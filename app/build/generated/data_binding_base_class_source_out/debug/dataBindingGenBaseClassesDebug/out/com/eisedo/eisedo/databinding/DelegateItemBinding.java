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

public abstract class DelegateItemBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox cbStatus;

  @NonNull
  public final TextView tvDelegateName;

  @NonNull
  public final TextView tvTaskName;

  @Bindable
  protected Task mTaskDelegate;

  protected DelegateItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CheckBox cbStatus, TextView tvDelegateName, TextView tvTaskName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbStatus = cbStatus;
    this.tvDelegateName = tvDelegateName;
    this.tvTaskName = tvTaskName;
  }

  public abstract void setTaskDelegate(@Nullable Task taskDelegate);

  @Nullable
  public Task getTaskDelegate() {
    return mTaskDelegate;
  }

  @NonNull
  public static DelegateItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DelegateItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DelegateItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.delegate_item, root, attachToRoot, component);
  }

  @NonNull
  public static DelegateItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DelegateItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DelegateItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.delegate_item, null, false, component);
  }

  public static DelegateItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DelegateItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DelegateItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.delegate_item);
  }
}
