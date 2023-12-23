module com.daniel.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.daniel.game to javafx.fxml;
    opens com.daniel.TerceiraCamada to javafx.fxml;
    exports com.daniel.game;
    exports com.daniel.TerceiraCamada;
    exports com.daniel.SegundaCamada;
    opens com.daniel.SegundaCamada to javafx.fxml;
    exports com.daniel.PrimeiraCamada;
    opens com.daniel.PrimeiraCamada to javafx.fxml;
    exports com.daniel.PrimeiraCamada.Itens;
    opens com.daniel.PrimeiraCamada.Itens to javafx.fxml;
}