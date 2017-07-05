package com.zs.kotlin.mykotlin.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.zs.kotlin.mykotlin.R

class LoginActivity : AppCompatActivity() {

    private var mPhone: EditText? = null
    private var mPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        mPhone = findViewById(R.id.et_phone) as EditText
        mPassword = findViewById(R.id.et_password) as EditText

    }

    fun btnLogin(view: View){

        var phone: String = mPhone?.text.toString().trim()
        var password: String = mPassword?.text.toString().trim()

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
