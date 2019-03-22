package com.eisedo.eisedo.home.sort;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.data.local.entities.SortFilter;
import com.eisedo.eisedo.databinding.SortFilterItemBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SortFilterAdapter extends RecyclerView.Adapter<SortFilterAdapter.SortFilterViewHolder> {

    private ArrayList<SortFilter> sortFilters;
    private static OnItemClickListener onItemClickListener;

    public SortFilterAdapter(ArrayList<SortFilter> sortFilters, OnItemClickListener onItemClickListener) {
        this.sortFilters = sortFilters;
        this.onItemClickListener = onItemClickListener;
    }

//    @BindingAdapter("onHomeItemClick")
//    public static void onHomeItemClick(int position){
//        onItemClickListener.onClick(null, position);
//
//    }

    @NonNull
    @Override
    public SortFilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        SortFilterItemBinding sortFilterItemBinding = SortFilterItemBinding.inflate(layoutInflater,parent,false);
        return new SortFilterAdapter.SortFilterViewHolder(sortFilterItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SortFilterViewHolder sortFilterViewHolder, int position) {
        SortFilter sortFilter = sortFilters.get(position);
        sortFilterViewHolder.sortFilterItemBinding.setSortFilter(sortFilter);
        sortFilterViewHolder.sortFilterItemBinding.setPosition(position);
        sortFilterViewHolder.sortFilterItemBinding.clSortFilterItem.setOnClickListener(
                v -> onItemClickListener.onClick(null,position)
        );
//        homeViewHolder.homeItemBinding.setOnItemClick(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return sortFilters.size();
    }

    class SortFilterViewHolder extends RecyclerView.ViewHolder {

        private SortFilterItemBinding sortFilterItemBinding;

        public SortFilterViewHolder(SortFilterItemBinding sortFilterItemBinding) {
            super(sortFilterItemBinding.getRoot());
            this.sortFilterItemBinding = sortFilterItemBinding;
        }
    }
}