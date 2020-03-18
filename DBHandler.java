package com.example.pihestudentdetails;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String databasename = "PIHE.db";

    public DBHandler(Context context) {
        super(context, databasename, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table students(" + "id text PRIMARY KEY," + "firstName text," + "lastName text," + "contact text," + "address text" + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String addStudent(Student n) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", n.getStudentID());
        cv.put("firstName", n.getFName());
        cv.put("lastName", n.getLName());
        cv.put("contact", n.getContact());
        cv.put("address", n.getAddress());

        long res = db.insert("students", null, cv);

        //add student to the database
        if (res == -1)
            return "Failed";
        else
            return "Successfully Added student";

    }

    //search existing students from database
    public Cursor search(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from students where id = '"+id +"'", null);
        return res;
    }


}
