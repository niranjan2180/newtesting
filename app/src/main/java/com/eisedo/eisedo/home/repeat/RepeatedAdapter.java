package com.eisedo.eisedo.home.repeat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.StarredItemBinding;
import com.eisedo.eisedo.util.EventHandeling;
import com.eisedo.eisedo.util.Util;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RepeatedAdapter extends RecyclerView.Adapter<RepeatedAdapter.RepeatedViewHolder> {

    private ArrayList<Task> taskItems;
    private Context context;
    private EventHandeling eventHandeling;

    public RepeatedAdapter(ArrayList<Task> tasks, Context context, EventHandeling eventHandeling) {
        this.taskItems = tasks;
        this.context = context;
        this.eventHandeling = eventHandeling;
    }

    @NonNull
    @Override
    public RepeatedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        StarredItemBinding starredItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.starred_item,viewGroup,false);
        return new RepeatedViewHolder(starredItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepeatedViewHolder starredViewHolder, int i) {

        Task task = taskItems.get(i);
//        EventHandeling eventHandeling = new EventHandeling() {
//            @Override
//            public void onCheckChange(boolean value) {

//                eventHandeling.onCheckChange(value);
//                Log.d("VAluesCHEd", value + "");
//            }
//        };

        Log.d("StarredDate", task.getDue_date() + "" );
        starredViewHolder.starredItemBinding.setTaskStarred(task);
        starredViewHolder.starredItemBinding.setEventHandel(eventHandeling);

        if (Util.getColorList(task.bucket,context) != null)
            starredViewHolder.starredItemBinding.cbStatus.setButtonTintList(Util.getColorList(task.bucket,context));

        starredViewHolder.starredItemBinding.tvDate.setText((task.getDue_date() == null ? "" : Util.diaplayDateMon(task.getDue_date())));
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

    class RepeatedViewHolder extends RecyclerView.ViewHolder {
        private StarredItemBinding starredItemBinding;

        public RepeatedViewHolder(StarredItemBinding starredItemBinding) {
            super(starredItemBinding.getRoot());
            this.starredItemBinding = starredItemBinding;
        }
    }
}
