package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;

public abstract class FragmentTaskBinding extends ViewDataBinding {
  @NonNull
  public final Button btnAddTask;

  @NonNull
  public final ConstraintLayout clChildContainer;

  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final FragmentTasksBinding listFragmentTasks;

  @NonNull
  public final Toolbar tbHomeItem;

  @Bindable
  protected HomeItemViewModel mHomeItemViewModel;

  protected FragmentTaskBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnAddTask, ConstraintLayout clChildContainer,
      ConstraintLayout clContainer, FragmentTasksBinding listFragmentTasks, Toolbar tbHomeItem) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnAddTask = btnAddTask;
    this.clChildContainer = clChildContainer;
    this.clContainer = clContainer;
    this.listFragmentTasks = listFragmentTasks;
    setContainedBinding(this.listFragmentTasks);;
    this.tbHomeItem = tbHomeItem;
  }

  public abstract void setHomeItemViewModel(@Nullable HomeItemViewModel homeItemViewModel);

  @Nullable
  public HomeItemViewModel getHomeItemViewModel() {
    return mHomeItemViewModel;
  }

  @NonNull
  public static FragmentTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTaskBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_task, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTaskBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTaskBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_task, null, false, component);
  }

  public static FragmentTaskBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentTaskBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentTaskBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_task);
  }
}
