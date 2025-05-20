package com.example.lab05_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText a,b,c;
    Button nx,so,ex;
    TextView result;
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
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        nx = findViewById(R.id.next);
        so = findViewById(R.id.solve);
        ex = findViewById(R.id.exit);
        result = findViewById(R.id.textView4);

        nx.setOnClickListener(v ->{
            a.setText("");
            b.setText("");
            c.setText("");
            a.requestFocus();
        });

        so.setOnClickListener(v ->{
            int A = Integer.parseInt(a.getText().toString());
            int B = Integer.parseInt(b.getText().toString());
            int C = Integer.parseInt(c.getText().toString());
            double D = B * B - 4 * A * C;
            if (D > 0) {
                double x1 = (-B + Math.sqrt(D)) / (2 * A);
                double x2 = (-B - Math.sqrt(D)) / (2 * A);
                result.setText("Px có 2 No: x1 = " + x1 + "; x2 = " + x2);
            } else if (D == 0) {
                double x = -B / (2 * A);
                result.setText("x = " + x);
            } else {
                result.setText("Vô phương cứu chữa");
            }
        });

        ex.setOnClickListener(v ->{
            finish();
        });
    }
}