package com.thailam.lab5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Suathongtin extends AppCompatActivity {


    public static String KEY_NAME = "name_sua";
    public static String KEY_DIACHI = "diaChi_sua";
    public static String KEY_TITLE = "title_sua";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suathongtin);

        Spinner spinner = findViewById(R.id.spinner_sua);
        @SuppressLint("WrongViewCast") TextInputEditText name_sua = findViewById(R.id.suaten);
        @SuppressLint("WrongViewCast") TextInputEditText diaChi_sua = findViewById(R.id.suadiachi);
        Button button = findViewById(R.id.btnsubmitsua);

        ArrayList<bai1_lab5.noi_Hoc> list = new ArrayList<>();
        list.add(new bai1_lab5.noi_Hoc("Fpoly Hà Nội", R.mipmap.hanoi));
        list.add(new bai1_lab5.noi_Hoc("Fpoly Đà Nẵng", R.mipmap.logodanang));
        list.add(new bai1_lab5.noi_Hoc("Fpoly Tây Nguyên", R.mipmap.logotaynguyen));
        list.add(new bai1_lab5.noi_Hoc("Fpoly Hồ Chí Minh", R.mipmap.logohcm));
        list.add(new bai1_lab5.noi_Hoc("Fpoly Cần Thơ", R.mipmap.logocantho));

        bai1_lab5.noiHocAdapter adapter = new bai1_lab5.noiHocAdapter(this, list);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_sua.getText().toString();
                String diaChi = diaChi_sua.getText().toString();
                String title = spinner.getSelectedItem().toString();

                Intent intent = new Intent(Suathongtin.this, bai2_lab5.class);
                intent.putExtra(KEY_NAME, name);
                intent.putExtra(KEY_DIACHI, diaChi);
                intent.putExtra(KEY_TITLE, title);
                startActivity(intent);
            }
        });

    }
}