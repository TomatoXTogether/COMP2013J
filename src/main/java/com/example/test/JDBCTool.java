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
        return JDBCTool.getConnection("localhost", " LectureSystem", "root", "123456");
        //这里输入数据库的url，数据库名，用户名，密码
    }
}
