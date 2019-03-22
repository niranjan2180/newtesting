package com.eisedo.eisedo.data.local;

import android.content.Context;

import com.eisedo.eisedo.data.local.entities.CheckList;
import com.eisedo.eisedo.data.local.entities.Folder;
import com.eisedo.eisedo.data.local.entities.Task;
import com.eisedo.eisedo.data.local.entities.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class,User.class,Folder.class, CheckList.class}, version = 1)
public abstract class EiseDoDatabase extends RoomDatabase {

    public static EiseDoDatabase eiseDoDatabase;

    public abstract EiseDoDao eiseDoDao();

    private static final Object mLock = new Object();

    public static EiseDoDatabase getInstance(Context context){
        synchronized(mLock){
            if (eiseDoDatabase== null){
                eiseDoDatabase = Room.databaseBuilder(context,EiseDoDatabase.class,"eisedo.db").build();
            }
        }
        return eiseDoDatabase;
    }
}