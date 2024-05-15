package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InitialInterfaceController {

    @FXML
    private Button Login;

    @FXML
    private Button Register;

    @FXML
    void loginBottonAction(ActionEvent event) throws IOException {
        Login login =new Login();
        login.start(new Stage());
    }

    @FXML
    void registerBottonAction(ActionEvent event) {

    }

}
