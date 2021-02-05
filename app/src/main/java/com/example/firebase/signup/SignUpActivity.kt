package com.example.firebase.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase.R
import com.example.firebase.login.LoginActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        intiView()
    }

    private fun intiView() {
        mAuth= FirebaseAuth.getInstance()
        btnSignup.setOnClickListener {
            mAuth!!.createUserWithEmailAndPassword(etdEmail.text.toString(), etdPassword.text.toString())
                .addOnCompleteListener(this@SignUpActivity, object: OnCompleteListener<AuthResult> {
                    override fun onComplete(@NonNull task: Task<AuthResult>) {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success")
                            val intent=Intent(this@SignUpActivity,LoginActivity::class.java)
                            startActivity(intent)
                            /*val user = mAuth.getCurrentUser()
                            updateUI(user)*/
                        }
                        else
                        {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException())
                            Toast.makeText(this@SignUpActivity, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                                //updateUI(null)
                        }
                        // ...
                    }
                })
        }
    }
}