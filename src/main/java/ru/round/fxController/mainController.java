package ru.round.fxController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import ru.round.Utils.PrefSettings;
import ru.round.Utils.undecorator.Undecorator;
import ru.round.Utils.undecorator.UndecoratorScene;
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
import java.io.IOException;
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
            public void handle(ActionEvent arg0) {
                dialogStage.hide();
            }
        });
        dialogStage.show();

    }


    public void ClickOnbtn1(ActionEvent actionEvent) throws Exception {
        Alert alert = new Alert(AlertType.INFORMATION,"tesxt");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
        }
        System.out.printf("click on btn1");
        System.out.printf("Processing readme files for inversion patch");


//---------------------------------//---------------------------------//---------------------------------
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JOptionPane.showMessageDialog(null, "Swing alert in invokeLater");
                //JOptionPane.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
            }
        });
//---------------------------------//---------------------------------//---------------------------------

    }


    public void clickOnbtnOpenFile(ActionEvent actionEvent) throws Exception {
        System.out.printf("Processing readme files for inversion patch");
        PrefSettings pref = new PrefSettings();



        if (os != null && !os.startsWith("Mac")) {
            /*swing chooser multi dir*/

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                JFileChooser chooser = new JFileChooser(pref.GetDirFromReadme());


                chooser.setMultiSelectionEnabled(true);
                chooser.setDialogTitle("Выбирете каталоги, из которых нужно выдернуть документации");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.showOpenDialog(null);
                File[] DirFromReadme = chooser.getSelectedFiles();
                pref.SetDirFromReadme(chooser);

                chooser.setCurrentDirectory(new File(pref.GetDirToReadme()));
                chooser.setDialogTitle("Выбирете каталог, куда будете сохранять");
                chooser.setMultiSelectionEnabled(false);
                chooser.showOpenDialog(null);

                if (DirFromReadme != null && chooser.getSelectedFile() != null) {
                    String DirToReadme = chooser.getSelectedFile().getAbsolutePath().toString();
                    pref.SetDirToReadme(chooser);
                    System.out.println(DirToReadme);


                    for (File dirFrom : DirFromReadme) {
                        File[] dirsInFolder = dirFrom.listFiles();
                        for (File dirInFolder : dirsInFolder) {
                            if (dirInFolder.getName().toUpperCase().contains("README")) {
                                //System.out.println(dirInFolder.getName());
                                File[] FileInFolder = dirInFolder.listFiles();
                                for (File f : FileInFolder) {
                                    if (f.isFile()) {
                                        File destFile = new File(DirToReadme + "/" + dirFrom.getName() + "_" + f.getName());
                                        System.out.println("file = " + destFile.toString());
                                        fileOperations.copyFile(f, destFile);
                                    }
                                }
                            }
                        }

                    }
                    Alert  alert = new Alert(AlertType.INFORMATION,"Обработка прошла успешно");alert.show();

                } else throw new IOException("Folder is not marked");

            } catch (Exception ex) {
                Alert  alert = new Alert(AlertType.ERROR,"Произошла непредвиденная ошибка: " + ex);
                alert.show();
            }

        } else {
            Alert  alert = new Alert(AlertType.ERROR,"This function not work in Mac OS");
            //alert.setHeaderText("Error");
            //alert.setTitle("Error");
            alert.show();
        }

    }


    public void clickOnbtnBase64Converter(ActionEvent actionEvent) throws Exception{
       System.out.println("Click on clickOnbtnBase64Converter");


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/base64Converter.fxml"));
        Region root = (Region) loader.load();
        base64ConverterController mc = loader.getController();
        Stage stage = new Stage();
        stage.setResizable(false);
        UndecoratorScene scene = new UndecoratorScene(stage,root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }


    public void setNativeMenu() {
        btnExit.setText("test");
    }


}

