package ru.round;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        Parent root = FXMLLoader.load(getClass().getResource("/mainForm.fxml"));
        primaryStage.setTitle("BankRound program");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
