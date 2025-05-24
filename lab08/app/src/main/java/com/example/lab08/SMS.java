package com.example.lab08;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SMS extends AppCompatActivity {
    EditText inpS,mes;
    Button back;
    ImageButton sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sms);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inpS = findViewById(R.id.inpS);
        back = findViewById(R.id.button4);
        sms = findViewById(R.id.imageButton2);
        mes = findViewById(R.id.mes);

        sms.setOnClickListener(v -> {
            String phone = inpS.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + phone));
            intent.putExtra("sms_body",mes.getText().toString());
            startActivity(intent);
        });
    }
}