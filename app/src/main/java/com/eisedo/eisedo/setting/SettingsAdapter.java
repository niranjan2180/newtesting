package com.eisedo.eisedo.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.SettingItem;
import com.eisedo.eisedo.databinding.SettingsItemBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingViewHolder>{

    private ArrayList<SettingItem> settingItems;

    private Context context;

    private OnItemClickListener onItemClickListener;

    public SettingsAdapter(ArrayList<SettingItem> settingItems, Context context, OnItemClickListener onItemClickListener) {
        this.settingItems = settingItems;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public SettingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        SettingsItemBinding settingsItemBinding  = DataBindingUtil.inflate(layoutInflater,R.layout.settings_item,viewGroup,false);
        return new SettingViewHolder(settingsItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingViewHolder settingViewHolder, int i) {
        SettingItem settingItem = settingItems.get(i);
        settingViewHolder.settingsItemBinding.setSettingItem(settingItem);
        settingViewHolder.settingsItemBinding.clSetting.setOnClickListener(v -> onItemClickListener.onClick(settingItem,i));
    }

    @Override
    public int getItemCount() {
        return settingItems.size();
    }

    class SettingViewHolder extends RecyclerView.ViewHolder{
        private SettingsItemBinding settingsItemBinding;

        public SettingViewHolder(SettingsItemBinding settingsItemBinding) {
            super(settingsItemBinding.getRoot());
            this.settingsItemBinding = settingsItemBinding;
        }
    }
}
