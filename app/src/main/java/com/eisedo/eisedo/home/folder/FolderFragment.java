package com.eisedo.eisedo.home.folder;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.databinding.FragmentFolderSelectionBinding;
import com.eisedo.eisedo.home.task.TaskActivity;
import com.eisedo.eisedo.home.task.TaskViewModel;
import com.eisedo.eisedo.home.task.project_selection.ProjectSelectionAdapter;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class FolderFragment extends Fragment implements OnItemClickListener {

    private TaskViewModel taskViewModel;

    public static FolderFragment folderFragment = null;

    public static FolderFragment getInstance() {
        if (folderFragment == null) {
            folderFragment = new FolderFragment();
        }
        return folderFragment;
    }

    private FragmentFolderSelectionBinding fragmentFolderSelectionBinding;
    private ProjectSelectionAdapter projectSelectionAdapter;
    private ArrayList<Folder> projects;
    private Context context;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        taskViewModel = TaskActivity.obtainViewModel(getActivity());
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentFolderSelectionBinding = FragmentFolderSelectionBinding.inflate(inflater, container, false);

        projects = new ArrayList<>();

        projects.add(new Folder(0,"Inbox",0,true));
        projects.add(new Folder(1,"Folder 1",0,true));
        projects.add(new Folder(2,"Folder 2",0,true));
        projects.add(new Folder(3,"Folder 3",0,true));
        projects.add(new Folder(4,"Folder 4",0,true));

        setUpActionBar();

        setUpFolders();
        return fragmentFolderSelectionBinding.getRoot();
    }

    void setUpFolders(){
        projectSelectionAdapter = new ProjectSelectionAdapter(projects, context,this);
        fragmentFolderSelectionBinding.rvFolderSelection.setLayoutManager(new LinearLayoutManager(context));
        fragmentFolderSelectionBinding.rvFolderSelection.setAdapter(projectSelectionAdapter);
    }


    private void setUpActionBar() {
        fragmentFolderSelectionBinding.tbFolderSelection.setTitle(R.string.save_to_folder);
        fragmentFolderSelectionBinding.tbFolderSelection.setNavigationOnClickListener(v -> getActivity().getSupportFragmentManager().popBackStack());
    }

    void saveFolder(int type) {
        Task task = taskViewModel.getTaskMutableLiveData().getValue();
        task.setFolder_id(type);
        taskViewModel.updateTask(task);
    }


    @Override
    public void onClick(Object o, int position) {
        Folder folder = (Folder) o;
        Log.d("Folder",folder.getName() + " " + position);
        saveFolder(folder.id);
    }
}