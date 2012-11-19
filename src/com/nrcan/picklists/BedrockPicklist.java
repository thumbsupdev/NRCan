package com.nrcan.picklists;

import com.nrcan.main.PicklistDatabaseHandler;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import android.content.Context;

public class BedrockPicklist extends PicklistDatabaseHandler implements PicklistInterface {
    
    // Store a reference to the hashmap
    private Map<String, Integer> bedrockFilenames;

    public BedrockPicklist(Context context, Map<String, Integer> bedrockFilenames) {
		super(context);
        this.bedrockFilenames = bedrockFilenames;
    }

    // Write Bedrock functionality below
    public void createTables() {

        StringBuilder newSql = new StringBuilder();

        for(Map.Entry<String, Integer> entry : bedrockFilenames.entrySet()) {

            newSql.append("CREATE TABLE IF NOT EXISTS ");
            // set the table name
            newSql.append((String)entry.getKey() + " (" + "id INTEGER PRIMARY KEY, ");

            // create the appropriate number of columns
            for(int i = 0; i < ((Integer)entry.getValue()).intValue(); i++) {

                newSql.append("col" + (i + 1) + " TEXT,");
            }

            super.execSQLStatement(newSql.toString().substring(0, newSql.length() - 1) + ")");
        }
    }

    public void dropTables() {

        for(Map.Entry<String, Integer> entry : bedrockFilenames.entrySet())
            super.execSQLStatement("DROP TABLE IF EXISTS " + (String)entry.getKey());
    }

    public void fillTables() {
        
        // To be accessed in finally
        InputStream fileIS = null;
        BufferedReader input = null;

        for(Map.Entry<String, Integer> entry : bedrockFilenames.entrySet()) {

            try {
                String filename = (String)entry.getKey();

                fileIS = super.context.getAssets().open("LUT_BEDROCK/" + filename + ".txt");
                input = new BufferedReader(new InputStreamReader(fileIS));

                //consume the first line
                input.readLine();

                switch(((Integer)entry.getValue()).intValue()) {

                    case 3: {

                                Pattern pattern = Pattern.compile("\t"); // compiles regex string into a pattern
                                String line = null;
                                String[] cells = new String[3];

                                while ((line = input.readLine()) != null) {

                                    String[] cells2 = pattern.split(line, 0);
                                    System.arraycopy(cells2, 0, cells, 0, (cells2.length > 3) ? 3 : cells2.length);
                                    
                                    super.execSQLStatement("INSERT INTO " + filename + " (" + "col1, col2, col3) VALUES " + "('"
                                            + ((cells[0] == null) ? "" : cells[0]) + "', '" + ((cells[1] == null) ? "" : cells[1])
                                            + "', '" + ((cells[2] == null) ? "" : cells[2]) + "')");
                                }
                    }
                    break;

                    case 2: {

                                Pattern pattern = Pattern.compile("\t");
                                String line = null;
                                String[] cells = new String[2];

                                while ((line = input.readLine()) != null) {

                                    String[] cells2 = pattern.split(line, 0);
                                    System.arraycopy(cells2, 0, cells, 0, (cells2.length > 2) ? 2 : cells2.length);

                                    super.execSQLStatement("INSERT INTO " + filename + " (" + "col1, col2) VALUES " + "('"
                                            + ((cells[0] == null) ? "" : cells[0]) + "', '" + ((cells[1] == null) ? "" : cells[1]) + "')");
                                }
                    }
                    break;

                    case 1: {

                                String line = null;

                                while ((line = input.readLine()) != null) {

                                    super.execSQLStatement("INSERT INTO " + filename + " (" + "col1) VALUES "
                                        + "('" + line + "')");
                                }
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
        this.bedrockFilenames = bedrockFilenames;
    }
}
