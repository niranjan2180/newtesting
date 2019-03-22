package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.data.local.entities.Task;
import java.util.ArrayList;

public abstract class FragmentSearchBinding extends ViewDataBinding {
  @NonNull
  public final EditText etSearchText;

  @NonNull
  public final RecyclerView rvSearchTasks;

  @NonNull
  public final Toolbar tbSearch;

  @NonNull
  public final TextView tvSearchMessage;

  @Bindable
  protected ArrayList<Task> mSearchTasks;

  protected FragmentSearchBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText etSearchText, RecyclerView rvSearchTasks, Toolbar tbSearch,
      TextView tvSearchMessage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.etSearchText = etSearchText;
    this.rvSearchTasks = rvSearchTasks;
    this.tbSearch = tbSearch;
    this.tvSearchMessage = tvSearchMessage;
  }

  public abstract void setSearchTasks(@Nullable ArrayList<Task> searchTasks);

  @Nullable
  public ArrayList<Task> getSearchTasks() {
    return mSearchTasks;
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSearchBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_search, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSearchBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_search, null, false, component);
  }

  public static FragmentSearchBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentSearchBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentSearchBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_search);
  }
}
