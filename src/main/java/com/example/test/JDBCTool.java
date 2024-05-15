package com.example.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTool {
    public static Connection getConnection(String url, String dbname, String username, String password) {
    Connection conn = null;
    try {
        conn = DriverManager.getConnection("jdbc:mysql://"+url+"/"+dbname+"?" + "user="+username+"&password="+password);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conn;
}
    public static Connection getConnection() {
        return JDBCTool.getConnection("localhost", "learningmanagementsystem", "root", "123456");
    }
}
