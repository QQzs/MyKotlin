package com.zs.kotlin.mykotlin.listener;

import android.support.v7.widget.RecyclerView;


public interface ItemClickListener {

    void onItemClick(RecyclerView.ViewHolder viewHolder, Object data);
}
