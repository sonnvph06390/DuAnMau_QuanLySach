package com.example.son.quanlysach_duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.son.quanlysach_duanmau.database.DatabaseHelper;
import com.example.son.quanlysach_duanmau.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
    DatabaseHelper databaseHelper;
    SQLiteDatabase database;
    public static final String TAG = "NguoiDungDao";
    public static final String SQL_NGUOI_DUNG = "CREATE TABLE NguoiDung (" +
            "username text primary key," +
            "password text," +
            "phone text," +
            "hoten text" + ");";
    public static final String TABLE_NAME = "NguoiDung";

    public NguoiDungDao(Context context) {
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    public int insertNguoiDung(NguoiDung nguoiDung) {
        ContentValues values = new ContentValues();
        values.put("username", nguoiDung.getUserName());
        values.put("password", nguoiDung.getPassWord());
        values.put("phone", nguoiDung.getPhone());
        values.put("hoten", nguoiDung.getFullName());
        // database.insert(TABLE_NAME,null,values);
        try {
            if (database.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, "Khong thanh cong");
        }
        return 1;
    }

    public List<NguoiDung> getAllNguoiDung() {
        List<NguoiDung> ls = new ArrayList<NguoiDung>();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setUserName(cursor.getString(0));
            nguoiDung.setPassWord(cursor.getString(1));
            nguoiDung.setPhone(cursor.getString(2));
            nguoiDung.setFullName(cursor.getString(3));
            ls.add(nguoiDung);
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }

    public int deleteNguoiDung(String username) {
        int result = database.delete(TABLE_NAME, "username=?", new String[]{username});
        if (result < 0){
            return -1;
        }
        return 1;

    }
    public int updateNguoiDung(NguoiDung nd) {
        ContentValues values = new ContentValues();
        values.put("username", nd.getUserName());
        values.put("password", nd.getPassWord());
        values.put("phone", nd.getPhone());
        values.put("hoten", nd.getFullName());
        try{
            if (database.update(TABLE_NAME, values, "username=?", new String[]{nd.getUserName()})< 0) {
                return -1;
            }

        }catch (Exception ex){
            Log.e("NguoidungDao", ex.getMessage());
        }
        return 1;

    }

}
