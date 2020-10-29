package com.company;

import java.sql.*;

public class JdbcQuary {


        static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
        static final String USER = "student";
        static final String PASS = "student";

        public static void main(String[] args) throws SQLException {
            Connection conn = null;
            Statement stmt = null;


            try {
                //Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Creating statement...");
                stmt = conn.createStatement();
                String sql;


                sql = "SELECT id,last_name FROM demo.employees";
                ResultSet rs = stmt.executeQuery(sql);


                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("last_name");
                //    String CountryCode = rs.getString("CountryCode");
                   // System.out.print("ID: " + id);
                    System.out.print(", Name: " + name);
                   // System.out.println(", Country Code " + CountryCode);

                }


                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
}
