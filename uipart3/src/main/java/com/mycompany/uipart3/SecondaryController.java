package com.mycompany.uipart3;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * Controls the FXML for the scene that displays the list of words Switches back
 * to the primary scene and also displays the words on the screen 
 * 
 * Contains the Label for the list of words
 *
 * @author alexa
 */
public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private Label stats;

    @FXML
    private void initialize() throws IOException, ClassNotFoundException, SQLException {
        stats.setText(words.set1());
    }
}
