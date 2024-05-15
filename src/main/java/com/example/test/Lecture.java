package com.example.test;

public class Lecture {

    private int lectureID;
    private int lecturerID;
    private String name;
    private int room;
    private int building;
    private String schedule;
    private String start;
    private String end;

    public Lecture() {
    }

    public Lecture(int lectureID, int lecturerID, String name, int room, int building, String schedule, String start, String end) {
        super();
        this.lectureID = lectureID;
        this.lecturerID = lecturerID;
        this.name = name;
        this.room = room;
        this.building = building;
        this.schedule = schedule;
        this.start = start;
        this.end = end;
    }

    public int getLectureID() {
        return lectureID;
    }

    public void setLectureID(int lectureID) {
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
