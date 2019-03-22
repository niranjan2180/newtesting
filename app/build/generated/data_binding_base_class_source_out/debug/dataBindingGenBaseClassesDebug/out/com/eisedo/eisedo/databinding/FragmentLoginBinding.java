package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.login.LoginHandler;
import com.eisedo.eisedo.login.LoginViewModel;

public abstract class FragmentLoginBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSubmit;

  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etPassword;

  @NonNull
  public final ImageView ivIcon;

  @NonNull
  public final TextView tvForgetPassword;

  @NonNull
  public final TextView tvRegister;

  @Bindable
  protected LoginViewModel mLoginvm;

  @Bindable
  protected LoginHandler mHandler;

  protected FragmentLoginBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnSubmit, ConstraintLayout clContainer, EditText etEmail,
      EditText etPassword, ImageView ivIcon, TextView tvForgetPassword, TextView tvRegister) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSubmit = btnSubmit;
    this.clContainer = clContainer;
    this.etEmail = etEmail;
    this.etPassword = etPassword;
    this.ivIcon = ivIcon;
    this.tvForgetPassword = tvForgetPassword;
    this.tvRegister = tvRegister;
  }

  public abstract void setLoginvm(@Nullable LoginViewModel loginvm);

  @Nullable
  public LoginViewModel getLoginvm() {
    return mLoginvm;
  }

  public abstract void setHandler(@Nullable LoginHandler handler);

  @Nullable
  public LoginHandler getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentLoginBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_login, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentLoginBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_login, null, false, component);
  }

  public static FragmentLoginBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentLoginBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentLoginBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_login);
  }
}
