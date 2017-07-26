package com.example.abhijeet.demo11;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class DbActivity extends AppCompatActivity {
    TextView mTextView;

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    int v1,v2,v3,v4,v5 = 0;
    DbHelper dbHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        dbHelper = new DbHelper(this);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        mTextView = (TextView) findViewById(R.id.textview);
        mTextView.setText(message);

        // setting each textbox to respective id



    }

    public void store(View view) {

        checkBox1 = (CheckBox)this.findViewById(R.id.tag1);
        checkBox2 = (CheckBox)this.findViewById(R.id.tag2);
        checkBox3 = (CheckBox)this.findViewById(R.id.tag3);
        checkBox4 = (CheckBox)this.findViewById(R.id.tag4);
        checkBox5 = (CheckBox)this.findViewById(R.id.tag5);

        if(checkBox1.isChecked())
            v1 = 1;

        if(checkBox2.isChecked())
            v2 = 1;

        if(checkBox3.isChecked())
            v3 = 1;
        if(checkBox4.isChecked())
            v4 = 1;
        if(checkBox5.isChecked())
            v5 = 1;



        dbHelper.insertValue(mTextView.getText().toString(),v1,v2,v3,v4,v5);



    }
}
