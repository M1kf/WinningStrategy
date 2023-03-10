package com.example.winningstrategy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.winningstrategy.DataBase.FileInstaller;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Objects;

public class SplashScreen extends AppCompatActivity {

    private String ID;
    private boolean accessGranted = false, theResultWasGot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ID = FileInstaller.id(this);
        getDataFromServer(ID);

        determineNextActivity();
    }

    private void getDataFromServer(String id) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("confirmed_keys");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                for (int i = 0; i < objects.size(); i++) {
                    if (Objects.equals(objects.get(i).getString("ID"), id))
                        accessGranted = true;
                }
                theResultWasGot = true;
            }
        });
    }

    private void determineNextActivity() {
        if (!theResultWasGot)
            new Handler().postDelayed(this::determineNextActivity, 1000);
        else {
            if (accessGranted)
                startActivity(new Intent(SplashScreen.this, MainScreen.class));
            else
                startActivity(new Intent(SplashScreen.this, Register.class).putExtra("ID", ID));
        }
    }
}