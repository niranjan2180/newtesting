package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public abstract class FragmentListSelectionBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvSelectionItems;

  @NonNull
  public final SearchView svListSelection;

  @Bindable
  protected ArrayList<String> mSelectionList;

  protected FragmentListSelectionBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvSelectionItems, SearchView svListSelection) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvSelectionItems = rvSelectionItems;
    this.svListSelection = svListSelection;
  }

  public abstract void setSelectionList(@Nullable ArrayList<String> selectionList);

  @Nullable
  public ArrayList<String> getSelectionList() {
    return mSelectionList;
  }

  @NonNull
  public static FragmentListSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentListSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentListSelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_list_selection, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentListSelectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentListSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentListSelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_list_selection, null, false, component);
  }

  public static FragmentListSelectionBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentListSelectionBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentListSelectionBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_list_selection);
  }
}
