package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.StationSurficialEntity;

public class StationSurficialModel {
	private DatabaseHandler dbHandler;
	private StationSurficialEntity stationSurficial;

	private static final String STATIONSURFICIAL_TABLE_NAME = "stationSurficial";
	private static final String STATIONSURFICIAL_NRCANID2 = "nrcanId2";
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

	private static final String STATIONSURFICIAL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + STATIONSURFICIAL_TABLE_NAME + " (" +
			STATIONSURFICIAL_NRCANID2 + " INTEGER PRIMARY KEY autoincrement, " +
			STATIONSURFICIAL_NRCANID1 + " INTEGER," +
			STATIONSURFICIAL_ID + " TEXT," +
			STATIONSURFICIAL_STATIONID + " TEXT," +
			STATIONSURFICIAL_TRAVNO + " TEXT," +
			STATIONSURFICIAL_VISITDATE + " TEXT," +
			STATIONSURFICIAL_VISITTIME + " TEXT," +
			STATIONSURFICIAL_LATITUDE + " TEXT," +
			STATIONSURFICIAL_LONGITUDE + " TEXT," +
			STATIONSURFICIAL_EASTING + " TEXT," +
			STATIONSURFICIAL_NORTHING + " TEXT," +
			STATIONSURFICIAL_DATUMZONE + " TEXT," +
			STATIONSURFICIAL_ELEVATION + " TEXT," +
			STATIONSURFICIAL_ELEVMETHOD + " TEXT," +
			STATIONSURFICIAL_ENTRYTYPE + " TEXT," +
			STATIONSURFICIAL_PDOP + " TEXT," +
			STATIONSURFICIAL_SATSUSED + " TEXT," +
			STATIONSURFICIAL_OBSTYPE + " TEXT," +
			STATIONSURFICIAL_OCQUALITY+ " TEXT," +
			STATIONSURFICIAL_PHYSENV + " TEXT," +
			STATIONSURFICIAL_OCSIZE + " TEXT," +
			STATIONSURFICIAL_NOTES + " TEXT," +
			STATIONSURFICIAL_SLSNOTES + " TEXT," +
			STATIONSURFICIAL_AIRPHOTO + " TEXT," +
			STATIONSURFICIAL_MAPSHEET + " TEXT," +
			STATIONSURFICIAL_LEGENDVAL + " TEXT," +
			STATIONSURFICIAL_PARTNER + " TEXT," +
			STATIONSURFICIAL_METAID + " TEXT" +			
			");";

	public StationSurficialModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.stationSurficial = new StationSurficialEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { String.valueOf(stationSurficial.getNrcanId2()) };
		dbHandler.executeQuery("SELECT * FROM " + STATIONSURFICIAL_TABLE_NAME + " WHERE " + STATIONSURFICIAL_NRCANID2 + " = ?", tmp);
		
		stationSurficial.setEntity(dbHandler.getSplitRow(0));
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(STATIONSURFICIAL_NRCANID1, 0);
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

		long rowID = dbHandler.insertRow(STATIONSURFICIAL_TABLE_NAME, null, values);

		stationSurficial.setNrcanId2((int) rowID);

		updateRow();
	}

	public void updateRow() {
		ContentValues values = new ContentValues();
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

		String whereClause = STATIONSURFICIAL_NRCANID2 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(stationSurficial.getNrcanId2())
		};

		dbHandler.updateRow(STATIONSURFICIAL_TABLE_NAME, values, whereClause, whereArgs);
	}

	public StationSurficialEntity getEntity() {
		return stationSurficial;
	}

	public static String getCreateTableStatement() {
		return STATIONSURFICIAL_TABLE_CREATE;
	}
}
