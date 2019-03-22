package com.eisedo.eisedo.data;

public enum RepeatType {

    NEVER(1),EVERY_DAY(2),EVERY_WEEK(3),EVERY_MONTH(4),EVERY_YEAR(5);

    private final int value;

    RepeatType(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }
}
