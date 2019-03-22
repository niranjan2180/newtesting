package com.eisedo.eisedo.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.BucketItem;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.util.OnItemClickListener;
import com.eisedo.eisedo.util.OnTaskChangeListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BucketAdapter extends RecyclerView.Adapter<BucketAdapter.BucketViewHolder>{

    private ArrayList<BucketItem> bucketItems;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public BucketAdapter(ArrayList<BucketItem> bucketItems, Context context, OnItemClickListener onItemClickListener) {
        this.bucketItems = bucketItems;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public BucketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = null;
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        View view = layoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bucket_item, viewGroup, false);

        return new BucketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketViewHolder bucketViewHolder, int i) {
        BucketItem bucketItem = bucketItems.get(i);

        bucketViewHolder.tv_title.setText(bucketItem.getBucketTitle());
        bucketViewHolder.tv_count.setText(bucketItem.getBucketCount()+"");

        bucketViewHolder.rv_tasks.setLayoutManager(new LinearLayoutManager(context));
        TaskAdapter taskAdapter = new TaskAdapter(bucketItem.getTasks(), context, new OnTaskChangeListener() {
            @Override
            public void onClick(Object o, int position) {
                onItemClickListener.onClick(o,position);
            }

            @Override
            public void onTaskChange(Task task, int position) {

            }
        },0);
        bucketViewHolder.rv_tasks.setAdapter(taskAdapter);

    }

    @Override
    public int getItemCount() {
        return bucketItems.size();
    }

    class BucketViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_title, tv_count;
        private RecyclerView rv_tasks;
        public BucketViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_count = itemView.findViewById(R.id.tv_count);
            rv_tasks = itemView.findViewById(R.id.rv_tasks);
        }

    }
}
