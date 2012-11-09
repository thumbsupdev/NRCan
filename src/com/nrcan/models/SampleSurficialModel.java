package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.SampleSurficialEntity;
import android.util.Log;
import java.util.ArrayList;

public class SampleSurficialModel {

	private DatabaseHandler dbHandler;
	private final Context context;
    private SampleSurficialEntity sampleSurficial;

    // Table column keys
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

	private static final String SAMPLESURFICIAL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS sampleSurficial (" +
				"md_id INTEGER PRIMARY KEY autoincrement, " +
				"md_prj_name TEXT, " +
				"nrcanId4 TEXT, " +
				"nrcanId3 TEXT, " +
				"stationId TEXT, " +
				"earthMatId TEXT, " +
				"sampleId TEXT, " +
				"sampleNo TEXT, " +
				"sampleType TEXT, " +
				"purpose TEXT, " +
				"format TEXT, " +
				"sampleDep TEXT, " +
				"azimuth TEXT, " +
				"dipplunge TEXT, " +
				"surface TEXT, " +
				"horizon TEXT, " +
				"state TEXT, " +
				"duplicate TEXT, " +
				"notes TEXT, " +
				");";

	public SampleSurficialModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}

    public SampleSurficialEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { SAMPLESURFICIAL_TABLE_NAME, KEY_SAMPLESURFICIAL_ID, String.valueOf(sampleSurficial.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new SampleSurficialEntity(dbHandler.getSplitRow(0));
    }

    public ArrayList<SampleSurficialEntity> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { SAMPLESURFICIAL_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        ArrayList<SampleSurficialEntity> entities = new ArrayList<SampleSurficialEntity>();

        int length = dbHandler.getList().size();
        
        for(int i = 0; i < length; i++) {
            entities.add(new SampleSurficialEntity(dbHandler.getSplitRow(i)));   
        }
        
        return entities;
    }

    // Returns: the row ID of the newly inserted row or -1 on error.
    // Process (only run when save is pressed):
        // 1. Insert blank row
        // 2. read the new blank row to get id
        // 3. set the id in the entity
    public long insertRow() {

        int rowsAffected = 0;
        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            ContentValues values = new ContentValues();
        	values.put(SAMPLESURFICIAL_NRCANID4, " ");
        	values.put(SAMPLESURFICIAL_NRCANID3, " ");
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

            long rowID = database.insert(SAMPLESURFICIAL_TABLE_NAME, null, values);
            sampleSurficial.setID(String.valueOf(rowID));

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
            values.put(SAMPLESURFICIAL_NRCANID4, sampleSurficial.getNrcanId4());
        	values.put(SAMPLESURFICIAL_NRCANID3, sampleSurficial.getNrcanId3());
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

            rowsAffected = database.update(SAMPLESURFICIAL_TABLE_NAME, values, KEY_SAMPLESURFICIAL_ID + "=?",
                    new String[] { String.valueOf(sampleSurficial.getID()) });

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
            rowsAffected = database.delete(SAMPLESURFICIAL_TABLE_NAME, KEY_SAMPLESURFICIAL_ID + "=?",
                    new String[] { String.valueOf(sampleSurficial.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public SampleSurficialEntity getEntity() {
        return sampleSurficial;
    }

    public void setEntity(String[] sampleSurficial) {
        this.sampleSurficial = new SampleSurficialEntity(sampleSurficial);
    }

    public static String getCreateTableStatement() {
        return SAMPLESURFICIAL_TABLE_CREATE;
    }
}

