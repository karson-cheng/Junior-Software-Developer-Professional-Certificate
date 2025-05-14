package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<User, String> fnameColumn;

    @FXML
    private TableColumn<User, String> lnameColumn;

    @FXML
    private TableColumn<User, Integer> pointsColumn;

    @FXML
    private TableView<User> tableView;

    @FXML
   public void initialize() {
      fnameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
      lnameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
      pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

      tableView.setItems(getAllUsers());
   }

    private static Connection connect() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/test_db";
        String user = "root";
        String password = "@@2468Abcd";

        return DriverManager.getConnection(url, user, password);
    }

    private ObservableList<User> getAllUsers(){
        ObservableList<User> userList = FXCollections.observableArrayList();

        String query = "SELECT * FROM user2";

        try(Connection conn = connect();
            Statement queryStatement = conn.createStatement();
            ResultSet rs = queryStatement.executeQuery(query)){
            while(rs.next()){
                int userId = rs.getInt("user_id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                int points = rs.getInt("reward_points");
                userList.add(new User(userId, fname, lname, points));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //return userList;

        FilteredList<User> filteredData = new FilteredList<>(userList, p -> true);

        filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
        {
            String searchText = searchField.getText();
            if(searchText == null || searchText.isEmpty()){
                return person -> true;
            }
                
            String lowerCaseFilter = searchText.toLowerCase();
            return person -> person.getfName().toLowerCase().contains(lowerCaseFilter);

        }, searchField.textProperty()));

        return filteredData;
    }



}
