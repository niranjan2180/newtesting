package com.eisedo.eisedo.home.repeat;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentRepeatedBinding;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;
import com.eisedo.eisedo.home.home_item.HomeItemsActivity;
import com.eisedo.eisedo.util.EventHandeling;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class RepeatedFragment extends Fragment implements EventHandeling {

    private HomeItemViewModel homeItemViewModel;
    private FragmentRepeatedBinding fragmentRepeatedBinding;
    private ArrayList<Task> repeatedTasks;
    private RepeatedAdapter repeatedAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        homeItemViewModel = HomeItemsActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        fragmentRepeatedBinding = FragmentRepeatedBinding.inflate(inflater, container, false);
        fragmentRepeatedBinding.setHomeItmeViewModel(homeItemViewModel);
        repeatedTasks = new ArrayList<>();

        setUpActionbar();

        homeItemViewModel.getTaskListMutableLiveData().observe(this, tasks -> {
            this.repeatedTasks.clear();
            this.repeatedTasks.addAll(tasks);
            repeatedAdapter.notifyDataSetChanged();
        });

        loadRepeatTasks();

        return fragmentRepeatedBinding.getRoot();
    }

    void setUpActionbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentRepeatedBinding.tbTitleBar);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.repeat);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    void loadRepeatTasks() {
        homeItemViewModel.getRepeatedTasks();
        repeatedAdapter = new RepeatedAdapter(repeatedTasks, getActivity(),this::onCheckChange);
        fragmentRepeatedBinding.rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentRepeatedBinding.rvItems.setAdapter(repeatedAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.edit_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCheckChange(boolean value) {
        Log.d("Vale", value + " ");
    }
}