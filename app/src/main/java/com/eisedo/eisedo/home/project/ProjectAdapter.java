package com.eisedo.eisedo.home.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.databinding.ProjectItemBinding;
import com.eisedo.eisedo.home.folder.FolderAdapter;
import com.eisedo.eisedo.util.ItemDecorator;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>{

    private ArrayList<Folder> folders;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public ProjectAdapter(ArrayList<Folder> folders, Context context,OnItemClickListener onItemClickListener) {
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
        ProjectItemBinding projectItemBinding  = DataBindingUtil.inflate(layoutInflater,R.layout.project_item,parent,false);
        return new ProjectViewHolder(projectItemBinding);
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

        holder.projectItemBinding.setFolder(folder);

        FolderAdapter folderAdapter = new FolderAdapter(folders,context,onItemClickListener);
        holder.projectItemBinding.rvFolderList.setLayoutManager(new LinearLayoutManager(context));
        holder.projectItemBinding.rvFolderList.setAdapter(folderAdapter);

//        ItemDecorator itemDecorator = new ItemDecorator(context,R.dimen.item_offset);
//        holder.projectItemBinding.rvFolderList.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
        holder.projectItemBinding.rvFolderList.addItemDecoration(new ItemDecorator(context,LinearLayoutManager.VERTICAL,15));

//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
//        itemTouchHelper.attachToRecyclerView(holder.projectItemBinding.rvFolderList);

        holder.projectItemBinding.clContainer.setOnClickListener(v -> {
            onItemClickListener.onClick(folder,position);
        });


        holder.projectItemBinding.ivHolder.setOnClickListener(v ->{
            if (holder.projectItemBinding.rvFolderList.getVisibility() == View.GONE){
                holder.projectItemBinding.rvFolderList.setVisibility(View.VISIBLE);
            }else {
                holder.projectItemBinding.rvFolderList.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return folders.size();
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder{
        private ProjectItemBinding projectItemBinding;
        public ProjectViewHolder(ProjectItemBinding projectItemBinding) {
            super(projectItemBinding.getRoot());
            this.projectItemBinding = projectItemBinding;
        }
    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            Toast.makeText(context, "on Move", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            Toast.makeText(context, "on Swiped ", Toast.LENGTH_SHORT).show();
            //Remove swiped item from list and notify the RecyclerView
            int position = viewHolder.getAdapterPosition();
            folders.remove(position);
//            adapter.notifyDataSetChanged();

        }
    };
}