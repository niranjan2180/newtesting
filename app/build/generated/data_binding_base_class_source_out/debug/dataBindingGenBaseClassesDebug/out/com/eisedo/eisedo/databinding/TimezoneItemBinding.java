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
import com.eisedo.eisedo.data.local.entities.TimeZone;

public abstract class TimezoneItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clTimezone;

  @NonNull
  public final ImageView ivImage;

  @NonNull
  public final ImageView ivSelected;

  @NonNull
  public final TextView tvSortName;

  @Bindable
  protected TimeZone mTimezone;

  @Bindable
  protected int mPosition;

  @Bindable
  protected View mView;

  protected TimezoneItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clTimezone, ImageView ivImage, ImageView ivSelected,
      TextView tvSortName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clTimezone = clTimezone;
    this.ivImage = ivImage;
    this.ivSelected = ivSelected;
    this.tvSortName = tvSortName;
  }

  public abstract void setTimezone(@Nullable TimeZone timezone);

  @Nullable
  public TimeZone getTimezone() {
    return mTimezone;
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
  public static TimezoneItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TimezoneItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TimezoneItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.timezone_item, root, attachToRoot, component);
  }

  @NonNull
  public static TimezoneItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TimezoneItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TimezoneItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.timezone_item, null, false, component);
  }

  public static TimezoneItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static TimezoneItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (TimezoneItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.timezone_item);
  }
}
