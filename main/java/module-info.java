module com.mycompany.uipart3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.uipart3 to javafx.fxml;
    exports com.mycompany.uipart3;
}
