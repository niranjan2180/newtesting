package com.eisedo.eisedo.home.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.data.HomeItem;
import com.eisedo.eisedo.databinding.HomeItemBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<HomeItem> homeItems;
    private static OnItemClickListener onItemClickListener;

    public HomeAdapter(ArrayList<HomeItem> homeItems, OnItemClickListener onItemClickListener) {
        this.homeItems = homeItems;
        this.onItemClickListener = onItemClickListener;
    }

//    @BindingAdapter("onHomeItemClick")
//    public static void onHomeItemClick(int position){
//        onItemClickListener.onClick(null, position);
//
//    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        HomeItemBinding homeItemBinding = HomeItemBinding.inflate(layoutInflater, parent, false);
        return new HomeAdapter.HomeViewHolder(homeItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int position) {
        HomeItem homeItem = homeItems.get(position);
        homeViewHolder.homeItemBinding.setHomeItem(homeItem);
        homeViewHolder.homeItemBinding.setPosition(position);
        homeViewHolder.homeItemBinding.clHomeItem.setOnClickListener(
                v -> onItemClickListener.onClick(null,position)
        );
//        homeViewHolder.homeItemBinding.setOnItemClick(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        private HomeItemBinding homeItemBinding;

        public HomeViewHolder(HomeItemBinding homeItemBinding) {
            super(homeItemBinding.getRoot());
            this.homeItemBinding = homeItemBinding;
        }
    }
}