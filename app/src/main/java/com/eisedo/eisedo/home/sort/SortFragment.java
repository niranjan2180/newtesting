package com.eisedo.eisedo.home.sort;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentSortBinding;
import com.eisedo.eisedo.home.TaskAdapter;
import com.eisedo.eisedo.home.task.TaskActivity;
import com.eisedo.eisedo.home.task.TaskViewModel;
import com.eisedo.eisedo.util.OnTaskChangeListener;

import java.util.ArrayList;
import java.util.Collections;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class SortFragment extends Fragment {

    private TextView tv_sort;

    public static SortFragment sortFragment = null;

    private ArrayList<Task> tasks;

    public static SortFragment getInstance() {
        if (sortFragment == null) {
            sortFragment = new SortFragment();
        }
        return sortFragment;
    }

    private FragmentSortBinding fragmentSortBinding;

    private TaskViewModel taskViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentSortBinding = FragmentSortBinding.inflate(inflater, container, false);

        tasks = new ArrayList<>();

        taskViewModel = TaskActivity.obtainViewModel(getActivity());

        taskViewModel.getSortSingleLiveDataEvent().observe(this, integer -> {
            Log.d("ProgressType", " " + integer);
            setTitle(integer);
        });

        taskViewModel.getTaskListMutableLiveData().observe(this, tasks1 -> {
            Log.d("Tasks", tasks1.size() + " ");
            tasks.clear();
            tasks.addAll(tasks1);
            fragmentSortBinding.rvTasks.getAdapter().notifyDataSetChanged();
        });

        if (taskViewModel.getSortSingleLiveDataEvent() != null){
            setTitle(taskViewModel.getSortSingleLiveDataEvent().getValue());
            taskViewModel.getTaskByAlphabeticOrder(0, taskViewModel.getSortSingleLiveDataEvent().getValue());
        }else {
            taskViewModel.getTaskByAlphabeticOrder(0,0);
        }


        fragmentSortBinding.tvSort.setOnClickListener(v -> {
            Collections.reverse(tasks);
            fragmentSortBinding.rvTasks.getAdapter().notifyDataSetChanged();
        });

//        taskViewModel.getSortType();

        fragmentSortBinding.setTakList(tasks);

//        View view = inflater.inflate(R.layout.fragment_sort,container,false);

//        tv_sort = view.findViewById(R.id.tv_sort);

//        tv_sort.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Sort Values", Toast.LENGTH_SHORT).show();
//            }
//        });
        setTaskAdapter();

        setUpActionBar();

        return fragmentSortBinding.getRoot();
    }

    void setTaskAdapter() {
        TaskAdapter taskAdapter = new TaskAdapter(tasks, getActivity(), new OnTaskChangeListener() {
            @Override
            public void onClick(Object o, int position) {
                Task task = (Task) o;
                Log.d("Position Task", task.getTask_id() + " " + position);
                taskViewModel.editTask(task.getId());
            }

            @Override
            public void onTaskChange(Task task, int position) {

            }
        }, 0);
        fragmentSortBinding.rvTasks.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentSortBinding.rvTasks.setAdapter(taskAdapter);
    }

    private void setUpActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentSortBinding.tbProgress);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.inbox);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.item_sort:
                taskViewModel.navigationTaskEvent(2);
//                getChildFragmentManager().beginTransaction().add(R.id.cl_container, new SortFilterFragment(), "sort").addToBackStack("sort").commit();
                break;
            case android.R.id.home:
//                taskViewModel.navigationTaskEvent(7);
                getActivity().finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void setTitle(int progressTitle) {
        switch (progressTitle) {

            case 0:
                fragmentSortBinding.tvSortTitle.setText(getString(R.string.priority));
                break;
            case 1:
                fragmentSortBinding.tvSortTitle.setText(getString(R.string.due_date));
                break;
            case 2:
                fragmentSortBinding.tvSortTitle.setText(getString(R.string.progress));
                break;
            case 3:
                fragmentSortBinding.tvSortTitle.setText(getString(R.string.alpha_order));
                break;
            default:
                fragmentSortBinding.tvSortTitle.setText(getString(R.string.priority));
                break;
        }
    }
}