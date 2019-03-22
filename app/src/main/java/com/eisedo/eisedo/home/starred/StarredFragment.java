package com.eisedo.eisedo.home.starred;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentStarredBinding;
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

public class StarredFragment extends Fragment implements EventHandeling {

    private HomeItemViewModel homeItemViewModel;
    private FragmentStarredBinding fragmentStarredBinding;
    private ArrayList<Task> starredTasks;
    private StarredAdapter starredAdapter;

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
        fragmentStarredBinding = FragmentStarredBinding.inflate(inflater, container, false);
        fragmentStarredBinding.setHomeItmeViewModel(homeItemViewModel);
        starredTasks = new ArrayList<>();

        setUpActionbar();

        homeItemViewModel.getTaskListMutableLiveData().observe(this, tasks -> {
            this.starredTasks.clear();
            this.starredTasks.addAll(tasks);
            starredAdapter.notifyDataSetChanged();
        });

        loadTrashTasks();

        return fragmentStarredBinding.getRoot();
    }

    void setUpActionbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentStarredBinding.tbTitleBar);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.starred);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    void loadTrashTasks() {
        homeItemViewModel.getStarredTasks();
        starredAdapter = new StarredAdapter(starredTasks, getActivity(),this::onCheckChange);
        fragmentStarredBinding.rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentStarredBinding.rvItems.setAdapter(starredAdapter);
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