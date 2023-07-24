package com.persona.persona.Activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.LogoutResponseCallback
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.util.OptionalBoolean
import com.kakao.util.exception.KakaoException
import com.persona.persona.R


class LoginActivity : AppCompatActivity() {
    private val callback = SessionCallback()
    private lateinit var firebaseAuth : FirebaseAuth
    private val loginButton : Button by lazy{
        findViewById(R.id.loginBUtton)
    }
    private val makeAccount : Button by lazy{
        findViewById(R.id.makeAccount)
    }
    private val kakaoLoginButton : com.kakao.usermgmt.LoginButton by lazy{
        findViewById(R.id.kakao_login_button)
    }

    private val emailEditText : EditText by lazy{
        findViewById(R.id.emailEditText)
    }
    private val passwordEditText : EditText by lazy{
        findViewById(R.id.passwordEditText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = Firebase.auth
        initLoginButton()   //firebase 로그인 버튼 init
        initMakeAccountButton()     //firevase 회원가입 버튼 init
        initKakaoLoginButton()      //카카오 간편로그인 버튼 init
        Session.getCurrentSession().checkAndImplicitOpen()      //카카오 로그인 세션이 남아있다면 자동로그인
    }
    inner class SessionCallback : ISessionCallback {
        override fun onSessionOpened() {
            requestMe()
        }

        // 로그인에 실패한 상태
        override fun onSessionOpenFailed(exception: KakaoException) {
            Log.e("SessionCallback :: ", "onSessionOpenFailed : " + exception.message)
        }

        // 사용자 정보 요청
        fun requestMe() {
            UserManagement.getInstance().me(object : MeV2ResponseCallback() {
                    override fun onSessionClosed(errorResult: ErrorResult) {
                        Log.e("KAKAO_API", "세션이 닫혀 있음: $errorResult")
                    }

                    override fun onFailure(errorResult: ErrorResult) {
                        Log.e("KAKAO_API", "사용자 정보 요청 실패: $errorResult")
                    }

                    override fun onSuccess(result: MeV2Response) {
                        val intent : Intent = Intent(this@LoginActivity, MenuActivity::class.java)
                        Log.i("KAKAO_API", "사용자 아이디: " + result.id)
                        val kakaoAccount = result.kakaoAccount
                        if (kakaoAccount != null) {
                            // 이메일
                            val email = kakaoAccount.email
                            if (email != null) {
                                Log.i("KAKAO_API", "email: $email")
                                intent.putExtra("email",email) // 카카오에서 받아온 email정보를 menuActivity로 전달

                            } else if (kakaoAccount.emailNeedsAgreement() == OptionalBoolean.TRUE) {
                                // 동의 요청 후 이메일 획득 가능
                                // 단, 선택 동의로 설정되어 있다면 서비스 이용 시나리오 상에서 반드시 필요한 경우에만 요청해야 합니다.
                            } else {
                                // 이메일 획득 불가
                            }
                            // 프로필
                            val profile = kakaoAccount.profile
                            if (profile != null) {
                                Log.d("KAKAO_API", "nickname: " + profile.nickname)
                                intent.putExtra("nickname",profile.nickname);
                                Log.d("KAKAO_API", "profile image: " + profile.profileImageUrl)
                                intent.putExtra("profileImageURL",profile.profileImageUrl)
                            } else if (kakaoAccount.profileNeedsAgreement() == OptionalBoolean.TRUE) {
                                // 동의 요청 후 프로필 정보 획득 가능
                            } else {
                                // 프로필 획득 불가
                            }
                        }
                        startActivity(intent)   //로그인 성공 후 필요한 정보들을 다음 Activity로 전달 후 Activity 전환
                        finish()
                    }
                })
        }
    }

    private fun initKakaoLoginButton() {
        kakaoLoginButton.setOnClickListener{
            Session.getCurrentSession().addCallback(callback)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // 세션 콜백 삭제
        Session.getCurrentSession().removeCallback(callback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int,  data: Intent?) {
        // 카카오톡|스토리 간편로그인 실행 결과를 받아서 SDK로 전달
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


    private fun moveMainPage(user: FirebaseUser?){
        if( user!= null){
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
    }
    private fun initMakeAccountButton() {
        makeAccount.setOnClickListener{
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }

    private fun initLoginButton() {
        loginButton.setOnClickListener{
            signIn(getInputID(),getInputPassword())
        }
    }



    private fun signIn(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext, "로그인에 성공 하였습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                        moveMainPage(firebaseAuth.currentUser)
                    } else {
                        Toast.makeText(
                            baseContext, "로그인에 실패 하였습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
        private fun getInputID() : String{
            return emailEditText.text.toString()
        }
        private fun getInputPassword() : String{
            return passwordEditText.text.toString()
        }
}