package com.eisedo.eisedo.home.completed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.CompleteItemBinding;
import com.eisedo.eisedo.databinding.TrashItemBinding;
import com.eisedo.eisedo.util.Util;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CompletedAdapter extends RecyclerView.Adapter<CompletedAdapter.CompleteViewHolder> {

    private ArrayList<Task> taskItems;
    private Context context;

    public CompletedAdapter(ArrayList<Task> tasks, Context context) {
        this.taskItems = tasks;
        this.context = context;
    }

    @NonNull
    @Override
    public CompleteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        CompleteItemBinding completeItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.complete_item,viewGroup,false);
        return new CompleteViewHolder(completeItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CompleteViewHolder completeViewHolder, int i) {

        Task task = taskItems.get(i);
        completeViewHolder.completeItemBinding.setTaskItem(task);

        if (Util.getColorList(task.bucket,context) != null)
            completeViewHolder.completeItemBinding.cbStatus.setButtonTintList(Util.getColorList(task.bucket,context));
//        homeViewHolder.homeItemBinding.clHomeItem.setOnClickListener(v -> onItemClickListner.onClick(homeItem, i));
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

    class CompleteViewHolder extends RecyclerView.ViewHolder {
        private CompleteItemBinding completeItemBinding;

        public CompleteViewHolder(CompleteItemBinding completeItemBinding) {
            super(completeItemBinding.getRoot());
            this.completeItemBinding = completeItemBinding;
        }
    }
}
