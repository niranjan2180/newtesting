package com.eisedo.eisedo.data.local.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "checklistitem", indices = {@Index(value = "title")})
public class CheckListItem {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "check_list")
    public CheckList checkList;

    public CheckListItem(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public CheckListItem setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CheckListItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public CheckList getCheckList() {
        return checkList;
    }

    public CheckListItem setCheckList(CheckList checkList) {
        this.checkList = checkList;
        return this;
    }
}
