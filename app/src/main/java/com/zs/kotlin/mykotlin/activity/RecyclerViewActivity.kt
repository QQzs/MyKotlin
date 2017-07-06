package com.zs.kotlin.mykotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.adapter.MyAdapter
import com.zs.kotlin.mykotlin.bean.User


/**
 *
Created by zs
Date：2017年 07月 05日
Time：15:27
—————————————————————————————————————
About:RecyclerView
—————————————————————————————————————
 */
class RecyclerViewActivity : AppCompatActivity(){

    var mRecyclerView: RecyclerView? = null
    var mData: ArrayList<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        mRecyclerView = findViewById(R.id.recycler_view) as RecyclerView
        mData = ArrayList<User>()
        for (i in 1..16){
            var user = User("data")
            mData!!.add(user)
        }
        mRecyclerView?.layoutManager = LinearLayoutManager(this)
        mRecyclerView?.adapter = MyAdapter(mData as ArrayList<User>)

    }

}
