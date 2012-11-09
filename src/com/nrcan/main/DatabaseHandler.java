package com.nrcan.main;

import com.nrcan.models.MetadataModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import android.util.Log;
import android.app.Activity;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "nrcanDatabase";
    private static final int DATABASE_VERSION = 1;

    private ArrayList<String> resultQuery;
    private Context context;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    	db.execSQL(MetadataModel.getCreateTableStatement());
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    public long insertRow(String tableName, String nullCol, ContentValues values) {
    	SQLiteDatabase db = getWritableDatabase();
    	
    	long rowNum = db.insert(tableName, nullCol, values);
    	
    	System.out.println("New Row: " + rowNum);
    	
    	db.close();
    	
    	return rowNum;
    }
    
    public void updateRow(String tableName, ContentValues values, String whereClause, String[] whereArgs) {
    	SQLiteDatabase db = getWritableDatabase();
    	
    	db.update(tableName, values, whereClause, whereArgs);
    	
    	db.close();
    }
    
    /*
    public void deleteRow() {
    	SQLiteDatabase db = getWritableDatabase();
    	
    	long tmp = db.delete("metadata", "nrcanid1 = ?", new String[] { String.valueOf(rowNum) } );
    	
    	System.out.println("Returnd Row: " + tmp);
    	System.out.println("Deleted Row: " + rowNum--);
    	
    	db.close();
    }
    */

    public void executeQuery(String query) {
    	SQLiteDatabase db = getWritableDatabase();

        if(query == null) {
            Log.v("MetadataModel", "query is null");
            throw new IllegalArgumentException("query is null");
        }

        try {

            Cursor cursor = db.rawQuery(query, null);

            ((Activity)context).startManagingCursor(cursor);

            if(cursor != null) {

                resultQuery = new ArrayList<String>();
                String[] columnNames = cursor.getColumnNames();
                StringBuilder results = new StringBuilder();

                while(cursor.moveToNext()) {
                    for(String s : columnNames) {
                        results.append(cursor.getString(cursor.getColumnIndex(s)) + "\t");
                    }
                    resultQuery.add(results.toString().trim());
                }
            }

            cursor.close();
        } finally {
        	db.close();
        }
    }

    public void executeQuery(String query, String[] selectionArgs) {
    	SQLiteDatabase db = getWritableDatabase();

        if(query == null) {
            Log.v("MetadataModel", "query is null");
            throw new IllegalArgumentException("query is null");
        }

        try {

            Cursor cursor = db.rawQuery(query, selectionArgs);

            ((Activity)context).startManagingCursor(cursor);

            if(cursor != null) {

                resultQuery = new ArrayList<String>();
                String columnNames[] = cursor.getColumnNames();
                StringBuilder results = new StringBuilder();

                while(cursor.moveToNext()) {
                    for(String s : columnNames) {
                        results.append(cursor.getString(cursor.getColumnIndex(s)) + "\t");
                    }
                    resultQuery.add(results.toString().trim());
                }
            }

            cursor.close();
        } finally {
        	db.close();
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
        return (String[])resultQuery.get(index).split("\t");
    }
    
    public ArrayList<String> getList() {
        return resultQuery;
    }
}
