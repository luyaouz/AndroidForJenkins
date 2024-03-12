package com.example.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder

class MyService : Service() {

    private var notificationManager: NotificationManager? = null
    private val serviceManagerImpl: ServiceManagerImpl = ServiceManagerImpl(this)

    companion object {
        init {

        }

        val TAG : String = MyService::class.java.simpleName
        const val NOTIFICATION_CHANNEL_ID = "ABACUS_CHANNEL_ID"
        const val NOTIFICATION_CHANNEL_NAME = "Abacus Core Service Notification"
        const val SERVICE_NOTIFICATION_ID = 1


    }

    override fun onCreate() {
        super.onCreate()
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager?.createNotificationChannel(channel)
        //startForeground(SERVICE_NOTIFICATION_ID,)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    private val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            TODO("Not yet implemented")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }


    }
}

class ServiceManagerImpl(myService: MyService) {

}
