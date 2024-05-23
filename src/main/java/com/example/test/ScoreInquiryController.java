package com.example.test;

import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ScoreInquiryController {

    @FXML
    private TableView<Lecture> LectureTable;

    @FXML
    private Button back;

    @FXML
    private Button check;

    @FXML
    private Text notFound;

    @FXML
    private TextField search;

    @FXML
    private TableColumn<Lecture,String > lectureID;

    @FXML
    private TableColumn<Lecture, String> lecturer;

    @FXML
    private Button myCourses;

    @FXML
    private TableColumn<Lecture, String> name;

    @FXML
    private Button refresh;

    @FXML
    private TableColumn<Lecture, String> score;

    private ObservableList<Lecture> lecturesData = FXCollections.observableArrayList();

    private Student userInfo;

    private static List<Lecture> selectedLectures;


    public ScoreInquiryController() {
        //空构造器
    }

    public void setStudentInfo(Student userInfo){
        this.userInfo = userInfo;
        initialize(null,null,userInfo);
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
        String search=this.search.getText();
        if (search!=null) {
            LectureTable.getItems().clear();
            Lecture foundLecture = LectureDAO.getLectureByID(search);
            if (foundLecture != null) {
                ObservableList<Lecture> lecturesList = LectureTable.getItems();
                lecturesList.add(0, foundLecture);
                LectureTable.setItems(lecturesList);
            } else {
                notFound.setVisible(true);
            }
        }
    }

    @FXML
    String searchBottonAction(ActionEvent event) {
        return this.search.getText();
    }

    @FXML
    void myCoursesAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) back.getScene().getWindow();
        currentStage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentCourses.fxml"));
        Parent root = loader.load();
        StudentCoursesController controller = loader.getController();
        controller.setStudentInfo(userInfo);

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    @FXML
    void refreshBottonAction(ActionEvent event) {
        this.search.setText("");
        notFound.setVisible(false);
        initialize(null,null,userInfo);
    }

    public void initialize(URL url, ResourceBundle resourceBundle, User userInfo) {
        lecturesData = FXCollections.observableArrayList(Optional.ofNullable(StudentDAO.getAllLectures(userInfo.getID()))
                .orElseGet(Collections::emptyList));

        lectureID.setCellValueFactory(cellData -> {
            String name = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLectureID)
                    .orElse("");

            return new SimpleStringProperty(name);
        });

        name.setCellValueFactory(cellData -> {
            String name = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getName)
                    .orElse("");

            return new SimpleStringProperty(name);
        });

        lecturer.setCellValueFactory(cellData -> {
            String name = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLecturerName)
                    .orElse("");

            return new SimpleStringProperty(name);
        });


        /**score.setCellValueFactory(cellData -> {
                    String score = Optional.ofNullable(cellData.getValue())
                            .map(Lecture::getGrade).orElse("");
                    return new SimpleStringProperty(score);
                });*/


        lecturesData = FXCollections.observableArrayList(Optional.of(StudentDAO.getAllLectures(userInfo.getID()))
                .orElseGet(Collections::emptyList));
        LectureTable.setItems(lecturesData);

    }

  
}
