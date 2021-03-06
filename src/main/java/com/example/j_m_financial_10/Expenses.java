package com.example.j_m_financial_10;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity(tableName = "expenses")
public class Expenses {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private Double amount;


    Expenses(String name, Double amount){
        this.name = name;
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

}
