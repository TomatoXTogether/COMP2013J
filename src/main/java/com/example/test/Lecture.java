package com.example.test;

public class Lecture {

    private String lectureID;
    private int lecturerID;
    private String name;
    private int room;
    private int building;
    private String schedule;
    private String startDate;
    private String endDate;

    public Lecture() {
    }

    public Lecture(String lectureID, int lecturerID, String name, int room, int building, String schedule, String startDate, String endDate) {
        super();
        this.lectureID = lectureID;
        this.lecturerID = lecturerID;
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

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
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
}
