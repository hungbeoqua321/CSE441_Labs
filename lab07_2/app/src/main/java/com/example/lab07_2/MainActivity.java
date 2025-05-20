package com.example.lab07_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText a,b;
    Button btn;
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
        a = findViewById(R.id.txta);
        b = findViewById(R.id.txtb);
        btn = findViewById(R.id.kq);
        btn.setOnClickListener(view -> {
            String str1 = a.getText().toString();
            String str2 = b.getText().toString();
            if (str1.isEmpty() || str2.isEmpty()) {
                a.setError("Please enter a number");
                b.setError("Please enter a number");
            } else {
                int num1 = Integer.parseInt(str1);
                int num2 = Integer.parseInt(str2);
                float sum = (float) -1 * ((float) num2 /num1);
                Intent intent = new Intent(MainActivity.this, resultActivity.class);
                intent.putExtra("result", sum);
                startActivity(intent);
            }
        });
    }
}