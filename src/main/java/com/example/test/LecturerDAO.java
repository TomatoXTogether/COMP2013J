package com.example.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LecturerDAO {
    public static List<Lecturer> getAllLecturers() {
        List<Lecturer> lectures = new ArrayList<Lecturer>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT lectureID FROM lecturer");

            while (rs.next()) {
                String lectureID = rs.getString("lectureID");
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

    public static Lecturer getLecturerByID(int lecturerID) {
        User lecturer = null;
        for (User l : getAllLecturers()) {
            if (l.getID() == lecturerID) {
                lecturer = l;
                break;
            }
        }
        return (Lecturer) lecturer;
    }

    public static void insertLecturer(Lecturer lecturer) {
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO lecturer VALUES (" + lecturer.getID() + ", '" + lecturer.getFirstname() + "', '" + lecturer.getLastname() + "', "
                    + lecturer.getPassword() + "', '" + lecturer.getEmail() + "', '" + lecturer.getOffice() + ")");
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteLecturerByID(int lecturerID) {
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("DELETE FROM lecturer WHERE lecturerID = " + lecturerID);
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
