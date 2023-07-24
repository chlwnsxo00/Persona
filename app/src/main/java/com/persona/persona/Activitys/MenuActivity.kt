package com.persona.persona.Activitys

import AccountFragment
import com.persona.persona.Fragment.CastingFragment
import com.persona.persona.Fragment.CommunityFragment
import com.persona.persona.Fragment.InformationFragment
import com.persona.persona.Fragment.LikeFragment
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.persona.persona.R

class MenuActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var bottomNavigationView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        //첫 프래그먼트 화면은 home fragment로
        bottomNavigationView.selectedItemId = R.id.information
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        when(p0.itemId){
            R.id.information ->{
                val fragmentHome = InformationFragment()
                transaction.replace(R.id.frameLayout,fragmentHome, "Home")
            }
            R.id.casting -> {
                val fragmentInformation = CastingFragment()
                transaction.replace(R.id.frameLayout,fragmentInformation, "Information")
            }
            R.id.like -> {
                val fragmentUpload = LikeFragment()
                transaction.replace(R.id.frameLayout,fragmentUpload, "Upload")
            }
            R.id.community -> {
                val fragmentPopular = CommunityFragment()
                transaction.replace(R.id.frameLayout,fragmentPopular, "Popular")
            }
            R.id.account -> {
                val fragmentLogin = AccountFragment()
                transaction.replace(R.id.frameLayout, fragmentLogin, "Account")
            }
        }
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
        return true
    }
}