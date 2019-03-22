package com.eisedo.eisedo.home.overdue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.OverDueItemBinding;
import com.eisedo.eisedo.util.Util;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class OverdueAdapter extends RecyclerView.Adapter<OverdueAdapter.OverDueViewHolder> {

    private ArrayList<Task> taskItems;
    private Context context;

    public OverdueAdapter(ArrayList<Task> tasks, Context context) {
        this.taskItems = tasks;
        this.context = context;
    }

    @NonNull
    @Override
    public OverDueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        OverDueItemBinding overDueItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.over_due_item,viewGroup,false);
        return new OverDueViewHolder(overDueItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OverDueViewHolder overDueViewHolder, int i) {

        Task task = taskItems.get(i);
        overDueViewHolder.overDueItemBinding.setTaskOverDue(task);

        if (Util.getColorList(task.bucket,context) != null)
            overDueViewHolder.overDueItemBinding.cbStatus.setButtonTintList(Util.getColorList(task.bucket,context));

        overDueViewHolder.overDueItemBinding.tvOverDue.setText((task.getDue_date() == null ? "" : Util.diaplayDateMon(task.getDue_date())));
        //        homeViewHolder.homeItemBinding.clHomeItem.setOnClickListener(v -> onItemClickListner.onClick(homeItem, i));
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

    class OverDueViewHolder extends RecyclerView.ViewHolder {
        private OverDueItemBinding overDueItemBinding;

        public OverDueViewHolder(OverDueItemBinding overDueItemBinding) {
            super(overDueItemBinding.getRoot());
            this.overDueItemBinding = overDueItemBinding;
        }
    }
}
