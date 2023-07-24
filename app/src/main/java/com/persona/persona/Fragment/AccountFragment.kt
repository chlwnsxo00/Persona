import android.R.attr.bitmap
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.LogoutResponseCallback
import com.persona.persona.Activitys.LoginActivity
import com.persona.persona.Activitys.MenuActivity
import com.persona.persona.R
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


/**
 * A simple [Fragment] subclass.
 */
class AccountFragment : Fragment() {
    private val menuActivity : MenuActivity by lazy {
        context as MenuActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(R.layout.fragment_account, container, false)
        val btnLogout : AppCompatButton = v.findViewById(R.id.btnLogout)
        val nicknameTextView : TextView = v.findViewById(R.id.nicknameTextView)
        val emailTextView : TextView = v.findViewById(R.id.emailTextView)
        val profileImageView : ImageView = v.findViewById(R.id.ivProfile)
        initLogoutButton(btnLogout)
        setProfileImageView(profileImageView)
        setNicknameTextView(nicknameTextView)
        setEmailTextView(emailTextView)
        return v
    }

    private fun setProfileImageView(profileImageView : ImageView) {
        Thread{
            Runnable {
                if(menuActivity.intent.hasExtra("profileImageURL")){
                    val url = URL(menuActivity.intent.getStringExtra("profileImageURL"))
                    // web에서 이미지를 가져와 ImageView에 저장할 Bitmap을 만든다.
                    val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
                    conn.doInput = true  // 서버로부터 응답 수신
                    conn.connect() //연결된 곳에 접속할 때 (connect() 호출해야 실제 통신 가능함)
                    val input = conn.inputStream //inputStream 값 가져오기
                    val bitmap = BitmapFactory.decodeStream(input)
                    profileImageView.setImageBitmap(bitmap)
                }
            }
        }.start()
    }

    private fun setEmailTextView(emailTextView: TextView) {
        if(menuActivity.intent.hasExtra("email")){
            emailTextView.text = "email : " + menuActivity.intent.getStringExtra("email")
        }
    }

    private fun setNicknameTextView(nicknameTextView: TextView) {
        if(menuActivity.intent.hasExtra("nickname")){
            nicknameTextView.text = "nickname : " + menuActivity.intent.getStringExtra("nickname")
        }
    }

    private fun initLogoutButton(btnLogout : AppCompatButton) {
        btnLogout.setOnClickListener{
            UserManagement.getInstance()
                .requestLogout(object : LogoutResponseCallback() {
                    override fun onCompleteLogout() {
                        Toast.makeText(menuActivity, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                    }
                })
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(menuActivity,LoginActivity::class.java))
        }
    }
}