package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class SubscriptionCardBinding extends ViewDataBinding {
  @NonNull
  public final Button btnPayNow;

  @NonNull
  public final ImageView ivSecure;

  @NonNull
  public final Toolbar tbSubscribe;

  @NonNull
  public final TextInputLayout textInputLayout22;

  @NonNull
  public final TextInputEditText tieCardNumber;

  @NonNull
  public final TextInputLayout tilCardNumber;

  @Bindable
  protected String mCardNumber;

  @Bindable
  protected String mExpiryDate;

  @Bindable
  protected String mSecurityCode;

  @Bindable
  protected String mName;

  protected SubscriptionCardBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnPayNow, ImageView ivSecure, Toolbar tbSubscribe,
      TextInputLayout textInputLayout22, TextInputEditText tieCardNumber,
      TextInputLayout tilCardNumber) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnPayNow = btnPayNow;
    this.ivSecure = ivSecure;
    this.tbSubscribe = tbSubscribe;
    this.textInputLayout22 = textInputLayout22;
    this.tieCardNumber = tieCardNumber;
    this.tilCardNumber = tilCardNumber;
  }

  public abstract void setCardNumber(@Nullable String cardNumber);

  @Nullable
  public String getCardNumber() {
    return mCardNumber;
  }

  public abstract void setExpiryDate(@Nullable String expiryDate);

  @Nullable
  public String getExpiryDate() {
    return mExpiryDate;
  }

  public abstract void setSecurityCode(@Nullable String securityCode);

  @Nullable
  public String getSecurityCode() {
    return mSecurityCode;
  }

  public abstract void setName(@Nullable String name);

  @Nullable
  public String getName() {
    return mName;
  }

  @NonNull
  public static SubscriptionCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SubscriptionCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SubscriptionCardBinding>inflate(inflater, com.eisedo.eisedo.R.layout.subscription_card, root, attachToRoot, component);
  }

  @NonNull
  public static SubscriptionCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SubscriptionCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SubscriptionCardBinding>inflate(inflater, com.eisedo.eisedo.R.layout.subscription_card, null, false, component);
  }

  public static SubscriptionCardBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static SubscriptionCardBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (SubscriptionCardBinding)bind(component, view, com.eisedo.eisedo.R.layout.subscription_card);
  }
}
