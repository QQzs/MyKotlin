package com.zs.kotlin.mykotlin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.zs.kotlin.mykotlin.R;

/**
 * Created by zs
 * Date：2017年 07月 11日
 * Time：13:13
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */

public class TestActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RelativeLayout mTitleLayout;
    private int mTitleHeight;
    private int mCurrentPosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mTitleHeight = mTitleLayout.getHeight();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //找到列表第二个可见的View
                View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                if (view == null) return;
                //判断View的top值是否小于悬浮条的高度
                if (view.getTop() <= mTitleHeight) {
                    //被顶掉的效果
                    mTitleLayout.setY(-(mTitleHeight - view.getTop()));
                } else {
                    mTitleLayout.setY(0);
                }

                //判断是否需要更新悬浮条
                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    mTitleLayout.setY(0);
                }
            }
        });
    }
}
