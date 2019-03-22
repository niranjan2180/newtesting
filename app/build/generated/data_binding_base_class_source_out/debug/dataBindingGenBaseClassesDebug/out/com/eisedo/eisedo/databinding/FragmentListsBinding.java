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
import com.eisedo.eisedo.data.local.entities.CheckList;
import java.util.ArrayList;

public abstract class FragmentListsBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvLists;

  @NonNull
  public final Toolbar tbList;

  @Bindable
  protected ArrayList<CheckList> mChecklist;

  protected FragmentListsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvLists, Toolbar tbList) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvLists = rvLists;
    this.tbList = tbList;
  }

  public abstract void setChecklist(@Nullable ArrayList<CheckList> checklist);

  @Nullable
  public ArrayList<CheckList> getChecklist() {
    return mChecklist;
  }

  @NonNull
  public static FragmentListsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentListsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentListsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_lists, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentListsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentListsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentListsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_lists, null, false, component);
  }

  public static FragmentListsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentListsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentListsBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_lists);
  }
}
