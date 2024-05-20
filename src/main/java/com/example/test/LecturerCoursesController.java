package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LecturerCoursesController {

    @FXML
    private TableView<?> LectureTable;

    @FXML
    private Button back;

    @FXML
    private TableColumn<?, ?> building;

    @FXML
    private Button check;

    @FXML
    private TableColumn<?, ?> checkBox;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<?, ?> endDate;

    @FXML
    private TextField input;

    @FXML
    private Button lectureChoosing;

    @FXML
    private TableColumn<?, ?> lectureID;

    @FXML
    private TableColumn<?, ?> lecturer;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private Button newLecture;

    @FXML
    private Button refresh;

    @FXML
    private TableColumn<?, ?> room;

    @FXML
    private Button save;

    @FXML
    private TableColumn<?, ?> schedule;

    @FXML
    private TableColumn<?, ?> startDate;

    @FXML
    private  Lecturer userInfo;

    public void LecturerCoursesController(Lecturer userInfo){
        //空构造器
    }

    public void setLecturerInfo(Lecturer userInfo){
        this.userInfo = userInfo;
    }

    @FXML
    void backBottonAction(ActionEvent event) {

    }

    @FXML
    void checkBottonAction(ActionEvent event) {

    }

    @FXML
    void deleteBottonAction(ActionEvent event) {

    }

    @FXML
    void inputBottonAction(ActionEvent event) {

    }

    @FXML
    void lectureChoosingAction(ActionEvent event) {

    }

    @FXML
    void refreshBottonAction(ActionEvent event) {

    }

    @FXML
    void saveBottonAction(ActionEvent event) {

    }

}
