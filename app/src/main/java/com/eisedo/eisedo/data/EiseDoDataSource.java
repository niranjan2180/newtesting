package com.eisedo.eisedo.data;

import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.data.local.entities.User;
import com.eisedo.eisedo.util.ResultCallBackListener;

import java.util.Date;
import java.util.List;

public interface EiseDoDataSource {

    interface LoadFolderCallback {

        void onFolderLoaded(List<Folder> folders);

        void onDataNotAvailable();
    }

    interface GetFolderCallback {

        void onFolderLoaded(Folder folder);

        void onDataNotAvailable();
    }

    interface LoadTaskCallback {
        void onTasksLoaded(List<Task> tasks);

        void onDataNotAvailable();
    }

    void insertTask(Task task, ResultCallBackListener resultCallBackListener);

    void updateTask(Task task, ResultCallBackListener resultCallBackListener);

    void deleteTask(Task task);

    List<Task> getAllTaskByBucket(int bucket, ResultCallBackListener resultCallBackListener);

    void staredCount(boolean value, ResultCallBackListener resultCallBackListener);

    void getTaskByProject(int project_id, ResultCallBackListener resultCallBackListener);

    void insertUser(User user, ResultCallBackListener resultCallBackListener);

    void getAllTasks(ResultCallBackListener resultCallBackListener);

    void getTaskById(long task_id, ResultCallBackListener resultCallBackListener);

    void insertFolder(Folder folder, GetFolderCallback getFolderCallback);

    void listAllFolders(LoadFolderCallback loadFolderCallback);

    void updateFolder(Folder folder, GetFolderCallback getFolderCallback);

    void searchTaskList(String search, LoadTaskCallback loadTaskCallback);

    void getTasksForDoNow(boolean importance, Date date, LoadTaskCallback loadTaskCallback);

    void getTasksForDoLater(boolean importance, Date date, LoadTaskCallback loadTaskCallback);

    void getTasksForDelegate(boolean importance, Date date, LoadTaskCallback loadTaskCallback);

    void getTasksForEliminate(boolean importance, Date date, LoadTaskCallback loadTaskCallback);

    void getTrashedTasks(LoadTaskCallback loadTaskCallback);

    void getCompletedTasks(LoadTaskCallback loadTaskCallback);

    void getDelegatedTasks(LoadTaskCallback loadTaskCallback);

    void getOverDueTasks(Date date, LoadTaskCallback loadTaskCallback);

    void getStarredTasks(LoadTaskCallback loadTaskCallback);

    void getTasksCount(Date date, ResultCallBackListener resultCallBackListener);

    void getReminders(LoadTaskCallback loadTaskCallback);

    void getSortTaskOrder(int folder,int option,LoadTaskCallback loadTaskCallback);

    void getRepeatedTasks(LoadTaskCallback loadTaskCallback);
}
