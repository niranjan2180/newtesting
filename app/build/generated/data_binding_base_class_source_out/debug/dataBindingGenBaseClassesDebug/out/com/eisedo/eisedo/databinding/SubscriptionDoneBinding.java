package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubscriptionDoneBinding extends ViewDataBinding {
  @NonNull
  public final Button btnDone;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final Toolbar tbSubscribe;

  @NonNull
  public final TextView tvTq;

  protected SubscriptionDoneBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnDone, ImageView ivLogo, Toolbar tbSubscribe, TextView tvTq) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnDone = btnDone;
    this.ivLogo = ivLogo;
    this.tbSubscribe = tbSubscribe;
    this.tvTq = tvTq;
  }

  @NonNull
  public static SubscriptionDoneBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SubscriptionDoneBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SubscriptionDoneBinding>inflate(inflater, com.eisedo.eisedo.R.layout.subscription_done, root, attachToRoot, component);
  }

  @NonNull
  public static SubscriptionDoneBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SubscriptionDoneBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SubscriptionDoneBinding>inflate(inflater, com.eisedo.eisedo.R.layout.subscription_done, null, false, component);
  }

  public static SubscriptionDoneBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static SubscriptionDoneBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (SubscriptionDoneBinding)bind(component, view, com.eisedo.eisedo.R.layout.subscription_done);
  }
}
