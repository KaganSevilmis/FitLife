package com.example.example.fitlife.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

public class DietItemViewHolder extends RecyclerView.ViewHolder {
    TextView tvDietName, tvCal, tvBreakfastPlan, tvLaunchPlan, tvDinnerPlan;
    MaterialCardView btnApply;
    // diyet card tasarımındaki tasarım nesneleri tanımlanır
    public DietItemViewHolder(@NonNull View itemView) {
        super(itemView);
        tvDietName = itemView.findViewById(com.example.example.fitlife.R.id.tvDietName);
        tvCal = itemView.findViewById(com.example.example.fitlife.R.id.tvCal);
        tvBreakfastPlan = itemView.findViewById(com.example.example.fitlife.R.id.tvBreakfastPlan);
        tvLaunchPlan = itemView.findViewById(com.example.example.fitlife.R.id.tvLaunchPlan);
        tvDinnerPlan = itemView.findViewById(com.example.example.fitlife.R.id.tvDinnerPlan);
        btnApply = itemView.findViewById(com.example.example.fitlife.R.id.btnApply);


    }

}
