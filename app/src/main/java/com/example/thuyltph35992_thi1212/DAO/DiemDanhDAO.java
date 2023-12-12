package com.example.thuyltph35992_thi1212.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thuyltph35992_thi1212.DTO.DiemDanhDTO;
import com.example.thuyltph35992_thi1212.DbHelper.MyDbHelper;

import java.util.ArrayList;
import java.util.List;

public class DiemDanhDAO {
    MyDbHelper db_;
    SQLiteDatabase db;

    public DiemDanhDAO(Context context){
        db_ = new MyDbHelper(context);
        db = db_.getWritableDatabase();
    }

    public Long add (DiemDanhDTO nv){
        ContentValues values = new ContentValues();
        values.put("maSV",nv.getMaSV());
        values.put("hoten",nv.getHoTen());
        values.put("Email",nv.getEmail());
        values.put("tongvang",nv.getTong_vang());

        return db.insert("tb_diem_danh",null,values);
    }

    public long xoa(DiemDanhDTO nv){
        String [] id = new String[]{
                String.valueOf(nv.getMaSV())
        };
        return db.delete("tb_diem_danh","maSV=?",id);
    }

    public long capnhap(DiemDanhDTO nv){
        ContentValues values = new ContentValues();
        values.put("maSV",nv.getMaSV());
        values.put("hoten",nv.getHoTen());


        String [] id = new String[]{
                String.valueOf(nv.getMaSV())
        };

        return db.update("tb_diem_danh",values,"maSV=?",id);
    }

    public List<DiemDanhDTO> getData(){
        List<DiemDanhDTO> list = new ArrayList<>();
        Cursor c =db.rawQuery("select * from tb_diem_danh",null);
        if(c!=null&&c.getCount()>0){
            c.moveToFirst();
            do {
                DiemDanhDTO dv = new DiemDanhDTO();

                dv.setMaSV(c.getString(0));
                dv.setHoTen(c.getString(1));
                dv.setEmail(c.getString(2));
                dv.setTong_vang(c.getInt(3));

                list.add(dv);

            }while (c.moveToNext());

        }
        return list;
    }
}
