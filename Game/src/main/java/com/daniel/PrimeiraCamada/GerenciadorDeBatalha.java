package com.daniel.PrimeiraCamada;

import com.daniel.game.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GerenciadorDeBatalha {

    PersonagemLuta Player, Inimigo;
    AnchorPane ui, mensagemBox;
    Text txtMensagem;
    States state;

    private enum States{
        turnoPlayer,
        turnoInimigo;
    }

    public GerenciadorDeBatalha(PersonagemLuta p, PersonagemLuta i, AnchorPane UIActions, AnchorPane boxMensagem, Text txtMensagem){
        this.Inimigo = i;
        this.Player = p;
        this.ui= UIActions;
        this.txtMensagem = txtMensagem;
        this.mensagemBox = boxMensagem;
    }
    public void mostrarResultado(String mensagem){
        Timeline T = new Timeline();
        T.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2), event -> {mensagemBox.setOpacity(1); txtMensagem.setText(mensagem);}));
        T.getKeyFrames().add(new KeyFrame(Duration.seconds(2.2), event -> {mensagemBox.setOpacity(0); txtMensagem.setText("");}));
        T.setOnFinished(event -> MudarTurno());
        T.play();
    }

    public void IniciarBatalha(){
        if(Inimigo.velocidade > Player.velocidade){
            state = States.turnoInimigo;
            turnoInimigo();
        }
        else{
            state = States.turnoPlayer;
            turnoPlayer();
        }
    }
    public void MudarTurno(){
        if(Player.currentHp <= 0){
            Derrota();
        }
        else if(Inimigo.currentHp <= 0){
            Vitoria();
        }
        else{
            if(state == States.turnoPlayer){
                state = States.turnoInimigo;
                turnoInimigo();
            }
            else{
                state = States.turnoPlayer;
                turnoPlayer();
            }
        }
    }

    public void turnoPlayer(){
        if(Player.stun > 0){
            Player.stun--;
            MudarTurno();
        }
        else{
        // logica do player
            ui.setOpacity(1);
            ui.setDisable(false);
            System.out.println("Turno player");
        }
    }
    public void turnoInimigo(){
        if(Inimigo.stun > 0){
            Inimigo.stun--;
            MudarTurno();
        }
        else{
        // logica do inimigo
            System.out.println("Turno inimigo");
            mostrarResultado("Turno do inimigo");
        }
    }
    public void Vitoria(){
        //implementar
        System.out.println("Player venceu");
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
    }
    public void Derrota(){
        //implementar
        System.out.println("Player perdeu");
    }

    public void ApagarUiPlayer(){
        ui.setOpacity(0);
        ui.setDisable(true);
    }
    public void Ataque(Timeline t, int Dano, TiposDano tipo){
        String Mensagem;
        if(state == States.turnoPlayer){
            ApagarUiPlayer();
            int danoTomado = this.Inimigo.tomarDano(Dano, tipo);
            if(danoTomado == 0){
                Mensagem = "O inimigo não sofreu dano";
            }
            else if(danoTomado < 0){
                Mensagem = "O inimigo recuperou " + danoTomado + " de vida";
            }
            else{
                Mensagem = "O inimigo tomou " + danoTomado + " de dano";
            }
        }
        else{
            int danoTomado = this.Player.tomarDano(Dano, tipo);
            if(danoTomado == 0){
                Mensagem = "O jogador não sofreu dano";
            }
            else if(danoTomado < 0){
                Mensagem = "O jogador recuperou " + danoTomado + " de vida";
            }
            else{
                Mensagem = "O jogador tomou " + danoTomado + " de dano";
            }
        }
        t.setOnFinished(event -> mostrarResultado(Mensagem));
        t.play();
    }
}
