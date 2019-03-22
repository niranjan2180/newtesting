package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FragmentTasksBinding extends ViewDataBinding {
  @NonNull
  public final CardView cardView;

  @NonNull
  public final CardView cardView1;

  @NonNull
  public final CardView cardViewDelegated;

  @NonNull
  public final CardView cardViewEliminate;

  @NonNull
  public final RecyclerView rvDelegateTasks;

  @NonNull
  public final RecyclerView rvDoFirstTasks;

  @NonNull
  public final RecyclerView rvDoLaterTasks;

  @NonNull
  public final RecyclerView rvEliminateTasks;

  @NonNull
  public final TextView tvDelegateCount;

  @NonNull
  public final TextView tvDelegateMessage;

  @NonNull
  public final TextView tvDoFirstMessage;

  @NonNull
  public final TextView tvDoLaterCount;

  @NonNull
  public final TextView tvDoLaterMessage;

  @NonNull
  public final TextView tvDoNowCount;

  @NonNull
  public final TextView tvEliminateCount;

  @NonNull
  public final TextView tvEliminateMessage;

  @NonNull
  public final TextView tvTitleDelegate;

  @NonNull
  public final TextView tvTitleDoLater;

  @NonNull
  public final TextView tvTitleDoNow;

  @NonNull
  public final TextView tvTitleEliminate;

  protected FragmentTasksBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CardView cardView, CardView cardView1, CardView cardViewDelegated,
      CardView cardViewEliminate, RecyclerView rvDelegateTasks, RecyclerView rvDoFirstTasks,
      RecyclerView rvDoLaterTasks, RecyclerView rvEliminateTasks, TextView tvDelegateCount,
      TextView tvDelegateMessage, TextView tvDoFirstMessage, TextView tvDoLaterCount,
      TextView tvDoLaterMessage, TextView tvDoNowCount, TextView tvEliminateCount,
      TextView tvEliminateMessage, TextView tvTitleDelegate, TextView tvTitleDoLater,
      TextView tvTitleDoNow, TextView tvTitleEliminate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardView = cardView;
    this.cardView1 = cardView1;
    this.cardViewDelegated = cardViewDelegated;
    this.cardViewEliminate = cardViewEliminate;
    this.rvDelegateTasks = rvDelegateTasks;
    this.rvDoFirstTasks = rvDoFirstTasks;
    this.rvDoLaterTasks = rvDoLaterTasks;
    this.rvEliminateTasks = rvEliminateTasks;
    this.tvDelegateCount = tvDelegateCount;
    this.tvDelegateMessage = tvDelegateMessage;
    this.tvDoFirstMessage = tvDoFirstMessage;
    this.tvDoLaterCount = tvDoLaterCount;
    this.tvDoLaterMessage = tvDoLaterMessage;
    this.tvDoNowCount = tvDoNowCount;
    this.tvEliminateCount = tvEliminateCount;
    this.tvEliminateMessage = tvEliminateMessage;
    this.tvTitleDelegate = tvTitleDelegate;
    this.tvTitleDoLater = tvTitleDoLater;
    this.tvTitleDoNow = tvTitleDoNow;
    this.tvTitleEliminate = tvTitleEliminate;
  }

  @NonNull
  public static FragmentTasksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTasksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTasksBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_tasks, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTasksBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTasksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTasksBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_tasks, null, false, component);
  }

  public static FragmentTasksBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentTasksBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentTasksBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_tasks);
  }
}
