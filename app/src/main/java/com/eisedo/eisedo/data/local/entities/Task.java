package com.eisedo.eisedo.data.local.entities;

import com.eisedo.eisedo.util.DateConverter;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "task", indices = {@Index(value = "title")})
public class Task {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long id;

    @ColumnInfo(name = "task_id")
    public String task_id;

    @ColumnInfo(name = "bucket")
    public int bucket;

    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "created_date")
    public Date created_date;

    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "due_date")
    public Date due_date;

    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "update_date")
    public Date updated_date;

    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "remainder_date")
    public Date remainder_date;

    @ColumnInfo(name = "notes")
    public String notes;

    @ColumnInfo(name = "timeZone")
    public String timezone;

    @ColumnInfo(name = "repeat")
    public int repeat;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "dismiss")
    public boolean dismiss;

    @ColumnInfo(name = "deleted")
    public boolean deleted;

    @ColumnInfo(name = "star")
    public boolean star;

    @ColumnInfo(name = "progress")
    public int progress;

    @ColumnInfo(name = "importance")
    public boolean importance;

    @ColumnInfo(name = "sync")
    public boolean sync;

    @ColumnInfo(name = "folder_id")
    public int folder_id;

    @Embedded
    public Delegate delegate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public int getBucket() {
        return bucket;
    }

    public void setBucket(int bucket) {
        this.bucket = bucket;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Date getRemainder_date() {
        return remainder_date;
    }

    public void setRemainder_date(Date remainder_date) {
        this.remainder_date = remainder_date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDismiss() {
        return dismiss;
    }

    public void setDismiss(boolean dismiss) {
        this.dismiss = dismiss;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isStar() {
        return star;
    }

    public void setStar(boolean star) {
        this.star = star;
    }

    public Delegate getDelegate() {
        return delegate;
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isImportance() {
        return importance;
    }

    public void setImportance(boolean importance) {
        this.importance = importance;
    }

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public int getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(int folder_id) {
        this.folder_id = folder_id;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task_id='" + task_id + '\'' +
                ", bucket=" + bucket +
                ", created_date=" + created_date +
                ", due_date=" + due_date +
                ", updated_date=" + updated_date +
                ", remainder_date=" + remainder_date +
                ", notes='" + notes + '\'' +
                ", timezone='" + timezone + '\'' +
                ", repeat=" + repeat +
                ", title='" + title + '\'' +
                ", dismiss=" + dismiss +
                ", deleted=" + deleted +
                ", star=" + star +
                ", progress=" + progress +
                ", importance=" + importance +
                ", sync=" + sync +
                ", folder_id=" + folder_id +
                ", delegate=" + delegate +
                '}';
    }
}