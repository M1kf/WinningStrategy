package com.example.winningstrategy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button task19, task20, task21, complexTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        task19 = findViewById(R.id.button19);
        task20 = findViewById(R.id.button20);
        task21 = findViewById(R.id.button21);
        complexTask = findViewById(R.id.buttonComplex);

        task19.setOnClickListener(view -> startActivity(new Intent(this, Task19Activity.class)));
        task20.setOnClickListener(view -> startActivity(new Intent(this, Task20Activity.class)));
        task21.setOnClickListener(view -> startActivity(new Intent(this, Task21Activity.class)));
        complexTask.setOnClickListener(view -> startActivity(new Intent(this, ComplexActivity.class)));
    }
}