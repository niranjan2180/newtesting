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
import com.eisedo.eisedo.data.local.entities.CheckList;
import com.eisedo.eisedo.data.local.entities.CheckListItem;
import java.util.ArrayList;

public abstract class FragmentCheckListBinding extends ViewDataBinding {
  @NonNull
  public final EditText etCheckListName;

  @NonNull
  public final RecyclerView rvCheckItems;

  @NonNull
  public final Toolbar toolbar4;

  @Bindable
  protected ArrayList<CheckListItem> mCheckListItems;

  @Bindable
  protected CheckList mCheckList;

  @Bindable
  protected CheckListItem mCheckListItem;

  protected FragmentCheckListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText etCheckListName, RecyclerView rvCheckItems, Toolbar toolbar4) {
    super(_bindingComponent, _root, _localFieldCount);
    this.etCheckListName = etCheckListName;
    this.rvCheckItems = rvCheckItems;
    this.toolbar4 = toolbar4;
  }

  public abstract void setCheckListItems(@Nullable ArrayList<CheckListItem> checkListItems);

  @Nullable
  public ArrayList<CheckListItem> getCheckListItems() {
    return mCheckListItems;
  }

  public abstract void setCheckList(@Nullable CheckList checkList);

  @Nullable
  public CheckList getCheckList() {
    return mCheckList;
  }

  public abstract void setCheckListItem(@Nullable CheckListItem checkListItem);

  @Nullable
  public CheckListItem getCheckListItem() {
    return mCheckListItem;
  }

  @NonNull
  public static FragmentCheckListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCheckListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCheckListBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_check_list, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentCheckListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCheckListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCheckListBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_check_list, null, false, component);
  }

  public static FragmentCheckListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentCheckListBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentCheckListBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_check_list);
  }
}
