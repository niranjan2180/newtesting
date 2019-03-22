package com.eisedo.eisedo.home.sort;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.data.local.entities.SortFilter;
import com.eisedo.eisedo.databinding.FragmentFilterSortBinding;
import com.eisedo.eisedo.home.task.TaskActivity;
import com.eisedo.eisedo.home.task.TaskViewModel;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SortFilterFragment extends Fragment implements OnItemClickListener {

    public static SortFilterFragment sortFilterFragment = null;

    public static SortFilterFragment getInstance() {
        if (sortFilterFragment == null) {
            sortFilterFragment = new SortFilterFragment();
        }
        return sortFilterFragment;
    }

    private FragmentFilterSortBinding fragmentFilterSortBinding;

    private TaskViewModel taskViewModel;

    private ArrayList<SortFilter> sortFilters;

    @BindingAdapter("setSortFilterItems")
    public static void setItems(RecyclerView recyclerView, ArrayList<SortFilter> sortFilters) {
        if (sortFilters != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentFilterSortBinding = FragmentFilterSortBinding.inflate(inflater, container, false);

        setRetainInstance(true);

        taskViewModel = TaskActivity.obtainViewModel(getActivity());

        taskViewModel.getFilterSortMutableLiveData().observe(this, sortFilters1 -> {
            this.sortFilters.clear();
            this.sortFilters.addAll(sortFilters1);
            fragmentFilterSortBinding.setFilterList(sortFilters1);
        });

        taskViewModel.getSortSingleLiveDataEvent();

        sortFilters = new ArrayList<>();

        taskViewModel.getFilterList(getActivity());

        setFilterSortAdapter();

        return fragmentFilterSortBinding.getRoot();
    }

    void setFilterSortAdapter() {
        SortFilterAdapter sortFilterAdapter = new SortFilterAdapter(sortFilters, this);
        fragmentFilterSortBinding.rvSorts.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentFilterSortBinding.rvSorts.setAdapter(sortFilterAdapter);
    }

    @Override
    public void onClick(Object o, int position) {
        Log.d("ProgressType", position + " ");
        taskViewModel.setSortType(position);
    }
}
