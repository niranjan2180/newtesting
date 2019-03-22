package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentForgetPasswordBinding extends ViewDataBinding {
  @NonNull
  public final TextView textView;

  protected FragmentForgetPasswordBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView textView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.textView = textView;
  }

  @NonNull
  public static FragmentForgetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentForgetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentForgetPasswordBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_forget_password, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentForgetPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentForgetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentForgetPasswordBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_forget_password, null, false, component);
  }

  public static FragmentForgetPasswordBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentForgetPasswordBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentForgetPasswordBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_forget_password);
  }
}
