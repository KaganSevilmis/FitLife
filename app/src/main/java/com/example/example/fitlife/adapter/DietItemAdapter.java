package com.example.example.fitlife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.example.fitlife.R;
import com.example.example.fitlife.model.DietModel;

import java.util.List;

public class DietItemAdapter extends RecyclerView.Adapter<DietItemViewHolder> {
    Context context;
    List<DietModel> items;

    DietClickListener dietClickListener;

    public DietItemAdapter(Context context, List<DietModel> items, DietClickListener dietClickListener) {
        this.context = context;
        this.items = items;
        this.dietClickListener = dietClickListener;
    }

    @NonNull
    @Override
    public DietItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DietItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_diet, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DietItemViewHolder holder, int position) {
        // diyet bilgileri tasarıma yerleştirilir
        DietModel item = items.get(position);
        holder.tvDietName.setText(item.getName());
        holder.tvCal.setText(String.valueOf(item.getCal()));
        holder.tvBreakfastPlan.setText(item.getBreakfastPlan());
        holder.tvLaunchPlan.setText(item.getLaunchPlan());
        holder.tvDinnerPlan.setText(item.getDinnerPlan());
        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dietClickListener != null) {
                    dietClickListener.onApplyButtonClick(item);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
