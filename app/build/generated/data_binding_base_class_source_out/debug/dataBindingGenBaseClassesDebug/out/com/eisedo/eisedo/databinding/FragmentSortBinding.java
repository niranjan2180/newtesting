package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.data.local.entities.Task;
import java.util.ArrayList;

public abstract class FragmentSortBinding extends ViewDataBinding {
  @NonNull
  public final Button btnAddTask;

  @NonNull
  public final CardView cardView2;

  @NonNull
  public final RecyclerView rvTasks;

  @NonNull
  public final Toolbar tbProgress;

  @NonNull
  public final ImageView tvSort;

  @NonNull
  public final TextView tvSortTitle;

  @Bindable
  protected ArrayList<Task> mTakList;

  @Bindable
  protected int mPosition;

  protected FragmentSortBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnAddTask, CardView cardView2, RecyclerView rvTasks,
      Toolbar tbProgress, ImageView tvSort, TextView tvSortTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnAddTask = btnAddTask;
    this.cardView2 = cardView2;
    this.rvTasks = rvTasks;
    this.tbProgress = tbProgress;
    this.tvSort = tvSort;
    this.tvSortTitle = tvSortTitle;
  }

  public abstract void setTakList(@Nullable ArrayList<Task> takList);

  @Nullable
  public ArrayList<Task> getTakList() {
    return mTakList;
  }

  public abstract void setPosition(int position);

  public int getPosition() {
    return mPosition;
  }

  @NonNull
  public static FragmentSortBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSortBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSortBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_sort, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSortBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSortBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSortBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_sort, null, false, component);
  }

  public static FragmentSortBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentSortBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentSortBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_sort);
  }
}
