package com.example.lab04_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name, height,weight,BMI,result;
    Button btn;
    @SuppressLint("SetTextI18n")
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
        name = findViewById(R.id.name);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        btn = findViewById(R.id.button2);
        BMI = findViewById(R.id.BMI);
        result = findViewById(R.id.result);
        btn.setOnClickListener(v ->{
            double h = Double.parseDouble(height.getText().toString());
            double w = Double.parseDouble(weight.getText().toString());
            double bmi = w / (h * h);
            BMI.setText(String.valueOf(bmi));
            if (bmi < 18.5) {
                result.setText("gầy");
            } else if (bmi >= 18.5 && bmi < 24.9) {
                result.setText("bình thường");
            } else if (bmi >= 25 && bmi < 29.9) {
                result.setText("Thừa cân");
            } else if (bmi >= 30 && bmi < 34.9) {
                result.setText("Béo phì độ I");
            } else if (bmi >= 35 && bmi < 39.9) {
                result.setText("Béo phì độ II");
            } else {
                result.setText("Béo phì độ III");
            }
        }
        );
    }
}