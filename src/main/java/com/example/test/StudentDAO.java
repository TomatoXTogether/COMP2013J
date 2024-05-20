package com.example.test;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<User> getAllStudents() {
        List<User> users = new ArrayList<User>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT DISTINCT studentID, name, email, password FROM students");

            while (rs.next()) {
                int studentID = rs.getInt("studentID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int password = rs.getInt("password");

                Student e = new Student(studentID, name, password, email);

                users.add(e);
            }

            rs.close();
            st.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    //以下三类用于更新学生所选课程
    //getAllLectures: 用于显示学生所选课程
    //selectLecture: 用于添加学生所选课程
    //cancelLecture: 用于删除学生所选课程
    public static List<Lecture> getAllLectures(Student student) {
        List<Lecture> lectures = new ArrayList<Lecture>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT lectureID FROM students WHERE studentID =" + student.getID());

            while (rs.next()) {
                int lectureID = rs.getInt("lectureID");
                Lecture lecture = LectureDAO.getLectureByID(lectureID);

                lectures.add(lecture);
        }
            rs.close();
            st.close();
            conn.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return lectures;
    }

    public List<Lecture> selectLecture(Student student, Lecture lecture) {
        List<Lecture> lectures = getAllLectures(student);
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (studentID, lectureID, name, email, password, grade) VALUES (?, ?, ?, ?, ?, ?);");

            stmt.setInt(1, student.getID());
            stmt.setString(2, lecture.getLectureID() );
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getEmail());
            stmt.setInt(5, student.getPassword());
            stmt.setString(6, "null");
            stmt.executeUpdate();

            lectures.add(lecture);

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lectures;
    }

    public static List<Lecture> cancelLecture(Student student, Lecture lecture) {
        List<Lecture> lectures = getAllLectures(student);
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            st.executeUpdate("DELETE from students where lectureID = " + lecture.getLecturerID());
            lectures.remove(lecture);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lectures;
    }
}
