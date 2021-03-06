package com.company;

import java.sql.*;

public class Practise2 {


    static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
    static final String USER = "student";
    static final String PASS = "student";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;


        try {

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id,last_name,first_name FROM demo.employees";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String ls = rs.getString("last_name");
                String fn = rs.getString("first_name");
                System.out.println("id" + id  + " ,");
                System.out.println("last_name" + ls + ", ");
                System.out.println("fisrt_name " + fn);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}





