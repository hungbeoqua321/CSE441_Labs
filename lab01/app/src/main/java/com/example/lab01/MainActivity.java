package com.example.lab01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText eA, eb, Result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        eA = findViewById(R.id.EditA);
        eb = findViewById(R.id.EditB);
        Result = findViewById(R.id.Result);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            String a = eA.getText().toString();
            String b = eb.getText().toString();
            if (a.isEmpty() || b.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                return;
            }
            int numA = Integer.parseInt(a);
            int numB = Integer.parseInt(b);
            Result.setText(String.valueOf(numA + numB));
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}