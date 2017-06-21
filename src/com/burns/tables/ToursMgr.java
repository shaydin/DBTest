package com.burns.tables;

import com.burns.DBType;
import com.burns.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

public class ToursMgr {

    public static void displayAllRows() throws SQLException {
        String sql = "SELECT adminId, userName, password FROM admin";

        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ){
            System.out.println("Admin Table: ");
            while (rs.next()) {
                int tourId = rs.getObject("tourId", Integer.class);
                String tourName = rs.getObject("tourName", String.class);
                StringBuffer buffer = new StringBuffer();
                BigDecimal price = rs.getObject("price", BigDecimal.class);

                buffer.append("Tour " + tourId + ": " );
                buffer.append(tourName);

                NumberFormat nf = NumberFormat.getCurrencyInstance().getCurrencyInstance();
                String formattedPrice = nf.format(price);
                buffer.append(" (" + formattedPrice + ")");

                System.out.println(buffer.toString());
            }
        }
    }
}
