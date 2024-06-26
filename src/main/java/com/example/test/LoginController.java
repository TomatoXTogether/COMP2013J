
package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField Account;

    @FXML
    private PasswordField Password;

    @FXML
    private ChoiceBox<String> choseIdentity;

    private final String[] type = { "Student", "Lecturer"};

    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    private Button reset;

    @FXML
    private Label errorMessageForEmpty;

    @FXML
    private Label errorMessageForWrong;

    @FXML
    private Label errorMessageForWrong1;

    private String account;

    private String password;



    @FXML
    void LoginAction(ActionEvent event) throws IOException {
        this.account = Account.getText();
        this.password = Password.getText();
        if (choseIdentity.getValue()== null) {
            errorMessageForEmpty.setVisible(false);
            errorMessageForWrong.setVisible(false);
            errorMessageForWrong1.setVisible(true);
            return;
        }

        switch (choseIdentity.getValue()){
            case "Student":
                List<User> students = StudentDAO.getAllStudents();
                if (account.equals("") || password.equals("")){
                    errorMessageForWrong1.setVisible(false);
                    errorMessageForWrong.setVisible(false);
                    errorMessageForEmpty.setVisible(true);
                }
                Student student = (Student) getUser(account, password, students);
                if ( student!= null){
                    Stage currentStage = (Stage) login.getScene().getWindow();
                    currentStage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentHomePage.fxml"));
                    Parent root = loader.load();
                    StudentHomePageController controller = loader.getController();
                    controller.setUserInfo(student);
                    Stage newStage = new Stage();
                    newStage.setScene(new Scene(root));
                    newStage.show();

                }
                else {
                    errorMessageForWrong1.setVisible(false);
                    errorMessageForEmpty.setVisible(false);
                    errorMessageForWrong.setVisible(true);
                }
                break;
            case "Lecturer":
                List<User> lectures = LecturerDAO.getAllLecturers();
                if (account.equals("") || password.equals("")){
                    errorMessageForWrong1.setVisible(false);
                    errorMessageForWrong.setVisible(false);
                    errorMessageForEmpty.setVisible(true);
                }
                Lecturer lecturer = (Lecturer) getUser(account, password, lectures);
                if (lecturer != null){
                    Stage currentStage = (Stage) login.getScene().getWindow();
                    currentStage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("LecturerHomePage.fxml"));
                    Parent root;
                    root = loader.load();
                    LecturerHomePageController controller = loader.getController();
                    controller.setUserInfo(lecturer);
                    Stage newStage = new Stage();
                    newStage.setScene(new Scene(root));
                    newStage.show();
                }
                else {
                    errorMessageForWrong1.setVisible(false);
                    errorMessageForEmpty.setVisible(false);
                    errorMessageForWrong.setVisible(true);
                }
                break;
            default:
                errorMessageForEmpty.setVisible(false);
                errorMessageForWrong.setVisible(false);
                errorMessageForWrong1.setVisible(true);
                if (account.equals("") || password.equals("")){
                    errorMessageForWrong.setVisible(false);
                    errorMessageForEmpty.setVisible(true);
                }
                break;
        }

    }

    @FXML
    void RegisterAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) login.getScene().getWindow();
        currentStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
        Parent root;
        root = loader.load();
        RegisterController controller = loader.getController();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    @FXML
    void ResetAction(ActionEvent event) {
        Account.setText("");
        Password.setText("");
    }

    @FXML
    void choseIdentity(MouseEvent event) {
        choseIdentity.getItems().addAll(type);
    }

    @FXML
    void enterAccount(ActionEvent event) {

    }

    @FXML
    void enterPassword(ActionEvent event) {

    }

    TextFormatter<String> accountFormatter = new TextFormatter<>(change -> {
        String newText = change.getControlNewText();
        if (newText.matches("\\d*")&& newText.length() <= 8) {
            return change;
        } else {
            return null;
        }
    });

    TextFormatter<String> passwordFormatter = new TextFormatter<>(change -> {
        String newText = change.getControlNewText();
        if (newText.matches("[a-zA-Z0-9]*")&& newText.length() <=10) {
            return change;
        } else {
            return null;
        }
    });



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choseIdentity.getItems().addAll(type);

        // Set the TextFormatter for the Account TextField
        Account.setTextFormatter(accountFormatter);

        // Set the TextFormatter for the Password TextField
        Password.setTextFormatter(passwordFormatter);
    }

    public User getUser(String account, String password, List<User> users) {
        for (User user : users) {
            if (String.valueOf(user.getID()).equals(account) && String.valueOf(user.getPassword()).equals(password)) {
                return user;
            }
        }
        return null;
    }

}
