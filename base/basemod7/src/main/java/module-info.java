module com.example.mod7base {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mod7base to javafx.fxml;
    exports com.example.mod7base;
}