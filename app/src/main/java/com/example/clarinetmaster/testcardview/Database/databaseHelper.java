package com.example.clarinetmaster.testcardview.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.clarinetmaster.testcardview.R;

public class databaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "MYDATABASE";
    public static final String TABLE_NAME = "CARD";
    public static final String COL_ID = "_ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_IMAGE = "IMAGE";
    public static final String COL_SCORE = "SCORE";
    private static final int DATABASE_VERSION = 1;

    private final String SQL_CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COL_NAME+" TEXT,"+
            COL_IMAGE+" INTEGER,"+
            COL_SCORE+" INTEGER" +
            ")";

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        insertExampleData(db);
    }

    private void insertExampleData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "Android");
        cv.put(COL_IMAGE, R.mipmap.ic_launcher);
        cv.put(COL_SCORE, 20);
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "iOS");
        cv.put(COL_IMAGE, R.mipmap.ic_launcher);
        cv.put(COL_SCORE, 50);
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "Windows");
        cv.put(COL_IMAGE, R.mipmap.ic_launcher);
        cv.put(COL_SCORE, 40);
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "Linux");

        cv.put(COL_IMAGE, R.mipmap.ic_launcher);
        cv.put(COL_SCORE, 10);
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "MacOS");
        cv.put(COL_IMAGE, R.mipmap.ic_launcher);
        cv.put(COL_SCORE, 70);
        db.insert(TABLE_NAME, null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
