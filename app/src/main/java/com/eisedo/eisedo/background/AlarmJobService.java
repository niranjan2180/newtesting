package com.eisedo.eisedo.background;

import android.content.Intent;
import android.util.Log;

import com.eisedo.eisedo.Injection;
import com.eisedo.eisedo.data.EiseDoDataSource;
import com.eisedo.eisedo.data.local.entities.Task;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class AlarmJobService extends JobIntentService {

    @Override
    protected void onHandleWork(@NonNull Intent intent) {

        Injection.eiseDoRepository(this).getReminders(new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                for (int i=0; i< tasks.size(); i++){
                    Log.d("Tasksj", tasks.get(i).getRemainder_date() + "");
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

}
