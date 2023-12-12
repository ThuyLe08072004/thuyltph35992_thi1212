package com.example.thuyltph35992_thi1212.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    static String DB_NAME = "145";
    static int DB_VERSION = 1;
    public MyDbHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String tb_sv = "CREATE TABLE tb_diem_danh (maSV      TEXT ,     hoten   TEXT, Email TEXT,    tongvang  Integer );";
        //sqLiteDatabase.execSQL("INSERT INTO tb_diem_danh VALUES('1','thuy','thuyltph35992@fpt.edu.vn',10)");
        sqLiteDatabase.execSQL(tb_sv);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS tb_diem_danh");
//        onCreate(db);

    }
}
