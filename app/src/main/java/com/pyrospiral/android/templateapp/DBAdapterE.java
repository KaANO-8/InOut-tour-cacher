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
public class DBAdapterE {


    public static final String ROW_ID = "_id";
    public static final String ITEMS= "items";
    public static final String DONE= "done";


    // public static final String KEY_EMAIL = "email";

    private static final String TAG = "DBAdapterW";
    private static final String DATABASE_NAME = "MyDBW";
    private static final String DATABASE_TABLE = "time_tableW";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE =
            "create table "+DATABASE_TABLE+" ("+ROW_ID+" integer primary key autoincrement, "
                    +ITEMS+" DOUBLE, "+DONE+" BOOLEAN);";
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public DBAdapterE(Context ctx) {
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

                ContentValues initialValues = new ContentValues();

                initialValues.put(ITEMS, "TOOTHPASTE");


                x=db.insert(DATABASE_TABLE, null, initialValues);
                initialValues.put(ITEMS, "CHARGER");


                x=db.insert(DATABASE_TABLE, null, initialValues);
                initialValues.put(ITEMS, "MOBILE PHONE");


                x=db.insert(DATABASE_TABLE, null, initialValues);
                initialValues.put(ITEMS, "LAPTOP");


                x=db.insert(DATABASE_TABLE, null, initialValues);
                initialValues.put(ITEMS, "CLOTHES");


                x=db.insert(DATABASE_TABLE, null, initialValues);
                initialValues.put(ITEMS, "HANDBAG");


                x=db.insert(DATABASE_TABLE, null, initialValues);
                initialValues.put(ITEMS, "WALLET");


                x=db.insert(DATABASE_TABLE, null, initialValues);





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
    public DBAdapterE open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close() {
        DBHelper.close();
    }


    //---insert a contact into the database---
    public long insertContact(String items) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(ITEMS, items);

        initialValues.put(DONE, false);




        return db.insert(DATABASE_TABLE, null, initialValues);
    }
    public boolean deleteContact(String items) {
        return db.delete(DATABASE_TABLE, DBAdapter.ITEMS+" = '"+items+"'", null) > 0;
    }


    //---retrieves all the contacts---
    public Cursor getAllItems() {
        return db.query(DATABASE_TABLE, new String[]{ROW_ID,ITEMS,DONE},null, null, null, null,ROW_ID+ " ASC");
    }





    public boolean updateSubject(String items) {
        ContentValues args = new ContentValues();

        //args.put(DAY,x);
        args.put(DONE,true);
        return db.update(DATABASE_TABLE, args, DBAdapter.ITEMS + "= '" + items, null) > 0;
    }

    public void deleteEverything() {
        db.delete(DATABASE_TABLE, null , null);
    }


}