package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.StructureEntity;

import android.util.Log;
import java.util.ArrayList;

public class StructureModel {

	private DatabaseHandler dbHandler;
	private final Context context;
    private StructureEntity structure;

    // Table column keys
	private static final String STRUCTURE_TABLE_NAME = "structure";
	private static final String STRUCTURE_NRCANID4 = "nrcanId4";
	private static final String STRUCTURE_NRCANID3 = "nrcanId3";
	private static final String STRUCTURE_STATIONID = "stationId";
	private static final String STRUCTURE_EARTHMATID = "earthMatID";
	private static final String STRUCTURE_STRUCTID = "structId";
	private static final String STRUCTURE_STRUCTNO = "structNo";
	private static final String STRUCTURE_STRUCCLASS = "strucClass";
	private static final String STRUCTURE_STRUCTYPE = "strucType";
	private static final String STRUCTURE_DETAIL = "detail";
	private static final String STRUCTURE_METHOD = "method";
	private static final String STRUCTURE_FORMAT = "format";
	private static final String STRUCTURE_ATTITUDE = "attitude";
	private static final String STRUCTURE_YOUNGING = "younging";
	private static final String STRUCTURE_GENERATION = "generation";
	private static final String STRUCTURE_STRAIN = "strain";
	private static final String STRUCTURE_FLATTENING = "flattening";
	private static final String STRUCTURE_RELATED = "related";
	private static final String STRUCTURE_FABRIC = "fabric";
	private static final String STRUCTURE_SENSE = "sense";
	private static final String STRUCTURE_AZIMUTH = "azimuth";
	private static final String STRUCTURE_DIPPLUNGE = "dipplunge";
	private static final String STRUCTURE_SYMANG = "symang";
	private static final String STRUCTURE_NOTES = "notes";

	private static final String STRUCTURE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS structure (" +
				"structId INTEGER PRIMARY KEY autoincrement, " +
				"nrcanId4 TEXT, " +
				"nrcanId3 TEXT, " +
				"stationId TEXT, " +
				"earthMatID TEXT, " +
				"structId TEXT, " +
				"structNo TEXT, " +
				"strucClass TEXT, " +
				"strucType TEXT, " +
				"detail TEXT, " +
				"method TEXT, " +
				"format TEXT," +
				"attitude TEXT," +
				"younging TEXT," +
				"generation TEXT," +
				"strain TEXT," +
				"flattening TEXT," +
				"related TEXT," +
				"fabric TEXT," +
				"sense TEXT," +
				"azimuth TEXT," +
				"dipplunge TEXT," +
				"symang TEXT," +
				"notes TEXT," +
				");";

	public StructureModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}

    public StructureEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { STRUCTURE_TABLE_NAME, STRUCTURE_STRUCTID, String.valueOf(structure.getStructId()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new StructureEntity(dbHandler.getSplitRow(0));
    }

    public ArrayList<StructureEntity> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { STRUCTURE_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        ArrayList<StructureEntity> entities = new ArrayList<StructureEntity>();

        int length = dbHandler.getList().size();
        
        for(int i = 0; i < length; i++) {
            entities.add(new StructureEntity(dbHandler.getSplitRow(i)));   
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
            values.put(STRUCTURE_NRCANID4, " ");
            values.put(STRUCTURE_NRCANID3, " ");
        	values.put(STRUCTURE_STATIONID, " ");
        	values.put(STRUCTURE_EARTHMATID, " ");
        	values.put(STRUCTURE_STRUCTID, " ");
        	values.put(STRUCTURE_STRUCTNO, " ");
        	values.put(STRUCTURE_STRUCCLASS, " ");
        	values.put(STRUCTURE_STRUCTYPE, " ");
        	values.put(STRUCTURE_DETAIL, " ");
        	values.put(STRUCTURE_METHOD, " ");
        	values.put(STRUCTURE_FORMAT, " ");
        	values.put(STRUCTURE_ATTITUDE, " ");
        	values.put(STRUCTURE_YOUNGING, " ");
        	values.put(STRUCTURE_GENERATION, " ");
        	values.put(STRUCTURE_STRAIN, " ");
        	values.put(STRUCTURE_FLATTENING, " ");
        	values.put(STRUCTURE_RELATED, " ");
        	values.put(STRUCTURE_FABRIC, " ");
        	values.put(STRUCTURE_SENSE, " ");
        	values.put(STRUCTURE_AZIMUTH, " ");
        	values.put(STRUCTURE_DIPPLUNGE, " ");
        	values.put(STRUCTURE_SYMANG, " ");
        	values.put(STRUCTURE_NOTES, " ");

            long rowID = database.insert(STRUCTURE_TABLE_NAME, null, values);
            structure.setStructId(String.valueOf(rowID));

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
            values.put(STRUCTURE_NRCANID4, structure.getNrcanId4());
            values.put(STRUCTURE_NRCANID3, structure.getNrcanId3());
            values.put(STRUCTURE_STATIONID, structure.getStationId());
        	values.put(STRUCTURE_EARTHMATID, structure.getEarthMatID());
        	values.put(STRUCTURE_STRUCTID, structure.getStructId());
        	values.put(STRUCTURE_STRUCTNO, structure.getStructNo());
        	values.put(STRUCTURE_STRUCCLASS, structure.getStrucClass());
        	values.put(STRUCTURE_STRUCTYPE, structure.getStrucType());
        	values.put(STRUCTURE_DETAIL, structure.getDetail());
        	values.put(STRUCTURE_METHOD, structure.getMethod());
        	values.put(STRUCTURE_FORMAT, structure.getFormat());
        	values.put(STRUCTURE_ATTITUDE, structure.getAttitude());
        	values.put(STRUCTURE_YOUNGING, structure.getYounging());
        	values.put(STRUCTURE_GENERATION, structure.getGeneration());
        	values.put(STRUCTURE_STRAIN, structure.getStrain());
        	values.put(STRUCTURE_FLATTENING, structure.getFlattening());
        	values.put(STRUCTURE_RELATED, structure.getRelated());
        	values.put(STRUCTURE_FABRIC, structure.getFabric());
        	values.put(STRUCTURE_SENSE, structure.getSense());
        	values.put(STRUCTURE_AZIMUTH, structure.getAzimuth());
        	values.put(STRUCTURE_DIPPLUNGE, structure.getDipplunge());
        	values.put(STRUCTURE_SYMANG, structure.getSymang());
        	values.put(STRUCTURE_NOTES, structure.getNotes());

            rowsAffected = database.update(STRUCTURE_TABLE_NAME, values, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(structure.getID()) });

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
            rowsAffected = database.delete(STRUCTURE_TABLE_NAME, KEY_METADATA_ID + "=?",
                    new String[] { String.valueOf(structure.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public StructureEntity getEntity() {
        return structure;
    }

    public void setEntity(String[] structure) {
        this.structure = new StructureEntity(structure);
    }

    public static String getCreateTableStatement() {
        return STRUCTURE_TABLE_CREATE;
    }
}

