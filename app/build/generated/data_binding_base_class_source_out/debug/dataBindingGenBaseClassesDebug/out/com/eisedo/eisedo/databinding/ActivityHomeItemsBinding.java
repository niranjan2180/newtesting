package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;

public abstract class ActivityHomeItemsBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @Bindable
  protected HomeItemViewModel mHomeItemViewModel;

  protected ActivityHomeItemsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
  }

  public abstract void setHomeItemViewModel(@Nullable HomeItemViewModel homeItemViewModel);

  @Nullable
  public HomeItemViewModel getHomeItemViewModel() {
    return mHomeItemViewModel;
  }

  @NonNull
  public static ActivityHomeItemsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityHomeItemsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityHomeItemsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.activity_home_items, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityHomeItemsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityHomeItemsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityHomeItemsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.activity_home_items, null, false, component);
  }

  public static ActivityHomeItemsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityHomeItemsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityHomeItemsBinding)bind(component, view, com.eisedo.eisedo.R.layout.activity_home_items);
  }
}
