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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * This class represents the controller for the StudentCourses view.
 * It handles the interactions between the UI elements and the underlying data model.
 */
public class StudentCoursesController {

    @FXML
    private TableView<Lecture> LectureTable;// Table view for displaying lectures

    @FXML
    private Button back; // Button to skip to home page

    @FXML
    private Button lectureChoosing; // Button to skip to lecture choosing page

    @FXML
    private Button refresh; // Button to refresh the lecture list table

    @FXML
    private TableColumn<Lecture, String> monday;  // Column for Monday's lectures

    @FXML
    private TableColumn<Lecture, String> tuesday; // Column for Tuesday's lectures

    @FXML
    private TableColumn<Lecture, String> wednesday;// Column for Wednesday's lectures

    @FXML
    private TableColumn<Lecture, String> thursday;// Column for Thursday's lectures

    @FXML
    private TableColumn<Lecture, String> friday; // Column for Friday's lectures

    private ObservableList<Lecture> lectures = FXCollections.observableArrayList(); // List of observable lectures

    private Student userInfo;  // Student information

    /**
     * Default constructor.
     */
    public StudentCoursesController(){
        // Empty
    }

    /**
     * Sets the student information for the controller.
     *
     * @param userInfo The student information object
     */
    public void setStudentInfo(Student userInfo){
        this.userInfo = userInfo;
        initialize(null,null,userInfo);
    }

    /**
     * Navigates back to the StudentHomePage when the back button is clicked.
     *
     * @param event The action event triggered by the button click
     * @throws IOException If there's an issue loading the FXML file
     */
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

    /**
     * Navigates to the LectureChoosing view when the choose lectures button is clicked.
     *
     * @param event The action event triggered by the button click
     * @throws IOException If there's an issue loading the FXML file
     */
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

    /**
     * Initializes the table view with the student's lectures.
     * Sets up the table columns to display the lecture details based on their schedule.
     *
     * @param url Unused parameter
     * @param resourceBundle Unused parameter
     * @param userInfo The student information object
     */
    public void initialize(URL url, ResourceBundle resourceBundle, User userInfo) {
        // Fetches the student's lectures from the database
        lectures = FXCollections.observableArrayList(Optional.ofNullable(StudentDAO.getAllLectures(userInfo.getID()))
                .orElseGet(Collections::emptyList));

        monday.setCellValueFactory(cellData -> {
            String name = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getName)
                    .orElse("");
            String lectureID = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLectureID)
                    .orElse("");
            String lecturerName = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLecturerName)
                    .orElse("");
            String room = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getRoom)
                    .orElse(0));
            String building = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getBuilding)
                    .orElse(0));
            String schedule= Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getSchedule)
                    .orElse("");
            return new SimpleStringProperty(schedule.equals("Monday") ? lectureID+"\n"+name+"\n"+lecturerName+"\nRoom  "+room+"\nBuilding "+building : null);
        });

        tuesday.setCellValueFactory(cellData -> {
            String name = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getName)
                    .orElse("");
            String lectureID = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLectureID)
                    .orElse("");
            String lecturerName = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLecturerName)
                    .orElse("");
            String room = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getRoom)
                    .orElse(0));
            String building = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getBuilding)
                    .orElse(0));
            String schedule= Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getSchedule)
                    .orElse("");
            return new SimpleStringProperty(schedule.equals("Tuesday") ? lectureID+"\n"+name+"\n"+lecturerName+"\nRoom  "+room+"\nBuilding "+building : null);
        });

        wednesday.setCellValueFactory(cellData -> {
            String name = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getName)
                    .orElse("");
            String lectureID = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLectureID)
                    .orElse("");
            String lecturerName = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLecturerName)
                    .orElse("");
            String room = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getRoom)
                    .orElse(0));
            String building = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getBuilding)
                    .orElse(0));
            String schedule= Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getSchedule)
                    .orElse("");
            return new SimpleStringProperty(schedule.equals("Wednesday") ? lectureID+"\n"+name+"\n"+lecturerName+"\nRoom  "+room+"\nBuilding "+building : null);
        });
        thursday.setCellValueFactory(cellData -> {
            String name = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getName)
                    .orElse("");
            String lectureID = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLectureID)
                    .orElse("");
            String lecturerName = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLecturerName)
                    .orElse("");
            String room = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getRoom)
                    .orElse(0));
            String building = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getBuilding)
                    .orElse(0));
            String schedule= Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getSchedule)
                    .orElse("");
            return new SimpleStringProperty(schedule.equals("Thursday") ? lectureID+"\n"+name+"\n"+lecturerName+"\nRoom  "+room+"\nBuilding "+building : null);
        });
        friday.setCellValueFactory(cellData -> {
            String name = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getName)
                    .orElse("");
            String lectureID = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLectureID)
                    .orElse("");
            String lecturerName = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLecturerName)
                    .orElse("");
            String room = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getRoom)
                    .orElse(0));
            String building = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getBuilding)
                    .orElse(0));
            String schedule= Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getSchedule)
                    .orElse("");
            return new SimpleStringProperty(schedule.equals("Friday") ? lectureID+"\n"+name+"\n"+lecturerName+"\nRoom  "+room+"\nBuilding "+building : null);
        });

        lectures = FXCollections.observableArrayList(Optional.ofNullable(StudentDAO.getAllLectures(userInfo.getID()))
                .orElseGet(Collections::emptyList));
        LectureTable.setItems(lectures);
    }

}
