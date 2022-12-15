package com.example.susin1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Buttons_extended extends AppCompatActivity {
    private String signer = null;
    private String options = null;
    private int opts = 0;

    public String checkSigner(){
        if (signer == null) signer = "UNSIGNED";
        return signer;
    }
    public String checkOptions(){
        switch (opts) {
            case 0:
                options = "NO OPTIONS CHECKED";
                break;
            case 1:
                options = "RADIO-CHECK1";
                break;
            case 2:
                options = "RADIO-CHECK2";
                break;
            case 3:
                options = "{ RADIO1 , RADIO2 }";
        }
        return options;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons_extended);

        Button btn = findViewById(R.id.button);
        Button submit = findViewById(R.id.submit);
        TextView txtv = findViewById(R.id.result);
        RadioGroup rbg = findViewById(R.id.rbg);

        CheckBox cb1 = findViewById(R.id.cb1);
        CheckBox cb2 = findViewById(R.id.cb2);

        btn.setOnClickListener(view -> startActivity(new Intent(this, FusionLayout.class)));
        submit.setOnClickListener(view -> txtv.setText("Signed : " + checkSigner() + "\nOptions : " + checkOptions()));
        cb1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) opts += 1;
            else opts -=1;
        });
        cb2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) opts += 2;
            else opts -=2;
        });
        rbg.setOnCheckedChangeListener((group, checkedId) -> {
            View radioButton = rbg.findViewById(checkedId);
            int index = rbg.indexOfChild(radioButton);
            switch (index) {
                case 0:
                    signer = "Eduardo";
                    break;
                case 1:
                    signer = "Victor";
                    break;
                case 2:
                    signer = "David";
                    break;
            }
        });
    }
}