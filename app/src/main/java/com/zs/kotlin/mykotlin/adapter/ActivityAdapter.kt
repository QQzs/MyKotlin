package com.zs.kotlin.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.listener.KotlinItemClickListener

/**
 *
Created by zs
Date：2017年 07月 05日
Time：14:20
—————————————————————————————————————
About:
—————————————————————————————————————
 */
class ActivityAdapter(private val mData: ArrayList<Class<*>> , var mItemListener: KotlinItemClickListener) : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ActivityViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout,parent,false)
        return ActivityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ActivityViewHolder?, position: Int) {
        var item = mData.get(position)
        holder!!.mTvName.text = item.simpleName
        holder!!.mTv.visibility = View.GONE

        holder.itemView.setOnClickListener {
            mItemListener.onItemClick(holder,item)
//            holder.itemView.context.startActivity(Intent(holder.itemView.context,item))
        }
    }


    inner class ActivityViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var mTvName: TextView
        var mTv: TextView
        init {
            mTvName = itemView?.findViewById(R.id.tv_item_name) as TextView
            mTv = itemView?.findViewById(R.id.tv_item_age) as TextView
        }
    }

}