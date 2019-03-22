package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.data.local.entities.SortFilter;
import java.util.ArrayList;

public abstract class FragmentFilterSortBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvSorts;

  @NonNull
  public final Toolbar tbSortFilter;

  @Bindable
  protected ArrayList<SortFilter> mFilterList;

  protected FragmentFilterSortBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvSorts, Toolbar tbSortFilter) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvSorts = rvSorts;
    this.tbSortFilter = tbSortFilter;
  }

  public abstract void setFilterList(@Nullable ArrayList<SortFilter> filterList);

  @Nullable
  public ArrayList<SortFilter> getFilterList() {
    return mFilterList;
  }

  @NonNull
  public static FragmentFilterSortBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFilterSortBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFilterSortBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_filter_sort, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFilterSortBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFilterSortBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFilterSortBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_filter_sort, null, false, component);
  }

  public static FragmentFilterSortBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFilterSortBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFilterSortBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_filter_sort);
  }
}
