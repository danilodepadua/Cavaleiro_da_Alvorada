package com.daniel.Model.BatalhaDeTurnos;

import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Magias.TiposElementais;
import com.daniel.View.BattleController;
import com.daniel.game.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GerenciadorDeBatalha {

    PersonagemLuta Player, Inimigo;
    AnchorPane mensagemBox;
    Text txtMensagem;
    States state;
    ImageView pEffect, eEffect;
    Comportamento comp;
    private BattleController BC;

    private enum States{
        turnoPlayer,
        turnoInimigo;
    }

    public GerenciadorDeBatalha(PersonagemLuta p, PersonagemLuta i, AnchorPane boxMensagem, Text txtMensagem, ImageView pe, ImageView ee, BattleController bc,Comportamento Comp){
        this.Inimigo = i;
        this.Player = p;
        this.txtMensagem = txtMensagem;
        this.mensagemBox = boxMensagem;
        this.pEffect = pe;
        this.eEffect = ee;
        this.comp = Comp;
        this.BC = bc;
    }
    public void mostrarResultado(ArrayList<String> mensagems, boolean passar){
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
        if(passar){
            T.setOnFinished(event -> {
                try {
                    MudarTurno();
                } catch (PlayerInexistenteException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        T.play();
    }

    public void IniciarBatalha() throws IOException{
        if(Inimigo.velocidade > Player.velocidade){
            state = States.turnoInimigo;
            turnoInimigo();
        }
        else{
            state = States.turnoPlayer;
            turnoPlayer();
        }
    }
    public void MudarTurno() throws PlayerInexistenteException, IOException{
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
        ArrayList<String> mensagem = new ArrayList<>();
        if(Player.envenenado){
            mensagem.add(Player.TomarDanoVeneno());
        }
        if(Player.stun > 0){
            Player.stun--;
            mensagem.add(Player.getNome() + " esta stunado");
            mostrarResultado(mensagem, true);
        }
        else if(Player.dormindo){
            mensagem.add(Player.getNome() + " esta dormindo");
            mostrarResultado(mensagem, true);
        }
        else{
        // logica do player
            BC.MostrarInterfacePlayer();
            System.out.println("Turno player");
        }
    }
    public void turnoInimigo() throws IOException{
        if(Inimigo.stun > 0){
            Inimigo.stun--;
            ArrayList<String> mensagem = new ArrayList<>();
            mensagem.add("Inimigo esta stunado");
            mostrarResultado(mensagem, true);
        }
        else{
            Comportamento.acoes acao = comp.EscolherAcao();
            if(acao == Comportamento.acoes.fugir && BC.tipoBatalha.escapavel){
                this.fugir(Inimigo.fugir(Player.getVelocidade()));
            }
            else if(acao == Comportamento.acoes.usarMagia){
                comp.magiaEscolhida.Conjurar(this, Inimigo);
            }
            else{
                this.Ataque(Inimigo.atqAnim.INICIAR(pEffect), Inimigo.getAtqM(),Inimigo.getTipoAtaqueBase(), true, null);
            }
        }
    }
    public void Ataque(Timeline t, int Dano, TiposElementais tipo, boolean fisico, ArrayList<String> Mensagem){
        boolean acertou = true;
        if(state == States.turnoPlayer){
            if(Mensagem == null){
                Mensagem = new ArrayList<String>();
                Mensagem.add(Player.getNome() + " atacou");
            }
            if(Inimigo.dormindo){
                Mensagem.add(Inimigo.getNome() + " acordou");
            }
            BC.EsconderInterfacePlayer();
            Random rand = new Random();
            double taxaAcerto = 1/(1+Math.exp(-0.0310*(Player.getVelocidade() - Inimigo.getVelocidade())));
            System.out.println("Taxa de acerto: " + taxaAcerto + "/nPlayer: " + Player.getVelocidade() + "/nInimigo: " + Inimigo.getVelocidade());
            if(Player.cegado){
                taxaAcerto /= 2;
            }
            if(taxaAcerto < 0.05){
                taxaAcerto = 0.05;
            }
            else if(taxaAcerto > 0.95){
                taxaAcerto = 0.95;
            }
            System.out.println("Taxa de acerto: " + taxaAcerto);
            if(!(taxaAcerto > rand.nextDouble(0,1))){
                acertou = false;
            }
            if(acertou){
                Mensagem.add(this.Inimigo.tomarDano(Dano, tipo, fisico));
            }
            else{
                Mensagem.add(Player.getNome() + " errou o ataque");
            }
        }
        else{
            if(Mensagem == null){
                Mensagem = new ArrayList<String>();
                Mensagem.add(Inimigo.getNome() + " atacou");
            }
            if(Player.dormindo){
                Mensagem.add(Player.getNome() + " acordou");
            }
            Random rand = new Random();
            double taxaAcerto = 1/(1+Math.exp(-5*(Inimigo.getVelocidade() - Player.getVelocidade())));
            if(Inimigo.cegado){
                taxaAcerto /= 2;
            }
            if(!(taxaAcerto > rand.nextDouble(0,1))){
                acertou = false;
            }
            if(acertou){
                Mensagem.add(this.Player.tomarDano(Dano, tipo, fisico));
            }
            else{
                Mensagem.add(Inimigo.getNome() + " errou o ataque");
            }
        }
        ArrayList<String> finalMensagem = Mensagem;
        t.setOnFinished(event -> mostrarResultado(finalMensagem,true));
        t.play();
    }

    public void acaoNaoAgreciva(Timeline t, ArrayList<String> mensagem){
        t.setOnFinished(event -> mostrarResultado(mensagem, true));
        t.play();
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
    public void fugir(boolean conseguiu) throws IOException {
        ArrayList<String> i = new ArrayList<String>();
        if(BC.tipoBatalha.escapavel) {
            if (conseguiu) {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
            } else {
                i.add("Falhou em fugir");
            }
        }
        else{
            i.add("Não é possível fugir desta batalha");
        }
        mostrarResultado(i, true);
    }
}
