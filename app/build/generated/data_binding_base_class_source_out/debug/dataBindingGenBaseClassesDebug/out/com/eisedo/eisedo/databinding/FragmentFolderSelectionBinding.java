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
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;

public abstract class FragmentFolderSelectionBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvFolderSelection;

  @NonNull
  public final Toolbar tbFolderSelection;

  @Bindable
  protected HomeItemViewModel mHomeViewModel;

  protected FragmentFolderSelectionBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvFolderSelection, Toolbar tbFolderSelection) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvFolderSelection = rvFolderSelection;
    this.tbFolderSelection = tbFolderSelection;
  }

  public abstract void setHomeViewModel(@Nullable HomeItemViewModel homeViewModel);

  @Nullable
  public HomeItemViewModel getHomeViewModel() {
    return mHomeViewModel;
  }

  @NonNull
  public static FragmentFolderSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFolderSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFolderSelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_folder_selection, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFolderSelectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFolderSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFolderSelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_folder_selection, null, false, component);
  }

  public static FragmentFolderSelectionBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFolderSelectionBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFolderSelectionBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_folder_selection);
  }
}
