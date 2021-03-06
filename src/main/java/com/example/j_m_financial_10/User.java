package com.example.j_m_financial_10;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    public User(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
