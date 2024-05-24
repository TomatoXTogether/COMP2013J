package com.example.test;

public class lectureStudent {
    private String lectureID;
    private String lectureName;
    private String studentName;
    private int studentID;
    private String email;
    private String grade;

    public lectureStudent(String lectureID, String lectureName,String studentName,  int studentID, String email, String grade) {
        this.lectureID = lectureID;
        this.lectureName = lectureName;
        this.studentID = studentID;
        this.email = email;
        this.studentName = studentName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
