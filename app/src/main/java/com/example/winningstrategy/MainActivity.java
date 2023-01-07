package com.example.winningstrategy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button19, button20, button21, buttonComplex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        buttonComplex = findViewById(R.id.buttonComplex);
        button19.setOnClickListener(this);
        button20.setOnClickListener(this);
        button21.setOnClickListener(this);
        buttonComplex.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button19:
                Intent intent19 = new Intent(this, Task19Activity.class);
                startActivity(intent19);
                break;
            case R.id.button20:
                Intent intent20 = new Intent(this, Task20Activity.class);
                startActivity(intent20);
                break;
            case R.id.button21:
                Intent intent21 = new Intent(this, Task21Activity.class);
                startActivity(intent21);
                break;
            case R.id.buttonComplex:
                Intent intentComplex = new Intent(this, ComplexActivity.class);
                startActivity(intentComplex);
                break;
        }
    }
}