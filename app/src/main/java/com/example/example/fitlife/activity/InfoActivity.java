package com.example.example.fitlife.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.example.fitlife.R;


public class InfoActivity extends AppCompatActivity {


    private TextView btnContinue;
    private ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btnContinue = findViewById(R.id.btnContinue);
        imgBack = findViewById(R.id.imgBack);
        clickListeners();
    }
    // geri ve devam et butonlarının tıklaması dinlenir
    private void clickListeners() {
        btnContinue.setOnClickListener(v -> {
            Intent intent = new Intent(InfoActivity.this, OptionsActivity.class);
            startActivity(intent);
        });
        imgBack.setOnClickListener(v -> {
            finish();
        });
    }
}