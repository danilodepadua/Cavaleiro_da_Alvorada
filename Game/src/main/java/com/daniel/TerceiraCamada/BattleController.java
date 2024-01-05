package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoExemplo1;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.GerenciadorDeBatalha;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposDano;
import com.daniel.SegundaCamada.SlashAnimation;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;

public class BattleController implements Initializable {

    GerenciadorDeBatalha gdb;
    private ArrayList<Item> itens = new ArrayList<>();
    int itemAtual = 0;

    private Inimigo[] inimigos = {new InimigoExemplo1()};
    PersonagemLuta Enimy;
    PersonagemLuta player;

    @FXML
    private AnchorPane Back;
    @FXML
    private AnchorPane boxMensagem;
    @FXML
    private Text txtMensagem;

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
    private AnchorPane PnlItens;

    @FXML
    private ImageView PlayerEffect;

    @FXML
    private ImageView PlayerImg;

    @FXML
    private AnchorPane PnlPrimeirasEscolhas;

    @FXML
    private AnchorPane Screen;

    @FXML
    private Button SetaDescer;

    @FXML
    private Button SetaSubir;

    @FXML
    private VBox VBoxItens;

    @FXML
    void AbrirItens(ActionEvent event) {
        PnlPrimeirasEscolhas.setDisable(true);
        PnlItens.setDisable(false);
        PnlItens.setOpacity(1);
        ColocarItens();
    }
    @FXML
    void SubirItens(ActionEvent event) {
        itemAtual -= 3;
        ColocarItens();
    }
    @FXML
    void DescerItens(ActionEvent event) {
        itemAtual += 3;
        ColocarItens();
    }
    @FXML
    void Sair(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();
        System.out.println("x: " + x + ", y: " + y);
        Bounds boundsInScene = PnlItens.localToScene(PnlItens.getBoundsInLocal());
        System.out.println("Minx: " + boundsInScene.getMinX() + ", Miny: " + boundsInScene.getMinY());
        System.out.println("Maxx: " + boundsInScene.getMaxX() + ", Maxy: " + boundsInScene.getMaxY());
        if (!boundsInScene.contains(x,y) && !PnlItens.isDisable()) {
            RetornarInicial();
            System.out.println("Clique fora do painel!");
        }
    }

    @FXML
    void Atacar(ActionEvent event) throws PlayerInexistenteException {
        gdb.Ataque(new SlashAnimation().INICIAR(EnimyEffect),player.getAtqF(), player.getTipoAtaqueBase());
    }

    @FXML
    void Fugir(ActionEvent event) throws PlayerInexistenteException {
        Random rand = new Random();
        int i = rand.nextInt(0, 100);
        if(i >= 50-(player.getVelocidade()-Enimy.getVelocidade())){
            Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
        }
        else{
            gdb.ApagarUiPlayer();
            gdb.mostrarResultado("Player falhou em fugir");
        }
    }

    public void Atualiazar(){
        try {
            InfoVida.setText("HP: " + Player.getPlayer().getcHP() + "/" + Player.getPlayer().getHP());
            InfoMp.setText("MP: " + Player.getPlayer().getcMp() + "/" + Player.getPlayer().getMP());
            InfoNome.setText(Player.getPlayer().getName());
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ColocarItens(){
        if(itemAtual == 0){
            SetaSubir.setDisable(true);
        }
        else{
            SetaSubir.setDisable(false);
        }
        if(itemAtual+3 > itens.size()){
            SetaDescer.setDisable(true);
        }
        else{
            SetaDescer.setDisable(false);
        }
        VBoxItens.getChildren().clear();
        for(int i = itemAtual; i< itens.size() && i<(itemAtual+3); i++){
            Button itemBtn = new Button();
            itemBtn.setText(itens.get(i).getNome() + " : X" + itens.get(i).getQuant());
            itemBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            itemBtn.prefHeightProperty().bind(VBoxItens.prefHeightProperty().subtract(20).divide(3));
            int finalI = i;
            itemBtn.setOnAction(event -> {
                try {
                    ((IConsumableInBattle)itens.get(finalI)).Consumir(player);
                    itens.get(finalI).MenosQuant();
                    if(itens.get(finalI).getQuant() <=0){
                        itens.remove(finalI);
                    }
                } catch (PlayerInexistenteException e) {
                    throw new RuntimeException(e);
                }
            });
            VBoxItens.getChildren().add(itemBtn);
        }
    }
    public void RetornarInicial(){
        PnlItens.setDisable(true);
        PnlItens.setOpacity(0);
        PnlPrimeirasEscolhas.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        PnlItens.setPickOnBounds(true);
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
        gdb = new GerenciadorDeBatalha(player, Enimy, InterfacePlayer, boxMensagem, txtMensagem);
        gdb.IniciarBatalha();
    }
}
