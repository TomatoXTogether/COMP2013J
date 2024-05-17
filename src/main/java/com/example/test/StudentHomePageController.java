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
        private Text studentName;

        @FXML
        private Button studentScore;

        private LoginController lc;

        @FXML
        void atopShowStudentName(MouseEvent event) {
                Student st = (Student) lc.user;
                studentName.setText(st.getName());
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
        void showStudentEmail(MouseEvent event) {

        }

        @FXML
        void showStudentID(MouseEvent event) {

        }

        @FXML
        void showStudentName(MouseEvent event) {

        }

        @FXML
        void studentClassSchedule(ActionEvent event) {

        }

        @FXML
        void studentCourseManagement(ActionEvent event) throws Exception {
                Stage currentStage = (Stage) studentCourse.getScene().getWindow();
                currentStage.close();
                Parent root = FXMLLoader.load(getClass().getResource("LectureChoosing.fxml"));
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();
        }

        @FXML
        void studentScoreInquiry(ActionEvent event) {


        }
}

