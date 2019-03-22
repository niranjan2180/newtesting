package com.eisedo.eisedo.data.local.entities;

import com.eisedo.eisedo.util.DateConverter;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "user")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_id")
    public String user_id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "email")
    public String email;

    @Embedded
    public Language language;

    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "matrix_on")
    public Date matrix_on;

    @Embedded
    public Notify notify;

    @ColumnInfo(name = "status")
    public int status;

    @Embedded
    public Subscribe subscribe;

    @Embedded
    public TimeZone timeZone;

    @ColumnInfo(name = "urgency")
    public String urgency;

    @Embedded
    public MatrixHeadings matrixHeadings;

    @Embedded
    public Notifications notifications;

    @ColumnInfo(name = "sync")
    public boolean sync;

    @NonNull
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(@NonNull String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Date getMatrix_on() {
        return matrix_on;
    }

    public void setMatrix_on(Date matrix_on) {
        this.matrix_on = matrix_on;
    }

    public Notify getNotify() {
        return notify;
    }

    public void setNotify(Notify notify) {
        this.notify = notify;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Subscribe getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Subscribe subscribe) {
        this.subscribe = subscribe;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public MatrixHeadings getMatrixHeadings() {
        return matrixHeadings;
    }

    public void setMatrixHeadings(MatrixHeadings matrixHeadings) {
        this.matrixHeadings = matrixHeadings;
    }

    public Notifications getNotifications() {
        return notifications;
    }

    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

}
