package ru.round.fxController;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import ru.round.startApp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;


import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import ru.round.Utils.fileOperations;


/**
 * Created by GrishukovVM on 21.12.2015.
 */
public class mainController implements Initializable {

    public Stage primaryStage;

    public Button btnExit;
    public Button bnt1;
    public Button btnOpenFile;
    public MenuBar mainMenuBar;
    final String os = System.getProperty("os.name");
    private Stage dialogStage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize controller");

        //Если мак - то используем нативное маковское меню
        if (os != null && os.startsWith("Mac"))
            mainMenuBar.useSystemMenuBarProperty().set(true);
    }


    public void clickOnbtnExit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    public void ClickOnMenuAbout(ActionEvent actionEvent) {
        System.out.printf("click on ClickOnMenuAbout");

        dialogStage = new Stage();
        BorderPane bPane = new BorderPane();

        Scene scene =new Scene(bPane,300,150);
        dialogStage.setScene(scene);
        dialogStage.setTitle("О программе");
        dialogStage.setResizable(false);
        dialogStage.setMaximized(false);
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        Label text_on_dialog = new Label("О программе О программе О программе О программе О программе О программе О программе О программе О программе О программе О программе О программе О программе ");
        text_on_dialog.setWrapText(true);
        bPane.setCenter(text_on_dialog);
        bPane.setPadding(new Insets(15));


        Button btn_close = new Button("Закрыть");
        HBox hbox = new HBox(5);
        hbox.setPadding(new Insets(5));
        hbox.getChildren().addAll(btn_close);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        bPane.setBottom(hbox);




        btn_close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                dialogStage.hide();
            }
        });
        dialogStage.show();

    }


    public void ClickOnbtn1(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION,"tesxt");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
        }
        System.out.printf("click on btn1");
    }


    public void clickOnbtnOpenFile(ActionEvent actionEvent) {
        System.out.printf("Processing readme files for inversion patch");

        if (os != null && !os.startsWith("Mac")) {
            /*swing chooser multi dir*/
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setMultiSelectionEnabled(true);
            chooser.setDialogTitle("Выбирете каталоги, из которых нужно выдернуть документации");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.showOpenDialog(null);
            File[] DirFromReadme = chooser.getSelectedFiles();

            chooser.setDialogTitle("Выбирете каталог, куда будете сохранять");
            chooser.setMultiSelectionEnabled(false);
            chooser.showOpenDialog(null);
            File[] DirToReadme = chooser.getSelectedFiles();
            for (File dirFrom : DirFromReadme) {
                System.out.println(dirFrom.getAbsolutePath());
                File[] filesToCopy = dirFrom.listFiles();
                for (File f : filesToCopy) {
                    if (f.isFile()) {
                        // fileOperations.copyFile(f,DirToReadme[0]);
                    }
                }

            }

/*
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle("Open dir");
        dirChooser.showDialog(primaryStage);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open  File");
       // fileChooser.showOpenDialog(primaryStage);
        fileChooser.showOpenMultipleDialog(primaryStage);*/


        } else {
            Alert  alert = new Alert(AlertType.ERROR,"This function not work in Mac OS");
            //alert.setHeaderText("Error");
            //alert.setTitle("Error");
            alert.show();
        }

    }



    public void setNativeMenu() {
        btnExit.setText("test");
    }
}

