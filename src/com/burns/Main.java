package com.burns;

import com.burns.tables.States;
import com.burns.tables.Tours;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {

        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT tourId, tourName, price FROM tours " + "LIMIT 10, 3")
            ) {
            Tours.displayData(rs);

            /*rs.last();
            System.out.println("Number of rows: " + rs.getRow());
            rs.first();
            System.out.println("The first state is: " + rs.getString("stateName"));
            rs.last();
            System.out.println("The last state is: " + rs.getString("stateName"));
            rs.absolute(10);
            System.out.println("The tenth state is: " + rs.getString("stateName"));*/

        } catch (SQLException e) {
            DBUtil.processException(e);
        }
    }
}
