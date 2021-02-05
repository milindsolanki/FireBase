package com.example.firebase.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebase.R
import com.example.firebase.api.ApiServices
import com.example.firebase.api.RestClient
import com.example.firebase.beans.Data1
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private var apiServices: ApiServices? = null
    private var madapter: DataAdapter? = null
    val dataList = ArrayList<Data1>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        apiServices = RestClient.clint.create(ApiServices::class.java)
        intiView()
    }

    private fun intiView() {
        rvData.layoutManager = LinearLayoutManager(this)
        madapter = DataAdapter(this, dataList)
        rvData.adapter = madapter
        fetchDataList()
    }

    private fun fetchDataList() {
        val call = apiServices!!.getData()
        call.enqueue(object : retrofit2.Callback<List<Data1>> {
            override fun onResponse(call: Call<List<Data1>>, response: Response<List<Data1>>) {
                dataList.addAll(response.body()!!)
                madapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Data1>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}