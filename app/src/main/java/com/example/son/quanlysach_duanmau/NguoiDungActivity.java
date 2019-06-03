package com.example.son.quanlysach_duanmau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.son.quanlysach_duanmau.dao.NguoiDungDao;
import com.example.son.quanlysach_duanmau.model.NguoiDung;

public class NguoiDungActivity extends AppCompatActivity {
    EditText edUserName, edPassWord, edPhone, edHoTen;
    Button btnAddUser, btnUpdate;
    NguoiDungDao nguoiDungDao;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        edUserName = findViewById(R.id.edUserName);
        edPassWord = findViewById(R.id.edPassWord);
        edPhone = findViewById(R.id.edPhoneNumber);
        edHoTen = findViewById(R.id.edFullName);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnAddUser = findViewById(R.id.btnAddUser);
        try {
            intent = getIntent();
            if (intent != null) {
                Bundle bundle = intent.getBundleExtra("bun");
                edUserName.setText(bundle.getString("username"));
                edPassWord.setText(bundle.getString("password"));
                edPhone.setText(bundle.getString("phone"));
                edHoTen.setText(bundle.getString("hoten"));
            }
        } catch (Exception ex) {
            Log.e("tag nguoi dung activity", ex.getMessage());
        }


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nguoiDungDao = new NguoiDungDao(NguoiDungActivity.this);
                NguoiDung nguoiDung = new NguoiDung(edUserName.getText().toString(), edPassWord.getText().toString(),
                        edPhone.getText().toString(), edHoTen.getText().toString());
                if (nguoiDungDao.updateNguoiDung(nguoiDung) == 1) {
                    Toast.makeText(NguoiDungActivity.this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NguoiDungActivity.this, "Cap nhat khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nguoiDungDao = new NguoiDungDao(NguoiDungActivity.this);
                NguoiDung nguoiDung = new NguoiDung(edUserName.getText().toString(), edPassWord.getText().toString(),
                        edPhone.getText().toString(), edHoTen.getText().toString());
                if (nguoiDungDao.insertNguoiDung(nguoiDung) == 1) {
                    Toast.makeText(NguoiDungActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NguoiDungActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
