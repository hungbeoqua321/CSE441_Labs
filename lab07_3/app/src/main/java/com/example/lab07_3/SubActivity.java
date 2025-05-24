package com.example.lab07_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {
    EditText a,b;
    Button sum,minus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        a = findViewById(R.id.getA);
        b = findViewById(R.id.getB);
        sum = findViewById(R.id.retS);
        minus = findViewById(R.id.retM);

        int numA = getIntent().getIntExtra("numA", 0);
        int numB = getIntent().getIntExtra("numB", 0);
        a.setText(String.valueOf(numA));
        b.setText(String.valueOf(numB));
        sum.setOnClickListener(v -> {
            int result = numA + numB;
            Intent intent = new Intent(SubActivity.this, MainActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);
        });
        minus.setOnClickListener(v -> {
            int result = numA - numB;
            Intent intent = new Intent(SubActivity.this, MainActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);
        });

    }
}