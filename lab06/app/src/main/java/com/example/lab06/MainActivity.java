package com.example.lab06;

import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name,cmnd,ttbs;
    RadioButton tc,cd,dh;
    CheckBox db,ds,dc;
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
        name = findViewById(R.id.inpName);
        cmnd = findViewById(R.id.inpCMND);
        ttbs = findViewById(R.id.ttbs);
        tc = findViewById(R.id.tc);
        cd = findViewById(R.id.cd);
        dh = findViewById(R.id.dh);
        db = findViewById(R.id.db);
        ds = findViewById(R.id.ds);
        dc = findViewById(R.id.dc);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            String nameInput = name.getText().toString().trim();
            String cmndInput = cmnd.getText().toString().trim();

            if (nameInput.isEmpty() || nameInput.split("\\s+").length < 3) {
                name.setError("Tên không được để trống và phải chứa ít nhất 3 từ");
                name.requestFocus();
                return;
            }
            if (!cmndInput.matches("\\d{9}")) {
                cmnd.setError("CMND chỉ được nhập số và phải có đúng 9 ký tự");
                cmnd.requestFocus();
                return;
            }

            if (!db.isChecked() && !ds.isChecked() && !dc.isChecked()) {
                ttbs.setError("Phải chọn ít nhất 1 checkbox");
                ttbs.requestFocus();
                return;
            }

            String degree = "";
            if (tc.isChecked()) degree = "Trung cấp";
            else if (cd.isChecked()) degree = "Cao Đẳng";
            else if (dh.isChecked()) degree = "Đại học";

            StringBuilder hobbies = new StringBuilder();
            if (db.isChecked()) hobbies.append("Đọc báo, ");
            if (ds.isChecked()) hobbies.append("Đọc sách, ");
            if (dc.isChecked()) hobbies.append("Đọc Coding, ");
            if (hobbies.length() > 0) hobbies.setLength(hobbies.length() - 2);



            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle(Html.fromHtml("<font color='cyan'>Thông tin cá nhân</font>", Html.FROM_HTML_MODE_LEGACY))
                    .setMessage(
                        nameInput + "\n" +
                        cmndInput + "\n" +
                        degree + "\n" +
                        hobbies.toString() +
                        "\n----------------------\n" +
                        ttbs.getText().toString().trim()
                    )
                    .setPositiveButton("Đóng", (dialog, which) -> dialog.dismiss())
                    .show();

        });

    }
    @Override
    public void onBackPressed() {
        if (isTaskRoot()) {
            new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Xác nhận")
                .setMessage("Bạn có chắc chắn muốn thoát không?")
                .setPositiveButton("Có", (dialog, which) -> super.onBackPressed())
                .setNegativeButton("Không", (dialog, which) -> dialog.dismiss())
                .show();
        } else {
            super.onBackPressed();
        }
    }
}