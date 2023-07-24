package com.persona.persona.Fragment

import Items
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.persona.data.itemAdapter
import com.persona.persona.Activitys.MenuActivity
import com.persona.persona.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class InformationFragment : Fragment() {
    private val menuActivity: MenuActivity by lazy {
        context as MenuActivity
    }

    val scope = CoroutineScope(Dispatchers.Main)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_information, container, false)
        val refreshButton: AppCompatButton = v.findViewById(R.id.refreshButton)
        initRefreshButton(refreshButton, v)      //새로고침 버튼 init
        initItemlist()
        crawlingstart(v)    // 첫 화면을 크롤링한 화면으로 설정
        return v
    }

    private fun initItemlist() {
    }

    private fun initRefreshButton(refreshButton: AppCompatButton, v: View) {
        refreshButton.setOnClickListener {
            crawlingstart(v)
        }
    }


    private fun crawlingstart(v: View) {    //크롤링하는 함수
        Thread {
            (Runnable {       //네트워크 작업을 할때는 반드시 비동기로 해야함 (아니면 NetworkException 오류뜸)
                val itemList = ArrayList<Items>()
                val doc = Jsoup.connect("https://www.filmmakers.co.kr/actorsAudition").get()
                val elements: Elements = doc.select(".mobile-padding").select("#board-list")
                // mobile-padding 클래스의 board-list의 id를 가진 것들을 elements 객체에 저장
                /*
            크롤링 하는 법 : class 는 .(class) 로 찾고 id 는 #(id) 로 검색
             */
                for (elements in elements) {  //elements의 개수만큼 반복
                    val href = elements.select("a.block").attr("href")
                    val firstRow = elements.select(".block strong").text()
                    val time = elements.select("span.content.date").text()
                    val secondRow = elements.select("td.mobile-nobold").text()
                    itemList.add(Items(firstRow, time, secondRow, href))
                }

                menuActivity.runOnUiThread(kotlinx.coroutines.Runnable {
                    v.findViewById<RecyclerView>(R.id.rv_item).layoutManager =
                        LinearLayoutManager(menuActivity, LinearLayoutManager.VERTICAL, false)
                    v.findViewById<RecyclerView>(R.id.rv_item).adapter = itemAdapter(itemList)
                })
            })
        }.run()
    }
}