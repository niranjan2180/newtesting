package com.eisedo.eisedo.data;

import com.eisedo.eisedo.data.local.entities.Task;

import java.util.ArrayList;

public class BucketItem {

    private int bucketCount;
    private String bucketTitle;
    private ArrayList<Task> tasks;

    public BucketItem(int bucketCount, String bucketTitle, ArrayList<Task> tasks) {
        this.bucketCount = bucketCount;
        this.bucketTitle = bucketTitle;
        this.tasks = tasks;
    }

    public int getBucketCount() {
        return bucketCount;
    }

    public void setBucketCount(int bucketCount) {
        this.bucketCount = bucketCount;
    }

    public String getBucketTitle() {
        return bucketTitle;
    }

    public void setBucketTitle(String bucketTitle) {
        this.bucketTitle = bucketTitle;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
