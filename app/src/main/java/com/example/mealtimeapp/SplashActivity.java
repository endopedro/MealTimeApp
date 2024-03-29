package com.example.mealtimeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToMainActivity();
            }
        }, 2000);
    }

    private void goToMainActivity() {
        Intent intent = new Intent(
                SplashActivity.this,MainActivity.class
        );
        startActivity(intent);
        finish();
    }
}