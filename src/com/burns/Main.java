package com.burns;

import com.burns.tables.States;
import com.burns.tables.Tours;
import com.burns.utils.InputHelper;

import java.sql.*;

public class Main {

    //?s are placeholders for SQL
    public static final String SQL = "{call GetToursByPrice(?)}";

    public static void main(String[] args) throws SQLException {

        double maxPrice;
        try {
            maxPrice = InputHelper.getDoubleInput("Enter a maximum price: ");
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number.");
            return;
        }
        ResultSet rs = null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement stmt = conn.prepareCall(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ) {

            //Make sure to use the right data type here
            stmt.setDouble(1, maxPrice);
            rs = stmt.executeQuery();
            Tours.displayData(rs);
        } catch (SQLException e) {
            DBUtil.processException(e);
        }finally {
            if(rs != null) rs.close();
        }
    }
}
