module com.daniel.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires java.desktop;
    requires javafx.media;
    requires java.sql;


    opens com.daniel.game to javafx.fxml;
    opens com.daniel.View to javafx.fxml;
    exports com.daniel.game;
    exports com.daniel.View;
    exports com.daniel.Model.Dados;
    opens com.daniel.Model.Dados to javafx.fxml;
    exports com.daniel.Model;
    opens com.daniel.Model to javafx.fxml;
    exports com.daniel.Model.Itens;
    opens com.daniel.Model.Itens to javafx.fxml;
    exports com.daniel.Model.Dados.Save;
    opens com.daniel.Model.Dados.Save to javafx.fxml;
    exports com.daniel.Model.Dados.Entidades;
    opens com.daniel.Model.Dados.Entidades to javafx.fxml;
    exports com.daniel.Model.Interfaces;
    opens com.daniel.Model.Interfaces to javafx.fxml;
    exports com.daniel.Model.Itens.Armaduras;
    opens com.daniel.Model.Itens.Armaduras to javafx.fxml;
    exports com.daniel.Model.Itens.Pocoes;
    opens com.daniel.Model.Itens.Pocoes to javafx.fxml;
    exports com.daniel.Model.Itens.Armaduras.Peitorais;
    opens com.daniel.Model.Itens.Armaduras.Peitorais to javafx.fxml;
    exports com.daniel.Model.Quests;
    opens com.daniel.Model.Quests to javafx.fxml;
    exports com.daniel.Model.Itens.Mapas;
    opens com.daniel.Model.Itens.Mapas to javafx.fxml;
    exports com.daniel.Controller;
    opens com.daniel.Controller to javafx.fxml;
    exports com.daniel.Model.Magias.Animation;
    opens com.daniel.Model.Magias.Animation to javafx.fxml;
    exports com.daniel.Model.BatalhaDeTurnos;
    opens com.daniel.Model.BatalhaDeTurnos to javafx.fxml;
    exports com.daniel.Model.Magias;
    opens com.daniel.Model.Magias to javafx.fxml;
    exports com.daniel.Model.Magias.Poderes;
    opens com.daniel.Model.Magias.Poderes to javafx.fxml;
    exports com.daniel.Model.ComportamentosInimigos;
    opens com.daniel.Model.ComportamentosInimigos to javafx.fxml;
    exports com.daniel.Model.Dados.CidadeRepositorio;
    opens com.daniel.Model.Dados.CidadeRepositorio to javafx.fxml;

}