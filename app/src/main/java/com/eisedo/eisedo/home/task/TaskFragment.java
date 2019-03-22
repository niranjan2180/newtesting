package com.eisedo.eisedo.home.task;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentTaskBinding;
import com.eisedo.eisedo.home.TaskAdapter;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;
import com.eisedo.eisedo.home.home_item.HomeItemsActivity;
import com.eisedo.eisedo.util.OnTaskChangeListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TaskFragment extends Fragment {

    static Context context;

    //    private RecyclerView rv_sections;
//    private ArrayList<BucketItem> bucketItems;
//    private BucketAdapter bucketAdapter;
//    private Button et_add_task;
    private HomeItemViewModel homeItemViewModel;

    private TaskViewModel taskViewModel;

    private FragmentTaskBinding fragmentTaskBinding;

    private ArrayList<Task> doFirstTasks, doLaterTasks, delegateTasks, eliminateTasks;

    private TaskAdapter doNowTaskAdapter, doLaterTaskAdapter, delegateTaskAdapter, eliminateTaskAdapter;

    public static TaskFragment taskFragment = null;

    private int project_id;

    public static TaskFragment getInstance() {
        if (taskFragment == null) {
            taskFragment = new TaskFragment();
        }
        return taskFragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_sort:
//                getChildFragmentManager().beginTransaction().add(R.id.cl_container, new SortFilterFragment(), "sort").addToBackStack("sort").commit();
                taskViewModel.navigationTaskEvent(2);
                break;
            case android.R.id.home:
//                taskViewModel.navigationTaskEvent(7);
                getActivity().finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        homeItemViewModel = HomeItemsActivity.obtainViewModel(getActivity());

        taskViewModel = TaskActivity.obtainViewModel(getActivity());

        project_id = getArguments().getInt("folder_id");

        Log.d("ProjectId", project_id + "");

        doFirstTasks = new ArrayList<>();

        doLaterTasks = new ArrayList<>();

        delegateTasks = new ArrayList<>();

        eliminateTasks = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentTaskBinding = FragmentTaskBinding.inflate(inflater, container, false);

//        fragmentInboxBinding.listFragmentTasks.tvDoNowCount.setText("55");


        homeItemViewModel.getOpenScreenMutableLiveData().observe(this, integer -> {
            Log.d("Integer", integer + " ");
        });
        setUpActionBar();

//        View view = inflater.inflate(R.layout.fragment_task, container, false);

//        ImageView iv_search = view.findViewById(R.id.iv_search);
//        iv_search.setOnClickListener(v -> {
//            Log.d("Clicked","///////clicked");
//        });

//        fragmentInboxBinding.btnAddTask.setOnClickListener(v -> homeItemViewModel.openScreen(0));
        fragmentTaskBinding.btnAddTask.setOnClickListener(v -> taskViewModel.navigationTaskEvent(1));

//        bucketItems = new ArrayList<>();

//        ArrayList<Task> tasks = new ArrayList<>();

//        bucketItems.add(new BucketItem(1, "DO NOW", tasks));
//        bucketItems.add(new BucketItem(1, "DO Later", tasks));
//        bucketItems.add(new BucketItem(1, "Delegate", tasks));
//        bucketItems.add(new BucketItem(1, "Eliminate", tasks));


//        rv_sections = view.findViewById(R.id.rv_sections);

        //TODO -- Open Task for Edit in Inbox

//        bucketAdapter = new BucketAdapter(bucketItems, getActivity(),new OnItemClickListener() {
//            @Override
//            public void onClick(Object o, int position) {
//                Task task = (Task) o;
//                homeItemViewModel.openForEdit(task.getId());
//                Log.d("CleickedL̥", position + " ");
//            }
//        });

//        rv_sections.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rv_sections.setAdapter(bucketAdapter);

        homeItemViewModel.getDoFirstTasksMutableLiveData().observe(this, new Observer<ArrayList<Task>>() {
            @Override
            public void onChanged(ArrayList<Task> tasks) {
                Log.d("ListSize", tasks.size() + " ");
                if (tasks.size() > 0) {
                    doFirstTasks.clear();
                    doFirstTasks.addAll(tasks);
                    doNowTaskAdapter.notifyDataSetChanged();
                    fragmentTaskBinding.listFragmentTasks.tvDoNowCount.setText(tasks.size() + "");
                    fragmentTaskBinding.listFragmentTasks.tvDoFirstMessage.setVisibility(View.GONE);
                    fragmentTaskBinding.listFragmentTasks.rvDoFirstTasks.setVisibility(View.VISIBLE);
                    fragmentTaskBinding.listFragmentTasks.rvDoFirstTasks.setNestedScrollingEnabled(false);
                } else {
                    fragmentTaskBinding.listFragmentTasks.tvDoNowCount.setText("0");
                    fragmentTaskBinding.listFragmentTasks.tvDoFirstMessage.setVisibility(View.VISIBLE);
                    fragmentTaskBinding.listFragmentTasks.rvDoFirstTasks.setVisibility(View.GONE);
                }
            }
        });

        homeItemViewModel.getDoLaterTasksMutableLiveData().observe(this, new Observer<ArrayList<Task>>() {
            @Override
            public void onChanged(ArrayList<Task> tasks) {

                Log.d("ListSize", tasks.size() + " ");
                if (tasks.size() > 0) {
                    doLaterTasks.clear();
                    doLaterTasks.addAll(tasks);
                    doLaterTaskAdapter.notifyDataSetChanged();
                    fragmentTaskBinding.listFragmentTasks.tvDoLaterCount.setText(doLaterTasks.size() + "");
                    fragmentTaskBinding.listFragmentTasks.tvDoLaterMessage.setVisibility(View.GONE);
                    fragmentTaskBinding.listFragmentTasks.rvDoLaterTasks.setVisibility(View.VISIBLE);
                } else {
                    fragmentTaskBinding.listFragmentTasks.tvDoLaterCount.setText("0");
                    fragmentTaskBinding.listFragmentTasks.tvDoLaterMessage.setVisibility(View.VISIBLE);
                    fragmentTaskBinding.listFragmentTasks.rvDoLaterTasks.setVisibility(View.GONE);
                }
            }
        });

        homeItemViewModel.getDelegateTasksMutableLiveData().observe(this, new Observer<ArrayList<Task>>() {
            @Override
            public void onChanged(ArrayList<Task> tasks) {
                Log.d("ListSize", tasks.size() + " ");
                if (tasks.size() > 0) {
                    delegateTasks.clear();
                    delegateTasks.addAll(tasks);
                    delegateTaskAdapter.notifyDataSetChanged();
                    fragmentTaskBinding.listFragmentTasks.tvDelegateCount.setText(tasks.size() + "");
                    fragmentTaskBinding.listFragmentTasks.tvDelegateMessage.setVisibility(View.GONE);
                    fragmentTaskBinding.listFragmentTasks.rvDelegateTasks.setVisibility(View.VISIBLE);
                } else {
                    fragmentTaskBinding.listFragmentTasks.tvDelegateCount.setText("0");
                    fragmentTaskBinding.listFragmentTasks.tvDelegateMessage.setVisibility(View.VISIBLE);
                    fragmentTaskBinding.listFragmentTasks.rvDelegateTasks.setVisibility(View.GONE);
                }
            }
        });

        homeItemViewModel.getEliminateTasksMutableLiveData().observe(this, tasks -> {
            Log.d("ListSize", tasks.size() + " ");
            if (tasks.size() > 0) {
                eliminateTasks.clear();
                eliminateTasks.addAll(tasks);
                eliminateTaskAdapter.notifyDataSetChanged();
                fragmentTaskBinding.listFragmentTasks.tvEliminateCount.setText(tasks.size() + "");
                fragmentTaskBinding.listFragmentTasks.tvEliminateMessage.setVisibility(View.GONE);
                fragmentTaskBinding.listFragmentTasks.rvEliminateTasks.setVisibility(View.VISIBLE);
            } else {
                fragmentTaskBinding.listFragmentTasks.tvEliminateCount.setText("0");
                fragmentTaskBinding.listFragmentTasks.tvEliminateMessage.setVisibility(View.VISIBLE);
                fragmentTaskBinding.listFragmentTasks.rvEliminateTasks.setVisibility(View.GONE);
            }
        });


//        homeItemViewModel.getAllTasks();

//        homeItemViewModel.getTaskListMutableLiveData().observe(getActivity(),updatedTasks ->{
//            tasks.clear();
//            tasks.addAll(updatedTasks);
//            bucketAdapter.notifyDataS etChanged();
//        } );
        return fragmentTaskBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        homeItemViewModel.getDoFirstTasks();

        homeItemViewModel.getDoLaterTasks();

        homeItemViewModel.getDelegateTask();

        homeItemViewModel.getEliminateTask();

        setDoNowTasks();

        setDoLaterTasks();

        setDelegateTasks();

        setEliminateTasks();
    }

    private void setDoNowTasks() {

        doNowTaskAdapter = new TaskAdapter(doFirstTasks, context, new OnTaskChangeListener() {
            @Override
            public void onClick(Object o, int position) {
                Task task = (Task) o;
                Log.d("Position Task", task.getTask_id() + " " + position);
                taskViewModel.editTask(task.getId());
            }

            @Override
            public void onTaskChange(Task task, int position) {
                Log.d("Position Task", position + "");
                taskViewModel.editTask(task.getId());
            }
        }, 0);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
//        layoutManager.setAutoMeasureEnabled(true);
        fragmentTaskBinding.listFragmentTasks.rvDoFirstTasks.setLayoutManager(layoutManager);
        fragmentTaskBinding.listFragmentTasks.rvDoFirstTasks.setAdapter(doNowTaskAdapter);
    }

    private void setDoLaterTasks() {

        doLaterTaskAdapter = new TaskAdapter(doLaterTasks, context, new OnTaskChangeListener() {
            @Override
            public void onClick(Object o, int position) {
                Task task = (Task) o;
                Log.d("Position Task", task.getTask_id() + " " + position);
                taskViewModel.editTask(task.getId());
            }

            @Override
            public void onTaskChange(Task task, int position) {

            }
        }, 1);
        fragmentTaskBinding.listFragmentTasks.rvDoLaterTasks.setLayoutManager(new LinearLayoutManager(context));
        fragmentTaskBinding.listFragmentTasks.rvDoLaterTasks.setAdapter(doLaterTaskAdapter);
    }

    private void setDelegateTasks() {
        delegateTaskAdapter = new TaskAdapter(delegateTasks, context, new OnTaskChangeListener() {
            @Override
            public void onClick(Object o, int position) {
                Task task = (Task) o;
                Log.d("Position Task", task.getTask_id() + " " + position);
                taskViewModel.editTask(task.getId());
            }

            @Override
            public void onTaskChange(Task task, int position) {
                delegateTasks.remove(position);
                delegateTaskAdapter.notifyDataSetChanged();
            }
        }, 2);
        fragmentTaskBinding.listFragmentTasks.rvDelegateTasks.setLayoutManager(new LinearLayoutManager(context));
        fragmentTaskBinding.listFragmentTasks.rvDelegateTasks.setAdapter(delegateTaskAdapter);
    }

    private void setEliminateTasks() {
        eliminateTaskAdapter = new TaskAdapter(eliminateTasks, context, new OnTaskChangeListener() {
            @Override
            public void onClick(Object o, int position) {

                Task task = (Task) o;
                Log.d("Position Task", task.getTask_id() + " " + position);
                taskViewModel.editTask(task.getId());
            }

            @Override
            public void onTaskChange(Task task, int position) {

            }
        }, 3);
        fragmentTaskBinding.listFragmentTasks.rvEliminateTasks.setLayoutManager(new LinearLayoutManager(context));
        fragmentTaskBinding.listFragmentTasks.rvEliminateTasks.setAdapter(eliminateTaskAdapter);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void setUpActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentTaskBinding.tbHomeItem);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.inbox);
        ab.setDisplayHomeAsUpEnabled(true);
    }

}