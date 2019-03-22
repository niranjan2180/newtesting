package com.eisedo.eisedo.home.overdue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentOverdueBinding;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;
import com.eisedo.eisedo.home.home_item.HomeItemsActivity;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class OverdueFragment extends Fragment {
    private HomeItemViewModel homeItemViewModel;
    private FragmentOverdueBinding fragmentOverdueBinding;

    private ArrayList<Task> overDueTasks;

    private OverdueAdapter overdueAdapter;

    @Override
    public void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeItemViewModel = HomeItemsActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        fragmentOverdueBinding = FragmentOverdueBinding.inflate(inflater,container,false);
        fragmentOverdueBinding.setHomeItmeViewModel(homeItemViewModel);
        overDueTasks = new ArrayList<>();

        setUpActionbar();

        homeItemViewModel.getTaskListMutableLiveData().observe(this, tasks -> {
            this.overDueTasks.clear();
            this.overDueTasks.addAll(tasks);
            overdueAdapter.notifyDataSetChanged();
        });

        loadOverDueTasks();

        return fragmentOverdueBinding.getRoot();
    }

    void setUpActionbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentOverdueBinding.tbTitleBar);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.overdue);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    void loadOverDueTasks() {
        Date date = new Date();
        homeItemViewModel.getOverDueTasks(date);
        overdueAdapter = new OverdueAdapter(overDueTasks, getActivity());
        fragmentOverdueBinding.rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentOverdueBinding.rvItems.setAdapter(overdueAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.edit_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
