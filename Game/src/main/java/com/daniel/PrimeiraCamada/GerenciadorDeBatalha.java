package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.TerceiraCamada.BattleController;
import com.daniel.game.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

public class GerenciadorDeBatalha {

    PersonagemLuta Player, Inimigo;
    AnchorPane ui, mensagemBox;
    Text txtMensagem;
    States state;
    ImageView pEffect, eEffect;
    Comportamento comp;
    private BattleController BC;

    private enum States{
        turnoPlayer,
        turnoInimigo;
    }

    public GerenciadorDeBatalha(PersonagemLuta p, PersonagemLuta i, AnchorPane UIActions, AnchorPane boxMensagem, Text txtMensagem, ImageView pe, ImageView ee, BattleController bc,Comportamento Comp){
        this.Inimigo = i;
        this.Player = p;
        this.ui= UIActions;
        this.txtMensagem = txtMensagem;
        this.mensagemBox = boxMensagem;
        this.pEffect = pe;
        this.eEffect = ee;
        this.comp = Comp;
        this.BC = bc;
    }
    public void mostrarResultado(ArrayList<String> mensagems){
        Timeline T = new Timeline();
        double time = 0.2;
        for(String i : mensagems) {
            T.getKeyFrames().add(new KeyFrame(Duration.seconds(time), event -> {
                mensagemBox.setOpacity(1);
                txtMensagem.setText(i);
            }));
            time+=1;
        }
        T.getKeyFrames().add(new KeyFrame(Duration.seconds(time), event -> {mensagemBox.setOpacity(0); txtMensagem.setText("");}));
        T.setOnFinished(event -> {
            try {
                MudarTurno();
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });
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
    public void MudarTurno() throws PlayerInexistenteException {
        if(Player.currentHp <= 0){
            BC.Derrota();
        }
        else if(Inimigo.currentHp <= 0){
            BC.Vitoria();
        }
        else{
            if(state == States.turnoPlayer){
                state = States.turnoInimigo;
                turnoInimigo();
            }
            else{
                state = States.turnoPlayer;
                BC.Atualiazar();
                turnoPlayer();
            }
        }
    }

    public void turnoPlayer(){
        if(Player.stun > 0){
            Player.stun--;
            ArrayList<String> mensagem = new ArrayList<>();
            mensagem.add("Jogador esta stunado");
            mostrarResultado(mensagem);
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
            ArrayList<String> mensagem = new ArrayList<>();
            mensagem.add("Inimigo esta stunado");
            mostrarResultado(mensagem);
        }
        else{
            Comportamento.acoes acao = comp.EscolherAcao();
            if(acao == Comportamento.acoes.fugir){
                this.fugir(Inimigo.fugir(Player.getVelocidade()));
            }
            else if(acao == Comportamento.acoes.usarMagia){
                comp.EscolherMagia().Conjurar(this, Inimigo);
            }
            else{
                this.Ataque(Inimigo.atqAnim.INICIAR(pEffect), Inimigo.getAtqM(),Inimigo.getTipoAtaqueBase(), true, null);
            }
        }
    }

    public void Vitoria() throws PlayerInexistenteException {
        //implementar
        for (Quest quest : com.daniel.PrimeiraCamada.Entidades.Player.getPlayer().getQuestsAtuais()) {
            if (quest.getNomeInimigo().equals(Inimigo.getNome())) {
                try {
                    quest.updateQuestCompleted();
                    Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaResultado.fxml")));
                } catch (PlayerInexistenteException e) {
                    System.err.println("Erro ao atualizar quests: " + e.getMessage());
                }
            }
        }
        System.out.println("Player venceu");

    }
    public void Derrota(){
        //implementar
        System.out.println("Player perdeu");
    }

    public void ApagarUiPlayer(){
        ui.setOpacity(0);
        ui.setDisable(true);
    }
    public void Ataque(Timeline t, int Dano, TiposElementais tipo, boolean fisico, ArrayList<String> Mensagem){
        if(state == States.turnoPlayer){
            if(Mensagem == null){
                Mensagem = new ArrayList<String>();
                Mensagem.add("Player atacou");
            }
            ApagarUiPlayer();
            int danoTomado = this.Inimigo.tomarDano(Dano, tipo, fisico);
            if(danoTomado == 0){
                Mensagem.add("O inimigo não sofreu dano");
            }
            else if(danoTomado < 0){
                Mensagem.add("O inimigo recuperou " + Math.abs(danoTomado) + " de vida");
            }
            else{
                Mensagem.add("O inimigo tomou " + danoTomado + " de dano");
            }
        }
        else{
            if(Mensagem == null){
                Mensagem = new ArrayList<String>();
                Mensagem.add("Inimigo atacou");
            }
            int danoTomado = this.Player.tomarDano(Dano, tipo, fisico);
            if(danoTomado == 0){
                Mensagem.add("O jogador não sofreu dano");
            }
            else if(danoTomado < 0){
                Mensagem.add("O jogador recuperou " + Math.abs(danoTomado) + " de vida");
            }
            else{
                Mensagem.add("O jogador tomou " + danoTomado + " de dano");
            }
        }
        ArrayList<String> finalMensagem = Mensagem;
        t.setOnFinished(event -> mostrarResultado(finalMensagem));
        t.play();
    }

    public void acaoNaoAgreciva(Timeline t, ArrayList<String> mensagem){
        t.setOnFinished(event -> mostrarResultado(mensagem));
    }
    public ImageView getAlvoView(boolean autoUsavel){
        if(!autoUsavel){
            if(this.state == States.turnoInimigo){
                return pEffect;
            }
            else{
                return eEffect;
            }
        }
        else{
            if(this.state == States.turnoInimigo){
                return eEffect;
            }
            else{
                return pEffect;
            }
        }
    }

    public PersonagemLuta getAlvo(boolean autoUsavel) {
        if(state == States.turnoInimigo){
            if(!autoUsavel){
                return Player;
            }
            else{
                return Inimigo;
            }
        }
        else{
            if(!autoUsavel){
                return Inimigo;
            }
            else{
                return Player;
            }
        }
    }
    public void fugir(boolean conseguiu){
        if(conseguiu){
            Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
        }
        else{
            ArrayList<String> i = new ArrayList<String>();
            i.add("Falhou em fugir");
            mostrarResultado(i);
        }
    }
}
