package com.eisedo.eisedo.data;

import android.graphics.drawable.Drawable;

public class HomeItem {

    Drawable image;

    int count;

    String name;

    public HomeItem(Drawable image, int count, String name) {
        this.image = image;
        this.count = count;
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}