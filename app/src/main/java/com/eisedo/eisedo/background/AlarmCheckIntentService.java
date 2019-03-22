package com.eisedo.eisedo.background;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.eisedo.eisedo.Injection;
import com.eisedo.eisedo.data.EiseDoDataSource;
import com.eisedo.eisedo.data.local.entities.Alarm;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.util.AlarmUtil;

import java.util.List;

import androidx.annotation.Nullable;

public class AlarmCheckIntentService extends IntentService {

    public AlarmCheckIntentService() {
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Injection.eiseDoRepository(this).getReminders(new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks != null){
                    for (int i =0 ; i < tasks.size() ; i++){
                        Log.d("Tasks", i + " " + tasks.get(i).getRemainder_date());
                        AlarmUtil.setTaskAlarm(changeToAlarm(tasks.get(i)),getApplicationContext());
                    }
                }
            }
            @Override
            public void onDataNotAvailable() { }
        });
    }

    Alarm changeToAlarm(Task task){
        Alarm alarm = new Alarm();
        alarm.setTask_id(task.getId()+"");
        alarm.setCreated_date(task.getCreated_date());
        alarm.setDue_date(task.getDue_date());
        alarm.setRemainder_date(task.getRemainder_date());
        alarm.setNotes(task.getNotes());
        alarm.setTimezone(task.getTimezone());
        alarm.setRepeat(task.getRepeat());
        alarm.setTitle(task.getTitle());
        alarm.setDismiss(task.isDismiss());
        return alarm;
    }
}
