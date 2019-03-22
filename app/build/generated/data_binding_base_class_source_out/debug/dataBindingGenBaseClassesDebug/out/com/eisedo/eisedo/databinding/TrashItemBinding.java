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

public abstract class TrashItemBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox cbSelection;

  @NonNull
  public final ImageView ivDelete;

  @NonNull
  public final TextView tvTaskName;

  @Bindable
  protected Task mTaskItem;

  protected TrashItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CheckBox cbSelection, ImageView ivDelete, TextView tvTaskName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbSelection = cbSelection;
    this.ivDelete = ivDelete;
    this.tvTaskName = tvTaskName;
  }

  public abstract void setTaskItem(@Nullable Task task_item);

  @Nullable
  public Task getTaskItem() {
    return mTaskItem;
  }

  @NonNull
  public static TrashItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TrashItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TrashItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.trash_item, root, attachToRoot, component);
  }

  @NonNull
  public static TrashItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TrashItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TrashItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.trash_item, null, false, component);
  }

  public static TrashItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static TrashItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (TrashItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.trash_item);
  }
}
