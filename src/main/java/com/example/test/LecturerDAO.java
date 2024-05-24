package com.example.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LecturerDAO {
    public static List<User> getAllLecturers() {
        List<User> lecturers = new ArrayList<User>();

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

    public static List<Lecture> getAllLecturerCourses(Lecturer lecturer){
        //得到老师所教的课的id
        int id=lecturer.getID();
        List<Lecture> lectures = new ArrayList<Lecture>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM lectures WHERE lecturerID =" + lecturer.getID());

            while (rs.next()) {
                String lectureID = rs.getString("lectureID");
                String lecturerName = lecturer.getFirstname();
                String name = rs.getString("name");
                int room = rs.getInt("room");
                int building = rs.getInt("building");
                String schedule = rs.getString("schedule");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                //String grade = rs.getString("grade");
                Lecture e = new Lecture(lectureID,lecturerName, name, room, building, schedule, startDate, endDate );
                lectures.add(e);

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

    public static void registerStudent(Lecturer lecturer) {

        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lecturer (lecturerID, firstname, lastname, email, office, password) VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, lecturer.getID());
            stmt.setString(2,  lecturer.getLastname());
            stmt.setString(3, lecturer.getFirstname());
            stmt.setString(4, lecturer.getEmail());
            stmt.setString(5, lecturer.getOffice());
            stmt.setInt(6, lecturer.getPassword());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}