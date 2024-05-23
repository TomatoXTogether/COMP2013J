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
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import com.example.test.Student;

public class LecturerScoreManagementController {

    @FXML
    public TableView<Lecture> LectureTable;

    @FXML
    private TableView<Student> StudentTable;

    @FXML
    public TableView<Grade> GradeTable;

    @FXML
    private Button back;

    @FXML
    private Button check;

    @FXML
    private TableColumn<Lecture, String> lectureID;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<Lecture, String> name;

    @FXML
    private TextField input;

    @FXML
    private Button lectureChoosing;

    @FXML
    private TableColumn<Student, String> studentID;

    @FXML
    private TableColumn<Student, String> studentName;

    @FXML
    private TableColumn<Student, String> email;

    @FXML
    private Button newLecture;

    @FXML
    private Button refresh;

    @FXML
    private Button save;

    @FXML
    private TableColumn<Grade, String> grade;

    private ObservableList<Lecture> lecturesData = FXCollections.observableArrayList();
    private ObservableList<Student> studentsData = FXCollections.observableArrayList();
    private ObservableList<Grade> gradesData = FXCollections.observableArrayList();

    @FXML
    private Lecturer userInfo;
    @FXML
    private String lecturerCourseID;



    public void LecturerScoreManagementController(Lecturer userInfo){
        //空构造器
    }

    public void setLecturerInfo(Lecturer userInfo){
        this.userInfo = userInfo;

        System.out.println(userInfo+"7777777777");
        loadLectures(userInfo);
        initialize(null,null,userInfo);
        System.out.println(userInfo+"9999999999");
        loadLectures(userInfo);
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

    }

    @FXML
    void inputBottonAction(ActionEvent event) {

    }

    @FXML
    void lectureChoosingAction(ActionEvent event) {

    }

    @FXML
    void refreshBottonAction(ActionEvent event) {
        loadLectures(userInfo);
    }

    @FXML
    void saveBottonAction(ActionEvent event) {

    }


    public void setLecturerCourseID(String lecturerCourseID) {
        this.lecturerCourseID = lecturerCourseID;
    }
    private void loadLectures(Lecturer user) {
        System.out.println(user+"test");
        if (user != null) {
            List<Lecture> lectures = LectureDAO.getLecturesByLecturerID(String.valueOf(userInfo.getID()));

            lecturesData.clear(); // 清除先前的数据

            // 将获取到的 Lecture 对象添加到数据源中
            lecturesData.addAll(lectures);
            LectureTable.setItems(lecturesData);

            for (Lecture lecture : lectures) {
                List<Student> students = StudentDAO.getStudentsByLectureID(Integer.parseInt((lecture.getLectureID())));
                //studentsData.clear();
                studentsData.addAll(students);
                StudentTable.setItems(studentsData);

                for (Student student : students) {
                    Grade grade = new Grade(lecture.getLectureID(), lecture.getName(), student.getGrade());
                    gradesData.add(grade);
                }
                StudentTable.setItems(studentsData);
                GradeTable.setItems(gradesData);

            }
        }
    }


    public void initialize(URL location, ResourceBundle resources,User user) {
        lectureID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLectureID()));
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        // 初始化 StudentTable 的列绑定
        studentID.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getID())));
        studentName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

        // 初始化 GradeTable 的列绑定
        grade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGrade()));

        // 加载数据
        loadLectures(userInfo);
    }

}
