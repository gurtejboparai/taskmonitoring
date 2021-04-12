package com.example.myapplication.objects;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.myapplication.R;

public class Channel extends ContextWrapper {
    private final static String CHANNEL_ID = "task monitor channel";
    public Channel(Context base) {
        super(base);
        createChannel();
    }

    private void createChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"Task Monitor", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Task monitor channel for alarm");

            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
    }

    public NotificationCompat.Builder getChannel(String Title, String Description){
        return new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setContentTitle(Title)
                .setContentText(Description)
                .setSmallIcon(R.drawable.programme)
                .setAutoCancel(true);

    }


}
