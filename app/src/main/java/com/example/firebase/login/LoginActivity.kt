package com.example.firebase.login

import android.content.Intent
import android.os.Bundle
import android.se.omapi.Session
import android.telephony.AccessNetworkConstants
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase.MainActivity
import com.example.firebase.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import java.nio.file.AccessMode

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private var mAuth: FirebaseAuth? = null
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        img_facebook.setOnClickListener(this)
        img_google.setOnClickListener(this)
        img_twitter.setOnClickListener(this)
        intiView()

    }

    override fun onStart() {
        super.onStart()
        /* val currentUser = mAuth!!.currentUser
         updateUI(currentUser)*/
    }

    private fun intiView() {
        // val callbackManager = CallbackManager.Factory.create()
        
        auth = Firebase.auth
        mAuth = FirebaseAuth.getInstance()
        btnLogin.setOnClickListener {
            mAuth!!.signInWithEmailAndPassword(
                etdEmail.text.toString(),
                etdPassword.text.toString()
            )
                .addOnCompleteListener(this@LoginActivity, object : OnCompleteListener<AuthResult> {
                    override fun onComplete(@NonNull task: Task<AuthResult>) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success")
                            /* val user = mAuth.getCurrentUser()
                             updateUI(user)*/
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException())
                            Toast.makeText(
                                this@LoginActivity, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                            //updateUI(null)
                        }
                        // ...
                    }
                })
        }
    }
   /* private fun handleFacebookAccessToken(token: A) {
        Log.d("TAG", "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
//                    val user = auth.currentUser
//                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                   // updateUI(null)
                }

                // ...
            }
    }*/

    override fun onClick(v: View?) {
        when (v!!.id) {
            /*R.id.img_facebook -> {
                val credential = FacebookAuthProvider.getCredential()
                mAuth!!.signInWithCredential(credential)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            *//* Log.d(TAG, "signInWithCredential:success")
                             val user = auth.currentUser
                             updateUI(user)*//*
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                            // updateUI(null)
                        }

                        // ...
                    }

            }*/
            R.id.img_google -> {

            }
            R.id.img_twitter -> {

            }
        }
    }
}