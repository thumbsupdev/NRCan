package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.entities.EnvironSurficialEntity;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;

public class EnvironSurficialModel {
	private DatabaseHandler dbHandler;
	private EnvironSurficialEntity environsurficial;

	private static final String ENVIRONSURFICIAL_TABLE_NAME = "environsurficial";
	private static final String ENVIRONSURFICIAL_NRCANID3 = "nrcanId3";
	private static final String ENVIRONSURFICIAL_NRCANID2 = "nrcanId2";
	private static final String ENVIRONSURFICIAL_STATION_ID = "stationID";
	private static final String ENVIRONSURFICIAL_DRAINAGE = "drainage";
	private static final String ENVIRONSURFICIAL_SLOPE = "slope";
	private static final String ENVIRONSURFICIAL_ASPECT = "aspect";
	private static final String ENVIRONSURFICIAL_PFPRESENT = "pfPresent";
	private static final String ENVIRONSURFICIAL_PFINDIC = "pfIndic";
	private static final String ENVIRONSURFICIAL_PFDEPTH = "pfDepth";
	private static final String ENVIRONSURFICIAL_GOSSANPRES = "gossanPres";
	private static final String ENVIRONSURFICIAL_GOSSONMAT = "gossanMat";
	private static final String ENVIRONSURFICIAL_BROCK = "bRock";
	private static final String ENVIRONSURFICIAL_EXPOSURE = "exposure";
	private static final String ENVIRONSURFICIAL_VEGITATION = "vegetation";
	private static final String ENVIRONSURFICIAL_BOULDERS = "boulders";
	private static final String ENVIRONSURFICIAL_BOULDFLD = "bouldFld";
	private static final String ENVIRONSURFICIAL_BOFLDTYP = "boFldTyp";
	private static final String ENVIRONSURFICIAL_GRNDCOVER = "grndCover";
	private static final String ENVIRONSURFICIAL_PCENTCOVER = "pcentCover";
	private static final String ENVIRONSURFICIAL_PATTERNGRN = "patternGrn";
	private static final String ENVIRONSURFICIAL_PATAREA = "patArea";
	private static final String ENVIRONSURFICIAL_NOTES = "notes";

	private static final String ENVIRONSURFICIAL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + ENVIRONSURFICIAL_TABLE_NAME +" (" +
			ENVIRONSURFICIAL_NRCANID3 + " INTEGER PRIMARY KEY autoincrement, " +
			ENVIRONSURFICIAL_NRCANID2 + " INTEGER, " +
			ENVIRONSURFICIAL_STATION_ID + " TEXT, " +
			ENVIRONSURFICIAL_DRAINAGE + " TEXT, " +
			ENVIRONSURFICIAL_SLOPE + " TEXT, " +
			ENVIRONSURFICIAL_ASPECT + " TEXT, " +
			ENVIRONSURFICIAL_PFPRESENT + " TEXT, " +
			ENVIRONSURFICIAL_PFINDIC + " TEXT, " +
			ENVIRONSURFICIAL_PFDEPTH + " TEXT, " +
			ENVIRONSURFICIAL_GOSSANPRES + " TEXT," +
			ENVIRONSURFICIAL_GOSSONMAT + " TEXT," +
			ENVIRONSURFICIAL_BROCK + " TEXT," +
			ENVIRONSURFICIAL_EXPOSURE + " TEXT," +
			ENVIRONSURFICIAL_VEGITATION + " TEXT," +
			ENVIRONSURFICIAL_BOULDERS + " TEXT, " +
			ENVIRONSURFICIAL_BOULDFLD + " TEXT, " +
			ENVIRONSURFICIAL_BOFLDTYP + " TEXT, " +
			ENVIRONSURFICIAL_GRNDCOVER + " TEXT, " +
			ENVIRONSURFICIAL_PCENTCOVER + " TEXT, " +
			ENVIRONSURFICIAL_PATTERNGRN + " TEXT, " +
			ENVIRONSURFICIAL_PATAREA + " TEXT," +
			ENVIRONSURFICIAL_NOTES + " TEXT" +
			");";

	public EnvironSurficialModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.environsurficial = new EnvironSurficialEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { ENVIRONSURFICIAL_TABLE_NAME, ENVIRONSURFICIAL_NRCANID3, String.valueOf(environsurficial.getNrcanId3()) };
		dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, tmp);

		environsurficial.setEntity(dbHandler.getSplitRow(0));
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(ENVIRONSURFICIAL_NRCANID2, 0);
		values.put(ENVIRONSURFICIAL_STATION_ID, " ");
		values.put(ENVIRONSURFICIAL_DRAINAGE, " ");
		values.put(ENVIRONSURFICIAL_SLOPE, " ");
		values.put(ENVIRONSURFICIAL_ASPECT, " ");
		values.put(ENVIRONSURFICIAL_PFPRESENT, " ");
		values.put(ENVIRONSURFICIAL_PFINDIC, " ");
		values.put(ENVIRONSURFICIAL_PFDEPTH, " ");
		values.put(ENVIRONSURFICIAL_GOSSANPRES, " ");	            
		values.put(ENVIRONSURFICIAL_GOSSONMAT, " ");
		values.put(ENVIRONSURFICIAL_BROCK, " ");
		values.put(ENVIRONSURFICIAL_EXPOSURE, " ");
		values.put(ENVIRONSURFICIAL_VEGITATION, " ");
		values.put(ENVIRONSURFICIAL_BOULDERS, " ");
		values.put(ENVIRONSURFICIAL_BOULDFLD, " ");
		values.put(ENVIRONSURFICIAL_BOFLDTYP, " ");
		values.put(ENVIRONSURFICIAL_GRNDCOVER, " ");	            
		values.put(ENVIRONSURFICIAL_PCENTCOVER, " ");
		values.put(ENVIRONSURFICIAL_PATTERNGRN, " ");
		values.put(ENVIRONSURFICIAL_PATAREA, " ");
		values.put(ENVIRONSURFICIAL_NOTES, " ");

		long rowID = dbHandler.insertRow(ENVIRONSURFICIAL_TABLE_NAME, null, values);
		
		environsurficial.setNrcanId3((int)rowID);
		
		updateRow();
	}
	
	public void updateRow() {
		ContentValues values = new ContentValues();
		values.put(ENVIRONSURFICIAL_STATION_ID, environsurficial.getStationId());
		values.put(ENVIRONSURFICIAL_DRAINAGE, environsurficial.getDrainage());
		values.put(ENVIRONSURFICIAL_SLOPE, environsurficial.getSlope());
		values.put(ENVIRONSURFICIAL_ASPECT, environsurficial.getAspect());
		values.put(ENVIRONSURFICIAL_PFPRESENT, environsurficial.getPfPresent());
		values.put(ENVIRONSURFICIAL_PFINDIC, environsurficial.getPfIndic());
		values.put(ENVIRONSURFICIAL_PFDEPTH, environsurficial.getPfDepth());
		values.put(ENVIRONSURFICIAL_GOSSANPRES, environsurficial.getGossanPres());	            
		values.put(ENVIRONSURFICIAL_GOSSONMAT, environsurficial.getGossanMat());
		values.put(ENVIRONSURFICIAL_BROCK, environsurficial.getbRock());
		values.put(ENVIRONSURFICIAL_EXPOSURE, environsurficial.getExposure());
		values.put(ENVIRONSURFICIAL_VEGITATION, environsurficial.getVegetation());
		values.put(ENVIRONSURFICIAL_BOULDERS, environsurficial.getBoulders());
		values.put(ENVIRONSURFICIAL_BOULDFLD, environsurficial.getBouldFld());
		values.put(ENVIRONSURFICIAL_BOFLDTYP, environsurficial.getBoFldTyp());
		values.put(ENVIRONSURFICIAL_GRNDCOVER, environsurficial.getGrndCover());	            
		values.put(ENVIRONSURFICIAL_PCENTCOVER, environsurficial.getPcentCover());
		values.put(ENVIRONSURFICIAL_PATTERNGRN, environsurficial.getPatternGrn());
		values.put(ENVIRONSURFICIAL_PATAREA, environsurficial.getPatArea());
		values.put(ENVIRONSURFICIAL_NOTES, environsurficial.getNotes());

		String whereClause = ENVIRONSURFICIAL_NRCANID3 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(environsurficial.getNrcanId3())
		};

		dbHandler.updateRow(ENVIRONSURFICIAL_TABLE_NAME, values, whereClause, whereArgs);
	}

	public EnvironSurficialEntity getEntity() {
		return environsurficial;
	}

	public static String getCreateTableStatement() {
		return ENVIRONSURFICIAL_TABLE_CREATE;
	}
	
}
