package com.example.son.quanlysach_duanmau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.son.quanlysach_duanmau.adapter.NguoiDungAdapter;
import com.example.son.quanlysach_duanmau.dao.NguoiDungDao;
import com.example.son.quanlysach_duanmau.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    public static List<NguoiDung> dsNguoiDung = new ArrayList<>();
    Button btnAddUserActivity;
    ListView listNguoiDung;
    NguoiDungDao nguoiDungDao;
    NguoiDungAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nguoi_dung);
        btnAddUserActivity = findViewById(R.id.btnAddUserActivity);
        listNguoiDung = findViewById(R.id.lvNguoiDung);
        nguoiDungDao = new NguoiDungDao(ListNguoiDungActivity.this);
        dsNguoiDung = nguoiDungDao.getAllNguoiDung();
        adapter=new NguoiDungAdapter(ListNguoiDungActivity.this,dsNguoiDung);
        listNguoiDung.setAdapter(adapter);
        btnAddUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListNguoiDungActivity.this, NguoiDungActivity.class);
                startActivity(intent);
            }
        });
    }
}
