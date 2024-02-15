package com.daniel.Model.BatalhaDeTurnos;

import com.daniel.Model.ComportamentosInimigos.*;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Magias.TiposElementais;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.View.BattleController;
import com.daniel.game.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GerenciadorDeBatalha {

    public TipoBatalha tipoBatalha;
    public PersonagemLuta player, inimigo;
    BattleController controller;
    Comportamento comp;
    States estado;

    double pBar = 0, iBar = 0;

    public void Inicializar(TipoBatalha tb) throws IOException, PlayerInexistenteException {
        this.tipoBatalha = tb;
        this.tipoBatalha.Inicializar();
        this.player = new PersonagemLuta(Player.getPlayer());
        this.inimigo = new PersonagemLuta(tb.inimigo);
        if(tipoBatalha.inimigo.getComp() == Comportamentos.fugitivo){
            comp = new ComportamentoFugitivo(this.inimigo, this.player);
        }
        else if(tipoBatalha.inimigo.getComp() == Comportamentos.BossFinal1){
            comp = new ComportamentoBossFinal1(this.inimigo, this.player);
        }
        else if(tipoBatalha.inimigo.getComp() == Comportamentos.BossAquatico){
            comp = new ComportamentoBossAquatico(this.inimigo,this.player);
        }
        else{
            comp = new ComportamentoPadrao(this.inimigo, this.player);
        }
        this.pBar = 0;
        this.iBar = 0;
        FXMLLoader root = new FXMLLoader(Main.class.getResource("TelaBatalha.fxml"));
        Parent parent = root.load();
        this.controller = root.getController();
        Main.ChangeScene(parent);
        VerificarTurno();
    }
    private enum States{
        turnoPlayer,
        turnoInimigo;
    }

    public void VerificarTurno() throws IOException, PlayerInexistenteException {
        System.out.println("Buscando turno");
        this.controller.Atualiazar();
        System.out.println("Player: " + pBar + ", Inimigo: " + iBar);
        this.controller.MostrarInterfacePlayer(true);
        if(this.player.currentHp <=0){
            Derrota();
        }
        else if(this.inimigo.currentHp <= 0){
            Vitoria();
        }
        else if(this.pBar >= 1){
            this.pBar = 0;
            System.out.println("Turno player //" + this.getClass().getName());
            turnoPlayer();
        }
        else if(this.iBar >= 1){
            System.out.println("Turno inimigo");
            this.iBar = 0;
            turnoInimigo();
        }
        else{
            this.controller.ShowProgressBar(true);
            this.pBar += (double) this.player.getVelocidade() /1000;
            this.iBar += (double) this.inimigo.getVelocidade() /1000;
            this.controller.SetPlyerBar(pBar);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.2), event -> {
                try {
                    VerificarTurno();
                } catch (IOException | PlayerInexistenteException e) {
                    throw new RuntimeException(e);
                }
            }));
            timeline.play();
        }
    }

    public void turnoPlayer(){
        estado = States.turnoPlayer;
        ArrayList<String> mensagem = new ArrayList<>();
        if(this.player.envenenado){
            mensagem.add(this.player.TomarDanoVeneno());
        }
        if(this.player.stun > 0){
            this.player.stun--;
            mensagem.add(this.player.getNome() + " esta stunado");
            this.controller.mostrarResultado(mensagem);
        }
        else if(this.player.dormindo){
            mensagem.add(this.player.getNome() + " esta dormindo");
            this.controller.mostrarResultado(mensagem);
        }
        else{
            this.controller.ShowProgressBar(false);
            System.out.println("Turno player");
        }
    }
    public void turnoInimigo() throws IOException{
        estado = States.turnoInimigo;
        if(this.inimigo.stun > 0){
            this.inimigo.stun--;
            ArrayList<String> mensagem = new ArrayList<>();
            mensagem.add("Inimigo esta stunado");
            this.controller.mostrarResultado(mensagem);
        }
        else{
            Comportamento.acoes acao = comp.EscolherAcao();
            if(acao == Comportamento.acoes.fugir && this.tipoBatalha.escapavel){
                this.fugir(this.inimigo.fugir(this.player.getVelocidade()));
            }
            else if(acao == Comportamento.acoes.usarMagia){
                comp.magiaEscolhida.Conjurar(this, this.inimigo);
            }
            else{
                this.Ataque(this.inimigo.atqAnim.INICIAR(this.controller.getPlayerEffect()), this.inimigo.getAtqM(),this.inimigo.getTipoAtaqueBase(), true, null);
            }
        }
    }
    public void Ataque(Timeline t, int Dano, TiposElementais tipo, boolean fisico, ArrayList<String> Mensagem){
        boolean acertou = true;
        PersonagemLuta alvo = getAlvo(false), atacante = getAlvo(true);
        if(Mensagem == null){
            Mensagem = new ArrayList<String>();
            Mensagem.add(atacante.getNome() + " atacou");
        }
        if(alvo.dormindo){
            Mensagem.add(alvo.getNome() + " acordou");
        }
        this.controller.EsconderInterfacePlayer();
        Random rand = new Random();
        double taxaAcerto = 1/(1+Math.exp(-0.1*(atacante.getVelocidade() + 7 - alvo.getVelocidade())));
        System.out.println("Taxa de acerto: " + taxaAcerto + "/nPlayer: " + this.player.getVelocidade() + "/nInimigo: " + this.inimigo.getVelocidade());
        if(atacante.cegado){
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
            Mensagem.add(alvo.tomarDano(Dano, tipo, fisico));
        }
        else{
            Mensagem.add(atacante.getNome() + " errou o ataque");
        }
        this.controller.MostrarInterfacePlayer(false);
        ArrayList<String> finalMensagem = Mensagem;
        t.setOnFinished(event -> this.controller.mostrarResultado(finalMensagem));
        t.play();
    }

    public void acaoNaoAgreciva(Timeline t, ArrayList<String> mensagem){
        this.controller.MostrarInterfacePlayer(false);
        t.setOnFinished(event -> this.controller.mostrarResultado(mensagem));
        t.play();
    }
    public ImageView getAlvoView(boolean autoUsavel){
        if(!autoUsavel){
            if(this.estado == States.turnoInimigo){
                return this.controller.getPlayerEffect();
            }
            else{
                return this.controller.getEnimyEffect();
            }
        }
        else{
            if(this.estado == States.turnoInimigo){
                return this.controller.getEnimyEffect();
            }
            else{
                return this.controller.getPlayerEffect();
            }
        }
    }
    public PersonagemLuta getAlvo(boolean autoUsavel) {
        if(this.estado == States.turnoInimigo){
            if(!autoUsavel){
                return this.player;
            }
            else{
                return this.inimigo;
            }
        }
        else{
            if(!autoUsavel){
                return this.inimigo;
            }
            else{
                return this.player;
            }
        }
    }
    public void fugir(boolean conseguiu) throws IOException {
        ArrayList<String> i = new ArrayList<String>();
        if(this.tipoBatalha.escapavel) {
            if (conseguiu) {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
            } else {
                i.add("Falhou em fugir");
                this.controller.mostrarResultado(i);
            }
        }
        else{
            i.add("Não é possível fugir desta batalha");
            this.controller.mostrarResultado(i);
        }
    }
    private void Vitoria() throws PlayerInexistenteException, IOException {
        this.tipoBatalha.Vitoria();
        if(!this.tipoBatalha.finalizado){
            this.inimigo = new PersonagemLuta(this.tipoBatalha.inimigo);
            this.iBar = 0;
            VerificarTurno();
        }
        else{
            this.controller.Vitoria();
        }
    }
    private void Derrota() throws IOException {
        this.tipoBatalha.Derrota();
        this.controller.Derrota();
    }
}
