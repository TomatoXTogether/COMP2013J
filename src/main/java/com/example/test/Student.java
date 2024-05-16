package com.example.test;

public class Student {
    private int studentID;
    private int lectureID;
    private String name;
    private String email;
    private int password;
    private String grade;

    public Student() {
    }

    public Student(int studentID, int lectureID, String name, String email, int password, String grade) {
        super();
        this.studentID = studentID;
        this.lectureID = lectureID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getLectureID() {
        return lectureID;
    }

    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

