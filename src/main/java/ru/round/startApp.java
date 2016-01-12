package ru.round;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.round.fxController.mainController;

import javax.swing.*;

/**
 * Created by GrishukovVM on 21.12.2015.
 */
public class startApp extends Application {


    public static void main(String[] args) {
       System.out.println("Start project");
       launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainForm.fxml"));
        Parent root =  (Parent) loader.load();
        mainController mc = loader.getController();
        //mc.setNativeMenu();

        primaryStage.setTitle("BankRound program");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/logo.png"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();





    }
}
