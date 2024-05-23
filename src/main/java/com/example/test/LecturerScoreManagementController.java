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
import java.util.List;
import java.util.ResourceBundle;
import com.example.test.Student;
import java.util.ArrayList;

public class LecturerScoreManagementController implements Initializable {

    @FXML
    private TableView<Lecture> LectureTable;

    @FXML
    private Button back;

    @FXML
    private Button check;

    @FXML
    private TableColumn<Lecture, String> lectureID;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<LecturerDAO, String> lectureName;

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
    private TableColumn<StudentDAO, String> grade;

    private ObservableList<Lecture> lecturesData = FXCollections.observableArrayList();

    @FXML
    private  Lecturer userInfo;
    @FXML
    private String lecturerCourseID;



    public void LecturerScoreManagementController(Lecturer userInfo){
        //空构造器
    }

    public void setLecturerInfo(Lecturer userInfo){
        this.userInfo = userInfo;
        initialize(null, null);
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


    public void setLecturerCourseID(String lecturerCourseID) {
        this.lecturerCourseID = lecturerCourseID;
    }
    private void loadLectures() {
        if (userInfo != null) {
            List<Lecture> lectures = LectureDAO.getLecturesByLecturerID(String.valueOf(userInfo.getID()));

            lecturesData.clear(); // 清除先前的数据

            // 将获取到的 Lecture 对象添加到数据源中
            lecturesData.addAll(lectures);
        }
        /*if (userInfo != null) {
            List<Lecture> lectures = LectureDAO.getLecturesByLecturerID(String.valueOf(userInfo.getID()));

            LectureTable.getItems().clear(); // 清除先前的数据

            for (Lecture lecture : lectures) {
                // 创建一个 Student 对象，并使用 Lecture 的相关信息进行初始化
                Student student = new Student(0, lecture.getName(), 0, lecture.getLecturerName());
                // 将学生对象添加到表格中
                //LectureTable.getItems().add(student);
            }
        }*/
    }

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller initialized");
        loadLectures();
        System.out.println(userInfo);
        lectureID.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLectureID())));
        /*lectureID.setCellValueFactory(cellData -> {
            String id = cellData.getValue().getLectureID();
            System.out.println("lectureID: " + id); // 添加打印语句
            return new SimpleStringProperty(id);
        });*/
        /*lectureName.setCellValueFactory(cellData -> new SimpleStringProperty(LecturerDAO.getLectureNameByID(String.valueOf(cellData.getValue().getLectureID()))));
        lectureName.setCellValueFactory(cellData -> new SimpleStringProperty(LecturerDAO.getLectureNameByID(String.valueOf(lectureID))));*/
        studentID.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getID())));
        studentName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        LectureTable.setItems(lecturesData);
        /*grade.setCellValueFactory(cellData -> new SimpleStringProperty(StudentDAO.Grade.getGrade(Integer.parseInt(lectureID.getText())).toString()));*/
        refreshBottonAction(null);

    }

}
