package com.persona.persona.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.persona.persona.R
import kotlin.math.sign

class SignupActivity : AppCompatActivity() {
    private val signupEmail : EditText by lazy{
        findViewById(R.id.signupID)
    }
    private val signupPassword : EditText by lazy{
        findViewById(R.id.signupPassword)
    }
    private val makeAccountButton : Button by lazy{
        findViewById(R.id.makeAccount)
    }
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = Firebase.auth
        // 계정 생성 버튼
        makeAccountButton.setOnClickListener {
            createAccount(signupEmail.text.toString(),signupPassword.text.toString())
        }
    }
    // 계정 생성
    private fun createAccount(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "계정 생성 완료.",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish() // 가입창 종료
                    } else {
                        Toast.makeText(
                            this, "계정 생성 실패",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}