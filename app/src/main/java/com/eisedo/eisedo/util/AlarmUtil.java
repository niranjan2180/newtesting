package com.eisedo.eisedo.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Log;

import com.eisedo.eisedo.broadcast_receiver.AlarmReceiver;
import com.eisedo.eisedo.broadcast_receiver.TaskAlarmReceiver;
import com.eisedo.eisedo.data.local.entities.Alarm;

import java.util.Calendar;

public class AlarmUtil {

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    private Context context;

    public AlarmUtil() {

        alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

    }

    void setAlarm(Calendar calendar, long repeatInterval) {
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 1, alarmIntent);
    }

    void cancelAlarm(int pendingId) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, pendingId, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Checks the status of the pending intent
        boolean alarmUp = (PendingIntent.getBroadcast(context, pendingId, intent, PendingIntent.FLAG_UPDATE_CURRENT) != null);
        Log.d("AlaramValue", alarmUp + "Value");
        if (alarmMgr != null) {
            alarmIntent.cancel();
            alarmMgr.cancel(alarmIntent);
        }
    }

    void snoozAlarm(int pending) {

        Intent intent = new Intent(context, this.getClass());
        PendingIntent pendingIntent = PendingIntent.getService(context, pending, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long currentTimeMillis = System.currentTimeMillis();
        long nextUpdateTimeMillis = currentTimeMillis + 5 * DateUtils.MINUTE_IN_MILLIS;
        Time nextUpdateTime = new Time();
        nextUpdateTime.set(nextUpdateTimeMillis);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, nextUpdateTimeMillis, pendingIntent);
    }

    public void setAlarmForTask(int pending, Calendar calendar, long repeatInterval) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra("PENDINGID", pending);
        alarmIntent = PendingIntent.getBroadcast(context, pending, intent, 0);
        setAlarm(calendar, repeatInterval);
    }


    private void setAlarm_RTC(long alarm) {
        Log.d("AlarmValue", alarm + "");
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarm,
                pendingIntent);
    }

    public static void checkAlarmStatus(Alarm alarm, Context context) {
        Intent intent = new Intent(context, TaskAlarmReceiver.class);
        boolean alarmUp = (PendingIntent.getBroadcast(context, Integer.parseInt(alarm.getTask_id()+""), intent, PendingIntent.FLAG_UPDATE_CURRENT) != null);
//        boolean alarmUp = (PendingIntent.getBroadcast(context, 16, intent, PendingIntent.FLAG_UPDATE_CURRENT) != null);
        Log.d("AlaramValue", alarmUp + "Value");
    }

    public static void cancelAlarm(Alarm alarm, Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, TaskAlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, Integer.parseInt(alarm.getTask_id()+""), intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Checks the status of the pending intent
        if (alarmManager != null) {
            alarmIntent.cancel();
            alarmManager.cancel(alarmIntent);
        }
    }

    public static void setTaskAlarm(Alarm alarm, Context context) {
        Log.d("TaskId", alarm.getTask_id() + "");
        Intent intent = new Intent(context, TaskAlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, Integer.parseInt(alarm.getTask_id()), intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        switch (alarm.getRepeat()) {
            case 0:
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarm.getRemainder_date().getTime(), pendingIntent);
                break;
            case 1:
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarm.getRemainder_date().getTime(), AlarmManager.INTERVAL_DAY, pendingIntent);
                break;
            default:
                break;
        }
    }

}