package com.example.toha.mywearapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val msgStr = StringBuilder("Текущее время: ")
        val formatter = SimpleDateFormat("hh:mm:ss a")
        msgStr.append(formatter.format(Date()))
        Toast.makeText(context, msgStr, Toast.LENGTH_SHORT).show()
    }
}
