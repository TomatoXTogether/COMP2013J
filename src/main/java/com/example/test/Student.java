package com.example.test;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    private int studentID;
    private String name;
    private int password;
    private String grade;
    private String email;
    public List<Lecture> lectures = new ArrayList<>();
    private String lectureName;

    public Student(int studentID, String name, int password, String email){
        this.studentID = studentID;
        this.name = name;
        this.password = password;
        this.email = email;

        JDBCTool.getConnection();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return studentID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLectureName(){
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public void setID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
