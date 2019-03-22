package com.eisedo.eisedo.data;

public enum BucketType {

    DO_FIRST(1),DO_LATER(2),DELEGATE(3),ELIMINATE(4);

    private final int value;

    BucketType(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }

}
