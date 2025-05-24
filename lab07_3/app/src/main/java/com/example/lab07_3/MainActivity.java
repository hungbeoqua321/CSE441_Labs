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

public class MainActivity extends AppCompatActivity {
    EditText a,b,kq;
    Button req;
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
        a = findViewById(R.id.inpA);
        b = findViewById(R.id.inpB);
        req = findViewById(R.id.button);
        kq = findViewById(R.id.kq);

        int result = getIntent().getIntExtra("result", 0);
        if (result != 0) {
            kq.setText(String.valueOf(result));
        }
        req.setOnClickListener(v -> {
            String strA = a.getText().toString();
            String strB = b.getText().toString();
            if (strA.isEmpty() || strB.isEmpty()) {
                return;
            }
            int numA = Integer.parseInt(strA);
            int numB = Integer.parseInt(strB);
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            intent.putExtra("numA", numA);
            intent.putExtra("numB", numB);
            startActivity(intent);
        });
    }
}