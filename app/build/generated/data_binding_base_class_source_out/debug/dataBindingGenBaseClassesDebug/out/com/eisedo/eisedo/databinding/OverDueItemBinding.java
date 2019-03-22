package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.Task;

public abstract class OverDueItemBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox cbStatus;

  @NonNull
  public final TextView tvOverDue;

  @NonNull
  public final TextView tvTaskName;

  @Bindable
  protected Task mTaskOverDue;

  protected OverDueItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CheckBox cbStatus, TextView tvOverDue, TextView tvTaskName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbStatus = cbStatus;
    this.tvOverDue = tvOverDue;
    this.tvTaskName = tvTaskName;
  }

  public abstract void setTaskOverDue(@Nullable Task taskOverDue);

  @Nullable
  public Task getTaskOverDue() {
    return mTaskOverDue;
  }

  @NonNull
  public static OverDueItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static OverDueItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<OverDueItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.over_due_item, root, attachToRoot, component);
  }

  @NonNull
  public static OverDueItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static OverDueItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<OverDueItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.over_due_item, null, false, component);
  }

  public static OverDueItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static OverDueItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (OverDueItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.over_due_item);
  }
}
