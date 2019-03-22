package com.eisedo.eisedo.data.local.entities;

import com.eisedo.eisedo.util.DateConverter;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "alarm", indices = {@Index(value = "title")})
public class Alarm {

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

    public long getId() {
        return id;
    }

    public Alarm setId(long id) {
        this.id = id;
        return this;
    }

    public String getTask_id() {
        return task_id;
    }

    public Alarm setTask_id(String task_id) {
        this.task_id = task_id;
        return this;
    }

    public int getBucket() {
        return bucket;
    }

    public Alarm setBucket(int bucket) {
        this.bucket = bucket;
        return this;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public Alarm setCreated_date(Date created_date) {
        this.created_date = created_date;
        return this;
    }

    public Date getDue_date() {
        return due_date;
    }

    public Alarm setDue_date(Date due_date) {
        this.due_date = due_date;
        return this;
    }

    public Date getRemainder_date() {
        return remainder_date;
    }

    public Alarm setRemainder_date(Date remainder_date) {
        this.remainder_date = remainder_date;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Alarm setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public Alarm setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public int getRepeat() {
        return repeat;
    }

    public Alarm setRepeat(int repeat) {
        this.repeat = repeat;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Alarm setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isDismiss() {
        return dismiss;
    }

    public Alarm setDismiss(boolean dismiss) {
        this.dismiss = dismiss;
        return this;
    }
}
