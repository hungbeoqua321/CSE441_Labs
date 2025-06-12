package com.example.lab13_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

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

        TextView textView = findViewById(R.id.textView);
        GridView gridView = findViewById(R.id.gridView);

        // Generate random values for the grid
        ArrayList<String> values = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            values.add(String.valueOf(random.nextInt(100)));
        }

        MyGridAdapter adapter = new MyGridAdapter(this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                int[] imageResIds = {
                    R.drawable.photo_1,
                    R.drawable.photo_2,
                    R.drawable.photo_3,
                    R.drawable.photo_4,
                    R.drawable.photo_5,
                    R.drawable.photo_6
                };
                int resId = imageResIds[position % imageResIds.length];
                Intent intent = new Intent(MainActivity.this, FullscreenImageActivity.class);
                intent.putExtra("imageResId", resId);
                startActivity(intent);
                adapter.animateView(view);
            }
        });
    }
}