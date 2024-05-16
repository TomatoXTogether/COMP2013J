package com.example.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LecturerDAO {
    public static List<Lecturer> getAllLecturers() {
        List<Lecturer> lecturers = new ArrayList<Lecturer>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM lecturer");

            while (rs.next()) {
                int lecturerID = rs.getInt("lecturerID");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                int password = rs.getInt("password");
                String email = rs.getString("email");
                String office = rs.getString("office");

                Lecturer e = new Lecturer(lecturerID, firstname, lastname, password, email, office);

                lecturers.add(e);
            }

            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lecturers;
    }

    public static Lecturer getLecturerByID(int lecturerID) {
        Lecturer lecturer = null;
        for (Lecturer l : getAllLecturers()) {
            if (l.getLecturerID() == lecturerID) {
                lecturer = l;
                break;
            }
        }
        return lecturer;
    }

    public static void insertLecturer(Lecturer lecturer) {
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO lecturer VALUES (" + lecturer.getLecturerID() + ", '" + lecturer.getFirstname() + "', '" + lecturer.getLastname() + "', "
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
