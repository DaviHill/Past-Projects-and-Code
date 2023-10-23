package com.example.datepicker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class applicationController {
    public RestaurantPickerController type;

    @FXML
    private DatePicker myRestuarantDatePicker;

    @FXML
    private Label myRestuarantLabel;

    @FXML
    public String getDate(ActionEvent event) {
        String[] invalidDates = {"01-01-2023", "01-16-2023", "05-29-2023", "07-04-2023", "09-04-2023", "11-23-2023", "12-25-2023"};
        LocalDate myDate = myRestuarantDatePicker.getValue();
        String myDateFormatted = myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        boolean pass = false;
        while(pass) {
            for (String invalidDate : invalidDates) {
                if (myDateFormatted.equals(invalidDate)) {
                    myRestuarantLabel.setText("This is a Holiday date. Please choose another date: ");
                }
            }
            pass = true;
        }
        return myDateFormatted;
    }


    @FXML
    void nextButton(ActionEvent event) throws IOException {
            Stage stage = new Stage();
            FXMLLoader ReservationNum = new FXMLLoader(HelloApplication.class.getResource("ReservationNumber.fxml"));
            stage.setScene(new Scene(ReservationNum.load(), 522, 182));
            stage.show();

        }

}

