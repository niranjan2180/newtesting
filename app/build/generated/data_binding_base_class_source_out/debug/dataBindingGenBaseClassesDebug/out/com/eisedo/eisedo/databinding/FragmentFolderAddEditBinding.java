package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;

public abstract class FragmentFolderAddEditBinding extends ViewDataBinding {
  @NonNull
  public final Button btnDeleteFilder;

  @NonNull
  public final TextInputLayout textInputLayout15;

  @NonNull
  public final TextInputLayout textInputLayout16;

  @NonNull
  public final TextInputEditText tieSelectProject;

  @NonNull
  public final Toolbar toolbar2;

  @Bindable
  protected Folder mFolder;

  @Bindable
  protected ArrayList<Folder> mProjectList;

  protected FragmentFolderAddEditBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnDeleteFilder, TextInputLayout textInputLayout15,
      TextInputLayout textInputLayout16, TextInputEditText tieSelectProject, Toolbar toolbar2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnDeleteFilder = btnDeleteFilder;
    this.textInputLayout15 = textInputLayout15;
    this.textInputLayout16 = textInputLayout16;
    this.tieSelectProject = tieSelectProject;
    this.toolbar2 = toolbar2;
  }

  public abstract void setFolder(@Nullable Folder folder);

  @Nullable
  public Folder getFolder() {
    return mFolder;
  }

  public abstract void setProjectList(@Nullable ArrayList<Folder> projectList);

  @Nullable
  public ArrayList<Folder> getProjectList() {
    return mProjectList;
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
