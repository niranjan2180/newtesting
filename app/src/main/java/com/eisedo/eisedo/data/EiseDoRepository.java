package com.eisedo.eisedo.data;

import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.data.local.entities.User;
import com.eisedo.eisedo.util.ResultCallBackListener;

import java.util.Date;
import java.util.List;

public class EiseDoRepository implements EiseDoDataSource {

    public static EiseDoRepository eiseDoRepository;

    private EiseDoDataSource eiseDoDataSourceLocal;

    private EiseDoDataSource eiseDoDataSourceRemote;

    public EiseDoRepository(EiseDoDataSource eiseDoDataSourceLocal, EiseDoDataSource eiseDoDataSourceRemote) {
        this.eiseDoDataSourceLocal = eiseDoDataSourceLocal;
        this.eiseDoDataSourceRemote = eiseDoDataSourceRemote;
    }

    public static EiseDoRepository getInstance(EiseDoDataSource eiseDoDataSourceLocal, EiseDoDataSource eiseDoDataSourceRemote) {
        if (eiseDoRepository == null) {
            eiseDoRepository = new EiseDoRepository(eiseDoDataSourceLocal, eiseDoDataSourceRemote);
        }
        return eiseDoRepository;
    }

    @Override
    public void insertTask(Task task, ResultCallBackListener resultCallBackListener) {
        eiseDoDataSourceLocal.insertTask(task, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                resultCallBackListener.onSuccess(task);
            }

            @Override
            public void onFailure(Object o) {
                resultCallBackListener.onFailure(0);
            }
        });
    }

    @Override
    public void updateTask(Task task, ResultCallBackListener resultCallBackListener) {
        eiseDoDataSourceLocal.updateTask(task, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                resultCallBackListener.onSuccess(o);
            }

            @Override
            public void onFailure(Object o) {
            }
        });
    }

    @Override
    public void deleteTask(Task task) {
        eiseDoDataSourceLocal.deleteTask(task);
    }

    @Override
    public List<Task> getAllTaskByBucket(int bucket, ResultCallBackListener resultCallBackListener) {
        eiseDoDataSourceLocal.getAllTaskByBucket(bucket, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                resultCallBackListener.onSuccess(o);
            }

            @Override
            public void onFailure(Object o) {
                resultCallBackListener.onFailure(o);
            }
        });
        return null;
    }

    @Override
    public void staredCount(boolean value, ResultCallBackListener resultCallBackListener) {
        eiseDoDataSourceLocal.staredCount(value, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                resultCallBackListener.onSuccess(o);
            }

            @Override
            public void onFailure(Object o) {
                resultCallBackListener.onFailure(o);
            }
        });
    }

    @Override
    public void getTaskByProject(int project_id, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void insertUser(User user, ResultCallBackListener resultCallBackListener) {
        eiseDoDataSourceLocal.insertUser(user, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                resultCallBackListener.onSuccess(o);
            }

            @Override
            public void onFailure(Object o) {
                resultCallBackListener.onFailure(o);
            }
        });
    }

    @Override
    public void getAllTasks(ResultCallBackListener resultCallBackListener) {
        eiseDoDataSourceLocal.getAllTasks(new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                resultCallBackListener.onSuccess(o);
            }

            @Override
            public void onFailure(Object o) {
                resultCallBackListener.onFailure(o);
            }
        });
    }

    @Override
    public void getTaskById(long task_id, ResultCallBackListener resultCallBackListener) {
        eiseDoDataSourceLocal.getTaskById(task_id, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                resultCallBackListener.onSuccess(o);
            }

            @Override
            public void onFailure(Object o) {
                resultCallBackListener.onFailure(o);
            }
        });
    }

    @Override
    public void insertFolder(Folder folder, GetFolderCallback getFolderCallback) {
        eiseDoDataSourceLocal.insertFolder(folder, new GetFolderCallback() {
            @Override
            public void onFolderLoaded(Folder folder) {
                getFolderCallback.onFolderLoaded(folder);
            }

            @Override
            public void onDataNotAvailable() {
            }
        });
    }

    @Override
    public void listAllFolders(LoadFolderCallback loadFolderCallback) {
        eiseDoDataSourceLocal.listAllFolders(new LoadFolderCallback() {
            @Override
            public void onFolderLoaded(List<Folder> folders) {
                loadFolderCallback.onFolderLoaded(folders);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void updateFolder(Folder folder, GetFolderCallback getFolderCallback) {
        eiseDoDataSourceLocal.updateFolder(folder, new GetFolderCallback() {
            @Override
            public void onFolderLoaded(Folder folder) {
                getFolderCallback.onFolderLoaded(folder);
            }

            @Override
            public void onDataNotAvailable() {
                getFolderCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void searchTaskList(String search, LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.searchTaskList(search, new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getTasksForDoNow(boolean importance, Date date, LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getTasksForDoNow(importance, date, new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getTasksForDoLater(boolean importance, Date date, LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getTasksForDoLater(importance, date, new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getTasksForDelegate(boolean importance, Date date, LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getTasksForDelegate(importance, date, new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getTasksForEliminate(boolean importance, Date date, LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getTasksForEliminate(importance, date, new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getTrashedTasks(LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getTrashedTasks(new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getCompletedTasks(LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getCompletedTasks(new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getDelegatedTasks(LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getDelegatedTasks(new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getOverDueTasks(Date date, LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getOverDueTasks(date, new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getStarredTasks(LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getStarredTasks(new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getRepeatedTasks(LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getRepeatedTasks(new LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                loadTaskCallback.onTasksLoaded(tasks);
            }

            @Override
            public void onDataNotAvailable() {
                loadTaskCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getTasksCount(Date date, ResultCallBackListener resultCallBackListener) {
        eiseDoDataSourceLocal.getTasksCount(date,resultCallBackListener);
    }

    @Override
    public void getReminders(LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getReminders(loadTaskCallback);
    }

    @Override
    public void getSortTaskOrder(int folder, int option, LoadTaskCallback loadTaskCallback) {
        eiseDoDataSourceLocal.getSortTaskOrder(folder,option,loadTaskCallback);
    }
}
