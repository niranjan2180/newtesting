package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.data.HomeItem;
import com.eisedo.eisedo.home.main.HomeFragment;
import java.util.ArrayList;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final Button btnAddTask;

  @NonNull
  public final RecyclerView rvHomeNavigation;

  @Bindable
  protected ArrayList<HomeItem> mHomeItems;

  @Bindable
  protected HomeFragment.HomeActivityPresenter mHomePresenter;

  protected FragmentHomeBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnAddTask, RecyclerView rvHomeNavigation) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnAddTask = btnAddTask;
    this.rvHomeNavigation = rvHomeNavigation;
  }

  public abstract void setHomeItems(@Nullable ArrayList<HomeItem> homeItems);

  @Nullable
  public ArrayList<HomeItem> getHomeItems() {
    return mHomeItems;
  }

  public abstract void setHomePresenter(@Nullable HomeFragment.HomeActivityPresenter homePresenter);

  @Nullable
  public HomeFragment.HomeActivityPresenter getHomePresenter() {
    return mHomePresenter;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentHomeBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentHomeBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentHomeBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentHomeBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_home);
  }
}
