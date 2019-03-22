package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.HomeItem;

public abstract class HomeItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clHomeItem;

  @NonNull
  public final ImageView ivItemIcon;

  @NonNull
  public final TextView tvHomeItemCount;

  @NonNull
  public final TextView tvHomeName;

  @Bindable
  protected HomeItem mHomeItem;

  @Bindable
  protected int mPosition;

  protected HomeItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clHomeItem, ImageView ivItemIcon,
      TextView tvHomeItemCount, TextView tvHomeName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clHomeItem = clHomeItem;
    this.ivItemIcon = ivItemIcon;
    this.tvHomeItemCount = tvHomeItemCount;
    this.tvHomeName = tvHomeName;
  }

  public abstract void setHomeItem(@Nullable HomeItem homeItem);

  @Nullable
  public HomeItem getHomeItem() {
    return mHomeItem;
  }

  public abstract void setPosition(int position);

  public int getPosition() {
    return mPosition;
  }

  @NonNull
  public static HomeItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static HomeItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<HomeItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.home_item, root, attachToRoot, component);
  }

  @NonNull
  public static HomeItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static HomeItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<HomeItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.home_item, null, false, component);
  }

  public static HomeItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static HomeItemBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (HomeItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.home_item);
  }
}
