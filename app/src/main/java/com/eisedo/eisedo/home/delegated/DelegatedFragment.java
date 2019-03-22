package com.eisedo.eisedo.home.delegated;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentDelegatedBinding;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;
import com.eisedo.eisedo.home.home_item.HomeItemsActivity;
import com.eisedo.eisedo.util.OnTaskSelectedListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class DelegatedFragment extends Fragment {

    private HomeItemViewModel homeItemViewModel;

    private FragmentDelegatedBinding fragmentDelegatedBinding;

    private ArrayList<Task> delegatedTasks;

    private DelegateAdapter delegateAdapter;

    private OnTaskSelectedListener onTaskSelectedListener;

    @Override
    public void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        homeItemViewModel = HomeItemsActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        fragmentDelegatedBinding = FragmentDelegatedBinding.inflate(inflater, container, false);
        fragmentDelegatedBinding.setHomeItmeViewModel(homeItemViewModel);
        delegatedTasks = new ArrayList<>();

        setUpActionbar();

        homeItemViewModel.getTaskListMutableLiveData().observe(this, tasks -> {
            Log.d("DElegated","tasks" + tasks.size());
            this.delegatedTasks.clear();
            this.delegatedTasks.addAll(tasks);
            delegateAdapter.notifyDataSetChanged();
        });

        loadDelegatedTasks();

        return fragmentDelegatedBinding.getRoot();
    }

    void setUpActionbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentDelegatedBinding.tbTitleBar);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.delegated);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    void loadDelegatedTasks() {
        homeItemViewModel.getDelegatedTasks();
        delegateAdapter = new DelegateAdapter(delegatedTasks, getActivity(), new OnTaskSelectedListener() {
            @Override
            public void onTaskSelected(Task task, int position) {
                Log.d("Task",task.getTitle() + " " + position);
            }

            @Override
            public void onTaskCompleted(Task task, int position) {
                Log.d("Task",task.getTitle() + " " + position);
            }
        });
        fragmentDelegatedBinding.rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentDelegatedBinding.rvItems.setAdapter(delegateAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.edit_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
