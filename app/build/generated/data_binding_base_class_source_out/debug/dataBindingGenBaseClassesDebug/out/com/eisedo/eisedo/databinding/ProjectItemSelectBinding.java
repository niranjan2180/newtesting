package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.Project;

public abstract class ProjectItemSelectBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final TextView tvProjectName;

  @Bindable
  protected Project mProject;

  protected ProjectItemSelectBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer, TextView tvProjectName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
    this.tvProjectName = tvProjectName;
  }

  public abstract void setProject(@Nullable Project project);

  @Nullable
  public Project getProject() {
    return mProject;
  }

  @NonNull
  public static ProjectItemSelectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProjectItemSelectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProjectItemSelectBinding>inflate(inflater, com.eisedo.eisedo.R.layout.project_item_select, root, attachToRoot, component);
  }

  @NonNull
  public static ProjectItemSelectBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProjectItemSelectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProjectItemSelectBinding>inflate(inflater, com.eisedo.eisedo.R.layout.project_item_select, null, false, component);
  }

  public static ProjectItemSelectBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ProjectItemSelectBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ProjectItemSelectBinding)bind(component, view, com.eisedo.eisedo.R.layout.project_item_select);
  }
}
