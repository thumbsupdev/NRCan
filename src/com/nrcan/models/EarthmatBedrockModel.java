package com.nrcan.models;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.nrcan.entities.EarthmatBedrockEntity;
import com.nrcan.entities.MetadataEntity;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;

public class EarthmatBedrockModel {
	private DatabaseHandler dbHandler;
	private final Context context;
	
	private EarthmatBedrockEntity earthmatbedrock;
	
	// Table column keys
		private static final String EARTHMATBEDROCK_TABLE_NAME = "earthmatbedrock";
		private static final String EARTHMATBEDROCK_NRCID3 = "nrcanId3";
		private static final String EARTHMATBEDROCK_NRCID2 = "nrcanId2";
		private static final String EARTHMATBEDROCK_STATION_ID = "stationID";
		private static final String EARTHMATBEDROCK_EARTHMATLT = "earthmatLT";
		private static final String EARTHMATBEDROCK_EARTHMATNO = "earthmatNo";
		private static final String EARTHMATBEDROCK_EARTHMATID = "earthmatID";
		private static final String EARTHMATBEDROCK_LITHGROUP = "lithGroup";
		private static final String EARTHMATBEDROCK_LITHTYPE = "lithType";
		private static final String EARTHMATBEDROCK_LITHDETAIL = "lithDetail";
		private static final String EARTHMATBEDROCK_MAPUNIT = "mapUnit";
		private static final String EARTHMATBEDROCK_OCCURAS = "occurAs";
		private static final String EARTHMATBEDROCK_MODSTRUC = "modStruc";
		private static final String EARTHMATBEDROCK_MODTEXTURE = "modTexture";
		private static final String EARTHMATBEDROCK_MODCOMP = "modComp";
		private static final String EARTHMATBEDROCK_GRCRYSIZE = "grcrySize";
		private static final String EARTHMATBEDROCK_DEFFABRIC = "defFabric";
		private static final String EARTHMATBEDROCK_BEDTHICK = "bedThick";
		private static final String EARTHMATBEDROCK_MINERAL = "mineral";
		private static final String EARTHMATBEDROCK_MINNOTE = "minNote";
		private static final String EARTHMATBEDROCK_COLOURF = "colourF";
		private static final String EARTHMATBEDROCK_COLOURW = "colourW";
		private static final String EARTHMATBEDROCK_COLOURIND = "colourInd";
		private static final String EARTHMATBEDROCK_MAGSUSCEPT = "magSuscept";
		private static final String EARTHMATBEDROCK_FOSSILS = "fossils";
		private static final String EARTHMATBEDROCK_FOSSILNOTE = "fossilNote";
		private static final String EARTHMATBEDROCK_CONTACT = "contact";
		private static final String EARTHMATBEDROCK_CONTACTUP = "contactUp";
		private static final String EARTHMATBEDROCK_CONTACTLOW = "contactLow";
		private static final String EARTHMATBEDROCK_INTERP = "interp";
		private static final String EARTHMATBEDROCK_INTERPCONF = "interpConf";
	
		
		

		private static final String EARTHMATBEDROCK_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + EARTHMATBEDROCK_TABLE_NAME +" (" +
					EARTHMATBEDROCK_NRCID3 + " INTEGER PRIMARY KEY autoincrement, " +
					EARTHMATBEDROCK_NRCID2 + " INTEGER, " +
					EARTHMATBEDROCK_STATION_ID + " TEXT, " +
					EARTHMATBEDROCK_EARTHMATLT + " TEXT, " +
					EARTHMATBEDROCK_EARTHMATNO + " TEXT, " +
					EARTHMATBEDROCK_EARTHMATID + " TEXT, " +
					EARTHMATBEDROCK_LITHGROUP + " TEXT, " +
					EARTHMATBEDROCK_LITHTYPE + " TEXT, " +
					EARTHMATBEDROCK_LITHDETAIL + " TEXT, " +
					EARTHMATBEDROCK_MAPUNIT + " TEXT," +
					EARTHMATBEDROCK_OCCURAS + " TEXT," +
					EARTHMATBEDROCK_MODSTRUC + " TEXT," +
					EARTHMATBEDROCK_MODTEXTURE + " TEXT," +
					EARTHMATBEDROCK_MODCOMP + " TEXT" +
					EARTHMATBEDROCK_GRCRYSIZE + " TEXT, " +
					EARTHMATBEDROCK_DEFFABRIC + " TEXT, " +
					EARTHMATBEDROCK_BEDTHICK + " TEXT, " +
					EARTHMATBEDROCK_MINERAL + " TEXT, " +
					EARTHMATBEDROCK_MINNOTE + " TEXT, " +
					EARTHMATBEDROCK_COLOURF + " TEXT, " +
					EARTHMATBEDROCK_COLOURW + " TEXT," +
					EARTHMATBEDROCK_COLOURIND + " TEXT," +
					EARTHMATBEDROCK_MAGSUSCEPT + " TEXT," +
					EARTHMATBEDROCK_FOSSILS + " TEXT," +
					EARTHMATBEDROCK_FOSSILNOTE + " TEXT" +
					EARTHMATBEDROCK_CONTACT + " TEXT," +
					EARTHMATBEDROCK_CONTACTUP + " TEXT," +
					EARTHMATBEDROCK_CONTACTLOW + " TEXT," +
					EARTHMATBEDROCK_INTERP + " TEXT," +
					EARTHMATBEDROCK_INTERPCONF + " TEXT" +
					");";
		public EarthmatBedrockModel(Context context, DatabaseHandler dbHandler) {
			this.context = context;
	        this.dbHandler = dbHandler;
		}
		public EarthmatBedrockEntity readRow() {

	        SQLiteDatabase database = dbHandler.getDatabase();

	        database.beginTransaction();

	        try {

	            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { EARTHMATBEDROCK_TABLE_NAME, EARTHMATBEDROCK_STATION_ID, String.valueOf(earthmatbedrock.getID()) });
	            database.setTransactionSuccessful();
	        } finally {
	            database.endTransaction();
	        }

	        return new EarthmatBedrockEntity(dbHandler.getSplitRow(0));
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
	            values.put(EARTHMATBEDROCK_NRCID2, " ");
	            values.put(EARTHMATBEDROCK_STATION_ID, " ");
	            values.put(EARTHMATBEDROCK_EARTHMATLT, " ");
	            values.put(EARTHMATBEDROCK_EARTHMATNO, " ");
	            values.put(EARTHMATBEDROCK_EARTHMATID, " ");
	            values.put(EARTHMATBEDROCK_LITHGROUP, " ");
	            values.put(EARTHMATBEDROCK_LITHTYPE, " ");
	            values.put(EARTHMATBEDROCK_LITHDETAIL, " ");
	            values.put(EARTHMATBEDROCK_MAPUNIT, " ");	            
	            values.put(EARTHMATBEDROCK_OCCURAS, " ");
	            values.put(EARTHMATBEDROCK_MODSTRUC, " ");
	            values.put(EARTHMATBEDROCK_MODTEXTURE, " ");
	            values.put(EARTHMATBEDROCK_MODCOMP, " ");
	            values.put(EARTHMATBEDROCK_GRCRYSIZE, " ");
	            values.put(EARTHMATBEDROCK_DEFFABRIC, " ");
	            values.put(EARTHMATBEDROCK_BEDTHICK, " ");
	            values.put(EARTHMATBEDROCK_MINERAL, " ");	            
	            values.put(EARTHMATBEDROCK_MINNOTE, " ");
	            values.put(EARTHMATBEDROCK_COLOURF, " ");
	            values.put(EARTHMATBEDROCK_COLOURW, " ");
	            values.put(EARTHMATBEDROCK_COLOURIND, " ");
	            values.put(EARTHMATBEDROCK_MAGSUSCEPT, " ");
	            values.put(EARTHMATBEDROCK_FOSSILS, " ");
	            values.put(EARTHMATBEDROCK_FOSSILNOTE, " ");
	            values.put(EARTHMATBEDROCK_CONTACT, " ");          
	            values.put(EARTHMATBEDROCK_CONTACTUP, " ");
	            values.put(EARTHMATBEDROCK_CONTACTLOW, " ");
	            values.put(EARTHMATBEDROCK_INTERP, " ");
	            values.put(EARTHMATBEDROCK_INTERPCONF, " ");
	            
	            

	            long rowID = database.insert(EARTHMATBEDROCK_TABLE_NAME, null, values);
	            earthmatbedrock.setID(String.valueOf(rowID));

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
	            
	            values.put(EARTHMATBEDROCK_STATION_ID, earthmatbedrock.getStationID());
	            values.put(EARTHMATBEDROCK_EARTHMATLT,  earthmatbedrock.getEarthmatLT());
	            values.put(EARTHMATBEDROCK_EARTHMATNO,  earthmatbedrock.getEarthmatNo());
	            values.put(EARTHMATBEDROCK_EARTHMATID,  earthmatbedrock.getEarthmatID());
	            values.put(EARTHMATBEDROCK_LITHGROUP,  earthmatbedrock.getLithGroup());
	            values.put(EARTHMATBEDROCK_LITHTYPE,  earthmatbedrock.getLithType());
	            values.put(EARTHMATBEDROCK_LITHDETAIL,  earthmatbedrock.getLithDetail());
	            values.put(EARTHMATBEDROCK_MAPUNIT,  earthmatbedrock.getMapUnit());	            
	            values.put(EARTHMATBEDROCK_OCCURAS,  earthmatbedrock.getOccurAs());
	            values.put(EARTHMATBEDROCK_MODSTRUC,  earthmatbedrock.getModStruc());
	            values.put(EARTHMATBEDROCK_MODTEXTURE,  earthmatbedrock.getModTexture());
	            values.put(EARTHMATBEDROCK_MODCOMP,  earthmatbedrock.getModComp());
	            values.put(EARTHMATBEDROCK_GRCRYSIZE,  earthmatbedrock.getGrcrySize());
	            values.put(EARTHMATBEDROCK_DEFFABRIC,  earthmatbedrock.getDefFabric());
	            values.put(EARTHMATBEDROCK_BEDTHICK,  earthmatbedrock.getBedThick());
	            values.put(EARTHMATBEDROCK_MINERAL,  earthmatbedrock.getMineral());	            
	            values.put(EARTHMATBEDROCK_MINNOTE,  earthmatbedrock.getMinNote());
	            values.put(EARTHMATBEDROCK_COLOURF,  earthmatbedrock.getColourF());
	            values.put(EARTHMATBEDROCK_COLOURW,  earthmatbedrock.getColourW());
	            values.put(EARTHMATBEDROCK_COLOURIND,  earthmatbedrock.getColourInd());
	            values.put(EARTHMATBEDROCK_MAGSUSCEPT,  earthmatbedrock.getMagSuscept());
	            values.put(EARTHMATBEDROCK_FOSSILS,  earthmatbedrock.getFossils());
	            values.put(EARTHMATBEDROCK_FOSSILNOTE,  earthmatbedrock.getFossilNote());
	            values.put(EARTHMATBEDROCK_CONTACT,  earthmatbedrock.getContact());          
	            values.put(EARTHMATBEDROCK_CONTACTUP,  earthmatbedrock.getContactUp());
	            values.put(EARTHMATBEDROCK_CONTACTLOW,  earthmatbedrock.getContactLow());
	            values.put(EARTHMATBEDROCK_INTERP,  earthmatbedrock.getInterp());
	            values.put(EARTHMATBEDROCK_INTERPCONF,  earthmatbedrock.getInterpConf());

	            rowsAffected = database.update(EARTHMATBEDROCK_TABLE_NAME, values, CHECKth 5 EARTHMATBEDROCK_STATION_ID + "=?",
	                    new String[] { String.valueOf(earthmatbedrock.getID()) });

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
	            rowsAffected = database.delete(EARTHMATBEDROCK_TABLE_NAME, EARTHMATBEDROCK_STATION_ID + "=?",
	                    new String[] { String.valueOf(earthmatbedrock.getID()) });
	            database.setTransactionSuccessful();
	        } finally {
	            database.endTransaction();
	        }

	        return rowsAffected;
	    }

	    public EarthmatBedrockEntity getEntity() {
	        return earthmatbedrock;
	    }

	    public void setEntity(String[] earthmatbedrock) {
	        this.earthmatbedrock = new EarthmatBedrockEntity(earthmatbedrock);
	    }

	    public static String getCreateTableStatement() {
	        return EARTHMATBEDROCK_TABLE_CREATE;
	    }

}
