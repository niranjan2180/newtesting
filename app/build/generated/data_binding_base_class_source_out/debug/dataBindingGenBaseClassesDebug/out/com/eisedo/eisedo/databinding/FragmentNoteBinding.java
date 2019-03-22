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
import com.eisedo.eisedo.data.local.entities.Task;

public abstract class FragmentNoteBinding extends ViewDataBinding {
  @NonNull
  public final EditText etTaskNote;

  @NonNull
  public final Toolbar tbAddNote;

  @Bindable
  protected Task mTask;

  protected FragmentNoteBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText etTaskNote, Toolbar tbAddNote) {
    super(_bindingComponent, _root, _localFieldCount);
    this.etTaskNote = etTaskNote;
    this.tbAddNote = tbAddNote;
  }

  public abstract void setTask(@Nullable Task task);

  @Nullable
  public Task getTask() {
    return mTask;
  }

  @NonNull
  public static FragmentNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentNoteBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_note, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentNoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentNoteBinding>inflate(inflater, com.eisedo.eisedo.R.layout.fragment_note, null, false, component);
  }

  public static FragmentNoteBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentNoteBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentNoteBinding)bind(component, view, com.eisedo.eisedo.R.layout.fragment_note);
  }
}
