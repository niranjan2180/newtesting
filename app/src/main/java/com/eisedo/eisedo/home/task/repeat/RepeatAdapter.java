package com.eisedo.eisedo.home.task.repeat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.RepeatType;
import com.eisedo.eisedo.databinding.RepeatItemBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RepeatAdapter extends RecyclerView.Adapter<RepeatAdapter.RepeatViewHolder> {

    private ArrayList<RepeatType> repeatItems;
    private static OnItemClickListener onItemClickListener;
    private int position;

    public RepeatAdapter(ArrayList<RepeatType> repeatItems, OnItemClickListener onItemClickListener,int position) {
        this.repeatItems = repeatItems;
        this.onItemClickListener= onItemClickListener;
        this.position = position;
    }

    @NonNull
    @Override
    public RepeatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        RepeatItemBinding repeatItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.repeat_item,viewGroup,false);
        return new RepeatViewHolder(repeatItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepeatViewHolder repeatViewHolder, int i) {
        RepeatType repeatType = repeatItems.get(i);
        repeatViewHolder.repeatItemBinding.setRepeatType(repeatType);
        repeatViewHolder.repeatItemBinding.setSelectedPosition(( position-1 == i ? 1 : 0));
        repeatViewHolder.repeatItemBinding.clContainer.setOnClickListener(
                v -> onItemClickListener.onClick(repeatType,i)
        );
    }

    @Override
    public int getItemCount() {
        return repeatItems.size();
    }

    class RepeatViewHolder extends RecyclerView.ViewHolder {
        private RepeatItemBinding repeatItemBinding;

        public RepeatViewHolder(RepeatItemBinding repeatItemBinding) {
            super(repeatItemBinding.getRoot());
            this.repeatItemBinding = repeatItemBinding;
        }
    }
}
