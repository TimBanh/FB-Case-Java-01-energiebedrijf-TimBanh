module com.example.fbcasejava01energiebedrijftimbanh {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fbcasejava01energiebedrijftimbanh to javafx.fxml;
    exports com.example.fbcasejava01energiebedrijftimbanh;
    exports com.example.fbcasejava01energiebedrijftimbanh.controllers;
    opens com.example.fbcasejava01energiebedrijftimbanh.controllers to javafx.fxml;
}