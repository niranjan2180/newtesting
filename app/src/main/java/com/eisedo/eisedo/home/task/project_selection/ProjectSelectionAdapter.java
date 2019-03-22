package com.eisedo.eisedo.home.task.project_selection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.databinding.ProjectItemSelectionBinding;
import com.eisedo.eisedo.home.folder.FolderAdapter;
import com.eisedo.eisedo.util.ItemDecorator;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectSelectionAdapter extends RecyclerView.Adapter<ProjectSelectionAdapter.ProjectViewHolder>{

    private ArrayList<Folder> folders;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public ProjectSelectionAdapter(ArrayList<Folder> folders, Context context, OnItemClickListener onItemClickListener) {
        this.folders = folders;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

//    @BindingAdapter("android:visibility")
//    public static void setVisibility(View view, int value) {
//        Log.d("Visibility", value +" ");
//        view.setVisibility(value!=0 ? View.VISIBLE : View.GONE);
//    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ProjectItemSelectionBinding projectItemSelectionBinding = DataBindingUtil.inflate(layoutInflater,R.layout.project_item_selection,parent,false);
        return new ProjectViewHolder(projectItemSelectionBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Folder folder = folders.get(position);


        ArrayList<Folder> folders = new ArrayList<>();
        if (position%2 == 1){
            folders.add(new Folder(1,"Sub Folder 1", 0,true));
            folders.add(new Folder(2,"Sub Folder 2", 0,true));
            folders.add(new Folder(3,"Sub Folder 3", 0,true));
            folders.add(new Folder(4,"Sub Folder 4", 0,true));
            folder.setFolderSize(1);
        }else {
            folder.setFolderSize(2);
        }


        holder.projectItemSelectionBinding.clContainer.setOnClickListener(v -> onItemClickListener.onClick(folder,position));

        holder.projectItemSelectionBinding.setFolder(folder);

        FolderAdapter folderAdapter = new FolderAdapter(folders,context,onItemClickListener);
        holder.projectItemSelectionBinding.rvFolderList.setLayoutManager(new LinearLayoutManager(context));
        holder.projectItemSelectionBinding.rvFolderList.setAdapter(folderAdapter);

//        ItemDecorator itemDecorator = new ItemDecorator(context,R.dimen.item_offset);
//        holder.projectItemBinding.rvFolderList.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
        holder.projectItemSelectionBinding.rvFolderList.addItemDecoration(new ItemDecorator(context,LinearLayoutManager.VERTICAL,15));

//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
//        itemTouchHelper.attachToRecyclerView(holder.projectItemBinding.rvFolderList);
    }

    @Override
    public int getItemCount() {
        return folders.size();
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder{
        private ProjectItemSelectionBinding projectItemSelectionBinding;
        public ProjectViewHolder(ProjectItemSelectionBinding projectItemSelectionBinding) {
            super(projectItemSelectionBinding.getRoot());
            this.projectItemSelectionBinding = projectItemSelectionBinding;
        }
    }
}