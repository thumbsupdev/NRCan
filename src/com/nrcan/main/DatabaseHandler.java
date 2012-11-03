package com.nrcan.main;

import com.nrcan.models.MetadataModel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
import java.util.ArrayList;
import android.util.Log;
import java.util.Locale;
import android.app.Activity;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "nrcanDatabase";
    private static final int DATABASE_VERSION = 1;

    private ArrayList<String> resultQuery;
    private SQLiteDatabase database;
    private Context context;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        openConnection();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(MetadataModel.getCreateTableStatement());
    }

    // Called when DATABASE_VERSION is incremented
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /*  db.execSQL("DROP TABLE IF EXISTS metadata");
            onCreate(db); */
    }

    public void openConnection() {

        try {
            database = this.getWritableDatabase();
            database.setLocale(Locale.getDefault());
            database.setLockingEnabled(true); // use database lock to be thread safe
        } catch(SQLiteException sqle) {
            Log.v("MetadataModel openConnection()", sqle.getMessage());
            throw new SQLiteException(sqle.getMessage());
        }
    }

    public void closeConnection() {
        
        database.close();
    }

    public void executeQuery(String query) {

        if(query == null) {
            Log.v("MetadataModel", "query is null");
            throw new IllegalArgumentException("query is null");
        }

        database.beginTransaction();

        try {

            Cursor cursor = this.getWritableDatabase().rawQuery(query, null);

            ((Activity)context).startManagingCursor(cursor);

            if(cursor != null) {

                resultQuery = new ArrayList<String>();
                String[] columnNames = cursor.getColumnNames();
                StringBuilder results = new StringBuilder();

                while(cursor.moveToNext()) {

                    for(String s : columnNames) {

                        results.append(cursor.getString(cursor.getColumnIndex(s)) + " ");
                    }

                    resultQuery.add(results.toString().trim());
                }
            }

            cursor.close();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public void executeQuery(String query, String[] selectionArgs) {

        if(query == null) {
            Log.v("MetadataModel", "query is null");
            throw new IllegalArgumentException("query is null");
        }

        database.beginTransaction();

        try {

            Cursor cursor = this.getWritableDatabase().rawQuery(query, selectionArgs);

            ((Activity)context).startManagingCursor(cursor);

            if(cursor != null) {

                resultQuery = new ArrayList<String>();
                String columnNames[] = cursor.getColumnNames();
                StringBuilder results = new StringBuilder();

                while(cursor.moveToNext()) {

                    for(String s : columnNames) {

                        results.append(cursor.getString(cursor.getColumnIndex(s)) + " ");
                    }

                    resultQuery.add(results.toString().trim());
                }
            }

            cursor.close();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public String getRow(int index) {

        if(index < 0) {
            Log.v("getRow()", "index is below 0");
            throw new IllegalArgumentException("index is below 0");
        }

        return resultQuery.get(index);
    }

    public String[] getSplitRow(int index) {
        
        return (String[])resultQuery.get(index).split(" ");
    }

    
    public ArrayList<String> getList() {
     
        return resultQuery;
    }

    public SQLiteDatabase getDatabase() {
        
        return database;
    }
}

