package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.entities.SampleSurficialEntity;

public class SampleSurficialModel {
	private DatabaseHandler dbHandler;
	private SampleSurficialEntity sampleSurficial;

	private static final String SAMPLESURFICIAL_TABLE_NAME = "sampleSurficial";
	private static final String SAMPLESURFICIAL_NRCANID4 = "nrcanId4";
	private static final String SAMPLESURFICIAL_NRCANID3 = "nrcanId3";
	private static final String SAMPLESURFICIAL_STATIONID = "stationId";
	private static final String SAMPLESURFICIAL_EARTHMATID = "earthMatId";
	private static final String SAMPLESURFICIAL_SAMPLEID = "sampleId";
	private static final String SAMPLESURFICIAL_SAMPLENO = "sampleNo";
	private static final String SAMPLESURFICIAL_SAMPLETYPE = "sampleType";
	private static final String SAMPLESURFICIAL_PURPOSE = "purpose";
	private static final String SAMPLESURFICIAL_FORMAT = "format";
	private static final String SAMPLESURFICIAL_SAMPLEDEP = "sampleDep";
	private static final String SAMPLESURFICIAL_AZIMUTH = "azimuth";
	private static final String SAMPLESURFICIAL_DIPPLUNGE = "dipplunge";
	private static final String SAMPLESURFICIAL_SURFACE = "surface";
	private static final String SAMPLESURFICIAL_HORIZON = "horizon";
	private static final String SAMPLESURFICIAL_STATE = "state";
	private static final String SAMPLESURFICIAL_DUPLICATE = "duplicate";
	private static final String SAMPLESURFICIAL_NOTES = "notes";

	private static final String SAMPLESURFICIAL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + SAMPLESURFICIAL_TABLE_NAME + " (" +
			SAMPLESURFICIAL_NRCANID4 + " INTEGER PRIMARY KEY autoincrement," +
			SAMPLESURFICIAL_NRCANID3 + " INTEGER," +
			SAMPLESURFICIAL_STATIONID + " TEXT," +
			SAMPLESURFICIAL_EARTHMATID + " TEXT," +
			SAMPLESURFICIAL_SAMPLEID + " TEXT," +
			SAMPLESURFICIAL_SAMPLENO + " TEXT," +
			SAMPLESURFICIAL_SAMPLETYPE + " TEXT," +
			SAMPLESURFICIAL_PURPOSE + " TEXT," +
			SAMPLESURFICIAL_FORMAT + " TEXT," +
			SAMPLESURFICIAL_SAMPLEDEP + " TEXT," +
			SAMPLESURFICIAL_AZIMUTH + " TEXT," +
			SAMPLESURFICIAL_DIPPLUNGE + " TEXT," +
			SAMPLESURFICIAL_SURFACE + " TEXT," +
			SAMPLESURFICIAL_HORIZON + " TEXT," +
			SAMPLESURFICIAL_STATE + " TEXT," +
			SAMPLESURFICIAL_DUPLICATE + " TEXT," +
			SAMPLESURFICIAL_NOTES + " TEXT" +			
			");";

	public SampleSurficialModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.sampleSurficial = new SampleSurficialEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { String.valueOf(sampleSurficial.getNrcanId4()) };
		dbHandler.executeQuery("SELECT * FROM " + SAMPLESURFICIAL_TABLE_NAME + " WHERE " + SAMPLESURFICIAL_NRCANID4 + " = ?", tmp);
		
		sampleSurficial.setEntity(dbHandler.getSplitRow(0));
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(SAMPLESURFICIAL_NRCANID3, 0);
		values.put(SAMPLESURFICIAL_STATIONID, " ");
		values.put(SAMPLESURFICIAL_EARTHMATID, " ");
		values.put(SAMPLESURFICIAL_SAMPLEID, " ");
		values.put(SAMPLESURFICIAL_SAMPLENO, " ");
		values.put(SAMPLESURFICIAL_SAMPLETYPE, " ");
		values.put(SAMPLESURFICIAL_PURPOSE, " ");
		values.put(SAMPLESURFICIAL_FORMAT, " ");
		values.put(SAMPLESURFICIAL_SAMPLEDEP, " ");
		values.put(SAMPLESURFICIAL_AZIMUTH, " ");
		values.put(SAMPLESURFICIAL_DIPPLUNGE, " ");
		values.put(SAMPLESURFICIAL_SURFACE, " ");
		values.put(SAMPLESURFICIAL_HORIZON, " ");
		values.put(SAMPLESURFICIAL_STATE, " ");
		values.put(SAMPLESURFICIAL_DUPLICATE, " ");
		values.put(SAMPLESURFICIAL_NOTES, " ");

		long rowID = dbHandler.insertRow(SAMPLESURFICIAL_TABLE_NAME, null, values);

		sampleSurficial.setNrcanId4((int) rowID);

		updateRow();
	}

	public void updateRow() {
		ContentValues values = new ContentValues();
		values.put(SAMPLESURFICIAL_STATIONID, sampleSurficial.getStationId());
		values.put(SAMPLESURFICIAL_EARTHMATID, sampleSurficial.getEarthMatId());
		values.put(SAMPLESURFICIAL_SAMPLEID, sampleSurficial.getSampleId());
		values.put(SAMPLESURFICIAL_SAMPLENO, sampleSurficial.getSampleNo());
		values.put(SAMPLESURFICIAL_SAMPLETYPE, sampleSurficial.getSampleType());
		values.put(SAMPLESURFICIAL_PURPOSE, sampleSurficial.getPurpose());
		values.put(SAMPLESURFICIAL_FORMAT, sampleSurficial.getFormat());
		values.put(SAMPLESURFICIAL_SAMPLEDEP, sampleSurficial.getSampleDep());
		values.put(SAMPLESURFICIAL_AZIMUTH, sampleSurficial.getAzimuth());
		values.put(SAMPLESURFICIAL_DIPPLUNGE, sampleSurficial.getDipplunge());
		values.put(SAMPLESURFICIAL_SURFACE, sampleSurficial.getSurface());
		values.put(SAMPLESURFICIAL_HORIZON, sampleSurficial.getHorizon());
		values.put(SAMPLESURFICIAL_STATE, sampleSurficial.getState());
		values.put(SAMPLESURFICIAL_DUPLICATE, sampleSurficial.getDuplicate());
		values.put(SAMPLESURFICIAL_NOTES, sampleSurficial.getNotes());

		String whereClause = SAMPLESURFICIAL_NRCANID4 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(sampleSurficial.getNrcanId4())
		};

		dbHandler.updateRow(SAMPLESURFICIAL_TABLE_NAME, values, whereClause, whereArgs);
	}

	public SampleSurficialEntity getEntity() {
		return sampleSurficial;
	}

	public static String getCreateTableStatement() {
		return SAMPLESURFICIAL_TABLE_CREATE;
	}
}

