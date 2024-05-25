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
    public TableView<lectureStudent> LectureTable;

    @FXML
    private TableView<Student> StudentTable;

    @FXML
    public TableView<Grade> GradeTable;

    @FXML
    private Button back;

    @FXML
    private Button check;

    @FXML
    private TableColumn<lectureStudent, String> lectureID;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<lectureStudent, String> name;

    @FXML
    private TextField input;

    @FXML
    private Button lectureChoosing;

    @FXML
    private TableColumn<lectureStudent, String> studentID;

    @FXML
    private TableColumn<lectureStudent, String> studentName;

    @FXML
    private TableColumn<lectureStudent, String> email;

    @FXML
    private Button newLecture;

    @FXML
    private Button refresh;

    @FXML
    private Button save;

    @FXML
    private TableColumn<lectureStudent, String> grade;

    private ObservableList<lectureStudent> lecturesData = FXCollections.observableArrayList();

    @FXML
    private Lecturer userInfo;
    @FXML
    private String lecturerCourseID;

    @FXML
    private TextField newGradeField;

    @FXML
    private Button updateGradeButton;




    public void LecturerScoreManagementController(Lecturer userInfo){
        //空构造器
    }

    public void setLecturerInfo(Lecturer userInfo){
        this.userInfo = userInfo;

        System.out.println(userInfo+"7777777777");
        initialize(null,null,userInfo);
        System.out.println(userInfo+"9999999999");
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

    @FXML
    void updateGradeButtonAction(ActionEvent event) {
        lectureStudent selectedStudent = LectureTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null && !newGradeField.getText().isEmpty()) {
            String newGrade = newGradeField.getText();
            selectedStudent.setGrade(newGrade);

            // 更新数据库中的成绩
            StudentDAO.updateStudentGrade(selectedStudent.getStudentID(), selectedStudent.getLectureID(), newGrade);

            // 刷新表格数据
            LectureTable.refresh();
        }
    }



    public void setLecturerCourseID(String lecturerCourseID) {
        this.lecturerCourseID = lecturerCourseID;
    }
    private void loadLectures(Lecturer lecturer) {
        System.out.println(lecturer+"test");
        if (lecturer != null) {
            List<Lecture> lectures = LecturerDAO.getAllLecturerCourses(lecturer);
            lecturesData.clear(); // 清除先前的数据

            // 将获取到的 Lecture 对象添加到数据源中


            for (Lecture lecture : lectures) {

                List<Student> students = StudentDAO.getStudentsByLectureID(lecture.getLectureID());
                //studentsData.clear();


                for (Student student : students) {
                    lectureStudent allInfo = new lectureStudent(lecture.getLectureID(), lecture.getName(), student.getName(), student.getID(), student.getEmail(), student.getGrade());
                    lecturesData.addAll(allInfo);
                }

            }
            LectureTable.setItems(lecturesData);
        }
    }


    public void initialize(URL location, ResourceBundle resources,User user) {
        lectureID.setCellValueFactory(cellData -> {
            String id = Optional.ofNullable(cellData.getValue())
                    .map(lectureStudent::getLectureID)
                    .orElse("null");
            return new SimpleStringProperty(id);
        });
        name.setCellValueFactory(cellData -> {
            String id = Optional.ofNullable(cellData.getValue())
                    .map(lectureStudent::getLectureName)
                    .orElse("null");
            return new SimpleStringProperty(id);
        });
        grade.setCellValueFactory(cellData -> {
            String id = Optional.ofNullable(cellData.getValue())
                    .map(lectureStudent::getGrade)
                    .orElse("null");
            return new SimpleStringProperty(id);
        });
        email.setCellValueFactory(cellData -> {
            String id = Optional.ofNullable(cellData.getValue())
                    .map(lectureStudent::getEmail)
                    .orElse("null");
            return new SimpleStringProperty(id);
        });
        // 初始化 StudentTable 的列绑定
        studentID.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getStudentID())));
        studentName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStudentName()));

        // 加载数据
        loadLectures(userInfo);

        // 修改成绩
        updateGradeButtonAction(null);
    }
}
