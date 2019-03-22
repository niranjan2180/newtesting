package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityHomeBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  protected ActivityHomeBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityHomeBinding>inflate(inflater, com.eisedo.eisedo.R.layout.activity_home, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityHomeBinding>inflate(inflater, com.eisedo.eisedo.R.layout.activity_home, null, false, component);
  }

  public static ActivityHomeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityHomeBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityHomeBinding)bind(component, view, com.eisedo.eisedo.R.layout.activity_home);
  }
}
