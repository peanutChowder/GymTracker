package com.example.gymtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    private SharedPreferences userDetails;
    private SharedPreferences.Editor edit;

    private Button buttonSave, buttonLoad;
    private EditText editTextExercise1, editTextExercise2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSave = findViewById(R.id.buttonSave);
        buttonLoad = findViewById(R.id.buttonLoad);
        editTextExercise1 = findViewById(R.id.editTextExercise1);
        editTextExercise2 = findViewById(R.id.editTextExercise2);

        userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
        edit = userDetails.edit();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putString("arbitrary", editTextExercise1.getText().toString().trim());
                edit.apply();
            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String arbitrary = userDetails.getString("arbitrary", "");
                editTextExercise2.setText(arbitrary);
            }
        });
    }
}