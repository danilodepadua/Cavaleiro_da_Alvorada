module com.daniel.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires java.desktop;
    requires javafx.media;
    requires java.sql;


    opens com.daniel.game to javafx.fxml;
    opens com.daniel.Telas to javafx.fxml;
    exports com.daniel.game;
    exports com.daniel.Telas;
    exports com.daniel.Dados;
    opens com.daniel.Dados to javafx.fxml;
    exports com.daniel.Modelo;
    opens com.daniel.Modelo to javafx.fxml;
    exports com.daniel.Modelo.Itens;
    opens com.daniel.Modelo.Itens to javafx.fxml;
    exports com.daniel.Modelo.Save;
    opens com.daniel.Modelo.Save to javafx.fxml;
    exports com.daniel.Dados.EntidadesRepositório;
    opens com.daniel.Dados.EntidadesRepositório to javafx.fxml;
    exports com.daniel.Modelo.Interfaces;
    opens com.daniel.Modelo.Interfaces to javafx.fxml;
    exports com.daniel.Modelo.Itens.Armaduras;
    opens com.daniel.Modelo.Itens.Armaduras to javafx.fxml;
    exports com.daniel.Modelo.Itens.Pocoes;
    opens com.daniel.Modelo.Itens.Pocoes to javafx.fxml;
    exports com.daniel.Modelo.Itens.Armaduras.Peitorais;
    opens com.daniel.Modelo.Itens.Armaduras.Peitorais to javafx.fxml;
    exports com.daniel.Modelo.Quests;
    opens com.daniel.Modelo.Quests to javafx.fxml;
    exports com.daniel.Modelo.Itens.Mapas;
    opens com.daniel.Modelo.Itens.Mapas to javafx.fxml;
    exports com.daniel.Modelo.Controles;
    opens com.daniel.Modelo.Controles to javafx.fxml;
    exports com.daniel.Dados.MagiasRepositório;
    opens com.daniel.Dados.MagiasRepositório to javafx.fxml;
    exports com.daniel.Modelo.BatalhaDeTurnos;
    opens com.daniel.Modelo.BatalhaDeTurnos to javafx.fxml;
    exports com.daniel.Modelo.Magia;
    opens com.daniel.Modelo.Magia to javafx.fxml;
    exports com.daniel.Modelo.Magia.Poderes;
    opens com.daniel.Modelo.Magia.Poderes to javafx.fxml;
    exports com.daniel.Modelo.ComportamentosInimigos;
    opens com.daniel.Modelo.ComportamentosInimigos to javafx.fxml;
    exports com.daniel.Dados.CidadeRepositório;
    opens com.daniel.Dados.CidadeRepositório to javafx.fxml;

}