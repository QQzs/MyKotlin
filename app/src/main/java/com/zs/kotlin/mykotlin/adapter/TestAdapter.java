package com.zs.kotlin.mykotlin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zs.kotlin.mykotlin.R;
import com.zs.kotlin.mykotlin.bean.User;

import java.util.ArrayList;

/**
 * Created by zs
 * Date：2017年 07月 04日
 * Time：17:29
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder>{

    private ArrayList<User> mData;

    public TestAdapter(ArrayList<User> mData) {
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        User user = mData.get(position);
        holder.tvName.setText(user.getName());
        holder.tvAge.setText(user.getAge() + "");

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvAge;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvAge = (TextView) itemView.findViewById(R.id.tv_item_age);

        }
    }

}
