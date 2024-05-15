package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField Account;

    @FXML
    private PasswordField Password;

    @FXML
    private ChoiceBox<String> choseIdentity;
    private String[] type = { "Student", "Lecturer"};

    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    private Button reset;

    @FXML
    void LoginAction(ActionEvent event) throws IOException {
        String account = Account.getText();
        String password = Password.getText();
        switch (choseIdentity.getValue()){
            case "Student":
                if (account.equals("") || password.equals("")){
                    System.out.println("Please enter your account and password");
                }
                else if (account.equals("1") && password.equals("1")){
                    System.out.println("Login Successfully");
                    Stage currentStage = (Stage) login.getScene().getWindow();
                    currentStage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                    Stage newStage = new Stage();
                    newStage.setScene(new Scene(root));
                    newStage.show();

                }
                else {
                    System.out.println("Wrong account or password");
                }
                break;
            case "Lecturer":
                if (account.equals("") || password.equals("")){
                    System.out.println("Please enter your account and password");
                }
                else if (account.equals("2") && password.equals("2")){
                    System.out.println("Login Successfully");
                }
                else {
                    System.out.println("Wrong account or password");
                }
                break;
        }

    }

    @FXML
    void RegisterAction(ActionEvent event) {

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

}