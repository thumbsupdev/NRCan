package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.SoilProSurficialEntity;

public class SoilProSurficialModel {
	private DatabaseHandler dbHandler;
	private SoilProSurficialEntity soilproSurficial;

	private static final String SOILPROSURFICIAL_TABLE_NAME = "soilproSurficial";
	private static final String SOILPROSURFICIAL_NRCANID3 = "nrcanId3";
	private static final String SOILPROSURFICIAL_NRCANID2 = "nrcanId2";
	private static final String SOILPROSURFICIAL_SOILPROID = "soilProId";
	private static final String SOILPROSURFICIAL_STATIONID = "stationId";
	private static final String SOILPROSURFICIAL_OHRZ = "o_hrz";
	private static final String SOILPROSURFICIAL_AHRZ = "a_hrz";
	private static final String SOILPROSURFICIAL_BHRZ = "b_hrz";
	private static final String SOILPROSURFICIAL_CHRZ = "c_hrz";
	private static final String SOILPROSURFICIAL_RHRZ = "r_hrz";
	private static final String SOILPROSURFICIAL_LFH = "l_f_h";
	private static final String SOILPROSURFICIAL_OQUALIFIER = "oQualifier";
	private static final String SOILPROSURFICIAL_AQUALIFIER = "aQualifier";
	private static final String SOILPROSURFICIAL_BQUALIFIER = "bQualifier";
	private static final String SOILPROSURFICIAL_CQUALIFIER = "cQualifier";
	private static final String SOILPROSURFICIAL_RQUALIFIER = "rQualifier";
	private static final String SOILPROSURFICIAL_LFHQUALI = "l_f_HQuali";
	private static final String SOILPROSURFICIAL_TOTTHICK = "totThick";
	private static final String SOILPROSURFICIAL_ATOP = "aTop";
	private static final String SOILPROSURFICIAL_BTOP = "bTop";
	private static final String SOILPROSURFICIAL_CTOP = "cTop";
	private static final String SOILPROSURFICIAL_RTOP = "rTop";
	private static final String SOILPROSURFICIAL_NOTES = "notes";
	private static final String SOILPROSURFICIAL_ID = "id";

	private static final String SOILPROSURFICIAL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + SOILPROSURFICIAL_TABLE_NAME + " (" +
			SOILPROSURFICIAL_NRCANID3 + " INTEGER PRIMARY KEY autoincrement, " +
			SOILPROSURFICIAL_NRCANID2 + " INTEGER, " +
			SOILPROSURFICIAL_SOILPROID  + " TEXT," +
			SOILPROSURFICIAL_STATIONID  + " TEXT," +
			SOILPROSURFICIAL_OHRZ  + " TEXT," +
			SOILPROSURFICIAL_AHRZ  + " TEXT," +
			SOILPROSURFICIAL_BHRZ  + " TEXT," +
			SOILPROSURFICIAL_CHRZ  + " TEXT," +
			SOILPROSURFICIAL_RHRZ + " TEXT," +
			SOILPROSURFICIAL_LFH  + " TEXT," +
			SOILPROSURFICIAL_OQUALIFIER  + " TEXT," +
			SOILPROSURFICIAL_AQUALIFIER  + " TEXT," +
			SOILPROSURFICIAL_BQUALIFIER  + " TEXT," +
			SOILPROSURFICIAL_CQUALIFIER  + " TEXT," +
			SOILPROSURFICIAL_RQUALIFIER  + " TEXT," +
			SOILPROSURFICIAL_LFHQUALI  + " TEXT," +
			SOILPROSURFICIAL_TOTTHICK  + " TEXT," +
			SOILPROSURFICIAL_ATOP  + " TEXT," +
			SOILPROSURFICIAL_BTOP  + " TEXT," +
			SOILPROSURFICIAL_CTOP  + " TEXT," +
			SOILPROSURFICIAL_RTOP  + " TEXT," +
			SOILPROSURFICIAL_NOTES  + " TEXT," +
			SOILPROSURFICIAL_ID  + " TEXT" +
			");";

	public SoilProSurficialModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.soilproSurficial = new SoilProSurficialEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { String.valueOf(soilproSurficial.getNrcanId3()) };
		dbHandler.executeQuery("SELECT * FROM " + SOILPROSURFICIAL_TABLE_NAME + " WHERE " + SOILPROSURFICIAL_NRCANID3 + " = ?", tmp);
		
		soilproSurficial.setEntity(dbHandler.getSplitRow(0));
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(SOILPROSURFICIAL_NRCANID2, 0);
		values.put(SOILPROSURFICIAL_SOILPROID, " ");
		values.put(SOILPROSURFICIAL_STATIONID, " ");
		values.put(SOILPROSURFICIAL_OHRZ, " ");
		values.put(SOILPROSURFICIAL_AHRZ, " ");
		values.put(SOILPROSURFICIAL_BHRZ, " ");
		values.put(SOILPROSURFICIAL_CHRZ, " ");
		values.put(SOILPROSURFICIAL_RHRZ, " ");
		values.put(SOILPROSURFICIAL_LFH, " ");
		values.put(SOILPROSURFICIAL_OQUALIFIER, " ");
		values.put(SOILPROSURFICIAL_AQUALIFIER, " ");
		values.put(SOILPROSURFICIAL_BQUALIFIER, " ");
		values.put(SOILPROSURFICIAL_CQUALIFIER, " ");
		values.put(SOILPROSURFICIAL_RQUALIFIER, " ");
		values.put(SOILPROSURFICIAL_LFHQUALI, " ");
		values.put(SOILPROSURFICIAL_TOTTHICK, " ");
		values.put(SOILPROSURFICIAL_ATOP, " ");
		values.put(SOILPROSURFICIAL_BTOP, " ");
		values.put(SOILPROSURFICIAL_CTOP, " ");
		values.put(SOILPROSURFICIAL_RTOP, " ");
		values.put(SOILPROSURFICIAL_NOTES, " ");
		values.put(SOILPROSURFICIAL_ID, " ");

		long rowID = dbHandler.insertRow(SOILPROSURFICIAL_TABLE_NAME, null, values);

		soilproSurficial.setNrcanId3((int) rowID);

		updateRow();
	}

	public void updateRow() {
		ContentValues values = new ContentValues();
		values.put(SOILPROSURFICIAL_SOILPROID, soilproSurficial.getSoilProId());
		values.put(SOILPROSURFICIAL_STATIONID, soilproSurficial.getStationId());
		values.put(SOILPROSURFICIAL_OHRZ, soilproSurficial.getO_hrz());
		values.put(SOILPROSURFICIAL_AHRZ, soilproSurficial.getA_hrz());
		values.put(SOILPROSURFICIAL_BHRZ, soilproSurficial.getB_hrz());
		values.put(SOILPROSURFICIAL_CHRZ, soilproSurficial.getC_hrz());
		values.put(SOILPROSURFICIAL_RHRZ, soilproSurficial.getR_hrz());
		values.put(SOILPROSURFICIAL_LFH, soilproSurficial.getL_f_h());
		values.put(SOILPROSURFICIAL_OQUALIFIER, soilproSurficial.getoQualifier());
		values.put(SOILPROSURFICIAL_AQUALIFIER, soilproSurficial.getaQualifier());
		values.put(SOILPROSURFICIAL_BQUALIFIER, soilproSurficial.getbQualifier());
		values.put(SOILPROSURFICIAL_CQUALIFIER, soilproSurficial.getcQualifier());
		values.put(SOILPROSURFICIAL_RQUALIFIER, soilproSurficial.getrQualifier());
		values.put(SOILPROSURFICIAL_LFHQUALI, soilproSurficial.getL_f_HQuali());
		values.put(SOILPROSURFICIAL_TOTTHICK, soilproSurficial.getTotThick());
		values.put(SOILPROSURFICIAL_ATOP, soilproSurficial.getaTop());
		values.put(SOILPROSURFICIAL_BTOP, soilproSurficial.getbTop());
		values.put(SOILPROSURFICIAL_CTOP, soilproSurficial.getcTop());
		values.put(SOILPROSURFICIAL_RTOP, soilproSurficial.getrTop());
		values.put(SOILPROSURFICIAL_NOTES, soilproSurficial.getNotes());
		values.put(SOILPROSURFICIAL_ID, soilproSurficial.getId());

		String whereClause = SOILPROSURFICIAL_NRCANID3 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(soilproSurficial.getNrcanId3())
		};

		dbHandler.updateRow(SOILPROSURFICIAL_TABLE_NAME, values, whereClause, whereArgs);
	}

	public SoilProSurficialEntity getEntity() {
		return soilproSurficial;
	}

	public static String getCreateTableStatement() {
		return SOILPROSURFICIAL_TABLE_CREATE;
	}
}
