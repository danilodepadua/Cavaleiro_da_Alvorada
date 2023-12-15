module com.daniel.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.daniel.game to javafx.fxml;
    opens com.daniel.controller to javafx.fxml;
    exports com.daniel.game;
    exports com.daniel.controller;
    exports com.daniel.Repositorios;
    opens com.daniel.Repositorios to javafx.fxml;
}