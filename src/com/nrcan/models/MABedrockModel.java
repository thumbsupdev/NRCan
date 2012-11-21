package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.entities.MABedrockEntity;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;

public class MABedrockModel {
	private DatabaseHandler dbHandler;
	private MABedrockEntity mabedrock;

	private static final String MABEDROCK_TABLE_NAME = "mabedrock";
	private static final String MABEDROCK_NRCANID3 = "nrcanId3";
	private static final String MABEDROCK_NRCANID2 = "nrcanId2";
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
			MABEDROCK_NRCANID3 + " INTEGER PRIMARY KEY autoincrement, " +
			MABEDROCK_NRCANID2 + " INTEGER, " +
			MABEDROCK_STATION_ID + " TEXT, " +
			MABEDROCK_MANO + " TEXT, " +
			MABEDROCK_MANID + " TEXT, " +
			MABEDROCK_MA + " TEXT, " +
			MABEDROCK_UNIT + " TEXT, " +
			MABEDROCK_MINERAL + " TEXT, " +
			MABEDROCK_MODE + " TEXT, " +
			MABEDROCK_DISTRIBUTE + " TEXT," +
			MABEDROCK_NOTES + " TEXT" +
			");";

	public MABedrockModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.mabedrock = new MABedrockEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { MABEDROCK_TABLE_NAME, MABEDROCK_NRCANID3, String.valueOf(mabedrock.getNrcanId3()) };
		dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, tmp);

		mabedrock.setEntity(dbHandler.getSplitRow(0));
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(MABEDROCK_NRCANID2, 0);
		values.put(MABEDROCK_STATION_ID, " ");
		values.put(MABEDROCK_MANO, " ");
		values.put(MABEDROCK_MANID, " ");
		values.put(MABEDROCK_MA, " ");
		values.put(MABEDROCK_UNIT, " ");
		values.put(MABEDROCK_MINERAL, " ");
		values.put(MABEDROCK_MODE, " ");
		values.put(MABEDROCK_DISTRIBUTE, " ");	            
		values.put(MABEDROCK_NOTES, " ");

		long rowID = dbHandler.insertRow(MABEDROCK_TABLE_NAME, null, values);

		mabedrock.setNrcanId3((int)rowID);

		updateRow();
	}

	public void updateRow() {
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

		String whereClause = MABEDROCK_NRCANID3 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(mabedrock.getNrcanId3())
		};

		dbHandler.updateRow(MABEDROCK_TABLE_NAME, values, whereClause, whereArgs);
	}

	public MABedrockEntity getEntity() {
		return mabedrock;
	}

	public static String getCreateTableStatement() {
		return MABEDROCK_TABLE_CREATE;
	}
}
