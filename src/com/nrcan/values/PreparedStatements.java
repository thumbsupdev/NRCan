package com.nrcan.values;

public final class PreparedStatements {
    public static final String READ_FIRST_ROW = " WHERE ? = ?";
    public static final String READ_ALL_ROWS1 = "SELECT * FROM ?";
    public static final String READ_ALL_ROWS2 = "SELECT * FROM ? WHERE ? = ?";
    public static final String INSERT_1_COL = " (col1) VALUES (?)";
    public static final String INSERT_2_COL = " (col1, col2) VALUES (?, ?)";
    public static final String INSERT_3_COL = " (col1, col2, col3) VALUES (?, ?, ?)";
}
