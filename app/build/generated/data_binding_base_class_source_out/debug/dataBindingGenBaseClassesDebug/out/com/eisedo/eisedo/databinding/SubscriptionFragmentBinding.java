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
import com.eisedo.eisedo.data.local.entities.Subscribe;

public abstract class SubscriptionFragmentBinding extends ViewDataBinding {
  @NonNull
  public final Toolbar tbSubscribe;

  @NonNull
  public final TextView tvInvoice;

  @NonNull
  public final TextView tvSubMsg;

  @NonNull
  public final TextView tvSubscription;

  @Bindable
  protected Subscribe mSubscribe;

  @Bindable
  protected String mExpiry;

  protected SubscriptionFragmentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Toolbar tbSubscribe, TextView tvInvoice, TextView tvSubMsg,
      TextView tvSubscription) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tbSubscribe = tbSubscribe;
    this.tvInvoice = tvInvoice;
    this.tvSubMsg = tvSubMsg;
    this.tvSubscription = tvSubscription;
  }

  public abstract void setSubscribe(@Nullable Subscribe subscribe);

  @Nullable
  public Subscribe getSubscribe() {
    return mSubscribe;
  }

  public abstract void setExpiry(@Nullable String expiry);

  @Nullable
  public String getExpiry() {
    return mExpiry;
  }

  @NonNull
  public static SubscriptionFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SubscriptionFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SubscriptionFragmentBinding>inflate(inflater, com.eisedo.eisedo.R.layout.subscription_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static SubscriptionFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SubscriptionFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SubscriptionFragmentBinding>inflate(inflater, com.eisedo.eisedo.R.layout.subscription_fragment, null, false, component);
  }

  public static SubscriptionFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static SubscriptionFragmentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (SubscriptionFragmentBinding)bind(component, view, com.eisedo.eisedo.R.layout.subscription_fragment);
  }
}
