package com.daniel.Model.BatalhaDeTurnos;

import com.daniel.Model.ComportamentosInimigos.*;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
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
        if(this.player.currentHp <=0){
            Derrota();
        }
        else if(this.inimigo.currentHp <= 0){
            Vitoria();
        }
        else {
            this.controller.MostrarInterfacePlayer(true);
            if (this.pBar >= 1) {
                this.pBar = 0;
                System.out.println("Turno player //" + this.getClass().getName());
                turnoPlayer();
            } else if (this.iBar >= 1) {
                System.out.println("Turno inimigo");
                this.iBar = 0;
                turnoInimigo();
            } else {
                this.controller.ShowProgressBar(true);
                this.pBar += (double) this.player.getVelocidade() / 100;
                this.iBar += (double) this.inimigo.getVelocidade() / 100;
                this.controller.SetPlyerBar(pBar);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), event -> {
                    try {
                        VerificarTurno();
                    } catch (IOException | PlayerInexistenteException e) {
                        throw new RuntimeException(e);
                    }
                }));
                timeline.play();
            }
        }
    }

    public void turnoPlayer(){
        estado = States.turnoPlayer;
        ArrayList<TextoNode> mensagem = new ArrayList<>();
        if(this.player.envenenado){
            mensagem.add(this.player.TomarDanoVeneno());
        }
        if(this.player.regen>0){
            this.player.regen --;
            this.player.currentHp += this.player.currentHp/5;
            mensagem.add(new TextoNode("Você teve sua vida regenerada","Your hp was regenerated"));
        }
        if(this.player.stun > 0){
            this.player.stun--;
            mensagem.add(new TextoNode(this.player.getNome() + " esta stunado",this.player.getNome() + " is stunned"));
            this.controller.mostrarResultado(mensagem);
        }
        else if(this.player.dormindo){
            mensagem.add(new TextoNode(this.player.getNome() + " esta dormindo",this.player.getNome() + " is sleeping"));
            this.controller.mostrarResultado(mensagem);
        }
        else{
            this.controller.ShowProgressBar(false);
            System.out.println("Turno player");
        }
    }
    public void turnoInimigo() throws IOException{
        estado = States.turnoInimigo;
        ArrayList<TextoNode> mensagem = new ArrayList<>();
        if(this.inimigo.envenenado){
            mensagem.add(this.player.TomarDanoVeneno());
        }
        if(this.inimigo.regen>0){
            this.inimigo.regen --;
            this.inimigo.currentHp += this.inimigo.currentHp/5;
            mensagem.add(new TextoNode("O inimigo teve sua vida regenerada","The enemy's hp was regenerated"));
        }
        if(this.inimigo.stun > 0){
            this.inimigo.stun--;
            mensagem.add(new TextoNode("O inimigo esta stunado", "The enemy is stunned"));
            this.controller.mostrarResultado(mensagem);
        }
        else if(this.inimigo.dormindo){
            mensagem.add(new TextoNode(this.inimigo.getNome() + " esta dormindo",this.inimigo.getNome() + " is sleeping"));
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
                this.Ataque(this.inimigo.atqAnim.INICIAR(this.controller.getPlayerEffect()), this.inimigo.getAtqF(),this.inimigo.getTipoAtaqueBase(), true, null);
            }
        }
    }
    public void Ataque(Timeline t, int Dano, TiposElementais tipo, boolean fisico, ArrayList<TextoNode> Mensagem){
        boolean acertou = true;
        boolean critico = true;
        PersonagemLuta alvo = getAlvo(false), atacante = getAlvo(true);
        if(Mensagem == null){
            Mensagem = new ArrayList<TextoNode>();
            Mensagem.add(new TextoNode(atacante.getNome() + " atacou", atacante.getNome() + " attacked"));
        }
        if(alvo.dormindo){
            Mensagem.add(new TextoNode(alvo.getNome() + " acordou",alvo.getNome() + " wake up"));
        }
        this.controller.EsconderInterfacePlayer();
        Random rand = new Random();
        double taxaAcerto = 1/(1+Math.exp(-0.01*(atacante.getVelocidade() + (0.25*(atacante.sorte+5-alvo.sorte)) - alvo.getVelocidade())));
        double taxaCritico = 1/(1+Math.exp(-0.1*(atacante.getVelocidade() + (0.25*(atacante.sorte+5-alvo.sorte)) - alvo.getVelocidade())));
        System.out.println("Taxa de acerto: " + taxaAcerto + "/nPlayer: " + this.player.getVelocidade() + "/nInimigo: " + this.inimigo.getVelocidade());
        if(atacante.cegado){
            taxaAcerto /= 2;
        }
        if(taxaAcerto < 0.2){
            taxaAcerto = 0.2;
        }
        else if(taxaAcerto > 0.95){
            taxaAcerto = 0.95;
        }
        System.out.println("Taxa de acerto: " + taxaAcerto);
        if(!(taxaAcerto > rand.nextDouble(0,1))){
            acertou = false;
        }
        if(!(taxaCritico > rand.nextDouble(0,1))){
            critico = false;
        }
        if(acertou){
            if(critico){
                Dano = (int)(Dano*1.5f);
                Mensagem.add(new TextoNode("Acerto crítico!!", "Critical hit!!"));
            }
            Mensagem.add(alvo.tomarDano(Dano, tipo, fisico));
        }
        else{
            Mensagem.add(new TextoNode(atacante.getNome() + " errou o ataque", atacante.getNome() + " missed the attack"));
        }
        this.controller.MostrarInterfacePlayer(false);
        ArrayList<TextoNode> finalMensagem = Mensagem;
        t.setOnFinished(event -> this.controller.mostrarResultado(finalMensagem));
        t.play();
    }

    public void acaoNaoAgreciva(Timeline t, ArrayList<TextoNode> mensagem){
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
        ArrayList<TextoNode> i = new ArrayList<TextoNode>();
        if(this.tipoBatalha.escapavel) {
            if (conseguiu) {
                int quem;
                if(estado==States.turnoPlayer){
                    quem = 1;
                }
                else {
                    quem = 2;
                }
                i.add(new TextoNode("Fugiu da batalha","Escaped"));
                this.controller.mostrarResultado(i);
                this.controller.Fuga(quem);
            } else {
                i.add(new TextoNode("Falhou em fugir","Failed to escape"));
                this.controller.mostrarResultado(i);
            }
        }
        else{
            i.add(new TextoNode("Não é possível fugir desta batalha","It's impossible to escape"));
            this.controller.mostrarResultado(i);
        }
    }
    private void Vitoria() throws PlayerInexistenteException, IOException {
        Timeline dest = this.controller.Destruir();
        dest.setOnFinished(event -> {
            try {
                Player.getPlayer().AtualizarStatus(this.player.getCurrentHp(), this.player.getCurrentMp());
                this.tipoBatalha.Vitoria();
                if(!this.tipoBatalha.finalizado){
                    this.inimigo = new PersonagemLuta(this.tipoBatalha.inimigo);
                    this.iBar = 0;
                    VerificarTurno();
                }
            } catch (PlayerInexistenteException | IOException e) {
                System.out.println("Destruindo3");
                throw new RuntimeException(e);
            }
        });
        dest.play();
    }
    private void Derrota() throws IOException {
        this.tipoBatalha.Derrota();
    }
}
