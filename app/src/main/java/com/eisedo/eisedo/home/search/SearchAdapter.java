package com.eisedo.eisedo.home.search;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.StarredItemBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private ArrayList<Task> searchTasks;
    private static OnItemClickListener onItemClickListener;

    public SearchAdapter(ArrayList<Task> searchTasks, OnItemClickListener onItemClickListener) {
        this.searchTasks = searchTasks;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        StarredItemBinding starredItemBinding = StarredItemBinding.inflate(layoutInflater,parent,false);
        return new SearchViewHolder(starredItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder searchViewHolder, int position) {
        Task task = searchTasks.get(position);
        searchViewHolder.starredItemBinding.setTaskStarred(task);
//        listViewHolder.listItemBinding.clContainer.setOnClickListener(
//                v -> onItemClickListener.onClick(checkList,position)
//        );
    }

    @Override
    public int getItemCount() {
        return searchTasks.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {

        private StarredItemBinding starredItemBinding;

        public SearchViewHolder(StarredItemBinding starredItemBinding) {
            super(starredItemBinding.getRoot());
            this.starredItemBinding= starredItemBinding;
        }
    }
}