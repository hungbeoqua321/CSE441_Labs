package com.example.lab09;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton playButton,stopButton;
    Boolean flag = true;
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

        playButton = findViewById(R.id.playButton);
        stopButton = findViewById(R.id.stopButton);
        playButton.setOnClickListener(view -> {
            if (flag) {
                startService(new Intent(MainActivity.this, MyService.class));
                flag = false;
            } else {
                stopService(new Intent(MainActivity.this, MyService.class));
                flag = true;
            }
        });
        stopButton.setOnClickListener(view -> {
            stopService(new Intent(MainActivity.this, MyService.class));
            playButton.setImageResource(R.drawable.play);
            flag = true;
            finish();
        });
    }
}