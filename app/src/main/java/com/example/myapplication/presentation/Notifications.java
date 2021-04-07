package com.example.myapplication.presentation;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;


public class Notifications {
    private Context currContext;
    public Notifications(Context currContext){
        this.currContext = currContext;
    }

    public Context getCurrContext(){
        return this.currContext;
    }

    //build a notification channel for the application
    //At this stage we only need one
    static public void createChannel(Context currContext){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "tasks notifications";
            String description = "tasks that have yet to be completed";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(NotificationChannel.DEFAULT_CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = currContext.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
