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
import com.eisedo.eisedo.data.local.entities.CheckList;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentAddEditListBinding extends ViewDataBinding {
  @NonNull
  public final Button btnDeleteList;

  @NonNull
  public final TextInputLayout textInputLayout18;

  @NonNull
  public final TextInputEditText tieCheckListName;

  @NonNull
  public final Toolbar toolbar3;

  @Bindable
  protected CheckList mCheckList;

  protected FragmentAddEditListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnDeleteList, TextInputLayout textInputLayout18,
      TextInputEditText tieCheckListName, Toolbar toolbar3) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnDeleteList = btnDeleteList;
    this.textInputLayout18 = textInputLayout18;
    this.tieCheckListName = tieCheckListName;
    this.toolbar3 = toolbar3;
  }

  public abstract void setCheckList(@Nullable CheckList checkList);

  @Nullable
  public CheckList getCheckList() {
    return mCheckList;
  }

  @NonNull
  public static FragmentAddEditListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAddEditListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAddEditListBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_add_edit_list, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAddEditListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAddEditListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAddEditListBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_add_edit_list, null, false, component);
  }

  public static FragmentAddEditListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentAddEditListBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentAddEditListBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_add_edit_list);
  }
}
