package com.example.habib.bloodbank.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Add_Dnr_DBStore extends SQLiteOpenHelper {

    public static final String Database_Name="DATABASE_DONER";
    public static final String Table_Name="TABLE_DONER";
    public static final String Id="ID";
    public static final String Coloum1="DONER_NAME";
    public static final String Coloum2="DONER_BL_TYPE";
    public static final String Coloum3="DONER_DISTRICT";
    public static final String Coloum4="DONER_CONTACT";
    Context context;
    public Add_Dnr_DBStore(Context context) {
        super(context, Database_Name, null, 1);
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
    public long Insert_Data(String doner_Name, String doner_Bl_Type, String doner_District, String doner_Contact){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(Coloum1, doner_Name);
        cv.put(Coloum2, doner_Bl_Type);
        cv.put(Coloum3, doner_District);
        cv.put(Coloum4, doner_Contact);
        long check= sqLiteDatabase.insert(Table_Name,null,cv);
        return check;
    }
    public Cursor Display_Data(){
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "+Table_Name, null);
        return cursor;
    }
}
