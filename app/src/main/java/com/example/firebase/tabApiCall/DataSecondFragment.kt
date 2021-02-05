package com.example.firebase.tabApiCall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebase.BaseFragment
import com.example.firebase.Comman
import com.example.firebase.R
import com.example.firebase.api.ApiServices
import com.example.firebase.api.RestClient
import com.example.firebase.beans.Example
import kotlinx.android.synthetic.main.fragment_data_second.view.*
import retrofit2.Call
import retrofit2.Response

class DataSecondFragment : BaseFragment() {
    val list = ArrayList<Example>()
    private var apiServices: ApiServices? = null
    private var mAdapter: FragAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_data_second, container, false)
        intiView(view)
        return view
    }

    private fun intiView(view: View) {
        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        Comman.isconnected(activity!!)
        showProgressDialog()
        mAdapter = FragAdapter(activity, list)
        view.recyclerView.adapter = mAdapter
        apiServices = RestClient.clint.create(ApiServices::class.java)
        apiCalling()
    }

    private fun apiCalling() {

        val call = apiServices!!.getUserData()
        call.enqueue(object : retrofit2.Callback<List<Example>> {
            override fun onResponse(call: Call<List<Example>>, response: Response<List<Example>>) {
                hideProgressDialog()
                list!!.addAll(response.body()!!)
                mAdapter!!.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<Example>>, t: Throwable) {
                
            }
        })
    }


}