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

public abstract class FragmentVerifyBinding extends ViewDataBinding {
  @NonNull
  public final TextView tvVerify;

  protected FragmentVerifyBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView tvVerify) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvVerify = tvVerify;
  }

  @NonNull
  public static FragmentVerifyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentVerifyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentVerifyBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_verify, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentVerifyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentVerifyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentVerifyBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_verify, null, false, component);
  }

  public static FragmentVerifyBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentVerifyBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentVerifyBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_verify);
  }
}
