package com.example.test;

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

public class ScoreInquiryController {

    @FXML
    private TableView<?> LectureTable;

    @FXML
    private Button back;

    @FXML
    private Button check;

    @FXML
    private TextField checkBox;

    @FXML
    private TableColumn<?, ?> lectureID;

    @FXML
    private TableColumn<?, ?> lecturer;

    @FXML
    private Button myCourses;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private Button refresh;

    @FXML
    private TableColumn<?, ?> score;

    @FXML
    void backBottonAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) back.getScene().getWindow();
        currentStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentHomePage.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    @FXML
    void checkBottonAction(ActionEvent event) {

    }

    @FXML
    void getInput(ActionEvent event) {

    }

    @FXML
    void myCoursesAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) back.getScene().getWindow();
        currentStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentHomePage.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    @FXML
    void refreshBottonAction(ActionEvent event) {

    }

  
}
