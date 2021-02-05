package com.example.firebase.pushNotyficstion

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.firebase.MainActivity
import com.example.firebase.R
import kotlinx.android.synthetic.main.activity_push_notification.*

class PushNotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_notification)
        intiView()
    }

    private fun intiView() {
        btnNotification.setOnClickListener {
            notification()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NOTIFICATION", "HELLO")
            val pIntent = PendingIntent.getActivity(this, 0, intent, 0)
            val builder =
                NotificationCompat.Builder(this, "hello").setSmallIcon(R.drawable.ic_google)
                    .setContentTitle("Notification").setContentText("Hello")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
            builder.setContentIntent(pIntent).setAutoCancel(true)
            //startActivity(intent)
            val getNotification =
                this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            with(getNotification) {
                notify(30, builder.build())
            }
        }

    }

    private fun notification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val chanalId = "hello"
            val anChanel =
                NotificationChannel(chanalId, "Milind", NotificationManager.IMPORTANCE_DEFAULT)
            anChanel.description = "Notification Example"


        }
    }

}