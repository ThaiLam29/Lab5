package com.thailam.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangNhap_activity extends AppCompatActivity {
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        EditText edtname = findViewById(R.id.edtname_Signin);
        EditText edtpass = findViewById(R.id.edtpass_signin);
        Button btndangnhap = findViewById(R.id.btndangnhap);
        Button btndangky = findViewById(R.id.btndangky);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString(Dangky_activity.KEY_USERNAME);
            password = bundle.getString(Dangky_activity.KEY_PASSWORD);
        }
        edtname.setText(username);
        edtpass.setText(password);

        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangNhap_activity.this, Dangky_activity.class));
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString();
                String pass = edtpass.getText().toString();

                if (name.trim().isEmpty()) {
                    Toast.makeText(DangNhap_activity.this, "Chua nhap tai khoan", Toast.LENGTH_SHORT).show();
                } else if (pass.trim().isEmpty()) {
                    Toast.makeText(DangNhap_activity.this, "Chua nhap mat khau", Toast.LENGTH_SHORT).show();
                } else if (!name.equals(username) && !pass.equals(password)) {
                    Toast.makeText(DangNhap_activity.this, "Sai tai khoan hoac mat khau", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DangNhap_activity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DangNhap_activity.this, bai2_lab5.class));
                }
            }
        });
    }
}

