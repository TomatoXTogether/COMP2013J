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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LecturerCourseScheduleController implements Initializable {

    @FXML
    private TableView<Lecture> LectureTable;

    @FXML
    private Button back;

    @FXML
    private Button check;


    @FXML
    private Button delete;

    @FXML
    private TableColumn<Lecture, String> lectureName;

    @FXML
    private TextField input;

    @FXML
    private Button lectureChoosing;

    @FXML
    private TableColumn<Lecture, String> lectureID;

    @FXML
    private Button newLecture;

    @FXML
    private Button refresh;

    @FXML
    private TableColumn<Lecture, String> building;
    @FXML
    private TableColumn<Lecture, String> room;

    @FXML
    private Button save;

    @FXML
    private TableColumn<Lecture, String> schedule;

    @FXML
    private TableColumn<Lecture, String> startDate;

    @FXML
    private TableColumn<Lecture, String> endDate;

    @FXML
    private TableColumn<Lecture, Boolean> checkBox;

    @FXML
    private Lecturer userInfo;

    private ObservableList<Lecture> lecturesData = FXCollections.observableArrayList();
    public  LecturerCourseScheduleController(){
        //
    }

    public LecturerCourseScheduleController(Lecturer userInfo){
        this.userInfo = userInfo;
    }

    public void setLecturerInfo(Lecturer userInfo){
        this.userInfo = userInfo;
        loadLectures();
    }



    @FXML
    void backBottonAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) back.getScene().getWindow();
        currentStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LecturerHomePage.fxml"));
        Parent root = loader.load();
        LecturerHomePageController controller = loader.getController();
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
        ObservableList<Lecture> selectedLectures = FXCollections.observableArrayList();
        for (Lecture lecture : lecturesData) {
            if (lecture.isSelected()) {
                selectedLectures.add(lecture);
                LectureDAO.deleteLectureByID(lecture.getLectureID());
            }
        }
        lecturesData.removeAll(selectedLectures);
    }

    @FXML
    void inputBottonAction(ActionEvent event) {

    }

    @FXML
    void lectureChoosingAction(ActionEvent event) {

    }

    @FXML
    void refreshBottonAction(ActionEvent event) {
        loadLectures();
    }

    @FXML
    void saveBottonAction(ActionEvent event) {

    }

    private void loadLectures(){
        if (userInfo != null) {
            List<Lecture> lectures = LectureDAO.getLecturesByLecturerID(String.valueOf(userInfo.getID()));
            lecturesData.clear();
            lecturesData.addAll(lectures);
            LectureTable.setItems(lecturesData);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lectureID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLectureID()));
        lectureName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        building.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBuilding())));
        room.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getRoom())));
        schedule.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSchedule()));
        startDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate()));
        endDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndDate()));

        checkBox.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isSelected()));
        checkBox.setCellFactory(CheckBoxTableCell.forTableColumn(checkBox));

        // Refresh the table on initialization
        loadLectures();
    }
}

