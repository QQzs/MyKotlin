package com.zs.kotlin.mykotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.TextView
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.adapter.MyAdapter
import com.zs.kotlin.mykotlin.bean.Book
import com.zs.kotlin.mykotlin.view.StarBarView
import kotlinx.android.synthetic.main.activity_evaluate.*

class EvaluateActivity : AppCompatActivity(){

    private var mTvEvaluate: TextView ? = null
    private var mStarBarView: StarBarView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluate)

        var mData = ArrayList<Book>()
        for(i in 1..15){
            var book = Book(1)
            mData.add(book)
        }
        recycler_view_evaluate?.layoutManager = LinearLayoutManager(this)
        recycler_view_evaluate?.adapter = MyAdapter(mData)
        recycler_view_evaluate?.setPullRefreshEnabled(false)
        var headView = LayoutInflater.from(this).inflate(R.layout.recycler_head_view,null)
        recycler_view_evaluate?.addHeaderView(headView)

        mTvEvaluate = headView.findViewById(R.id.tv_eva_head) as TextView
        mStarBarView = headView.findViewById(R.id.star_eva_head) as StarBarView

        mStarBarView?.starMark = 3.3f
        mStarBarView?.setOnStarChangeListener { mark -> mTvEvaluate?.text = "评分：" + mark }

    }

}
