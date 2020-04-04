package com.example.lab6;

import android.icu.util.ULocale;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String description;
    public String status;

    public String category;
    public String duration;

}
