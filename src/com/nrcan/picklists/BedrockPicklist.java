package com.nrcan.picklists;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.values.PreparedStatements;

import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.regex.Pattern;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class BedrockPicklist extends PicklistDatabaseHandler implements PicklistInterface {
	private Map<String, Integer> bedrockFilenames;
	public Map<String, Integer> getBedrockFilenames() {
		return bedrockFilenames;
	}

	private String filePath;

	public BedrockPicklist(Context context, Map<String, Integer> bedrockFilenames, String filePath) {
		super(context);
		this.bedrockFilenames = bedrockFilenames;
		this.filePath = filePath;
	}

	// Write Bedrock functionality below
	public void createTables() {

		StringBuilder newSql = new StringBuilder();

		for(Map.Entry<String, Integer> entry : bedrockFilenames.entrySet()) {

			newSql.append("CREATE TABLE IF NOT EXISTS ");
			// set the table name
			String filename = (String)entry.getKey();
			// Delete the last 4 chars (file extension: .txt)
			newSql.append(filename.substring(0, filename.length() - 4)  + " (" + "id INTEGER PRIMARY KEY, ");

			// create the appropriate number of columns
			for(int i = 0; i < ((Integer)entry.getValue()).intValue(); i++) {

				newSql.append("col" + (i + 1) + " TEXT,");
			}

			super.execSQLStatement(newSql.toString().substring(0, newSql.length() - 1) + ")");
			newSql.delete(0, newSql.length());
		}
	}

	public void dropTables() {

		for(Map.Entry<String, Integer> entry : bedrockFilenames.entrySet()) {

			String tableName = (String)entry.getKey();
			super.execSQLStatement("DROP TABLE IF EXISTS " + tableName.substring(0, tableName.length() - 4));
		}
	}
	
	public void fillTable(Entry<String, Integer> entry) {
		// To be accessed in finally
		InputStream fileIS = null;
		BufferedReader input = null;

		//for(Map.Entry<String, Integer> entry : bedrockFilenames.entrySet()) {

			try {
				String filename = (String)entry.getKey();

				//fileIS = super.context.getAssets().open("LUT_BEDROCK/" + filename + ".txt");
				fileIS = new FileInputStream(filePath + "/" + filename);
				input = new BufferedReader(new InputStreamReader(fileIS));

				//consume the first line
				input.readLine();

				switch(((Integer)entry.getValue()).intValue()) {

				case 3: {

					Pattern pattern = Pattern.compile("\t"); // compiles regex string into a pattern
					String line = null;
					String[] cells = new String[3];

					SQLiteDatabase db = getWritableDatabase();
					SQLiteStatement s = db.compileStatement("INSERT INTO " + filename.substring(0, filename.length() - 4) + PreparedStatements.INSERT_3_COL);

					while ((line = input.readLine()) != null) {

						String[] cells2 = pattern.split(line, 0);
						System.arraycopy(cells2, 0, cells, 0, (cells2.length > 3) ? 3 : cells2.length);
						//System.out.println(((cells[0] == null) ? "" : cells[0]) + " -- " + ((cells[1] == null) ? "" : cells[1]) + " -- " + ((cells[2] == null) ? "" : cells[2]));
						s.bindString(1, (cells[0] == null) ? "" : cells[0]);
						s.bindString(2, (cells[1] == null) ? "" : cells[1]);
						s.bindString(3, (cells[2] == null) ? "" : cells[2]);
						s.execute();
					}

					db.close();
				}
				break;

				case 2: {

					Pattern pattern = Pattern.compile("\t");
					String line = null;
					String[] cells = new String[2];

					SQLiteDatabase db = getWritableDatabase();
					SQLiteStatement s = db.compileStatement("INSERT INTO " + filename.substring(0, filename.length() - 4) + PreparedStatements.INSERT_2_COL);

					while ((line = input.readLine()) != null) {
						String[] cells2 = pattern.split(line, 0);
						System.arraycopy(cells2, 0, cells, 0, (cells2.length > 2) ? 2 : cells2.length);
						//System.out.println(((cells[0] == null) ? "" : cells[0]) + " -- " + ((cells[1] == null) ? "" : cells[1]));
						s.bindString(1, (cells[0] == null) ? "" : cells[0]);
						s.bindString(2, (cells[1] == null) ? "" : cells[1]);
						s.execute();
					}

					db.close();
				}
				break;

				case 1: {

					String line = null;
					String[] cells = new String[1];

					SQLiteDatabase db = getWritableDatabase();
					SQLiteStatement s = db.compileStatement("INSERT INTO " + filename.substring(0, filename.length() - 4) + PreparedStatements.INSERT_1_COL);

					while ((line = input.readLine()) != null) {
						cells[0] = line;
						//System.out.println((cells[0] == null) ? "" : cells[0]);
						s.bindString(1, (cells[0] == null) ? "" : cells[0]);
						s.execute();
					}

					db.close();
				}
				break;

				default: break;
				}

				if(input != null) {
					input.close();
				}

				if(fileIS != null) {
					fileIS.close();
				}

			} catch(IOException ioe) {
				System.out.println(ioe.getCause().getMessage());
				//throw new IOException(ioe.getCause().getMessage());
			}
	}

	public void fillTables() {
		// To be accessed in finally
		InputStream fileIS = null;
		BufferedReader input = null;

		for(Map.Entry<String, Integer> entry : bedrockFilenames.entrySet()) {

			try {
				String filename = (String)entry.getKey();

				//fileIS = super.context.getAssets().open("LUT_BEDROCK/" + filename + ".txt");
				fileIS = new FileInputStream(filePath + "/" + filename);
				input = new BufferedReader(new InputStreamReader(fileIS));

				//consume the first line
				input.readLine();

				switch(((Integer)entry.getValue()).intValue()) {

				case 3: {

					Pattern pattern = Pattern.compile("\t"); // compiles regex string into a pattern
					String line = null;
					String[] cells = new String[3];

					SQLiteDatabase db = getWritableDatabase();
					SQLiteStatement s = db.compileStatement("INSERT INTO " + filename.substring(0, filename.length() - 4) + PreparedStatements.INSERT_3_COL);

					while ((line = input.readLine()) != null) {

						String[] cells2 = pattern.split(line, 0);
						System.arraycopy(cells2, 0, cells, 0, (cells2.length > 3) ? 3 : cells2.length);
						//System.out.println(((cells[0] == null) ? "" : cells[0]) + " -- " + ((cells[1] == null) ? "" : cells[1]) + " -- " + ((cells[2] == null) ? "" : cells[2]));
						s.bindString(1, (cells[0] == null) ? "" : cells[0]);
						s.bindString(2, (cells[1] == null) ? "" : cells[1]);
						s.bindString(3, (cells[2] == null) ? "" : cells[2]);
						s.execute();
					}

					db.close();
				}
				break;

				case 2: {

					Pattern pattern = Pattern.compile("\t");
					String line = null;
					String[] cells = new String[2];

					SQLiteDatabase db = getWritableDatabase();
					SQLiteStatement s = db.compileStatement("INSERT INTO " + filename.substring(0, filename.length() - 4) + PreparedStatements.INSERT_2_COL);

					while ((line = input.readLine()) != null) {
						String[] cells2 = pattern.split(line, 0);
						System.arraycopy(cells2, 0, cells, 0, (cells2.length > 2) ? 2 : cells2.length);
						//System.out.println(((cells[0] == null) ? "" : cells[0]) + " -- " + ((cells[1] == null) ? "" : cells[1]));
						s.bindString(1, (cells[0] == null) ? "" : cells[0]);
						s.bindString(2, (cells[1] == null) ? "" : cells[1]);
						s.execute();
					}

					db.close();
				}
				break;

				case 1: {

					String line = null;
					String[] cells = new String[1];

					SQLiteDatabase db = getWritableDatabase();
					SQLiteStatement s = db.compileStatement("INSERT INTO " + filename.substring(0, filename.length() - 4) + PreparedStatements.INSERT_1_COL);

					while ((line = input.readLine()) != null) {
						cells[0] = line;
						//System.out.println((cells[0] == null) ? "" : cells[0]);
						s.bindString(1, (cells[0] == null) ? "" : cells[0]);
						s.execute();
					}

					db.close();
				}
				break;

				default: break;
				}

				if(input != null) {
					input.close();
				}

				if(fileIS != null) {
					fileIS.close();
				}

			} catch(IOException ioe) {
				System.out.println(ioe.getCause().getMessage());
				//throw new IOException(ioe.getCause().getMessage());
			}
		}
	}

	public void setBedrockFilenames(Map<String, Integer> bedrockFilenames) {

		if(bedrockFilenames == null)
			this.bedrockFilenames = bedrockFilenames;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
