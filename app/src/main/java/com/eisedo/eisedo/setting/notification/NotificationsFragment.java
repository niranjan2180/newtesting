package com.eisedo.eisedo.setting.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.eisedo.eisedo.R;
import com.eisedo.eisedo.databinding.FragmentNotificationsBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding fragmentNotificationsBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentNotificationsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_notifications, container, false);

        setUpActionBar();
        return fragmentNotificationsBinding.getRoot();
    }

    private void setUpActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentNotificationsBinding.tbNotification.tbTitle);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.notification);
        ab.setDisplayHomeAsUpEnabled(true);
    }
}