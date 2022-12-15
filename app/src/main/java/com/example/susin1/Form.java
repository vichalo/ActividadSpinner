package com.example.susin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Form extends AppCompatActivity {
    String data = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

    // array objects
    String courseList[] = {"C-Programming", "Data Structure", "Database", "Python",
            "Java", "Operating System", "Compiler Design", "Android Development"};

    EditText username, name, mail, phone;
    Spinner spinner;
    ListView simpleListView;
    Button submit, policy;
    TextView dataPolicy;
    SharedPreferences sharedPref;


    private void elementos(){
        spinner = (Spinner) findViewById(R.id.spinner);
        simpleListView  = (ListView) findViewById(R.id.simpleListView);
         submit = findViewById(R.id.submit);
         policy = findViewById(R.id.data_consent);
        dataPolicy = findViewById(R.id.data_policy);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_view, R.id.itemTextView, courseList);
        simpleListView.setAdapter(arrayAdapter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.valores_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        elementos();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        submit.setOnClickListener(view -> startActivity(new Intent(this, Buttons_extended.class)));
        policy.setOnClickListener(view -> {
            if (dataPolicy.getText() == "") dataPolicy.setText(data);
            else dataPolicy.setText("");
            getData();
        });
    }
    protected void onPause() {
        super.onPause();
        saveData();
    }
    public void saveData(){
        sharedPref = getSharedPreferences("Profile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("@string/username",username.getText().toString());
        editor.putString("@string/name",name.getText().toString());
        editor.putString("@string/mail",mail.getText().toString());
        editor.putString("@string/phone",phone.getText().toString());
        editor.putInt("string/item",simpleListView.getSelectedItemPosition());
        editor.putInt("@string/spinner",spinner.getSelectedItemPosition());
        editor.apply();
    }
    public void getData(){
        sharedPref = getSharedPreferences("Profile", Context.MODE_PRIVATE);
        username.setText(sharedPref.getString("@string/username",""));
        name.setText(sharedPref.getString("@string/name",""));
        mail.setText(sharedPref.getString("@string/mail",""));
        phone.setText(sharedPref.getString("@string/phone",""));
        simpleListView.setSelection(sharedPref.getInt("@string/item",simpleListView.getSelectedItemPosition()));
        spinner.setSelection(sharedPref.getInt("@string/spinner",spinner.getSelectedItemPosition()));
    }



}