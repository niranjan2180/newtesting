package com.eisedo.eisedo.data.local.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//@Entity(tableName = "folder",indices = {@Index("userId")},foreignKeys = @ForeignKey(entity = User.class,parentColumns = "user_id",childColumns = "userId"))
@Entity(tableName = "folder")
public class Folder {

    @PrimaryKey(autoGenerate = true)
    public int id = 0;

    public String name = "";

    public int parent_folder_id = 0;

    @ColumnInfo(name = "sync")
    public boolean sync = false;

    public long userId =0;

    @Ignore
    public int folderSize = 0;


    public int getFolderSize() {
        return folderSize;
    }

    public Folder setFolderSize(int folderSize) {
        this.folderSize = folderSize;
        return this;
    }

    @Ignore
    public Folder(int id, String name, int parent_folder_id, boolean sync) {
        this.id = id;
        this.name = name;
        this.parent_folder_id = parent_folder_id;
        this.sync = sync;
    }

    public Folder(String name, int parent_folder_id, boolean sync) {
//        this.id = id;
        this.name = name;
        this.parent_folder_id = parent_folder_id;
        this.sync = sync;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public int getParent_folder_id() {
        return parent_folder_id;
    }

    public void setParent_folder_id(int parent_folder_id) {
        this.parent_folder_id = parent_folder_id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
