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
import com.eisedo.eisedo.data.local.entities.Folder;

public abstract class FolderItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final ImageView ivFolder;

  @NonNull
  public final TextView tvFolderName;

  @Bindable
  protected Folder mFolder;

  protected FolderItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer, ImageView ivFolder,
      TextView tvFolderName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
    this.ivFolder = ivFolder;
    this.tvFolderName = tvFolderName;
  }

  public abstract void setFolder(@Nullable Folder folder);

  @Nullable
  public Folder getFolder() {
    return mFolder;
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
