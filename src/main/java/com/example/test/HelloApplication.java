package com.example.test;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("InitialInterface.fxml"));
            //primaryStage.setTitle("Hello!");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();


/*
        Label welcome = new Label("Welcome to Lecture Management System");
        welcome.setFont(new Font(30));//字体大小

        Button login = new Button("Login");
        Button register = new Button("Register");
        login.setPrefSize(100, 50);
        register.setPrefSize(100, 50);

        GridPane gr = new GridPane();

        //gr.setStyle("-fx-background-color: #ffffff");
        gr.add(welcome, 1, 1);
        gr.add(register, 1, 3);
        gr.add(login, 1, 3);

        gr.setAlignment(Pos.CENTER);
        gr.setHgap(10);//设置水平间距
        gr.setVgap(17);//设置垂直间距
        GridPane.setMargin(login, new Insets(0, 0, 0, 300));


        //Register
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        //Log in
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Login login = new Login();//Open login window
                    login.start(primaryStage);
                    primaryStage.close();
            }

        });


        Scene scene = new Scene(gr);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Lecture Management System");
        primaryStage.setWidth(1200);
        primaryStage.setHeight(1000);
        primaryStage.setResizable(false);
        primaryStage.show();

*/
    }


}



