package com.eisedo.eisedo.home.lists;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.data.local.entities.CheckList;
import com.eisedo.eisedo.databinding.ListItemBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private ArrayList<CheckList> checkLists;
    private static OnItemClickListener onItemClickListener;

    public ListAdapter(ArrayList<CheckList> checkLists, OnItemClickListener onItemClickListener) {
        this.checkLists = checkLists;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ListItemBinding listItemBinding = ListItemBinding.inflate(layoutInflater,parent,false);
        return new ListAdapter.ListViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int position) {
        CheckList checkList = checkLists.get(position);
        listViewHolder.listItemBinding.setCheckItem(checkList);
        listViewHolder.listItemBinding.clContainer.setOnClickListener(
                v -> onItemClickListener.onClick(checkList,position)
        );
    }

    @Override
    public int getItemCount() {
        return checkLists.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        private ListItemBinding listItemBinding;

        public ListViewHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;
        }
    }
}