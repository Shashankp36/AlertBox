package com.example.alertbox

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.getSystemService

class MainActivity2 : AppCompatActivity() {
    lateinit var alarmManager:AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var start = findViewById<Button>(R.id.button)
        var clear = findViewById<Button>(R.id.button2)
        var repeat = findViewById<Button>(R.id.button3)
        val et=findViewById<EditText>(R.id.editTextTextPersonName)
        val i = Intent(this,MyBroadcast::class.java)
        val pi=PendingIntent.getBroadcast(this,0,i,0)
        start.setOnClickListener{
            val e=et.text.toString().toInt()
            alarmManager=getSystemService(Context.ALARM_SERVICE)as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(e*1000),pi)
            Toast.makeText(this,"Alarm is set",Toast.LENGTH_LONG).show()
        }
        repeat.setOnClickListener{
            val e=et.text.toString().toInt()
            alarmManager=getSystemService(Context.ALARM_SERVICE)as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(e*1000),5000,pi)
            Toast.makeText(this," Repeat Alarm is set",Toast.LENGTH_LONG).show()
        }
        clear.setOnClickListener{
            alarmManager=getSystemService(Context.ALARM_SERVICE)as AlarmManager
            alarmManager.cancel(pi)
            Toast.makeText(this,"alarm is cancelled",Toast.LENGTH_LONG).show()
        }
    }
}