package com.example.firebase.tabApiCall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebase.R
import com.example.firebase.api.ApiServices
import com.example.firebase.api.RestClient
import com.example.firebase.beans.Example
import kotlinx.android.synthetic.main.frag_adapter.*
import kotlinx.android.synthetic.main.frag_adapter.txtCompany
import kotlinx.android.synthetic.main.frag_adapter.txtText
import kotlinx.android.synthetic.main.frag_adapter.txtUrl
import kotlinx.android.synthetic.main.fragment_data_one.*
import kotlinx.android.synthetic.main.fragment_data_one.view.*
import retrofit2.Call
import retrofit2.Response


class DataOneFragment : Fragment() {
    val list = ArrayList<Example>()
    private var apiServices: ApiServices? = null
    private var madapter: FragAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_data_one, container, false)
        intiView(view)
        return view
    }

    private fun intiView(view: View) {
        apiServices = RestClient.clint.create(ApiServices::class.java)
        apiCalling()

    }

    private fun apiCalling() {
      /*  val call = apiServices!!.getUserData()
        call.enqueue(object : retrofit2.Callback<Example> {
            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                view!!.txtText.text = response.body()!!.ad.text
                view!!.txtUrl.text = response.body()!!.ad.text
                view!!.txtCompany.text = response.body()!!.ad.text
                view!!.txtId.text = response.body()!!.data[0].id.toString()
                view!!.txtEmail.text = response.body()!!.data[1].email.toString()
                view!!.txtFirstname.text = response.body()!!.data[2].firstName.toString()
                view!!.txtlastName.text = response.body()!!.data[3].lastName.toString()
                view!!.txtAvatar.text = response.body()!!.data[4].avatar.toString()

            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Toast.makeText(activity, "onFailure", Toast.LENGTH_SHORT).show()
            }
        })*/
    }
}