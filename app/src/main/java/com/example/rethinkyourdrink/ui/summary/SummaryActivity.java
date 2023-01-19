package com.example.rethinkyourdrink.ui.summary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rethinkyourdrink.R;
import com.example.rethinkyourdrink.ui.summary.tab_item.MyViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class SummaryActivity extends AppCompatActivity {
    ImageView backHome;
    MyViewPageAdapter myViewPageAdapter;
    ViewPager2 switch_layout_summary;
    TabLayout layout_summary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        backHome = findViewById(R.id.backHome2);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Set the fragment adapter
        switch_layout_summary = findViewById(R.id.switch_layout_summary);
        myViewPageAdapter = new MyViewPageAdapter(this);
        switch_layout_summary.setAdapter(myViewPageAdapter);

        //Set up tab layout
        layout_summary = findViewById(R.id.layout_summary);
        layout_summary.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch_layout_summary.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        switch_layout_summary.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                layout_summary.getTabAt(position).select();
            }
        });

    }
}