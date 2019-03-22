package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentMyDetailsBinding extends ViewDataBinding {
  @NonNull
  public final Toolbar tbTitle;

  @NonNull
  public final TextInputLayout textInputLayout;

  @NonNull
  public final TextInputLayout textInputLayout2;

  @NonNull
  public final TextInputLayout textInputLayout3;

  @NonNull
  public final TextInputLayout textInputLayout4;

  @NonNull
  public final TextInputLayout textInputLayout5;

  @NonNull
  public final TextInputEditText tieEmail;

  @NonNull
  public final TextInputEditText tieLanguage;

  @NonNull
  public final TextInputEditText tieLocation;

  @NonNull
  public final TextInputEditText tieName;

  @NonNull
  public final TextInputEditText tiePassword;

  @NonNull
  public final TextInputEditText tieTimeZone;

  @Bindable
  protected User mUser;

  protected FragmentMyDetailsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Toolbar tbTitle, TextInputLayout textInputLayout,
      TextInputLayout textInputLayout2, TextInputLayout textInputLayout3,
      TextInputLayout textInputLayout4, TextInputLayout textInputLayout5,
      TextInputEditText tieEmail, TextInputEditText tieLanguage, TextInputEditText tieLocation,
      TextInputEditText tieName, TextInputEditText tiePassword, TextInputEditText tieTimeZone) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tbTitle = tbTitle;
    this.textInputLayout = textInputLayout;
    this.textInputLayout2 = textInputLayout2;
    this.textInputLayout3 = textInputLayout3;
    this.textInputLayout4 = textInputLayout4;
    this.textInputLayout5 = textInputLayout5;
    this.tieEmail = tieEmail;
    this.tieLanguage = tieLanguage;
    this.tieLocation = tieLocation;
    this.tieName = tieName;
    this.tiePassword = tiePassword;
    this.tieTimeZone = tieTimeZone;
  }

  public abstract void setUser(@Nullable User user);

  @Nullable
  public User getUser() {
    return mUser;
  }

  @NonNull
  public static FragmentMyDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMyDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMyDetailsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_my_details, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMyDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMyDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMyDetailsBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_my_details, null, false, component);
  }

  public static FragmentMyDetailsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMyDetailsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMyDetailsBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_my_details);
  }
}
