package com.example.winningstrategy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Button returnToMainScreen = findViewById(R.id.returnToMainScreen);
        returnToMainScreen.setOnClickListener(view -> finish());
    }
}