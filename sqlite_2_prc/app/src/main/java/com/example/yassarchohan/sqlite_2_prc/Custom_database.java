package com.example.yassarchohan.sqlite_2_prc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Yassar chohan on 11/6/2016.
 */
public class Custom_database extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    SQLiteDatabase sql_db;
     Context con;

    private static final String DB_NAME = "Students_records.db";
    private static final String TABLE_NAME = "students_marks";

    private static final String _ID = "id";
    private static final String NAME = "Students_Name";
    private static final String FATHER_NAME = "F_NAME";
    private static final String MARKS = "s_MARKS";


    public Custom_database(Context context) {
        super(context, DB_NAME,null, VERSION);
        this.con = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE_NAME+"("+_ID+" INTEGER AUTO_INCREMENT PRIMARY KEY , "+NAME+" TEXT , " + FATHER_NAME+" TEXT , "+MARKS+" INTEGER )";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABLE_NAME+"";
        db.execSQL(sql);
        onCreate(db);

    }

    public void insertdata(String name , String fname , int marks){
        sql_db  = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME , name);
        values.put(FATHER_NAME , fname);
        values.put(MARKS , marks);

        long no =  sql_db.insert(TABLE_NAME,null,values);

        if(no == -1){
            Toast.makeText(con, "not inserted", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(con, "inserted", Toast.LENGTH_SHORT).show();
        }


    }

    public ArrayList<getrecords> readData(){

        getrecords getmethods = new getrecords();
        String name,fname;
        int marks;
        ArrayList<getrecords> data = new ArrayList<getrecords>();
        try {

            sql_db = this.getReadableDatabase();
            Cursor cus = sql_db.rawQuery("select * from " + TABLE_NAME + "", null);
             while (cus.moveToNext()){
                 data.add(new getrecords(cus.getString(cus.getColumnIndex("Students_Name")), cus.getString(cus.getColumnIndex("F_NAME")), cus.getInt(cus.getColumnIndex("s_MARKS"))));
             }
            cus.close();
           }
        catch (Exception e){
            Toast.makeText(con, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return data;
    }
}


//