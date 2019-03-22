package com.eisedo.eisedo.data.local;

import android.util.Log;

import com.eisedo.eisedo.data.EiseDoDataSource;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.data.local.entities.User;
import com.eisedo.eisedo.executor.AppExecutors;
import com.eisedo.eisedo.util.ResultCallBackListener;

import java.util.Date;
import java.util.List;

public class EiseDoLocalDataRepository implements EiseDoDataSource {

    private static EiseDoDao eiseDoDao;

    private static AppExecutors appExecutors;

    public static EiseDoLocalDataRepository eiseDoLocalDataRepository;

    public static EiseDoLocalDataRepository getInstance(EiseDoDao eiseDoDao, AppExecutors appExecutors) {
        if (eiseDoLocalDataRepository == null) {
            eiseDoLocalDataRepository = new EiseDoLocalDataRepository(eiseDoDao, appExecutors);
        }
        return eiseDoLocalDataRepository;
    }

    private EiseDoLocalDataRepository(EiseDoDao notesDao, AppExecutors appExecutors) {
        this.eiseDoDao = notesDao;
        this.appExecutors = appExecutors;
    }

    @Override
    public void insertTask(Task task, ResultCallBackListener resultCallBackListener) {

        appExecutors.getUiExecutor().execute(() -> {
            long id = eiseDoDao.insertTask(task);
            Log.d("Task_id", id + "");
            task.setId(id);
            appExecutors.getMainExecutor().execute(() -> resultCallBackListener.onSuccess(task));
        });
    }

    @Override
    public void updateTask(Task task, ResultCallBackListener resultCallBackListener) {
        appExecutors.getUiExecutor().execute(() -> {
            eiseDoDao.updateTask(task);
            appExecutors.getMainExecutor().execute(() -> resultCallBackListener.onSuccess(task));
        });
    }

    @Override
    public void deleteTask(Task task) {

    }

    @Override
    public List<Task> getAllTaskByBucket(int bucket, ResultCallBackListener resultCallBackListener) {
        appExecutors.getUiExecutor().execute(() -> resultCallBackListener.onSuccess(eiseDoDao.getTaskByBucket(bucket)));
        return null;
    }

    @Override
    public void staredCount(boolean value, ResultCallBackListener resultCallBackListener) {
//        appExecutors.getUiExecutor().execute(() -> resultCallBackListener.onSuccess(eiseDoDao.getStarCount(false)));
    }

    @Override
    public void getTaskByProject(int project_id, ResultCallBackListener resultCallBackListener) {
//        appExecutors.getUiExecutor().execute(() -> resultCallBackListener.onSuccess(eiseDoDao.ge));
    }

    @Override
    public void insertUser(User user, ResultCallBackListener resultCallBackListener) {
        appExecutors.getUiExecutor().execute(() -> resultCallBackListener.onSuccess(""));
    }

    @Override
    public void getAllTasks(ResultCallBackListener resultCallBackListener) {
        appExecutors.getUiExecutor().execute(() -> resultCallBackListener.onSuccess(eiseDoDao.getAllTasks()));
    }

    @Override
    public void getTaskById(long task_id, ResultCallBackListener resultCallBackListener) {
        appExecutors.getUiExecutor().execute(() -> {
            Task task = eiseDoDao.getTaskById(task_id);
            appExecutors.getMainExecutor().execute(() -> {
                resultCallBackListener.onSuccess(task);
            });
        });
    }

    @Override
    public void insertFolder(Folder folder, GetFolderCallback getFolderCallback) {
        Runnable runnable = () -> {
            long folder_id = eiseDoDao.insertFolder(folder);

            folder.setId((int) folder_id);

            getFolderCallback.onFolderLoaded(folder);

        };
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void listAllFolders(LoadFolderCallback loadFolderCallback) {
        Runnable runnable = () -> loadFolderCallback.onFolderLoaded(eiseDoDao.getFolderList());
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void updateFolder(Folder folder, GetFolderCallback getFolderCallback) {
        Runnable runnable = () -> getFolderCallback.onFolderLoaded(folder);
        appExecutors.getUiExecutor().execute(runnable);
    }


    @Override
    public void searchTaskList(String search, LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.searchTaskByTitle(search));
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getTasksForDoNow(boolean importance, Date date, LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getTasksBasedOnDateNow(true, date));
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getTasksForDoLater(boolean importance, Date date, LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getTasksBasedOnDateLater(true, date));
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getTasksForDelegate(boolean importance, Date date, LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getTasksBasedOnDateNow(false, date));
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getTasksForEliminate(boolean importance, Date date, LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getTasksBasedOnDateLater(false, date));
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getTrashedTasks(LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getTrashedTasks());
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getCompletedTasks(LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getCompletedTasks());
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getDelegatedTasks(LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getDelegatedTasks());
        appExecutors.getUiExecutor().execute(runnable);
    }


    @Override
    public void getOverDueTasks(Date date, LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getOverDueTasks(date));
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getStarredTasks(LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getStaredTasks());
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getTasksCount(Date date, ResultCallBackListener resultCallBackListener) {
        Runnable runnable = () -> resultCallBackListener.onSuccess(eiseDoDao.getTaskCounts(date));
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getReminders(LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getReminders());
        appExecutors.getUiExecutor().execute(runnable);
    }

    @Override
    public void getSortTaskOrder(int folder, int option, LoadTaskCallback loadTaskCallback) {

        if (option == 1) {

            Runnable uiRunnable = () -> {
                List<Task> tasks = eiseDoDao.getTasksByDueDate(folder);
                appExecutors.getMainExecutor().execute(() -> loadTaskCallback.onTasksLoaded(tasks));
            };
            appExecutors.getUiExecutor().execute(uiRunnable);

        } else if (option == 2) {

            Runnable uiRunnable = () -> {
                List<Task> tasks = eiseDoDao.getTasksByOrderProgress(folder);
                appExecutors.getMainExecutor().execute(() -> loadTaskCallback.onTasksLoaded(tasks));
            };
            appExecutors.getUiExecutor().execute(uiRunnable);

        } else if (option == 3) {

            Runnable uiRunnable = () -> {
                List<Task> tasks = eiseDoDao.getTasksByOrderTitle(folder);
                appExecutors.getMainExecutor().execute(() -> loadTaskCallback.onTasksLoaded(tasks));
            };
            appExecutors.getUiExecutor().execute(uiRunnable);

        }
    }

    @Override
    public void getRepeatedTasks(LoadTaskCallback loadTaskCallback) {
        Runnable runnable = () -> loadTaskCallback.onTasksLoaded(eiseDoDao.getRepeatTasks());
        appExecutors.getUiExecutor().execute(runnable);
    }
}