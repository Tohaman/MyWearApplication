package com.example.toha.mywearapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.content.Intent
import android.media.AudioManager
import android.content.Context.AUDIO_SERVICE
import android.content.Context.NOTIFICATION_SERVICE
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val n = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        if (n.isNotificationPolicyAccessGranted) {
//        } else {
//            // Ask the user to grant access
//            val intent = Intent(android.provider.Settings.ACTION_VOICE_CONTROL_DO_NOT_DISTURB_MODE)
//            startActivity(intent)
//        }

        //val intent = Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            if (NotificationManagerCompat.getEnabledListenerPackages(this).contains(packageName)) {        //ask for permission
                val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
                startActivity(intent)
            }
        }

        val title = "Мяу!"
        val text = "А кота кто кормить будет?"

        button.setOnClickListener {
            val notificationId = 1

            val notificationBuilder = NotificationCompat.Builder(this@MainActivity)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle(title)
                    .setContentText(text)

            val notificationManager = NotificationManagerCompat.from(this@MainActivity)

            notificationManager.notify(notificationId, notificationBuilder.build())
        }

        button2.setOnClickListener {

        }
    }
}
