package com.nrcan.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.values.PreparedStatements;
import com.nrcan.entities.PhotoEntity;
import android.util.Log;
import java.util.ArrayList;

public class PhotoModel {

	private DatabaseHandler dbHandler;
	private final Context context;
    private PhotoEntity photo;

    // Table column keys
	private static final String PHOTO_TABLE_NAME = "photo";
	private static final String PHOTO_NRCANID3 = "nrcanId3";
	private static final String PHOTO_NRCANID2 = "nrcanId2";
	private static final String PHOTO_STATIONID = "stationId";
	private static final String PHOTO_PHOTOID = "photoId";
	private static final String PHOTO_PHOTONO = "photoNo";
	private static final String PHOTO_CATEGORY = "category";
	private static final String PHOTO_FILENO = "fileNo";
	private static final String PHOTO_FILENAME = "fileName";
	private static final String PHOTO_DIRECTION = "direction";
	private static final String PHOTO_CAPTION = "caption";
	private static final String PHOTO_LINKID = "linkId";

	private static final String PHOTO_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS photo (" +
				"md_id INTEGER PRIMARY KEY autoincrement, " +
				"md_prj_name TEXT, " +
				"nrcanId3 TEXT, " +
				"nrcanId2 TEXT, " +
				"stationId TEXT, " +
				"photoId TEXT, " +
				"photoNo TEXT, " +
				"category TEXT, " +
				"fileNo TEXT, " +
				"fileName TEXT, " +
				"direction TEXT, " +
				"caption TEXT, " +
				"linkId TEXT, " +
				");";

	public PhotoModel(Context context, DatabaseHandler dbHandler) {
		this.context = context;
        this.dbHandler = dbHandler;
	}

    public PhotoEntity readRow() {

        SQLiteDatabase database = dbHandler.getDatabase();

        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_FIRST_ROW, new String[] { PHOTO_TABLE_NAME, KEY_PHOTO_ID, String.valueOf(photo.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return new PhotoEntity(dbHandler.getSplitRow(0));
    }

    public ArrayList<PhotoEntity> readRows() {

        SQLiteDatabase database = dbHandler.getDatabase();
        
        database.beginTransaction();

        try {

            dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { PHOTO_TABLE_NAME });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        ArrayList<PhotoEntity> entities = new ArrayList<PhotoEntity>();

        int length = dbHandler.getList().size();
        
        for(int i = 0; i < length; i++) {
            entities.add(new PhotoEntity(dbHandler.getSplitRow(i)));   
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
        	values.put(PHOTO_NRCANID3, " ");
        	values.put(PHOTO_NRCANID2, " ");
        	values.put(PHOTO_STATIONID, " ");
        	values.put(PHOTO_PHOTOID, " ");
        	values.put(PHOTO_PHOTONO, " ");
        	values.put(PHOTO_CATEGORY, " ");
        	values.put(PHOTO_FILENO, " ");
        	values.put(PHOTO_FILENAME, " ");
        	values.put(PHOTO_DIRECTION, " ");
        	values.put(PHOTO_CAPTION, " ");
        	values.put(PHOTO_LINKID, " ");

            long rowID = database.insert(PHOTO_TABLE_NAME, null, values);
            photo.setID(String.valueOf(rowID));

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
            values.put(PHOTO_NRCANID3, photo.getNrcanId3());
        	values.put(PHOTO_NRCANID2, photo.getNrcanId2());
        	values.put(PHOTO_STATIONID, photo.getStationId());
        	values.put(PHOTO_PHOTOID, photo.getPhotoId());
        	values.put(PHOTO_PHOTONO, photo.getPhotoNo());
        	values.put(PHOTO_CATEGORY, photo.getCategory());
        	values.put(PHOTO_FILENO, photo.getFileNo());
        	values.put(PHOTO_FILENAME, photo.getFileName());
        	values.put(PHOTO_DIRECTION, photo.getDirection());
        	values.put(PHOTO_CAPTION, photo.getCaption());
        	values.put(PHOTO_LINKID, photo.getLinkId());

            rowsAffected = database.update(PHOTO_TABLE_NAME, values, KEY_PHOTO_ID + "=?",
                    new String[] { String.valueOf(photo.getID()) });

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
            rowsAffected = database.delete(PHOTO_TABLE_NAME, KEY_PHOTO_ID + "=?",
                    new String[] { String.valueOf(photo.getID()) });
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return rowsAffected;
    }

    public PhotoEntity getEntity() {
        return photo;
    }

    public void setEntity(String[] photo) {
        this.photo = new PhotoEntity(photo);
    }

    public static String getCreateTableStatement() {
        return PHOTO_TABLE_CREATE;
    }
}

