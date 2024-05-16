package com.example.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<Student> getAllStudents() {
        List<Student> employees = new ArrayList<Student>();
        List<Lecture> lectures = new ArrayList<Lecture>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT DISTINCT studentID, name, email, password FROM students");

            for (int i = 0; i < 6; i ++) {
                int studentID = rs.getInt("studentID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int password = rs.getInt(" password");

                Student e = new Student(studentID, name, password, email, lectures);

                employees.add(e);
            }

            rs.close();
            st.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
