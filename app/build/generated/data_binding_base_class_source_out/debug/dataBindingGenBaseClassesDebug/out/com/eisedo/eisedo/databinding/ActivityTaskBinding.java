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
import com.eisedo.eisedo.data.local.entities.Task;

public abstract class ActivityTaskBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @Bindable
  protected Task mTask;

  protected ActivityTaskBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
  }

  public abstract void setTask(@Nullable Task task);

  @Nullable
  public Task getTask() {
    return mTask;
  }

  @NonNull
  public static ActivityTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTaskBinding>inflate(inflater, com.eisedo.eisedo.R.layout.activity_task, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTaskBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTaskBinding>inflate(inflater, com.eisedo.eisedo.R.layout.activity_task, null, false, component);
  }

  public static ActivityTaskBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityTaskBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityTaskBinding)bind(component, view, com.eisedo.eisedo.R.layout.activity_task);
  }
}
