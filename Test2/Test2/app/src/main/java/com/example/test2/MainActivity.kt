package com.example.test2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.test2.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        edit()
        login()
    }

    fun edit() {
        binding.apply {
            loginEmail.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                        loginErrorText.text = "이메일 형식으로 입력해주세요"
                        loginErrorText.setTextColor(Color.RED)
                        loginEmail.setBackgroundResource(R.drawable.blue_edittext)
                    } else if (loginPasswd.length() == 0) {
                        loginErrorText.text = "비밀번호를 입력해주세요"
                        loginEmail.setBackgroundResource(R.drawable.white_edittext)
                        loginPasswd.setBackgroundResource(R.drawable.blue_edittext)
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                    if (loginEmail.length() > 0 && loginPasswd.length() > 0) {
                        loginButton.isClickable = true
                        loginButton.setBackgroundResource(R.color.sky)
                    } else {
                        loginButton.isClickable = false
                        loginButton.setBackgroundResource(R.color.grayW)
                    }

                }

            })
            loginPasswd.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches() || loginPasswd.length() == 0) {
                        loginErrorText.text = "비밀번호를 입력해주세요"
                        loginErrorText.setTextColor(Color.RED)
                        loginPasswd.setBackgroundResource(R.drawable.blue_edittext)
                    } else {
                        loginErrorText.text = ""
                        loginErrorText.setTextColor(Color.GRAY)
                        loginPasswd.setBackgroundResource(R.drawable.white_edittext)
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                    if(loginPasswd.length() > 0 && loginEmail.length() > 0) {
                        loginButton.isClickable = true
                        loginButton.setBackgroundResource(R.color.sky)
                    } else {
                        loginButton.isClickable = false
                        loginButton.setBackgroundResource(R.color.grayW)
                    }
                }

            })
        }
    }

    fun login() {
        val intent = Intent(this, HomeActivity::class.java)

        binding.apply {
            loginButton.setOnClickListener {
                val formBody = FormBody.Builder()
                    .add("member_email", "${loginEmail.text}")
                    .add("member_passwd","${loginPasswd.text}").build()

                val request = Request.Builder().url("http://172.30.1.31:8080/hyper/member").post(formBody).build()
                val okHttpClient = OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS)

                okHttpClient.build().newCall(request).enqueue(object : Callback {
                    override fun onFailure(call: okhttp3.Call, e: IOException) {
                        Log.e("실패","+ 실패")
                    }

                    override fun onResponse(call: okhttp3.Call, response: Response) {
                        var rs = response.body?.string()

                        if (rs == "로그인성공") {
                            startActivity(intent)
                            loginEmail.text = null
                            loginPasswd.text = null
                        } else if (rs == "아이디가 존재하지 않습니다.") {
                            loginErrorText.text = "아이디가 존재하지 않습니다."
                            loginErrorText.setTextColor(Color.RED)
                        } else if (rs == "비밀번호가 일치하지 않습니다.") {
                            loginErrorText.text = "비밀번호가 일치하지 않습니다."
                            loginErrorText.setTextColor(Color.RED)
                        }
                    }
                })
            }
        }
    }
}