package com.example.myapplication.business.UILogic;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myapplication.R;
import com.example.myapplication.objects.Channel;

import java.util.Date;
import java.util.Random;

public class NotificationTask extends BroadcastReceiver {

    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION = "notification";
    private Channel channel;

    public void onReceive(Context context, Intent intent) {
        channel = new Channel(context);
        NotificationCompat.Builder aChannel = new NotificationCompat.Builder(channel.getApplicationContext(), Channel.CHANNEL_ID)
                .setContentTitle(intent.getStringExtra(NOTIFICATION_ID))
                .setContentText(intent.getStringExtra(NOTIFICATION))
                .setSmallIcon(R.drawable.programme)
                .setAutoCancel(true);
        int r = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);//go by current day
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(r, aChannel.build());
    }

}
