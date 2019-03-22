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
import com.eisedo.eisedo.data.SettingItem;

public abstract class SettingsItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clSetting;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final TextView tvSettingName;

  @NonNull
  public final View view;

  @Bindable
  protected SettingItem mSettingItem;

  protected SettingsItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clSetting, ImageView ivBack, TextView tvSettingName,
      View view) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clSetting = clSetting;
    this.ivBack = ivBack;
    this.tvSettingName = tvSettingName;
    this.view = view;
  }

  public abstract void setSettingItem(@Nullable SettingItem settingItem);

  @Nullable
  public SettingItem getSettingItem() {
    return mSettingItem;
  }

  @NonNull
  public static SettingsItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SettingsItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SettingsItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.settings_item, root, attachToRoot, component);
  }

  @NonNull
  public static SettingsItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SettingsItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SettingsItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.settings_item, null, false, component);
  }

  public static SettingsItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static SettingsItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (SettingsItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.settings_item);
  }
}
