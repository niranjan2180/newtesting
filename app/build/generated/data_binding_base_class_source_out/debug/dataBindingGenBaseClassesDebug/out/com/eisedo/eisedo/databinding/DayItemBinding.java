package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DayItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clDay;

  @NonNull
  public final ImageView ivImage;

  @NonNull
  public final ImageView ivSelected;

  @NonNull
  public final TextView tvDay;

  @Bindable
  protected String mDay;

  @Bindable
  protected int mPosition;

  @Bindable
  protected View mView;

  protected DayItemBinding(DataBindingComponent _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout clDay, ImageView ivImage, ImageView ivSelected, TextView tvDay) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clDay = clDay;
    this.ivImage = ivImage;
    this.ivSelected = ivSelected;
    this.tvDay = tvDay;
  }

  public abstract void setDay(@Nullable String day);

  @Nullable
  public String getDay() {
    return mDay;
  }

  public abstract void setPosition(int position);

  public int getPosition() {
    return mPosition;
  }

  public abstract void setView(@Nullable View view);

  @Nullable
  public View getView() {
    return mView;
  }

  @NonNull
  public static DayItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DayItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DayItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.day_item, root, attachToRoot, component);
  }

  @NonNull
  public static DayItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DayItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DayItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.day_item, null, false, component);
  }

  public static DayItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DayItemBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (DayItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.day_item);
  }
}
