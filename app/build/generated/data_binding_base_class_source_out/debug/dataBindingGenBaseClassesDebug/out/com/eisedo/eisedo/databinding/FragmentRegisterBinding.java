package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentRegisterBinding extends ViewDataBinding {
  @NonNull
  public final Button btnRegister;

  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final TextInputLayout textInputLayout17;

  @NonNull
  public final TextInputLayout textInputLayout19;

  @NonNull
  public final TextInputLayout textInputLayout20;

  @NonNull
  public final TextInputEditText tieEmail;

  @NonNull
  public final TextInputEditText tieName;

  @NonNull
  public final TextInputEditText tiePassword;

  @Bindable
  protected String mUserName;

  @Bindable
  protected String mEmail;

  @Bindable
  protected String mPassword;

  protected FragmentRegisterBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnRegister, ConstraintLayout clContainer,
      TextInputLayout textInputLayout17, TextInputLayout textInputLayout19,
      TextInputLayout textInputLayout20, TextInputEditText tieEmail, TextInputEditText tieName,
      TextInputEditText tiePassword) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnRegister = btnRegister;
    this.clContainer = clContainer;
    this.textInputLayout17 = textInputLayout17;
    this.textInputLayout19 = textInputLayout19;
    this.textInputLayout20 = textInputLayout20;
    this.tieEmail = tieEmail;
    this.tieName = tieName;
    this.tiePassword = tiePassword;
  }

  public abstract void setUserName(@Nullable String userName);

  @Nullable
  public String getUserName() {
    return mUserName;
  }

  public abstract void setEmail(@Nullable String email);

  @Nullable
  public String getEmail() {
    return mEmail;
  }

  public abstract void setPassword(@Nullable String password);

  @Nullable
  public String getPassword() {
    return mPassword;
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentRegisterBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_register, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentRegisterBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_register, null, false, component);
  }

  public static FragmentRegisterBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentRegisterBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentRegisterBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_register);
  }
}
