package com.nrcan.values;

public final class PreparedStatements {
    
    public static final String READ_FIRST_ROW = "SELECT TOP 1 * FROM ? WHERE ?=?";
    public static final String READ_ALL_ROWS = "SELECT * from ?"; 
}
