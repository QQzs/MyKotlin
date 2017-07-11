package com.zs.kotlin.mykotlin.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.RelativeLayout
import com.zs.kotlin.mykotlin.R

/**
 * Created by zs
 * Date：2017年 07月 11日
 * Time：13:13
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */

class TestKotlinActivity : Activity() {

    private val mRecyclerView: RecyclerView? = null
    private val mTitleLayout: RelativeLayout? = null
    private var mTitleHeight: Int = 0
    private var mCurrentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val linearLayoutManager = LinearLayoutManager(this)

        mRecyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                mTitleHeight = mTitleLayout!!.height
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                //找到列表下一个可见的View
                val view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1) ?: return
                //判断View的top值是否小于悬浮条的高度
                if (view.top <= mTitleHeight) {
                    //被顶掉的效果
                    mTitleLayout!!.y = (-(mTitleHeight - view.top)).toFloat()
                } else {
                    mTitleLayout!!.y = 0f
                }

                //判断是否需要更新悬浮条
                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition()
                    mTitleLayout.y = 0f
                }
            }
        })
    }
}
