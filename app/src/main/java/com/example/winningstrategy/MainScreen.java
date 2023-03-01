package com.example.winningstrategy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {
    Button task19, task20, task21, complexTask, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task19 = findViewById(R.id.button19);
        task20 = findViewById(R.id.button20);
        task21 = findViewById(R.id.button21);
        complexTask = findViewById(R.id.buttonComplex);
        info = findViewById(R.id.info);

        task19.setOnClickListener(view -> startActivity(new Intent(this, Task19.class)));
        task20.setOnClickListener(view -> startActivity(new Intent(this, Task20.class)));
        task21.setOnClickListener(view -> startActivity(new Intent(this, Task21.class)));
        complexTask.setOnClickListener(view -> startActivity(new Intent(this, ComplexTask.class)));
        info.setOnClickListener(view -> startActivity(new Intent(this, Info.class)));
    }
}