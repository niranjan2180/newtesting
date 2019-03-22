package com.eisedo.eisedo.home.home_item;

import android.app.Application;
import android.util.Log;

import com.eisedo.eisedo.data.EiseDoDataSource;
import com.eisedo.eisedo.data.EiseDoRepository;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.executor.AppExecutors;
import com.eisedo.eisedo.util.ResultCallBackListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class HomeItemViewModel extends AndroidViewModel {

    private EiseDoRepository eiseDoRepository;

    private MutableLiveData<ArrayList<Task>> taskListMutableLiveData;

    private MutableLiveData<Integer> openScreenMutableLiveData;

    private MutableLiveData<Long> passTaskMutableLiveData;

    private MutableLiveData<Task> taskMutableLiveData;

    private MutableLiveData<Boolean> closeFragmentMutableLiveData;

    // Lists of Data Sorting

    private MutableLiveData<ArrayList<Task>> doFirstTasksMutableLiveData;

    private MutableLiveData<ArrayList<Task>> doLaterTasksMutableLiveData;

    private MutableLiveData<ArrayList<Task>> delegateTasksMutableLiveData;

    private MutableLiveData<ArrayList<Task>> eliminateTasksMutableLiveData;


//    private AppExecutors appExecutors;

    public ObservableInt observableInt = new ObservableInt();

    private MutableLiveData<ArrayList<Folder>> folderListMutableLiveData;

    public HomeItemViewModel(@NonNull Application application, EiseDoRepository eiseDoRepository) {
        super(application);
        this.eiseDoRepository = eiseDoRepository;
//        appExecutors  = AppExecutors.
    }

    public ObservableInt getObservableInt() {
        return observableInt;
    }

    public MutableLiveData<ArrayList<Task>> getDoFirstTasksMutableLiveData() {
        if (doFirstTasksMutableLiveData == null) {
            doFirstTasksMutableLiveData = new MutableLiveData<>();
        }
        return doFirstTasksMutableLiveData;
    }

    public MutableLiveData<ArrayList<Task>> getDoLaterTasksMutableLiveData() {
        if (doLaterTasksMutableLiveData == null) {
            doLaterTasksMutableLiveData = new MutableLiveData<>();
        }
        return doLaterTasksMutableLiveData;
    }

    public MutableLiveData<ArrayList<Task>> getDelegateTasksMutableLiveData() {
        if (delegateTasksMutableLiveData == null) {
            delegateTasksMutableLiveData = new MutableLiveData<>();
        }
        return delegateTasksMutableLiveData;
    }

    public MutableLiveData<ArrayList<Task>> getEliminateTasksMutableLiveData() {
        if (eliminateTasksMutableLiveData == null) {
            eliminateTasksMutableLiveData = new MutableLiveData<>();
        }
        return eliminateTasksMutableLiveData;
    }

    public MutableLiveData<ArrayList<Task>> getTaskListMutableLiveData() {
        if (taskListMutableLiveData == null) {
            taskListMutableLiveData = new MutableLiveData<>();
        }
        return taskListMutableLiveData;
    }

    public MutableLiveData<Integer> getOpenScreenMutableLiveData() {
        if (openScreenMutableLiveData == null) {
            openScreenMutableLiveData = new MutableLiveData<>();
        }
        return openScreenMutableLiveData;
    }

    public MutableLiveData<Long> getPassTaskMutableLiveData() {
        if (passTaskMutableLiveData == null) {
            passTaskMutableLiveData = new MutableLiveData<>();
        }
        return passTaskMutableLiveData;
    }

    public MutableLiveData<Task> getTaskMutableLiveData() {
        if (taskMutableLiveData == null) {
            taskMutableLiveData = new MutableLiveData<>();
        }
        return taskMutableLiveData;
    }

    public MutableLiveData<Boolean> getCloseFragmentMutableLiveData() {
        if (closeFragmentMutableLiveData == null) {
            closeFragmentMutableLiveData = new MutableLiveData<>();
        }
        return closeFragmentMutableLiveData;
    }

    public void removeInstance() {
        closeFragmentMutableLiveData = null;
    }

    public MutableLiveData<ArrayList<Folder>> getFolderListMutableLiveData() {
        if (folderListMutableLiveData == null) {
            folderListMutableLiveData = new MutableLiveData<>();
        }
        return folderListMutableLiveData;
    }

    public void openForEdit(long task_id) {
        getPassTaskMutableLiveData().setValue(task_id);
    }

    //open Screen
    public void openScreen(int i) {
        openScreenMutableLiveData.setValue(i);
    }

    //Save Task
    public void addTask(Task task) {
        eiseDoRepository.insertTask(task, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                Task addedTask = (Task) o;

                switch (addedTask.getBucket()) {
                    case 0:

                        ArrayList<Task> doFirstTasks = ((doFirstTasksMutableLiveData.getValue() == null) ? new ArrayList<>() : doFirstTasksMutableLiveData.getValue());
                        doFirstTasks.add(addedTask);
                        doFirstTasksMutableLiveData.postValue(doFirstTasks);
                        AppExecutors doFirstAppExecutors = new AppExecutors();
                        doFirstAppExecutors.getUiExecutor().execute(() -> doFirstTasksMutableLiveData.postValue(doFirstTasks));
                        break;

                    case 1:

                        ArrayList<Task> doLaterTasks = ((doLaterTasksMutableLiveData.getValue() == null) ? new ArrayList<>() : doLaterTasksMutableLiveData.getValue());
                        doLaterTasks.add(addedTask);
                        doLaterTasksMutableLiveData.postValue(doLaterTasks);
                        AppExecutors doLaterAppExecutors = new AppExecutors();
                        doLaterAppExecutors.getUiExecutor().execute(() -> doLaterTasksMutableLiveData.postValue(doLaterTasks));
                        break;

                    case 2:

                        ArrayList<Task> delegateTasks = ((delegateTasksMutableLiveData.getValue() == null) ? new ArrayList<>() : delegateTasksMutableLiveData.getValue());
                        delegateTasks.add(addedTask);
                        delegateTasksMutableLiveData.postValue(delegateTasks);
                        AppExecutors delegateAppExecutors = new AppExecutors();
                        delegateAppExecutors.getUiExecutor().execute(() -> delegateTasksMutableLiveData.postValue(delegateTasks));
                        break;

                    case 3:

                        ArrayList<Task> eliminateTasks = ((eliminateTasksMutableLiveData.getValue() == null) ? new ArrayList<>() : eliminateTasksMutableLiveData.getValue());
                        eliminateTasks.add(addedTask);
                        eliminateTasksMutableLiveData.postValue(eliminateTasks);
                        AppExecutors eliminateAppExecutors = new AppExecutors();
                        eliminateAppExecutors.getUiExecutor().execute(() -> eliminateTasksMutableLiveData.postValue(eliminateTasks));
                        break;

                    default:
                        break;
                }

                Log.d("Value", addedTask.getDue_date() + " " + addedTask.getTitle() + " " + addedTask.getId());

//                Runnable runnable = () -> {
                moveToScreen();
//                };
//                AppExecutors appExecutors = new AppExecutors();
//                appExecutors.getMainExecutor().execute(runnable);
            }

            @Override
            public void onFailure(Object o) {

            }
        });
    }

    @MainThread
    public void moveToScreen() {
        Runnable runnable = () -> {
//            moveToScreen();
            closeFragmentMutableLiveData.setValue(true);
        };
        AppExecutors appExecutors = new AppExecutors();
        appExecutors.getMainExecutor().execute(runnable);
    }

    //TODO -- Do it in a better way
    // To get the tasks in a proper manner
    public void edit(Task task) {
        eiseDoRepository.updateTask(task, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                Task task1 = (Task) o;
                Log.d("Task", task1.getTitle());

                Runnable runnable = () -> {
                    closeFragmentMutableLiveData.setValue(true);
                };
                AppExecutors appExecutors = new AppExecutors();
                appExecutors.getMainExecutor().execute(runnable);
            }

            @Override
            public void onFailure(Object o) {
            }
        });
    }

    public void getAllTasks() {
        eiseDoRepository.getAllTasks(new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                Task[] tasks = (Task[]) o;
                Log.d("Tasks Value", tasks.length + "");
                if (tasks.length > 0) {
                    ArrayList<Task> taskArrayList = new ArrayList(Arrays.asList(tasks));
                    taskListMutableLiveData.postValue(taskArrayList);
                }
            }

            @Override
            public void onFailure(Object o) {
            }
        });
    }


    //Delegated Tasks
    public void getDelegatedTasks() {
        eiseDoRepository.getDelegatedTasks(new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    ArrayList<Task> delegatedTasksList = (ArrayList<Task>) tasks;
                    taskListMutableLiveData.postValue(delegatedTasksList);
                }
            }

            @Override
            public void onDataNotAvailable() {
                Log.d("Deleagate","NoDataFound");
            }
        });
    }

    //Over Due Tasks
    public void getOverDueTasks(Date date) {
        eiseDoRepository.getOverDueTasks(date, new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    ArrayList<Task> overDueTasksList = (ArrayList<Task>) tasks;
                    taskListMutableLiveData.postValue(overDueTasksList);
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    //Trashed Tasks
    public void getTrashTasks() {
        eiseDoRepository.getTrashedTasks(new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    ArrayList<Task> trashTasksList = (ArrayList<Task>) tasks;
                    taskListMutableLiveData.postValue(trashTasksList);
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    //Starred Tasks
    public void getStarredTasks() {
        eiseDoRepository.getStarredTasks(new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    ArrayList<Task> starredTasksList = (ArrayList<Task>) tasks;
                    taskListMutableLiveData.postValue(starredTasksList);
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    //repeated Task
    public void getRepeatedTasks(){
        eiseDoRepository.getRepeatedTasks(new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    ArrayList<Task> starredTasksList = (ArrayList<Task>) tasks;
                    taskListMutableLiveData.postValue(starredTasksList);
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }



    //All Completed Tasks
    public void getCompletedTasks() {
        eiseDoRepository.getCompletedTasks(new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    ArrayList<Task> completedTasksList = (ArrayList<Task>) tasks;
                    taskListMutableLiveData.postValue(completedTasksList);
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    public void getTasks() {
        eiseDoRepository.getTaskByProject(0, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                if (o != null) {
                    List<Task> tasks = (List<Task>) o;
                    Log.d("Values", tasks.size() + "");
                }
            }

            @Override
            public void onFailure(Object o) {
            }
        });
    }

    public void getTaskById(long task_id) {
        eiseDoRepository.getTaskById(task_id, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                if (o != null) {
                    Task task = (Task) o;
                    if (taskMutableLiveData != null) {
                        Runnable runnable = () -> taskMutableLiveData.setValue(task);
                        AppExecutors appExecutors = new AppExecutors();
                        appExecutors.getMainExecutor().execute(runnable);
                    }
                }
            }

            @Override
            public void onFailure(Object o) {
            }
        });
    }

    public void addFolder(Folder folder) {
        eiseDoRepository.insertFolder(folder, new EiseDoDataSource.GetFolderCallback() {
            @Override
            public void onFolderLoaded(Folder folder) {
//                listMutableLiveData.getValue().add(folder);
                Log.d("FolderAdded", folder.toString());
            }

            @Override
            public void onDataNotAvailable() {
            }
        });
//        Log.d("VAlues",  eiseDoRepository.listAllFolders().size() + "");
    }

    public void listAllFolders() {
        eiseDoRepository.listAllFolders(new EiseDoDataSource.LoadFolderCallback() {
            @Override
            public void onFolderLoaded(List<Folder> folders) {
                Runnable runnable = () -> folderListMutableLiveData.setValue((ArrayList<Folder>) folders);

                AppExecutors appExecutors = new AppExecutors();
                appExecutors.getMainExecutor().execute(runnable);
            }

            @Override
            public void onDataNotAvailable() {
            }
        });
    }

    public void searchTasksList(String task) {
        eiseDoRepository.searchTaskList(task, new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                Log.d("TaskesLoaded", tasks.size() + " ");
                if (tasks.size() > 0) {
                    Runnable runnable = () -> taskListMutableLiveData.setValue((ArrayList<Task>) tasks);
                    AppExecutors appExecutors = new AppExecutors();
                    appExecutors.getMainExecutor().execute(runnable);
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    public void getDoFirstTasks() {
        eiseDoRepository.getTasksForDoNow(true, new Date(), new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    Runnable runnable = () -> doFirstTasksMutableLiveData.setValue((ArrayList<Task>) tasks);
                    AppExecutors appExecutors = new AppExecutors();
                    appExecutors.getMainExecutor().execute(runnable);
                }
            }

            @Override
            public void onDataNotAvailable() {
            }
        });
    }

    public void getDoLaterTasks() {
        eiseDoRepository.getTasksForDoLater(true, new Date(), new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    Runnable runnable = () -> doLaterTasksMutableLiveData.setValue((ArrayList<Task>) tasks);
                    AppExecutors appExecutors = new AppExecutors();
                    appExecutors.getMainExecutor().execute(runnable);
                }
            }

            @Override
            public void onDataNotAvailable() {
            }
        });
    }

    //Delegated Tasks
    public void getDelegateTask() {
        eiseDoRepository.getTasksForDelegate(false, new Date(), new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    Runnable runnable = () -> delegateTasksMutableLiveData.setValue((ArrayList<Task>) tasks);
                    AppExecutors appExecutors = new AppExecutors();
                    appExecutors.getMainExecutor().execute(runnable);
                }
            }

            @Override
            public void onDataNotAvailable() {
            }
        });
    }

    // Eliminated Tasks
    public void getEliminateTask() {
        eiseDoRepository.getTasksForEliminate(false, new Date(), new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                if (tasks.size() > 0) {
                    Runnable runnable = () -> eliminateTasksMutableLiveData.setValue((ArrayList<Task>) tasks);
                    AppExecutors appExecutors = new AppExecutors();
                    appExecutors.getMainExecutor().execute(runnable);
                }
            }

            @Override
            public void onDataNotAvailable() {
            }
        });
    }


    // TODO - Set the bucket value

    public int setBucketValue(Task task) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 2);
        if (task.isImportance()) {
            if (task.getDue_date() == null) {
                return 1;
            }
            if (task.getDue_date().getTime() < calendar.getTime().getTime()) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (task.getDue_date() == null) {
                return 3;
            }
            if (task.getDue_date().getTime() < calendar.getTime().getTime()) {
                return 2;
            } else {
                return 3;
            }
        }
    }

}
