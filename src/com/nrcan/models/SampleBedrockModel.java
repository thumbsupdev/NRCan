package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.SampleBedrockEntity;

public class SampleBedrockModel {
	private DatabaseHandler dbHandler;
	private SampleBedrockEntity sampleBedrock;

	private static final String SAMPLEBEDROCK_TABLE_NAME = "sampleBedrock";
	private static final String SAMPLEBEDROCK_NRCANID4 = "nrcanId4";
	private static final String SAMPLEBEDROCK_NRCANID3 = "nrcanId3";
	private static final String SAMPLEBEDROCK_STATIONID = "stationId";
	private static final String SAMPLEBEDROCK_EARTHMATID = "earthMatId";
	private static final String SAMPLEBEDROCK_SAMPLENO = "sampleNo";
	private static final String SAMPLEBEDROCK_SAMPLETYPE = "sampleType";
	private static final String SAMPLEBEDROCK_PURPOSE = "purpose";
	private static final String SAMPLEBEDROCK_FORMAT = "format";
	private static final String SAMPLEBEDROCK_AZIMUTH = "azimuth";
	private static final String SAMPLEBEDROCK_DIPPLUNGE = "dipplunge";
	private static final String SAMPLEBEDROCK_SURFACE = "surface";
	private static final String SAMPLEBEDROCK_NOTES = "notes";

	private static final String SAMPLEBEDROCK_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + SAMPLEBEDROCK_TABLE_NAME + " (" +
			SAMPLEBEDROCK_NRCANID4 + " INTEGER PRIMARY KEY autoincrement, " +
			SAMPLEBEDROCK_NRCANID3 + " INTEGER, " +
			SAMPLEBEDROCK_STATIONID + " TEXT," +
			SAMPLEBEDROCK_EARTHMATID + " TEXT," +
			SAMPLEBEDROCK_SAMPLENO + " TEXT,"+
			SAMPLEBEDROCK_SAMPLETYPE + " TEXT," +
			SAMPLEBEDROCK_PURPOSE  + " TEXT," +
			SAMPLEBEDROCK_FORMAT  + " TEXT," +
			SAMPLEBEDROCK_AZIMUTH  + " TEXT," +
			SAMPLEBEDROCK_DIPPLUNGE  + " TEXT," +
			SAMPLEBEDROCK_SURFACE  + " TEXT," +
			SAMPLEBEDROCK_NOTES  + " TEXT" +			
			");";

	public SampleBedrockModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.sampleBedrock = new SampleBedrockEntity();
	}

	public void readRow() {
		//String[] tmp = new String[] { SAMPLEBEDROCK_TABLE_NAME, SAMPLEBEDROCK_NRCANID4, String.valueOf(sampleBedrock.getNrcanId4()) };
		//dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, tmp);
		
		String[] tmp = new String[] { SAMPLEBEDROCK_NRCANID4, String.valueOf(sampleBedrock.getNrcanId4()) };
		dbHandler.executeQuery("SELECT * FROM " + SAMPLEBEDROCK_TABLE_NAME + " WHERE ", tmp);

		sampleBedrock.setEntity(dbHandler.getSplitRow(0));
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(SAMPLEBEDROCK_NRCANID3, 0);
		values.put(SAMPLEBEDROCK_STATIONID, " ");
		values.put(SAMPLEBEDROCK_EARTHMATID, " ");
		values.put(SAMPLEBEDROCK_SAMPLENO, " ");
		values.put(SAMPLEBEDROCK_SAMPLETYPE, " ");
		values.put(SAMPLEBEDROCK_PURPOSE, " ");
		values.put(SAMPLEBEDROCK_FORMAT, " ");
		values.put(SAMPLEBEDROCK_AZIMUTH, " ");
		values.put(SAMPLEBEDROCK_DIPPLUNGE, " ");
		values.put(SAMPLEBEDROCK_SURFACE, " ");
		values.put(SAMPLEBEDROCK_NOTES, " ");

		long rowID = dbHandler.insertRow(SAMPLEBEDROCK_TABLE_NAME, null, values);

		sampleBedrock.setNrcanId4((int)rowID);

		updateRow();
	}

	public void updateRow() {
		ContentValues values = new ContentValues();
		values.put(SAMPLEBEDROCK_STATIONID, sampleBedrock.getStationId());
		values.put(SAMPLEBEDROCK_EARTHMATID, sampleBedrock.getEarthMatId());
		values.put(SAMPLEBEDROCK_SAMPLENO, sampleBedrock.getSampleNo());
		values.put(SAMPLEBEDROCK_SAMPLETYPE, sampleBedrock.getSampleType());
		values.put(SAMPLEBEDROCK_PURPOSE, sampleBedrock.getPurpose());
		values.put(SAMPLEBEDROCK_FORMAT, sampleBedrock.getFormat());
		values.put(SAMPLEBEDROCK_AZIMUTH, sampleBedrock.getAzimuth());
		values.put(SAMPLEBEDROCK_DIPPLUNGE, sampleBedrock.getDipplunge());
		values.put(SAMPLEBEDROCK_SURFACE, sampleBedrock.getSurface());
		values.put(SAMPLEBEDROCK_NOTES, sampleBedrock.getNotes());

		String whereClause = SAMPLEBEDROCK_NRCANID4 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(sampleBedrock.getNrcanId4())
		};

		dbHandler.updateRow(SAMPLEBEDROCK_TABLE_NAME, values, whereClause, whereArgs);
	}

	public SampleBedrockEntity getEntity() {
		return sampleBedrock;
	}

	public static String getCreateTableStatement() {
		return SAMPLEBEDROCK_TABLE_CREATE;
	}
}

