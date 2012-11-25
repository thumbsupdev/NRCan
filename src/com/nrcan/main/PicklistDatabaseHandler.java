package com.nrcan.main;

import java.util.ArrayList;
import com.nrcan.values.PreparedStatements;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.database.SQLException;

public class PicklistDatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "nrcanPicklistDatabase";
    private static final int DATABASE_VERSION = 1;

    // save context for subclasses
    protected final Context context;

	public PicklistDatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    this.context = context;
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	public ArrayList<String> getCol1(String tableName) {
		
        ArrayList<String> list = new ArrayList<String>();
		SQLiteDatabase database = this.getWritableDatabase();
		
		Cursor cursor = database.rawQuery("SELECT DISTINCT col1 FROM " + tableName + " ORDER BY id ASC", null);
		
		if(cursor != null) {

			while(cursor.moveToNext()) {
				list.add(cursor.getString(cursor.getColumnIndex("col1")));
				//System.out.println(cursor.getString(cursor.getColumnIndex("col1")));
			}
		}
		else {
			list.add("The list for col1 is empty.");
		}
		
        if(cursor != null) {
		    cursor.close();
        }

        if(database != null) {
		    database.close();
        }
		
		return list;
	}
	
	public ArrayList<String> getCol2(String tableName, String col1) {

		ArrayList<String> list = new ArrayList<String>();
		SQLiteDatabase database = this.getWritableDatabase();
		
		Cursor cursor = database.rawQuery("SELECT DISTINCT col2 FROM " + tableName + " WHERE col1 = '" + col1 + "' ORDER BY id ASC", null);
		
		if(cursor != null) {

			list.add(" ");
			while(cursor.moveToNext()) {
				list.add(cursor.getString(cursor.getColumnIndex("col2")));
				//System.out.println(cursor.getString(cursor.getColumnIndex("col2")));
			}
		}
		else {
			list.add("The list for col2 is empty.");
		}
		
        if(cursor != null) {
		    cursor.close();
        }

        if(database != null) {
		    database.close();
        }
		
		return list;
	}
	
	public ArrayList<String> getCol3(String tableName, String col1, String col2) {

		ArrayList<String> list = new ArrayList<String>();
		SQLiteDatabase database = this.getWritableDatabase();
		
		Cursor cursor = database.rawQuery("SELECT DISTINCT col3 FROM " + tableName + " WHERE col1 = '" + col1 + "' AND col2 = '" + col2 + "' ORDER BY id ASC", null);
		
		if(cursor != null) {
			
            list.add(" ");
			while(cursor.moveToNext()) {
				list.add(cursor.getString(cursor.getColumnIndex("col3")));
				//System.out.println(cursor.getString(cursor.getColumnIndex("col3")));
			}
		}
		else {
			list.add("empty...");
		}
		
        if(cursor != null) {
		    cursor.close();
        }
        
        if(database != null) {
		    database.close();
        }
		
		return list;
	}

    public void execSQLStatement(String sqlStatement) {
        
        SQLiteDatabase database = this.getWritableDatabase();

        database.beginTransaction();
        try {

            database.execSQL(sqlStatement);
            database.setTransactionSuccessful();
        } catch(SQLException sqle) {
            throw new SQLException(sqle.getCause().getMessage());
        } finally {
            database.endTransaction();

            if(database != null) {
                database.close();
            }
        }
    }

    public void insertNewValue(String tableName, int columnNumber, String value, String columnOne, String columnTwo) {

        SQLiteDatabase database = this.getWritableDatabase();
        String newSql = "INSERT INTO " + tableName;
        SQLiteStatement sqlStatement;

        switch(columnNumber) {

            case 1:

                sqlStatement = database.compileStatement(newSql + PreparedStatements.INSERT_1_COL);

                sqlStatement.bindString(1, value);
                sqlStatement.execute();
                break;

            case 2:
                
                sqlStatement = database.compileStatement(newSql + PreparedStatements.INSERT_2_COL);

                sqlStatement.bindString(1, columnOne);
                sqlStatement.bindString(2, value);
                sqlStatement.execute();
                break;

            case 3:

                sqlStatement = database.compileStatement(newSql + PreparedStatements.INSERT_3_COL);

                sqlStatement.bindString(1, columnOne);
                sqlStatement.bindString(2, columnTwo);
                sqlStatement.bindString(3, value);
                sqlStatement.execute();
                break; 

            default: break;

        }

        if(database != null) {
            database.close();
        }
    }
    public boolean isBedrockLoaded(){
    	SQLiteDatabase database = this.getWritableDatabase();

        try {
        	database.query("lutBEDEarthmatRocktype", null, null,  null, null,null, null);
           
        } catch(SQLException sqle) {
        	database.close();
        	return false;
        } 
        database.close();
        return true;
    }
    
    public boolean isSurficialLoaded(){
    	SQLiteDatabase database = this.getWritableDatabase();

        try {
        	database.query("lutSUREarthmatLith2", null, null,  null, null,null, null);
            
        } catch(SQLException sqle) {
        	database.close();
        	return false;
        } 
        database.close();
        return true;
    }
}
