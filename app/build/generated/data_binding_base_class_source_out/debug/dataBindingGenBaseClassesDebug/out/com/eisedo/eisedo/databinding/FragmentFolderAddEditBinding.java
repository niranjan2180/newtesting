package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.Project;
import com.eisedo.eisedo.data.local.entities.SubProject;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentFolderAddEditBinding extends ViewDataBinding {
  @NonNull
  public final Button btnDeleteFolder;

  @NonNull
  public final ConstraintLayout clChildContainer;

  @NonNull
  public final Toolbar tbAddEditFolder;

  @NonNull
  public final TextInputLayout textInputLayout15;

  @NonNull
  public final TextInputLayout textInputLayout16;

  @NonNull
  public final TextInputEditText tieFolderName;

  @NonNull
  public final TextInputEditText tieSelectProject;

  @Bindable
  protected SubProject mFolder;

  @Bindable
  protected Project mParentFolder;

  protected FragmentFolderAddEditBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnDeleteFolder, ConstraintLayout clChildContainer,
      Toolbar tbAddEditFolder, TextInputLayout textInputLayout15, TextInputLayout textInputLayout16,
      TextInputEditText tieFolderName, TextInputEditText tieSelectProject) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnDeleteFolder = btnDeleteFolder;
    this.clChildContainer = clChildContainer;
    this.tbAddEditFolder = tbAddEditFolder;
    this.textInputLayout15 = textInputLayout15;
    this.textInputLayout16 = textInputLayout16;
    this.tieFolderName = tieFolderName;
    this.tieSelectProject = tieSelectProject;
  }

  public abstract void setFolder(@Nullable SubProject folder);

  @Nullable
  public SubProject getFolder() {
    return mFolder;
  }

  public abstract void setParentFolder(@Nullable Project parentFolder);

  @Nullable
  public Project getParentFolder() {
    return mParentFolder;
  }

  @NonNull
  public static FragmentFolderAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFolderAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFolderAddEditBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_folder_add_edit, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFolderAddEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFolderAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFolderAddEditBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_folder_add_edit, null, false, component);
  }

  public static FragmentFolderAddEditBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFolderAddEditBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFolderAddEditBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_folder_add_edit);
  }
}
