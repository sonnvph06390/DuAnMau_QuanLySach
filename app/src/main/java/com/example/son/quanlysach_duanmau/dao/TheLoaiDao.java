package com.example.son.quanlysach_duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.son.quanlysach_duanmau.database.DatabaseHelper;
import com.example.son.quanlysach_duanmau.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDao {
    DatabaseHelper databaseHelper;
    SQLiteDatabase database;
    public static final String TAG = "TheLoaiDao";
    public static final String SQL_THE_LOAI = "CREATE TABLE TheLoai (" +
            "matheloai text primary key," +
            "tentheloai text," +
            "mota text," +
            "vitri integer" + ");";
    public static final String TABLE_NAME = "TheLoai";

    public TheLoaiDao(Context context) {
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    public int insertTheLoai(TheLoai theLoai) {
        ContentValues values = new ContentValues();
        values.put("matheloai", theLoai.getMaTheLoai());
        values.put("tentheloai", theLoai.getTenTheLoai());
        values.put("mota", theLoai.getMoTa());
        values.put("vitri", theLoai.getViTri());
        try {
            if (database.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<TheLoai> getAllTheLoai() {
        List<TheLoai> dsTheLoai = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            TheLoai ee = new TheLoai();
            ee.setMaTheLoai(cursor.getString(0));
            ee.setTenTheLoai(cursor.getString(1));
            ee.setMoTa(cursor.getString(2));
            ee.setViTri(cursor.getInt(3));
            dsTheLoai.add(ee);
            Log.d("=====", ee.toString());
            cursor.moveToNext();
        }
        cursor.close();
        return dsTheLoai;
    }

    public int updateTheLoai(TheLoai theLoai) {
        ContentValues values = new ContentValues();
        values.put("matheloai", theLoai.getMaTheLoai());
        values.put("tentheloai", theLoai.getTenTheLoai());
        values.put("mota", theLoai.getMoTa());
        values.put("vitri", theLoai.getViTri());
        int result = database.update(TABLE_NAME, values, "matheloai=?", new String[]{theLoai.getMaTheLoai()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteTheLoaiByID(String matheloai) {
        int result = database.delete(TABLE_NAME, "matheloai=?", new String[]{matheloai});
        if (result == 0){
            return -1;
        }
        return 1;
    }
}
