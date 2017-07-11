package com.zs.kotlin.mykotlin.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.zs.kotlin.mykotlin.R
import kotlinx.android.synthetic.main.activity_kotlin.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/**
 *
Created by zs
Date：2017年 07月 05日
Time：15:27
—————————————————————————————————————
About: 登录页面demo
—————————————————————————————————————
 */
class LoginActivity : AppCompatActivity() {

//    private var mPhone: EditText? = null
//    private var mPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

//        et_phone = findViewById(R.id.et_phone) as EditText
//        et_password = findViewById(R.id.et_password) as EditText

    }

    fun btnLogin(view: View){

        doAsync{
            var result = ""
            uiThread {
                toast(result)
            }
        }

        var phone: String = et_phone?.text.toString().trim()
        var password: String = et_password?.text.toString().trim()

        if (TextUtils.isEmpty(phone)){

            Toast.makeText(LoginActivity@this,"手机号不能为空", Toast.LENGTH_SHORT).show()

        } else if (TextUtils.isEmpty(password)){

            Toast.makeText(this,"密码不能为空", Toast.LENGTH_SHORT).show()

        } else{
            var intent = Intent()
            intent.setClass(LoginActivity@this, GrammarActivity::class.java)
            startActivity(intent)
        }

    }


}
