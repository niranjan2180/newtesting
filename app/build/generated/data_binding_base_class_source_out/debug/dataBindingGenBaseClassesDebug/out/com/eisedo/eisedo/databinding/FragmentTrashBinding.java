package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;

public abstract class FragmentTrashBinding extends ViewDataBinding {
  @NonNull
  public final Button btnTrash;

  @NonNull
  public final NestedScrollView nestedScrollView;

  @NonNull
  public final RecyclerView rvItems;

  @NonNull
  public final Toolbar tbHomeItem;

  @Bindable
  protected HomeItemViewModel mHomeItemModel;

  protected FragmentTrashBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnTrash, NestedScrollView nestedScrollView,
      RecyclerView rvItems, Toolbar tbHomeItem) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnTrash = btnTrash;
    this.nestedScrollView = nestedScrollView;
    this.rvItems = rvItems;
    this.tbHomeItem = tbHomeItem;
  }

  public abstract void setHomeItemModel(@Nullable HomeItemViewModel homeItemModel);

  @Nullable
  public HomeItemViewModel getHomeItemModel() {
    return mHomeItemModel;
  }

  @NonNull
  public static FragmentTrashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTrashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTrashBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_trash, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTrashBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTrashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTrashBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_trash, null, false, component);
  }

  public static FragmentTrashBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentTrashBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentTrashBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_trash);
  }
}
