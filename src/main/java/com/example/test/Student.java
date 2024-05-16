package com.example.test;

public class Student {
    private int studentID;
    private String name;
    private String password;
    private String email;

    public Student(int studentID, String name, String password, String email){
        this.studentID = studentID;
        this.name = name;
        this.password = password;
        this.email = email;

        JDBCTool.getConnection();
    }

    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
