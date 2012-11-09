package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.StationBedrockEntity;
import android.util.Log;
import java.util.ArrayList;

public class StationBedrockModel {

	private DatabaseHandler dbHandler;
	private final Context context;
    private StationBedrockEntity stationBedrock;

    // Table column keys
	private static final String STATIONBEDROCK_TABLE_NAME = "stationBedrock";
	private static final String STATIONBEDROCK_NRCANID2 = "nrcanId2";
	private static final String STATIONBEDROCK_NRCANID1 = "nrcanId1";
	private static final String STATIONBEDROCK_ID = "id";
	private static final String STATIONBEDROCK_STATIONID = "stationId";
	private static final String STATIONBEDROCK_TRAVNO = "travNo";
	private static final String STATIONBEDROCK_VISITDATE = "visitDate";
	private static final String STATIONBEDROCK_VISITTIME = "visitTime";
	private static final String STATIONBEDROCK_LATITUDE = "latitude";
	private static final String STATIONBEDROCK_LONGITUDE = "longitude";
	private static final String STATIONBEDROCK_EASTING = "easting";
	private static final String STATIONBEDROCK_NORTHING = "northing";
	private static final String STATIONBEDROCK_DATUMZONE = "datumZone";
	private static final String STATIONBEDROCK_ELEVATION = "elevation";
	private static final String STATIONBEDROCK_ELEVMETHOD = "elevMethod";
	private static final String STATIONBEDROCK_ENTRYTYPE = "entryType";
	private static final String STATIONBEDROCK_PDOP = "pDop";
	private static final String STATIONBEDROCK_SATSUSED = "satsUsed";
	private static final String STATIONBEDROCK_OBSTYPE = "obsType";
	private static final String STATIONBEDROCK_PHYSENV = "physEnv";
	private static final String STATIONBEDROCK_OCSIZE = "ocSize";
	private static final String STATIONBEDROCK_NOTES = "notes";
	private static final String STATIONBEDROCK_SLSNOTES = "slsNotes";
	private static final String STATIONBEDROCK_AIRPHOTO = "airPhoto";
	private static final String STATIONBEDROCK_PARTNER = "partner";
	private static final String STATIONBEDROCK_METAID = "metaId";

	private static final String STATIONBEDROCK_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS stationBedrock (" +
				"md_id INTEGER PRIMARY KEY autoincrement, " +
				"nrcanId2 TEXT, " +
				"nrcanId1 TEXT, " +
				"id TEXT, " +
				"stationId TEXT, " +
				"travNo TEXT, " +
				"visitDate TEXT, " +
				"visitTime TEXT, " +
				"latitude TEXT, " +
				"longitude TEXT, " +
				"easting TEXT, " +
				"northing TEXT, " +
				"datumZone TEXT, " +
				"elevation TEXT, " +
				"elevMethod TEXT, " +
				"entryType TEXT, " +
				"pDop TEXT, " +
				"satsUsed TEXT, " +
				"obsType TEXT, " +
				"physEnv TEXT, " +
				"ocSize TEXT, " +
				"notes TEXT, " +
				"slsNotes TEXT, " +
				"airPhoto TEXT, " +
				"partner TEXT, " +
				"metaId TEXT, " +
				");";

	public StationBedrockModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}

    public StationBedrockEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { STATIONBEDROCK_TABLE_NAME, KEY_METADATA_ID, String.valueOf(stationBedrock.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new StationBedrockEntity(dbHandler.getSplitRow(0));
    }

    public ArrayList<StationBedrockEntity> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { STATIONBEDROCK_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        ArrayList<StationBedrockEntity> entities = new ArrayList<StationBedrockEntity>();

        int length = dbHandler.getList().size();
        
        for(int i = 0; i < length; i++) {
            entities.add(new StationBedrockEntity(dbHandler.getSplitRow(i)));   
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
        	values.put(STATIONBEDROCK_NRCANID2, " ");
        	values.put(STATIONBEDROCK_NRCANID1, " ");
        	values.put(STATIONBEDROCK_ID, " ");
        	values.put(STATIONBEDROCK_STATIONID, " ");
        	values.put(STATIONBEDROCK_TRAVNO, " ");
        	values.put(STATIONBEDROCK_VISITDATE, " ");
        	values.put(STATIONBEDROCK_VISITTIME, " ");
        	values.put(STATIONBEDROCK_LATITUDE, " ");
        	values.put(STATIONBEDROCK_LONGITUDE, " ");
        	values.put(STATIONBEDROCK_EASTING, " ");
        	values.put(STATIONBEDROCK_NORTHING, " ");
        	values.put(STATIONBEDROCK_DATUMZONE, " ");
        	values.put(STATIONBEDROCK_ELEVATION, " ");
        	values.put(STATIONBEDROCK_ELEVMETHOD, " ");
        	values.put(STATIONBEDROCK_ENTRYTYPE, " ");
        	values.put(STATIONBEDROCK_PDOP, " ");
        	values.put(STATIONBEDROCK_SATSUSED, " ");
        	values.put(STATIONBEDROCK_OBSTYPE, " ");
        	values.put(STATIONBEDROCK_PHYSENV, " ");
        	values.put(STATIONBEDROCK_OCSIZE, " ");
        	values.put(STATIONBEDROCK_NOTES, " ");
        	values.put(STATIONBEDROCK_SLSNOTES, " ");
        	values.put(STATIONBEDROCK_AIRPHOTO, " ");
        	values.put(STATIONBEDROCK_PARTNER, " ");
        	values.put(STATIONBEDROCK_METAID, " ");

            long rowID = database.insert(STATIONBEDROCK_TABLE_NAME, null, values);
            stationBedrock.setID(String.valueOf(rowID));

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
            values.put(STATIONBEDROCK_NRCANID2, stationBedrock.getNrcanId2());
        	values.put(STATIONBEDROCK_NRCANID1, stationBedrock.getNrcanId1());
        	values.put(STATIONBEDROCK_ID, stationBedrock.getId());
        	values.put(STATIONBEDROCK_STATIONID, stationBedrock.getStationId());
        	values.put(STATIONBEDROCK_TRAVNO, stationBedrock.getTravNo());
        	values.put(STATIONBEDROCK_VISITDATE, stationBedrock.getVisitDate());
        	values.put(STATIONBEDROCK_VISITTIME, stationBedrock.getVisitTime());
        	values.put(STATIONBEDROCK_LATITUDE, stationBedrock.getLatitude());
        	values.put(STATIONBEDROCK_LONGITUDE, stationBedrock.getLongitude());
        	values.put(STATIONBEDROCK_EASTING, stationBedrock.getEasting());
        	values.put(STATIONBEDROCK_NORTHING, stationBedrock.getNorthing());
        	values.put(STATIONBEDROCK_DATUMZONE, stationBedrock.getDatumZone());
        	values.put(STATIONBEDROCK_ELEVATION, stationBedrock.getElevation());
        	values.put(STATIONBEDROCK_ELEVMETHOD, stationBedrock.getElevMethod());
        	values.put(STATIONBEDROCK_ENTRYTYPE, stationBedrock.getEntryType());
        	values.put(STATIONBEDROCK_PDOP, stationBedrock.getpDop());
        	values.put(STATIONBEDROCK_SATSUSED, stationBedrock.getSatsUsed());
        	values.put(STATIONBEDROCK_OBSTYPE, stationBedrock.getObsType());
        	values.put(STATIONBEDROCK_PHYSENV, stationBedrock.getPhysEnv());
        	values.put(STATIONBEDROCK_OCSIZE, stationBedrock.getOcSize());
        	values.put(STATIONBEDROCK_NOTES, stationBedrock.getNotes());
        	values.put(STATIONBEDROCK_SLSNOTES, stationBedrock.getSlsNotes());
        	values.put(STATIONBEDROCK_AIRPHOTO, stationBedrock.getAirPhoto());
        	values.put(STATIONBEDROCK_PARTNER, stationBedrock.getPartner());
        	values.put(STATIONBEDROCK_METAID, stationBedrock.getMetaId());

            rowsAffected = database.update(STATIONBEDROCK_TABLE_NAME, values, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(stationBedrock.getID()) });

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
            rowsAffected = database.delete(STATIONBEDROCK_TABLE_NAME, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(stationBedrock.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public StationBedrockEntity getEntity() {
        return stationBedrock;
    }

    public void setEntity(String[] stationBedrock) {
        this.stationBedrock = new StationBedrockEntity(stationBedrock);
    }

    public static String getCreateTableStatement() {
        return STATIONBEDROCK_TABLE_CREATE;
    }
}

