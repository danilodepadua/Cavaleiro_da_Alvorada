package com.daniel.Modelo.TiposDeBatalha;

import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.BatalhaDeTurnos.TipoBatalha;
import com.daniel.Telas.ResultadoController;
import com.daniel.game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class BatalhaPredefinida extends TipoBatalha {
    public BatalhaPredefinida(Inimigo i){
        this.inimigo = i;
        this.escapavel = false;
    }
    @Override
    public void Inicializar() {

    }

    @Override
    public void LogicaVitoria() throws IOException, PlayerInexistenteException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("TelaResultado.fxml"));
        Parent root = loader.load();
        ResultadoController resultadoController = loader.getController();
        resultadoController.atualizarValores(this.xpGanho,  this.dinheiroGanho, this.itensDropados);
        Main.ChangeScene(root);
    }

    @Override
    public void Derrota() throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaGameOver.fxml")).load());
    }
}
