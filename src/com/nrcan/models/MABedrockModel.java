package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.nrcan.entities.EnvironSurficialEntity;
import com.nrcan.entities.MABedrockEntity;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;

public class MABedrockModel {
	private DatabaseHandler dbHandler;
	private final Context context;
	
	private MABedrockEntity mabedrock;
	
	// Table column keys
		private static final String MABEDROCK_TABLE_NAME = "mabedrock";
		private static final String MABEDROCK_NRCID3 = "nrcanId3";
		private static final String MABEDROCK_NRCID2 = "nrcanId2";
		private static final String MABEDROCK_STATION_ID = "stationID";
		private static final String MABEDROCK_MANO = "maNo";
		private static final String MABEDROCK_MANID = "manID";
		private static final String MABEDROCK_MA = "ma";
		private static final String MABEDROCK_UNIT = "unit";
		private static final String MABEDROCK_MINERAL = "mineral";
		private static final String MABEDROCK_MODE = "mode";
		private static final String MABEDROCK_DISTRIBUTE = "distribute";
		private static final String MABEDROCK_NOTES = "notes";
		
		private static final String MABEDROCK_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + MABEDROCK_TABLE_NAME +" (" +
				MABEDROCK_NRCID3 + " INTEGER PRIMARY KEY autoincrement, " +
				MABEDROCK_NRCID2 + " INTEGER, " +
				MABEDROCK_STATION_ID + " TEXT, " +
				MABEDROCK_MANO + " TEXT, " +
				MABEDROCK_MANID + " TEXT, " +
				MABEDROCK_MA + " TEXT, " +
				MABEDROCK_UNIT + " TEXT, " +
				MABEDROCK_MINERAL + " TEXT, " +
				MABEDROCK_MODE + " TEXT, " +
				MABEDROCK_DISTRIBUTE + " TEXT," +
				MABEDROCK_NOTES + " TEXT," +
				
				
				");";
	public MABedrockModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}
	
	public MABedrockEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { MABEDROCK_TABLE_NAME, MABEDROCK_STATION_ID, String.valueOf(mabedrock.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new MABedrockEntity(dbHandler.getSplitRow(0));
    }
	/*
	public ArrayList<EarthmatBedrockEntity> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { EARTHMATBEDROCK_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        ArrayList<EarthmatBedrockEntity> entities = new ArrayList<EarthmatBedrockEntity>();

        int length = dbHandler.getList().size();
        
        for(int i = 0; i < length; i++) {
            entities.add(new EarthmatBedrockEntity(dbHandler.getSplitRow(i)));   
        }
        
        return entities;
    }
	*/
	public long insertRow() {

        int rowsAffected = 0;
        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            ContentValues values = new ContentValues();
            values.put(MABEDROCK_NRCID2, " ");
            values.put(MABEDROCK_STATION_ID, " ");
            values.put(MABEDROCK_MANO, " ");
            values.put(MABEDROCK_MANID, " ");
            values.put(MABEDROCK_MA, " ");
            values.put(MABEDROCK_UNIT, " ");
            values.put(MABEDROCK_MINERAL, " ");
            values.put(MABEDROCK_MODE, " ");
            values.put(MABEDROCK_DISTRIBUTE, " ");	            
            values.put(MABEDROCK_NOTES, " ");
            
            
            
            

            long rowID = database.insert(MABEDROCK_TABLE_NAME, null, values);
            mabedrock.setID(String.valueOf(rowID));

            rowsAffected = updateRow();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }
	public int updateRow() {

        int rowsAffected = 0;
        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            ContentValues values = new ContentValues();
            
            
            values.put(MABEDROCK_STATION_ID, mabedrock.getStationID());
            values.put(MABEDROCK_MANO, mabedrock.getMaNo());
            values.put(MABEDROCK_MANID, mabedrock.getManID());
            values.put(MABEDROCK_MA, mabedrock.getMa());
            values.put(MABEDROCK_UNIT, mabedrock.getUnit());
            values.put(MABEDROCK_MINERAL, mabedrock.getMineral());
            values.put(MABEDROCK_MODE, mabedrock.getMode());
            values.put(MABEDROCK_DISTRIBUTE, mabedrock.getDistribute());	            
            values.put(MABEDROCK_NOTES, mabedrock.getNotes());

            rowsAffected = database.update(MABEDROCK_TABLE_NAME, values, CHECKth 5 MABEDROCK_STATION_ID + "=?",
                    new String[] { String.valueOf(mabedrock.getID()) });

            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public int deleteRow() {

        int rowsAffected = 0;
        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {
            rowsAffected = database.delete(MABEDROCK_TABLE_NAME, MABEDROCK_STATION_ID + "=?",
                    new String[] { String.valueOf(mabedrock.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public MABedrockEntity getEntity() {
        return mabedrock;
    }

    public void setEntity(String[] mabedrock) {
        this.mabedrock = new MABedrockEntity(mabedrock);
    }

    public static String getCreateTableStatement() {
        return MABEDROCK_TABLE_CREATE;
    }
}
