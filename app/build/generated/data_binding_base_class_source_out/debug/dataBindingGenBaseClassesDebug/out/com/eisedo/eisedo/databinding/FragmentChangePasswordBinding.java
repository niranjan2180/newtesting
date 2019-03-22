package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentChangePasswordBinding extends ViewDataBinding {
  @NonNull
  public final ToolBarBinding tbChangePassword;

  @NonNull
  public final TextInputLayout textInputLayout12;

  @NonNull
  public final TextInputLayout textInputLayout6;

  @NonNull
  public final TextInputLayout textInputLayout7;

  @NonNull
  public final TextInputEditText tieConfirmPassword;

  @NonNull
  public final TextInputEditText tieCurrentPassword;

  @NonNull
  public final TextInputEditText tieNewPassword;

  @Bindable
  protected String mOldPassword;

  @Bindable
  protected String mNewPassword;

  @Bindable
  protected String mConformPassword;

  protected FragmentChangePasswordBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ToolBarBinding tbChangePassword, TextInputLayout textInputLayout12,
      TextInputLayout textInputLayout6, TextInputLayout textInputLayout7,
      TextInputEditText tieConfirmPassword, TextInputEditText tieCurrentPassword,
      TextInputEditText tieNewPassword) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tbChangePassword = tbChangePassword;
    setContainedBinding(this.tbChangePassword);;
    this.textInputLayout12 = textInputLayout12;
    this.textInputLayout6 = textInputLayout6;
    this.textInputLayout7 = textInputLayout7;
    this.tieConfirmPassword = tieConfirmPassword;
    this.tieCurrentPassword = tieCurrentPassword;
    this.tieNewPassword = tieNewPassword;
  }

  public abstract void setOldPassword(@Nullable String oldPassword);

  @Nullable
  public String getOldPassword() {
    return mOldPassword;
  }

  public abstract void setNewPassword(@Nullable String newPassword);

  @Nullable
  public String getNewPassword() {
    return mNewPassword;
  }

  public abstract void setConformPassword(@Nullable String conformPassword);

  @Nullable
  public String getConformPassword() {
    return mConformPassword;
  }

  @NonNull
  public static FragmentChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChangePasswordBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_change_password, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentChangePasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChangePasswordBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_change_password, null, false, component);
  }

  public static FragmentChangePasswordBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentChangePasswordBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentChangePasswordBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_change_password);
  }
}
