package com.example.j_m_financial_10;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpensesDao {

    @Insert
    void insert(Expenses expenses);

    @Update
    void update(Expenses expenses);

    @Delete
    void delete(Expenses expenses);

    @Query("SELECT * FROM expenses")
    LiveData<List<Expenses>> getAllExpenses();
}
