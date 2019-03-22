package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.Delegate;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentDelagateBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox cbNotifyEmail;

  @NonNull
  public final EditText etDelegateName;

  @NonNull
  public final Toolbar tbDelegate;

  @NonNull
  public final TextInputLayout textInputLayout13;

  @NonNull
  public final TextInputEditText tieDelegateEmail;

  @NonNull
  public final TextInputEditText tieDelegateMessage;

  @NonNull
  public final TextInputLayout tilMessage;

  @Bindable
  protected Delegate mDelegate;

  @Bindable
  protected View mView;

  protected FragmentDelagateBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CheckBox cbNotifyEmail, EditText etDelegateName, Toolbar tbDelegate,
      TextInputLayout textInputLayout13, TextInputEditText tieDelegateEmail,
      TextInputEditText tieDelegateMessage, TextInputLayout tilMessage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbNotifyEmail = cbNotifyEmail;
    this.etDelegateName = etDelegateName;
    this.tbDelegate = tbDelegate;
    this.textInputLayout13 = textInputLayout13;
    this.tieDelegateEmail = tieDelegateEmail;
    this.tieDelegateMessage = tieDelegateMessage;
    this.tilMessage = tilMessage;
  }

  public abstract void setDelegate(@Nullable Delegate delegate);

  @Nullable
  public Delegate getDelegate() {
    return mDelegate;
  }

  public abstract void setView(@Nullable View view);

  @Nullable
  public View getView() {
    return mView;
  }

  @NonNull
  public static FragmentDelagateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentDelagateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentDelagateBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_delagate, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentDelagateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentDelagateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentDelagateBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_delagate, null, false, component);
  }

  public static FragmentDelagateBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentDelagateBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentDelagateBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_delagate);
  }
}
