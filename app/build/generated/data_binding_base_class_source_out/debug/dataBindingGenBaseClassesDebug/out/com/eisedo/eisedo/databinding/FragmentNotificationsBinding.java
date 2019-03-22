package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.User;

public abstract class FragmentNotificationsBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox cbEmailNewsUpdates;

  @NonNull
  public final CheckBox cbEmailRemainder;

  @NonNull
  public final CheckBox cbPushNewsReminder;

  @NonNull
  public final CheckBox cbPushNewsUpdates;

  @NonNull
  public final ToolBarBinding tbNotification;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  @Bindable
  protected User mUser;

  protected FragmentNotificationsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CheckBox cbEmailNewsUpdates, CheckBox cbEmailRemainder,
      CheckBox cbPushNewsReminder, CheckBox cbPushNewsUpdates, ToolBarBinding tbNotification,
      TextView textView10, TextView textView11, TextView textView12, TextView textView13,
      TextView textView8, TextView textView9) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbEmailNewsUpdates = cbEmailNewsUpdates;
    this.cbEmailRemainder = cbEmailRemainder;
    this.cbPushNewsReminder = cbPushNewsReminder;
    this.cbPushNewsUpdates = cbPushNewsUpdates;
    this.tbNotification = tbNotification;
    setContainedBinding(this.tbNotification);;
    this.textView10 = textView10;
    this.textView11 = textView11;
    this.textView12 = textView12;
    this.textView13 = textView13;
    this.textView8 = textView8;
    this.textView9 = textView9;
  }

  public abstract void setUser(@Nullable User user);

  @Nullable
  public User getUser() {
    return mUser;
  }

  @NonNull
  public static FragmentNotificationsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentNotificationsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentNotificationsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_notifications, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentNotificationsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentNotificationsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentNotificationsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_notifications, null, false, component);
  }

  public static FragmentNotificationsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentNotificationsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentNotificationsBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_notifications);
  }
}
