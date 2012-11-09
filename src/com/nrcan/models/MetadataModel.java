package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.entities.MetadataEntity;
import com.nrcan.values.PreparedStatements;

public class MetadataModel {
	private DatabaseHandler dbHandler;
	private MetadataEntity metadata;

	private static final String METADATA_TABLE_NAME = "metadata";
	private static final String METADATA_NRCANID1 = "nrcanId1";
	private static final String METADATA_PROJECT_NAME = "prjct_name";
	private static final String METADATA_PROJECT_CODE = "prjct_code";
	private static final String METADATA_PROJECT_LEAD = "prjct_lead";
	private static final String METADATA_PROJECT_TYPE = "prjct_type";
	private static final String METADATA_GEOLCODE = "geolcode";
	private static final String METADATA_GEOLOGIST = "geologist";
	private static final String METADATA_MAPPATH = "mappath";
	private static final String METADATA_PRJ_NAME = "prj_name";
	private static final String METADATA_PRJ_TYPE = "prj_type";
	private static final String METADATA_PRJ_DATUM = "prj_datum";
	private static final String METADATA_DIGCAMERA = "digcamera";
	private static final String METADATA_STNSTARTNO = "stnstartno";
	private static final String METADATA_METAID = "metaid";

	private static final String PROJECT_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + METADATA_TABLE_NAME + " (" +
			METADATA_NRCANID1 + " INTEGER PRIMARY KEY autoincrement," +
			METADATA_PROJECT_NAME + " TEXT," +
			METADATA_PROJECT_CODE + " TEXT," +
			METADATA_PROJECT_LEAD + " TEXT," +
			METADATA_PROJECT_TYPE + " TEXT," +
			METADATA_GEOLCODE + " TEXT," +
			METADATA_GEOLOGIST + " TEXT," +
			METADATA_MAPPATH + " TEXT," +
			METADATA_PRJ_NAME + " TEXT," +
			METADATA_PRJ_TYPE + " TEXT," +
			METADATA_PRJ_DATUM + " TEXT," +
			METADATA_DIGCAMERA + " TEXT," +
			METADATA_STNSTARTNO + " TEXT," +
			METADATA_METAID + " TEXT" +
			");";

	public MetadataModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.metadata = new MetadataEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { METADATA_TABLE_NAME, METADATA_NRCANID1, String.valueOf(metadata.getNrcanId1()) };
		dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, tmp);

		metadata.setEntity(dbHandler.getSplitRow(0));
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(METADATA_PROJECT_NAME, " ");
		values.put(METADATA_PROJECT_CODE, " ");
		values.put(METADATA_PROJECT_LEAD, " ");
		values.put(METADATA_PROJECT_TYPE, " ");
		values.put(METADATA_GEOLCODE, " ");
		values.put(METADATA_GEOLOGIST, " ");
		values.put(METADATA_MAPPATH, " ");
		values.put(METADATA_PRJ_NAME, " ");
		values.put(METADATA_PRJ_TYPE, " ");
		values.put(METADATA_PRJ_DATUM, " ");
		values.put(METADATA_DIGCAMERA, " ");
		values.put(METADATA_METAID, " ");
		values.put(METADATA_STNSTARTNO, " ");

		long rowID = dbHandler.insertRow(METADATA_TABLE_NAME, null, values);

		metadata.setNrcanId1((int)rowID);

		updateRow();
	}

	public void updateRow() {
		ContentValues values = new ContentValues();
		values.put(METADATA_PROJECT_NAME, metadata.getPrjct_name());
		values.put(METADATA_PROJECT_CODE, metadata.getPrjct_code());
		values.put(METADATA_PROJECT_LEAD, metadata.getPrjct_lead());
		values.put(METADATA_PROJECT_TYPE, metadata.getPrjct_type());
		values.put(METADATA_GEOLCODE, metadata.getGeolcode());
		values.put(METADATA_GEOLOGIST, metadata.getGeologist());
		values.put(METADATA_MAPPATH, metadata.getMappath());
		values.put(METADATA_PRJ_NAME, metadata.getPrj_name());
		values.put(METADATA_PRJ_TYPE, metadata.getPrj_type());
		values.put(METADATA_PRJ_DATUM, metadata.getPrj_datum());
		values.put(METADATA_DIGCAMERA, metadata.getDigcamera());
		values.put(METADATA_METAID, metadata.getMetaid());
		values.put(METADATA_STNSTARTNO, metadata.getStnstartno());

		String whereClause = METADATA_NRCANID1 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(metadata.getNrcanId1())
		};

		dbHandler.updateRow(METADATA_TABLE_NAME, values, whereClause, whereArgs);
	}

	public MetadataEntity getEntity() {
		return metadata;
	}

	public static String getCreateTableStatement() {
		return PROJECT_TABLE_CREATE;
	}
}

