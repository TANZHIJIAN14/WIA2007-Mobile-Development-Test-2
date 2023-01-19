package com.example.rethinkyourdrink.ui.record;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.rethinkyourdrink.model.Record;
import com.example.rethinkyourdrink.repository.RecordRepository;

import java.util.List;

public class RecordViewModel extends AndroidViewModel {

    //Added a private member variable to hold a reference to the repository.
    private final RecordRepository recordRepository;
    private final LiveData<List<Record>> recordList;

    public RecordViewModel(@NonNull Application application) {
        super(application);

        recordRepository = new RecordRepository(application);
        recordList = recordRepository.getAllRecords();
    }

    //Added a getAllNotes() method to return a cached list of words.
    public LiveData<List<Record>> getAllRecord() {
        return recordList;
    }

    // Created a wrapper insert() method that calls the Repository's insert() method.
    // In this way, the implementation of insert() is encapsulated from the UI.
    public void insert(Record record) {
        recordRepository.insert(record);
    }

    public void update(Record record) {recordRepository.update(record);}
}
