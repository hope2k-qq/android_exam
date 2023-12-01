package com.example.android_exam;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);
    @Query("SELECT * FROM user")
    List<User> getAllUsers();
}
