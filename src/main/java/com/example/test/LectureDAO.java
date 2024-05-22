package com.example.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.test.LecturerDAO.getAllLecturers;


public class LectureDAO {
    public static List<Lecture> getAllLectures() {
        List<Lecture> lectures = new ArrayList<Lecture>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM lectures");

            while(rs.next()) {
                String lectureID = rs.getString("lectureID");
                int lecturerID = rs.getInt("lecturerID");
                String name = rs.getString("name");
                int room = rs.getInt("room");
                int building = rs.getInt("building");
                String schedule = rs.getString("schedule");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");

                String lectureName = getLecturerNameByID(lecturerID);

                Lecture e = new Lecture(lectureID, lectureName, name, room, building, schedule, startDate, endDate);

                lectures.add(e);
            }

            rs.close();
            st.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lectures;
    }


    public static Lecture getLectureByID(String lectureID) {
        for (Lecture l : getAllLectures()) {
            if (l.getLectureID().equals(lectureID)) {
                return l;
            }
        }
        return null;
    }

    public static String getLecturerNameByID(int lecturerID){
        for (User l : getAllLecturers()) {
            if (l.getID() == (lecturerID)) {
                return ((Lecturer)l).getFirstname() + " " + ((Lecturer)l).getLastname();

            }
        }
        return null;
    }

    public static void insertLecture(Lecture lecture) {
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO lecture VALUES (" + lecture.getLectureID() + ", '" + lecture.getLecturerName() + "', '" + lecture.getName() + "', "
                    + lecture.getRoom() + "', '" + lecture.getBuilding() + "', '" + lecture.getSchedule() + "', '" + lecture.getStartDate() + "', '" + lecture.getEndDate() + ")");
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteLectureByID(String lectureID) {
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("DELETE FROM lecture WHERE lectureID = " + lectureID);
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Lecture> getLecturesByLecturerID(String lecturerID) {
        List<Lecture> lectures = new ArrayList<>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lectures WHERE lecturerID = " + lecturerID);

            while (rs.next()) {
                String lectureID = rs.getString("lectureID");
                String name = rs.getString("name");
                int room = rs.getInt("room");
                int building = rs.getInt("building");
                String schedule = rs.getString("schedule");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");

                Lecture lecture = new Lecture(lectureID, lecturerID, name, room, building, schedule, startDate, endDate);
                lectures.add(lecture);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lectures;
    }


}
