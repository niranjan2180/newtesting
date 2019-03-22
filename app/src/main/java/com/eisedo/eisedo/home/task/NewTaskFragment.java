package com.eisedo.eisedo.home.task;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentNewTaskBinding;
import com.eisedo.eisedo.util.Util;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.fragment.app.Fragment;

public class NewTaskFragment extends Fragment {

    private static Context context;

    @BindingAdapter("setDateNAttrChanged")
    public static void setListners(TextView textView, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener != null) {
            textView.setOnClickListener(v -> setDateSelection(textView, inverseBindingListener));
        }
    }

    @BindingAdapter("setDateN")
    public static void setDateNData(TextView textView, Date date) {
        textView.setText((date == null ? context.getString(R.string.due_date) : Util.displayDate(date)));
    }

    @InverseBindingAdapter(attribute = "setDateN")
    public static Date getDateNData(TextView view) {
        return Util.stringToDate(view.getText().toString());
    }

    @BindingAdapter("setDateTime")
    public static void setDateTime(TextView dateTimeText, Date dateTime) {
        dateTimeText.setText((dateTime == null ? context.getString(R.string.reminder) : Util.displayDateTime(dateTime)));
    }

    @InverseBindingAdapter(attribute = "setDateTime")
    public static Date getDateTime(TextView view) {
        return Util.stringToDate(view.getText().toString());
    }

    @BindingAdapter("setDateTimeAttrChanged")
    public static void setListnerTime(TextView textView, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener != null) {
            textView.setOnClickListener(v -> setDateTimeSelection(textView, inverseBindingListener));
        }
    }

    public static Task task;

    @BindingAdapter("starredAttrChanged")
    public static void setListner(ImageView view, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener != null) {
            if (task.star) {
                view.setImageResource(R.drawable.ic_star);
            } else {
                view.setImageResource(R.drawable.ic_star_border);
            }
            inverseBindingListener.onChange();
        }
    }

    @BindingAdapter("starred")
    public static void setStarred(ImageView view, boolean starrred) {
        view.setImageResource(starrred ? R.drawable.ic_star : R.drawable.ic_star_border);
    }


    @InverseBindingAdapter(attribute = "starred")
    public static boolean getStarred(ImageView view) {
        if (view.getDrawable().getConstantState() == context.getResources().getDrawable(R.drawable.ic_star_border).getConstantState()){
            return true;
        }else {
            return false;
        }
    }

    private TaskViewModel taskViewModel;

    public static NewTaskFragment newTaskFragment = null;

    public static NewTaskFragment getInstance() {
        if (newTaskFragment == null) {
            newTaskFragment = new NewTaskFragment();
        }
        return newTaskFragment;
    }

    private FragmentNewTaskBinding fragmentNewTaskBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        setHasOptionsMenu(false);
    }

    private long task_id = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        task = new Task();

        task_id = getArguments().getLong("task_id");

        fragmentNewTaskBinding = FragmentNewTaskBinding.inflate(inflater, container, false);

        taskViewModel = TaskActivity.obtainViewModel(getActivity());

        if (task_id == -1){
            task = new Task();
        }else {
            taskViewModel.getTaskById(task_id);
        }

        fragmentNewTaskBinding.setTask(task);

        taskViewModel.getTaskMutableLiveData().observe(this, task -> {
            this.task = task;
            fragmentNewTaskBinding.setTask(task);
        });

        TaskManager taskManager = new TaskManager();

        fragmentNewTaskBinding.setTaskManager(taskManager);

//        fragmentNewTaskBinding.tvDueDate.setOnClickListener(v -> {
//            Log.d("USers", "OnClivk");
//        });

//        fragmentNewTaskBinding.tvSave.setOnClickListener(v -> Log.d("Clicked","value"));

        taskViewModel.getTaskDetail();

        return fragmentNewTaskBinding.getRoot();
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
            }), mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    public static void setDateTimeSelection(TextView dateandTime, InverseBindingListener inverseBindingListener) {

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        if (context != null) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(context, ((view, year, month, dayOfMonth) -> {

                dateandTime.setText(Util.changeToDateFormat(dayOfMonth + "/" + (month + 1) + "/" + year));
                inverseBindingListener.onChange();
                setTimeSelection(Util.stringToDate(dayOfMonth + "/" + (month + 1) + "/" + year),dateandTime, inverseBindingListener);

            }), mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    public static void setTimeSelection(Date date,TextView timeSelection, InverseBindingListener inverseBindingListener) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int mHours = calendar.get(Calendar.HOUR);
        int mMinute = calendar.get(Calendar.MINUTE);
        if (context != null) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(context, ((view, hourOfDay, minute) -> {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);

                timeSelection.setText(Util.displayDateTime(calendar.getTime()));
                inverseBindingListener.onChange();
            }), mHours, mMinute, true);
            timePickerDialog.show();
        }
    }

    void setUpActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentNewTaskBinding.tbNewItem);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(R.string.new_task);
    }


    public class TaskManager {

        public void addDelegate() {
            //TODO -- open Delegate Fragment
            Log.d("DelegateCall", "CallDelegate");
            taskViewModel.navigationTaskEvent(5);
        }

        public void addNote() {
            //TODO -- open Add Note Fragment
            Log.d("NoteCall", "Call Note");
            taskViewModel.navigationTaskEvent(4);
        }

        public void addFolder() {
            //TODO -- open Folder Selection
            Log.d("FolderCall", "Call Folder");
            taskViewModel.navigationTaskEvent(6);
        }

        public void selectRepeat() {
            //TODO -- open Folder Selection
            Log.d("FolderCall", "Call Folder");
            taskViewModel.navigationTaskEvent(8);
        }


        public void saveTask() {
            //TODO -- save Task to Database
            if (task_id == -1){
                taskViewModel.saveTask();
            }else {
                taskViewModel.updateTask(task);
            }

            Log.d("Clicked", "value  " + task.toString());
        }

        public void cancelTask() {
            //TODO -- cancel
            Log.d("Cancel", "Task");
            taskViewModel.navigationTaskEvent(7);
        }

        public void onStared(){
            Log.d("Task", task.star + "");

            if (task.star){
                task.setStar(false);
            }else {
                task.setStar(true);
            }

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        taskViewModel.resetTaskDetail();
    }
}