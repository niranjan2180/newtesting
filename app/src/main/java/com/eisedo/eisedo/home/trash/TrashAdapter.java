package com.eisedo.eisedo.home.trash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.TrashItemBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class TrashAdapter extends RecyclerView.Adapter<TrashAdapter.TrashViewHolder> {

    private ArrayList<Task> taskItems;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public TrashAdapter(ArrayList<Task> tasks, Context context, OnItemClickListener onItemClickListener) {
        this.taskItems = tasks;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TrashViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        TrashItemBinding trashItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.trash_item,viewGroup,false);
        return new TrashViewHolder(trashItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrashViewHolder trashViewHolder, int i) {

        Task task = taskItems.get(i);
        trashViewHolder.trashItemBinding.setTaskItem(task);
        trashViewHolder.trashItemBinding.ivDelete.setOnClickListener(v-> onItemClickListener.onClick(task,i));
//        homeViewHolder.homeItemBinding.clHomeItem.setOnClickListener(v -> onItemClickListner.onClick(homeItem, i));
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

    class TrashViewHolder extends RecyclerView.ViewHolder {
        private TrashItemBinding trashItemBinding;

        public TrashViewHolder(TrashItemBinding trashItemBinding) {
            super(trashItemBinding.getRoot());
            this.trashItemBinding = trashItemBinding;
        }
    }
}
