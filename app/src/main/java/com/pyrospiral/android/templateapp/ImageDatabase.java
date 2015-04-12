package com.pyrospiral.android.templateapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by adeshkala on 11/04/15.
 */
public class ImageDatabase {


    public static final String ROW_ID = "_id";
    public static final String Image_ID= "id_image";



    private static final String TAG = "DBAdapters";
    private static final String DATABASE_NAME = "MyDBWSS";
    private static final String DATABASE_TABLE = "time_tabless";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE =
            "create table "+DATABASE_TABLE+" ("+ROW_ID+" integer primary key autoincrement, "
                    +Image_ID+" INTEGER);";
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public ImageDatabase(Context ctx) {
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
            db.execSQL("DROP TABLE IF EXISTS time_tables");
            onCreate(db);
        }
    }


    //---opens the database---
    public ImageDatabase open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close() {
        DBHelper.close();
    }


    //---insert a contact into the database---
    public long insertContact(int items) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(Image_ID, items);






        return db.insert(DATABASE_TABLE, null, initialValues);
    }
    public boolean deleteContact(String items) {
        return db.delete(DATABASE_TABLE, DBAdapter.ITEMS+" = '"+items+"'", null) > 0;
    }


    //---retrieves all the contacts---
    public Cursor getAllItems() {
        return db.query(DATABASE_TABLE, new String[]{ROW_ID,Image_ID},null, null, null, null,ROW_ID+ " ASC");
    }







    public void deleteEverything() {
        db.delete(DATABASE_TABLE, null , null);
    }


}
