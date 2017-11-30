package com.zs.kotlin.mykotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.adapter.MyAdapter
import com.zs.kotlin.mykotlin.bean.Book
import kotlinx.android.synthetic.main.activity_evaluate.*
import kotlinx.android.synthetic.main.recycler_head_view.view.*

/**
 * 评价星星
 */

class EvaluateActivity : AppCompatActivity(){

//    private var mTvEvaluate: TextView ? = null
//    private var mStarBarView: StarBarView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluate)
        var headView = LayoutInflater.from(this).inflate(R.layout.recycler_head_view,null)
        headView.tv_header_title?.text = "测试显示问题"
        headView.tv_eva_head?.text = "aaaaaaaa"
        var mData = ArrayList<Book>()
        for(i in 1..15){
            var book = Book(1)
            mData.add(book)
        }
        recycler_view_evaluate?.layoutManager = LinearLayoutManager(this)
        recycler_view_evaluate?.addHeaderView(headView)
        recycler_view_evaluate?.adapter = MyAdapter(mData)
        recycler_view_evaluate?.setPullRefreshEnabled(false)

//        mTvEvaluate = headView.findViewById(R.id.tv_eva_head) as TextView
//        mStarBarView = headView.findViewById(R.id.star_eva_head) as StarBarView

//        mStarBarView?.starMark = 3.3f
//        mStarBarView?.setOnStarChangeListener { mark -> mTvEvaluate?.text = "评分：" + mark }

    }

}
