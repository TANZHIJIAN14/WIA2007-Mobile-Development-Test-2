package com.example.rethinkyourdrink.ui.summary;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.rethinkyourdrink.model.Record;

public class SummaryAdapter extends ListAdapter<Record, SummaryViewHolder> {
    public SummaryAdapter(@NonNull DiffUtil.ItemCallback<Record> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public SummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return SummaryViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull SummaryViewHolder holder, int position) {
        Record record = getItem(position);
        holder.bind(record.getCurrentDate(), record.getCurrentDay(),
                record.getBeverageCategory(), record.getNameDrink(), record.getAmount());
    }

    public static class RecordDiff extends DiffUtil.ItemCallback<Record> {

        @Override
        public boolean areItemsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
            return oldItem.getRecordID() == newItem.getRecordID();
        }
    }
}
