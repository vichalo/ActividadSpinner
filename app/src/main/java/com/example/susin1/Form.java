package com.example.susin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Form extends AppCompatActivity {
    String data = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(view -> startActivity(new Intent(this, Buttons_extended.class)));

        Button policy = findViewById(R.id.data_consent);
        TextView dataPolicy = findViewById(R.id.data_policy);
        policy.setOnClickListener(view -> {
            if (dataPolicy.getText() == "") dataPolicy.setText(data);
            else dataPolicy.setText("");
        });
    }



}