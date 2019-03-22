package com.eisedo.eisedo.util;

import com.eisedo.eisedo.data.local.entities.Task;

public interface OnTaskSelectedListener {

    void onTaskSelected(Task task, int position);

    void onTaskCompleted(Task task, int position);
}