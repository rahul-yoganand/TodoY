package com.example.todoy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class RecyclerAdapter(var data: List<Task>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.singlecard,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       if(data!=null) {holder.tvRecy.text= data[position].toString()}
    }

    override fun getItemCount(): Int {
        return data.size
    }
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tvRecy: TextView = itemView.findViewById(R.id.card)
    }
}