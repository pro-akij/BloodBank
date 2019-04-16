package com.example.habibadnan.e_commerce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DB_Healper extends SQLiteOpenHelper {
    public static final String DB_name="E_COMMERCE_DATABASE";
    public static final String DB_table="E_COMMERCE_TABLE";
    public static final String Id="E_COMMERCE_ID";
    public static final String DB_image="E_COMMERCE_IMAGE";
    public static final String DB_header="E_COMMERCE_HEADER";
    public static final String DB_prize="E_COMMERCE_TEXT_VALUE";

    public DB_Healper(Context context) {
        super(context, DB_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String string=("CREATE TABLE "+DB_table+" ("+Id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ DB_image +" BLOB, "+ DB_header +" TEXT, "+DB_prize+" TEXT)");
        db.execSQL(string);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_table);
    }


    public long insertData(String header, String prize){
        SQLiteDatabase database= getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(DB_header,header);
        contentValues.put(DB_prize,prize);
        long check= database.insert(DB_table,null,contentValues);
        database.close();
        return check;
    }
    public Cursor display_Data(){
        SQLiteDatabase database= getReadableDatabase();
        Cursor cursor;
        return cursor= database.rawQuery("SELECT * FROM "+DB_table,null);
    }
}
