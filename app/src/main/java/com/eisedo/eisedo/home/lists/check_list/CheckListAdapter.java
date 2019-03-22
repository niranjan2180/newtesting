package com.eisedo.eisedo.home.lists.check_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.data.local.entities.CheckListItem;
import com.eisedo.eisedo.databinding.CheckItemBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CheckListAdapter extends RecyclerView.Adapter<CheckListAdapter.CheckListViewHolder> {

    private ArrayList<CheckListItem> checkListItems;
    private static OnItemClickListener onItemClickListener;

    public CheckListAdapter(ArrayList<CheckListItem> checkListItems, OnItemClickListener onItemClickListener) {
        this.checkListItems = checkListItems;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CheckListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CheckItemBinding checkItemBinding = CheckItemBinding.inflate(layoutInflater,parent,false);
        return new CheckListViewHolder(checkItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckListViewHolder checkListViewHolder, int position) {
        CheckListItem checkListItem = checkListItems.get(position);
        checkListViewHolder.checkItemBinding.setCheckListItem(checkListItem);
        checkListViewHolder.checkItemBinding.clContainer.setOnClickListener(v -> onItemClickListener.onClick(checkListItem, position));
    }

    @Override
    public int getItemCount() {
        return checkListItems.size();
    }

    class CheckListViewHolder extends RecyclerView.ViewHolder {

        private CheckItemBinding checkItemBinding;

        public CheckListViewHolder(CheckItemBinding checkItemBinding) {
            super(checkItemBinding.getRoot());
            this.checkItemBinding = checkItemBinding;
        }
    }
}