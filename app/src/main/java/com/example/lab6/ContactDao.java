package com.example.lab6;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab6.Contact;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert
    void Insert(Contact contact);
    @Update
    void Update(Contact contact);
    @Delete
    void Delete(Contact contact);
    @Query("SELECT * FROM Contact")
    List<Contact> getContact();
    @Query("SELECT * FROM Contact WHERE id = :id")
    Contact getContactById(int id);
}
