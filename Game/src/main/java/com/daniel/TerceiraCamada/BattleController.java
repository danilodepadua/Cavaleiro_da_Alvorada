package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.*;
import com.daniel.PrimeiraCamada.ComportamentosInimigos.ComportamentoPadrao;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Magias.*;
import com.daniel.SegundaCamada.SlashAnimation;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;


public class BattleController implements Initializable {
    GerenciadorDeBatalha gdb;
    private ArrayList<Item> itens = new ArrayList<>();
    int itemAtual = 0;
    private Inimigo[] inimigos;
    private Inimigo inimigo;
    PersonagemLuta Enimy;
    PersonagemLuta player;

    @FXML
    private AnchorPane Back;

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
        gdb.Ataque(new SlashAnimation().INICIAR(EnimyEffect),player.getAtqF(), player.getTipoAtaqueBase(), true, null);
    }

    @FXML
    void Fugir(ActionEvent event) throws PlayerInexistenteException, IOException {
        gdb.ApagarUiPlayer();
        gdb.fugir(player.fugir(Enimy.getVelocidade()));
    }

    public void Vitoria() throws PlayerInexistenteException, IOException {
        for (Quest quest : com.daniel.PrimeiraCamada.Entidades.Player.getPlayer().getQuestsAtuais()) {
            if (quest.getNomeInimigo().equals(inimigo.getName())) {
                try {
                    quest.updateQuestCompleted();
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("TelaResultado.fxml"));
                    Parent root = loader.load();

                    ResultadoController resultadoController = loader.getController();
                    resultadoController.atualizarValores(Enimy.getXpDrop(),  Enimy.getMoedas(), Enimy.getLootTable());

                    Main.ChangeScene(root);
                } catch (PlayerInexistenteException e) {
                    System.err.println("Erro ao atualizar quests: " + e.getMessage());
                }
            }
        }
        Player.getPlayer().getBestiario().adicionarInimigos(inimigo);
        System.out.println("Player venceu");
    }

    public void Derrota() throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaGameOver.fxml")).load());

    }

    public void Atualiazar(){
        InfoVida.setText("HP: " + player.getCurrentHp() + "/" + player.getHP());
        InfoMp.setText("MP: " + player.getCurrentMp() + "/" + player.getMP());
        InfoNome.setText(player.getNome());
    }
    private void ColocarMagias() throws PlayerInexistenteException {
        isItens = false;
        VerificarSetas(Player.getPlayer().getMagias().size());

        for (int i = itemAtual; i< Player.getPlayer().getMagias().size() && i<(itemAtual+3); i++) {
            Button magiaButton = new Button();
            magiaButton.setText(Player.getPlayer().getMagias().get(i).getClass().getSimpleName() + " : " + Player.getPlayer().getMagias().get(i).getCusto() + "MP");
            magiaButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            magiaButton.prefHeightProperty().bind(VBoxItens.prefHeightProperty().subtract(20).divide(3));
            if(player.getCurrentMp() < Player.getPlayer().getMagias().get(i).getCusto()){
                magiaButton.setDisable(true);
            }
            int finalI = i;
            magiaButton.setOnAction(event -> {

                try {
                    if(Player.getPlayer().getMagias().get(finalI) instanceof IEffects){
                        ((IEffects) Player.getPlayer().getMagias().get(finalI)).aplicarEfeito(Enimy);
                    }
                    itemAtual =0;
                    RetornarInicial();
                    Player.getPlayer().getMagias().get(finalI).Conjurar(gdb, player);

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
                    mensagem.add(((IConsumableInBattle)itens.get(finalI)).Consumir(player));
                    if(itens.get(finalI).getQuant() <=0){
                        itens.remove(finalI);
                    }
                    itemAtual =0;
                    RetornarInicial();
                    gdb.ApagarUiPlayer();
                    Atualiazar();
                    gdb.mostrarResultado(mensagem, true);
                } catch (PlayerInexistenteException e) {
                    throw new RuntimeException(e);
                }
            });
            VBoxItens.getChildren().add(itemBtn);
        }
    }

    private void VerificarSetas(int size) {
        if(itemAtual == 0){
            SetaSubir.setDisable(true);
        }
        else{
            SetaSubir.setDisable(false);
        }
        if(itemAtual+3 > size){
            SetaDescer.setDisable(true);
        }
        else{
            SetaDescer.setDisable(false);
        }
        VBoxItens.getChildren().clear();
    }

    private void RetornarInicial(){
        PnlOpcoes.setDisable(true);
        PnlOpcoes.setOpacity(0);
        PnlPrimeirasEscolhas.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inimigos = Main.cidadeAtual.getInimigos();
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
        Random rand = new Random();
        inimigo = inimigos[rand.nextInt(0, inimigos.length)];
        EnimyImg.setImage(inimigo.getImagem());
        Enimy = new PersonagemLuta(inimigo);
        try {
            player = new PersonagemLuta(Player.getPlayer());
            for(Item i : Player.getPlayer().getInventario().getItens()){
                if(i instanceof IConsumableInBattle){
                    itens.add(i);
                }
            }
            System.out.println(itens.size());
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
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
        gdb = new GerenciadorDeBatalha(player, Enimy, InterfacePlayer, boxMensagem, txtMensagem, PlayerEffect, EnimyEffect,this ,new ComportamentoPadrao(Enimy, player));
        try {
            gdb.IniciarBatalha();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
