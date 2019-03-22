package com.eisedo.eisedo.home.trash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentTrashBinding;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;
import com.eisedo.eisedo.home.home_item.HomeItemsActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class TrashFragment extends Fragment {

    private HomeItemViewModel homeItemViewModel;
    private FragmentTrashBinding fragmentTrashBinding;

    private ArrayList<Task> trashedTasks;

    private TrashAdapter trashAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeItemViewModel = HomeItemsActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        fragmentTrashBinding = FragmentTrashBinding.inflate(inflater, container, false);
        fragmentTrashBinding.setHomeItemModel(homeItemViewModel);
        trashedTasks = new ArrayList<>();

        setUpActionBar();

        homeItemViewModel.getTaskListMutableLiveData().observe(this, tasks -> {
            tasks.clear();
            this.trashedTasks.addAll(tasks);
            trashAdapter.notifyDataSetChanged();
        });

        loadTrashTasks();

        return fragmentTrashBinding.getRoot();
    }

    void setUpActionBar(){
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentTrashBinding.tbHomeItem);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.trash);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    void loadTrashTasks() {
        homeItemViewModel.getTrashTasks();
        trashAdapter = new TrashAdapter(trashedTasks, getActivity(),(Object o, int position) -> {});
        fragmentTrashBinding.rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentTrashBinding.rvItems.setAdapter(trashAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.edit_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
