package com.example.personal_profile;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This line tells the app to show the "activity_main" design, which has your profile info!
        setContentView(R.layout.activity_main);
    }
}