package com.eisedo.eisedo.data.local.entities;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UsersProject {

    @Embedded
    User user;

    @Relation(parentColumn = "user_id", entityColumn = "userId")
    public List<Folder> folders;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
