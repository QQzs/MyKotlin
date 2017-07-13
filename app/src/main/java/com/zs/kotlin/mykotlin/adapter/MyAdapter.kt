package com.zs.kotlin.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.bean.Book

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

    var mData: ArrayList<Book>? = null

    constructor(data: ArrayList<Book>) {
        this.mData = data
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return mData!!.get(position).type
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyAdapter.MyViewHolder {
        var view: View
        when (viewType) {
            0 -> {
                view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
                return MyViewHolder0(view)
            }
            1 -> {
                view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout1, parent, false)
                return MyViewHolder1(view)
            }
            2 -> {
                view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout2, parent, false)
                return MyViewHolder2(view)
            }
            else -> {
                view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
                return MyViewHolder0(view)
            }
        }
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder?, position: Int) {
        var book = mData!!.get(position)
        if(position == 0){
            holder!!.layoutTitle.visibility = View.VISIBLE
            holder!!.tvType.text = "类型：" + book.type.toString()
        }else{
            if (mData!!.get(position - 1).type == book.type){
                holder!!.layoutTitle.visibility = View.GONE
            }else{
                holder!!.layoutTitle.visibility = View.VISIBLE
                holder!!.tvType.text = "类型：" + book.type.toString()
            }
        }
        when(getItemViewType(position)){
            0  -> {
                (holder as MyAdapter.MyViewHolder0).tvName.text = book.name
                holder.tvAge.text = book.content
            }
            1  -> {
                (holder as MyAdapter.MyViewHolder1).tvName.text = book.name
            }
            2  -> {
                (holder as MyAdapter.MyViewHolder2).tvName.text = book.name
                holder.tvAge.text = book.content
            }
            else  ->{

            }
        }

    }

    open inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvType: TextView
        val layoutTitle: View

        init {
            tvType = itemView.findViewById(R.id.tv_item_type) as TextView
            layoutTitle = itemView.findViewById(R.id.rl_item)
        }

    }

    inner class MyViewHolder0(itemView: View) : MyViewHolder(itemView) {

        val tvName: TextView
        val tvAge: TextView

        init {
            tvName = itemView.findViewById(R.id.tv_item_name) as TextView
            tvAge = itemView.findViewById(R.id.tv_item_age) as TextView
        }

    }

    inner class MyViewHolder1(itemView: View) : MyViewHolder(itemView) {

        val tvName: TextView
        val ivImage: ImageView

        init {
            tvName = itemView.findViewById(R.id.tv_item_name) as TextView
            ivImage = itemView.findViewById(R.id.iv_item) as ImageView
        }

    }

    inner class MyViewHolder2(itemView: View) : MyViewHolder(itemView) {

        val tvName: TextView
        val tvAge: TextView

        init {
            tvName = itemView.findViewById(R.id.tv_item_name) as TextView
            tvAge = itemView.findViewById(R.id.tv_item_age) as TextView
        }

    }

}
