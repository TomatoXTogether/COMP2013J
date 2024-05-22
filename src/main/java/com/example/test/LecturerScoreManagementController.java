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
import java.util.stream.Collectors;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LecturerScoreManagementController implements Initializable {

    @FXML
    private TableView<StudentWithLecture> LectureTable;

    @FXML
    private Button back;

    @FXML
    private Button check;

    @FXML
    private TableColumn<StudentWithLecture, String> lectureID;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<StudentWithLecture, String> lectureName;

    @FXML
    private TextField input;

    @FXML
    private Button lectureChoosing;

    @FXML
    private TableColumn<StudentWithLecture, String> studentID;

    @FXML
    private TableColumn<StudentWithLecture, String> studentName;

    @FXML
    private TableColumn<StudentWithLecture, String> email;

    @FXML
    private Button newLecture;

    @FXML
    private Button refresh;

    @FXML
    private Button save;

    @FXML
    private TableColumn<StudentWithLecture, String> grade;

    @FXML
    private  Lecturer userInfo;
    @FXML
    private String lecturerCourseID;



    public void LecturerScoreManagementController(Lecturer userInfo){
        //空构造器
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

    }

    @FXML
    void saveBottonAction(ActionEvent event) {

    }

    public static class StudentWithLecture{
        private final SimpleStringProperty studentID;
        private final SimpleStringProperty studentName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty lectureID;
        private final SimpleStringProperty lectureName;
        private final SimpleStringProperty grade;

        public StudentWithLecture(int studentID, String studentName, String email, String lectureID, String lectureName, String grade) {
            this.studentID = new SimpleStringProperty(String.valueOf(studentID));
            this.studentName = new SimpleStringProperty(studentName);
            this.email = new SimpleStringProperty(email);
            this.lectureID = new SimpleStringProperty(lectureID);
            this.lectureName = new SimpleStringProperty(lectureName);
            this.grade = new SimpleStringProperty(grade);
        }
        public String getStudentID() {
            return studentID.get();
        }

        public String getStudentName() {
            return studentName.get();
        }

        public String getEmail() {
            return email.get();
        }

        public String getLectureID() {
            return lectureID.get();
        }

        public String getLectureName() {
            return lectureName.get();
        }

        public String getGrade() {
            return grade.get();
        }

    }
    public void setLecturerCourseID(String lecturerCourseID) {
        this.lecturerCourseID = lecturerCourseID;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lectureID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLectureID()));
        lectureName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLectureName()));
        studentID.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getStudentID())));
        studentName.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getStudentName())));
        email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        grade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGrade()));

        ObservableList<StudentWithLecture> studentsWithLectures = FXCollections.observableArrayList();
        List<User> students = StudentDAO.getAllStudents();
        StudentDAO studentDAO = new StudentDAO();
        String lecturerCourseID = this.lecturerCourseID;
        //int lecturerID = this.userInfo.getID();
        //List<String> lecturerCourseIDs = LectureDAO.getLecturesByLecturerID(String.valueOf(lecturerID)).stream().map(Lecture::getLectureID).collect(Collectors.toList());
        for (User student : students) {
            List<StudentDAO.Grade> grades = StudentDAO.Grade.getGrade(student.getID());
            for (StudentDAO.Grade grade : grades) {
                //if (lecturerCourseIDs.contains(grade.lectureID)) {
                //if (grade.lectureID.equals(lecturerCourseID)) {
                    studentsWithLectures.add(new StudentWithLecture(
                            ((Student) student).getID(),
                            ((Student) student).getName(),
                            ((Student) student).getEmail(),
                            grade.lectureID,
                            grade.lectureName,
                            grade.grade
                    ));
                //}
            }
        }
        LectureTable.setItems(studentsWithLectures);
    }
}
