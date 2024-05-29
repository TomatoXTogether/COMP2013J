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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class LecturerCoursesManagementController implements Initializable {

    @FXML
    private TableView<Lecture> LectureTable;

    @FXML
    private Button back;

    @FXML
    private TableColumn<Lecture, String> building;

    @FXML
    private Button check;

    @FXML
    private TableColumn<Lecturer, String> checkBox;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<Lecture, String> endDate;

    @FXML
    private TextField input;

    @FXML
    private Button lectureChoosing;

    @FXML
    private TableColumn<Lecture, String> lectureID;

    @FXML
    private TableColumn<Lecture, String> lecturer;

    @FXML
    private TableColumn<Lecture, String> name;

    @FXML
    private Button newLecture;

    @FXML
    private Button refresh;

    @FXML
    private TableColumn<Lecture, String> schedule;

    @FXML
    private Button save;

    @FXML
    private TableColumn<Lecture, String> room;

    @FXML
    private TableColumn<Lecture, String> startDate;

    @FXML
    private  Lecturer userInfo;

    private ObservableList<Lecture> lecturesData = FXCollections.observableArrayList();

    public void LecturerCoursesManagementController(Lecturer userInfo){
        //
    }

    public void setLecturerInfo(Lecturer userInfo){
        this.userInfo = userInfo;
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
        filterLectures();
    }


    @FXML
    void inputBottonAction(ActionEvent event) {
        filterLectures();
    }
    @FXML
    void resetBottonAction(ActionEvent event) {
        input.clear();
        LectureTable.setItems(lecturesData);
        LectureTable.getSelectionModel().clearSelection();
    }
    private void filterLectures(){
        String filterText = input.getText().trim().toLowerCase();
        if (filterText.isEmpty()) {
            LectureTable.setItems(lecturesData);
        } else {
            List<Lecture> filteredList = lecturesData.stream()
                    .filter(lecture -> lecture.getLectureID().toLowerCase().contains(filterText) ||
                            lecture.getName().toLowerCase().contains(filterText) ||
                            lecture.getLecturerName().toLowerCase().contains(filterText) ||
                            String.valueOf(lecture.getBuilding()).toLowerCase().contains(filterText) ||
                            String.valueOf(lecture.getRoom()).toLowerCase().contains(filterText) ||
                            lecture.getStartDate().contains(filterText) ||
                            lecture.getEndDate().contains(filterText) ||
                            lecture.getSchedule().toLowerCase().contains(filterText))
                    .collect(Collectors.toList());

            ObservableList<Lecture> filteredData = FXCollections.observableArrayList(filteredList);
            LectureTable.setItems(filteredData);
            if (!filteredData.isEmpty()) {
                LectureTable.getSelectionModel().select(0);
                LectureTable.scrollTo(0);
                LectureTable.getSelectionModel().clearSelection();
            }
        }
    }

    @FXML
    void jumpToSchedule(ActionEvent event) throws IOException{
        Stage currentStage = (Stage) back.getScene().getWindow();
        currentStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LecturerCourseSchedule.fxml"));
        Parent root = loader.load();
        LecturerCourseScheduleController controller = loader.getController();
        controller.setLecturerInfo(userInfo);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
    }


    @FXML
    void refreshBottonAction(ActionEvent event) {
        List<Lecture> lectures = LectureDAO.getAllLectures();
        lecturesData.clear();
        lecturesData.addAll(lectures);
        LectureTable.setItems(lecturesData);
    }

    public void initialize (URL arg0, ResourceBundle arg1){
        //表格与实体类的属性进行绑定
        lectureID.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLectureID())));
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        lecturer.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLecturerName())));
        building.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBuilding())));
        room.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getRoom())));
        startDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate()));
        endDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndDate()));
        schedule.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSchedule()));

        refreshBottonAction(null);
    }

}
