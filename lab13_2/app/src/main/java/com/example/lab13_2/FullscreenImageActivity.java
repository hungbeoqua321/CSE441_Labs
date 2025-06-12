package com.example.lab13_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullscreenImageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_image);
        ImageView imageView = findViewById(R.id.fullscreen_image);
        int resId = getIntent().getIntExtra("imageResId", 0);
        if (resId != 0) {
            imageView.setImageResource(resId);
        }
        imageView.setOnClickListener(v -> finish()); // Tap to close
    }
}
