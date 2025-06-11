package com.example.lab12_2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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

        EditText edtWork = findViewById(R.id.editText);
        EditText edtHour = findViewById(R.id.hour);
        EditText edtMinute = findViewById(R.id.minute);
        Button btnAddWork = findViewById(R.id.btnAddWork);
        ListView listViewWorks = findViewById(R.id.listViewWorks);

        SharedPreferences prefs = getSharedPreferences("works_prefs", MODE_PRIVATE);
        ArrayList<String> works = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, works);
        listViewWorks.setAdapter(adapter);

        // Load saved data
        works.addAll(prefs.getStringSet("works", new java.util.HashSet<>()));
        adapter.notifyDataSetChanged();

        Animation animAdd = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation animDelete = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation animShake = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        btnAddWork.setOnClickListener(v -> {
            String work = edtWork.getText().toString().trim();
            String hour = edtHour.getText().toString().trim();
            String minute = edtMinute.getText().toString().trim();
            boolean valid = true;
            if (work.isEmpty()) {
                edtWork.setError("Không được để trống");
                edtWork.startAnimation(animShake);
                valid = false;
            }
            if (hour.isEmpty()) {
                edtHour.setError("Không được để trống");
                edtHour.startAnimation(animShake);
                valid = false;
            }
            if (minute.isEmpty()) {
                edtMinute.setError("Không được để trống");
                edtMinute.startAnimation(animShake);
                valid = false;
            }
            if (!valid) return;
            String item = work + " - " + hour + ":" + minute;
            works.add(item);
            adapter.notifyDataSetChanged();
            listViewWorks.startAnimation(animAdd);
            // Save to SharedPreferences
            prefs.edit().putStringSet("works", new java.util.HashSet<>(works)).apply();
            edtWork.setText("");
            edtHour.setText("");
            edtMinute.setText("");
        });

        listViewWorks.setOnItemClickListener((parent, view, position, id) -> {
            view.startAnimation(animDelete);
            works.remove(position);
            adapter.notifyDataSetChanged();
            // Save to SharedPreferences
            prefs.edit().putStringSet("works", new java.util.HashSet<>(works)).apply();
        });
    }
}