package com.example.habib.bloodbank.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Add_Rqst_DBStore extends SQLiteOpenHelper {

    public static final String Database_Name="DATABASE_REQUEST";
    public static final String Table_Name="TABLE_REQUEST";
    public static final String Id="ID";
    public static final String Coloum1="REQ_NAME";
    public static final String Coloum2="REQ_BL_TYPE";
    public static final String Coloum3="REQ_BL_AMOUNT";
    public static final String Coloum4="REQ_DESTRICT";
    public static final String Coloum5="REQ_CONTACT";
    public static final String Coloum6="REQ_HOSPITAL_NM";
    public static final String Coloum7="REQ_HOSPITAL_LOC";
    public static final String Coloum8="REQ_WHY_NEED";
    Context context;
    public Add_Rqst_DBStore(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE " +Table_Name+"(" +Id+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +Coloum1+ " TEXT, " +Coloum2+ " TEXT, " +Coloum3+ " TEXT, " +Coloum4+
                    " TEXT, " +Coloum5+ " TEXT, " +Coloum6+ " TEXT, " +Coloum7+ " TEXT, " +Coloum8+ " TEXT "+")");
        }
        catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Table_Name);
    }
    public long Insert_Data(String req_Name, String req_Bl_Type, String req_Bl_Amount, String req_District,
                            String req_Contact, String req_Hospital_Nm, String req_Hospital_Loc, String req_Why_need){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(Coloum1, req_Name);
        cv.put(Coloum2, req_Bl_Type);
        cv.put(Coloum3, req_Bl_Amount);
        cv.put(Coloum4, req_District);
        cv.put(Coloum5, req_Contact);
        cv.put(Coloum6, req_Hospital_Nm);
        cv.put(Coloum7, req_Hospital_Loc);
        cv.put(Coloum8, req_Why_need);
        long check= sqLiteDatabase.insert(Table_Name,null,cv);
        return check;
    }
    public Cursor Display_Data(){
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "+Table_Name, null);
        return cursor;
    }
}
