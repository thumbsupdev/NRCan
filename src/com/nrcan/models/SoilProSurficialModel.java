package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.SoilProSurficialEntity;
import android.util.Log;
import java.util.ArrayList;

public class SoilProSurficialModel {

	private DatabaseHandler dbHandler;
	private final Context context;
    private SoilProSurficialEntity soilproSurficial;

    // Table column keys
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

	private static final String SOILPROSURFICIAL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS soilproSurficial (" +
				"md_id INTEGER PRIMARY KEY autoincrement, " +
				"nrcanId3 TEXT, " +
				"nrcanId2 TEXT, " +
				"soilProId TEXT, " +
				"stationId TEXT, " +
				"o_hrz TEXT, " +
				"a_hrz TEXT, " +
				"b_hrz TEXT, " +
				"c_hrz TEXT, " +
				"r_hrz TEXT, " +
				"l_f_h TEXT, " +
				"oQualifier TEXT, " +
				"aQualifier TEXT, " +
				"bQualifier TEXT, " +
				"cQualifier TEXT, " +
				"rQualifier TEXT, " +
				"l_f_HQuali TEXT, " +
				"totThick TEXT, " +
				"aTop TEXT, " +
				"bTop TEXT, " +
				"cTop TEXT, " +
				"rTop TEXT, " +
				"notes TEXT, " +
				"id TEXT, " +
				");";

	public SoilProSurficialModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}

    public SoilProSurficialEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { SOILPROSURFICIAL_TABLE_NAME, KEY_METADATA_ID, String.valueOf(soilproSurficial.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new SoilProSurficialEntity(dbHandler.getSplitRow(0));
    }

    public ArrayList<SoilProSurficialEntity> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { SOILPROSURFICIAL_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        ArrayList<SoilProSurficialEntity> entities = new ArrayList<SoilProSurficialEntity>();

        int length = dbHandler.getList().size();
        
        for(int i = 0; i < length; i++) {
            entities.add(new SoilProSurficialEntity(dbHandler.getSplitRow(i)));   
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
            values.put(SOILPROSURFICIAL_NRCANID3, " ");
        	values.put(SOILPROSURFICIAL_NRCANID2, " ");
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

            long rowID = database.insert(SOILPROSURFICIAL_TABLE_NAME, null, values);
            soilproSurficial.setID(String.valueOf(rowID));

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
            values.put(SOILPROSURFICIAL_NRCANID3, soilproSurficial.getNrcanId3());
        	values.put(SOILPROSURFICIAL_NRCANID2, soilproSurficial.getNrcanId2());
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

            rowsAffected = database.update(SOILPROSURFICIAL_TABLE_NAME, values, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(soilproSurficial.getID()) });

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
            rowsAffected = database.delete(SOILPROSURFICIAL_TABLE_NAME, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(soilproSurficial.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public SoilProSurficialEntity getEntity() {
        return soilproSurficial;
    }

    public void setEntity(String[] soilproSurficial) {
        this.soilproSurficial = new SoilProSurficialEntity(soilproSurficial);
    }

    public static String getCreateTableStatement() {
        return SOILPROSURFICIAL_TABLE_CREATE;
    }
}

