package com.example.example.fitlife.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.example.fitlife.CustomDialog;
import com.example.example.fitlife.R;
import com.example.example.fitlife.adapter.ExerciseItemAdapter;
import com.example.example.fitlife.adapter.ExerciseItemClickListener;
import com.example.example.fitlife.model.ExcerciseModel;

import java.util.Arrays;
import java.util.List;

public class ExerciseActivity extends AppCompatActivity implements ExerciseItemClickListener {

    RecyclerView rvExercises;
    ExerciseItemAdapter adapter;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        rvExercises = findViewById(R.id.rvExercises);
        imgBack = findViewById(R.id.imgBack);

        adapter = new ExerciseItemAdapter(this, getExercises(), this);

        rvExercises.setLayoutManager(new LinearLayoutManager(this));
        rvExercises.setAdapter(adapter);

        imgBack.setOnClickListener(v -> finish());
    }

    // egzersizi uygula butonuna tıklayınca çalışır
    @Override
    public void onApplyButtonClick(ExcerciseModel model) {
        Log.e("TAG", "clicked : " + model.getName());

        exerciseCompleted(model.getCal());

    }

    private void exerciseCompleted(int cal) {
        // shared'daki currentCal'ı al.
        // cal değerini çıkar
        // currentCal'ın yeni değerini set'le.
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int currentCal = preferences.getInt("currentCal", 0);
        int newCal = currentCal - cal;
        editor.putInt("currentCal", newCal);
        editor.apply();

        CustomDialog dialog = new CustomDialog(this, "Egzersiz uygulandı!");
        dialog.showCustomAlertDialog();
    }

    public List<ExcerciseModel> getExercises() {
        String image1 = "https://cdn.yemek.com/mnresize/1250/833/uploads/2023/07/yuruyus-kac-kalori-1-saat.jpg"; // yürüyüş
        String image2 = "https://www.sneakscloud.com/minio-url/blog/hangi-egzersiz-ne-kadar-kalori-yakiyor-03_603611c477dbe.jpg"; // koşu
        String image3 = "https://imgrosetta.mynet.com.tr/file/16933945/16933945-728xauto.jpg"; // ip atlamak
        String image4 = "https://www.sneakscloud.com/minio-url/blog/hangi-egzersiz-ne-kadar-kalori-yakiyor-04_603611e946e39.jpg"; // yüzme
        String image5 = "https://cdn.dsmcdn.com/mrktng/seo/mayis11/bisiklet-surmek-hangi-kaslari-calistirir.png"; // Bisiklet Sürmek
        String image6 = "https://www.medikalakademi.com.tr/wp-content/uploads/2015/01/nefes-yoga-breathe.jpg"; //yoga
        String image7 = "https://www.gloriasportsarena.com.tr/media/1963/weightlifting-b-1.jpg"; // Ağırlık kaldırma
        String image8 = "https://www.diyetkolik.com/site_media/media/customvideo_images/kick_box.jpg"; // kickbox
        String image9 = "https://hips.hearstapps.com/hmg-prod/images/squat-jump-squat-178-1653334247.jpg?crop=0.859xw:0.646xh;0.0481xw,0.342xh&resize=1200:*"; // squat
        String image10 = "https://cdn.mos.cms.futurecdn.net/oYDbf5hQAePHEBNZTQMXRA.jpg"; // Push Up
        String image11 = "https://image.posta.com.tr/i/posta/75/0x0/637dcbebe4bfdc075486ec6c.jpg"; // Mekik
        String image12 = "https://hips.hearstapps.com/hmg-prod/images/hdm119918mh15842-1545237096.png?crop=0.668xw:1.00xh;0.117xw,0&resize=1200:*"; // Plank

        ExcerciseModel e1 = new ExcerciseModel(image1, "Yürüyüş", 300, "1 saat");
        ExcerciseModel e2 = new ExcerciseModel(image2, "Koşu", 600, "1 saat");
        ExcerciseModel e3 = new ExcerciseModel(image3, "İp Atlamak", 180, "10 dakika");
        ExcerciseModel e4 = new ExcerciseModel(image4, "Yüzme", 600, "1 saat");
        ExcerciseModel e5 = new ExcerciseModel(image5, "Bisiklet Sürmek", 700, "1 saat");
        ExcerciseModel e6 = new ExcerciseModel(image6, "Yoga", 200, "1 saat");
        ExcerciseModel e7 = new ExcerciseModel(image7, "Ağırlık Kaldırma", 100, "30 dakika");
        ExcerciseModel e8 = new ExcerciseModel(image8, "Kick Boks", 700, "1 saat");
        ExcerciseModel e9 = new ExcerciseModel(image9, "Squat", 230, "1 saat");
        ExcerciseModel e10 = new ExcerciseModel(image10, "Push Up", 200, "30 dakika");
        ExcerciseModel e11 = new ExcerciseModel(image11, "Mekik", 100, "10 dakika");
        ExcerciseModel e12 = new ExcerciseModel(image12, "Plank", 20, "5 dakika");

        List<ExcerciseModel> itemList = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);

        return itemList;
    }
}