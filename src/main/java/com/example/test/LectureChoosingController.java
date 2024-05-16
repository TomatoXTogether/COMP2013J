package com.example.test;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LectureChoosingController {
    @FXML
    private TableView<Lecture> LectureTable;
    @FXML
    private Button back;

    @FXML
    private TableColumn<Lecture, Checkbox> checkBox;

    @FXML
    private TableColumn<Lecture, String> building;

    @FXML
    private Button check;

    @FXML
    private TableColumn<Lecture, String> endDate;

    @FXML
    private TableColumn<Lecture, String> lectureID;

    @FXML
    private TableColumn<Lecture, String> lecturer;

    @FXML
    private Button myCourses;

    @FXML
    private TableColumn<Lecture, String> name;

    @FXML
    private Button refresh;

    @FXML
    private TableColumn<Lecture, String> room;

    @FXML
    private Button save;

    @FXML
    private TableColumn<Lecture, String> schedule;

    @FXML
    private TableColumn<Lecture, String> startDate;

    private ObservableList<Lecture> lecturesData= FXCollections.observableArrayList();


    @FXML
    void backBottonAction(ActionEvent event) {

    }

    @FXML
    void checkBottonAction(ActionEvent event) {

    }

    @FXML
    void myCoursesAction(ActionEvent event) {

    }

    @FXML
    void refreshBottonAction(ActionEvent event) {

    }

    @FXML
    void saveBottonAction(ActionEvent event) {

    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        //表格与实体类的属性进行绑定
        this.lectureID.setCellValueFactory(cellData -> {
            int value = cellData.getValue().getLectureID();
            return new SimpleStringProperty(Integer.toString(value));
        });
        this.lecturer.setCellValueFactory(cellData -> {
            int value = cellData.getValue().getLecturerID();//id转化成名字
            return new SimpleStringProperty(Integer.toString(value));
        });
        this.name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        this.room.setCellValueFactory(cellData -> {
            int value = cellData.getValue().getRoom();
            return new SimpleStringProperty(Integer.toString(value));
        });
        this.building.setCellValueFactory(cellData -> {
            int value = cellData.getValue().getBuilding();
            return new SimpleStringProperty(Integer.toString(value));
        });
        this.schedule.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getSchedule()));
        this.startDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate()));
        this.endDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndDate()));
        //this.checkBox.setCellValueFactory(cellData -> cellData.getValue().Checkbox.getCheckBox());

        //List<Lecture> lectures = Lecture.getLectureList();
        LectureTable.setItems(lecturesData);

        //lecturesData.add();
//        try {
//            lectureList = ServantFile.servantJson();
//            final ObservableList<ServantCheck> tarData = FXCollections.observableArrayList(servantlist);
//            this.showServantTable(tarData);
//            tableView.setItems(tarData);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
