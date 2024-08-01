package com.example.example.fitlife.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example.fitlife.R;
import com.google.android.material.card.MaterialCardView;


public class SetCalActivity extends AppCompatActivity {
    private MaterialCardView btnSave;
    private EditText etCalTarget;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_cal);

        btnSave = findViewById(R.id.btnSave);
        etCalTarget = findViewById(R.id.etCalTarget);
        imgBack = findViewById(R.id.imgBack);
        clickListeners();

    }
    // geri ve kaydet butonlarının tıklama durumları dinlenir
    private void clickListeners() {
        btnSave.setOnClickListener(v -> {
            saveTargetCal();
        });
        imgBack.setOnClickListener(v -> {
            finish();
        });
    }
    // input'tan girilen kalori hedefi veritabanına kaydedilir
    private void saveTargetCal() {

        String input = etCalTarget.getText().toString().trim();
        if (input.equals("")) {
            //değer girilmemişse uyarı mesajı gösterilir
            Toast.makeText(this, "Değer girmelisiniz", Toast.LENGTH_SHORT).show();
        } else {

            int target = Integer.parseInt(input);

            // SharedPreferences nesnesini al
            SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

            // SharedPreferences üzerinde düzenleme yapabilmek için bir editor oluştur
            SharedPreferences.Editor editor = preferences.edit();

            // Key-Value çiftini kaydet
            editor.putInt("dailyTarget", target); // "dailytarget" adlı bir anahtarla target değerini kaydediyoruz.

            // Değişiklikleri kaydet
            editor.apply();

            Toast.makeText(this, "Başarıyla kaydedildi", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
