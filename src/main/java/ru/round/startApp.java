package ru.round;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.round.Utils.undecorator.UndecoratorScene;
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
        //Parent root =  (Parent) loader.load();
        Region root =  (Region) loader.load();
        mainController mc = loader.getController();
        //mc.setNativeMenu();

        primaryStage.setTitle("BankRound program");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/logo.png"));


        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        System.out.println("getWidth = " + primaryScreenBounds.getWidth());
        System.out.println("getHeight = " + primaryScreenBounds.getHeight());
        /*primaryStage.setWidth(primaryScreenBounds.getWidth()/100*50);
        primaryStage.setHeight(120);
        primaryStage.setX(primaryScreenBounds.getWidth()/2 -600);
        primaryStage.setY(0);*/
        primaryStage.centerOnScreen();

        //Scene scene = new Scene(root);
        //scene.setFill(Color.TRANSPARENT);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        //primaryStage.setScene(scene);
        //primaryStage.show();

        UndecoratorScene scene = new UndecoratorScene(primaryStage,root);
        primaryStage.setScene(scene);
        primaryStage.show();





    }
}
