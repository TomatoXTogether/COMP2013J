package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LecturerHomePageController {

        @FXML
        private Button lecturerClass;

        @FXML
        private Button lecturerCourse;

        @FXML
        private Text lecturerEmail;

        @FXML
        private Text lecturerID;

        @FXML
        private Text lecturerName;

        @FXML
        private Text lecturerOffice;

        @FXML
        private Button lecturerScore;

        @FXML
        private Button newLecturerEmail;

        @FXML
        private Button newLecturerID;

        @FXML
        private Button newLecturerName;

        @FXML
        private Button newLecturerOffice;

        @FXML
        private Button newLecturerPassword;

        @FXML
        private Text welcomeLecturerName;

        private Lecturer userInfo;

        public LecturerHomePageController(Lecturer userInfo){
                this.userInfo = userInfo;
        }

        public LecturerHomePageController() {
                // 无参构造器
        }

        public void setUserInfo(Lecturer userInfo) {
                this.userInfo = userInfo;
                lecturerName.setText(userInfo.getFirstname() + " " + userInfo.getLastname());
                lecturerOffice.setText(userInfo.getOffice());
                lecturerEmail.setText(userInfo.getEmail());
                lecturerID.setText(String.valueOf(userInfo.getID()));
                welcomeLecturerName.setText(userInfo.getFirstname() + " " + userInfo.getLastname());
        }

        @FXML
        void lecturerCourseManagement(ActionEvent event) throws IOException {
                Stage currentStage = (Stage) lecturerCourse.getScene().getWindow();
                currentStage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LecturerCourse.fxml"));
                Parent root = loader.load();
                LecturerCoursesManagementController controller = loader.getController();
                controller.setLecturerInfo(userInfo);
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();
        }
        @FXML
        void lecturerClassSchedule(ActionEvent event) throws IOException {
                Stage currentStage = (Stage) lecturerCourse.getScene().getWindow();
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
        void changeLecturerEmail(ActionEvent event) {

        }

        @FXML
        void changeLecturerID(ActionEvent event) {

        }

        @FXML
        void changeLecturerName(ActionEvent event) {

        }

        @FXML
        void changeLecturerOffice(ActionEvent event) {

        }

        @FXML
        void changeLecturerPassword(ActionEvent event) {

        }




        @FXML
        void lecturerScoreManagement(ActionEvent event) throws IOException{
                Stage currentStage = (Stage) lecturerCourse.getScene().getWindow();
                currentStage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LecturerScoreManagement.fxml"));
                Parent root = loader.load();
                LecturerScoreManagementController controller = loader.getController();
                controller.setLecturerInfo(userInfo);
                System.out.println(userInfo);
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();
        }

}

