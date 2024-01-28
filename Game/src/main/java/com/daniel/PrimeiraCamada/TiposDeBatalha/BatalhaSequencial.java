package com.daniel.PrimeiraCamada.TiposDeBatalha;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TipoBatalha;
import com.daniel.TerceiraCamada.BattleController;
import com.daniel.TerceiraCamada.ResultadoController;
import com.daniel.game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;

public class BatalhaSequencial extends TipoBatalha {
    ArrayList<Inimigo> sequenciaInimigos;
    int pos = 0;
    BattleController bc;
    public BatalhaSequencial(ArrayList<Inimigo> inimigos, BattleController bc){
        sequenciaInimigos = inimigos;
        this.bc = bc;
    }
    @Override
    public void Inicializar() {
        inimigo = sequenciaInimigos.get(0);
    }

    @Override
    public void LogicaVitoria() throws IOException, PlayerInexistenteException {
        pos++;
        if(pos<sequenciaInimigos.size()){
            inimigo = sequenciaInimigos.get(pos);
            System.out.println("Nova batalha em sequência");
            bc.ShowMensage("Um novo inimigo apareceu");
            bc.Inicializar();
        }
        else{
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
