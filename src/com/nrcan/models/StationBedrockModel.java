package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.entities.StationBedrockEntity;

public class StationBedrockModel {
	private DatabaseHandler dbHandler;
	private StationBedrockEntity stationBedrock;

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
	private static final String STATIONBEDROCK_OCQUALITY = "ocQuality";
	private static final String STATIONBEDROCK_PHYSENV = "physEnv";
	private static final String STATIONBEDROCK_OCSIZE = "ocSize";
	private static final String STATIONBEDROCK_NOTES = "notes";
	private static final String STATIONBEDROCK_SLSNOTES = "slsNotes";
	private static final String STATIONBEDROCK_AIRPHOTO = "airPhoto";
	private static final String STATIONBEDROCK_PARTNER = "partner";
	private static final String STATIONBEDROCK_METAID = "metaId";

	private static final String STATIONBEDROCK_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + STATIONBEDROCK_TABLE_NAME + " (" +
			STATIONBEDROCK_NRCANID2 + " INTEGER PRIMARY KEY autoincrement, " +
			STATIONBEDROCK_NRCANID1 + " INTEGER," +
			STATIONBEDROCK_ID + " TEXT," +
			STATIONBEDROCK_STATIONID + " TEXT," +
			STATIONBEDROCK_TRAVNO + " TEXT," +
			STATIONBEDROCK_VISITDATE + " TEXT," +
			STATIONBEDROCK_VISITTIME + " TEXT," +
			STATIONBEDROCK_LATITUDE + " TEXT," +
			STATIONBEDROCK_LONGITUDE + " TEXT," +
			STATIONBEDROCK_EASTING + " TEXT," +
			STATIONBEDROCK_NORTHING + " TEXT," +
			STATIONBEDROCK_DATUMZONE + " TEXT," +
			STATIONBEDROCK_ELEVATION + " TEXT," +
			STATIONBEDROCK_ELEVMETHOD + " TEXT," +
			STATIONBEDROCK_ENTRYTYPE + " TEXT," +
			STATIONBEDROCK_PDOP + " TEXT," +
			STATIONBEDROCK_SATSUSED + " TEXT," +
			STATIONBEDROCK_OBSTYPE + " TEXT," +
			STATIONBEDROCK_OCQUALITY + " TEXT," +
			STATIONBEDROCK_PHYSENV + " TEXT," +
			STATIONBEDROCK_OCSIZE + " TEXT," +
			STATIONBEDROCK_NOTES + " TEXT," +
			STATIONBEDROCK_SLSNOTES + " TEXT," +
			STATIONBEDROCK_AIRPHOTO + " TEXT," +
			STATIONBEDROCK_PARTNER + " TEXT," +
			STATIONBEDROCK_METAID + " TEXT" +
			");";

	public StationBedrockModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.stationBedrock = new StationBedrockEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { String.valueOf(stationBedrock.getNrcanId2()) };
		dbHandler.executeQuery("SELECT * FROM " + STATIONBEDROCK_TABLE_NAME + " WHERE " + STATIONBEDROCK_NRCANID2 + " = ?", tmp);
		
		stationBedrock.setEntity(dbHandler.getList());
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(STATIONBEDROCK_NRCANID1, 0);
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
		values.put(STATIONBEDROCK_OCQUALITY, " ");
		values.put(STATIONBEDROCK_PHYSENV, " ");
		values.put(STATIONBEDROCK_OCSIZE, " ");
		values.put(STATIONBEDROCK_NOTES, " ");
		values.put(STATIONBEDROCK_SLSNOTES, " ");
		values.put(STATIONBEDROCK_AIRPHOTO, " ");
		values.put(STATIONBEDROCK_PARTNER, " ");
		values.put(STATIONBEDROCK_METAID, " ");

		long rowID = dbHandler.insertRow(STATIONBEDROCK_TABLE_NAME, null, values);

		stationBedrock.setNrcanId2((int) rowID);

		updateRow();
	}

	public void updateRow() {
		ContentValues values = new ContentValues();
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
		values.put(STATIONBEDROCK_OCQUALITY, stationBedrock.getOCQuality());
		values.put(STATIONBEDROCK_PHYSENV, stationBedrock.getPhysEnv());
		values.put(STATIONBEDROCK_OCSIZE, stationBedrock.getOcSize());
		values.put(STATIONBEDROCK_NOTES, stationBedrock.getNotes());
		values.put(STATIONBEDROCK_SLSNOTES, stationBedrock.getSlsNotes());
		values.put(STATIONBEDROCK_AIRPHOTO, stationBedrock.getAirPhoto());
		values.put(STATIONBEDROCK_PARTNER, stationBedrock.getPartner());
		values.put(STATIONBEDROCK_METAID, stationBedrock.getMetaId());

		String whereClause = STATIONBEDROCK_NRCANID2 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(stationBedrock.getNrcanId2())
		};

		dbHandler.updateRow(STATIONBEDROCK_TABLE_NAME, values, whereClause, whereArgs);
	}

	public StationBedrockEntity getEntity() {
		return stationBedrock;
	}

	public static String getCreateTableStatement() {
		return STATIONBEDROCK_TABLE_CREATE;
	}
}
