package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.SampleBedrockEntity;
import android.util.Log;
import java.util.ArrayList;

public class SampleBedrockModel {

	private DatabaseHandler dbHandler;
	private final Context context;
    private SampleBedrockEntity sampleBedrock;

    // Table column keys
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

	private static final String SAMPLEBEDROCK_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS sampleBedrock (" +
				"md_id INTEGER PRIMARY KEY autoincrement, " +
				"md_prj_name TEXT, " +
				"nrcanId4 TEXT, " +
				"nrcanId3 TEXT, " +
				"stationId TEXT, " +
				"earthMatId TEXT, " +
				"sampleNo TEXT, " +
				"sampleType TEXT, " +
				"purpose TEXT, " +
				"format TEXT, " +
				"azimuth TEXT, " +
				"dipplunge TEXT, " +
				"surface TEXT, " +
				"notes TEXT, " +
				");";

	public SampleBedrockModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}

    public SampleBedrockEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { SAMPLEBEDROCK_TABLE_NAME, KEY_SAMPLEBEDROCK_ID, String.valueOf(sampleBedrock.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new SampleBedrockEntity(dbHandler.getSplitRow(0));
    }

    public ArrayList<SampleBedrockEntity> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { SAMPLEBEDROCK_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        ArrayList<SampleBedrockEntity> entities = new ArrayList<SampleBedrockEntity>();

        int length = dbHandler.getList().size();
        
        for(int i = 0; i < length; i++) {
            entities.add(new SampleBedrockEntity(dbHandler.getSplitRow(i)));   
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
            values.put(SAMPLEBEDROCK_NRCANID4, " ");
        	values.put(SAMPLEBEDROCK_NRCANID3, " ");
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

            long rowID = database.insert(SAMPLEBEDROCK_TABLE_NAME, null, values);
            sampleBedrock.setID(String.valueOf(rowID));

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
            values.put(SAMPLEBEDROCK_NRCANID4, sampleBedrock.getNrcanId4());
        	values.put(SAMPLEBEDROCK_NRCANID3, sampleBedrock.getNrcanId3());
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

            rowsAffected = database.update(SAMPLEBEDROCK_TABLE_NAME, values, KEY_SAMPLEBEDROCK_ID + "=?",
                    new String[] { String.valueOf(sampleBedrock.getID()) });

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
            rowsAffected = database.delete(SAMPLEBEDROCK_TABLE_NAME, KEY_SAMPLEBEDROCK_ID + "=?",
                    new String[] { String.valueOf(sampleBedrock.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public SampleBedrockEntity getEntity() {
        return sampleBedrock;
    }

    public void setEntity(String[] sampleBedrock) {
        this.sampleBedrock = new SampleBedrockEntity(sampleBedrock);
    }

    public static String getCreateTableStatement() {
        return SAMPLEBEDROCK_TABLE_CREATE;
    }
}

