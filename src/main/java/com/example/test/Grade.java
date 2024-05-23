package com.example.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Grade {

        String lectureID;
        String lectureName;
        String grade;

        public Grade(String lectureID, String lectureName, String grade){
        this.lectureID = lectureID;
        this.lectureName = lectureName;
        this.grade = grade;
    }
        public Grade(){

    }

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getLectureID() {
        return lectureID;
    }
    public void setLectureID(String lectureID) {
        this.lectureID = lectureID;
    }
    public String getLectureName() {
        return lectureName;
    }
    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }
}
