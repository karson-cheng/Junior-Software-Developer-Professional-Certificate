package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        TextArea userTextArea = new TextArea();
        userTextArea.setEditable(false);
        userTextArea.setMinHeight(480);
        userTextArea.setMinWidth(640);

        DatabaseHandler dbHandler = new DatabaseHandler();
        String userData = "";
        try{
            userData = dbHandler.getAllUsers();
        } catch (SQLException e){
            e.printStackTrace();
        }

        if(!userData.isEmpty()){
            userTextArea.setText(userData);
        }

        VBox verticalBox = new VBox(userTextArea);
        scene = new Scene(verticalBox, 640, 480);
        stage.setTitle("User Data Viewer");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}