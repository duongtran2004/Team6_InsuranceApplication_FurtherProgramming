module com.example.team6_insuranceapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.team6_insuranceapplication to javafx.fxml;
    exports com.example.team6_insuranceapplication;
}