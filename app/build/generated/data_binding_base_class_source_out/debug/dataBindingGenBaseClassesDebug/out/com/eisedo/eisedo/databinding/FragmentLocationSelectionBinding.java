package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.data.local.entities.Location;
import java.util.ArrayList;

public abstract class FragmentLocationSelectionBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvLocationSelection;

  @NonNull
  public final EditText svLocation;

  @NonNull
  public final Toolbar tbTitle;

  @Bindable
  protected ArrayList<Location> mLocationItems;

  protected FragmentLocationSelectionBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvLocationSelection, EditText svLocation,
      Toolbar tbTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvLocationSelection = rvLocationSelection;
    this.svLocation = svLocation;
    this.tbTitle = tbTitle;
  }

  public abstract void setLocationItems(@Nullable ArrayList<Location> locationItems);

  @Nullable
  public ArrayList<Location> getLocationItems() {
    return mLocationItems;
  }

  @NonNull
  public static FragmentLocationSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentLocationSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentLocationSelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_location_selection, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentLocationSelectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentLocationSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentLocationSelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_location_selection, null, false, component);
  }

  public static FragmentLocationSelectionBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentLocationSelectionBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentLocationSelectionBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_location_selection);
  }
}
