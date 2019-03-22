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

public abstract class FragmentProjectAddEditBinding extends ViewDataBinding {
  @NonNull
  public final Button btnDelete;

  @NonNull
  public final TextInputLayout textInputLayout14;

  @NonNull
  public final TextInputEditText tieProjectName;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected Folder mFolder;

  protected FragmentProjectAddEditBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnDelete, TextInputLayout textInputLayout14,
      TextInputEditText tieProjectName, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnDelete = btnDelete;
    this.textInputLayout14 = textInputLayout14;
    this.tieProjectName = tieProjectName;
    this.toolbar = toolbar;
  }

  public abstract void setFolder(@Nullable Folder folder);

  @Nullable
  public Folder getFolder() {
    return mFolder;
  }

  @NonNull
  public static FragmentProjectAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentProjectAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentProjectAddEditBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_project_add_edit, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentProjectAddEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentProjectAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentProjectAddEditBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_project_add_edit, null, false, component);
  }

  public static FragmentProjectAddEditBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentProjectAddEditBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentProjectAddEditBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_project_add_edit);
  }
}
