package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;

public class StudentHomePageController {

        @FXML
        private Button newStudentEmail;

        @FXML
        private Button newStudentID;

        @FXML
        private Button newStudentName;

        @FXML
        private Button newStudentPassword;

        @FXML
        private Button studentClass;

        @FXML
        private Button studentCourse;

        @FXML
        private Text studentEmail;

        @FXML
        private Text studentID;

        @FXML
        private Text StudName;

        @FXML
        private Text atopStudName;

        @FXML
        private Button studentScore;

        private Student userInfo;

        public StudentHomePageController(Student userInfo){
                this.userInfo = userInfo;
        }

        public StudentHomePageController() {
                // 无参构造器
        }

        public void setUserInfo(Student userInfo) {
                this.userInfo = userInfo;
                StudName.setText(userInfo.getName());
                atopStudName.setText(userInfo.getName());
                studentEmail.setText(userInfo.getEmail());
                studentID.setText(String.valueOf(userInfo.getID()));

        }


        @FXML
        void changeStudentEmail(ActionEvent event) {

        }

        @FXML
        void changeStudentID(ActionEvent event) {

        }

        @FXML
        void changeStudentName(ActionEvent event) {

        }

        @FXML
        void changeStudentPassword(ActionEvent event) {

        }


        @FXML
        void studentClassSchedule(ActionEvent event) throws IOException {
                Stage currentStage = (Stage) studentCourse.getScene().getWindow();
                currentStage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentCourses.fxml"));
                System.out.println(userInfo+"lwy");
                System.out.println("2");
                System.out.println(userInfo+"lwy2");
                Parent root = loader.load();
                System.out.println(userInfo);

                StudentCoursesController controller = loader.getController();
                System.out.println(userInfo+"3");
                controller.setStudentInfo(userInfo);
                System.out.println(userInfo+"4");
                //controller.initialize(null, null);

                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();
        }

        @FXML
        void studentCourseManagement(ActionEvent event) throws Exception {
                Stage currentStage = (Stage) studentCourse.getScene().getWindow();
                currentStage.close();


                FXMLLoader loader = new FXMLLoader(getClass().getResource("LectureChoosing.fxml"));
                Parent root = loader.load();
                LectureChoosingController controller = loader.getController();
                controller.setStudentInfo(userInfo);

                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();
        }

        @FXML
        void studentScoreInquiry(ActionEvent event) throws IOException {
                Stage currentStage = (Stage) studentScore.getScene().getWindow();
                currentStage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreInquiry.fxml"));
                Parent root = loader.load();
                ScoreInquiryController controller = loader.getController();
                controller.setStudentInfo(userInfo);

                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();

        }
}

