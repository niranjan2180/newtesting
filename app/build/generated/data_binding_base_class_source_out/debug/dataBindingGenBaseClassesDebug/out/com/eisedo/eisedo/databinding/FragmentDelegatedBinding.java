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

public abstract class FragmentDelegatedBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvItems;

  @NonNull
  public final Toolbar tbTitleBar;

  @Bindable
  protected HomeItemViewModel mHomeItmeViewModel;

  protected FragmentDelegatedBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvItems, Toolbar tbTitleBar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvItems = rvItems;
    this.tbTitleBar = tbTitleBar;
  }

  public abstract void setHomeItmeViewModel(@Nullable HomeItemViewModel homeItmeViewModel);

  @Nullable
  public HomeItemViewModel getHomeItmeViewModel() {
    return mHomeItmeViewModel;
  }

  @NonNull
  public static FragmentDelegatedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentDelegatedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentDelegatedBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_delegated, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentDelegatedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentDelegatedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentDelegatedBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_delegated, null, false, component);
  }

  public static FragmentDelegatedBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentDelegatedBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentDelegatedBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_delegated);
  }
}
