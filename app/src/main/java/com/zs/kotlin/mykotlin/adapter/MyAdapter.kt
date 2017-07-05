package com.zs.kotlin.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.bean.User

/**
 *
Created by zs
Date：2017年 07月 04日
Time：17:16
—————————————————————————————————————
About:
—————————————————————————————————————
 */
class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    var mData: ArrayList<User>? = null

    constructor(data: ArrayList<User>){
        this.mData = data
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        var user = mData!!.get(position)
        holder!!.tvName.text = user.name
        holder!!.tvAge.text = user.age!!.toString()

    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName: TextView
        val tvAge: TextView

        init {
            tvName = itemView.findViewById(R.id.tv_item_name) as TextView
            tvAge = itemView.findViewById(R.id.tv_item_age) as TextView
        }

    }

}
