package com.example.lab03;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txt1, txt2, txt3;
    Button btncong, btntru, btnnhan, btnchia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Tích), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        btncong = findViewById(R.id.button);
        btntru = findViewById(R.id.button2);
        btnnhan = findViewById(R.id.button3);
        btnchia = findViewById(R.id.button4);
        btncong.setOnClickListener(v -> {
            if (txt1.getText().toString().isEmpty() || txt2.getText().toString().isEmpty()) {
                txt3.setText("Please enter both numbers");
            }
            else {
                int a = Integer.parseInt(txt1.getText().toString());
                int b = Integer.parseInt(txt2.getText().toString());
                int c = a + b;
                txt3.setText(String.valueOf(c));
            }
        });
        btntru.setOnClickListener(v -> {
            if (txt1.getText().toString().isEmpty() || txt2.getText().toString().isEmpty()) {
                txt3.setText("Please enter both numbers");
            }
            else {
                int a = Integer.parseInt(txt1.getText().toString());
                int b = Integer.parseInt(txt2.getText().toString());
                int c = a - b;
                txt3.setText(String.valueOf(c));
            }
        });
        btnnhan.setOnClickListener(v -> {
            if (txt1.getText().toString().isEmpty() || txt2.getText().toString().isEmpty()) {
                txt3.setText("Please enter both numbers");
            }
            else {
                int a = Integer.parseInt(txt1.getText().toString());
                int b = Integer.parseInt(txt2.getText().toString());
                int c = a * b;
                txt3.setText(String.valueOf(c));
            }
        });
        btnchia.setOnClickListener(v -> {
            if (txt1.getText().toString().isEmpty() || txt2.getText().toString().isEmpty()) {
                txt3.setText("Please enter both numbers");
            }
            else {
                int a = Integer.parseInt(txt1.getText().toString());
                int b = Integer.parseInt(txt2.getText().toString());
                if (b == 0) {
                    txt3.setText("Cannot divide by zero");
                }
                else{
                    float c =(float) a / b;
                    txt3.setText(String.valueOf(c));
                }
            }
        });

    }
}