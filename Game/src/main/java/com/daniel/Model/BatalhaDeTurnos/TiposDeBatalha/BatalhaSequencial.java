package com.daniel.Model.BatalhaDeTurnos.TiposDeBatalha;

import com.daniel.Model.BatalhaDeTurnos.GerenciadorDeBatalha;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.BatalhaDeTurnos.TipoBatalha;
import com.daniel.View.BattleController;
import com.daniel.View.ResultadoController;
import com.daniel.game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;

public class BatalhaSequencial extends TipoBatalha {
    ArrayList<Inimigo> sequenciaInimigos;
    int pos = 0;
    GerenciadorDeBatalha bc;
    public BatalhaSequencial(ArrayList<Inimigo> inimigos, GerenciadorDeBatalha bc){
        sequenciaInimigos = inimigos;
        this.bc = bc;
    }
    @Override
    public void Inicializar() {
        inimigo = sequenciaInimigos.get(pos);
    }

    @Override
    public void LogicaVitoria() throws IOException, PlayerInexistenteException {
        pos++;
        if(pos<sequenciaInimigos.size()){
            System.out.println("Nova batalha em sequência");
            ArrayList<TextoNode> msgn= new ArrayList<>();
            msgn.add(new TextoNode("Um novo inimigo apareceu","A new enemy appeared"));
            bc.controller.mostrarResultado(msgn);
        }
        else{
            this.finalizado = true;
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("TelaResultado.fxml"));
            Parent root = loader.load();
            ResultadoController resultadoController = loader.getController();
            resultadoController.atualizarValores(this.xpGanho,  this.dinheiroGanho, this.itensDropados);
            Main.ChangeScene(root);
        }
    }

    @Override
    public void Derrota() throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaGameOver.fxml")).load());
    }
}
