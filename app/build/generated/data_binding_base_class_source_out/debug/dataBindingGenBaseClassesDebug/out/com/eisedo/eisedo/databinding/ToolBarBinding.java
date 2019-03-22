package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ToolBarBinding extends ViewDataBinding {
  @NonNull
  public final Toolbar tbTitle;

  protected ToolBarBinding(DataBindingComponent _bindingComponent, View _root, int _localFieldCount,
      Toolbar tbTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tbTitle = tbTitle;
  }

  @NonNull
  public static ToolBarBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ToolBarBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ToolBarBinding>inflate(inflater, com.eisedo.eisedo.R.layout.tool_bar, root, attachToRoot, component);
  }

  @NonNull
  public static ToolBarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ToolBarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ToolBarBinding>inflate(inflater, com.eisedo.eisedo.R.layout.tool_bar, null, false, component);
  }

  public static ToolBarBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ToolBarBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (ToolBarBinding)bind(component, view, com.eisedo.eisedo.R.layout.tool_bar);
  }
}
