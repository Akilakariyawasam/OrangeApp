package com.akila.orangeapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;

import java.util.Date;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private NotificationManager mNM;
    private String message;
//    private NotificationHelpers notificationUtils;
    private String TAG="firebase_message";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"onMessageReceived:"+remoteMessage);

            message=remoteMessage.getNotification().getBody();

            Intent pushNotification = new Intent("Parameter.FCM_PUSH_NOTIFICATION");
            pushNotification.putExtra("fcmData", message);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);


    }
    private void handleNotification(String message) {
        Log.d(TAG,"Normal message"+message);
//        if (!NotificationHelpers.isAppIsInBackground(getApplicationContext())) {
            // app is in foreground, broadcast the push message
            Intent pushNotification = new Intent("Parameter.FCM_PUSH_NOTIFICATION");
            pushNotification.putExtra("fcmData", message);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);

            // play notification sound
//            NotificationHelpers notificationUtils = new NotificationHelpers(getApplicationContext());
//            notificationUtils.playNotificationSound();
//        }else{
            // If the app is in background, firebase itself handles the notification
//        }
    }



}
