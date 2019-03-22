package com.eisedo.eisedo.home.task;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.EiseDoDataSource;
import com.eisedo.eisedo.data.EiseDoRepository;
import com.eisedo.eisedo.data.local.entities.SortFilter;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.util.ResultCallBackListener;
import com.eisedo.eisedo.util.SingleLiveDataEvent;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class TaskViewModel extends AndroidViewModel {

    private EiseDoRepository eiseDoRepository;

    private MutableLiveData<ArrayList<SortFilter>> filterSortMutableLiveData;

    private MutableLiveData<ArrayList<Task>> taskListMutableLiveData;

    private MutableLiveData<Task> taskMutableLiveData;

    private SingleLiveDataEvent<Integer> taskNavigationDataEvent;

    private SingleLiveDataEvent<Long> editTaskDataEvent;

    private SingleLiveDataEvent<Integer> sortSingleLiveDataEvent;

    public SingleLiveDataEvent<Integer> getSortSingleLiveDataEvent() {
        if (sortSingleLiveDataEvent == null){
            sortSingleLiveDataEvent = new SingleLiveDataEvent<>();
        }
        return sortSingleLiveDataEvent;
    }

    public MutableLiveData<Task> getTaskMutableLiveData() {
        if (taskMutableLiveData == null){
            taskMutableLiveData = new MutableLiveData<>();
        }
        return taskMutableLiveData;
    }

    public SingleLiveDataEvent<Long> getEditTaskDataEvent() {
        if (editTaskDataEvent == null){
            editTaskDataEvent = new SingleLiveDataEvent<>();
        }
        return editTaskDataEvent;
    }

    public MutableLiveData<ArrayList<SortFilter>> getFilterSortMutableLiveData() {
        if (filterSortMutableLiveData == null){
            filterSortMutableLiveData = new MutableLiveData<>();
        }
        return filterSortMutableLiveData;
    }

    public MutableLiveData<ArrayList<Task>> getTaskListMutableLiveData() {
        if (taskListMutableLiveData == null){
            taskListMutableLiveData = new MutableLiveData<>();
        }
        return taskListMutableLiveData;
    }

    public SingleLiveDataEvent<Integer> getTaskNavigationDataEvent() {
        if (taskNavigationDataEvent == null){
            taskNavigationDataEvent = new SingleLiveDataEvent<>();
        }
        return taskNavigationDataEvent;
    }

    public TaskViewModel(@NonNull Application application, EiseDoRepository eiseDoRepository) {
        super(application);
        this.eiseDoRepository = eiseDoRepository;
    }

    public void getSortType(){
        if (sortSingleLiveDataEvent != null){
            sortSingleLiveDataEvent.setValue(sortSingleLiveDataEvent.getValue());
        }
        Log.d("SortTypr", sortSingleLiveDataEvent.getValue() + "");
    }

    public void getFilterList(Context context){
        ArrayList<SortFilter> sortFilters = new ArrayList<>();
        sortFilters.add(new SortFilter(false,context.getString(R.string.priority),R.drawable.ic_priority));
        sortFilters.add(new SortFilter(false,context.getString(R.string.due_date),R.drawable.ic_date));
        sortFilters.add(new SortFilter(false,context.getString(R.string.progress),R.drawable.ic_progress));
        sortFilters.add(new SortFilter(false,context.getString(R.string.alpha_order),R.drawable.ic_sort_alpha));
        filterSortMutableLiveData.setValue(sortFilters);
    }

    public void getTaskByAlphabeticOrder(int folder, int option){
        eiseDoRepository.getSortTaskOrder(folder, option, new EiseDoDataSource.LoadTaskCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                ArrayList<Task> tasks1 = (ArrayList<Task>) tasks;
                Log.d("Tasks", tasks1.size() +" ");
                taskListMutableLiveData.setValue(tasks1);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    public void initialTask(Task task){
        taskMutableLiveData.setValue(task);
    }

    public void getTaskDetail(){
        taskMutableLiveData.getValue();
    }

    public void resetTaskDetail(){
        taskMutableLiveData.setValue(new Task());
    }

    public void editTask(long task_id){
        editTaskDataEvent.setValue(task_id);
    }


    public void getTaskById(long task_id){
        eiseDoRepository.getTaskById(task_id, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                Task task = (Task) o;
                taskMutableLiveData.setValue(task);
            }

            @Override
            public void onFailure(Object o) {

            }
        });
    }

    public void updateTask(Task task){
        eiseDoRepository.updateTask(task, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                navigationTaskEvent(7);
            }

            @Override
            public void onFailure(Object o) {

            }
        });
    }

    public void saveTask(){
        eiseDoRepository.insertTask(taskMutableLiveData.getValue(), new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                Log.d("", " ");
                navigationTaskEvent(7);
            }

            @Override
            public void onFailure(Object o) {

            }
        });
    }

    public void navigationTaskEvent(int event){
        taskNavigationDataEvent.setValue(event);
    }

    public void setSortType(int type){
        if (type == 0){
            sortSingleLiveDataEvent.setValue(type);
            navigationTaskEvent(0);
        }else {
            sortSingleLiveDataEvent.setValue(type);
            navigationTaskEvent(3);
        }
    }

}
