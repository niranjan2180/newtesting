package com.eisedo.eisedo.home.task.repeat;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.RepeatType;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentRepeatBinding;
import com.eisedo.eisedo.home.task.TaskActivity;
import com.eisedo.eisedo.home.task.TaskViewModel;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class RepeatFragment extends Fragment implements OnItemClickListener {

    private ArrayList<RepeatType> repeatItems;

    private FragmentRepeatBinding fragmentRepeatBinding;

    public static RepeatFragment repeatFragment = null;

    private TaskViewModel taskViewModel;

    public static RepeatFragment getInstance() {
        if (repeatFragment == null) {
            repeatFragment = new RepeatFragment();
        }
        return repeatFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(false);
        taskViewModel = TaskActivity.obtainViewModel(getActivity());
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentRepeatBinding = FragmentRepeatBinding.inflate(inflater,container,false);

        repeatItems = new ArrayList<>();

        setUpActionBar();

        taskViewModel.getTaskMutableLiveData().observe(this, task ->  setRepeatAdapter(task.getRepeat()));

        taskViewModel.getTaskDetail();

        repeatItems.addAll(Arrays.asList(RepeatType.values()));

        for (int i= 0; i < repeatItems.size(); i++){
            Log.d("RepeatType",  repeatItems.get(i) +  " " + RepeatType.values().toString() +" "  );
        }

        return fragmentRepeatBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setUpActionBar() {
        fragmentRepeatBinding.tbRepeat.setTitle(R.string.repeat);
        fragmentRepeatBinding.tbRepeat.setNavigationOnClickListener(v -> getActivity().getSupportFragmentManager().popBackStack());
    }

    void setRepeatAdapter(int position) {
        RepeatAdapter repeatAdapter = new RepeatAdapter(repeatItems, this, position);
        fragmentRepeatBinding.rvRepeatItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentRepeatBinding.rvRepeatItems.setAdapter(repeatAdapter);
    }

    void saveRepeat(int type) {
        Task task = taskViewModel.getTaskMutableLiveData().getValue();
        task.setRepeat(type);
        taskViewModel.updateTask(task);
    }

    @Override
    public void onClick(Object o, int position) {
        RepeatType repeatType = (RepeatType) o;
        saveRepeat(repeatType.value());
    }
}