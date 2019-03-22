package com.eisedo.eisedo.util;

import com.eisedo.eisedo.data.local.entities.Task;

public interface EventTaskHandling {

    void onTaskComplete(Task task, int position, boolean b);

}
