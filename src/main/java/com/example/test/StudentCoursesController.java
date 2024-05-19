package com.example.test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentCoursesController {

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
    private Button refresh;

    @FXML
    private TableColumn<?, ?> room;

    @FXML
    private Button save;

    @FXML
    private TableColumn<?, ?> schedule;

    @FXML
    private TableColumn<?, ?> startDate;

    private ObservableList<Lecture> lecturesData= FXCollections.observableArrayList();

    private Student userInfo;

    public StudentCoursesController(Student userInfo){
        this.userInfo = userInfo;
    }

    public StudentCoursesController(){
        //无参构造器
    }
    public void setStudentInfo(Student userInfo){
        this.userInfo = userInfo;
    }

    @FXML
    void backBottonAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) back.getScene().getWindow();
        currentStage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentHomePage.fxml"));
        Parent root = loader.load();
        StudentHomePageController controller = loader.getController();
        controller.setUserInfo(userInfo);

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
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
    void lectureChoosingAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) back.getScene().getWindow();
        currentStage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LectureChoosing.fxml"));
        Parent root = loader.load();
        LectureChoosingController controller = loader.getController();
        controller.setStudentInfo(userInfo);

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    @FXML
    void refreshBottonAction(ActionEvent event) {

    }

    @FXML
    void saveBottonAction(ActionEvent event) {

    }

}
