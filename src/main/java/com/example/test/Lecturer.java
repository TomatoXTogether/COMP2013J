package com.example.test;

public class Lecturer extends User{

    private int lecturerID;
    private String firstname;
    private String lastname;
    private int password;
    private String email;
    private String office;
    private boolean selected;

    public Lecturer() {
    }

    public Lecturer(int lecturerID, String firstname,  String lastname, int password, String email, String office) {
        super();
        this.lecturerID = lecturerID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.office = office;
        this.selected = false;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int getID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        System.out.println("Lecture " + getFirstname() + " isSelected: " + selected);
    }

}
