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
import com.eisedo.eisedo.data.local.entities.Project;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentProjectAddEditBinding extends ViewDataBinding {
  @NonNull
  public final Button btnDelete;

  @NonNull
  public final Toolbar tbAddEdit;

  @NonNull
  public final TextInputLayout textInputLayout14;

  @NonNull
  public final TextInputEditText tieProjectName;

  @Bindable
  protected Project mProject;

  protected FragmentProjectAddEditBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnDelete, Toolbar tbAddEdit, TextInputLayout textInputLayout14,
      TextInputEditText tieProjectName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnDelete = btnDelete;
    this.tbAddEdit = tbAddEdit;
    this.textInputLayout14 = textInputLayout14;
    this.tieProjectName = tieProjectName;
  }

  public abstract void setProject(@Nullable Project project);

  @Nullable
  public Project getProject() {
    return mProject;
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
