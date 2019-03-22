package com.eisedo.eisedo.home.task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentNoteBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NoteFragment extends Fragment {

    public static NoteFragment noteFragment = null;

    private FragmentNoteBinding fragmentNoteBinding;

    public static NoteFragment getInstance() {
        if (noteFragment == null) {
            noteFragment = new NoteFragment();
        }
        return noteFragment;
    }

    private TaskViewModel taskViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        taskViewModel = TaskActivity.obtainViewModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentNoteBinding = FragmentNoteBinding.inflate(inflater, container, false);

        taskViewModel.getTaskMutableLiveData().observe(this, task -> fragmentNoteBinding.setTask(task));

        taskViewModel.getTaskDetail();

        setUpActionBar();

        return fragmentNoteBinding.getRoot();
    }

    private void setUpActionBar() {
        fragmentNoteBinding.tbAddNote.inflateMenu(R.menu.done_menu);
        fragmentNoteBinding.tbAddNote.setTitle(R.string.add_note);
        fragmentNoteBinding.tbAddNote.setNavigationOnClickListener(v -> getActivity().getSupportFragmentManager().popBackStack());
        fragmentNoteBinding.tbAddNote.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.item_done) {
                addNote();
            }
            return false;
        });
    }

    void addNote() {
        Task task = taskViewModel.getTaskMutableLiveData().getValue();
        task.setNotes(fragmentNoteBinding.etTaskNote.getText().toString());
        taskViewModel.updateTask(task);
    }
}
