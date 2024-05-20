package com.example.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    // 显示老师所教课程
    public static List<Lecture> getAllLectures(Lecturer lecturer) {
        List<Lecture> lectures = new ArrayList<Lecture>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT lectureID FROM lecturer WHERE lecturerID =" + lecturer.getID());

            while (rs.next()) {
                String lectureID = rs.getString("lectureID");
                Lecture lecture = LectureDAO.getLectureByID(lectureID);

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

    // 打印出老师教的课程
    public static void printAllLecturers(Lecturer lecturer) {
        List<Lecture> lectures = getAllLectures(lecturer);

        for (Lecture lecture : lectures) {
            System.out.println("\tLecture ID: " + lecture.getLectureID());
            System.out.println("\tLecture Name: " + lecture.getName());
            System.out.println("\tRoom: " + lecture.getRoom());
            System.out.println("\tBuilding: " + lecture.getBuilding());
            System.out.println("\tSchedule: " + lecture.getSchedule());
            System.out.println("\tStart Date: " + lecture.getStartDate());
            System.out.println("\tEnd Date: " + lecture.getEndDate());
            System.out.println();
        }

    }

}
