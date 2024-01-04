package com.daniel.PrimeiraCamada;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class GerenciadorDeBatalha {

    PersonagemLuta Player, Inimigo;
    AnchorPane ui;
    States state;

    private enum States{
        turnoPlayer,
        turnoInimigo;
    }

    public GerenciadorDeBatalha(PersonagemLuta p, PersonagemLuta i, AnchorPane UI){
        this.Inimigo = i;
        this.Player = p;
        ui= UI;
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
        ui.setOpacity(0);
        ui.setDisable(true);
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
            MudarTurno();
        }
    }
    public void Vitoria(){
        //implementar
        System.out.println("Player venceu");
    }
    public void Derrota(){
        //implementar
        System.out.println("Player perdeu");
    }

    public void Animacao(Timeline t){
        t.setOnFinished(event -> MudarTurno());
        t.play();
    }
}
