package com.example.son.quanlysach_duanmau;

import android.renderscript.Script;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.son.quanlysach_duanmau.dao.TheLoaiDao;
import com.example.son.quanlysach_duanmau.model.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {
    private EditText edMaTheLoai;
    private EditText edTenTheLoai;
    private EditText edVitri;
    private EditText edMota;
    private Button btnAddTheLoaiToList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        edMaTheLoai = (EditText) findViewById(R.id.edMaTheLoai);
        edTenTheLoai = (EditText) findViewById(R.id.edTenTheLoai);
        edVitri = (EditText) findViewById(R.id.edVitri);
        edMota = (EditText) findViewById(R.id.edMota);
        btnAddTheLoaiToList = (Button) findViewById(R.id.btnAddTheLoaiToList);
        btnAddTheLoaiToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TheLoaiDao theLoaiDao=new TheLoaiDao(TheLoaiActivity.this);
                TheLoai theLoai=new TheLoai();
                theLoai.setMaTheLoai(edMaTheLoai.getText().toString());
                theLoai.setMaTheLoai(edTenTheLoai.getText().toString());
                theLoai.setMoTa(edMota.getText().toString());
                theLoai.setViTri(Integer.parseInt(edVitri.getText().toString()));
                if (theLoaiDao.insertTheLoai(theLoai)==1){
                    Toast.makeText(TheLoaiActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(TheLoaiActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
