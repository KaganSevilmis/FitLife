package com.example.example.fitlife.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.example.fitlife.CustomDialog;
import com.example.example.fitlife.R;
import com.example.example.fitlife.adapter.DietClickListener;
import com.example.example.fitlife.adapter.DietItemAdapter;
import com.example.example.fitlife.model.DietModel;

import java.util.Arrays;
import java.util.List;

public class DietActivity extends AppCompatActivity implements DietClickListener {

    RecyclerView rvDiets;
    ImageView imgBack;
    DietItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        rvDiets = findViewById(R.id.rvDiets);
        imgBack = findViewById(R.id.imgBack);

        adapter = new DietItemAdapter(this, getExercises(), this);
        rvDiets.setLayoutManager(new LinearLayoutManager(this));
        rvDiets.setAdapter(adapter);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
    //diyeti ıygula butonuna tıklandığında çalışır
    @Override
    public void onApplyButtonClick(DietModel model) {
        Log.e("TAG", "clicked : " + model.getName());
        dietApplied(model.getCal());

    }
    // diyetin kalori değeri, veritabanındaki değerin üzerine eklenir
    private void dietApplied(int cal) {
        // shared'daki currentCal'ı al.
        // cal değerini ekle
        // currentCal'ın yeni değerini set'le.
        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int currentCal = preferences.getInt("currentCal", 0);
        int newCal = currentCal + cal;
        editor.putInt("currentCal", newCal);
        editor.apply();

        // diyalog gösterilir
        CustomDialog dialog = new CustomDialog(this, "Diyet uygulandı!");
        dialog.showCustomAlertDialog();

    }


    public List<DietModel> getExercises() {
        DietModel d1 = new DietModel("Diyet 1", 3000, "- Yulaf ezmesi, süt ile birlikte ve üzerine taze meyve dilimleri.\n- 1 dilim tam buğday ekmeği, fıstık ezmesi ve muz", "- Tavuk salata: Tavuk göğsü, marul, domates, salatalık, biber ve az yağlı sos.\n- Esmer pirinç pilavı", "- Izgara somon, buğulanmış brokoli ve kızarmış tatlı patates");
        DietModel d2 = new DietModel("Diyet 2", 1700, "- Yoğurt, yaban mersini ve granola karışımı.\n- Tam buğday baget üzerine avokado dilimleri", "- Quinoa salatası: Quinoa, taze sebzeler, humus ve tavuk dilimleri.\n- Bir avuç ceviz içi.", "- Izgara tavuk, ızgara sebzeler ve bulgur pilavı");
        DietModel d3 = new DietModel("Diyet 3", 2100, "- Tam buğdaylı gevrekler, süt ve muz\n- 1 dilim çavdar ekmeği üzerine lor peyniri ve çilek.", "Mercimek çorbası ve ızgara tavuklu sandviç (tam buğday ekmeği, marul, domates).", "Fırında balık, kahverengi pirinç ve buharda pişmiş sebzeler.");
        DietModel d4 = new DietModel("Diyet 4", 1800, "- Omlet (yumurta beyazı, ıspanak, domates ve peynir).\n- Tam buğday baget üzerine avokado dilimleri.", "- Yeşilliklerle yapılmış bir karışık salata ve ton balığı.\n- Bulgur pilavı.", "- Izgara tavuk, kızarmış brüksel lahanası ve kepekli makarna.");
        DietModel d5 = new DietModel("Diyet 5", 1900, "- Yulaf ezmesi, süt ve taze meyve dilimleri.", "- Karışık yeşillik salatası, hindistancevizi tavuk ve tam buğday tortilla.", "- Izgara somon, buğulanmış brokoli ve kahverengi pirinç.");
        DietModel d6 = new DietModel("Diyet 6", 2200, "- Yoğurt, chia tohumu ve taze meyve karışımı.", "- Kırmızı mercimek çorbası ve ızgara tavuk salatası.", "- Izgara karides, yeşil fasulye ve quinoa.");
        DietModel d7 = new DietModel("Diyet 7", 2000, "- Tam buğdaylı krep, çilek ve bal.", "- Kinoa salatası (kinoa, taze sebzeler, haşlanmış yumurta).", "- Izgara levrek, ızgara kabak ve kahverengi pirinç.");
        DietModel d8 = new DietModel("Diyet 8", 3100, "- Protein shake (süt, protein tozu, muz).", "- Tavuklu yeşil salata ve tam buğday ekmeği.", "- Izgara hindi göğsü, kızarmış tatlı patates ve buharda brokoli.");
        DietModel d9 = new DietModel("Diyet 9", 1800, "- Yulaf ezmesi, süt ve taze meyve karışımı.", "- Mercimek çorbası ve ızgara tavuklu sandviç.", "- Izgara somon, buğulanmış ıspanak ve kepekli makarna.");
        DietModel d10 = new DietModel("Diyet 10", 1600, "- Omlet (yumurta beyazı, ıspanak, domates).", "- Kırmızı mercimek çorbası ve ton balığı salatası.", "- Izgara tavuk, ızgara sebzeler ve kahverengi pirinç.");

        List<DietModel> itemList = Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);

        return itemList;
    }
}

