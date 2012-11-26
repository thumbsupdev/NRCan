package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.entities.StructureEntity;

public class StructureModel {
	private DatabaseHandler dbHandler;
	private StructureEntity structure;

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

	private static final String STRUCTURE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + STRUCTURE_TABLE_NAME + " (" +
			STRUCTURE_NRCANID4 + " INTEGER PRIMARY KEY autoincrement, " +
			STRUCTURE_NRCANID3 + " INTEGER," +
			STRUCTURE_STATIONID + " TEXT," +
			STRUCTURE_EARTHMATID + " TEXT," +
			STRUCTURE_STRUCTID + " TEXT," +
			STRUCTURE_STRUCTNO + " TEXT," +
			STRUCTURE_STRUCCLASS + " TEXT," +
			STRUCTURE_STRUCTYPE + " TEXT," +
			STRUCTURE_DETAIL + " TEXT," +
			STRUCTURE_METHOD + " TEXT," +
			STRUCTURE_FORMAT + " TEXT," +
			STRUCTURE_ATTITUDE + " TEXT," +
			STRUCTURE_YOUNGING + " TEXT," +
			STRUCTURE_GENERATION + " TEXT," +
			STRUCTURE_STRAIN + " TEXT," +
			STRUCTURE_FLATTENING + " TEXT," +
			STRUCTURE_RELATED + " TEXT," +
			STRUCTURE_FABRIC + " TEXT," +
			STRUCTURE_SENSE + " TEXT," +
			STRUCTURE_AZIMUTH + " TEXT," +
			STRUCTURE_DIPPLUNGE + " TEXT," +
			STRUCTURE_SYMANG + " TEXT," +
			STRUCTURE_NOTES + " TEXT" +	
			");";

	public StructureModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.structure = new StructureEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { String.valueOf(structure.getNrcanId4()) };
		dbHandler.executeQuery("SELECT * FROM " + STRUCTURE_TABLE_NAME + " WHERE " + STRUCTURE_NRCANID4 + " = ?", tmp);
		
		structure.setEntity(dbHandler.getList());
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(STRUCTURE_NRCANID3, 0);
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

		long rowID = dbHandler.insertRow(STRUCTURE_TABLE_NAME, null, values);

		structure.setNrcanId4((int) rowID);

		updateRow();
	}

	public void updateRow() {
		ContentValues values = new ContentValues();
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

		String whereClause = STRUCTURE_NRCANID4 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(structure.getNrcanId4())
		};

		dbHandler.updateRow(STRUCTURE_TABLE_NAME, values, whereClause, whereArgs);
	}

	public StructureEntity getEntity() {
		return structure;
	}

	public static String getCreateTableStatement() {
		return STRUCTURE_TABLE_CREATE;
	}
}
