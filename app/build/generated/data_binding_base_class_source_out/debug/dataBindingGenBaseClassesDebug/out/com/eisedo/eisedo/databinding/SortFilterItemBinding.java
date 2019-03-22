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
import com.eisedo.eisedo.data.local.entities.SortFilter;

public abstract class SortFilterItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clSortFilterItem;

  @NonNull
  public final ImageView ivImage;

  @NonNull
  public final ImageView ivSelected;

  @NonNull
  public final TextView tvSortName;

  @Bindable
  protected SortFilter mSortFilter;

  @Bindable
  protected int mPosition;

  @Bindable
  protected int mSelectedPosition;

  @Bindable
  protected View mView;

  protected SortFilterItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout clSortFilterItem, ImageView ivImage,
      ImageView ivSelected, TextView tvSortName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clSortFilterItem = clSortFilterItem;
    this.ivImage = ivImage;
    this.ivSelected = ivSelected;
    this.tvSortName = tvSortName;
  }

  public abstract void setSortFilter(@Nullable SortFilter sortFilter);

  @Nullable
  public SortFilter getSortFilter() {
    return mSortFilter;
  }

  public abstract void setPosition(int position);

  public int getPosition() {
    return mPosition;
  }

  public abstract void setSelectedPosition(int selectedPosition);

  public int getSelectedPosition() {
    return mSelectedPosition;
  }

  public abstract void setView(@Nullable View view);

  @Nullable
  public View getView() {
    return mView;
  }

  @NonNull
  public static SortFilterItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SortFilterItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SortFilterItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.sort_filter_item, root, attachToRoot, component);
  }

  @NonNull
  public static SortFilterItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SortFilterItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SortFilterItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.sort_filter_item, null, false, component);
  }

  public static SortFilterItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static SortFilterItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (SortFilterItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.sort_filter_item);
  }
}
