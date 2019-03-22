package com.eisedo.eisedo.data.local.entities;

import com.eisedo.eisedo.util.DateConverter;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.TypeConverters;

public class Subscribe {

    public String current;

    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "exp_date")
    public Date exp_date;
}