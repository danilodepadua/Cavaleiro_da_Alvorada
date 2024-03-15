package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.BatalhaDeTurnos.*;
import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.Magias.Animacoes.SlashAnimation;
import com.daniel.game.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

import java.net.URL;
import java.util.ResourceBundle;


public class BattleController implements Initializable {
    GerenciadorDeBatalha gdb;
    private ArrayList<Item> itens = new ArrayList<>();
    int itemAtual = 0;
    @FXML
    private AnchorPane Back;
    @FXML
    private ProgressBar PlayerBar;

    @FXML
    private Button BtnAtacar;

    @FXML
    private Button BtnFugir;

    @FXML
    private Button BtnItens;

    @FXML
    private Button BtnMagias;

    @FXML
    private ImageView EnimyEffect;

    @FXML
    private ImageView EnimyImg;

    @FXML
    private GridPane GridActions;

    @FXML
    private Text InfoMp;

    @FXML
    private Text InfoNivel;

    @FXML
    private Text InfoNome;

    @FXML
    private Text InfoVida;

    @FXML
    private AnchorPane InterfacePlayer;

    @FXML
    private ImageView PlayerEffect;

    @FXML
    private ImageView PlayerImg;

    @FXML
    private AnchorPane PnlOpcoes;

    @FXML
    private AnchorPane PnlPrimeirasEscolhas;

    @FXML
    private AnchorPane Screen;

    @FXML
    private Button SetaDescer;

    @FXML
    private Button SetaDescer1;

    @FXML
    private Button SetaSubir;

    @FXML
    private Button SetaSubir1;

    @FXML
    private VBox VBoxItens;

    @FXML
    private VBox VboxMagias;

    @FXML
    private AnchorPane boxMensagem;

    @FXML
    private Text txtMensagem;

    boolean isItens;
    public static AudioPlayer controladorMusica = new AudioPlayer();

    @FXML
    void AbrirItens(ActionEvent event) {
        PnlPrimeirasEscolhas.setDisable(true);
        PnlOpcoes.setDisable(false);
        PnlOpcoes.setOpacity(1);
        ColocarItens();
    }
    @FXML
    void AbrirMagias(ActionEvent event) throws PlayerInexistenteException {
        PnlPrimeirasEscolhas.setDisable(true);
        PnlOpcoes.setDisable(false);
        PnlOpcoes.setOpacity(1);
        ColocarMagias();
    }
    @FXML
    void SubirItens(ActionEvent event) throws PlayerInexistenteException {
        itemAtual -= 3;
        if(isItens) {
            ColocarItens();
        }
        else{
            ColocarMagias();
        }
    }
    @FXML
    void DescerItens(ActionEvent event) throws PlayerInexistenteException {
        itemAtual += 3;
        if(isItens) {
            ColocarItens();
        }
        else{
            ColocarMagias();
        }
    }
    public void ShowProgressBar(boolean mostrar){
        if(mostrar){
            PlayerBar.setOpacity(1);
            PlayerBar.setDisable(false);
            PnlPrimeirasEscolhas.setDisable(true);
            PnlPrimeirasEscolhas.setOpacity(0);
        }
        else{
            PlayerBar.setOpacity(0);
            PlayerBar.setDisable(true);
            PnlPrimeirasEscolhas.setOpacity(1);
            PnlPrimeirasEscolhas.setDisable(false);
        }
    }
    @FXML
    void Sair(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();
        System.out.println("x: " + x + ", y: " + y);
        Bounds boundsInScene = PnlOpcoes.localToScene(PnlOpcoes.getBoundsInLocal());
        System.out.println("Minx: " + boundsInScene.getMinX() + ", Miny: " + boundsInScene.getMinY());
        System.out.println("Maxx: " + boundsInScene.getMaxX() + ", Maxy: " + boundsInScene.getMaxY());
        if (!boundsInScene.contains(x,y) && !PnlOpcoes.isDisable()) {
            RetornarInicial();
            System.out.println("Clique fora do painel!");
        }
    }

    @FXML
    void Atacar(ActionEvent event) throws PlayerInexistenteException {
        gdb.Ataque(new SlashAnimation().INICIAR(EnimyEffect),this.gdb.player.getAtqF(),
                this.gdb.player.getTipoAtaqueBase(), true, null);

        JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_swordSlash.wav");
    }

    @FXML
    void Fugir(ActionEvent event) throws PlayerInexistenteException, IOException {
        EsconderInterfacePlayer();
        gdb.fugir(this.gdb.player.fugir(this.gdb.inimigo.getVelocidade()));
    }
    public void mostrarResultado(ArrayList<String> mensagems){
        Timeline T = new Timeline();
        double time = 0.2;
        for(String i : mensagems) {
            T.getKeyFrames().add(new KeyFrame(Duration.seconds(time), event -> {
                boxMensagem.setOpacity(1);
                txtMensagem.setText(i);
            }));
            time+=1/ ConfiguracoesUsuario.obterVelelocidadeTextoBatalhaPadrao();
        }
        T.getKeyFrames().add(new KeyFrame(Duration.seconds(time), event -> {boxMensagem.setOpacity(0); txtMensagem.setText("");}));
        T.setOnFinished(event -> {
            try {
                gdb.VerificarTurno();
            } catch (IOException | PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });
        T.play();
    }
    public void SetPlyerBar(double d){
        PlayerBar.setProgress(d);
    }
    public ImageView getPlayerEffect(){
        return PlayerEffect;
    }
    public ImageView getEnimyEffect(){
        return EnimyEffect;
    }
    public void Vitoria() throws PlayerInexistenteException, IOException {
        Player.getPlayer().AtualizarStatus(this.gdb.player.getCurrentHp(), this.gdb.player.getCurrentMp());
    }


    public void Atualiazar(){
        InfoVida.setText("HP: " + this.gdb.player.getCurrentHp() + "/" + this.gdb.player.getHP());
        InfoMp.setText("MP: " + this.gdb.player.getCurrentMp() + "/" + this.gdb.player.getMP());
        InfoNome.setText(this.gdb.player.getNome());
    }
    private void ColocarMagias() throws PlayerInexistenteException {
        isItens = false;
        VerificarSetas(Player.getPlayer().getMagias().size());

        for (int i = itemAtual; i< Player.getPlayer().getMagias().size() && i<(itemAtual+3); i++) {
            Button magiaButton = new Button();
            magiaButton.setText(Player.getPlayer().getMagias().get(i).getNome() + " : " + Player.getPlayer().getMagias().get(i).getCusto() + "MP");
            magiaButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            magiaButton.prefHeightProperty().bind(VBoxItens.prefHeightProperty().subtract(20).divide(3));
            if(this.gdb.player.getCurrentMp() < Player.getPlayer().getMagias().get(i).getCusto()){
                magiaButton.setDisable(true);
            }
            int finalI = i;
            magiaButton.setOnAction(event -> {

                try {
                    if(Player.getPlayer().getMagias().get(finalI) instanceof IEffects){
                        ((IEffects) Player.getPlayer().getMagias().get(finalI)).aplicarEfeito(this.gdb.inimigo);
                    }
                    itemAtual =0;
                    RetornarInicial();
                    Player.getPlayer().getMagias().get(finalI).Conjurar(gdb, this.gdb.player);

                } catch (PlayerInexistenteException e) {
                    throw new RuntimeException(e);
                }

            });
            VBoxItens.getChildren().add(magiaButton);
        }
    }


    private void ColocarItens(){
        isItens = true;
        VerificarSetas(itens.size());
        for(int i = itemAtual; i< itens.size() && i<(itemAtual+3); i++){
            Button itemBtn = new Button();
            itemBtn.setText(itens.get(i).getNome() + " : X" + itens.get(i).getQuant());
            itemBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            itemBtn.prefHeightProperty().bind(VBoxItens.prefHeightProperty().subtract(20).divide(3));
            int finalI = i;
            itemBtn.setOnAction(event -> {
                try {
                    ArrayList<String> mensagem = new ArrayList<>();
                    mensagem.add(((IConsumableInBattle)itens.get(finalI)).Consumir(this.gdb.player));
                    if(itens.get(finalI).getQuant() <=0){
                        itens.remove(finalI);
                    }
                    itemAtual =0;
                    RetornarInicial();
                    EsconderInterfacePlayer();
                    Atualiazar();
                    mostrarResultado(mensagem);
                } catch (PlayerInexistenteException e) {
                    throw new RuntimeException(e);
                }
            });
            VBoxItens.getChildren().add(itemBtn);
        }
    }

    private void VerificarSetas(int size) {
        SetaSubir.setDisable(itemAtual == 0);
        SetaDescer.setDisable(itemAtual + 3 > size);
        VBoxItens.getChildren().clear();
    }

    private void RetornarInicial(){
        PnlOpcoes.setDisable(true);
        PnlOpcoes.setOpacity(0);
        PnlPrimeirasEscolhas.setDisable(false);
    }

    public void MostrarInterfacePlayer(boolean b){
        if(b) {
            System.out.println("Mostrar interface player.");
            InterfacePlayer.setOpacity(1);
            InterfacePlayer.setDisable(false);
            BtnMagias.setDisable(this.gdb.player.getSilenciado());
        }
        else{
            InterfacePlayer.setOpacity(0);
            InterfacePlayer.setDisable(true);
        }
    }
    public void EsconderInterfacePlayer(){
        InterfacePlayer.setOpacity(0);
        InterfacePlayer.setDisable(true);
    }
    public void ShowMensage(String s){
        ArrayList<String> mensagem = new ArrayList<>();
        mensagem.add(s);
        mostrarResultado(mensagem);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gdb = JogoFachada.getInstance().getGerenciadorDeBatalha();
        JogoFachada.getInstance().getAudioPlayer().PlayLoop("/com.daniel.audios/NovasMusicas/Batalhas/BatalhaComum1/Battle-Abysswalker_intro.wav", "/com.daniel.audios/NovasMusicas/Batalhas/BatalhaComum1/Battle-Abysswalker_loop.wav");
        Screen.setBackground(new Background(new BackgroundImage(Main.cidadeAtual.getFundoBatalha(),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        true
                ))));
        try {
            this.gdb.player = new PersonagemLuta(Player.getPlayer());
            for(Item i : Player.getPlayer().getInventario().getItens()){
                if(i instanceof IConsumableInBattle){
                    itens.add(i);
                }
            }
            System.out.println(itens.size());
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
        EnimyImg.setImage(this.gdb.tipoBatalha.inimigo.getImagem());
        try {
            PlayerImg.setImage(Player.getPlayer().getImagem());
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
        PlayerImg.setFitHeight(PlayerImg.getFitHeight()*1.5);
        PnlOpcoes.setPickOnBounds(true);
        ImageView seta = new ImageView();
        seta.setImage(new Image(Main.class.getResource("/com.daniel.Images/Setas/Seta.png").toString()));
        seta.setFitWidth(30);
        seta.setPreserveRatio(true);
        ImageView setaInv = new ImageView();
        setaInv.setImage(new Image(Main.class.getResource("/com.daniel.Images/Setas/Seta.png").toString()));
        setaInv.setFitWidth(30);
        setaInv.setPreserveRatio(true);
        setaInv.rotateProperty().set(180);
        SetaDescer.setGraphic(seta);
        SetaSubir.setGraphic(setaInv);
        Atualiazar();
    }
}
