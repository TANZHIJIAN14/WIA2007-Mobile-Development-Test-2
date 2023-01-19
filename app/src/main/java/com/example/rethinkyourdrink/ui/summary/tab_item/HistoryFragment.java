package com.example.rethinkyourdrink.ui.summary.tab_item;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rethinkyourdrink.R;
import com.example.rethinkyourdrink.ui.summary.SummaryAdapter;
import com.example.rethinkyourdrink.ui.summary.SummaryViewModel;

public class HistoryFragment extends Fragment {

    RecyclerView recordRecyclerView;
    private SummaryViewModel summaryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        //Set up recycler view
        recordRecyclerView = view.findViewById(R.id.recordRecyclerView);
        final SummaryAdapter summaryAdapter = new SummaryAdapter(new SummaryAdapter.RecordDiff());
        recordRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recordRecyclerView.setAdapter(summaryAdapter);
        recordRecyclerView.setHasFixedSize(true);

        summaryViewModel = new ViewModelProvider(this).get(SummaryViewModel.class);
        summaryViewModel.getAllRecord().observe(getViewLifecycleOwner(), records -> {
            // Update the cached copy of the words in the adapter.
            summaryAdapter.submitList(records);
        });

        return view;

    }
}