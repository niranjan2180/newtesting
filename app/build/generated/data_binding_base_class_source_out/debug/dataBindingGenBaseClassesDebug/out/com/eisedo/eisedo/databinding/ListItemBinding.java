package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.CheckList;

public abstract class ListItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final TextView tvListName;

  @Bindable
  protected CheckList mCheckItem;

  protected ListItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer, TextView tvListName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
    this.tvListName = tvListName;
  }

  public abstract void setCheckItem(@Nullable CheckList checkItem);

  @Nullable
  public CheckList getCheckItem() {
    return mCheckItem;
  }

  @NonNull
  public static ListItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ListItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ListItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.list_item, root, attachToRoot, component);
  }

  @NonNull
  public static ListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ListItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.list_item, null, false, component);
  }

  public static ListItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ListItemBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (ListItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.list_item);
  }
}
