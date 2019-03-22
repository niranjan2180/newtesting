package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubscriptionPlansBinding extends ViewDataBinding {
  @NonNull
  public final Button btnProceed;

  @NonNull
  public final EditText editText;

  @NonNull
  public final EditText editText2;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final Toolbar tbSubscribe;

  @NonNull
  public final TextView tvCancel;

  @NonNull
  public final TextView tvSelect;

  protected SubscriptionPlansBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnProceed, EditText editText, EditText editText2,
      ImageView ivLogo, Toolbar tbSubscribe, TextView tvCancel, TextView tvSelect) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnProceed = btnProceed;
    this.editText = editText;
    this.editText2 = editText2;
    this.ivLogo = ivLogo;
    this.tbSubscribe = tbSubscribe;
    this.tvCancel = tvCancel;
    this.tvSelect = tvSelect;
  }

  @NonNull
  public static SubscriptionPlansBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SubscriptionPlansBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SubscriptionPlansBinding>inflate(inflater, com.eisedo.eisedo.R.layout.subscription_plans, root, attachToRoot, component);
  }

  @NonNull
  public static SubscriptionPlansBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SubscriptionPlansBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SubscriptionPlansBinding>inflate(inflater, com.eisedo.eisedo.R.layout.subscription_plans, null, false, component);
  }

  public static SubscriptionPlansBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static SubscriptionPlansBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (SubscriptionPlansBinding)bind(component, view, com.eisedo.eisedo.R.layout.subscription_plans);
  }
}
