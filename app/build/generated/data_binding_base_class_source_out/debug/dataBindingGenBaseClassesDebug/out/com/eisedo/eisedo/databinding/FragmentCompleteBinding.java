package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;

public abstract class FragmentCompleteBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvItems;

  @NonNull
  public final Toolbar tbTitleBar;

  @Bindable
  protected HomeItemViewModel mHomeItemViewModel;

  protected FragmentCompleteBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvItems, Toolbar tbTitleBar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvItems = rvItems;
    this.tbTitleBar = tbTitleBar;
  }

  public abstract void setHomeItemViewModel(@Nullable HomeItemViewModel homeItemViewModel);

  @Nullable
  public HomeItemViewModel getHomeItemViewModel() {
    return mHomeItemViewModel;
  }

  @NonNull
  public static FragmentCompleteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCompleteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCompleteBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_complete, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentCompleteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCompleteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCompleteBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_complete, null, false, component);
  }

  public static FragmentCompleteBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentCompleteBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentCompleteBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_complete);
  }
}
