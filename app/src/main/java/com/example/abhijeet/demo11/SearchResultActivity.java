package com.example.abhijeet.demo11;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static com.example.abhijeet.demo11.DbHelper.CONTENT;
import static com.example.abhijeet.demo11.DbHelper.DATABASE_NAME;
import static com.example.abhijeet.demo11.DbHelper.TABLE_NAME;

public class SearchResultActivity extends AppCompatActivity {

    SQLiteDatabase database ;
    Cursor cursor , cursor2;
    DbHelper helper = new DbHelper(this);
    EditText mEditText;
    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        mEditText = (EditText) findViewById(R.id.edit_text);
    }

    public void fetch_result(View view) {

        s = mEditText.getText().toString();


        database = helper.getWritableDatabase();
        cursor = database.rawQuery("SELECT * FROM "+ TABLE_NAME + " WHERE dt = " +s+"" ,null);
        cursor2 = database.rawQuery("SELECT * FROM "+ TABLE_NAME + " WHERE "+ s +" = 1" ,null);

        String ll = Integer.toString(cursor2.getCount());

        Log.i("cursor length", ll);

        try{
            while( cursor !=null && cursor.moveToNext()) {

               String text = cursor.getString(cursor.getColumnIndex(CONTENT));
               Integer date1 = cursor.getInt(cursor.getColumnIndex("dt"));

               String date = date1.toString();

               Log.i("The text is", text);
               Log.i("The date is ", date);

           }}
        finally {
           cursor.close();
       }
        try {
            while (cursor2 != null && cursor2.moveToNext()) {
                Log.i("GOING INSIDE while", "YES");

                String text = cursor.getString(cursor.getColumnIndex(CONTENT));
                String date = cursor.getString(cursor.getColumnIndex("dt"));

                Log.i("The text is", text);
                Log.i("The date is ", date);
            }
        }finally {
           cursor2.close();
       }




    }
}
