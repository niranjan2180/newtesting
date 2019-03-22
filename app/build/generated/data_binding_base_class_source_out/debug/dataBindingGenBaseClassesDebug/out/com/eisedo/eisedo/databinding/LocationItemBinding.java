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
import com.eisedo.eisedo.data.local.entities.Location;

public abstract class LocationItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clLocation;

  @NonNull
  public final ImageView ivImage;

  @NonNull
  public final ImageView ivSelected;

  @NonNull
  public final TextView tvSortName;

  @Bindable
  protected Location mLocation;

  @Bindable
  protected int mPosition;

  @Bindable
  protected View mView;

  protected LocationItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clLocation, ImageView ivImage, ImageView ivSelected,
      TextView tvSortName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clLocation = clLocation;
    this.ivImage = ivImage;
    this.ivSelected = ivSelected;
    this.tvSortName = tvSortName;
  }

  public abstract void setLocation(@Nullable Location location);

  @Nullable
  public Location getLocation() {
    return mLocation;
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
  public static LocationItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LocationItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LocationItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.location_item, root, attachToRoot, component);
  }

  @NonNull
  public static LocationItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LocationItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LocationItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.location_item, null, false, component);
  }

  public static LocationItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static LocationItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (LocationItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.location_item);
  }
}
