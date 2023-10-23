package com.example.datepicker;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class holds a static value of string and which ever button the user presses, it will save it in the static
 * variable
 */
public class RestaurantPickerController {

    static String typeRes;

    @FXML
    String americanBtn(ActionEvent event) throws IOException {
        typeRes = "American";
        System.out.print(typeRes);
        return typeRes;

    }

    @FXML
    String chineseBtn(ActionEvent event) throws IOException {
        typeRes = "Chinese";
        System.out.print(typeRes);
        return typeRes;

    }

    @FXML
    String italianBtn(ActionEvent event) throws IOException {
        typeRes = "Italian";
        System.out.print(typeRes);
        return typeRes;

    }

    @FXML
    String mexicanBtn(ActionEvent event) throws IOException {
        typeRes = "Mexican";
        System.out.print(typeRes);
        return typeRes;

    }

    /**
     * This method well move on to the datepicker in javafx when the button is pressed
     * @param event
     * @throws IOException
     */
    @FXML
    void nextBtn(ActionEvent event) throws IOException {
        String ReservationNumberController;
        Stage stage = new Stage();
        FXMLLoader DatePicker = new FXMLLoader(HelloApplication.class.getResource("DatePicker.fxml"));
        stage.setScene(new Scene(DatePicker.load(), 361, 262));
        DatePicker.getController();
        stage.show();

    }

}
