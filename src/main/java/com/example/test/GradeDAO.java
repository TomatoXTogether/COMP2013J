package com.example.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {
    public static List<Grade> getGrade(int studentID){
        List<Grade> grades = new ArrayList<Grade>();

        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT lectureID, grade FROM students WHERE studentID = ?");
            ps.setInt(1, studentID);
            ResultSet rs = ps.executeQuery();
            //Statement st = conn.createStatement();

            //ResultSet rs = st.executeQuery("SELECT lectureID, grade FROM students WHERE studentID = " + studentID);

            while (rs.next()) {
                String lectureID = rs.getString("lectureID");
                String grade = rs.getString("grade");

                Lecture lecture = LectureDAO.getLectureByID(lectureID);

                if (lecture != null) {
                    String lectureName = lecture.getName();
                    Grade g = new Grade(lectureID, lectureName, grade);
                    grades.add(g);
                } else {
                    System.err.println("Lecture with ID " + lectureID + " not found for student ID " + studentID);
                }
            }

            rs.close();
            ps.close();
            //st.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grades;
    }

    public String getEveryGrade(int studentId, String lectureID){
        {
            try {
                Connection conn = JDBCTool.getConnection();

                PreparedStatement checkStmt = conn.prepareStatement("SELECT grade FROM students WHERE studentID = ? AND lectureID = ?");
                checkStmt.setInt(1, studentId);
                checkStmt.setString(2, lectureID);
                ResultSet rs = checkStmt.executeQuery();
                rs.next();

                String grade = rs.getString(1);

                checkStmt.close();
                conn.close();
                return grade;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
