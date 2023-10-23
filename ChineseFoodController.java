package com.example.datepicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class ChineseFoodController {


    // represents the number of unique items in the cart
    private int cart_len = 0;
    // total cost of cart
    static double cart_total = 0;
    private MenuItem[] cart = new MenuItem[100];
    @FXML
    private AnchorPane CartAnchor;
    @FXML
    private Text CartText;
    @FXML
    private TextArea TotalText;


    // buttons to add items to cart array
    @FXML
    void Appetizers1Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Appetizers", "Vegetable Spring Rolls", "", 5.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Appetizers2Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Appetizers", "Pork Dumplings", "", 5.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Appetizers3Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Appetizers", "Crab Ragoon", "", 5.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Appetizers4Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Appetizers", "Lettuce Wraps", "", 5.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Beverages1Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Beverages", "Water", "", 1.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Beverages2Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Beverages", "Fountain Drink", "", 3.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Beverages3Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Beverages", "Bubble Tea", "", 3.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Beverages4Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Beverages", "Kombucha", "", 3.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Desserts1Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Desserts", "Fried Ice Cream", "", 10.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Desserts2Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Desserts", "Chinese Donuts", "", 10.99, 1, "None");
        AddItem(new_menu_item);

    }

    @FXML
    void Desserts3Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Desserts", "Rice Pudding", "", 10.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Desserts4Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Desserts", "Moon Pies", "", 10.99, 1, "None");
        AddItem(new_menu_item);

    }

    @FXML
    void Entres1Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Entres", "Kung Pao", "", 15.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Entres2Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Entres", "General Tsao's", "", 15.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Entres3Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Entres", "Sweet & Sour", "", 15.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Entres4Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Entres", "Sesame", "", 15.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Kids1Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Kid's", "Kid's Vegetable Lo Mein", "", 10.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Kids2Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Kid's", "Kid's Chicken & Rice", "", 10.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Kids3Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Kid's", "Kid's Shrimp & Rice", "", 10.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Kids4Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Kid's", "Kid's Dumplings", "", 10.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Sides1_1Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Sides", "White Rice", "", 5.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Sides1_2Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Sides", "Fried Rice", "", 5.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Sides1_3Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Kid's", "Brown Rice", "", 3.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Sides2Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Sides", "Lo Mein", "", 5.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Sides3Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Sides", "Wonton Soup", "", 5.99, 1, "None");
        AddItem(new_menu_item);
    }

    @FXML
    void Sides4Pressed(ActionEvent event) {
        MenuItem new_menu_item = new MenuItem("Sides", "Broccoli", "", 5.99, 1, "None");
        AddItem(new_menu_item);
    }


    // button to clear cart
    @FXML
    void ClearCartPressed(ActionEvent event){
        Arrays.fill(cart, null);
        cart_len = 0;
        cart_total = 0.0;
        UpdateCart();
    }
    @FXML
    void checkoutBtn(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader TipCalculator = new FXMLLoader(HelloApplication.class.getResource("BillCalculator.fxml"));
        stage.setScene(new Scene(TipCalculator.load(), 223, 232));
        stage.show();
    }



    // method adds item to cart. creates new index if item is not already in cart. If item is in cart, increments item quantity value.
    private void AddItem(MenuItem new_menu_item){
        for(int item_index = 0; item_index < cart.length; item_index ++) {
            if(cart[item_index] != null) {
                if (cart[item_index].getItemName().equals(new_menu_item.getItemName())) {
                    cart[item_index].setItemQty(cart[item_index].getItemQty() + 1);
                    cart_total += new_menu_item.getItemPrice();
                    UpdateCart();
                    return;
                }
            }
            else{
                cart[item_index] = new_menu_item;
                cart_total += new_menu_item.getItemPrice();
                cart_len ++;
                UpdateCart();
                return;
            }
        }
    }


    // method updates cart text
    private void UpdateCart(){
        String cart_text = "";
        for(MenuItem item : cart) {
            if (item != null) {
                cart_text += item.getItemName() + " (" + item.getItemQty() + ")" + "\n" + item.getItemPrice() + "\n\n";
            }
        }
        TotalText.setText(String.format("%.2f", cart_total));
        CartAnchor.setPrefHeight(cart_len * 50);
        CartText.setText(cart_text);
    }
}
