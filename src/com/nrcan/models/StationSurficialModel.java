package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.StationSurficialEntity;
import android.util.Log;
import java.util.ArrayList;

public class StationSurficialModel {

	private DatabaseHandler dbHandler;
	private final Context context;
    private StationSurficialEntity stationSurficial;

    // Table column keys
	private static final String STATIONSURFICIAL_TABLE_NAME = "stationSurficial";
	private static final String STATIONSURFICIAL_NRCANID2 =  "nrcanId2";
	private static final String STATIONSURFICIAL_NRCANID1 = "nrcanId1";
	private static final String STATIONSURFICIAL_ID = "id";
	private static final String STATIONSURFICIAL_STATIONID = "stationId";
	private static final String STATIONSURFICIAL_TRAVNO = "travNo";
	private static final String STATIONSURFICIAL_VISITDATE = "visitDate";
	private static final String STATIONSURFICIAL_VISITTIME = "visitTime";
	private static final String STATIONSURFICIAL_LATITUDE = "latitude";
	private static final String STATIONSURFICIAL_LONGITUDE = "longitude";
	private static final String STATIONSURFICIAL_EASTING = "easting";
	private static final String STATIONSURFICIAL_NORTHING = "northing";
	private static final String STATIONSURFICIAL_DATUMZONE = "datumZone";
	private static final String STATIONSURFICIAL_ELEVATION = "elevation";
	private static final String STATIONSURFICIAL_ELEVMETHOD = "elevMethod";
	private static final String STATIONSURFICIAL_ENTRYTYPE = "entryType";
	private static final String STATIONSURFICIAL_PDOP = "pDop";
	private static final String STATIONSURFICIAL_SATSUSED = "satsUsed";
	private static final String STATIONSURFICIAL_OBSTYPE = "obsType";
	private static final String STATIONSURFICIAL_OCQUALITY = "ocQuality";
	private static final String STATIONSURFICIAL_PHYSENV = "physEnv";
	private static final String STATIONSURFICIAL_OCSIZE = "ocSize";
	private static final String STATIONSURFICIAL_NOTES = "notes";
	private static final String STATIONSURFICIAL_SLSNOTES = "slsNotes";
	private static final String STATIONSURFICIAL_AIRPHOTO = "airPhoto";
	private static final String STATIONSURFICIAL_MAPSHEET = "mapSheet";
	private static final String STATIONSURFICIAL_LEGENDVAL = "legendVal";
	private static final String STATIONSURFICIAL_PARTNER = "partner";
	private static final String STATIONSURFICIAL_METAID = "metaId";

	private static final String STATIONSURFICIAL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS stationSurficial (" +
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
				"ocQuality TEXT, " +
				"physEnv TEXT, " +
				"ocSize TEXT, " +
				"notes TEXT, " +
				"slsNotes TEXT, " +
				"airPhoto TEXT, " +
				"mapSheet TEXT, " +
				"legendVal TEXT, " +
				"partner TEXT, " +
				"metaId TEXT, " +
				");";

	public StationSurficialModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}

    public StationSurficialEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { STATIONSURFICIAL_TABLE_NAME, KEY_METADATA_ID, String.valueOf(stationSurficial.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new StationSurficialEntity(dbHandler.getSplitRow(0));
    }

    public ArrayList<StationSurficialEntity> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { STATIONSURFICIAL_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        ArrayList<StationSurficialEntity> entities = new ArrayList<StationSurficialEntity>();

        int length = dbHandler.getList().size();
        
        for(int i = 0; i < length; i++) {
            entities.add(new StationSurficialEntity(dbHandler.getSplitRow(i)));   
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
        	values.put(STATIONSURFICIAL_NRCANID2, " ");
        	values.put(STATIONSURFICIAL_NRCANID1, " ");
        	values.put(STATIONSURFICIAL_ID, " ");
        	values.put(STATIONSURFICIAL_STATIONID, " ");
        	values.put(STATIONSURFICIAL_TRAVNO, " ");
        	values.put(STATIONSURFICIAL_VISITDATE, " ");
        	values.put(STATIONSURFICIAL_VISITTIME, " ");
        	values.put(STATIONSURFICIAL_LATITUDE, " ");
        	values.put(STATIONSURFICIAL_LONGITUDE, " ");
        	values.put(STATIONSURFICIAL_EASTING, " ");
        	values.put(STATIONSURFICIAL_NORTHING, " ");
        	values.put(STATIONSURFICIAL_DATUMZONE, " ");
        	values.put(STATIONSURFICIAL_ELEVATION, " ");
        	values.put(STATIONSURFICIAL_ELEVMETHOD, " ");
        	values.put(STATIONSURFICIAL_ENTRYTYPE, " ");
        	values.put(STATIONSURFICIAL_PDOP, " ");
        	values.put(STATIONSURFICIAL_SATSUSED, " ");
        	values.put(STATIONSURFICIAL_OBSTYPE, " ");
        	values.put(STATIONSURFICIAL_OCQUALITY, " ");
        	values.put(STATIONSURFICIAL_PHYSENV, " ");
        	values.put(STATIONSURFICIAL_OCSIZE, " ");
        	values.put(STATIONSURFICIAL_NOTES, " ");
        	values.put(STATIONSURFICIAL_SLSNOTES, " ");
        	values.put(STATIONSURFICIAL_AIRPHOTO, " ");
        	values.put(STATIONSURFICIAL_MAPSHEET, " ");
        	values.put(STATIONSURFICIAL_LEGENDVAL, " ");
        	values.put(STATIONSURFICIAL_PARTNER, " ");
        	values.put(STATIONSURFICIAL_METAID, " ");

            long rowID = database.insert(STATIONSURFICIAL_TABLE_NAME, null, values);
            stationSurficial.setID(String.valueOf(rowID));

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
        	values.put(STATIONSURFICIAL_NRCANID2, stationSurficial.getNrcanId2());
        	values.put(STATIONSURFICIAL_NRCANID1, stationSurficial.getNrcanId1());
        	values.put(STATIONSURFICIAL_ID, stationSurficial.getId());
        	values.put(STATIONSURFICIAL_STATIONID, stationSurficial.getStationId());
        	values.put(STATIONSURFICIAL_TRAVNO, stationSurficial.getTravNo());
        	values.put(STATIONSURFICIAL_VISITDATE, stationSurficial.getVisitDate());
        	values.put(STATIONSURFICIAL_VISITTIME, stationSurficial.getVisitTime());
        	values.put(STATIONSURFICIAL_LATITUDE, stationSurficial.getLatitude());
        	values.put(STATIONSURFICIAL_LONGITUDE, stationSurficial.getLongitude());
        	values.put(STATIONSURFICIAL_EASTING, stationSurficial.getEasting());
        	values.put(STATIONSURFICIAL_NORTHING, stationSurficial.getNorthing());
        	values.put(STATIONSURFICIAL_DATUMZONE, stationSurficial.getDatumZone());
        	values.put(STATIONSURFICIAL_ELEVATION, stationSurficial.getElevation());
        	values.put(STATIONSURFICIAL_ELEVMETHOD, stationSurficial.getElevMethod());
        	values.put(STATIONSURFICIAL_ENTRYTYPE, stationSurficial.getEntryType());
        	values.put(STATIONSURFICIAL_PDOP, stationSurficial.getpDop());
        	values.put(STATIONSURFICIAL_SATSUSED, stationSurficial.getSatsUsed());
        	values.put(STATIONSURFICIAL_OBSTYPE, stationSurficial.getObsType());
        	values.put(STATIONSURFICIAL_OCQUALITY, stationSurficial.getOcQuality());
        	values.put(STATIONSURFICIAL_PHYSENV, stationSurficial.getPhysEnv());
        	values.put(STATIONSURFICIAL_OCSIZE, stationSurficial.getOcSize());
        	values.put(STATIONSURFICIAL_NOTES, stationSurficial.getNotes());
        	values.put(STATIONSURFICIAL_SLSNOTES, stationSurficial.getSlsNotes());
        	values.put(STATIONSURFICIAL_AIRPHOTO, stationSurficial.getAirPhoto());
        	values.put(STATIONSURFICIAL_MAPSHEET, stationSurficial.getMapSheet());
        	values.put(STATIONSURFICIAL_LEGENDVAL, stationSurficial.getLegendVal());
        	values.put(STATIONSURFICIAL_PARTNER, stationSurficial.getPartner());
        	values.put(STATIONSURFICIAL_METAID, stationSurficial.getMetaId());
            rowsAffected = database.update(STATIONSURFICIAL_TABLE_NAME, values, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(stationSurficial.getID()) });

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
            rowsAffected = database.delete(STATIONSURFICIAL_TABLE_NAME, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(stationSurficial.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public StationSurficialEntity getEntity() {
        return stationSurficial;
    }

    public void setEntity(String[] stationSurficial) {
        this.stationSurficial = new StationSurficialEntity(stationSurficial);
    }

    public static String getCreateTableStatement() {
        return STATIONSURFICIAL_TABLE_CREATE;
    }
}

