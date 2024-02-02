package com.daniel.Model.TiposDeBatalha;

import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigo;
import com.daniel.Model.BatalhaDeTurnos.TipoBatalha;
import com.daniel.View.ResultadoController;
import com.daniel.game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Random;

public class BatalhaComum extends TipoBatalha {
    Inimigo[] inimigos = Main.cidadeAtual.getInimigos();

    @Override
    public void Inicializar() {
        Random rand = new Random();
        inimigo = inimigos[rand.nextInt(0, inimigos.length)];
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
