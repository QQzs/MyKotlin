package com.zs.kotlin.mykotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.adapter.MyAdapter
import com.zs.kotlin.mykotlin.bean.Book


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
    var mData = arrayListOf<Book>()
    var mTitleHeight = 0
    var mCurrentPosition = 0
    var mLayoutTitle: RelativeLayout? = null
    var mTvTitle: TextView? = null
    var mTvFloat: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        mRecyclerView = findViewById(R.id.recycler_view)

        for ( i in 1..20){
            mData.add(Book(i%3))
        }
        val linearLayoutManager = LinearLayoutManager(this)
        mRecyclerView?.layoutManager = linearLayoutManager
        mRecyclerView?.adapter = MyAdapter(mData)

        mLayoutTitle = findViewById(R.id.rl_item)
        mLayoutTitle?.visibility = View.VISIBLE
        mTvTitle = findViewById(R.id.tv_item_type)
        mTvTitle?.text = "类型：" + mData[mCurrentPosition].type

        mTvFloat = findViewById(R.id.tv_float_view)
        mTvFloat?.text = "0"

        mRecyclerView?.addOnScrollListener(object: RecyclerView.OnScrollListener(){

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                mTitleHeight = mLayoutTitle!!.height
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                //找到列表下一个可见的View
                var view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1) ?: return
                if (view.top <= mTitleHeight && view.findViewById<RelativeLayout>(R.id.rl_item).visibility == View.VISIBLE){
                    //被顶掉的效果
                    mLayoutTitle?.y = (-(mTitleHeight -view.top)).toFloat()
                }else{
                    mLayoutTitle?.y = 0f
                }
                //判断是否需要更新悬浮条
                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()){
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition()
                    mLayoutTitle?.y = 0f
                    mTvTitle?.text = "类型：" + mData!!.get(mCurrentPosition).type


                    mTvFloat?.text = mCurrentPosition.toString()

                }
            }
        })
    }

}
