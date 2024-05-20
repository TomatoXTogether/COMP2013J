package com.example.test;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentCoursesController implements Initializable {

    @FXML
    private TableView<Lecture> LectureTable;

    @FXML
    private Button back;

    @FXML
    private Button lectureChoosing;

    @FXML
    private Button refresh;

    @FXML
    private TableColumn<Lecture, String> monday;

    @FXML
    private TableColumn<Lecture, String> tuesday;

    @FXML
    private TableColumn<Lecture, String> wednesday;

    @FXML
    private TableColumn<Lecture, String> thursday;

    @FXML
    private TableColumn<Lecture, String> friday;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monday.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName() + cellData.getValue().getLecturerName()));
        LectureChoosingController.getSelectedLectures();
    }
}
