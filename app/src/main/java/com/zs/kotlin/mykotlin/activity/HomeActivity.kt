package com.zs.kotlin.mykotlin.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.adapter.ActivityAdapter
import com.zs.kotlin.mykotlin.listener.KotlinItemClickListener

class HomeActivity : AppCompatActivity() , KotlinItemClickListener {

    var mRecyclerView: RecyclerView? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mRecyclerView = findViewById(R.id.recycler_view_home) as RecyclerView

        var mActivityList = ArrayList<Class<*>>()
        mActivityList.add(GrammarActivity::class.java)
        mActivityList.add(LoginActivity::class.java)
        mActivityList.add(RecyclerViewActivity::class.java)

        mRecyclerView?.layoutManager = LinearLayoutManager(this)
        mRecyclerView?.adapter = ActivityAdapter(mActivityList,this)

    }

    override fun onItemClick(viewHolder: RecyclerView.ViewHolder, data: Any) {
        startActivity(Intent(this,data as Class<*>))
    }


}
