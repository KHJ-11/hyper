package com.example.test2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
                        loginErrorText.setText("이메일 형식으로 입력해주세요")
                        loginErrorText.setTextColor(Color.RED)
                        loginEmail.setBackgroundResource(R.drawable.red_edittext)
                    } else if (loginPasswd.length() == 0) {
                        loginErrorText.setText("비밀번호를 입력해주세요")
                        loginEmail.setBackgroundResource(R.drawable.white_edittext)
                        loginPasswd.setBackgroundResource(R.drawable.red_edittext)
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
                        loginErrorText.setText("비밀번호를 입력해주세요")
                        loginErrorText.setTextColor(Color.RED)
                        loginPasswd.setBackgroundResource(R.drawable.red_edittext)
                    } else {
                        loginErrorText.setText("")
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
                        Log.e("성공","${response.body?.string()}")
                    }

                })
            }
        }
    }
}