package com.example.rethinkyourdrink.ui.summary.tab_item;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rethinkyourdrink.R;
import com.example.rethinkyourdrink.ui.summary.SummaryViewModel;

public class DetailsFragment extends Fragment {
    TextView totalAmountAll, totalAmountPlainWater, totalAmountNonSweetened, totalAmountSweetened;
    private SummaryViewModel summaryViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);


        totalAmountAll = view.findViewById(R.id.totalAmountAll);
        totalAmountPlainWater = view.findViewById(R.id.totalAmountPlainWater);
        totalAmountNonSweetened = view.findViewById(R.id.totalAmountNonSweetened);
        totalAmountSweetened = view.findViewById(R.id.totalAmountSweetened);


        summaryViewModel = new ViewModelProvider(this).get(SummaryViewModel.class);
        summaryViewModel.getAllRecord().observe(getViewLifecycleOwner(), records -> {
            int totalAmountDrank = 0;
            int amount1 = 0, amount2 = 0, amount3 = 0;
            for(int i = 0; i < records.size(); i++) {
                String category = records.get(i).getBeverageCategory();
                int amount = records.get(i).getAmount();
                totalAmountDrank += amount;
                if(category.equals("Plain water")) {
                    amount1 += amount;
                } else if (category.equals("Non-sweetened")) {
                    amount2 += amount;
                } else {
                    amount3 += amount;
                }
            }
            totalAmountAll.setText(String.valueOf(totalAmountDrank));
            totalAmountPlainWater.setText(String.valueOf(amount1));
            totalAmountNonSweetened.setText(String.valueOf(amount2));
            totalAmountSweetened.setText(String.valueOf(amount3));
        });

        return view;
    }
}