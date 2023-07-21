module com.mycompany.textdata {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.mycompany.textdata to javafx.fxml;
    exports com.mycompany.textdata;
}
