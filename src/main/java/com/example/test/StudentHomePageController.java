package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the Student Home Page, managing UI components and user interactions.
 */
public class StudentHomePageController {
        // UI Components injected by FXML
        @FXML
        private Button changeStudentPassword;

        @FXML
        private TextField newPasswordText;

        @FXML
        private Button save;

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

        @FXML
        private Button backToLogin;

        private Student userInfo;

        /**
         * Constructor with Student parameter to initialize controller with student data.
         *
         * @param userInfo the Student object containing user details
         */
        public StudentHomePageController(Student userInfo){
                this.userInfo = userInfo;
        }

        /**
         * Default constructor for the controller.
         */
        public StudentHomePageController() {
                // Empty constructor
        }

        /**
         * Sets the user information and updates the displayed text fields accordingly.
         *
         * @param userInfo the Student object to be displayed and managed
         */
        public void setUserInfo(Student userInfo) {
                this.userInfo = userInfo;
                StudName.setText(userInfo.getName());
                atopStudName.setText(userInfo.getName());
                studentEmail.setText(userInfo.getEmail());
                studentID.setText(String.valueOf(userInfo.getID()));
        }

        @FXML
        void backToLoginBottonAction(ActionEvent event) throws IOException {
                Stage currentStage = (Stage) backToLogin.getScene().getWindow();
                currentStage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
                Parent root = loader.load();

                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();
        }

        @FXML
        void changeStudentPassword(ActionEvent event) {
                newPasswordText.setVisible(true);
                save.setVisible(true);
        }

        @FXML
        void saveNewPassword(ActionEvent event) {
                int newPassword = Integer.parseInt(newPasswordText.getText());
                StudentDAO.changePassword(userInfo, newPassword);
                newPasswordText.setVisible(false);
                save.setVisible(false);
        }


        // Navigation methods to other pages
        @FXML
        void studentClassSchedule(ActionEvent event) throws IOException {
                Stage currentStage = (Stage) studentClass.getScene().getWindow();
                currentStage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentCourses.fxml"));
                Parent root = loader.load();
                StudentCoursesController controller = loader.getController();
                controller.setStudentInfo(userInfo);

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

