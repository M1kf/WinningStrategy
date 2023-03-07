package com.example.winningstrategy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import com.example.winningstrategy.DataBase.GeneratorOfKeys;
import com.google.android.material.textfield.TextInputLayout;
import com.parse.ParseObject;

import java.util.Objects;

public class Register extends AppCompatActivity {

    private final String key = String.valueOf(new GeneratorOfKeys().getPassword());
    private boolean accessGranted = false;
    Button commitEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupFloatingLabelError();

        commitEnter = findViewById(R.id.commitEnter);
        String ID = getIntent().getStringExtra("ID");

        writeDataOnServer("requested_keys", key, ID);

        commitEnter.setOnClickListener(view -> {
            if (accessGranted) {
                writeDataOnServer("confirmed_keys", key, ID);
                finish();
                startActivity(new Intent(this, MainScreen.class));
            }
        });
    }

    private void setupFloatingLabelError() {
        final TextInputLayout floatingKeyLabel = findViewById(R.id.key_text_input_layout);
        Objects.requireNonNull(floatingKeyLabel.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() == 0)
                    floatingKeyLabel.setErrorEnabled(false);
                else {
                    if (!Objects.equals(text.toString().replaceAll("\\s", ""), key)) {
                        floatingKeyLabel.setError(getString(R.string.error_key));
                        floatingKeyLabel.setErrorEnabled(true);
                    } else {
                        floatingKeyLabel.setErrorEnabled(false);
                        accessGranted = true;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void writeDataOnServer(String theClassName, String key, String ID) {
        ParseObject person = new ParseObject(theClassName);
        person.put("Key", key);
        person.put("ID", ID);
        person.saveInBackground();
    }
}