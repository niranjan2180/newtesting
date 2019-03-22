package com.eisedo.eisedo.setting.mydetails;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.User;
import com.eisedo.eisedo.databinding.FragmentMyDetailsBinding;
import com.eisedo.eisedo.setting.SettingActivity;
import com.eisedo.eisedo.setting.SettingViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class MyDetailsFragment extends Fragment {

    private Context context;

    private FragmentMyDetailsBinding fragmentMyDetailsBinding;

    private SettingViewModel settingViewModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingViewModel = SettingActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMyDetailsBinding = FragmentMyDetailsBinding.inflate(inflater,container,false);

        User user = fragmentMyDetailsBinding.getUser();
        fragmentMyDetailsBinding.setUser(user);

        fragmentMyDetailsBinding.tiePassword.setOnClickListener(v -> settingViewModel.openScreen(7));

        setUpActionBar();

        return fragmentMyDetailsBinding.getRoot();
    }

    private void setUpActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentMyDetailsBinding.tbTitle);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.my_details);
        ab.setDisplayHomeAsUpEnabled(true);
    }
}