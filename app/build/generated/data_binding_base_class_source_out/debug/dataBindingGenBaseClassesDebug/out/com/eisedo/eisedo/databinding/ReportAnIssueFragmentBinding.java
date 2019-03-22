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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class ReportAnIssueFragmentBinding extends ViewDataBinding {
  @NonNull
  public final Toolbar tbTitle;

  @NonNull
  public final TextInputLayout textInputLayout21;

  @NonNull
  public final TextInputEditText tieMessage;

  @NonNull
  public final TextInputEditText tieSubject;

  @Bindable
  protected String mSubject;

  @Bindable
  protected String mMessage;

  protected ReportAnIssueFragmentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Toolbar tbTitle, TextInputLayout textInputLayout21,
      TextInputEditText tieMessage, TextInputEditText tieSubject) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tbTitle = tbTitle;
    this.textInputLayout21 = textInputLayout21;
    this.tieMessage = tieMessage;
    this.tieSubject = tieSubject;
  }

  public abstract void setSubject(@Nullable String subject);

  @Nullable
  public String getSubject() {
    return mSubject;
  }

  public abstract void setMessage(@Nullable String message);

  @Nullable
  public String getMessage() {
    return mMessage;
  }

  @NonNull
  public static ReportAnIssueFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ReportAnIssueFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ReportAnIssueFragmentBinding>inflate(inflater, com.eisedo.eisedo.R.layout.report_an_issue_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static ReportAnIssueFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ReportAnIssueFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ReportAnIssueFragmentBinding>inflate(inflater, com.eisedo.eisedo.R.layout.report_an_issue_fragment, null, false, component);
  }

  public static ReportAnIssueFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ReportAnIssueFragmentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ReportAnIssueFragmentBinding)bind(component, view, com.eisedo.eisedo.R.layout.report_an_issue_fragment);
  }
}
