package ru.round.fxController;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.xml.bind.DatatypeConverter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.ResourceBundle;

/**
 * Created by GrishukovVM on 01.02.2016.
 */
public class base64ConverterController implements Initializable {
    public Button base64Converter;
    public Button ToPlainTextBtn;
    public Button ToBase64Btn;
    public TextArea TextBase64Box;
    public TextArea TextPlainBox;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize controller");
    }

    public void clickOnbtnExit(ActionEvent actionEvent) {
         Stage stage = (Stage) base64Converter.getScene().getWindow();
         stage.close();
    }

    public void ClickOnBtnToPlainText(ActionEvent actionEvent) {
        try {
            //String base64Str = Base64.getEncoder().withoutPadding().encodeToString(TextBase64Box.getText().getBytes());
            String base64Str = Base64.getEncoder().encodeToString(TextBase64Box.getText().getBytes(StandardCharsets.UTF_8));
            System.out.println(base64Str);
            TextPlainBox.setText(base64Str);
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"ClickOnBtnToPlainText | Произошла непредвиденная ошибка: " + ex);
            alert.show();
        }
    }

    public void ClickOnBtnToBase64(ActionEvent actionEvent) {
        try {
            byte[] base64Bytes = DatatypeConverter.parseBase64Binary(TextPlainBox.getText());
            TextBase64Box.setText(new String(base64Bytes,StandardCharsets.UTF_8));
            System.out.println(new String(base64Bytes));
            /*byte[] base64Bytes = Base64.getDecoder().decode(TextPlainBox.getText());
            System.out.println(new String(base64Bytes));
            TextBase64Box.setText(new String(base64Bytes,StandardCharsets.UTF_8));*/
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"ClickOnBtnToBase64 | Произошла непредвиденная ошибка: " + ex);
            alert.show();
    }


    }
}
