package com.example.test;


public class Lecture {

    private String lectureID;
    private String lecturerName;
    private String name;
    private int room;
    private int building;
    private String schedule;
    private String startDate;
    private String endDate;
    private boolean selected;
    private String grade;


    public Lecture() {
    }

    public Lecture(String lectureID, String lecturerName, String name, int room, int building, String schedule, String startDate, String endDate) {
        super();
        this.lectureID = lectureID;
        this.lecturerName = lecturerName;
        this.name = name;
        this.room = room;
        this.building = building;
        this.schedule = schedule;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getLectureID() {
        return lectureID;
    }

    public void setLectureID(String lectureID) {
        this.lectureID = lectureID;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerName = lecturerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String start) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String end) {
        this.endDate = endDate;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
