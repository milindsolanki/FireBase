package com.example.firebase.tabApiCall

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.R
import com.example.firebase.beans.Example
import com.example.firebase.viewHolder.ViewHolder
import kotlinx.android.synthetic.main.adapter_data.view.*
import kotlinx.android.synthetic.main.frag_adapter.view.*

class FragAdapter(val context: Context?, var list: ArrayList<Example>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.frag_adapter,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        /* val add = list[position].ad
         val data = list[position].*/
        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
        holder.itemView.txtId.text = list[position].id.toString()
       // holder.itemView.txtName.text = list[position].company.name
        holder.itemView.txtUrl.text = list[position].website.toString()
        holder.itemView.txtEmail.text = list[position].email.toString()
        holder.itemView.txtAvatar.text = list[position].address.toString()
        holder.itemView.txtFirstname.text = list[position].address.city.toString()

    }

    override fun getItemCount(): Int = list.size
}