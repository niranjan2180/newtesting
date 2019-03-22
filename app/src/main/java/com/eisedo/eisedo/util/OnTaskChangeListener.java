package com.eisedo.eisedo.util;

import com.eisedo.eisedo.data.local.entities.Task;

public interface OnTaskChangeListener {

    void onClick(Object o, int position);

    void onTaskChange(Task task, int position);
}
