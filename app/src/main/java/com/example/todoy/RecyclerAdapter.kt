package com.example.todoy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.lang.Thread.sleep

class   RecyclerAdapter(var data: List<Task>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.singlecard,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvtask.text= data[position].toString()
        holder.cbDel.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
               var delTask=DeleteLastTask(maintaskDao,data[position])
                delTask.execute()
                var listData =FetchData(maintaskDao, recyclerView)
                listData.execute()
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tvtask: TextView = itemView.findViewById(R.id.card)
        var cbDel:CheckBox=itemView.findViewById(R.id.del_task)
    }
}