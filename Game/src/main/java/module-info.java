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
    exports com.daniel.Model.Dados.Itens;
    opens com.daniel.Model.Dados.Itens to javafx.fxml;
    exports com.daniel.Model.Dados.Save;
    opens com.daniel.Model.Dados.Save to javafx.fxml;
    exports com.daniel.Model.Dados.Entidades;
    opens com.daniel.Model.Dados.Entidades to javafx.fxml;
    exports com.daniel.Model.Interfaces;
    opens com.daniel.Model.Interfaces to javafx.fxml;
    exports com.daniel.Model.Dados.Itens.Armaduras;
    opens com.daniel.Model.Dados.Itens.Armaduras to javafx.fxml;
    exports com.daniel.Model.Dados.Itens.Pocoes;
    opens com.daniel.Model.Dados.Itens.Pocoes to javafx.fxml;
    exports com.daniel.Model.Dados.Itens.Armaduras.Peitorais;
    opens com.daniel.Model.Dados.Itens.Armaduras.Peitorais to javafx.fxml;
    exports com.daniel.Model.Dados.Quests;
    opens com.daniel.Model.Dados.Quests to javafx.fxml;
    exports com.daniel.Model.Dados.Itens.Mapas;
    opens com.daniel.Model.Dados.Itens.Mapas to javafx.fxml;
    exports com.daniel.Controller;
    opens com.daniel.Controller to javafx.fxml;
    exports com.daniel.Model.Dados.Magias.Animation;
    opens com.daniel.Model.Dados.Magias.Animation to javafx.fxml;
    exports com.daniel.Model.BatalhaDeTurnos;
    opens com.daniel.Model.BatalhaDeTurnos to javafx.fxml;
    exports com.daniel.Model.Dados.Magias;
    opens com.daniel.Model.Dados.Magias to javafx.fxml;
    exports com.daniel.Model.Dados.Magias.Poderes;
    opens com.daniel.Model.Dados.Magias.Poderes to javafx.fxml;
    exports com.daniel.Model.ComportamentosInimigos;
    opens com.daniel.Model.ComportamentosInimigos to javafx.fxml;
    exports com.daniel.Model.Dados.CidadeRepositorio;
    opens com.daniel.Model.Dados.CidadeRepositorio to javafx.fxml;
    exports com.daniel.Model.Dados.Entidades.Inimigos;
    opens com.daniel.Model.Dados.Entidades.Inimigos to javafx.fxml;
    exports com.daniel.Model.Dados.Entidades.Inimigos.Viloes;
    opens com.daniel.Model.Dados.Entidades.Inimigos.Viloes to javafx.fxml;

}