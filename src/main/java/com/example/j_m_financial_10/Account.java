package com.example.j_m_financial_10;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
When making the constructors, want to take the users into account of how much information they are willing to provide.
We are not asking them to apply serious information, therefore the way they wish to set up the account information
must be more vague. Accounts are what house their theorhetical value of money. they can either add or take away
from these values. This is their emualated real world account
*/
@Entity(tableName = "accounts")
public class Account {

    @PrimaryKey(autoGenerate = true)
    private  int id;

    private String accountName;
    private Double accountValue;

    public Account(String accountName, Double accountValue){
        this.accountName = accountName;
        this.accountValue = accountValue;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public Double getAccountValue() {
        return accountValue;
    }
}