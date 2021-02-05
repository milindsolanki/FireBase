package com.example.firebase

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open class BaseFragment : Fragment() {

       var progressDialog:ProgressDialog? = null

       override fun onCreateView(
           inflater: LayoutInflater, container: ViewGroup?,
           savedInstanceState: Bundle?
       ): View? {
           // Inflate the layout for this fragment
           return inflater.inflate(R.layout.fragment_base, container, false)
       }

       fun showProgressDialog(){
//           if(progressDialog!=null && progressDialog!!.isShowing){
//               return
//           }
           progressDialog=ProgressDialog(activity)
           progressDialog!!.setTitle("APICALLING")
           progressDialog!!.setMessage("LODING.................")
           progressDialog!!.show()

   }
    fun hideProgressDialog()
    {

        if(progressDialog!=null)
        {
            progressDialog!!.dismiss()
        }
    }
}