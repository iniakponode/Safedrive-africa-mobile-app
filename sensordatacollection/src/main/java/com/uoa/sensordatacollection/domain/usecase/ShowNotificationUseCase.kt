package com.uoa.sensordatacollection.domain.usecase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

class ShowNotificationUseCase {

    fun execute(message: String, context: Context) {
        // Use NotificationManager to show notifications
        // Example: Create a notification channel (for Android O and above)
        val channelId = "sensor_notification_channel"
        val channelName = "Sensor Notification Channel"
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description=message
            }
            notificationManager.createNotificationChannel(channel)
        }

//        Create the sensor Notification
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setContentTitle("Sensor Notification")
            .setContentText(message)
            .setSmallIcon(androidx.constraintlayout.widget.R.drawable.notify_panel_notification_icon_bg) // Fixed the syntax error here

        // Example: Show the notification
        notificationManager.notify(1, notificationBuilder.build())
    }

}