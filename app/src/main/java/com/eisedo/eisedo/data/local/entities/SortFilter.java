package com.eisedo.eisedo.data.local.entities;

public class SortFilter {

    boolean selected;

    String filterName;

    int image;

    public SortFilter(boolean selected, String filterName, int image) {
        this.selected = selected;
        this.filterName = filterName;
        this.image = image;
    }

    public boolean isSelected() {
        return selected;
    }

    public SortFilter setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

    public String getFilterName() {
        return filterName;
    }

    public SortFilter setFilterName(String filterName) {
        this.filterName = filterName;
        return this;
    }

    public int getImage() {
        return image;
    }

    public SortFilter setImage(int image) {
        this.image = image;
        return this;
    }
}
