package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.nrcan.entities.EnvironSurficialEntity;
import com.nrcan.entities.MineralBedrockEntity;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;

public class MineralBedrockModel {
	private DatabaseHandler dbHandler;
	private final Context context;
	
	private MineralBedrockEntity mineralbedrock;
	
	// Table column keys
		private static final String MINERALBEDROCK_TABLE_NAME = "mineralbedrock";
		private static final String MINERALBEDROCK_NRCID4 = "nrcanId4";
		private static final String MINERALBEDROCK_NRCID3 = "nrcanId3";
		private static final String MINERALBEDROCK_STATION_ID = "stationID";
		private static final String MINERALBEDROCK_EARRTHMATID = "earthmatID";
		private static final String MINERALBEDROCK_MINERALID = "mineralID";
		private static final String MINERALBEDROCK_MINERALNO = "mineralNo";
		private static final String MINERALBEDROCK_MINERAL = "mineral";
		private static final String MINERALBEDROCK_FORM = "form";
		private static final String MINERALBEDROCK_HABIT = "habit";
		private static final String MINERALBEDROCK_OCCURRENCE = "occurrence";
		private static final String MINERALBEDROCK_COLOUR = "colour";
		private static final String MINERALBEDROCK_SIZEMINMM= "sizeMinmm";
		private static final String MINERALBEDROCK_SIZEMAXMM = "sizeMaxmm";
		private static final String MINERALBEDROCK_MODE = "mode";
		private static final String MINERALBEDROCK_NOTES = "notes";
		
		private static final String MINERALBEDROCK_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + MINERALBEDROCK_TABLE_NAME +" (" +
				MINERALBEDROCK_NRCID4 + " INTEGER PRIMARY KEY autoincrement, " +
				MINERALBEDROCK_NRCID3 + " INTEGER, " +
				MINERALBEDROCK_STATION_ID + " TEXT, " +
				MINERALBEDROCK_EARRTHMATID + " TEXT, " +
				MINERALBEDROCK_MINERALID + " TEXT, " +
				MINERALBEDROCK_MINERALNO + " TEXT, " +
				MINERALBEDROCK_MINERAL + " TEXT, " +
				MINERALBEDROCK_FORM + " TEXT, " +
				MINERALBEDROCK_HABIT + " TEXT, " +
				MINERALBEDROCK_OCCURRENCE + " TEXT," +
				MINERALBEDROCK_COLOUR + " TEXT," +
				MINERALBEDROCK_SIZEMINMM + " TEXT," +
				MINERALBEDROCK_SIZEMAXMM + " TEXT," +
				MINERALBEDROCK_MODE + " TEXT" +
				MINERALBEDROCK_NOTES + " TEXT" +
				
				");";
	public MineralBedrockModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}
	public MineralBedrockEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { MINERALBEDROCK_TABLE_NAME, MINERALBEDROCK_STATION_ID, String.valueOf(mineralbedrock.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new MineralBedrockEntity(dbHandler.getSplitRow(0));
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
            values.put(MINERALBEDROCK_NRCID3, " ");
            values.put(MINERALBEDROCK_STATION_ID, " ");
            values.put(MINERALBEDROCK_EARRTHMATID, " ");
            values.put(MINERALBEDROCK_MINERALID , " ");
            values.put(MINERALBEDROCK_MINERALNO, " ");
            values.put(MINERALBEDROCK_MINERAL, " ");
            values.put(MINERALBEDROCK_FORM, " ");
            values.put(MINERALBEDROCK_HABIT, " ");
            values.put(MINERALBEDROCK_OCCURRENCE, " ");	            
            values.put(MINERALBEDROCK_COLOUR, " ");
            values.put(MINERALBEDROCK_SIZEMINMM, " ");
            values.put(MINERALBEDROCK_SIZEMAXMM, " ");
            values.put(MINERALBEDROCK_MODE, " ");
            values.put(MINERALBEDROCK_NOTES, " ");
            
            

            long rowID = database.insert(MINERALBEDROCK_TABLE_NAME, null, values);
            mineralbedrock.setID(String.valueOf(rowID));

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
            
            
            values.put(MINERALBEDROCK_STATION_ID, mineralbedrock.getStationID());
            values.put(MINERALBEDROCK_EARRTHMATID, mineralbedrock.getEarthmatID());
            values.put(MINERALBEDROCK_MINERALID , mineralbedrock.getMineralID());
            values.put(MINERALBEDROCK_MINERALNO, mineralbedrock.getMineralNo());
            values.put(MINERALBEDROCK_MINERAL, mineralbedrock.getMineral());
            values.put(MINERALBEDROCK_FORM, mineralbedrock.getForm());
            values.put(MINERALBEDROCK_HABIT, mineralbedrock.getHabit());
            values.put(MINERALBEDROCK_OCCURRENCE, mineralbedrock.getOccurrence());	            
            values.put(MINERALBEDROCK_COLOUR, mineralbedrock.getColour());
            values.put(MINERALBEDROCK_SIZEMINMM, mineralbedrock.getSizeMinmm());
            values.put(MINERALBEDROCK_SIZEMAXMM, mineralbedrock.getSizeMaxmm());
            values.put(MINERALBEDROCK_MODE, mineralbedrock.getMode());
            values.put(MINERALBEDROCK_NOTES, mineralbedrock.getNotes());
            rowsAffected = database.update(MINERALBEDROCK_TABLE_NAME, values, CHECKth 5 MINERALBEDROCK_STATION_ID + "=?",
                    new String[] { String.valueOf(mineralbedrock.getID()) });

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
            rowsAffected = database.delete(MINERALBEDROCK_TABLE_NAME, MINERALBEDROCK_STATION_ID + "=?",
                    new String[] { String.valueOf(mineralbedrock.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public MineralBedrockEntity getEntity() {
        return mineralbedrock;
    }

    public void setEntity(String[] mineralbedrock) {
        this.mineralbedrock = new MineralBedrockEntity(mineralBedrock);
    }

    public static String getCreateTableStatement() {
        return MINERALBEDROCK_TABLE_CREATE;
    }
}
