package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.entities.MineralBedrockEntity;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;

public class MineralBedrockModel {
	private DatabaseHandler dbHandler;
	private MineralBedrockEntity mineralbedrock;

	private static final String MINERALBEDROCK_TABLE_NAME = "mineralbedrock";
	private static final String MINERALBEDROCK_NRCANID4 = "nrcanId4";
	private static final String MINERALBEDROCK_NRCANID3 = "nrcanId3";
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
			MINERALBEDROCK_NRCANID4 + " INTEGER PRIMARY KEY autoincrement, " +
			MINERALBEDROCK_NRCANID3 + " INTEGER, " +
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
			MINERALBEDROCK_MODE + " TEXT," +
			MINERALBEDROCK_NOTES + " TEXT" +
			");";

	public MineralBedrockModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.mineralbedrock = new MineralBedrockEntity();
	}
	
	public void readRow() {
		String[] tmp = new String[] { MINERALBEDROCK_TABLE_NAME, MINERALBEDROCK_NRCANID4, String.valueOf(mineralbedrock.getNrcanId4()) };
		dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, tmp);

		mineralbedrock.setEntity(dbHandler.getSplitRow(0));
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(MINERALBEDROCK_NRCANID3, 0);
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

		long rowID = dbHandler.insertRow(MINERALBEDROCK_TABLE_NAME, null, values);

		mineralbedrock.setNrcanId4((int)rowID);

		updateRow();
	}

	public void updateRow() {
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

		String whereClause = MINERALBEDROCK_NRCANID4 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(mineralbedrock.getNrcanId4())
		};

		dbHandler.updateRow(MINERALBEDROCK_TABLE_NAME, values, whereClause, whereArgs);
	}

	public MineralBedrockEntity getEntity() {
		return mineralbedrock;
	}


	public static String getCreateTableStatement() {
		return MINERALBEDROCK_TABLE_CREATE;
	}
}
