package com.example.firebase

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager

object Comman {


   fun isconnected(context:Context): Boolean {
     var isconnected=false
      val conn:ConnectivityManager= context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
       if(conn.activeNetworkInfo !=null)
       {
           isconnected= conn.activeNetworkInfo!!.isConnected
       }

       if (!isconnected) {

           showDailog(context)
       }
   return isconnected
  }

    private fun showDailog(context:Context) {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("MY App")
        dialog.setMessage("No inteRnert Connect")
        dialog.setPositiveButton("OK")
        {dialog,_->
            dialog.dismiss()
        }
        dialog.show()
    }
}