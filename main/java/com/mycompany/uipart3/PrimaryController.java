package com.mycompany.uipart3;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private TextArea text;

    @FXML
    private void switchToSecondary() throws IOException {

        App.setRoot("secondary");
    }

    @FXML
    private void initialize() throws IOException {
        text.setText(words.set());
       
       
    }

    public PrimaryController() throws IOException {

    }

}
