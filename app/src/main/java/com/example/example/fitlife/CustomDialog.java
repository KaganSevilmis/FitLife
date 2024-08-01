package com.example.example.fitlife;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.airbnb.lottie.LottieAnimationView;

public class CustomDialog {

    Activity activity;
    String message;

    public CustomDialog(Activity activity, String message) {
        this.activity = activity;
        this.message = message;
    }

    public void showCustomAlertDialog() {
        // LayoutInflater kullanarak özel bir düzen oluşturun
        LayoutInflater inflater = LayoutInflater.from(activity);
        View customView = inflater.inflate(R.layout.custom_alert_dialog, null);

        // LottieAnimationView öğesini bulun
        LottieAnimationView lottieAnimationView = customView.findViewById(R.id.lottieAnimationView);
        lottieAnimationView.setAnimation(R.raw.success);
        lottieAnimationView.playAnimation();

        // AlertDialog oluşturun
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(customView);

        TextView tvMessage = customView.findViewById(R.id.tvMessage);
        tvMessage.setText(message);

        // AlertDialog'u gösterin
        final AlertDialog alertDialog = builder.create();
        builder.setCancelable(false);
        alertDialog.show();

        // 1 saniye sonra metodu çalıştırmak için Handler kullanın
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Metodunuzu burada çağırabilirsiniz
                if (!activity.isFinishing())
                    activity.finish();

                // AlertDialog'u kapatın
                alertDialog.dismiss();
            }
        }, 2000); // 1000 milisaniye = 1 saniye
    }

}
