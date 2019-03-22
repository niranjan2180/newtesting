package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eisedo.eisedo.data.local.entities.TimeZone;
import java.util.ArrayList;

public abstract class FragmentTimezoneSlelectionBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvTimezoneSelection;

  @NonNull
  public final EditText svTimezone;

  @NonNull
  public final Toolbar tbTitle;

  @Bindable
  protected ArrayList<TimeZone> mTimeZones;

  protected FragmentTimezoneSlelectionBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvTimezoneSelection, EditText svTimezone,
      Toolbar tbTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvTimezoneSelection = rvTimezoneSelection;
    this.svTimezone = svTimezone;
    this.tbTitle = tbTitle;
  }

  public abstract void setTimeZones(@Nullable ArrayList<TimeZone> timeZones);

  @Nullable
  public ArrayList<TimeZone> getTimeZones() {
    return mTimeZones;
  }

  @NonNull
  public static FragmentTimezoneSlelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTimezoneSlelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTimezoneSlelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_timezone_slelection, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTimezoneSlelectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTimezoneSlelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTimezoneSlelectionBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_timezone_slelection, null, false, component);
  }

  public static FragmentTimezoneSlelectionBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentTimezoneSlelectionBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentTimezoneSlelectionBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_timezone_slelection);
  }
}
