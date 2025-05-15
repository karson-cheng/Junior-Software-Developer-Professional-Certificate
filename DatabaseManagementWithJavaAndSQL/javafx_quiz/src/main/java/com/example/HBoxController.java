package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HBoxController {
    /*TODO 26: Paste the @FXML annotations from hboxscene.fxml */
    @FXML
    private Label cityLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Button nextButton;

    @FXML
    private Button prevButton;

    @FXML
    private Button showGridBtn;

    @FXML
    private Label zipcodeLabel;

    

    // @FXML
    // void prevRecord(ActionEvent event) {

    // }

    // @FXML
    // void switchGridScene(ActionEvent event) {

    // }

    private List<String[]> personData;  // List to store fetched records
    private int currentIndex = 0;

    /*TODO 27: Copy the code of fetchPersonData(), displayRecord(), initialize() and nextRecord() methods 
    from VBoxController.java code to HBoxController.java file*/
    @FXML
    public void initialize() {
        /*TODO 22: call the fetchPersonData() method first*/
        personData = fetchPersonData();  // Fetch data from the database
        if (!personData.isEmpty()) {
            /*TODO 23: call the displayRecord() to show the 
            contents of person at currentIndex on the application window*/
            displayRecord(currentIndex);
        }
    }


    /* TODO 15: Define fetchPersonData() method to read all records in person table in an ArrayList */

    private List<String[]> fetchPersonData() {
        List<String[]> data = new ArrayList<>();

        /*TODO 16: Construct a SQL query string SQL Query 
        to select name, city, zipcode from person*/
        String query = "SELECT * FROM person";
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery(query)) {

            // Iterate through the result set and store each record
            while (resultSet.next()) {
                /*TODO 17: store name, city and zipcode in string variables 
                with resultSet.getString() method*/
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String zipcode = resultSet.getString("zipcode");
                data.add(new String[]{name, city, zipcode});
            }

        } catch (Exception e) {
            e.printStackTrace();  // Handle exception (log or show error message)
        }

        return data;
    }

    /*TODO 18: In VBoxController.java define displayRecord() method*/

    private void displayRecord(int index) {
        /*TODO 19: fetch information of person at current index 
        from personData arraylist. Set nameLabel to the name field*/
        String[] person = personData.get(index);
        nameLabel.setText("Name: " + person[0]);
        /*TODO 20: similarly set cityLabel and zipcodeLabel*/
        cityLabel.setText("City: " + person[1]);
        zipcodeLabel.setText("Zipcode: " + person[2]);
    }
    

     @FXML
    void nextRecord(ActionEvent event) {
        if (currentIndex < personData.size() - 1) {
            /*TODO 24: Inside this method, increment currentIndex 
            and call displayRecord() method.*/
            currentIndex++;
            displayRecord(currentIndex);
        }
    }




    @FXML
    void prevRecord(ActionEvent event) {

    }

    
    @FXML
    void switchGridScene(ActionEvent event) throws IOException {
        /*TODO 28: set the gridscene.fxml as the root of application window*/
        App.setRoot("gridscene");
    }

    
    
}
