package com.sathruwan.notes.services


import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.sathruwan.notes.receiver.AlarmBroadcastReceiver
import com.sathruwan.notes.utils.Constants


fun scheduleEvent( context: Context?, title:String="", description: String="",getInMilliSecond:Long=0,requestCode: Int = 0) {

    val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val broadcastIntent = Intent(context, AlarmBroadcastReceiver::class.java)
    broadcastIntent.action = Constants.ALARM_ACTIONS
    broadcastIntent.apply{
        putExtra("IntentId", requestCode)
        putExtra("Title", title)
        putExtra("Description", description)
    }
    val broadcastPendingIntent = PendingIntent.getBroadcast(
        context,
        requestCode,
        broadcastIntent,
        0
    )
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, getInMilliSecond,broadcastPendingIntent)
    } else {
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, getInMilliSecond,broadcastPendingIntent)
    }
}
fun cancelAlarm(context: Context?,requestCode: Int){
    val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val broadcastIntent = Intent(context, AlarmBroadcastReceiver::class.java)
    broadcastIntent.action = Constants.ALARM_ACTIONS
    broadcastIntent.apply{
        putExtra("IntentId", requestCode)
        putExtra("Title", "title")
        putExtra("Description", "description")
    }
    val broadcastPendingIntent = PendingIntent.getBroadcast(
        context,
        requestCode,
        broadcastIntent,
        PendingIntent.FLAG_NO_CREATE
    )
    alarmManager.cancel(broadcastPendingIntent)
}
