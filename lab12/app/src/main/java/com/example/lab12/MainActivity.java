package com.example.lab12;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        // Setup ListView and adapter
        ListView lvItems = findViewById(R.id.lvItems);
        TextView tvSelectedInfo = findViewById(R.id.tvSelectedInfo);
        String[] items = {
            "iPhone 15 Pro",
            "Samsung Galaxy S24 Ultra",
            "Google Pixel 8",
            "Xiaomi 14",
            "Sony Xperia 1 V"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(adapter);
        lvItems.setOnItemClickListener((parent, view, position, id) -> {
            int displayPos = position + 1;
            tvSelectedInfo.setText(getString(R.string.selected_info, displayPos, items[position]));
        });
    }
}