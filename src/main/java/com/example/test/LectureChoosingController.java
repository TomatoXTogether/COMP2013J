package com.example.test;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Controller class for the student course selection interface.
 */
public class LectureChoosingController implements Initializable {

    // UI Components
    @FXML
    private TableView<Lecture> LectureTable;  // Table to display available lectures

    @FXML
    private Button back;// Button to navigate back to the home page

    @FXML
    private TableColumn<Lecture, Boolean> checkBox;  // Checkbox column for selecting lectures

    @FXML
    private TableColumn<Lecture, String> building; // Column for lecture building information

    @FXML
    private Button check;// Button to search for a specific lecture by ID

    @FXML
    private Text notFound; // Text to indicate when a searched lecture is not found

    @FXML
    private TableColumn<Lecture, String> endDate; // Column for lecture end date information

    @FXML
    private TableColumn<Lecture, String> lectureID; // Column for lecture ID

    @FXML
    private TableColumn<Lecture, String> lecturer; // Column for lecturer's name

    @FXML
    private Button myCourses; // Button to view the student course schedule

    @FXML
    private TableColumn<Lecture, String> name; // Column for lecture name

    @FXML
    private Button refresh; // Button to refresh the table of lectures

    @FXML
    private TableColumn<Lecture, String> room;  // Column for lecture room number

    @FXML
    private Button save;  // Button to save selected lectures

    @FXML
    private Button delete;  // Button to delete selected lectures

    @FXML
    private TableColumn<Lecture, String> schedule; // Column for lecture schedule information

    @FXML
    private TableColumn<Lecture, String> startDate;  // Column for lecture start date
    @FXML
    private TextField search; // Text field to input lecture ID for search

    private ObservableList<Lecture> lecturesData = FXCollections.observableArrayList(); // List holding lecture data

    private Student userInfo;  // Current student's information

    private static List<Lecture> selectedLectures; // List of lectures selected by the student

    /**
     * Default constructor for LectureChoosingController.
     */
    public void LectureChoosingController() {
        // Empty constructor
    }

    /**
     * Sets the student's information in the controller.
     *
     * @param userInfo The student's information object.
     */
   public void setStudentInfo(Student userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * Handles the 'back' button action. Closes the current stage and loads the StudentHomePage.
     *
     * @param event ActionEvent object triggered by the button click.
     * @throws IOException If an error occurs while loading the FXML file.
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
     * Retrieves the text from the search field when the search button is clicked.
     *
     * @param event ActionEvent object triggered by the button click.
     * @return The text in the search field.
     */
    @FXML
    String searchBottonAction(ActionEvent event) {
        return this.search.getText();
    }

    /**
     * Handles the 'check' button action. Searches for a lecture by ID, displays it in the table or shows a 'not found' message.
     *
     * @param event ActionEvent object triggered by the button click.
     */
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

    /**
     * Handles the 'my courses' button action. Closes the current stage and loads the StudentCourses page.
     *
     * @param event ActionEvent object triggered by the button click.
     * @throws IOException If an error occurs while loading the FXML file.
     */
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

    /**
     * Handles the 'refresh' button action. Refreshes the table of lectures and sets the selected lectures.
     *
     * @param event ActionEvent object triggered by the button click.
     */
    @FXML
    void refreshBottonAction(ActionEvent event) {
        this.search.setText("");
        notFound.setVisible(false);
        selectedLectures = lecturesData.stream()
                .filter(Lecture::isSelected)
                .collect(Collectors.toList());
        List<Lecture> updatedLectures = LectureDAO.getAllLectures();
        for (Lecture lecture : lecturesData) {
            updatedLectures.stream()
                    .filter(l -> Objects.equals(l.getLectureID(), lecture.getLectureID()))
                    .findFirst().ifPresent(updatedLecture -> updatedLecture.setSelected(lecture.isSelected()));
        }
        lecturesData.setAll(updatedLectures);
        LectureTable.setItems(lecturesData);
    }

    /**
     * Handles the 'save' button action. Saves the selected lectures for the student.
     *
     * @param event ActionEvent object triggered by the button click.
     * @return A list of selected lectures.
     */
    @FXML
     List<Lecture> saveBottonAction(ActionEvent event) {
        selectedLectures = lecturesData.stream()
                .filter(Lecture::isSelected)
                .peek(lecture -> lecture.setSelected(true))
                .collect(Collectors.toList());

        List<Lecture> lectures = new ArrayList<Lecture>();

        if (!selectedLectures.isEmpty()) {
            for (Lecture lecture : selectedLectures) {
                StudentDAO.selectLecture(userInfo, lecture);
                StudentDAO.getStudentByID(userInfo.getID()).lectures.add(lecture);
            }
        } else {
            System.out.println("No lectures selected.");
        }
        return lectures;
    }

    /**
     * Handles the 'delete' button action. Deletes the selected lectures for the student.
     *
     * @param event ActionEvent object triggered by the button click.
     * @return A list of deleted lectures.
     */
    @FXML
    List<Lecture> deleteBottonAction(ActionEvent event) {
        selectedLectures = lecturesData.stream()
                .filter(Lecture::isSelected)
                .peek(lecture -> lecture.setSelected(true))
                .collect(Collectors.toList());

        List<Lecture> lectures = new ArrayList<Lecture>();

        if (!selectedLectures.isEmpty()) {
            for (Lecture lecture : selectedLectures) {
                StudentDAO.cancelLecture(userInfo, lecture);
            }
        } else {
            System.out.println("No lectures selected.");
        }
        return lectures;
    }

    /**
     * Initializes the controller and sets up the table view bindings.
     */
    public void initialize (URL arg0, ResourceBundle arg1){
        // Binds table columns with properties from the Lecture entity
        lectureID.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLectureID())));
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        lecturer.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLecturerName())));
        building.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBuilding())));
        room.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getRoom())));
        startDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate()));
        endDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndDate()));
        schedule.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSchedule()));

        // Sets up checkbox functionality within the table
        TableColumn checkBoxColumn = new TableColumn("");
        checkBox.setCellFactory(CheckBoxTableCell.forTableColumn(checkBoxColumn));
        checkBox.setCellValueFactory(cellData -> {
            Lecture lecture = cellData.getValue();
            SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(lecture.isSelected());
            booleanProp.addListener((observable, oldValue, newValue) -> lecture.setSelected(newValue));
            return booleanProp;
        });
        TableColumn<Lecture, Boolean> selectCol = new TableColumn<>("Select");
        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));

        // Calls refresh method to populate the table initially
        refreshBottonAction(null);
        }
}
