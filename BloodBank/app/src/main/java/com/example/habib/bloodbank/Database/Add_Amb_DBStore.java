package com.example.habib.bloodbank.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Add_Amb_DBStore extends SQLiteOpenHelper {

    public static final String Database_Name="DATABASE_AMBULANCE";
    public static final String Table_Name="TABLE_AMBULACE";
    public static final String Id="ID";
    public static final String Coloum1="AMB_NAME";
    public static final String Coloum2="AMB_LOCATION";
    public static final String Coloum3="AMB_DISTRICT";
    public static final String Coloum4="AMB_CONTACT";
    Context context;
    public Add_Amb_DBStore(Context context) {
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
    public long Insert_Data(String org_Name, String org_Address, String org_District, String org_Contact){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(Coloum1, org_Name);
        cv.put(Coloum2, org_Address);
        cv.put(Coloum3, org_District);
        cv.put(Coloum4, org_Contact);
        long check= sqLiteDatabase.insert(Table_Name,null,cv);
        return check;
    }
    public Cursor Display_Data(){
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "+Table_Name, null);
        return cursor;
    }
}
