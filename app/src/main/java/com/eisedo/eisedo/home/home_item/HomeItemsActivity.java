package com.eisedo.eisedo.home.home_item;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.databinding.ActivityHomeItemsBinding;
import com.eisedo.eisedo.home.repeat.RepeatedFragment;
import com.eisedo.eisedo.home.search.SearchFragment;
import com.eisedo.eisedo.home.task.AddEditTaskFragment;
import com.eisedo.eisedo.home.completed.CompletedFragment;
import com.eisedo.eisedo.home.delegated.DelegatedFragment;
import com.eisedo.eisedo.home.task.TaskFragment;
import com.eisedo.eisedo.home.lists.ListsFragment;
import com.eisedo.eisedo.home.overdue.OverdueFragment;
import com.eisedo.eisedo.home.project.ProjectNavigationFragment;
import com.eisedo.eisedo.home.starred.StarredFragment;
import com.eisedo.eisedo.home.trash.TrashFragment;
import com.eisedo.eisedo.util.ViewModelFactory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

public class HomeItemsActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private HomeItemViewModel homeItemViewModel;
    private ActivityHomeItemsBinding activityHomeItemsBinding;

    private DelegatedFragment delegatedFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityHomeItemsBinding = DataBindingUtil.setContentView(this, R.layout.activity_home_items);

        Intent intent = getIntent();

        String homeItem = intent.getStringExtra(getString(R.string.type));

        fragmentManager = getSupportFragmentManager();

//        if (savedInstanceState == null) {
        delegatedFragment = new DelegatedFragment();
//        } else {
//            delegatedFragment = (DelegatedFragment) fragmentManager.findFragmentByTag("delegated");
//        }

        homeItemViewModel = obtainViewModel(HomeItemsActivity.this);

        activityHomeItemsBinding.setHomeItemViewModel(homeItemViewModel);

        homeItemViewModel.getOpenScreenMutableLiveData().observe(this, integer -> openScreen(integer));

        homeItemViewModel.getPassTaskMutableLiveData().observe(this, task_id -> openScreenForEdit(task_id));

//        homeItemViewModel.searchTasksList("task");

        if (homeItem.equals(getString(R.string.inbox))) {
            TaskFragment taskFragment = (TaskFragment) fragmentManager.findFragmentByTag(getString(R.string.inbox));
            if (taskFragment == null) {
                taskFragment = TaskFragment.getInstance();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("folder_id", 0);
            taskFragment.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.cl_container, taskFragment, getString(R.string.inbox)).commit();
        } else if (homeItem.equals(getString(R.string.projects))) {
            fragmentManager.beginTransaction().add(R.id.cl_container, new ProjectNavigationFragment(), getString(R.string.projects)).commit();
        } else if (homeItem.equals(getString(R.string.lists))) {
            fragmentManager.beginTransaction().add(R.id.cl_container, new ListsFragment(), getString(R.string.lists)).commit();
        } else if (homeItem.equals(getString(R.string.starred))) {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag(getString(R.string.starred));
//            StarredFragment starredFragment = (StarredFragment) fragmentManager.findFragmentByTag("starred");
            if (fragment != null) {
                fragmentManager.beginTransaction().add(R.id.cl_container, fragment, getString(R.string.starred)).commit();
            } else {
                fragmentManager.beginTransaction().add(R.id.cl_container, new StarredFragment(), getString(R.string.starred)).commit();
            }
        } else if (homeItem.equals(getString(R.string.overdue))) {
            fragmentManager.beginTransaction().add(R.id.cl_container, new OverdueFragment(), getString(R.string.overdue)).commit();
        } else if (homeItem.equals(getString(R.string.delegated))) {
            fragmentManager.beginTransaction().add(R.id.cl_container, new DelegatedFragment(), getString(R.string.delegated)).commit();

        } else if (homeItem.equals(getString(R.string.completed))) {
            fragmentManager.beginTransaction().add(R.id.cl_container, new CompletedFragment(), getString(R.string.completed)).commit();
        } else if (homeItem.equals(getString(R.string.trash))) {
            fragmentManager.beginTransaction().add(R.id.cl_container, new TrashFragment(), getString(R.string.trash)).commit();
        }else if (homeItem.equals(getString(R.string.search))){
            fragmentManager.beginTransaction().add(R.id.cl_container,new SearchFragment(),getString(R.string.search)).commit();
        }else if (homeItem.equals(getString(R.string.repeat))){
            fragmentManager.beginTransaction().add(R.id.cl_container,new RepeatedFragment(),getString(R.string.repeat)).commit();
        }
    }

    public static HomeItemViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(HomeItemViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getFragments().size() > 1) {
                    getSupportFragmentManager().popBackStack();
                } else {
                    finish();
                }
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openScreenForEdit(long task_id) {
        Bundle bundle = new Bundle();
        bundle.putLong("TASK_ID", task_id);
        AddEditTaskFragment addEditTaskFragment = new AddEditTaskFragment();
        addEditTaskFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.cl_container, addEditTaskFragment, "addedit").addToBackStack("").commit();
    }

    private void openScreen(int screenNo) {

        switch (screenNo) {
            case 0:
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("addedit");
                if (fragment == null) {
                    getSupportFragmentManager().beginTransaction().add(R.id.cl_container, new AddEditTaskFragment(), "addedit").addToBackStack("").commit();
                } else {
                    getSupportFragmentManager().beginTransaction().add(R.id.cl_container, (AddEditTaskFragment) fragment, "addedit").addToBackStack("").commit();
                }
                break;
            case 1:
//                getSupportFragmentManager().beginTransaction().add(R.id.cl_container, new MatrixFragment(), "matrix").addToBackStack("").commit();
                break;
            case 2:
//                getSupportFragmentManager().beginTransaction().add(R.id.cl_container, new NotificationsFragment(), "notification").addToBackStack("").commit();
                break;
            case 3:
//                getSupportFragmentManager().beginTransaction().add(R.id.cl_container,new NotificationsFragment(),"notification").addToBackStack("").commit();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
//                getSupportFragmentManager().beginTransaction().add(R.id.cl_container, new ChangePasswordFragment(), "changePassword").addToBackStack("").commit();
                break;
            default:
                break;
        }
    }
}