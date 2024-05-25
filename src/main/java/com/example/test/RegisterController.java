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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private TextField Account;

    @FXML
    private TextField Password;

    @FXML
    private Text account;

    @FXML
    private ChoiceBox<String> choseIdentity;

    private final String[] type = { "Student", "Lecturer"};

    @FXML
    private Text email;

    @FXML
    private TextField emailText;

    @FXML
    private Label errorMessageForEmpty;

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private Text name;

    @FXML
    private Text firstName;

    @FXML
    private Text lastName;

    @FXML
    private TextField nameText;

    @FXML
    private Text office;

    @FXML
    private TextField officeText;

    @FXML
    private Text password;

    @FXML
    private Button register;

    @FXML
    private Button reset;

    @FXML
    private Button save;

    @FXML
    void RegisterAction(ActionEvent event) throws IOException {
        try {
            if(Objects.equals(nameText.getText(), "") || Objects.equals(emailText.getText(), "") || Objects.equals(firstNameText.getText(), "") || Objects.equals(lastNameText.getText(), "") || Objects.equals(officeText.getText(), "")) {
                errorMessageForEmpty.setVisible(true);
            }else {
                int newAccount = Integer.parseInt(Account.getText());
                int newPassword = Integer.parseInt(Password.getText());
                String newName = nameText.getText();
                String newEmail = emailText.getText();
                String newFirstName = firstNameText.getText();
                String newLastName = lastNameText.getText();
                String newOffice = officeText.getText();

                switch (choseIdentity.getValue()) {
                    case "Student":
                        Student newStudent = new Student(newAccount, newName, newPassword, newEmail);
                        StudentDAO.registerStudent(newStudent);
                        break;

                    case "Lecturer":
                        Lecturer newLecturer = new Lecturer(newAccount, newFirstName, newLastName, newPassword, newEmail, newOffice);
                        LecturerDAO.registerLecturer(newLecturer);
                        break;
                    default:
                        break;

                }
                Stage currentStage = (Stage) register.getScene().getWindow();
                currentStage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
                Parent root;
                root = loader.load();
                LoginController controller = loader.getController();
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();
            }

        } catch (NumberFormatException e) {
                errorMessageForEmpty.setVisible(true);
        }
    }

    @FXML
    void ResetAction(ActionEvent event) {
        switch (choseIdentity.getValue()) {
            case "Student":
                Account.setText("");
                Password.setText("");
                nameText.setText("");
                emailText.setText("");
                break;

            case "Lecturer":
                Account.setText("");
                Password.setText("");
                emailText.setText("");
                firstNameText.setText("");
                lastNameText.setText("");
                officeText.setText("");
                break;
        }
    }

    @FXML
    void choseIdentity(MouseEvent event) {
        choseIdentity.getItems().addAll(type);

    }

    @FXML
    void enterAccount(ActionEvent event) {

    }

    @FXML
    void enterEmail(ActionEvent event) {

    }

    @FXML
    void enterFirstName(ActionEvent event) {

    }

    @FXML
    void enterLastName(ActionEvent event) {

    }

    @FXML
    void enterName(ActionEvent event) {

    }

    @FXML
    void enterOffice(ActionEvent event) {

    }

    @FXML
    void enterPassword(ActionEvent event) {

    }
    @FXML
    void saveBottonAction(ActionEvent event) {
        switch (choseIdentity.getValue()) {
            case "Student":
                reset.setVisible(true);
                register.setVisible(true);
                Account.setVisible(true);
                account.setVisible(true);
                name.setVisible(true);
                nameText.setVisible(true);
                email.setVisible(true);
                emailText.setVisible(true);
                password.setVisible(true);
                Password.setVisible(true);
                firstName.setVisible(false);
                firstNameText.setVisible(false);
                lastName.setVisible(false);
                lastNameText.setVisible(false);
                office.setVisible(false);
                officeText.setVisible(false);


                break;

            case "Lecturer":
                reset.setVisible(true);
                register.setVisible(true);
                Account.setVisible(true);
                account.setVisible(true);
                firstName.setVisible(true);
                firstNameText.setVisible(true);
                lastName.setVisible(true);
                lastNameText.setVisible(true);
                email.setVisible(true);
                emailText.setVisible(true);
                office.setVisible(true);
                officeText.setVisible(true);
                password.setVisible(true);
                Password.setVisible(true);
                name.setVisible(false);
                nameText.setVisible(false);

                break;

            default:

                break;
        }
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
}
