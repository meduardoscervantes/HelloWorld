package com.example.j_m_financial_10;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Expenses.class, version = 1)
public abstract class ExpensesDatabase extends RoomDatabase {

    private static ExpensesDatabase instance;

    public abstract ExpensesDao expensesDao();

    public static synchronized ExpensesDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ExpensesDatabase.class,"expenses_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
