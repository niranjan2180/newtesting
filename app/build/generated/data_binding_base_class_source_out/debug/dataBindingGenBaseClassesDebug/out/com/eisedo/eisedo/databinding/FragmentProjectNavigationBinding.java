package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.home.HomeViewModel;

public abstract class FragmentProjectNavigationBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final RecyclerView rvProjects;

  @NonNull
  public final ToolBarBinding tbProject;

  @Bindable
  protected HomeViewModel mProject;

  protected FragmentProjectNavigationBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer, RecyclerView rvProjects,
      ToolBarBinding tbProject) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
    this.rvProjects = rvProjects;
    this.tbProject = tbProject;
    setContainedBinding(this.tbProject);;
  }

  public abstract void setProject(@Nullable HomeViewModel project);

  @Nullable
  public HomeViewModel getProject() {
    return mProject;
  }

  @NonNull
  public static FragmentProjectNavigationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentProjectNavigationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentProjectNavigationBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_project_navigation, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentProjectNavigationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentProjectNavigationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentProjectNavigationBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_project_navigation, null, false, component);
  }

  public static FragmentProjectNavigationBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentProjectNavigationBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentProjectNavigationBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_project_navigation);
  }
}
