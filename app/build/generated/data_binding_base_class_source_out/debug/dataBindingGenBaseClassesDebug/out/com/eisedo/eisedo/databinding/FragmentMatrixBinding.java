package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentMatrixBinding extends ViewDataBinding {
  @NonNull
  public final ToolBarBinding tbMatrix;

  @NonNull
  public final TextInputLayout textInputLayout10;

  @NonNull
  public final TextInputLayout textInputLayout11;

  @NonNull
  public final TextInputLayout textInputLayout8;

  @NonNull
  public final TextInputLayout textInputLayout9;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextInputEditText tieBuck1;

  @NonNull
  public final TextInputEditText tieBuck2;

  @NonNull
  public final TextInputEditText tieBuck3;

  @NonNull
  public final TextInputEditText tieBuck4;

  @NonNull
  public final TextInputEditText tieUrgency;

  @Bindable
  protected User mUser;

  protected FragmentMatrixBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ToolBarBinding tbMatrix, TextInputLayout textInputLayout10,
      TextInputLayout textInputLayout11, TextInputLayout textInputLayout8,
      TextInputLayout textInputLayout9, TextView textView3, TextView textView4, TextView textView6,
      TextView textView7, TextInputEditText tieBuck1, TextInputEditText tieBuck2,
      TextInputEditText tieBuck3, TextInputEditText tieBuck4, TextInputEditText tieUrgency) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tbMatrix = tbMatrix;
    setContainedBinding(this.tbMatrix);;
    this.textInputLayout10 = textInputLayout10;
    this.textInputLayout11 = textInputLayout11;
    this.textInputLayout8 = textInputLayout8;
    this.textInputLayout9 = textInputLayout9;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView6 = textView6;
    this.textView7 = textView7;
    this.tieBuck1 = tieBuck1;
    this.tieBuck2 = tieBuck2;
    this.tieBuck3 = tieBuck3;
    this.tieBuck4 = tieBuck4;
    this.tieUrgency = tieUrgency;
  }

  public abstract void setUser(@Nullable User user);

  @Nullable
  public User getUser() {
    return mUser;
  }

  @NonNull
  public static FragmentMatrixBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMatrixBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMatrixBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_matrix, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMatrixBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMatrixBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMatrixBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_matrix, null, false, component);
  }

  public static FragmentMatrixBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMatrixBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMatrixBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_matrix);
  }
}