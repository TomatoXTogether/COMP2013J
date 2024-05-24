package com.example.test;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class HelloApplication extends Application {


    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Login
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

    }



}



