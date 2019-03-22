package com.eisedo.eisedo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.home.task.NewTaskFragment;

public abstract class FragmentNewTaskBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final EditText etTitle;

  @NonNull
  public final ImageView ivFavourite;

  @NonNull
  public final Switch switchImportance;

  @NonNull
  public final Toolbar tbNewItem;

  @NonNull
  public final TextView tvAddNote;

  @NonNull
  public final TextView tvClose;

  @NonNull
  public final TextView tvDelegate;

  @NonNull
  public final TextView tvDueDate;

  @NonNull
  public final TextView tvFolder;

  @NonNull
  public final TextView tvMessage;

  @NonNull
  public final TextView tvReminder;

  @NonNull
  public final TextView tvRepeat;

  @NonNull
  public final TextView tvSave;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final View view5;

  @NonNull
  public final View viewDueDate;

  @Bindable
  protected Task mTask;

  @Bindable
  protected NewTaskFragment.TaskManager mTaskManager;

  protected FragmentNewTaskBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout constraintLayout, EditText etTitle,
      ImageView ivFavourite, Switch switchImportance, Toolbar tbNewItem, TextView tvAddNote,
      TextView tvClose, TextView tvDelegate, TextView tvDueDate, TextView tvFolder,
      TextView tvMessage, TextView tvReminder, TextView tvRepeat, TextView tvSave, TextView tvTitle,
      View view5, View viewDueDate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.constraintLayout = constraintLayout;
    this.etTitle = etTitle;
    this.ivFavourite = ivFavourite;
    this.switchImportance = switchImportance;
    this.tbNewItem = tbNewItem;
    this.tvAddNote = tvAddNote;
    this.tvClose = tvClose;
    this.tvDelegate = tvDelegate;
    this.tvDueDate = tvDueDate;
    this.tvFolder = tvFolder;
    this.tvMessage = tvMessage;
    this.tvReminder = tvReminder;
    this.tvRepeat = tvRepeat;
    this.tvSave = tvSave;
    this.tvTitle = tvTitle;
    this.view5 = view5;
    this.viewDueDate = viewDueDate;
  }

  public abstract void setTask(@Nullable Task task);

  @Nullable
  public Task getTask() {
    return mTask;
  }

  public abstract void setTaskManager(@Nullable NewTaskFragment.TaskManager taskManager);

  @Nullable
  public NewTaskFragment.TaskManager getTaskManager() {
    return mTaskManager;
  }

  @NonNull
  public static FragmentNewTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentNewTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentNewTaskBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_new_task, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentNewTaskBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentNewTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentNewTaskBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_new_task, null, false, component);
  }

  public static FragmentNewTaskBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentNewTaskBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentNewTaskBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_new_task);
  }
}
