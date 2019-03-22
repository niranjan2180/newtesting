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
import com.eisedo.eisedo.data.local.entities.SubProject;

public abstract class FolderItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer1;

  @NonNull
  public final ImageView ivFolder;

  @NonNull
  public final ImageView ivSelected;

  @NonNull
  public final TextView tvFolderName;

  @Bindable
  protected SubProject mSubProject;

  @Bindable
  protected String mFolderId;

  protected FolderItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer1, ImageView ivFolder, ImageView ivSelected,
      TextView tvFolderName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer1 = clContainer1;
    this.ivFolder = ivFolder;
    this.ivSelected = ivSelected;
    this.tvFolderName = tvFolderName;
  }

  public abstract void setSubProject(@Nullable SubProject subProject);

  @Nullable
  public SubProject getSubProject() {
    return mSubProject;
  }

  public abstract void setFolderId(@Nullable String folderId);

  @Nullable
  public String getFolderId() {
    return mFolderId;
  }

  @NonNull
  public static FolderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FolderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FolderItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.folder_item, root, attachToRoot, component);
  }

  @NonNull
  public static FolderItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FolderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FolderItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.folder_item, null, false, component);
  }

  public static FolderItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FolderItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FolderItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.folder_item);
  }
}
