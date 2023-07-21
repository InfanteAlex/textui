package com.mycompany.textdata;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * Controls the FXML for the scene that displays the poem. Has FXML controls to switch 
 * to the secondary scene and also displays the the poem to the screen 
 * 
 * Contains the TextArea for the poem to be displayed.
 * @author alexa
 */
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

    /**
     *
     * @throws IOException
     */
    public PrimaryController() throws IOException {

    }

}
