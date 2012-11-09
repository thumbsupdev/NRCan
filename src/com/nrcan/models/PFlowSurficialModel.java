package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.nrcan.entities.EnvironSurficialEntity;
import com.nrcan.entities.PFlowSurficialEntity;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;

public class PFlowSurficialModel {
	private DatabaseHandler dbHandler;
	private final Context context;
	
	private PFlowSurficialEntity pflowsurficial;
	
	// Table column keys
		private static final String PFLOWSURFICIAL_TABLE_NAME = "pflowsurficial";
		private static final String PFLOWSURFICIAL_NRCID4 = "nrcanId4";
		private static final String PFLOWSURFICIAL_NRCID3 = "nrcanId3";
		private static final String PFLOWSURFICIAL_STATION_ID = "stationID";
		private static final String PFLOWSURFICIAL_EARTHMATID = "earthMatId";
		private static final String PFLOWSURFICIAL_PFLOWID = "pFlowId";
		private static final String PFLOWSURFICIAL_PFLOWNO = "pFlowNo";
		private static final String PFLOWSURFICIAL_PFCLASS = "pfClass";
		private static final String PFLOWSURFICIAL_PFFEATURE = "pfFeature";
		private static final String PFLOWSURFICIAL_PFSENSE = "pfSense";
		private static final String PFLOWSURFICIAL_METHOD = "method";
		private static final String PFLOWSURFICIAL_PFAZIMUTH = "pfAzimuth";
		private static final String PFLOWSURFICIAL_NOTES = "notes";
		private static final String PFLOWSURFICIAL_RELAGE = "relage";
		private static final String PFLOWSURFICIAL_NUMINDIC = "numIndic";
		private static final String PFLOWSURFICIAL_DEFINITION = "definition";
		private static final String PFLOWSURFICIAL_RELATION = "relation";
		private static final String PFLOWSURFICIAL_NOTES_1 = "notes_1";
		
		private static final String PFLOWSURFICIAL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + PFLOWSURFICIAL_TABLE_NAME +" (" +
				PFLOWSURFICIAL_NRCID4 + " INTEGER PRIMARY KEY autoincrement, " +
				PFLOWSURFICIAL_NRCID3 + " INTEGER, " +
				PFLOWSURFICIAL_STATION_ID + " TEXT, " +
				PFLOWSURFICIAL_EARTHMATID + " TEXT, " +
				PFLOWSURFICIAL_PFLOWID + " TEXT, " +
				PFLOWSURFICIAL_PFLOWNO + " TEXT, " +
				PFLOWSURFICIAL_PFCLASS + " TEXT, " +
				PFLOWSURFICIAL_PFFEATURE + " TEXT, " +
				PFLOWSURFICIAL_PFSENSE + " TEXT, " +
				PFLOWSURFICIAL_METHOD + " TEXT," +
				PFLOWSURFICIAL_PFAZIMUTH + " TEXT," +
				PFLOWSURFICIAL_NOTES + " TEXT," +
				PFLOWSURFICIAL_RELAGE + " TEXT," +
				PFLOWSURFICIAL_NUMINDIC + " TEXT" +
				PFLOWSURFICIAL_DEFINITION + " TEXT, " +
				PFLOWSURFICIAL_RELATION + " TEXT, " +
				PFLOWSURFICIAL_NOTES_1 + " TEXT, " +
				
				
				");";
	public PFlowSurficialModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}
	public PFlowSurficialEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { PFLOWSURFICIAL_TABLE_NAME, PFLOWSURFICIAL_STATION_ID, String.valueOf(pflowsurficial.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new PFlowSurficialEntity(dbHandler.getSplitRow(0));
    }
	/*
	public ArrayList<EarthmatBedrockEntity> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { EARTHMATBEDROCK_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        ArrayList<EarthmatBedrockEntity> entities = new ArrayList<EarthmatBedrockEntity>();

        int length = dbHandler.getList().size();
        
        for(int i = 0; i < length; i++) {
            entities.add(new EarthmatBedrockEntity(dbHandler.getSplitRow(i)));   
        }
        
        return entities;
    }
	*/
	public long insertRow() {

        int rowsAffected = 0;
        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            ContentValues values = new ContentValues();
            values.put(PFLOWSURFICIAL_NRCID3, " ");
            values.put(PFLOWSURFICIAL_STATION_ID, " ");
            values.put(PFLOWSURFICIAL_EARTHMATID, " ");
            values.put(PFLOWSURFICIAL_PFLOWID, " ");
            values.put(PFLOWSURFICIAL_PFLOWNO, " ");
            values.put(PFLOWSURFICIAL_PFCLASS, " ");
            values.put(PFLOWSURFICIAL_PFFEATURE, " ");
            values.put(PFLOWSURFICIAL_PFSENSE, " ");
            values.put(PFLOWSURFICIAL_METHOD, " ");	            
            values.put(PFLOWSURFICIAL_PFAZIMUTH, " ");
            values.put(PFLOWSURFICIAL_NOTES, " ");
            values.put(PFLOWSURFICIAL_RELAGE, " ");
            values.put(PFLOWSURFICIAL_NUMINDIC, " ");
            values.put(PFLOWSURFICIAL_DEFINITION, " ");
            values.put(PFLOWSURFICIAL_RELATION, " ");
            values.put(PFLOWSURFICIAL_NOTES_1, " ");
            
            
            
            

            long rowID = database.insert(PFLOWSURFICIAL_TABLE_NAME, null, values);
            pflowsurficial.setID(String.valueOf(rowID));

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
            
            
            values.put(PFLOWSURFICIAL_STATION_ID, pflowsurficial.getStationId());
            values.put(PFLOWSURFICIAL_EARTHMATID, pflowsurficial.getEarthMatId());
            values.put(PFLOWSURFICIAL_PFLOWID, pflowsurficial.getpFlowId());
            values.put(PFLOWSURFICIAL_PFLOWNO, pflowsurficial.getpFlowNo());
            values.put(PFLOWSURFICIAL_PFCLASS, pflowsurficial.getPfClass());
            values.put(PFLOWSURFICIAL_PFFEATURE, pflowsurficial.getPfFeature());
            values.put(PFLOWSURFICIAL_PFSENSE, pflowsurficial.getPfSense());
            values.put(PFLOWSURFICIAL_METHOD, pflowsurficial.getMethod());	            
            values.put(PFLOWSURFICIAL_PFAZIMUTH, pflowsurficial.getPfAzimuth());
            values.put(PFLOWSURFICIAL_NOTES, pflowsurficial.getNotes());
            values.put(PFLOWSURFICIAL_RELAGE, pflowsurficial.getRelage());
            values.put(PFLOWSURFICIAL_NUMINDIC, pflowsurficial.getNumIndic());
            values.put(PFLOWSURFICIAL_DEFINITION, pflowsurficial.getDefinition());
            values.put(PFLOWSURFICIAL_RELATION, pflowsurficial.getRelation());
            values.put(PFLOWSURFICIAL_NOTES_1, pflowsurficial.getNotes_1());

            rowsAffected = database.update(PFLOWSURFICIAL_TABLE_NAME, values, CHECKth 5 PFLOWSURFICIAL_STATION_ID + "=?",
                    new String[] { String.valueOf(pflowsurficial.getID()) });

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
            rowsAffected = database.delete(PFLOWSURFICIAL_TABLE_NAME, PFLOWSURFICIAL_STATION_ID + "=?",
                    new String[] { String.valueOf(pflowsurficial.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public PFlowSurficialEntity getEntity() {
        return pflowsurficial;
    }

    public void setEntity(String[] pflowsurficial) {
        this.pflowsurficial = new PFlowSurficialEntity(pflowsurficial);
    }

    public static String getCreateTableStatement() {
        return PFLOWSURFICIAL_TABLE_CREATE;
    }
}
