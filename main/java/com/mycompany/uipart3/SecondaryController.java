package com.mycompany.uipart3;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private Label stats;
    @FXML
     private void initialize() throws IOException {
        stats.setText(words.set1());
    }
}
