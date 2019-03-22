package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.Task;

public abstract class CompleteItemBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox cbStatus;

  @NonNull
  public final ImageView ivDelete;

  @NonNull
  public final TextView tvTaskName;

  @Bindable
  protected Task mTaskItem;

  protected CompleteItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CheckBox cbStatus, ImageView ivDelete, TextView tvTaskName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbStatus = cbStatus;
    this.ivDelete = ivDelete;
    this.tvTaskName = tvTaskName;
  }

  public abstract void setTaskItem(@Nullable Task task_item);

  @Nullable
  public Task getTaskItem() {
    return mTaskItem;
  }

  @NonNull
  public static CompleteItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CompleteItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CompleteItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.complete_item, root, attachToRoot, component);
  }

  @NonNull
  public static CompleteItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CompleteItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CompleteItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.complete_item, null, false, component);
  }

  public static CompleteItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static CompleteItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (CompleteItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.complete_item);
  }
}
