package com.eisedo.eisedo.home.completed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentCompleteBinding;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;
import com.eisedo.eisedo.home.home_item.HomeItemsActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CompletedFragment extends Fragment {

    private HomeItemViewModel homeItemViewModel;
    private FragmentCompleteBinding fragmentCompleteBinding;

    private ArrayList<Task> completedTasks;

    private CompletedAdapter completedAdapter;

    @Override
    public void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeItemViewModel = HomeItemsActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        fragmentCompleteBinding = FragmentCompleteBinding.inflate(inflater,container,false);
        fragmentCompleteBinding.setHomeItmeViewModel(homeItemViewModel);
        completedTasks = new ArrayList<>();

        setUpActionBar();

        homeItemViewModel.getTaskListMutableLiveData().observe(this, tasks -> {
            this.completedTasks.clear();
            this.completedTasks.addAll(tasks);
            completedAdapter.notifyDataSetChanged();
        });

        loadTrashTasks();

        return fragmentCompleteBinding.getRoot();
    }

    void loadTrashTasks() {
        homeItemViewModel.getCompletedTasks();
        completedAdapter = new CompletedAdapter(completedTasks, getActivity());
        fragmentCompleteBinding.rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentCompleteBinding.rvItems.setAdapter(completedAdapter);
    }

    void setUpActionBar(){
        Toolbar toolbar = fragmentCompleteBinding.tbTitleBar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.completed);
        ab.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.edit_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
