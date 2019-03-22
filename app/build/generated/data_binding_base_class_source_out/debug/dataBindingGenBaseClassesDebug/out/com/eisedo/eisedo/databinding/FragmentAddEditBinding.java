package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.Task;
import java.util.ArrayList;

public abstract class FragmentAddEditBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSave;

  @NonNull
  public final CheckBox cbNotify;

  @NonNull
  public final EditText etDelegateName;

  @NonNull
  public final TextView etDueDate;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etMailMsg;

  @NonNull
  public final TextView etRemainder;

  @NonNull
  public final EditText etTaskTitle;

  @NonNull
  public final Spinner spRepeat;

  @NonNull
  public final Spinner spTaskFolder;

  @NonNull
  public final Switch switchImportance;

  @NonNull
  public final ToolBarBinding tbAddEdit;

  @NonNull
  public final TextView textView14;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView tvAddTask;

  @NonNull
  public final View view2;

  @Bindable
  protected String mDefaultDate;

  @Bindable
  protected ArrayList<String> mRepeatItems;

  @Bindable
  protected Task mTask;

  @Bindable
  protected ArrayList<Folder> mFolders;

  protected FragmentAddEditBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnSave, CheckBox cbNotify, EditText etDelegateName,
      TextView etDueDate, EditText etEmail, EditText etMailMsg, TextView etRemainder,
      EditText etTaskTitle, Spinner spRepeat, Spinner spTaskFolder, Switch switchImportance,
      ToolBarBinding tbAddEdit, TextView textView14, TextView textView5, TextView tvAddTask,
      View view2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSave = btnSave;
    this.cbNotify = cbNotify;
    this.etDelegateName = etDelegateName;
    this.etDueDate = etDueDate;
    this.etEmail = etEmail;
    this.etMailMsg = etMailMsg;
    this.etRemainder = etRemainder;
    this.etTaskTitle = etTaskTitle;
    this.spRepeat = spRepeat;
    this.spTaskFolder = spTaskFolder;
    this.switchImportance = switchImportance;
    this.tbAddEdit = tbAddEdit;
    setContainedBinding(this.tbAddEdit);;
    this.textView14 = textView14;
    this.textView5 = textView5;
    this.tvAddTask = tvAddTask;
    this.view2 = view2;
  }

  public abstract void setDefaultDate(@Nullable String defaultDate);

  @Nullable
  public String getDefaultDate() {
    return mDefaultDate;
  }

  public abstract void setRepeatItems(@Nullable ArrayList<String> repeatItems);

  @Nullable
  public ArrayList<String> getRepeatItems() {
    return mRepeatItems;
  }

  public abstract void setTask(@Nullable Task task);

  @Nullable
  public Task getTask() {
    return mTask;
  }

  public abstract void setFolders(@Nullable ArrayList<Folder> folders);

  @Nullable
  public ArrayList<Folder> getFolders() {
    return mFolders;
  }

  @NonNull
  public static FragmentAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAddEditBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_add_edit, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAddEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAddEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAddEditBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_add_edit, null, false, component);
  }

  public static FragmentAddEditBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentAddEditBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentAddEditBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_add_edit);
  }
}
