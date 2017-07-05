package com.zs.kotlin.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.bean.User
import java.util.*

/**
 * Created by zs
 * Date：2017年 07月 04日
 * Time：17:29
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */

 class TestKotlinAdapter(private val mData: ArrayList<User>) : RecyclerView.Adapter<TestKotlinAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, null)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val user = mData[position]
        holder.tvName.text = user.name
        holder.tvAge.text = user.age!!.toString() + ""

    }

    override fun getItemCount(): Int {
        return mData.size
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
