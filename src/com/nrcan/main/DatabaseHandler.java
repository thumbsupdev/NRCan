package com.nrcan.main;

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
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public long insertRow(String tableName, String nullCol, ContentValues values) {
		SQLiteDatabase db = getWritableDatabase();

		long rowNum = db.insert(tableName, nullCol, values);

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

	/*
	public void executeQuery(String query) {
		SQLiteDatabase db = getWritableDatabase();

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
	}*/

	public void executeQuery(String query, String[] selectionArgs) {
		int count;
		ArrayList<String> tmp = new ArrayList<String>();
		SQLiteDatabase db = getWritableDatabase();
		Cursor c = db.rawQuery(query, selectionArgs);
		
		if(c != null) {
			c.moveToNext();
			count = c.getColumnCount();

			for(int i = 0; i < count; i++)
				tmp.add(c.getString(i));
		}
		else
		{
			System.out.println("empty?");
		}

		c.close();
		db.close();
		resultQuery = tmp;
	}

	/*
	public String getRow(int index) {
		if(index < 0) {
			Log.v("getRow()", "index is below 0");
			throw new IllegalArgumentException("index is below 0");
		}

		return resultQuery.get(index);
	}*/

	public void createTable(String query) {
		SQLiteDatabase db = getWritableDatabase();

		db.execSQL(query);

		db.close();
	}

/*	
	public String[] getSplitRow(int index) {
		System.out.println(resultQuery.get(index));
		String[] t = resultQuery.get(index).split("\\t");
		for(int i = 0; i < t.length; i++)
			System.out.println(t[i]);

		return resultQuery.get(index).split("\\t");
	}*/

	public ArrayList<String> getList() {
		return resultQuery;
	}

	public ArrayList<ArrayList<String>> populateMetadataList() {
		int num = 0;
		ArrayList<ArrayList<String>> projects = new ArrayList<ArrayList<String>>();
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c = db.rawQuery("SELECT * FROM metadata ORDER BY nrcanId1 ASC", null);

		if (c != null)
		{
			while(c.moveToNext()) {
				ArrayList<String> t = new ArrayList<String>();
				String value = c.getString(c.getColumnIndex("nrcanId1"));
				String pcode = c.getString(c.getColumnIndex("prjct_code"));
				String gcode = c.getString(c.getColumnIndex("geolcode"));
				t.add(value);
				t.add(pcode + " - " + gcode);
				projects.add(t);
				num++;
			}
		}
		else
		{
			projects.get(num).add("empty...");
		}

		c.close();
		db.close();
		return projects;
	}

	public ArrayList<ArrayList<String>> populateList(String table, String col, int id, String targetColumn1, String targetColumn2) {
		int num = 0;
		ArrayList<ArrayList<String>> tmp = new ArrayList<ArrayList<String>>();
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c = db.rawQuery("SELECT * FROM " + table + " WHERE " + col + " = " + id + " ORDER BY " + targetColumn1 + " ASC", null);

		if (c != null)
		{
			while(c.moveToNext()) {
				ArrayList<String> t = new ArrayList<String>();
				String value1 = c.getString(c.getColumnIndex(targetColumn1));
				String value2 = c.getString(c.getColumnIndex(targetColumn2));
				t.add(value1);
				t.add(value2);
				tmp.add(t);
				num++;
			}
		}
		else
		{
			tmp.get(num).add("empty...");
		}

		c.close();
		db.close();
		return tmp;
	}
}
