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
import com.eisedo.eisedo.data.RepeatType;

public abstract class RepeatItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final ImageView ivSelected;

  @NonNull
  public final TextView tvRepeatType;

  @Bindable
  protected RepeatType mRepeatType;

  @Bindable
  protected Integer mSelectedPosition;

  @Bindable
  protected View mView;

  protected RepeatItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clContainer, ImageView ivSelected,
      TextView tvRepeatType) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clContainer = clContainer;
    this.ivSelected = ivSelected;
    this.tvRepeatType = tvRepeatType;
  }

  public abstract void setRepeatType(@Nullable RepeatType repeatType);

  @Nullable
  public RepeatType getRepeatType() {
    return mRepeatType;
  }

  public abstract void setSelectedPosition(@Nullable Integer selectedPosition);

  @Nullable
  public Integer getSelectedPosition() {
    return mSelectedPosition;
  }

  public abstract void setView(@Nullable View view);

  @Nullable
  public View getView() {
    return mView;
  }

  @NonNull
  public static RepeatItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RepeatItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RepeatItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.repeat_item, root, attachToRoot, component);
  }

  @NonNull
  public static RepeatItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RepeatItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RepeatItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.repeat_item, null, false, component);
  }

  public static RepeatItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static RepeatItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (RepeatItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.repeat_item);
  }
}
