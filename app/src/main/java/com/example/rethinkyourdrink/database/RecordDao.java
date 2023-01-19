package com.example.rethinkyourdrink.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rethinkyourdrink.model.Record;

import java.util.List;

//TAN ZHI JIAN
//U2102832

@Dao
public interface RecordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Record record);

    @Update
    void update(Record record);

    // LiveData works with Room database to get instant update whenever there is any changes
    @Query("SELECT * FROM Record ORDER BY recordID DESC")
    LiveData<List<Record>> getAscendingRecord();
}
