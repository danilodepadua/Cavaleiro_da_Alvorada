module com.daniel.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires java.desktop;
    requires javafx.media;


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
    exports com.daniel.PrimeiraCamada.Save;
    opens com.daniel.PrimeiraCamada.Save to javafx.fxml;
    exports com.daniel.PrimeiraCamada.Entidades;
    opens com.daniel.PrimeiraCamada.Entidades to javafx.fxml;
    exports com.daniel.PrimeiraCamada.Interfaces;
    opens com.daniel.PrimeiraCamada.Interfaces to javafx.fxml;
    exports com.daniel.PrimeiraCamada.Itens.Armaduras;
    opens com.daniel.PrimeiraCamada.Itens.Armaduras to javafx.fxml;
    exports com.daniel.PrimeiraCamada.Itens.Pocoes;
    opens com.daniel.PrimeiraCamada.Itens.Pocoes to javafx.fxml;
    exports com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;
    opens com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais to javafx.fxml;
    exports com.daniel.PrimeiraCamada.Quests;
    opens com.daniel.PrimeiraCamada.Quests to javafx.fxml;
    exports com.daniel.PrimeiraCamada.Itens.Mapas;
    opens com.daniel.PrimeiraCamada.Itens.Mapas to javafx.fxml;

}