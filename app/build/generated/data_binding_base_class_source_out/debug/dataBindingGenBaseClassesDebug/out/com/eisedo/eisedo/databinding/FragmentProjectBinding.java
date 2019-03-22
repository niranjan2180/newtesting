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
import com.eisedo.eisedo.data.local.entities.Folder;

public abstract class FragmentProjectBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvProjects;

  @NonNull
  public final Toolbar tbProject;

  @Bindable
  protected Folder mFolder;

  protected FragmentProjectBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvProjects, Toolbar tbProject) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvProjects = rvProjects;
    this.tbProject = tbProject;
  }

  public abstract void setFolder(@Nullable Folder folder);

  @Nullable
  public Folder getFolder() {
    return mFolder;
  }

  @NonNull
  public static FragmentProjectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentProjectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentProjectBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_project, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentProjectBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentProjectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentProjectBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_project, null, false, component);
  }

  public static FragmentProjectBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentProjectBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentProjectBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_project);
  }
}