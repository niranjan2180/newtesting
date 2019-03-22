package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.CheckListItem;

public abstract class CheckItemBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox cbComplete;

  @NonNull
  public final ConstraintLayout clContainer;

  @NonNull
  public final TextView tvCheckName;

  @Bindable
  protected CheckListItem mCheckListItem;

  protected CheckItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CheckBox cbComplete, ConstraintLayout clContainer,
      TextView tvCheckName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbComplete = cbComplete;
    this.clContainer = clContainer;
    this.tvCheckName = tvCheckName;
  }

  public abstract void setCheckListItem(@Nullable CheckListItem checkListItem);

  @Nullable
  public CheckListItem getCheckListItem() {
    return mCheckListItem;
  }

  @NonNull
  public static CheckItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CheckItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CheckItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.check_item, root, attachToRoot, component);
  }

  @NonNull
  public static CheckItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CheckItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CheckItemBinding>inflate(inflater, com.eisedo.eisedo.R.layout.check_item, null, false, component);
  }

  public static CheckItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static CheckItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (CheckItemBinding)bind(component, view, com.eisedo.eisedo.R.layout.check_item);
  }
}
