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
import com.eisedo.eisedo.util.EventHandeling;

public abstract class StarredItemBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox cbStatus;

  @NonNull
  public final ImageView ivStar;

  @NonNull
  public final TextView tvDate;

  @NonNull
  public final TextView tvTaskName;

  @Bindable
  protected Task mTaskStarred;

  @Bindable
  protected EventHandeling mEventHandel;

  protected StarredItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CheckBox cbStatus, ImageView ivStar, TextView tvDate,
      TextView tvTaskName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbStatus = cbStatus;
    this.ivStar = ivStar;
    this.tvDate = tvDate;
    this.tvTaskName = tvTaskName;
  }

  public abstract void setTaskStarred(@Nullable Task taskStarred);

  @Nullable
  public Task getTaskStarred() {
    return mTaskStarred;
  }

  public abstract void setEventHandel(@Nullable EventHandeling eventHandel);

  @Nullable
  public EventHandeling getEventHandel() {
    return mEventHandel;
  }

  @NonNull
  public static StarredItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static StarredItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<StarredItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.starred_item, root, attachToRoot, component);
  }

  @NonNull
  public static StarredItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static StarredItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<StarredItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.starred_item, null, false, component);
  }

  public static StarredItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static StarredItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (StarredItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.starred_item);
  }
}
