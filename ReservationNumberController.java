package com.example.datepicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The two methods in this class will get the input from user and save them as a static method.
 * This holds the adult and kid count within the party
 */
public class ReservationNumberController {

    @FXML
    private TextField adultTextFieldID;

    @FXML
    private TextField kidsTextFieldID;
    static int adultCount = 0;

    static int kidCount = 0;




    @FXML
    public int adultTextField(ActionEvent event) {

        adultCount = Integer.parseInt(adultTextFieldID.getText());
        return adultCount;
    }

    @FXML
    int kidsTextField(ActionEvent event) {
        kidCount = Integer.parseInt(kidsTextFieldID.getText());
        return kidCount;
    }
    /**
     * This method gets the value from RestaurantPickerController and by using if else statements, displays the type of
     * menu that the user wanted to order from*/
    @FXML
    void nextBtn(ActionEvent event) throws IOException {
        adultCount = Integer.parseInt(adultTextFieldID.getText());
        kidCount = Integer.parseInt(kidsTextFieldID.getText());
        Stage stage = new Stage();
        String typeRes = RestaurantPickerController.typeRes;
        if ("American".equals(typeRes)) {
            FXMLLoader FoodPicker = new FXMLLoader(HelloApplication.class.getResource("AmericanFood.fxml"));
            stage.setScene(new Scene(FoodPicker.load(), 600, 700));
            stage.show();
        }
        else if ("Chinese".equals(typeRes)) {
            FXMLLoader FoodPicker = new FXMLLoader(HelloApplication.class.getResource("ChineseFood.fxml"));
            stage.setScene(new Scene(FoodPicker.load(), 600, 700));
            stage.show();
        }
        else if ("Italian".equals(typeRes)) {
            FXMLLoader FoodPicker = new FXMLLoader(HelloApplication.class.getResource("ItalianFood.fxml"));
            stage.setScene(new Scene(FoodPicker.load(), 600, 700));
            stage.show();
        }
        else if ("Mexican".equals(typeRes)) {
            FXMLLoader FoodPicker = new FXMLLoader(HelloApplication.class.getResource("MexicanFood.fxml"));
            stage.setScene(new Scene(FoodPicker.load(), 600, 700));
            stage.show();
        }


    }

}
