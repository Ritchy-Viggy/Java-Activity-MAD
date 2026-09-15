package com.example.personal_profile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This line tells the app to show the "activity_splash" design first!
        setContentView(R.layout.activity_splash);

        // We use a "Handler" to wait for 5 seconds.
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // After the timer rings, we "Intent" to go to the next screen (MainActivity).
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            
            // "finish" means we close this splash screen so we don't see it again if we press back.
            finish();
        }, 5000);
    }
}
