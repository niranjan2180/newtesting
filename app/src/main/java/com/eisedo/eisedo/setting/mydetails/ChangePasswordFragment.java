package com.eisedo.eisedo.setting.mydetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.databinding.FragmentChangePasswordBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class ChangePasswordFragment extends Fragment {

    private FragmentChangePasswordBinding fragmentChangePasswordBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentChangePasswordBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_password, container, false);

        setUpActionBar();

        return fragmentChangePasswordBinding.getRoot();
    }

    private void setUpActionBar() {

        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentChangePasswordBinding.tbChangePassword.tbTitle);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.change_password);
        ab.setDisplayHomeAsUpEnabled(true);
    }
}
