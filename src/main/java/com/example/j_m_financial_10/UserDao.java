package com.example.j_m_financial_10;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void Insert(User user);

    @Update
    void Update(User user);

    @Delete
    void Delete(User user);

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllUsers();

}
