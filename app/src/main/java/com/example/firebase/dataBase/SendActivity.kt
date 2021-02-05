package com.example.firebase.dataBase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebase.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_send.*

class SendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        intiView()
    }

    private fun intiView() {
        val dataBase = FirebaseDatabase.getInstance().getReference("Detail")
        btnSubmit.setOnClickListener {
            val details = dataBase.push().key
            val detailsUser = DetailsData(
                email = etdEmail.text.toString().trim(),
                phone = etdPhone.text.toString().trim(),
                name = etdName.text.toString().trim()
            )
            dataBase.child(details!!).setValue(detailsUser).addOnCompleteListener {
                Toast.makeText(this, "send Done", Toast.LENGTH_SHORT).show()
                etdEmail.text.clear()
                etdPhone.setText("")
                etdName.text.clear()
            }

        }
    }

}