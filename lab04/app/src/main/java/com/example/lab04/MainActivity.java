package com.example.lab04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText doC,doF;
    Button CtoF,FtoC,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        doC = findViewById(R.id.C);
        doF = findViewById(R.id.F);
        CtoF = findViewById(R.id.CtoF);
        FtoC = findViewById(R.id.FtoC);
        clear = findViewById(R.id.clear);
        CtoF.setOnClickListener(v -> {
            String celsius = doC.getText().toString();
            if (!celsius.isEmpty()) {
                double c = Double.parseDouble(celsius);
                double f = (c * 9/5) + 32;
                doF.setText(String.valueOf(f));
            }
        });
        FtoC.setOnClickListener(v -> {
            String fahrenheit = doF.getText().toString();
            if (!fahrenheit.isEmpty()) {
                double f = Double.parseDouble(fahrenheit);
                double c = (f - 32) * 5/9;
                doC.setText(String.valueOf(c));
            }
        });
        clear.setOnClickListener(v -> {
            doC.setText("");
            doF.setText("");
        });
    }
}