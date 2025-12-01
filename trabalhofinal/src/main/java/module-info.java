module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.controllers to javafx.fxml;

    opens com.models to javafx.fxml;

    exports com;

    exports com.controllers;
    exports com.models;
    exports com.DTO;
}
