package com.example.test;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            //primaryStage.setTitle("Hello!");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

    }


}



