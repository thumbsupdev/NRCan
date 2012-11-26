package com.nrcan.models;

import android.content.ContentValues;
import com.nrcan.main.DatabaseHandler;
import com.nrcan.entities.PhotoEntity;

public class PhotoModel {
	private DatabaseHandler dbHandler;
	private PhotoEntity photo;

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

	private static final String PHOTO_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + PHOTO_TABLE_NAME + " (" +
			PHOTO_NRCANID3 + " INTEGER PRIMARY KEY autoincrement," +
			PHOTO_NRCANID2 + " INTEGER," +
			PHOTO_STATIONID + " TEXT," +
			PHOTO_PHOTOID + " TEXT," +
			PHOTO_PHOTONO + " TEXT," +
			PHOTO_CATEGORY + " TEXT," +
			PHOTO_FILENO + " TEXT," +
			PHOTO_FILENAME + " TEXT," +
			PHOTO_DIRECTION + " TEXT," +
			PHOTO_CAPTION + " TEXT," +
			PHOTO_LINKID + " TEXT" +
			");";

	public PhotoModel(DatabaseHandler dbHandler) {
		this.dbHandler = dbHandler;
		this.dbHandler.createTable(getCreateTableStatement());
		this.photo = new PhotoEntity();
	}

	public void readRow() {
		String[] tmp = new String[] { String.valueOf(photo.getNrcanId3()) };
		dbHandler.executeQuery("SELECT * FROM " + PHOTO_TABLE_NAME + " WHERE " + PHOTO_NRCANID3 + " = ?", tmp);
		
		photo.setEntity(dbHandler.getList());
	}

	public void insertRow() {
		ContentValues values = new ContentValues();
		values.put(PHOTO_NRCANID2, 0);
		values.put(PHOTO_STATIONID, " ");
		values.put(PHOTO_PHOTOID, " ");
		values.put(PHOTO_PHOTONO, " ");
		values.put(PHOTO_CATEGORY, " ");
		values.put(PHOTO_FILENO, " ");
		values.put(PHOTO_FILENAME, " ");
		values.put(PHOTO_DIRECTION, " ");
		values.put(PHOTO_CAPTION, " ");
		values.put(PHOTO_LINKID, " ");

		long rowID = dbHandler.insertRow(PHOTO_TABLE_NAME, null, values);

		photo.setNrcanId3((int)rowID);

		updateRow();
	}

	public void updateRow() {
		ContentValues values = new ContentValues();
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

		String whereClause = PHOTO_NRCANID3 + " = ?";
		String[] whereArgs = new String[] {
				String.valueOf(photo.getNrcanId3())
		};

		dbHandler.updateRow(PHOTO_TABLE_NAME, values, whereClause, whereArgs);
	}

	public PhotoEntity getEntity() {
		return photo;
	}

	public static String getCreateTableStatement() {
		return PHOTO_TABLE_CREATE;
	}
}

