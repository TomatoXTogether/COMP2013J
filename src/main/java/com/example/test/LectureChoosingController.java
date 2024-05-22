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

public class LectureChoosingController implements Initializable {
    //学生的选课界面
    @FXML
    private TableView<Lecture> LectureTable;

    @FXML
    private Button back;

    @FXML
    private TableColumn<Lecture, Boolean> checkBox;

    @FXML
    private TableColumn<Lecture, String> building;

    @FXML
    private Button check;

    @FXML
    private Text notFound;

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
    private Button delete;

    @FXML
    private TableColumn<Lecture, String> schedule;

    @FXML
    private TableColumn<Lecture, String> startDate;

    @FXML
    private TextField search;

    private ObservableList<Lecture> lecturesData = FXCollections.observableArrayList();

    private Student userInfo;

    private static List<Lecture> selectedLectures;


    public void LectureChoosingController() {
        //空构造器
    }

   public void setStudentInfo(Student userInfo) {
        this.userInfo = userInfo;
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
    String searchBottonAction(ActionEvent event) {
        return this.search.getText();
    }


    @FXML
    void checkBottonAction(ActionEvent event) {
        String search=this.search.getText();
        if (search!=null) {
            LectureTable.getItems().clear();
            // 调用 LectureDAO 的方法来通过讲座 ID 查找讲座
            Lecture foundLecture = LectureDAO.getLectureByID(search);
            if (foundLecture != null) {
                // 处理找到的讲座对象，例如显示在界面上或进行其他操作
                ObservableList<Lecture> lecturesList = LectureTable.getItems();
                // 在数据源的最前面插入找到的课程
                lecturesList.add(0, foundLecture);
                // 刷新表格以显示更新后的数据
                LectureTable.setItems(lecturesList);
            } else {
                notFound.setVisible(true);
            }
        }
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
        // 先获取之前选中的课程
        selectedLectures = lecturesData.stream()
                .filter(Lecture::isSelected)
                .collect(Collectors.toList());
        List<Lecture> updatedLectures = LectureDAO.getAllLectures();
        for (Lecture lecture : lecturesData) {
            // 更新课程对象的属性，保持勾选状态不变
            updatedLectures.stream()
                    .filter(l -> Objects.equals(l.getLectureID(), lecture.getLectureID()))
                    .findFirst().ifPresent(updatedLecture -> updatedLecture.setSelected(lecture.isSelected()));
        }
        lecturesData.setAll(updatedLectures);
        LectureTable.setItems(lecturesData);
    }



    @FXML
     List<Lecture> saveBottonAction(ActionEvent event) {
        selectedLectures = lecturesData.stream()
                .filter(Lecture::isSelected)
                .peek(lecture -> lecture.setSelected(true))
                .collect(Collectors.toList());

        List<Lecture> lectures = new ArrayList<Lecture>();

        if (!selectedLectures.isEmpty()) {
            for (Lecture lecture : selectedLectures) {
                // 在此处添加保存逻辑//
                StudentDAO.selectLecture(userInfo, lecture);
                StudentDAO.getStudentByID(userInfo.getID()).lectures.add(lecture);
            }
        } else {
            System.out.println("No lectures selected.");
        }
        return lectures;
    }

    @FXML
    List<Lecture> deleteBottonAction(ActionEvent event) {
        selectedLectures = lecturesData.stream()
                .filter(Lecture::isSelected)
                .peek(lecture -> lecture.setSelected(true))
                .collect(Collectors.toList());

        List<Lecture> lectures = new ArrayList<Lecture>();

        if (!selectedLectures.isEmpty()) {
            for (Lecture lecture : selectedLectures) {
                // 在此处添加保存逻辑//
                StudentDAO.cancelLecture(userInfo, lecture);
            }
        } else {
            System.out.println("No lectures selected.");
        }
        return lectures;
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

            refreshBottonAction(null);
        }
}
