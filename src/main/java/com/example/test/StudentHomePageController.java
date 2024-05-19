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

        }

        @FXML
        void studentCourseManagement(ActionEvent event) throws Exception {
                Stage currentStage = (Stage) studentCourse.getScene().getWindow();
                currentStage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LectureChoosing.fxml"));
                Parent root = loader.load();
                LectureChoosingController controller = loader.getController();
                controller.setStudentInfo(userInfo);
                //Parent root = FXMLLoader.load(getClass().getResource("LectureChoosing.fxml"));
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
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();

        }
}

