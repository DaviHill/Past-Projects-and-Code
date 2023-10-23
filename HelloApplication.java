package com.example.datepicker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @Authors: David Hill, Remy Garay, Zach Mathis, Kayla Lewis, Michael Freier
 * @Date: 04/18/2023
 * @Class: CSC 331
 * @Algorthm:
 * 1. The Code will start off by greeting the user in the terminal.
 * 2. Next it will Open a Menu asking the user to choose a restaurant from 4 select places
 * 3. After the user chooses their restaurant, they are sent to the calendar to choose a reservation time
 *      a. If the user chooses a Holiday it will ask them to choose a different time
 * 4. Once the reservations is made, It will ask the user how many is in their party
 * 5. After that, It will finally bring up the menu of the restaurant they chose and the user can pick whatever they
 * want (there is no limit).
 * 6. Lastly, the program will bring you to the Bill Calculator, and it'll display the total, the number of people in
 * your party and the tip. Once you hit calculate it does the math for you and displays your actual total with included
 * tip.
 * @Description: This program uses a series of javafx files to switch from one scene to the other to mimick a restaurant.
 * This program also utilizes different codes and exception handling in certain areas to help deal with problems along
 * the way.
 * */

/**
 * This starts off the code by doing to the RestaurantPicker in javafx
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Hello welcome to the Restaurant Hub. Please choose A restaurant to choose from: ");
        FXMLLoader RestaurantPicker = new FXMLLoader(HelloApplication.class.getResource("RestaurantPicker.fxml"));
        stage.setScene(new Scene(RestaurantPicker.load(), 600, 400));
        stage.show();



        }
    public static void main(String[] args) {launch();}
}