package com.cydeo.jdbctests.day1;

import java.sql.*;

public class P01_JDBCIntro {

    public static void main(String[] args) throws SQLException {
        // connection string
        String dbUrl = "jdbc:oracle:thin:@54.237.36.94:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        // create the connection
        // DriverManger class getConnection Method will help to connect database

        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        // it will help us to execute queries
        Statement statement = conn.createStatement();

        // ResultSet will store data after execution/ it only stores data ( there is not table info)

        ResultSet rs = statement.executeQuery("select * from DEPARTMENTS where Manager_Id is not null");


        // 10- administration 200-1700
        while (rs.next()){
            System.out.println(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
        }

        // we can run multiple query in the same time

        rs = statement.executeQuery("select * from LOCATIONS");

        //1297 Via Cola di Rie - Roma
        System.out.println("---------------------------------");

        while(rs.next()){
            System.out.println(rs.getString(2)+" - "+ rs.getString(4));
        }


        //close connection
        rs.close();
        statement.close();
        conn.close();


    }
}