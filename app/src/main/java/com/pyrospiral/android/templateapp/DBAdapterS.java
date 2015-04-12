package com.pyrospiral.android.templateapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapterS {
    public static final String ROW_ID = "_id";
    public static final String TITLE = "day";
    public static final String DATA= "data";
    public static final String LATI = "strtime";
    public static final String LONGI = "endtime";


    // public static final String KEY_EMAIL = "email";

    private static final String TAG = "DBAdapterTH";
    private static final String DATABASE_NAME = "MyDBth";
    private static final String DATABASE_TABLE = "time_tableT";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE =
            "create table "+DATABASE_TABLE+" ("+ROW_ID+" integer primary key autoincrement, "
                    +TITLE+" VARCHAR(255), "+DATA+" VARCHAR(255), "+LATI+" DOUBLE, "+LONGI+" DOUBLE);";
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public DBAdapterS(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            long x;
            try {
                db.execSQL(DATABASE_CREATE);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS time_table");
            onCreate(db);
        }
    }


    //---opens the database---
    public DBAdapterS open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close() {
        DBHelper.close();
    }


    //---insert a contact into the database---
    public long insertContact(String title,String data, double start_time, double end_time) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(TITLE, title);
        initialValues.put(DATA, data);

        initialValues.put(LATI,start_time);

        initialValues.put(LONGI, end_time);

        return db.insert(DATABASE_TABLE, null, initialValues);
    }



    //---retrieves all the contacts---
    public Cursor getAllContacts() {
        return db.query(DATABASE_TABLE, new String[]{ROW_ID,TITLE,DATA,LATI,LONGI},
                null, null, null, null,null);
    }








}

