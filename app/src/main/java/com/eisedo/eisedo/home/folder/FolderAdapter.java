package com.eisedo.eisedo.home.folder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eisedo.eisedo.R;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.databinding.FolderItemBinding;
import com.eisedo.eisedo.util.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.FolderViewHolder> {

    private ArrayList<Folder> folderItems;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public FolderAdapter(ArrayList<Folder> folderItems, Context context,OnItemClickListener onItemClickListener) {
        this.folderItems = folderItems;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public FolderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = null;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        FolderItemBinding folderItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.folder_item,viewGroup,false);
        return new FolderViewHolder(folderItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FolderViewHolder folderViewHolder, int i) {
        Folder folder = folderItems.get(i);
        folderViewHolder.folderItemBinding.setFolder(folder);
        folderViewHolder.folderItemBinding.clContainer.setOnClickListener(v -> onItemClickListener.onClick(folder,i));
    }

    @Override
    public int getItemCount() {
        return folderItems.size();
    }

    class FolderViewHolder extends RecyclerView.ViewHolder {
        private FolderItemBinding folderItemBinding;

        public FolderViewHolder(FolderItemBinding folderItemBinding) {
            super(folderItemBinding.getRoot());
            this.folderItemBinding = folderItemBinding;
        }
    }
}