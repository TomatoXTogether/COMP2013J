package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

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

        @FXML
        void atopShowLecturerName(MouseEvent event) {
                String lecturerNameValue = lecturerName.getText();
                this.lecturerName.setText(lecturerNameValue);
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
        void lecturerClassSchedule(ActionEvent event) {

        }

        @FXML
        void lecturerCourseManagement(ActionEvent event) {

        }

        @FXML
        void lecturerScoreManagement(ActionEvent event) {

        }

        @FXML
        void showLecturerEmail(MouseEvent event) {

        }

        @FXML
        void showLecturerID(MouseEvent event) {

        }

        @FXML
        void showLecturerName(MouseEvent event) {

        }

        @FXML
        void showLecturerOffice(MouseEvent event) {

        }

}

