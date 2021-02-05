package com.example.firebase.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firebase.R
import com.example.firebase.beans.Data1
import com.example.firebase.viewHolder.ViewHolder
import kotlinx.android.synthetic.main.adapter_data.view.*

class DataAdapter(val context: Context, val data: ArrayList<Data1>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.adapter_data, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(context).load(data[position].imageurl).into(holder.itemView.image)
        holder.itemView.txtName.text = data[position].name
        holder.itemView.txtFirstappearance.text = data[position].firstappearance
        holder.itemView.txtRealname.text = data[position].realname
        holder.itemView.txtTeam.text = data[position].team

    }

    override fun getItemCount() = data.size

}