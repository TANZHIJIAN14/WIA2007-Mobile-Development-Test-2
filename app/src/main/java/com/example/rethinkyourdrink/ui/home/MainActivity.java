package com.example.rethinkyourdrink.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rethinkyourdrink.R;
import com.example.rethinkyourdrink.ui.record.RecordActivity;
import com.example.rethinkyourdrink.ui.record.RecordViewModel;
import com.example.rethinkyourdrink.model.Record;
import com.example.rethinkyourdrink.ui.summary.SummaryActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//TAN ZHI JIAN
//U2102832
public class MainActivity extends AppCompatActivity {

    TextView currentDate;
    TextView amountWaterCate1, amountWaterCate2, amountWaterCate3;
    BottomNavigationView bottomBarView;

    public static final int NEW_RECORD_ACTIVITY_REQUEST_CODE = 1;
    private RecordViewModel recordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set current date
        currentDate = findViewById(R.id.currentDate);
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        currentDate.setText(formattedDate);

        bottomBarView = findViewById(R.id.bottomBarView);
        bottomBarView.setOnNavigationItemSelectedListener(navListener);

        //Setup viewModel
        recordViewModel = new ViewModelProvider(this).get(RecordViewModel.class);

        //Update the view
        amountWaterCate1 = findViewById(R.id.amountWaterCate1);
        amountWaterCate2 = findViewById(R.id.amountWaterCate2);
        amountWaterCate3 = findViewById(R.id.amountWaterCate3);
        recordViewModel.getAllRecord().observe(this, records -> {
            int amount1 = 0, amount2 = 0, amount3 = 0;
            for (int i = 0; i < records.size(); i++) {
                String category = records.get(i).getBeverageCategory();
                int amount = records.get(i).getAmount();
                if (category.equals("Plain water")) {
                    amount1 += amount;
                } else if (category.equals("Non-sweetened")) {
                    amount2 += amount;
                } else {
                    amount3 += amount;
                }
            }
            //Set the amount of water drank
            amountWaterCate1.setText(String.valueOf(amount1));
            Log.d("Amount", "Amount: " + amount1);
            amountWaterCate2.setText(String.valueOf(amount2));
            amountWaterCate3.setText(String.valueOf(amount3));
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_RECORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Log.d("Record", data.getStringExtra(RecordActivity.Amount));
            if (data != null) {
                String _currentDate = currentDate.getText().toString();
                String currentDay = data.getStringExtra(RecordActivity.currentDay);
                String category = data.getStringExtra(RecordActivity.category);
                String nameDrink = data.getStringExtra(RecordActivity.nameDrink);
                int amount = Integer.parseInt(data.getStringExtra(RecordActivity.Amount));
                Record record = new Record(_currentDate, currentDay, category, nameDrink, amount);
                recordViewModel.insert(record);
            }
        } else {
            Toast.makeText(this, "Record of water consumed not saved due to empty field", Toast.LENGTH_SHORT).show();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.add:
                    Intent intent = new Intent(getApplicationContext(), RecordActivity.class);
                    startActivityForResult(intent, NEW_RECORD_ACTIVITY_REQUEST_CODE);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.summary:
                    startActivity(new Intent(getApplicationContext(), SummaryActivity.class));
                    break;
                default:
                    return false;
            }
            return true;
        }
    };
}