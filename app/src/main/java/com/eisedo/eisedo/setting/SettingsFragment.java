package com.eisedo.eisedo.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.SettingItem;
import com.eisedo.eisedo.data.local.entities.User;
import com.eisedo.eisedo.databinding.FragmentSettingsBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class SettingsFragment extends Fragment implements OnItemClickListener {

    private Context context;

    private SettingViewModel settingViewModel;

    private SettingsAdapter settingsAdapter;

    private ArrayList<SettingItem> settingItems;

    private FragmentSettingsBinding fragmentSettingsBinding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingViewModel = SettingActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false);
        fragmentSettingsBinding.setSettingViewModel(settingViewModel);

        settingItems = new ArrayList<>();

        User user = settingViewModel.getUserMutableLiveData().getValue();
        if (user != null) {
            fragmentSettingsBinding.tvTaskName.setText(user.name);
        }
        settingViewModel.getSettingsListMutableLiveData().observe(this, settingItems -> {
            this.settingItems.clear();
            this.settingItems.addAll(settingItems);
            settingsAdapter.notifyDataSetChanged();
        });

        settingViewModel.loadSettingItems();

        setUpActionBar();

        setSettingItems();
        return fragmentSettingsBinding.getRoot();
    }

    private void setSettingItems() {
        settingsAdapter = new SettingsAdapter(settingItems, context, this);
        fragmentSettingsBinding.rvSettings.setLayoutManager(new LinearLayoutManager(context));
        fragmentSettingsBinding.rvSettings.setAdapter(settingsAdapter);
    }

    private void setUpActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentSettingsBinding.tbTitle);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.setting);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(Object o, int position) {
        settingViewModel.openScreen(position);
    }
}