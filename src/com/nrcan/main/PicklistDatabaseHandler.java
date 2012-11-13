package com.nrcan.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class PicklistDatabaseHandler extends SQLiteOpenHelper {
	private List<String> plNames;

	public PicklistDatabaseHandler(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	public List<String> getCol1 (int id) {
		List<String> tmpDD = new ArrayList<String>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT DISTINCT col1 FROM " + plNames.get(id) + " ORDER BY id ASC", null);
		
		if (c != null)
		{
			while(c.moveToNext()) {
				tmpDD.add(c.getString(c.getColumnIndex("col1")));
			}
		}
		else
		{
			tmpDD.add("empty...");
		}
		
		c.close();
		db.close();
		
		return tmpDD;
	}
	
	public List<String> getCol2 (int id, String col1) {
		List<String> tmpDD = new ArrayList<String>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT DISTINCT col2 FROM " + plNames.get(id) + " WHERE col1 = '" + col1 + "' ORDER BY id ASC", null);
		
		if (c != null)
		{
			tmpDD.add(" ");
			while(c.moveToNext()) {
				tmpDD.add(c.getString(c.getColumnIndex("col2")));
			}
			
		}
		else
		{
			tmpDD.add("empty...");
		}
		
		c.close();
		db.close();
		
		return tmpDD;
	}
	
	public List<String> getCol3 (int id, String col1, String col2) {
		List<String> tmpDD = new ArrayList<String>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT DISTINCT col3 FROM " + plNames.get(id) + " WHERE col1 = '" + col1 + "' AND col2 = '" + col2 + "' ORDER BY id ASC", null);
		
		if (c != null)
		{
			tmpDD.add(" ");
			while(c.moveToNext()) {
				tmpDD.add(c.getString(c.getColumnIndex("col3")));
			}
			
		}
		else
		{
			tmpDD.add("empty...");
		}
		
		c.close();
		db.close();
		
		return tmpDD;
	}

	public void setPLNames(List<String> tmp) {
		this.plNames = tmp;
	}

	public void createTables() {
		SQLiteDatabase db = this.getWritableDatabase();

		for (int i = 0; i < plNames.size(); i++)
		{
			db.execSQL("CREATE TABLE IF NOT EXISTS " + plNames.get(i) + " (" +
					"id INTEGER PRIMARY KEY, " +
					"col1 TEXT, " +
					"col2 TEXT, " +
					"col3 TEXT" +
					")");
		}

		db.close();
	}
	
	public void dropTables() {
		SQLiteDatabase db = this.getWritableDatabase();

		for (int i = 0; i < plNames.size(); i++)
			db.execSQL("DROP TABLE IF EXISTS " + plNames.get(i));

		db.close();
	}

	public void fillTables (Context context) {
		SQLiteDatabase db = this.getWritableDatabase();
		String line = null;

		for (int i = 0; i < plNames.size(); i++)
		{
			//if(plNames.get(i).compareTo("lutEarthmatRocktype") == 0)
			if(i == 5)
			{
				try {
					InputStream fileIS = context.getAssets().open("LUT/" + plNames.get(i) + ".csv");
					BufferedReader input = new BufferedReader(new InputStreamReader(fileIS));

					int lineCount = 0;
					while ((line = input.readLine()) != null)
					{
						if (lineCount++ > 1)
						{
							String[] RowData = line.split(",");
							if (RowData[0] == null)
								RowData[0] = "";
							if (RowData[1] == null)
								RowData[1] = "";
							if (RowData[2] == null)
								RowData[2] = "";

							//System.out.println(RowData[0] + ", " + RowData[1] + ", " + RowData[2]);
							db.execSQL("INSERT INTO " + plNames.get(i) + " (" +
									"col1, col2, col3) VALUES " +
									"('" + RowData[0] + "', '" + RowData[1] + "', '" + RowData[2] + "')");
						}
					}

					input.close();
					fileIS.close();

				} catch (IOException e1) {
					System.out.println(plNames.get(i));
					e1.printStackTrace();
				}
			}
			//else if(plNames.get(i).compareTo("lut") == 0)
			else if (i == 7 | i == 8 | i == 9 | i == 10 | i == 11)
			{
				try {
					InputStream fileIS = context.getAssets().open("LUT/" + plNames.get(i) + ".csv");
					BufferedReader input = new BufferedReader(new InputStreamReader(fileIS));

					int lineCount = 0;
					while ((line = input.readLine()) != null)
					{
						if (lineCount++ > 1)
						{
							String[] RowData = line.split(",");
							if (RowData[0] == null)
								RowData[0] = "";
							if (RowData[1] == null)
								RowData[1] = "";

							//System.out.println(RowData[0] + ", " + RowData[1]);
							db.execSQL("INSERT INTO " + plNames.get(i) + " (" +
									"col1, col2, col3) VALUES " +
									"('" + RowData[0] + "', '" + RowData[1] + "', '')");
						}
					}

					input.close();
					fileIS.close();

				} catch (IOException e1) {
					System.out.println(plNames.get(i));
					e1.printStackTrace();
				}
			}
			else
			{
				try {
					InputStream fileIS = context.getAssets().open("LUT/" + plNames.get(i) + ".csv");
					BufferedReader input = new BufferedReader(new InputStreamReader(fileIS));

					int lineCount = 0;
					while ((line = input.readLine()) != null)
					{
						if (lineCount++ > 1)
						{
							//System.out.println(line);
							db.execSQL("INSERT INTO " + plNames.get(i) + " (" +
									"col1, col2, col3) VALUES " +
									"('" + line + "', '', '')");
						}
					}

					input.close();
					fileIS.close();

				} catch (IOException e1) {
					System.out.println(plNames.get(i));
					e1.printStackTrace();
				}
			}
		}

		db.close();
	}
}
