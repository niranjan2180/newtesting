package com.eisedo.eisedo.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.databinding.FragmentLoginBinding;
import com.eisedo.eisedo.home.HomeActivity;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment implements LoginHandler {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        loginViewModel = LoginActivity.obtainViewModel(getActivity());
        loginViewModel.getLoginLiveData().observe(getActivity(), bool -> moveToMainScreen());
        loginViewModel.getMessage().observe(getActivity(), string -> showSnackMessage(string));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentLoginBinding fragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false);
        fragmentLoginBinding.setLoginvm(loginViewModel);
        fragmentLoginBinding.setHandler(this);

        fragmentLoginBinding.tvForgetPassword.setOnClickListener(v -> Log.d("Forget","Click"));

        return fragmentLoginBinding.getRoot();
    }

    private void moveToMainScreen() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void showSnackMessage(String errorText) {
        Snackbar.make(getView(), errorText, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onclick(LoginViewModel loginViewModel) {
        this.loginViewModel.loginClick();
    }
}