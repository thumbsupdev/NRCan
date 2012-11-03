package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.entities.MetadataEntity;
import android.util.Log;
import java.util.ArrayList;

public class MetadataModel {

	private DatabaseHandler dbHandler;
	private final Context context;
    private MetadataEntity metadata;

    // Table column keys
	private static final String METADATA_TABLE_NAME = "metadata";
	private static final String KEY_PROJECT_NAME = "md_prjct_name";
	private static final String KEY_PROJECT_CODE = "md_prjct_code";
	private static final String KEY_PROJECT_LEAD = "md_prjct_lead";
	private static final String KEY_PROJECT_TYPE = "md_prjct_type";
	private static final String KEY_METADATA_GEOLCODE = "md_geolcode";
	private static final String KEY_METADATA_GEOLOGIST = "md_geologist";
	private static final String KEY_METADATA_MAPPATH = "md_mappath";
//	private static final String 
	private static final String KEY_METADATA_DATUM = "md_datum";
	private static final String KEY_METADATA_DIGCAMERA = "md_digcamera";
	private static final String KEY_METADATA_ID = "md_id";
	private static final short KEY_METADATA_STNSTARTNO = 0;

	private static final String PROJECT_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS metadata (" +
				"md_id INTEGER PRIMARY KEY autoincrement, " +
			
				"md_prj_name TEXT, " +
				"md_prj_code TEXT, " +
				"md_prj_lead TEXT, " +
				"md_prj_type TEXT, " +
				"md_geologist TEXT, " +
				"md_geolcode TEXT, " +
				"md_digcamera TEXT, " +
				"md_name TEXT," +
				"md_type TEXT," +
				"md_datum TEXT," +
				"md_mappath TEXT," +
				"md_stnstartno SHORT" +
				");";

	public MetadataModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}

    public Metadata readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { METADATA_TABLE_NAME, KEY_METADATA_ID, String.valueOf(metadata.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new Metadata(dbHandler.getSplitRow(0));
    }

/*    public ArrayList<Metadata> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { METADATA_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return dbHandler.getList();
    }*/

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
            values.put(KEY_PROJECT_NAME, " ");
            values.put(KEY_PROJECT_CODE, " ");
            values.put(KEY_PROJECT_LEAD, " ");
            values.put(KEY_PROJECT_TYPE, " ");
            values.put(KEY_METADATA_GEOLOGIST, " ");
            values.put(KEY_METADATA_GEOLCODE, " ");
            values.put(KEY_METADATA_DIGCAMERA, " ");
            values.put(KEY_METADATA_MAPPATH, " ");

            long rowID = database.insert(METADATA_TABLE_NAME, null, values);
            metadata.setID(String.valueOf(rowID));

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
            values.put(KEY_PROJECT_NAME, metadata.getProjectName());
            values.put(KEY_PROJECT_CODE, metadata.getProjectCode());
            values.put(KEY_PROJECT_LEAD, metadata.getProjectLead());
            values.put(KEY_PROJECT_TYPE, metadata.getProjectType());
            values.put(KEY_METADATA_GEOLOGIST, metadata.getGeologist());
            values.put(KEY_METADATA_GEOLCODE, metadata.getGeolcode());
            values.put(KEY_METADATA_DIGCAMERA, metadata.getDigcamera());
            values.put(KEY_METADATA_MAPPATH, metadata.getMapPath());

            rowsAffected = database.update(METADATA_TABLE_NAME, values, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(metadata.getID()) });

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
            rowsAffected = database.delete(METADATA_TABLE_NAME, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(metadata.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public Metadata getEntity() {
        return metadata;
    }

    public void setEntity(String[] metadata) {
        this.metadata = new Metadata(metadata);
    }

    public static String getCreateTableStatement() {
        return PROJECT_TABLE_CREATE;
    }
}

