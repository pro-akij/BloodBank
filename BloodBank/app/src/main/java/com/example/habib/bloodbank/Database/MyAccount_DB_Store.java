package com.example.habib.bloodbank.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyAccount_DB_Store extends SQLiteOpenHelper {

    public static final String Database_Name="DATABASE_MYACCOUNT";
    public static final String Table_Name="TABLE_ACCOUNT";
    public static final String Id="ID";
    public static final String Coloum1="MY_NAME";
    public static final String Coloum2="MY_CONTACT";
    public static final String Coloum3="MY_BLOOD";
    public static final String Coloum4="MY_DISTRICT";
    Context context;
    public MyAccount_DB_Store(Context context) {
        super(context, Database_Name,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE " +Table_Name+"(" +Id+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +Coloum1+ " TEXT, " +Coloum2+ " TEXT, " +Coloum3+ " TEXT, " +Coloum4+ " TEXT "+")");
        }
        catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Table_Name);
    }
    public long Insert_Data(String my_Name, String my_contact, String my_Blood, String my_District){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(Coloum1, my_Name);
        cv.put(Coloum2, my_contact);
        cv.put(Coloum3, my_Blood);
        cv.put(Coloum4, my_District);
        long check= sqLiteDatabase.insert(Table_Name,null,cv);
        return check;
    }
    public Cursor Display_Data(){
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "+Table_Name, null);
        return cursor;
    }
}
