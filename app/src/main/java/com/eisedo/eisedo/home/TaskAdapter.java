package com.eisedo.eisedo.home;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.util.OnTaskChangeListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Task> tasks;
    private Context context;
    private OnTaskChangeListener onTaskChangeListener;
    private int bucletType;

    public TaskAdapter(ArrayList<Task> tasks, Context context, OnTaskChangeListener onTaskChangeListener, int bucket) {
        this.tasks = tasks;
        this.context = context;
        this.onTaskChangeListener = onTaskChangeListener;
        this.bucletType = bucket;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        View view = layoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.task_item, viewGroup, false);

        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int i) {
        Task task = tasks.get(i);
        taskViewHolder.cb_task.setChecked(task.isStar());

        ColorStateList myColorStateList = null;

        switch (bucletType) {

            case 0:
                myColorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_window_focused},
                        },
                        new int[]{
                                context.getResources().getColor(R.color.green),
                        }
                );
                break;
            case 1:
                myColorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_window_focused},
                        },
                        new int[]{
                                context.getResources().getColor(R.color.blue_light),
                        }
                );
                break;
            case 2:
                myColorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_window_focused},
                        },
                        new int[]{
                                context.getResources().getColor(R.color.orange),
                        }
                );
                break;
            case 3:
                myColorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_window_focused},
                        },
                        new int[]{
                                context.getResources().getColor(R.color.red_light),
                        }
                );
                break;
            default:
                break;
        }

        if (myColorStateList != null)
            taskViewHolder.cb_task.setButtonTintList(myColorStateList);

//        taskViewHolder.cb_task.setButtonTintList();

        int starred = (task.isStar() ? R.drawable.ic_star_border : R.drawable.ic_star);
        taskViewHolder.iv_starred.setImageDrawable(context.getDrawable(starred));
        taskViewHolder.tv_task_name.setText(task.getTitle());

        taskViewHolder.tv_task_name.setOnClickListener(v -> {
            Log.d("avlues", "clicekdc");
            onTaskChangeListener.onClick(task, i);
        });

        taskViewHolder.cb_task.setOnCheckedChangeListener((buttonView, isChecked) ->  onTaskChangeListener.onTaskChange(task,i));

        taskViewHolder.cl_container.setOnClickListener(v -> onTaskChangeListener.onClick(task,i));

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        private CheckBox cb_task;
        private ImageView iv_starred;
        private TextView tv_time, tv_task_name;
        private ConstraintLayout cl_container;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_task_name = itemView.findViewById(R.id.tv_task_name);
            tv_time = itemView.findViewById(R.id.tv_time);
            iv_starred = itemView.findViewById(R.id.iv_starred);
            cb_task = itemView.findViewById(R.id.cb_task);
            cl_container = itemView.findViewById(R.id.cl_container);
        }
    }
}
