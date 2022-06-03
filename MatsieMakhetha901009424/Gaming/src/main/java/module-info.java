module com.example.gaming {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gaming to javafx.fxml;
    exports com.example.gaming;
}