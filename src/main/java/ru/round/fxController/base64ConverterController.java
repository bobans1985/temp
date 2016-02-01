package ru.round.fxController;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by GrishukovVM on 01.02.2016.
 */
public class base64ConverterController implements Initializable {
    public Button base64Converter;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize controller");
    }

    public void clickOnbtnExit(ActionEvent actionEvent) {
         Stage stage = (Stage) base64Converter.getScene().getWindow();
         stage.close();
    }
}
