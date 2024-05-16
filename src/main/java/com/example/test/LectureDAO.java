package com.example.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LectureDAO {
    public static List<Lecture> getAllLectures() {
        List<Lecture> lectures = new ArrayList<Lecture>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM lecture");

            while(rs.next()) {
                int lectureID = rs.getInt("lectureID");
                int lecturerID = rs.getInt("lecturerID");
                String name = rs.getString("name");
                int room = rs.getInt("room");
                int building = rs.getInt("building");
                String schedule = rs.getString("schedule");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");

                Lecture e = new Lecture(lectureID, lecturerID, name, room, building, schedule, startDate, endDate);

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
}
