package com.burns.tables;

import com.burns.DBType;
import com.burns.DBUtil;
import com.burns.beans.Admin;

import java.sql.*;

public class AdminMgr {

    public static void displayAllRows() throws SQLException {
        String sql = "SELECT adminId, userName, password FROM admin";

        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                ){
            System.out.println("Admin Table: ");
            while (rs.next()) {
                int adminId = rs.getObject("adminId", Integer.class);
                String userName = rs.getObject("userName", String.class);
                String password = rs.getObject("password", String.class);

                StringBuffer bf = new StringBuffer();
                bf.append(adminId + ": ");
                bf.append(userName + ", ");
                bf.append(password );
                System.out.println(bf.toString());
            }
        }
    }

    public static Admin getRow (int adminId) throws SQLException {
        String sql = "SELECT * FROM admin WHERE adminId = ?";
        ResultSet rs = null;

        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, adminId);
            rs = stmt.executeQuery();

            if(rs.next()) {
                Admin bean = new Admin();
                bean.setAdminId(adminId);
                bean.setUserName(rs.getString("userName"));
                bean.setPassword(rs.getString("password"));
                return bean;
            } else {
                return null;
            }


        } catch (SQLException e){
            System.err.println(e);
            return null;

        } finally {
            if (rs != null){
                rs.close();
            }
        }
    }
}
