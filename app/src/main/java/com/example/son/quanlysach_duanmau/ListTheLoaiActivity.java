package com.example.son.quanlysach_duanmau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.son.quanlysach_duanmau.dao.TheLoaiDao;

public class ListTheLoaiActivity extends AppCompatActivity {
    private Button btnAddTheLoai;
    private RecyclerView rcvListTheLoai;
    TheLoaiDao theLoaiDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai);
        btnAddTheLoai = (Button) findViewById(R.id.btnAddTheLoai);
        rcvListTheLoai = (RecyclerView) findViewById(R.id.rcvListTheLoai);
        theLoaiDao=new TheLoaiDao(ListTheLoaiActivity.this);
        btnAddTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ListTheLoaiActivity.this, TheLoaiActivity.class);
                startActivity(intent);
            }
        });
    }
}
