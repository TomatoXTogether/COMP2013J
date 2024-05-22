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
import java.util.Collections;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentCoursesController {

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

    private ObservableList<Lecture> lectures = FXCollections.observableArrayList();

    private Student userInfo;

    public StudentCoursesController(){
        //无参构造器
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

    public void initialize(URL url, ResourceBundle resourceBundle, User userInfo) {
        // 使用 Optional 来包装获取讲座列表的结果
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
