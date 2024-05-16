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

            while (rs.next()) {
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

    public static Student getStudent(int studentID) {
        Student student = null;
        for (Student e : StudentDAO.getAllStudents()) {
            if (e.getStudentID() == studentID) {
                student = e;
                break;
            }
        }
        return student;
    }

    public static void addStudent(Student student) {
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO students VALUES (" + student.getStudentID() + ", '" + student.getName() + "', '" + student.getEmail() + "', " + student.getPassword() + ")");
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}


}
