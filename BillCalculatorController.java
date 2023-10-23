package com.example.datepicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import static com.example.datepicker.ReservationNumberController.*;


public class BillCalculatorController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.15);

    @FXML
    private Label amount;

    @FXML
    private Label people;

    @FXML
    private TextField splitTotalTextField;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private TextField partyszeTextFieldID;

    @FXML
    private TextField amountTextFieldID;


    @FXML
    void calculateButtonPressed(ActionEvent event) {
        String typeRes = RestaurantPickerController.typeRes;
        if ("American".equals(typeRes)) {
                BigDecimal cart_total_dec = new BigDecimal(AmericanFoodController.cart_total);
                BigDecimal adultCountdec = new BigDecimal(adultCount);
                BigDecimal tip = cart_total_dec.multiply(tipPercentage);
                BigDecimal total = cart_total_dec.add(tip);
                BigDecimal totalSplit = total.divide(adultCountdec, RoundingMode.HALF_UP);
                tipTextField.setText(currency.format(tip));
                totalTextField.setText(currency.format(total));
                splitTotalTextField.setText(currency.format(totalSplit));
            }
        else if ("Chinese".equals(typeRes)) {
                    BigDecimal cart_total_dec = new BigDecimal(ChineseFoodController.cart_total);
                    BigDecimal adultCountdec = new BigDecimal(ReservationNumberController.adultCount);
                    BigDecimal tip = cart_total_dec.multiply(tipPercentage);
                    BigDecimal total = cart_total_dec.add(tip);
                    BigDecimal totalSplit = total.divide(adultCountdec);
                    tipTextField.setText(currency.format(tip));
                    totalTextField.setText(currency.format(total));
                    splitTotalTextField.setText(currency.format(totalSplit));
                }
        else if ("Italian".equals(typeRes)) {
            if (ReservationNumberController.adultCount >= 6) {
                BigDecimal cart_total_dec = new BigDecimal(ItalianFoodController.cart_total);
                BigDecimal adultCountdec = new BigDecimal(ReservationNumberController.adultCount);
                BigDecimal tip = cart_total_dec.multiply(tipPercentage);
                BigDecimal total = cart_total_dec.add(tip);
                BigDecimal totalSplit = total.divide(adultCountdec, RoundingMode.DOWN);
                tipTextField.setText(currency.format(tip));
                totalTextField.setText(currency.format(total));
                splitTotalTextField.setText(currency.format(totalSplit));
            }
        }
        else if ("Mexican".equals(typeRes)) {
            if (ReservationNumberController.adultCount >= 6) {
                BigDecimal cart_total_dec = new BigDecimal(MexicanFoodController.cart_total);
                BigDecimal adultCountdec = new BigDecimal(ReservationNumberController.adultCount);
                BigDecimal tip = cart_total_dec.multiply(tipPercentage);
                BigDecimal total = cart_total_dec.add(tip);
                BigDecimal totalSplit = total.divide(adultCountdec);
                tipTextField.setText(currency.format(tip));
                totalTextField.setText(currency.format(total));
                splitTotalTextField.setText(currency.format(totalSplit));
            }

        }

    }
    public void initialize() {
        partyszeTextFieldID.setText(String.format("%d", ReservationNumberController.adultCount));
        String typeRes = RestaurantPickerController.typeRes;
        if ("American".equals(typeRes)) {
            amountTextFieldID.setText(String.format("%.2f", AmericanFoodController.cart_total));
        } else if ("Chinese".equals(typeRes)) {
            amountTextFieldID.setText(String.format("%.2f", ChineseFoodController.cart_total));
       } else if ("Italian".equals(typeRes)) {
            amountTextFieldID.setText(String.format("%.2f", ItalianFoodController.cart_total));
       } else if ("Mexican".equals(typeRes)) {
            amountTextFieldID.setText(String.format("%,2f", MexicanFoodController.cart_total));
       }
        if (ReservationNumberController.adultCount >= 6) {
            currency.setRoundingMode(RoundingMode.HALF_UP);

            tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                    tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                    tipPercentageLabel.setText(percent.format(tipPercentage));
                }

            }
            );
        }

    }
}
