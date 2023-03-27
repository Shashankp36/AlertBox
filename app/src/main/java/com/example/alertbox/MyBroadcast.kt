package com.example.alertbox
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast


    class MyBroadcast: BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            var mp = MediaPlayer.create(p0, R.raw.alarm)

            Log.d("Hello","repeating alarm")
            mp.start()
            Toast.makeText(p0,"Alarm is Ringing", Toast.LENGTH_LONG).show()
        }
    }