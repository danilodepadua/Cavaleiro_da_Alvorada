package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.*;
import com.daniel.PrimeiraCamada.ComportamentosInimigos.ComportamentoPadrao;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Magias.Escuridao;
import com.daniel.PrimeiraCamada.Magias.Fogo;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.Magias.Luz;
import com.daniel.SegundaCamada.SlashAnimation;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;

public class BattleController implements Initializable {
    ArrayList<Magia> magiasDisponiveis = new ArrayList<Magia>();
    GerenciadorDeBatalha gdb;
    private ArrayList<Item> itens = new ArrayList<>();
    int itemAtual = 0;

    private Inimigo[] inimigos;
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
    void AbrirMagias(ActionEvent event) {
        PnlPrimeirasEscolhas.setDisable(true);
        PnlOpcoes.setDisable(false);
        PnlOpcoes.setOpacity(1);
        ColocarMagias();
    }
    @FXML
    void SubirItens(ActionEvent event) {
        itemAtual -= 3;
        if(isItens) {
            ColocarItens();
        }
        else{
            ColocarMagias();
        }
    }
    @FXML
    void DescerItens(ActionEvent event) {
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
    void Fugir(ActionEvent event) throws PlayerInexistenteException {
        gdb.ApagarUiPlayer();
        gdb.fugir(player.fugir(Enimy.getVelocidade()));
    }

    public void Atualiazar(){
        try {
            InfoVida.setText("HP: " + player.getCurrentHp() + "/" + Player.getPlayer().getHP());
            InfoMp.setText("MP: " + player.getCurrentMp() + "/" + Player.getPlayer().getMP());
            InfoNome.setText(Player.getPlayer().getName());
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ColocarMagias() {
        isItens = false;
        VerificarSetas(magiasDisponiveis.size());

        for (int i = itemAtual; i< magiasDisponiveis.size() && i<(itemAtual+3); i++) {
            Button magiaButton = new Button();
            magiaButton.setText(magiasDisponiveis.get(i).getClass().getSimpleName() + " : " + magiasDisponiveis.get(i).getCusto() + "MP");
            magiaButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            magiaButton.prefHeightProperty().bind(VBoxItens.prefHeightProperty().subtract(20).divide(3));
            if(player.getCurrentMp() < magiasDisponiveis.get(i).getCusto()){
                magiaButton.setDisable(true);
            }
            int finalI = i;
            magiaButton.setOnAction(event -> {
                if(magiasDisponiveis.get(finalI) instanceof IEffects){
                    ((IEffects) magiasDisponiveis.get(finalI)).aplicarEfeito(Enimy);
                }
                itemAtual =0;
                RetornarInicial();
                magiasDisponiveis.get(finalI).Conjurar(gdb, player);
                Atualiazar();
            });
            VBoxItens.getChildren().add(magiaButton);
        }
    }


    public void ColocarItens(){
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
                    gdb.mostrarResultado(mensagem);
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

    public void RetornarInicial(){
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
        magiasDisponiveis.add(new Fogo());
        magiasDisponiveis.add(new Gelo());
        magiasDisponiveis.add(new Escuridao());
        magiasDisponiveis.add(new Luz());
        Random rand = new Random();
        Inimigo inimigo = inimigos[rand.nextInt(0, inimigos.length)];
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
        seta.setImage(new Image(Main.class.getResource("/com.daniel.Images/Seta.png").toString()));
        seta.setFitWidth(30);
        seta.setPreserveRatio(true);
        ImageView setaInv = new ImageView();
        setaInv.setImage(new Image(Main.class.getResource("/com.daniel.Images/Seta.png").toString()));
        setaInv.setFitWidth(30);
        setaInv.setPreserveRatio(true);
        setaInv.rotateProperty().set(180);
        SetaDescer.setGraphic(seta);
        SetaSubir.setGraphic(setaInv);
        Atualiazar();
        gdb = new GerenciadorDeBatalha(player, Enimy, InterfacePlayer, boxMensagem, txtMensagem, PlayerEffect, EnimyEffect, new ComportamentoPadrao(Enimy, player));
        gdb.IniciarBatalha();
    }
}
