package com.burns.tables;

import com.burns.DBType;
import com.burns.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatesMgr {

    public static void displayAllRows() throws SQLException {
        String sql = "SELECT adminId, userName, password FROM admin";

        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ){
            System.out.println("Admin Table: ");
            while (rs.next()) {
                String stateId = rs.getObject("stateId", String.class);
                String stateName = rs.getObject("stateName", String.class);

                System.out.println(stateId + ": " + stateName);
            }
        }
    }
}
