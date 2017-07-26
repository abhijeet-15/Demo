package com.example.abhijeet.demo11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by abhijeet on 7/25/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyData.db";
    public static final String CONTENT = "retrieved_text";
    public static final String TAG1 = "tag1";
    public static final String TAG2 = "tag2";
    public static final String TAG3 = "tag3";
    public static final String TAG4 = "tag4";
    public static final String TAG5 = "tag5";
    public static final String TABLE_NAME = "tblVALUES";
    Cursor cursor;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME , null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME  + "  (_id INTEGER PRIMARY KEY AUTOINCREMENT, dt datetime default current_date " + " ," +
                CONTENT +" TEXT ," +
                TAG1 +" INTEGER ," +
                TAG2 +" INTEGER ," +
                TAG3 +" INTEGER ," +
                TAG4 +" INTEGER ," +
                TAG5 +" INTEGER "+");"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertValue (String retrieved_text,Integer tag1 ,Integer tag2,Integer tag3,Integer tag4,Integer tag5) {
        SQLiteDatabase db = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
        contentValues.put("retrieved_text", retrieved_text);
        contentValues.put("tag1", tag1);
        contentValues.put("tag2", tag2);
        contentValues.put("tag3", tag3);
        contentValues.put("tag4", tag4);
        contentValues.put("tag5",tag5);
       long r =   db.insert("tblVALUES", null, contentValues);



      /*  String ROW1 = "INSERT INTO " + TABLE_NAME + " ("
                + CONTENT + ", " + TAG1 + ", "
                + TAG2 + ", " + TAG3 + ", "
                + TAG4 + ", " + TAG5 + ") Values ('retrieved_text',tag1,tag2 ,tag3,tag4,tag5 )";
        db.execSQL(ROW1); */

        Log.i("The text is" , retrieved_text);
        if(r != -1) {
            Log.i("data inserted ?", "YES!");
            String s = String.valueOf(r);
            Log.i("The row number is ", s);


            }

        return true;

    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM tblvalues WHERE id="+id+"", null );
        return res;

    }
}
