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

}

