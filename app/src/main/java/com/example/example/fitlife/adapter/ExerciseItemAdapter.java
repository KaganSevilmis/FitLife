package com.example.example.fitlife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.example.fitlife.R;
import com.example.example.fitlife.model.ExcerciseModel;


import java.util.List;

public class ExerciseItemAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<ExcerciseModel> items;

    ExerciseItemClickListener itemClickListener;


    public ExerciseItemAdapter(Context context, List<ExcerciseModel> items, ExerciseItemClickListener itemClickListener) {
        this.context = context;
        this.items = items;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_exercise, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //egzersiz bilgileri tasarıma yerleştirilir
        ExcerciseModel item = items.get(position);
        Glide.with(context).load(item.getImage()).into(holder.imgExercise);
        holder.tvExerciseName.setText(item.getName());
        holder.tvCal.setText(String.valueOf(item.getCal()) + " cal");
        holder.tvSetCount.setText(item.getSetCount());

        holder.btnApply.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onApplyButtonClick(item);
            }

        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}


