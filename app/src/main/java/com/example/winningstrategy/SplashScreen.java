package com.example.winningstrategy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.winningstrategy.DataBase.FileInstaller;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class SplashScreen extends AppCompatActivity {

    private boolean accessGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DatabaseReference dataBase = FirebaseDatabase.getInstance().getReference();
        String ID = FileInstaller.id(this);

        dataBase.child("Verified keys").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    if (Objects.equals(data.child("ID").getValue(), ID)) {
                        accessGranted = true;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        new Handler().postDelayed(() -> {
            if (accessGranted)
                startActivity(new Intent(SplashScreen.this, MainScreen.class));
            else
                startActivity(new Intent(SplashScreen.this, Register.class).putExtra("ID", ID));
        }, 1300);
    }
}