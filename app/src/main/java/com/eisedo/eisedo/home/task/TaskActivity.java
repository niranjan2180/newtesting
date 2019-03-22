package com.eisedo.eisedo.home.task;

import android.os.Bundle;
import android.util.Log;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.ActivityTaskBinding;
import com.eisedo.eisedo.home.folder.FolderFragment;
import com.eisedo.eisedo.home.sort.SortFilterFragment;
import com.eisedo.eisedo.home.sort.SortFragment;
import com.eisedo.eisedo.home.task.repeat.RepeatFragment;
import com.eisedo.eisedo.util.ViewModelFactory;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

public class TaskActivity extends AppCompatActivity {

    private ActivityTaskBinding activityTaskBinding;

    private TaskViewModel taskViewModel;

    private int screen = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCenter.start(getApplication(), "de79cba7-31ed-4940-91e8-f2cb280e2a2e", Analytics.class, Crashes.class);

        activityTaskBinding = DataBindingUtil.setContentView(this, R.layout.activity_task);

        taskViewModel = obtainViewModel(TaskActivity.this);

        taskViewModel.getTaskNavigationDataEvent().observe(this, integer -> openScreen(integer));

        taskViewModel.getEditTaskDataEvent().observe(this,aLong -> callAddEditFragment(aLong));


        taskViewModel.getTaskMutableLiveData();

        Task task = new Task();

        taskViewModel.initialTask(task);

        taskViewModel.getSortSingleLiveDataEvent().observe(this,integer -> {
            Log.d("DataValues", integer + "");
        });

        if (getIntent().getExtras() != null){
            screen = getIntent().getExtras().getInt("screen");
        }

        if (screen == -1){
            taskViewModel.navigationTaskEvent(0);
        }else {
            openScreen(screen);
        }

//        callTaskFragment();
    }

    void openScreen(int screen) {

        switch (screen) {
            case 0:
                callTaskFragment();
                break;
            case 1:
                callAddEditFragment(-1);
                break;
            case 2:
                callSortFilter();
                break;
            case 3:
                callSortFragment();
                break;
            case 4:
                callAddNoteFragment();
                break;
            case 5:
                callDelegateFragment();
                break;
            case 6:
                callFolderFragment();
                break;
            case 7:
                if (getSupportFragmentManager().getFragments().size() == 0){
                    finish();
                }else {
                    getSupportFragmentManager().popBackStack();
                }
                break;
            case 8:
                callRepeatFragment();
                break;
            default:
                callTaskFragment();
                break;
        }
    }

    public static TaskViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TaskViewModel.class);
    }

    void callTaskFragment() {

        TaskFragment taskFragment = (TaskFragment) getSupportFragmentManager().findFragmentByTag("taskFragment");
        if (taskFragment == null) {
            taskFragment = TaskFragment.getInstance();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("folder_id", 0);
        taskFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.cl_container, taskFragment, "taskFragment").commit();
    }

    void callSortFilter() {

        SortFilterFragment sortFilterFragment = (SortFilterFragment) getSupportFragmentManager().findFragmentByTag("sortFilterFragment");

        if (sortFilterFragment == null) {
            sortFilterFragment = SortFilterFragment.getInstance();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.cl_container, sortFilterFragment, "sortFilterFragment").addToBackStack("sortFilterFragment").commit();
    }

    void callSortFragment() {
//        SortFragment sortFragment = (SortFragment) getSupportFragmentManager().findFragmentByTag("sortFragment");
//
//        if (sortFragment == null) {
//            sortFragment = SortFragment.getInstance();
//        }

        getSupportFragmentManager().beginTransaction().replace(R.id.cl_container, new SortFragment(), "sortFragment").commit();
    }

    void callAddEditFragment(long task_id) {

        NewTaskFragment newTaskFragment = (NewTaskFragment) getSupportFragmentManager().findFragmentByTag("newTaskFragment");

        if (newTaskFragment == null) {
            newTaskFragment = NewTaskFragment.getInstance();
        }
        Bundle bundle = new Bundle();
        bundle.putLong("task_id",task_id);
        newTaskFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.cl_container, newTaskFragment, "newTaskFragment").addToBackStack("addTask").commit();
    }

    void callDelegateFragment() {

        DelegateFragment delegateFragment = (DelegateFragment) getSupportFragmentManager().findFragmentByTag("delegateFragment");

        if (delegateFragment == null) {
            delegateFragment = DelegateFragment.getInstance();
        }


        getSupportFragmentManager().beginTransaction().replace(R.id.cl_container, delegateFragment, "delegateFragment").addToBackStack("delegate").commit();
    }

    void callAddNoteFragment() {

        NoteFragment noteFragment = (NoteFragment) getSupportFragmentManager().findFragmentByTag("noteFragment");

        if (noteFragment == null) {
            noteFragment = NoteFragment.getInstance();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.cl_container, noteFragment, "noteFragment").addToBackStack("note").commit();

    }

    void callRepeatFragment() {

        RepeatFragment repeatFragment = (RepeatFragment) getSupportFragmentManager().findFragmentByTag("repeatfragment");

        if (repeatFragment == null){
            repeatFragment = RepeatFragment.getInstance();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.cl_container,repeatFragment,"repeatFragment").addToBackStack("repeat").commit();
    }

    void callFolderFragment() {

        FolderFragment folderFragment = (FolderFragment) getSupportFragmentManager().findFragmentByTag("folderFragment");

        if (folderFragment == null) {
            folderFragment = FolderFragment.getInstance();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.cl_container, folderFragment, "folderFragment").addToBackStack("folder").commit();
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        taskViewModel.resetTaskDetail();
//    }

    @Override
    public void onBackPressed() {

//        try{
//            SortFragment fragment = (SortFragment) getSupportFragmentManager().findFragmentByTag("sortFragment");
//            Log.d("SortFragment", fragment.getTag());
//        }catch (Exception e){
//            e.printStackTrace();
//        }


//        if (fragment.allowBackPressed()) { // and then you define a method allowBackPressed with the logic to allow back pressed or not
            super.onBackPressed();
//        }
//        super.onBackPressed();

//        Log.d("TasksCount", getSupportFragmentManager().getFragments().size() + "");
//        if (getSupportFragmentManager().getFragments().size()> 0){
//            for (int i=0; i< getSupportFragmentManager().getFragments().size(); i++){
//                Log.d("FragmentNames", getSupportFragmentManager().getFragments().get(i).getTag());
//            }
//        }


    }


    //    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        if (getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size() -1) instanceof SortFragment){
//            Log.d("Sort Frag ment", " Calle");
//            finish();
//        }else if (getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size() -1) instanceof TaskFragment){
//            Log.d("Task Fragment", "Task fragmenr");
//            finish();
//        }
//        for (int i =0; i< getSupportFragmentManager().getFragments().size(); i++){
//            Log.d("FRagments", getSupportFragmentManager().getFragments().get(0).getTag() +""  );
//        }
//    }
}