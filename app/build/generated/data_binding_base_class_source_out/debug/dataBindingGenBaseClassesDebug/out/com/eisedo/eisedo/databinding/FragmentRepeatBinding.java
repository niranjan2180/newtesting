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
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public abstract class FragmentRepeatBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvRepeatItems;

  @NonNull
  public final Toolbar tbRepeat;

  @Bindable
  protected ArrayList<String> mRepeat;

  protected FragmentRepeatBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvRepeatItems, Toolbar tbRepeat) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvRepeatItems = rvRepeatItems;
    this.tbRepeat = tbRepeat;
  }

  public abstract void setRepeat(@Nullable ArrayList<String> repeat);

  @Nullable
  public ArrayList<String> getRepeat() {
    return mRepeat;
  }

  @NonNull
  public static FragmentRepeatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentRepeatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentRepeatBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_repeat, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentRepeatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentRepeatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentRepeatBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_repeat, null, false, component);
  }

  public static FragmentRepeatBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentRepeatBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentRepeatBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_repeat);
  }
}
