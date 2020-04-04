package com.example.lab6;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class }, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();
}