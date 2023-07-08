package com.mycompany.uipart3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Word Count");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException, SQLException {
        String url = "jdbc:mysql://localhost:3306/word occurrences ";
        String username = "root";
        String password = "password";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver loaded!");
//        } catch (ClassNotFoundException e) {
//            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
//        }
        
//        System.out.println("Connecting database...");
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Database connected!");
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }
        launch();
    }

}
