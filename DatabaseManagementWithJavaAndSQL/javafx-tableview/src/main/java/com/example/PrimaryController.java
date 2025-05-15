package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private TextField searchField; 
    
    @FXML
    private TextField fNameField;

    @FXML
    private TextField lNameField;

    @FXML
    private TextField pointsField;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRead;

    @FXML
    private Button btnUpdate;

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
        
        // Initialize columns
        fnameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        
        //right alignment
        pointsColumn.setCellFactory(column -> new TableCell<User, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER_RIGHT); // Align text to the right
                }
            }
        });
        //right alignment
        //tableView.setItems(getAllUsers());
        refreshTable();
        //getAllUsers();
    } 

/*     private static Connection connect() throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/clicknbuy";
        String user = "root";
        String password = "Lmv@15561";
        return DriverManager.getConnection(url, user, password);
    } */

     private ObservableList<User> getAllUsers() {

        ObservableList<User> userList = FXCollections.observableArrayList();       

        String query = "SELECT * FROM user";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                int points = rs.getInt("reward_points");
                System.out.println("Id: "+userId+" fName: "+fName+" lName: "+lName+" points: "+points);
                userList.add(new User(userId, fName, lName, points));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;        
        
    }     

     // Method to refresh the TableView with current data
    private void refreshTable() {
        tableView.setItems(getAllUsers());
    } 

    @FXML
    void readUser(ActionEvent event) {
         User selectedUser = tableView.getSelectionModel().getSelectedItem();
        fNameField.setText(selectedUser.getfName());
        lNameField.setText(selectedUser.getlName());
        pointsField.setText((String.valueOf(selectedUser.getPoints()))); 

    }

    @FXML
    void insertUser(ActionEvent event) {
         String newFName;
        String newLName;
        int newPoints;
        
        newFName=fNameField.getText();
        newLName=lNameField.getText();
        newPoints=Integer.valueOf(pointsField.getText());

        String query = "INSERT INTO user (first_name, last_name, reward_points) VALUES (?, ?, ?)";

            try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, newFName);
            pstmt.setString(2, newLName);
            pstmt.setInt(3, newPoints);

            pstmt.executeUpdate();
            
            refreshTable();
        } catch (SQLException e) {
            System.out.println("error:"+e.getMessage());
            
        } 

    }

    @FXML
    void updateUser(ActionEvent event) {
         String newFName;
        String newLName;
        int newPoints;

        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        newFName=fNameField.getText();
        newLName=lNameField.getText();
        newPoints=Integer.valueOf(pointsField.getText());

        String query = "UPDATE user SET first_name = ?, last_name = ?, reward_points = ? WHERE user_id = ?";

            try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newFName);
            pstmt.setString(2, newLName);
            pstmt.setInt(3, newPoints);
            pstmt.setInt(4, selectedUser.getUserId());

            pstmt.executeUpdate();
            refreshTable();
        } catch (SQLException e) {
            System.out.println("error:"+e.getMessage());            
        } 
    }
    @FXML
    void deleteUser(ActionEvent event) {

         User selectedUser = tableView.getSelectionModel().getSelectedItem();

        String query = "DELETE FROM user WHERE user_id = ?";

                try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, selectedUser.getUserId());

            pstmt.executeUpdate();
            refreshTable();
        } catch (SQLException e) {
            System.out.println("error:"+e.getMessage());
            
        } 
    }    
    
}
