package com.example.firebase.recyclerView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.firebase.BaseActivity
import com.example.firebase.R
import com.example.firebase.viewHolder.ViewHolder
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_retrive_data.*
import kotlinx.android.synthetic.main.adapter_data.view.*
import kotlinx.android.synthetic.main.item_retrive_adapter.view.*
import kotlinx.android.synthetic.main.item_retrive_adapter.view.image
import kotlinx.android.synthetic.main.item_retrive_adapter.view.txtName

class RetriveDataActivity : BaseActivity() {
    var ref: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrive_data)
        intiView()
    }

    private fun intiView() {
        ref = FirebaseDatabase.getInstance().getReference("photoghrafy")
        recyclerView.layoutManager = LinearLayoutManager(this)
        val recyclerviewAdapter = object : FirebaseRecyclerAdapter<RetriveData, ViewHolder>(
            RetriveData::class.java,
            R.layout.item_retrive_adapter,
            ViewHolder::class.java,
            ref
        ) {
            override fun populateViewHolder(p0: ViewHolder?, p1: RetriveData?, p2: Int) {

                p0!!.view.txtName.setText(p1!!.name)

                Glide.with(this@RetriveDataActivity).load(p1.image).into(p0.view.image)

                p0.view.imgImage.setOnClickListener {
                    //Toast.makeText(this@RetriveDataActivity, "done", Toast.LENGTH_SHORT).show()
                     askPermissions()
                }
            }
        }
        recyclerView.adapter = recyclerviewAdapter
    }
}