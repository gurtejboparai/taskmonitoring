package com.example.myapplication.objects;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.myapplication.R;

public class Channel extends ContextWrapper {
    public static String CHANNEL_ID = "task monitor notification";
    public Channel(Context base) {
        super(base);
        createChannel();
    }

    private void createChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"Task Monitor", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Task monitor channel for alarm");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }


}
