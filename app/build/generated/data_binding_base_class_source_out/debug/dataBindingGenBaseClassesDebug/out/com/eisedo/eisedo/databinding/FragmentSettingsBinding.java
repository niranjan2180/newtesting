package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.setting.SettingViewModel;

public abstract class FragmentSettingsBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvSettings;

  @NonNull
  public final Toolbar tbTitle;

  @NonNull
  public final TextView tvTaskName;

  @Bindable
  protected SettingViewModel mSettingViewModel;

  protected FragmentSettingsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvSettings, Toolbar tbTitle, TextView tvTaskName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvSettings = rvSettings;
    this.tbTitle = tbTitle;
    this.tvTaskName = tvTaskName;
  }

  public abstract void setSettingViewModel(@Nullable SettingViewModel settingViewModel);

  @Nullable
  public SettingViewModel getSettingViewModel() {
    return mSettingViewModel;
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSettingsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_settings, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSettingsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_settings, null, false, component);
  }

  public static FragmentSettingsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentSettingsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentSettingsBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_settings);
  }
}
