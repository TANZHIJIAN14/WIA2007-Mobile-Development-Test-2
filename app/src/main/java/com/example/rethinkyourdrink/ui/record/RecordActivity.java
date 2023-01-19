package com.example.rethinkyourdrink.ui.record;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.rethinkyourdrink.R;
import com.example.rethinkyourdrink.model.Record;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class RecordActivity extends AppCompatActivity {
    public static final String currentDay = "day";
    public static final String category = "category";
    public static final String nameDrink = "nameDrink";
    public static final String Amount = "amount";
    int index = -1;
    int index1 = -1;

    ImageView backHome;
    Button saveBtn;
    RadioGroup currentGroup, categoryGroup;
    RadioButton currentDayBtn, categoryBtn;
    TextInputEditText amountEdit, nameDrinkEdit;
    String amount = "";
    String nameDRINK = "";
    int categoryId = -1;
    int currentDayId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        categoryGroup = findViewById(R.id.categoryGroup);
        currentGroup = findViewById(R.id.currentGroup);
        nameDrinkEdit = findViewById(R.id.nameDrinkEdit);

        backHome = findViewById(R.id.backHome1);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        HashMap<Integer, String> map1 = new HashMap();
        map1.put(0, "Day 1");
        map1.put(1, "Day 2");
        map1.put(2, "Day 3");

        HashMap<Integer, String> map2 = new HashMap();
        map2.put(0, "Plain water");
        map2.put(1, "Non-sweetened");
        map2.put(2, "Sweetened");


        amountEdit = findViewById(R.id.amountEdit);
        saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Radio group category
                if (amountEdit.getText() != null) {
                    amount = amountEdit.getText().toString().trim();
                }

                if (nameDrinkEdit.getText() != null) {
                    nameDRINK = nameDrinkEdit.getText().toString();
                }

                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(amountEdit.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else if (index < 0 || index1 < 0) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    replyIntent.putExtra(currentDay, map1.get(index1));
                    replyIntent.putExtra(category, map2.get(index));
                    replyIntent.putExtra(nameDrink, nameDRINK);
                    replyIntent.putExtra(Amount, amount);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }

    public void chooseCategory(View v) {
        categoryId = categoryGroup.getCheckedRadioButtonId();
        categoryBtn = categoryGroup.findViewById(categoryId);
        index = categoryGroup.indexOfChild(categoryBtn);
        Log.d("radio button", "IndexCategory:" + index);
    }

    public void chooseCurrentDay(View v) {
        currentDayId = currentGroup.getCheckedRadioButtonId();
        currentDayBtn = currentGroup.findViewById(currentDayId);
        index1 = currentGroup.indexOfChild(currentDayBtn);
        Log.d("radio button", "IndexCurrentDay:" + index1);
    }
}