package ru.round.fxController;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.round.startApp;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by GrishukovVM on 21.12.2015.
 */
public class mainController {

    public Stage primaryStage;

    public Button btnExit;
    public Button bnt1;
    public Button btnOpenFile;

    public void clickOnbtnExit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }


    public void ClickOnbtn1(ActionEvent actionEvent) {
        Alert  alert = new Alert(Alert.AlertType.INFORMATION,"tesxt");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
        }
        System.out.printf("click on btn1");
    }

    public void clickOnbtnOpenFile(ActionEvent actionEvent) {

/*swing chooser multi dir*/
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setMultiSelectionEnabled(true);
        chooser.setDialogTitle("Выбирете каталоги, из которых нужно выдернуть документации");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.showOpenDialog(null);
        File[] files = chooser.getSelectedFiles();
        for  (File f : files) {
            System.out.println(f.getAbsolutePath());
        }



      /*  DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle("Open dir");
        dirChooser.showDialog(primaryStage);


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open  File");
       // fileChooser.showOpenDialog(primaryStage);
        fileChooser.showOpenMultipleDialog(primaryStage);
*/
    }
}
