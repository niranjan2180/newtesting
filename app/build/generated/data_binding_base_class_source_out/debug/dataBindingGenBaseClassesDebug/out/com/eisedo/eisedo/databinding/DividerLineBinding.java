package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DividerLineBinding extends ViewDataBinding {
  protected DividerLineBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  @NonNull
  public static DividerLineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DividerLineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DividerLineBinding>inflate(inflater, com.eisedo.eisedo.R.layout.divider_line, root, attachToRoot, component);
  }

  @NonNull
  public static DividerLineBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DividerLineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DividerLineBinding>inflate(inflater, com.eisedo.eisedo.R.layout.divider_line, null, false, component);
  }

  public static DividerLineBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DividerLineBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DividerLineBinding)bind(component, view, com.eisedo.eisedo.R.layout.divider_line);
  }
}
