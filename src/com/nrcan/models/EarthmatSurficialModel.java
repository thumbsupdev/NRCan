package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.entities.EarthmatSurficialEntity;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;

public class EarthmatSurficialModel {
	private DatabaseHandler dbHandler;
	private EarthmatSurficialEntity earthmatsurficial;

	private static final String EARTHMATSURFICIAL_TABLE_NAME = "earthmatsurficial";
	private static final String EARTHMATSURFICIAL_NRCANID3 = "nrcanId3";
	private static final String EARTHMATSURFICIAL_NRCANID2 = "nrcanId2";
	private static final String EARTHMATSURFICIAL_STATION_ID = "stationID";
	private static final String EARTHMATSURFICIAL_EARTHMATLT = "earthmatLT";
	private static final String EARTHMATSURFICIAL_EARTHMATNO = "earthmatNo";
	private static final String EARTHMATSURFICIAL_EARTHMATID = "earthmatID";
	private static final String EARTHMATSURFICIAL_LITHGROUP = "lithGroup";
	private static final String EARTHMATSURFICIAL_LITHTYPE = "lithType";
	private static final String EARTHMATSURFICIAL_LITHDETAIL = "lithDetail";
	private static final String EARTHMATSURFICIAL_MAPUNIT = "mapUnit";
	private static final String EARTHMATSURFICIAL_SUFFORM = "sufform";
	private static final String EARTHMATSURFICIAL_UNITNO = "unitNo";
	private static final String EARTHMATSURFICIAL_MATRIXMOD = "matrixMod";
	private static final String EARTHMATSURFICIAL_MATRIX = "matrix";
	private static final String EARTHMATSURFICIAL_JOINTING = "jointing";
	private static final String EARTHMATSURFICIAL_COMPACTION = "compaction";
	private static final String EARTHMATSURFICIAL_OXIDATION = "oxidation";
	private static final String EARTHMATSURFICIAL_H2OCONTENT = "h2oContent";
	private static final String EARTHMATSURFICIAL_FISSILITY = "fissilty";
	private static final String EARTHMATSURFICIAL_HCLREACT = "hclReact";
	private static final String EARTHMATSURFICIAL_CLASTMODAL = "clastModal";
	private static final String EARTHMATSURFICIAL_CLASTMIN = "clastMin";
	private static final String EARTHMATSURFICIAL_CLASTMAX = "clastMax";
	private static final String EARTHMATSURFICIAL_CLASTPCT= "clastPct";
	private static final String EARTHMATSURFICIAL_CLASTFORM = "clastForm";
	private static final String EARTHMATSURFICIAL_SORTING = "sorting";
	private static final String EARTHMATSURFICIAL_MODALRND = "modalRnd";
	private static final String EARTHMATSURFICIAL_MAXROUND = "maxRound";
	private static final String EARTHMATSURFICIAL_MINROUND = "minRound";
	private static final String EARTHMATSURFICIAL_THICKTYPE = "thickType";
	private static final String EARTHMATSURFICIAL_THICKMIN = "thickMin";
	private static final String EARTHMATSURFICIAL_THICKMAX = "thickMax";
	private static final String EARTHMATSURFICIAL_COLOUR = "colour";
	private static final String EARTHMATSURFICIAL_LWRCONTACT = "lwrContact";
	private static final String EARTHMATSURFICIAL_INTCONTACT = "intContact";
	private static final String EARTHMATSURFICIAL_LATCONTACT = "latContact";
	private static final String EARTHMATSURFICIAL_ERRATICTYP = "erraticTyp";
	private static final String EARTHMATSURFICIAL_ERRATICPER = "erraticPer";
	private static final String EARTHMATSURFICIAL_LANDFORM = "landForm";
	private static final String EARTHMATSURFICIAL_PRIMESTRUC = "primeStruc";
	private static final String EARTHMATSURFICIAL_SCNDSTRUC = "scndStruc";
	private static final String EARTHMATSURFICIAL_WAYUP = "wayUp";
	private static final String EARTHMATSURFICIAL_NOTES = "notes";
	private static final String EARTHMATSURFICIAL_INTERP= "interp";
	private static final String EARTHMATSURFICIAL_INTERPCONF = "interpConf";

	private static final String EARTHMATSURFICIAL_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + EARTHMATSURFICIAL_TABLE_NAME +" (" +
			EARTHMATSURFICIAL_NRCANID3 + " INTEGER PRIMARY KEY autoincrement, " +
			EARTHMATSURFICIAL_NRCANID2 + " INTEGER, " +
			EARTHMATSURFICIAL_STATION_ID + " TEXT, " +
			EARTHMATSURFICIAL_EARTHMATLT + " TEXT, " +
			EARTHMATSURFICIAL_EARTHMATNO + " TEXT, " +
			EARTHMATSURFICIAL_EARTHMATID + " TEXT, " +
			EARTHMATSURFICIAL_LITHGROUP + " TEXT, " +
			EARTHMATSURFICIAL_LITHTYPE + " TEXT, " +
			EARTHMATSURFICIAL_LITHDETAIL + " TEXT, " +
			EARTHMATSURFICIAL_MAPUNIT + " TEXT," +
			EARTHMATSURFICIAL_SUFFORM + " TEXT," +
			EARTHMATSURFICIAL_UNITNO + " TEXT," +
			EARTHMATSURFICIAL_MATRIXMOD + " TEXT," +
			EARTHMATSURFICIAL_MATRIX + " TEXT" +
			EARTHMATSURFICIAL_JOINTING + " TEXT, " +
			EARTHMATSURFICIAL_COMPACTION + " TEXT, " +
			EARTHMATSURFICIAL_OXIDATION + " TEXT, " +
			EARTHMATSURFICIAL_H2OCONTENT + " TEXT, " +
			EARTHMATSURFICIAL_FISSILITY + " TEXT, " +
			EARTHMATSURFICIAL_HCLREACT + " TEXT, " +
			EARTHMATSURFICIAL_CLASTMODAL + " TEXT," +
			EARTHMATSURFICIAL_CLASTMIN + " TEXT," +
			EARTHMATSURFICIAL_CLASTMAX + " TEXT," +
			EARTHMATSURFICIAL_CLASTPCT + " TEXT," +
			EARTHMATSURFICIAL_CLASTFORM + " TEXT" +
			EARTHMATSURFICIAL_SORTING + " TEXT," +
			EARTHMATSURFICIAL_MODALRND + " TEXT," +
			EARTHMATSURFICIAL_MAXROUND + " TEXT," +
			EARTHMATSURFICIAL_MINROUND + " TEXT, " +
			EARTHMATSURFICIAL_THICKTYPE + " TEXT, " +
			EARTHMATSURFICIAL_THICKMIN + " TEXT," +
			EARTHMATSURFICIAL_THICKMAX + " TEXT," +
			EARTHMATSURFICIAL_COLOUR + " TEXT," +
			EARTHMATSURFICIAL_LWRCONTACT + " TEXT," +
			EARTHMATSURFICIAL_INTCONTACT + " TEXT" +
			EARTHMATSURFICIAL_LATCONTACT + " TEXT, " +
			EARTHMATSURFICIAL_ERRATICTYP + " TEXT, " +
			EARTHMATSURFICIAL_ERRATICPER + " TEXT, " +
			EARTHMATSURFICIAL_LANDFORM + " TEXT, " +
			EARTHMATSURFICIAL_PRIMESTRUC + " TEXT, " +
			EARTHMATSURFICIAL_SCNDSTRUC + " TEXT, " +
			EARTHMATSURFICIAL_WAYUP + " TEXT," +
			EARTHMATSURFICIAL_NOTES + " TEXT," +
			EARTHMATSURFICIAL_INTERP + " TEXT," +
			EARTHMATSURFICIAL_INTERPCONF + " TEXT" +
			");";

	public EarthmatSurficialModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.earthmatsurficial = new EarthmatSurficialEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { EARTHMATSURFICIAL_TABLE_NAME, EARTHMATSURFICIAL_NRCANID3, String.valueOf(earthmatsurficial.getNrcanId3()) };
		dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, tmp);

		earthmatsurficial.setEntity(dbHandler.getSplitRow(0));
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(EARTHMATSURFICIAL_NRCANID2, 0);
		values.put(EARTHMATSURFICIAL_STATION_ID, " ");
		values.put(EARTHMATSURFICIAL_EARTHMATLT, " ");
		values.put(EARTHMATSURFICIAL_EARTHMATNO, " ");
		values.put(EARTHMATSURFICIAL_EARTHMATID, " ");
		values.put(EARTHMATSURFICIAL_LITHGROUP, " ");
		values.put(EARTHMATSURFICIAL_LITHTYPE, " ");
		values.put(EARTHMATSURFICIAL_LITHDETAIL, " ");
		values.put(EARTHMATSURFICIAL_MAPUNIT, " ");	            
		values.put(EARTHMATSURFICIAL_SUFFORM, " ");
		values.put(EARTHMATSURFICIAL_UNITNO, " ");
		values.put(EARTHMATSURFICIAL_MATRIXMOD, " ");
		values.put(EARTHMATSURFICIAL_MATRIX, " ");
		values.put(EARTHMATSURFICIAL_JOINTING, " ");
		values.put(EARTHMATSURFICIAL_COMPACTION, " ");
		values.put(EARTHMATSURFICIAL_OXIDATION, " ");
		values.put(EARTHMATSURFICIAL_H2OCONTENT, " ");	            
		values.put(EARTHMATSURFICIAL_FISSILITY, " ");
		values.put(EARTHMATSURFICIAL_HCLREACT, " ");
		values.put(EARTHMATSURFICIAL_CLASTMODAL, " ");
		values.put(EARTHMATSURFICIAL_CLASTMIN, " ");
		values.put(EARTHMATSURFICIAL_CLASTMAX, " ");
		values.put(EARTHMATSURFICIAL_CLASTPCT, " ");
		values.put(EARTHMATSURFICIAL_CLASTFORM, " ");
		values.put(EARTHMATSURFICIAL_SORTING, " ");          
		values.put(EARTHMATSURFICIAL_MODALRND, " ");
		values.put(EARTHMATSURFICIAL_MAXROUND, " ");
		values.put(EARTHMATSURFICIAL_MINROUND, " ");
		values.put(EARTHMATSURFICIAL_THICKTYPE, " ");
		values.put(EARTHMATSURFICIAL_THICKMIN, " ");
		values.put(EARTHMATSURFICIAL_THICKMAX, " ");
		values.put(EARTHMATSURFICIAL_COLOUR, " ");
		values.put(EARTHMATSURFICIAL_LWRCONTACT, " ");
		values.put(EARTHMATSURFICIAL_INTCONTACT, " ");
		values.put(EARTHMATSURFICIAL_LATCONTACT, " ");
		values.put(EARTHMATSURFICIAL_ERRATICTYP, " ");	            
		values.put(EARTHMATSURFICIAL_ERRATICPER, " ");
		values.put(EARTHMATSURFICIAL_LANDFORM, " ");
		values.put(EARTHMATSURFICIAL_PRIMESTRUC, " ");
		values.put(EARTHMATSURFICIAL_SCNDSTRUC, " ");
		values.put(EARTHMATSURFICIAL_WAYUP, " ");
		values.put(EARTHMATSURFICIAL_NOTES, " ");
		values.put(EARTHMATSURFICIAL_INTERP, " ");
		values.put(EARTHMATSURFICIAL_INTERPCONF, " ");

		long rowID = dbHandler.insertRow(EARTHMATSURFICIAL_TABLE_NAME, null, values);

		earthmatsurficial.setNrcanId3((int)rowID);

		updateRow();
	}

	public void updateRow() {
		ContentValues values = new ContentValues();
		values.put(EARTHMATSURFICIAL_STATION_ID, earthmatsurficial.getStationId());
		values.put(EARTHMATSURFICIAL_EARTHMATLT,  earthmatsurficial.getEarthMatLt());
		values.put(EARTHMATSURFICIAL_EARTHMATNO,  earthmatsurficial.getEarthMatNo());
		values.put(EARTHMATSURFICIAL_EARTHMATID,  earthmatsurficial.getEarthMatId());
		values.put(EARTHMATSURFICIAL_LITHGROUP,  earthmatsurficial.getLithGroup());
		values.put(EARTHMATSURFICIAL_LITHTYPE,  earthmatsurficial.getLithType());
		values.put(EARTHMATSURFICIAL_LITHDETAIL,  earthmatsurficial.getLithDetail());
		values.put(EARTHMATSURFICIAL_MAPUNIT,  earthmatsurficial.getMapUnit());	
		values.put(EARTHMATSURFICIAL_SUFFORM, earthmatsurficial.getSufform());
		values.put(EARTHMATSURFICIAL_UNITNO, earthmatsurficial.getUnitNo());
		values.put(EARTHMATSURFICIAL_MATRIXMOD, earthmatsurficial.getMatrixMod());
		values.put(EARTHMATSURFICIAL_MATRIX, earthmatsurficial.getMatrix());
		values.put(EARTHMATSURFICIAL_JOINTING, earthmatsurficial.getJointing());
		values.put(EARTHMATSURFICIAL_COMPACTION, earthmatsurficial.getCompaction());
		values.put(EARTHMATSURFICIAL_OXIDATION, earthmatsurficial.getOxidation());
		values.put(EARTHMATSURFICIAL_H2OCONTENT, earthmatsurficial.getH2oContent());	            
		values.put(EARTHMATSURFICIAL_FISSILITY, earthmatsurficial.getFissilty());
		values.put(EARTHMATSURFICIAL_HCLREACT, earthmatsurficial.getHclReact());
		values.put(EARTHMATSURFICIAL_CLASTMODAL, earthmatsurficial.getClastModal());
		values.put(EARTHMATSURFICIAL_CLASTMIN, earthmatsurficial.getClastMin());
		values.put(EARTHMATSURFICIAL_CLASTMAX, earthmatsurficial.getClastMax());
		values.put(EARTHMATSURFICIAL_CLASTPCT, earthmatsurficial.getClastPct());
		values.put(EARTHMATSURFICIAL_CLASTFORM, earthmatsurficial.getClastForm());
		values.put(EARTHMATSURFICIAL_SORTING, earthmatsurficial.getSorting());          
		values.put(EARTHMATSURFICIAL_MODALRND, earthmatsurficial.getModalRnd());
		values.put(EARTHMATSURFICIAL_MAXROUND, earthmatsurficial.getMaxRound());
		values.put(EARTHMATSURFICIAL_MINROUND, earthmatsurficial.getMinRound());
		values.put(EARTHMATSURFICIAL_THICKTYPE, earthmatsurficial.getThickType());
		values.put(EARTHMATSURFICIAL_THICKMIN, earthmatsurficial.getThickMin());
		values.put(EARTHMATSURFICIAL_THICKMAX, earthmatsurficial.getThickMax());
		values.put(EARTHMATSURFICIAL_COLOUR, earthmatsurficial.getColour());
		values.put(EARTHMATSURFICIAL_LWRCONTACT, earthmatsurficial.getLwrContact());
		values.put(EARTHMATSURFICIAL_INTCONTACT, earthmatsurficial.getIntContact());
		values.put(EARTHMATSURFICIAL_LATCONTACT, earthmatsurficial.getLatContact());
		values.put(EARTHMATSURFICIAL_ERRATICTYP, earthmatsurficial.getErraticTyp());	            
		values.put(EARTHMATSURFICIAL_ERRATICPER, earthmatsurficial.getErraticPer());
		values.put(EARTHMATSURFICIAL_LANDFORM, earthmatsurficial.getLandForm());
		values.put(EARTHMATSURFICIAL_PRIMESTRUC, earthmatsurficial.getPrimeStruc());
		values.put(EARTHMATSURFICIAL_SCNDSTRUC, earthmatsurficial.getScndStruc());
		values.put(EARTHMATSURFICIAL_WAYUP, earthmatsurficial.getWayUp());
		values.put(EARTHMATSURFICIAL_NOTES, earthmatsurficial.getNotes());
		values.put(EARTHMATSURFICIAL_INTERP, earthmatsurficial.getInterp());
		values.put(EARTHMATSURFICIAL_INTERPCONF, earthmatsurficial.getInterpConf());

		String whereClause = EARTHMATSURFICIAL_NRCANID3 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(earthmatsurficial.getNrcanId3())
		};

		dbHandler.updateRow(EARTHMATSURFICIAL_TABLE_NAME, values, whereClause, whereArgs);
	}

	public EarthmatSurficialEntity getEntity() {
		return earthmatsurficial;
	}

	public static String getCreateTableStatement() {
		return EARTHMATSURFICIAL_TABLE_CREATE;
	}


}
