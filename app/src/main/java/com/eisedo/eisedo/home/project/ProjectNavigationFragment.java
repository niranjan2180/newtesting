package com.eisedo.eisedo.home.project;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.databinding.FragmentProjectNavigationBinding;
import com.eisedo.eisedo.home.project.add_edit_project.AddEditProject;
import com.eisedo.eisedo.home.task.TaskActivity;
import com.eisedo.eisedo.util.OnItemClickListener;
import com.eisedo.eisedo.util.RecyclerItemTouchListner;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectNavigationFragment extends Fragment implements RecyclerItemTouchListner.RecyclerItemTouchHelperListener , OnItemClickListener {

    private FragmentProjectNavigationBinding fragmentProjectNavigationBinding;
    private ProjectAdapter projectAdapter;
    private ArrayList<Folder> projects;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentProjectNavigationBinding = FragmentProjectNavigationBinding.inflate(inflater, container, false);
        projects = new ArrayList<>();

        projects.add(new Folder(1,"Folder 1",0,true));
        projects.add(new Folder(2,"Folder 2",0,true));
        projects.add(new Folder(3,"Folder 3",0,true));
        projects.add(new Folder(4,"Folder 4",0,true));
        projects.add(new Folder(-1,"+ Create Project",0,true));

        setUpToolbar();

        setUpProjects();

        return fragmentProjectNavigationBinding.getRoot();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_folder:

                Log.d("FolderSelection", "Folder");

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.folder_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    void setUpProjects(){
        projectAdapter = new ProjectAdapter(projects, context,this);
        fragmentProjectNavigationBinding.rvProjects.setLayoutManager(new LinearLayoutManager(context));
        fragmentProjectNavigationBinding.rvProjects.setAdapter(projectAdapter);
    }

    void setUpToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentProjectNavigationBinding.tbProject.tbTitle);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(R.string.projects);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof ProjectAdapter.ProjectViewHolder) {
            // get the removed item name to display it in snack bar
//            String name = .get(viewHolder.getAdapterPosition()).getName();
//
//            // backup of removed item for undo purpose
//            final Item deletedItem = cartList.get(viewHolder.getAdapterPosition());
//            final int deletedIndex = viewHolder.getAdapterPosition();
//
//            // remove the item from recycler view
//            mAdapter.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(fragmentProjectNavigationBinding.clContainer,  " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
//                    mAdapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }

    @Override
    public void onClick(Object o, int position) {
        Folder folder = (Folder)o;
        if (folder.id == -1){
            //TODO Call Folder To Place in the list
            getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).add(new AddEditProject(),"AddEdit").commit();
        }else {
            callTaskFragment();
        }

        Log.d("Position", position + " " + folder.getName());

    }

    void callTaskFragment() {
        startActivity(new Intent(getActivity(), TaskActivity.class));
    }

}
