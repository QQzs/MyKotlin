package com.zs.kotlin.mykotlin.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.adapter.ActivityAdapter
import com.zs.kotlin.mykotlin.bean.Live39Info
import com.zs.kotlin.mykotlin.listener.KotlinItemClickListener
import kotlinx.android.synthetic.main.activity_home.*

/**
 *
Created by zs
Date：2017年 07月 05日
Time：15:27
—————————————————————————————————————
About: 主页面
—————————————————————————————————————
 */
class HomeActivity : AppCompatActivity() , KotlinItemClickListener {

//    var mRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        mRecyclerView = findViewById(R.id.recycler_view_home) as RecyclerView

        var mActivityList = ArrayList<Class<*>>()
        mActivityList.add(GrammarActivity::class.java)
        mActivityList.add(LoginActivity::class.java)
        mActivityList.add(RecyclerViewActivity::class.java)
        mActivityList.add(EvaluateActivity::class.java)

        recycler_view_home?.layoutManager = LinearLayoutManager(this)
        recycler_view_home?.adapter = ActivityAdapter(mActivityList,this)

        var bean = Live39Info()
        var data = (bean.rolelist) as ArrayList<Live39Info.RoleList>
        data.add(Live39Info.RoleList("ds","12222"))
        Log.d("My_Log",data.toString())


    }

    override fun onItemClick(viewHolder: RecyclerView.ViewHolder, data: Any) {
        startActivity(Intent(this,data as Class<*>))
    }


}
