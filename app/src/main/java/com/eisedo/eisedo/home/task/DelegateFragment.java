package com.eisedo.eisedo.home.task;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Delegate;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentDelagateBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DelegateFragment extends Fragment {

    private static FragmentDelagateBinding fragmentDelagateBinding;

    public static DelegateFragment delegateFragment = null;

    public static DelegateFragment getInstance() {
        if (delegateFragment == null) {
            delegateFragment = new DelegateFragment();
        }
        return delegateFragment;
    }

//    @BindingAdapter("notifyAttrChanged")
//    public static void setListener(CheckBox checkBox, InverseBindingListener inverseBindingListener) {
//        if (inverseBindingListener != null) {
//            if (checkBox.isChecked()) {
//                fragmentDelagateBinding.textInputLayout13.setVisibility(View.VISIBLE);
//            } else {
//                fragmentDelagateBinding.textInputLayout13.setVisibility(View.GONE);
//            }
//            inverseBindingListener.onChange();
//        }
//    }
//
//
//    @BindingAdapter("notify")
//    public static void setNotify(CheckBox notify, boolean b) {
//        notify.setChecked(b);
//    }
//
//    @InverseBindingAdapter(attribute = "notify")
//    public static boolean getNotify(CheckBox view) {
//        return view.isChecked();
//    }

    private TaskViewModel taskViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
        setRetainInstance(true);
        taskViewModel = TaskActivity.obtainViewModel(getActivity());

    }

    private Delegate delegate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentDelagateBinding = FragmentDelagateBinding.inflate(inflater, container, false);

        if (taskViewModel.getTaskMutableLiveData().getValue().getDelegate() == null) {
            delegate = new Delegate();
        } else {
            delegate = taskViewModel.getTaskMutableLiveData().getValue().getDelegate();
        }

        fragmentDelagateBinding.setDelegate(delegate);

        taskViewModel.getTaskMutableLiveData().observe(this, task -> {
//            fragmentDelagateBinding.setDelegate(task.getDelegate());
//            if (task.getDelegate() != null){
//                Log.d("TAskDelegate", task.getDelegate().isNotify() + " ");
//            }
        });

        taskViewModel.getTaskDetail();
//        fragmentDelagateBinding.setDelegate();

        fragmentDelagateBinding.cbNotifyEmail.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.d("Chedcked", "Checked");
            if (isChecked) {
                fragmentDelagateBinding.textInputLayout13.setVisibility(View.VISIBLE);
                fragmentDelagateBinding.tilMessage.setVisibility(View.VISIBLE);
                Log.d("Chedcked", "Checked " + isChecked);
            } else {
                fragmentDelagateBinding.textInputLayout13.setVisibility(View.GONE);
                fragmentDelagateBinding.tilMessage.setVisibility(View.GONE);
                Log.d("Chedcked", "Checked " + isChecked);
            }
        });

        setUpActionBar();

        return fragmentDelagateBinding.getRoot();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d("Delegate","Home");
                break;
            case R.id.item_save:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    void saveDelegate(){
        delegate.setNotify(fragmentDelagateBinding.cbNotifyEmail.isChecked());
        if (validateDelegate(delegate)){
            if (!delegate.isNotify()){
                delegate.setEmail("");
                delegate.setMessage("");
            }
            Task task = taskViewModel.getTaskMutableLiveData().getValue();
            task.setDelegate(delegate);
            taskViewModel.updateTask(task);
        }

        Log.d("Task", delegate.isNotify() + " " + delegate.delegate_name + " "  + delegate.email + " " + delegate.message);
    }

    boolean validateDelegate(Delegate delegate){

        if (delegate.getDelegate_name().isEmpty()){
            fragmentDelagateBinding.etDelegateName.setError("Enter Delegate Name");
            return false;
        }else if (delegate.isNotify()){
            if (delegate.email.trim().length() ==0){
                fragmentDelagateBinding.tieDelegateEmail.setError("Enter Delegate Email");
                return false;
            }else if (!delegate.email.contains(".") || !delegate.email.contains("@")){
                fragmentDelagateBinding.tieDelegateEmail.setError("Enter Valid Email");
                return false;
            }else {
                return true;
            }
        }else {
            return true;
        }
    }




    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.save_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void setUpActionBar() {
        fragmentDelagateBinding.tbDelegate.inflateMenu(R.menu.save_menu);
        fragmentDelagateBinding.tbDelegate.setTitle(R.string.delegate);
        fragmentDelagateBinding.tbDelegate.setNavigationOnClickListener(v -> getActivity().getSupportFragmentManager().popBackStack());
        fragmentDelagateBinding.tbDelegate.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.item_save){
                saveDelegate();
            }
            return false;
        });
//        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentDelagateBinding.tbDelegate);
//        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
//        ab.setTitle(R.string.delegate);
//        ab.setDisplayHomeAsUpEnabled(true);
    }

}