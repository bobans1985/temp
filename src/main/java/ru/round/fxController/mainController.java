package ru.round.fxController;
//test
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.round.startApp;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by GrishukovVM on 21.12.2015.
 */
public class mainController implements Initializable {

    public Stage primaryStage;

    public Button btnExit;
    public Button bnt1;
    public Button btnOpenFile;
    public MenuBar mainMenuBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize controller");
        final String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Mac"))
            mainMenuBar.useSystemMenuBarProperty().set(true);
    }


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


    ///testfgsafdhjsdfm
    public void clickOnbtnOpenFile(ActionEvent actionEvent) {
        System.out.printf("click on btn2");

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

/*

        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle("Open dir");
        dirChooser.showDialog(primaryStage);


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open  File");
       // fileChooser.showOpenDialog(primaryStage);
        fileChooser.showOpenMultipleDialog(primaryStage);*/

    }



    public void setNativeMenu() {
        btnExit.setText("test");
    }
}

