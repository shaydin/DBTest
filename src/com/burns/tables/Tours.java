package com.burns.tables;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {
    public static void displayData(ResultSet rs, int nRows) throws SQLException {
        while(rs.next()) {
            StringBuffer buffer = new StringBuffer();

        // rs.last();
        // int nRows = rs.getRow();
        if (nRows == 0){
            System.out.println("No tours found.");
        } else {
            System.out.println("Number of tours: " + nRows);
            rs.beforeFirst();

            buffer.append("Tour " + tourId + ": ");
            buffer.append(tourName);

            NumberFormat nf = NumberFormat.getCurrencyInstance();
            String formattedPrice = nf.format(price);
            buffer.append(" (" + formattedPrice + ")");

            System.out.println(buffer.toString());
        }
    }
}
