package com.example.rethinkyourdrink.ui.summary;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rethinkyourdrink.R;

public class SummaryViewHolder extends RecyclerView.ViewHolder {
    private final TextView currentDate, currentDay, category, nameDrink, amount;

    private SummaryViewHolder(@NonNull View itemView) {
        super(itemView);
        currentDate = itemView.findViewById(R.id.date);
        currentDay = itemView.findViewById(R.id.currentDay);
        category = itemView.findViewById(R.id.category);
        nameDrink = itemView.findViewById(R.id.nameDrink);
        amount = itemView.findViewById(R.id.amount);
    }

    public void bind(String _currentDate,String _currentDay, String _beverageCategory, String _nameDrink, int _amount) {
        currentDate.setText(_currentDate);
        currentDay.setText(_currentDay);
        category.setText(_beverageCategory);
        if(nameDrink != null && !nameDrink.equals("")) {
            nameDrink.setText(_nameDrink);
        } else {
            nameDrink.setText("-");
        }
        amount.setText(String.valueOf(_amount));
    }

    static SummaryViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.record_card, parent, false);
        return new SummaryViewHolder(view);
    }
}
