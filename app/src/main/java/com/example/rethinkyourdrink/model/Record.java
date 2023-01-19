package com.example.rethinkyourdrink.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//TAN ZHI JIAN
//U2102832
@Entity
public class Record {
    @PrimaryKey(autoGenerate = true)
    private int recordID;
    @NonNull
    private String currentDate;
    @NonNull
    private String currentDay;
    @NonNull
    private String beverageCategory;
    @NonNull
    private String nameDrink;
    @NonNull
    private int amount;

    public Record(String currentDate,String currentDay, String beverageCategory, String nameDrink, int amount) {
        this.currentDate = currentDate;
        this.currentDay = currentDay;
        this.beverageCategory = beverageCategory;
        this.nameDrink = nameDrink;
        this.amount = amount;
    }

    @NonNull
    public String getCurrentDate() {
        return currentDate;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public String getCurrentDay() {
        return currentDay;
    }

    public String getBeverageCategory() {
        return beverageCategory;
    }

    @NonNull
    public String getNameDrink() {
        return nameDrink;
    }

    public int getAmount() {
        return amount;
    }
}
