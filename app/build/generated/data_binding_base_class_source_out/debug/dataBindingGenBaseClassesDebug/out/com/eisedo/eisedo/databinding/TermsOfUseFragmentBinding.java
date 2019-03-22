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

public abstract class TermsOfUseFragmentBinding extends ViewDataBinding {
  @NonNull
  public final Toolbar tbTitle;

  @NonNull
  public final TextView tvData;

  @Bindable
  protected String mData;

  protected TermsOfUseFragmentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Toolbar tbTitle, TextView tvData) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tbTitle = tbTitle;
    this.tvData = tvData;
  }

  public abstract void setData(@Nullable String data);

  @Nullable
  public String getData() {
    return mData;
  }

  @NonNull
  public static TermsOfUseFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TermsOfUseFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TermsOfUseFragmentBinding>inflate(inflater, com.eisedo.eisedo.R.layout.terms_of_use_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static TermsOfUseFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TermsOfUseFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TermsOfUseFragmentBinding>inflate(inflater, com.eisedo.eisedo.R.layout.terms_of_use_fragment, null, false, component);
  }

  public static TermsOfUseFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static TermsOfUseFragmentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (TermsOfUseFragmentBinding)bind(component, view, com.eisedo.eisedo.R.layout.terms_of_use_fragment);
  }
}
