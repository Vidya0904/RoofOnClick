package com.example.roofonclick.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roofonclick.MainActivity;
import com.example.roofonclick.R;

public class SplashScreenActivity extends AppCompatActivity
{
    private static int SplashTimeOut = 3000;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        }, SplashTimeOut);
    }
}
