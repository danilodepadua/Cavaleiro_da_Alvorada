module com.daniel.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.daniel.game to javafx.fxml;
    opens com.daniel.ControleInterface to javafx.fxml;
    exports com.daniel.game;
    exports com.daniel.ControleInterface;
    exports com.daniel.Repositorios;
    opens com.daniel.Repositorios to javafx.fxml;
    exports com.daniel.Basicos;
    opens com.daniel.Basicos to javafx.fxml;
}