package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public abstract class FragmentDaySelectionBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvDaySelection;

  @Bindable
  protected ArrayList<String> mDayList;

  protected FragmentDaySelectionBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvDaySelection) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvDaySelection = rvDaySelection;
  }

  public abstract void setDayList(@Nullable ArrayList<String> dayList);

  @Nullable
  public ArrayList<String> getDayList() {
    return mDayList;
  }

  @NonNull
  public static FragmentDaySelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentDaySelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentDaySelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_day_selection, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentDaySelectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentDaySelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentDaySelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_day_selection, null, false, component);
  }

  public static FragmentDaySelectionBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentDaySelectionBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentDaySelectionBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_day_selection);
  }
}
