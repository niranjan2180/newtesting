package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.data.local.entities.Project;

public abstract class ProjectItemSelectionBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final ImageView ivSelected;

  @NonNull
  public final RecyclerView rvSubProject;

  @NonNull
  public final TextView tvProjectName;

  @Bindable
  protected String mProjectID;

  @Bindable
  protected Project mProject;

  protected ProjectItemSelectionBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer, ImageView ivSelected,
      RecyclerView rvSubProject, TextView tvProjectName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
    this.ivSelected = ivSelected;
    this.rvSubProject = rvSubProject;
    this.tvProjectName = tvProjectName;
  }

  public abstract void setProjectID(@Nullable String projectID);

  @Nullable
  public String getProjectID() {
    return mProjectID;
  }

  public abstract void setProject(@Nullable Project project);

  @Nullable
  public Project getProject() {
    return mProject;
  }

  @NonNull
  public static ProjectItemSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProjectItemSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProjectItemSelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.project_item_selection, root, attachToRoot, component);
  }

  @NonNull
  public static ProjectItemSelectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProjectItemSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProjectItemSelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.project_item_selection, null, false, component);
  }

  public static ProjectItemSelectionBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ProjectItemSelectionBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ProjectItemSelectionBinding)bind(component, view, com.eisedo.eisedo.R.layout.project_item_selection);
  }
}
