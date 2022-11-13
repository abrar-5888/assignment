package com.example.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="aoooo.db";
    public static final String TABLE_re="registeration";
    public static final String COL_1="ID";
    public static final String COL_2="FirstName";
    public static final String COL_3="LastName";
    public static final String COL_4="Password";
    public static final String COL_5="Email";
    public static final String COL_6="Phone";


    public static final String TABLE_loca="location";
    public static final String locCOL_2="LocName";
    public static final String locCOL_3="LocAdd";
    public static final String locCOL_1="ID";

    public DatabaseHelper(Context context) {
        super(context,
                DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_re +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FirstName TEXT,LastName TEXT,Password TEXT, Email TEXT,Phone TEXT )");

        db.execSQL("CREATE TABLE " + TABLE_loca +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "LocName TEXT,LocAdd TEXT )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_re); //Drop older table if existsS
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_loca); //Drop older table if exists
        onCreate(db);
    }
}