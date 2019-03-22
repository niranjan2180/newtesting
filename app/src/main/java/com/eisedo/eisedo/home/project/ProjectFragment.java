package com.eisedo.eisedo.home.project;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.home.TaskAdapter;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;
import com.eisedo.eisedo.home.home_item.HomeItemsActivity;
import com.eisedo.eisedo.util.OnTaskChangeListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectFragment extends Fragment {

    private HomeItemViewModel homeItemViewModel;

    private RecyclerView rv_do_now_tasks, rv_do_later_tasks;

    private TaskAdapter taskAdapter;

    private ArrayList<Task> tasks;

    private Context context;

//    private FragmentProjectBinding fragmentProjectBinding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeItemViewModel = HomeItemsActivity.obtainViewModel(getActivity());
        setHasOptionsMenu(true);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project, container, false);

//        fragmentProjectBinding = DataBindingUtil.getBinding(view);

        Folder folder = new Folder("Folder 1", 0, false);

        Folder folder1 = new Folder(" Floder 2", 0, false);
        Folder folder3 = new Folder(" Floder 3", 0, false);


        homeItemViewModel.addFolder(folder);
        homeItemViewModel.addFolder(folder1);
        homeItemViewModel.addFolder(folder3);


        tasks = new ArrayList<>();

        homeItemViewModel.getAllTasks();

        taskAdapter = new TaskAdapter(tasks, context, new OnTaskChangeListener() {
            @Override
            public void onClick(Object o, int position) {
                Task task = (Task) o;
                homeItemViewModel.openForEdit(task.getId());
                Log.d("CleickedL̥", position + " ");
            }

            @Override
            public void onTaskChange(Task task, int position) {

            }
        },0);


        rv_do_now_tasks = view.findViewById(R.id.rv_do_now_tasks);
        rv_do_now_tasks.setLayoutManager(new LinearLayoutManager(context));
        rv_do_now_tasks.setAdapter(taskAdapter);

        rv_do_later_tasks = view.findViewById(R.id.rv_do_later_tasks);
        rv_do_later_tasks.setLayoutManager(new LinearLayoutManager(context));
        rv_do_later_tasks.setAdapter(taskAdapter);

        homeItemViewModel.getTaskListMutableLiveData().observe(getActivity(), updatedTasks -> {
//            tasks.clear();
//            tasks.addAll(updatedTasks);
//            taskAdapter.notifyDataSetChanged();
        });


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

//    @Override
//    public void onClick(Object o, int position) {
//        Task task = (Task) o;
//        homeItemViewModel.openForEdit(task.getId());
//    }
}
