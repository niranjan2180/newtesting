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
import com.eisedo.eisedo.data.local.entities.Folder;

public abstract class ProjectItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final ImageView ivHolder;

  @NonNull
  public final RecyclerView rvFolderList;

  @NonNull
  public final TextView tvProjectName;

  @Bindable
  protected Folder mFolder;

  protected ProjectItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer, ImageView ivHolder,
      RecyclerView rvFolderList, TextView tvProjectName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
    this.ivHolder = ivHolder;
    this.rvFolderList = rvFolderList;
    this.tvProjectName = tvProjectName;
  }

  public abstract void setFolder(@Nullable Folder folder);

  @Nullable
  public Folder getFolder() {
    return mFolder;
  }

  @NonNull
  public static ProjectItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProjectItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProjectItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.project_item, root, attachToRoot, component);
  }

  @NonNull
  public static ProjectItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProjectItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProjectItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.project_item, null, false, component);
  }

  public static ProjectItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ProjectItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ProjectItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.project_item);
  }
}
