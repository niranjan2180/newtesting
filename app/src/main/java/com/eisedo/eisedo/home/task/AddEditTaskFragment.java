package com.eisedo.eisedo.home.task;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentAddEditBinding;
import com.eisedo.eisedo.home.home_item.HomeItemViewModel;
import com.eisedo.eisedo.home.home_item.HomeItemsActivity;
import com.eisedo.eisedo.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.fragment.app.Fragment;

public class AddEditTaskFragment extends Fragment {

    //Two way binding
    @BindingAdapter("setDateAttrChanged")
    public static void setListner(TextView textView, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener != null) {
            textView.setOnClickListener(v -> setDateSelection(textView, inverseBindingListener));
        }
    }

    @BindingAdapter("setDate")
    public static void setDateData(TextView textView, Date date) {
        Log.d("DateVAleu", date + " ");
        if (date != null)
            textView.setText(Util.displayDate(date));
    }

    @InverseBindingAdapter(attribute = "setDate")
    public static Date getDateData(TextView view) {
        return Util.stringToDate(view.getText().toString());
    }

    private HomeItemViewModel homeItemViewModel;

    private FragmentAddEditBinding fragmentAddEditBinding;

    private Task task;

    private static Activity context;

    private ArrayList<Folder> folders = new ArrayList<>();

    public static AddEditTaskFragment addEditTaskFragment = null;

    public static AddEditTaskFragment getInstance(){
        if (addEditTaskFragment == null){
            addEditTaskFragment = new AddEditTaskFragment();
        }
        return addEditTaskFragment;
    }


    @BindingAdapter("setRepeatOptions")
    public static void setRepeatOptions(Spinner spinner, ArrayList<String> strings) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, strings);
        spinner.setAdapter(adapter);
    }

    @BindingAdapter("setFolders")
    public static void setFolders(Spinner spinner, ArrayList<Folder> folders) {
        ArrayAdapter<Folder> adapter = new ArrayAdapter<Folder>(context, android.R.layout.simple_spinner_item, folders);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
        homeItemViewModel = HomeItemsActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentAddEditBinding = FragmentAddEditBinding.inflate(inflater, container, false);

//        setUpActionBar();

        ArrayList<String> repeatOptions = new ArrayList<>();
        repeatOptions.add("Never Repeat");
        repeatOptions.add("Every Day");
        repeatOptions.add("Every Week");
        repeatOptions.add("Every Month");
        repeatOptions.add("Every Year");

        folders.add(new Folder("Inbox", 1, false));

        fragmentAddEditBinding.setFolders(folders);

        homeItemViewModel.listAllFolders();

        homeItemViewModel.getFolderListMutableLiveData().observe(this, folders1 -> {
            this.folders.clear();
            folders.add(new Folder("Inbox", 1, false));
            folders.addAll(folders1);
            fragmentAddEditBinding.setFolders(folders);

        });

        fragmentAddEditBinding.setDefaultDate("Due DAte");

        fragmentAddEditBinding.setRepeatItems(repeatOptions);
        task = new Task();

        if (getArguments() == null) {
        } else {
            long task_id = getArguments().getLong("TASK_ID", -1);

            if (task_id == -1) {
//                task = new Task();
            } else {
                homeItemViewModel.getTaskMutableLiveData().observe(this, task1 -> {
                    task = task1;
                    fragmentAddEditBinding.setTask(task);
                });
                homeItemViewModel.getTaskById(task_id);
            }
        }

        fragmentAddEditBinding.setTask(task);

//        homeItemViewModel.getAllTasks();

        homeItemViewModel.getCloseFragmentMutableLiveData().observe(this, aBoolean -> {
            if (aBoolean) getActivity().getSupportFragmentManager().popBackStack();
            homeItemViewModel.removeInstance();
        });


        fragmentAddEditBinding.spRepeat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                task.setRepeat(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        fragmentAddEditBinding.spTaskFolder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                task.set
//                Log.d("FolderId", fragmentAddEditBinding.spTaskFolder.getSelectedItem().toString());
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        fragmentAddEditBinding.btnSave.setOnClickListener(v -> {

            Log.d("Folder", task.getFolder_id() + " ");
            if (task.getTitle() != null) {
                task.setBucket(homeItemViewModel.setBucketValue(task));
                if (task.getId() == 0) {
                    homeItemViewModel.addTask(task);
                } else {
                    homeItemViewModel.edit(task);
                }
            } else {
                fragmentAddEditBinding.etTaskTitle.setError("Enter Title");
            }
        });

        return fragmentAddEditBinding.getRoot();
    }

    void setUpActionBar() {

        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentAddEditBinding.tbAddEdit.tbTitle);

        androidx.appcompat.app.ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.add_edit_task);

    }

    public static void setDateSelection(TextView dateandTime, InverseBindingListener inverseBindingListener) {

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        if (context != null) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(context, ((view, year, month, dayOfMonth) -> {

                dateandTime.setText(Util.changeToDateFormat(dayOfMonth + "/" + (month + 1) + "/" + year));
                inverseBindingListener.onChange();
                setTimeSelection(dateandTime, inverseBindingListener);
            }), mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    public static void setTimeSelection(TextView timeSelection, InverseBindingListener inverseBindingListener) {
        final Calendar calendar = Calendar.getInstance();

        int mHours = calendar.get(Calendar.HOUR);
        int mMinute = calendar.get(Calendar.MINUTE);
        if (context != null) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(context, ((view, hourOfDay, minute) -> {
                timeSelection.setText(hourOfDay + " " + minute);
            }), mHours, mMinute, false);
            timePickerDialog.show();
        }
    }
}