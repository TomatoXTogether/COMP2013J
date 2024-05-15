package com.example.test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {

    @FXML
    private ChoiceBox<String> choseIdentity;
    private final String[] ID = { "Student", "Lecturer" };

    @FXML
    private Button login;

    @FXML
    private Button reset;

    public static String Acc;
    public static String Pas;

    private final Stage stage = new Stage();


    public Login(){
        this.login=login;
        this.reset=reset;

    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //primaryStage.setTitle("Hello!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        stage.close();
    }


    @FXML
    void Login(ActionEvent event) {

    }

    @FXML
    void Reset(ActionEvent event) {

    }

    @FXML
    void choseIdentity(MouseEvent event) {

    }

    @FXML
    void enterAccount(ActionEvent event) {

    }

    @FXML
    void enterPassword(ActionEvent event) {

    }
    public static void main(String[] args) {
        launch(args);
    }

}
