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

/**
 * Controller class responsible for handling UI interactions and data operations related to student score inquiry.
 */
public class ScoreInquiryController {

    @FXML
    private TableView<Lecture> LectureTable; // Table view for displaying lecture information

    @FXML
    private Button back;

    @FXML
    private Button check;

    @FXML
    private Text notFound;// Text indicating "Not Found"

    @FXML
    private TextField search;// Search field

    @FXML
    private TableColumn<Lecture,String > lectureID; // Column for Lecture ID

    @FXML
    private TableColumn<Lecture, String> lecturer; // Column for Lecturer Name

    @FXML
    private Button myCourses; // My Courses button to skip to student's courses schedule

    @FXML
    private TableColumn<Lecture, String> name; // Column for Lecture Name

    @FXML
    private Button refresh; // Refresh button to refresh the table

    @FXML
    private TableColumn<Lecture, String> score; // Column for Lecture Score

    private ObservableList<Lecture> lecturesData = FXCollections.observableArrayList(); // Observable list for storing lectures data

    private Student userInfo;


    /**
     * Default constructor.
     */
    public ScoreInquiryController() {
        // Empty constructor
    }

    /**
     * Sets the student information.
     *
     * @param userInfo The student information to be set
     */
    public void setStudentInfo(Student userInfo){
        this.userInfo = userInfo;
        initialize(null,null,userInfo);
    }

    /**
     * Handles the back button action.
     *
     * @param event ActionEvent triggered by clicking the back button
     * @throws IOException Exception that may occur while loading FXML
     */
    @FXML
    void backBottonAction(ActionEvent event) throws IOException {
        // Closes the current stage and navigates to the StudentHomePage.fxml
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
     * Handles the check button action.
     *
     * @param event ActionEvent triggered by clicking the check button
     */
    @FXML
    void checkBottonAction(ActionEvent event) {
        // Searches for a lecture based on the input in the search field
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

    /**
     * Returns the text from the search field.
     *
     * @param event ActionEvent triggered by clicking the search button
     * @return The text entered the search field
     */
    @FXML
    String searchBottonAction(ActionEvent event) {
        return this.search.getText();
    }

    /**
     * Handles the myCourses button action.
     *
     * @param event ActionEvent triggered by clicking the myCourses button
     * @throws IOException Exception that may occur while loading FXML
     */
    @FXML
    void myCoursesAction(ActionEvent event) throws IOException {
        // Navigates to the StudentCourses.fxml
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

    /**
     * Handles the refresh button action.
     *
     * @param event ActionEvent triggered by clicking the refresh button
     */
    @FXML
    void refreshBottonAction(ActionEvent event) {
        this.search.setText("");
        notFound.setVisible(false);
        initialize(null,null,userInfo);
    }

    /**
     * Initializes the UI components and loads the data.
     *
     * @param url Unused parameter
     * @param resourceBundle Unused parameter
     * @param userInfo The current student's information
     */
    public void initialize(URL url, ResourceBundle resourceBundle, User userInfo) {
        // Loads the lectures data and sets up the table columns
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


        score.setCellValueFactory(cellData -> {
                    String score = Optional.ofNullable(cellData.getValue())
                            .map(Lecture::getGrade).orElse("");
                    return new SimpleStringProperty(score);
                });


        lecturesData = FXCollections.observableArrayList(Optional.of(StudentDAO.getAllLectures(userInfo.getID()))
                .orElseGet(Collections::emptyList));
        LectureTable.setItems(lecturesData);

    }

  
}
