package com.example.lab08;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Call extends AppCompatActivity {
    Button backButton;
    ImageButton callButton;
    EditText phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_call);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        callButton = findViewById(R.id.imageButton);
        backButton = findViewById(R.id.button4);
        phoneNumber = findViewById(R.id.inpS);

        callButton.setOnClickListener(v -> {
            if (ActivityCompat.checkSelfPermission(Call.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Call.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber.getText().toString()));
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(Call.this,MainActivity.class);
            startActivity(intent);
        });
    }
}