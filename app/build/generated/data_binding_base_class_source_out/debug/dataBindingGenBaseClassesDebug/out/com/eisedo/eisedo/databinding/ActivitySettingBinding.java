package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.setting.SettingViewModel;

public abstract class ActivitySettingBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @Bindable
  protected SettingViewModel mSettingsViewModel;

  protected ActivitySettingBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
  }

  public abstract void setSettingsViewModel(@Nullable SettingViewModel settingsViewModel);

  @Nullable
  public SettingViewModel getSettingsViewModel() {
    return mSettingsViewModel;
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySettingBinding>inflate(inflater, com.eisedo.eisedo.R.layout.activity_setting, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySettingBinding>inflate(inflater, com.eisedo.eisedo.R.layout.activity_setting, null, false, component);
  }

  public static ActivitySettingBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySettingBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySettingBinding)bind(component, view, com.eisedo.eisedo.R.layout.activity_setting);
  }
}
