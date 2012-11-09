package com.nrcan.values;

public final class PreparedStatements {
    
    public static final String READ_FIRST_ROW = "SELECT * FROM ? WHERE ?=?";
    public static final String READ_ALL_ROWS1 = "SELECT * FROM ?";
    public static final String READ_ALL_ROWS2 = "SELECT * FROM ? WHERE ? = ?";
}
