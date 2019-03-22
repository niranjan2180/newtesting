package com.eisedo.eisedo.home.delegated;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.DelegateItemBinding;
import com.eisedo.eisedo.util.OnTaskSelectedListener;
import com.eisedo.eisedo.util.Util;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class DelegateAdapter extends RecyclerView.Adapter<DelegateAdapter.DelegateViewHolder> {

    private ArrayList<Task> taskItems;
    private Context context;
    private OnTaskSelectedListener onTaskSelectedListener;

    public DelegateAdapter(ArrayList<Task> tasks, Context context, OnTaskSelectedListener onTaskSelectedListener) {
        this.taskItems = tasks;
        this.context = context;
        this.onTaskSelectedListener = onTaskSelectedListener;
    }

    @NonNull
    @Override
    public DelegateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        DelegateItemBinding delegateItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.delegate_item,viewGroup,false);
        return new DelegateViewHolder(delegateItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DelegateViewHolder delegateViewHolder, int i) {

        Task task = taskItems.get(i);
        delegateViewHolder.delegateItemBinding.setTaskDelegate(task);

        if (Util.getColorList(task.bucket,context) != null)
            delegateViewHolder.delegateItemBinding.cbStatus.setButtonTintList(Util.getColorList(task.bucket,context));

        delegateViewHolder.delegateItemBinding.cbStatus.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> onTaskSelectedListener.onTaskCompleted(task,i));
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

    class DelegateViewHolder extends RecyclerView.ViewHolder {
        private DelegateItemBinding delegateItemBinding;

        public DelegateViewHolder(DelegateItemBinding delegateItemBinding) {
            super(delegateItemBinding.getRoot());
            this.delegateItemBinding = delegateItemBinding;
        }
    }
}
