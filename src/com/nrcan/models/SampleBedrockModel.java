package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.MetadataEntity;
import com.nrcan.entities.SampleBedrockEntity;
import android.util.Log;
import java.util.ArrayList;

public class SampleBedrockModel {

	private DatabaseHandler dbHandler;
	private final Context context;
    private SampleBedrockEntity sampleBedrock;

    // Table column keys
	private static final String SAMPLEBEDROCK_TABLE_NAME = "sampleBedrock";
	private static final String SAMPLEBEDROCK_NRCANID4 = "nrcanId4";
	private static final String SAMPLEBEDROCK_NRCANID3 = "nrcanId3";
	private static final String SAMPLEBEDROCK_STATIONID = "stationId";
	private static final String SAMPLEBEDROCK_EARTHMATID = "earthMatId";
	private static final String SAMPLEBEDROCK_SAMPLENO = "sampleNo";
	private static final String SAMPLEBEDROCK_SAMPLETYPE = "sampleType";
	private static final String SAMPLEBEDROCK_PURPOSE = "purpose";
	private static final String SAMPLEBEDROCK_FORMAT = "format";
	private static final String SAMPLEBEDROCK_AZIMUTH = "azimuth";
	private static final String SAMPLEBEDROCK_DIPPLUNGE = "dipplunge";
	private static final String SAMPLEBEDROCK_SURFACE = "surface";
	private static final String SAMPLEBEDROCK_NOTES = "notes";

	private static final String SAMPLEBEDROCK_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS sampleBedrock (" +
				"nrcanId4 INTEGER PRIMARY KEY autoincrement, " +
				"nrcanId3 INTEGER, " +
				"stationId TEXT, " +
				"earthMatId TEXT, " +
				"sampleNo TEXT, " +
				"sampleType TEXT, " +
				"purpose TEXT, " +
				"format TEXT, " +
				"azimuth TEXT, " +
				"dipplunge TEXT, " +
				"surface TEXT, " +
				"notes TEXT, " +
				");";

	public SampleBedrockModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}

	public void readRow() {
    	String[] tmp = new String[] { SAMPLEBEDROCK_TABLE_NAME, SAMPLEBEDROCK_NRCANID4, String.valueOf(sampleBedrock.getNrcanId4()) };
        dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, tmp);
        
        sampleBedrock.setEntity(dbHandler.getSplitRow(0));
    }

    public void insertRow() {
    	
        ContentValues values = new ContentValues();
        values.put(SAMPLEBEDROCK_NRCANID4, " ");
    	values.put(SAMPLEBEDROCK_NRCANID3, " ");
    	values.put(SAMPLEBEDROCK_STATIONID, " ");
    	values.put(SAMPLEBEDROCK_EARTHMATID, " ");
    	values.put(SAMPLEBEDROCK_SAMPLENO, " ");
    	values.put(SAMPLEBEDROCK_SAMPLETYPE, " ");
    	values.put(SAMPLEBEDROCK_PURPOSE, " ");
    	values.put(SAMPLEBEDROCK_FORMAT, " ");
    	values.put(SAMPLEBEDROCK_AZIMUTH, " ");
    	values.put(SAMPLEBEDROCK_DIPPLUNGE, " ");
    	values.put(SAMPLEBEDROCK_SURFACE, " ");
    	values.put(SAMPLEBEDROCK_NOTES, " ");

        	long rowID = dbHandler.insertRow(SAMPLEBEDROCK_TABLE_NAME, null, values);

    		sampleBedrock.setNrcanId4((int)rowID);

    		updateRow();
    }

    public void updateRow() {

        ContentValues values = new ContentValues();
        values.put(SAMPLEBEDROCK_NRCANID4, sampleBedrock.getNrcanId4());
    	values.put(SAMPLEBEDROCK_NRCANID3, sampleBedrock.getNrcanId3());
    	values.put(SAMPLEBEDROCK_STATIONID, sampleBedrock.getStationId());
    	values.put(SAMPLEBEDROCK_EARTHMATID, sampleBedrock.getEarthMatId());
    	values.put(SAMPLEBEDROCK_SAMPLENO, sampleBedrock.getSampleNo());
    	values.put(SAMPLEBEDROCK_SAMPLETYPE, sampleBedrock.getSampleType());
    	values.put(SAMPLEBEDROCK_PURPOSE, sampleBedrock.getPurpose());
    	values.put(SAMPLEBEDROCK_FORMAT, sampleBedrock.getFormat());
    	values.put(SAMPLEBEDROCK_AZIMUTH, sampleBedrock.getAzimuth());
    	values.put(SAMPLEBEDROCK_DIPPLUNGE, sampleBedrock.getDipplunge());
    	values.put(SAMPLEBEDROCK_SURFACE, sampleBedrock.getSurface());
    	values.put(SAMPLEBEDROCK_NOTES, sampleBedrock.getNotes());

    	String whereClause = SAMPLEBEDROCK_NRCANID4 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(sampleBedrock.getNrcanId4())
				};
		
		dbHandler.updateRow(SAMPLEBEDROCK_TABLE_NAME, values, whereClause, whereArgs);
    }

    public SampleBedrockEntity getEntity() {
		return sampleBedrock;
	}

	public static String getCreateTableStatement() {
		return SAMPLEBEDROCK_TABLE_CREATE;
	}
}

