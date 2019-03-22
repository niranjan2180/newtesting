package com.eisedo.eisedo.broadcast_receiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.eisedo.eisedo.R;

import java.util.Date;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Received at " + new Date(), Toast.LENGTH_SHORT).show();
        Log.d("AlarmReceiver", "Receivew Now  Eise Do Task" + new Date());

        int id = (int) intent.getExtras().getInt("PENDINGID");

        createNotificationChannel(context,id);
    }

    private void createNotificationChannel(Context context, int id_notifi) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = context.getString(R.string.channel_name);
            String description = context.getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Notification DOT", name, importance);
            channel.setDescription(description);

            Intent snoozeIntent = new Intent(context, AlarmReceiver.class);

//            snoozeIntent.setAction(ACTION_SNOOZE);
//            snoozeIntent.putExtra(EXTRA_NOTIFICATION_ID, 0);
            PendingIntent snoozePendingIntent =
                    PendingIntent.getBroadcast(context, 0, snoozeIntent, 0);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "Notificaiton")
                    .setSmallIcon(R.drawable.ic_completed)
                    .setContentTitle("My notification")
                    .setContentText("Much longer text that cannot fit one line...")
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Much longer text that cannot fit one line..."))
                    .addAction(android.R.drawable.sym_def_app_icon, "Snooz",
                            snoozePendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
            mBuilder.build();
            notificationManager.notify(id_notifi, mBuilder.build());
        } else {

            Intent snoozeIntent = new Intent(context, AlarmReceiver.class);
//            snoozeIntent.setAction(ACTION_SNOOZE);
//            snoozeIntent.putExtra(EXTRA_NOTIFICATION_ID, 0);
            PendingIntent snoozePendingIntent =
                    PendingIntent.getBroadcast(context, id_notifi, snoozeIntent, 0);
//
//
            NotificationManager notificationManager = (NotificationManager)
                    context.getSystemService(Context.NOTIFICATION_SERVICE);


            //            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "Notificaiton")
//                    .setContentTitle("My notification")
//                    .setContentText("Much longer text that cannot fit one line...")
//                    .setStyle(new NotificationCompat.BigTextStyle()
//                            .bigText("Much longer text that cannot fit one line..."))
//                    .setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true)
//                    .addAction(android.R.drawable.sym_def_app_icon, "SnoozL̥",
//                            snoozePendingIntent);
////            mBuilder.build();
////            mBuilder.notify();
//            notificationManager.notify(1, mBuilder.build());
//            notify();

//            Intent intent = new Intent(context, AlarmReceiver.class);
//// use System.currentTimeMillis() to have a unique ID for the pending intent
//            PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);

// build notification
// the addAction re-use the same intent to keep the example short
            Notification n  = new Notification.Builder(context)
                    .setContentTitle("New mail from " + "test@gmail.com")
                    .setContentText("Subject")
                    .setSmallIcon(android.R.drawable.sym_def_app_icon)
                    .setContentIntent(snoozePendingIntent)
                    .setAutoCancel(false)
                    .addAction(android.R.drawable.sym_def_app_icon, "Call", snoozePendingIntent)
                    .addAction(android.R.drawable.sym_def_app_icon, "More", snoozePendingIntent)
                    .addAction(android.R.drawable.sym_def_app_icon, "And more", snoozePendingIntent).build();


//            NotificationManager notificationManager =
//                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(id_notifi, n);
        }
    }
}