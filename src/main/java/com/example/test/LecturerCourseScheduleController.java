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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class LecturerCourseScheduleController{

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
    private Text notFound;

    @FXML
    private TextField search;

    @FXML
    private TableColumn<Lecture, String> schedule;

    @FXML
    private TableColumn<Lecture, String> startDate;

    @FXML
    private TableColumn<Lecture, String> endDate;

    @FXML
    private Lecturer userInfo;

    private ObservableList<Lecture> lecturesData = FXCollections.observableArrayList();

    public LecturerCourseScheduleController() {
        //
    }

    public LecturerCourseScheduleController(Lecturer userInfo) {
        this.userInfo = userInfo;
    }

    public void setLecturerInfo(Lecturer userInfo) {
        this.userInfo = userInfo;
        initialize(null,null,userInfo);
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
        String search = input.getText();
        if (search != null && !search.trim().isEmpty()) {
            LectureTable.getItems().clear();
            Lecture foundLecture = LectureDAO.getLectureByID(search);
            if (foundLecture != null) {
                ObservableList<Lecture> lecturesList = LectureTable.getItems();
                lecturesList.add(0, foundLecture);
                LectureTable.setItems(lecturesList);
            } else {
                // 如果找不到讲座，可以在这里添加一个提示，例如显示一个标签
                // notFound.setVisible(true);
                System.out.println("Lecture not found.");
            }
        }
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
        this.search.setText("");
        notFound.setVisible(false);
        initialize(null,null,userInfo);
    }

    @FXML
    void jumpToScore(ActionEvent event) throws IOException{
        Stage currentStage = (Stage) back.getScene().getWindow();
        currentStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LecturerScoreManagement.fxml"));
        Parent root = loader.load();
        LecturerScoreManagementController controller = loader.getController();
        controller.setLecturerInfo(userInfo);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    private void loadLectures() {
//        List<Lecture> lectures = Optional.ofNullable(LectureDAO.getAllLectures(userInfo != null ? userInfo.getID() : null))
//                .orElseGet(Collections::emptyList);
//        lecturesData = FXCollections.observableArrayList(lectures);
//        LectureTable.setItems(lecturesData);
//        if (userInfo != null) {
//            List<Lecture> lectures = LectureDAO.getLecturesByLecturerID(String.valueOf(userInfo.getID()));
//            lecturesData.clear();
//            lecturesData.addAll(lectures);
//            LectureTable.setItems(lecturesData);
//        }
    }

    public void initialize(URL location, ResourceBundle resources, User userInfo) {
        lecturesData = FXCollections.observableArrayList(Optional.ofNullable(LecturerDAO.getAllLecturerCourses((Lecturer) userInfo))
                .orElseGet(Collections::emptyList));
        lectureID.setCellValueFactory(cellData -> {
            String id = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getLectureID)
                    .orElse("");
            return new SimpleStringProperty(id);
        });

        lectureName.setCellValueFactory(cellData -> {
            String lectureName = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getName)
                    .orElse("");
            return new SimpleStringProperty(lectureName);
        });

        building.setCellValueFactory(cellData -> {
            String buildingName = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getBuilding)
                    .orElse(0));
            return new SimpleStringProperty(buildingName);
        });

        room.setCellValueFactory(cellData -> {
            String roomName = String.valueOf(Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getRoom)
                    .orElse(0));
            return new SimpleStringProperty(roomName);
        });

        schedule.setCellValueFactory(cellData -> {
            String scheduleValue = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getSchedule)
                    .orElse("");
            return new SimpleStringProperty(scheduleValue);
        });

        startDate.setCellValueFactory(cellData -> {
            String start = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getStartDate)
                    .orElse("");
            return new SimpleStringProperty(start);
        });

        endDate.setCellValueFactory(cellData -> {
            String end = Optional.ofNullable(cellData.getValue())
                    .map(Lecture::getEndDate)
                    .orElse("");
            return new SimpleStringProperty(end);
        });
        lecturesData = FXCollections.observableArrayList(Optional.of(LecturerDAO.getAllLecturerCourses((Lecturer) userInfo))
                .orElseGet(Collections::emptyList));
        LectureTable.setItems(lecturesData);
        // 初始加载讲座数据
        //loadLectures(null);
//        lectureID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLectureID()));
//        lectureName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
//        building.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBuilding())));
//        room.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getRoom())));
//        schedule.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSchedule()));
//        startDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate()));
//        endDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndDate()));
//        loadLectures();
    }
}
