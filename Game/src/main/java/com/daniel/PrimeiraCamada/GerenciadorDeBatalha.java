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

    public void IniciarBatalha() throws IOException {
        if(Inimigo.velocidade > Player.velocidade){
            state = States.turnoInimigo;
            turnoInimigo();
        }
        else{
            state = States.turnoPlayer;
            turnoPlayer();
        }
    }
    public void MudarTurno() throws PlayerInexistenteException, IOException {
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
    public void turnoInimigo() throws IOException {
        if(Inimigo.stun > 0){
            Inimigo.stun--;
            ArrayList<String> mensagem = new ArrayList<>();
            mensagem.add("Inimigo esta stunado");
            mostrarResultado(mensagem, true);
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

    public void ApagarUiPlayer(){
        //ui.setOpacity(0); TO DO INSTANCIAR O NODE!
       // ui.setDisable(true); TO DO INSTANCIAR O NODE!
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
            ApagarUiPlayer();
            Random rand = new Random();
            double taxaAcerto = 1/(1+Math.exp(-5*(Player.getVelocidade() - Inimigo.getVelocidade())));
            if(Player.cegado){
                taxaAcerto /= 2;
            }
            if(!(taxaAcerto > rand.nextDouble(0,1))){
                acertou = false;
            }
            if(acertou){
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
        if(conseguiu){
            Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
        }
        else{
            ArrayList<String> i = new ArrayList<String>();
            i.add("Falhou em fugir");
            mostrarResultado(i, true);
        }
    }
}
