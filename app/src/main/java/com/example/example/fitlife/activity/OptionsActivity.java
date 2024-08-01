package com.example.example.fitlife.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example.fitlife.R;
import com.google.android.material.card.MaterialCardView;


public class OptionsActivity extends AppCompatActivity {

    private MaterialCardView btnSetCal;
    private MaterialCardView btnExercise;
    private MaterialCardView btnDietList;
    private MaterialCardView btnFinishDay;
    private TextView tvDailyTarget;
    private TextView tvCurrentCal;
    private ImageView imgBack;

    // sayfa her açıldığında son kalori bilgileri veritabanından çekilir
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("tag", "onResume");
        getCalories();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Log.e("tag", "onCreate");

        btnSetCal = findViewById(R.id.btnSetCal);
        btnExercise = findViewById(R.id.btnExercise);
        btnDietList = findViewById(R.id.btnDietList);
        btnFinishDay = findViewById(R.id.btnFinishDay);
        tvDailyTarget = findViewById(R.id.tvDailyTarget);
        tvCurrentCal = findViewById(R.id.tvCurrentCal);
        imgBack = findViewById(R.id.imgBack);

        clickListeners();
    }
    // veritabanından anlık ve hedef kalori bilgileri çekilir
    private void getCalories() {
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int dailyTarget = preferences.getInt("dailyTarget", 0);
        int currentCal = preferences.getInt("currentCal", 0);

        tvDailyTarget.setText(dailyTarget + " cal");
        tvCurrentCal.setText(currentCal + " cal");

    }
    //butonlara tıklayınca ilgili sayfalara yönlendirme yapılır
    private void clickListeners() {
        btnSetCal.setOnClickListener(v -> {
            Intent intent = new Intent(OptionsActivity.this, SetCalActivity.class);
            startActivity(intent);
        });
        btnExercise.setOnClickListener(v -> {
            Intent intent = new Intent(OptionsActivity.this, ExerciseActivity.class);
            startActivity(intent);
        });
        btnDietList.setOnClickListener(v -> {
            Intent intent = new Intent(OptionsActivity.this, DietActivity.class);
            startActivity(intent);
        });
        btnFinishDay.setOnClickListener(v -> {
            Intent intent = new Intent(OptionsActivity.this, FinishDayActivity.class);
            startActivity(intent);
        });
        imgBack.setOnClickListener(v -> {
            finish();
        });
    }
}