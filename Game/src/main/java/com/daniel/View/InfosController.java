package com.daniel.View;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Magias.TiposElementais;
import com.daniel.game.Main;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.*;

public class InfosController implements Initializable {

    @FXML
    private Rectangle GrafAF;

    @FXML
    private Rectangle GrafAM;

    @FXML
    private Rectangle GrafDF;

    @FXML
    private Rectangle GrafDM;

    @FXML
    private GridPane GridElementos;

    @FXML
    private ImageView ImgPlayer;

    @FXML
    private Circle SinalPontos;

    @FXML
    private Text TxtLvl;

    @FXML
    private Text TxtNome;

    @FXML
    private Text TxtNomeArma;

    @FXML
    private Text TxtNomeCalca;

    @FXML
    private Text TxtNomeCapacete;

    @FXML
    private Text TxtNomePeitoral;

    @FXML
    private Text TxtXPAtual;

    @FXML
    private Text TxtXPProx;

    @FXML
    private Button btnBestiario;

    @FXML
    private Button btnInventario;

    @FXML
    private Button btnPontos;

    @FXML
    private Button btnVoltar;
    @FXML
    private AnchorPane panePrincipal;
    @FXML
    void OnActionBestiario(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBestiario.fxml")).load());
    }

    @FXML
    void OnActionInventario(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInventario.fxml")).load());
    }

    @FXML
    void OnActionPontos(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaStatus.fxml")).load());
    }

    @FXML
    void OnActionVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }

    private void AnimarBarras(Rectangle rectangle, int valor) {
        KeyValue keyValue = new KeyValue(rectangle.widthProperty(), valor);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        timeline.play();
    }
    private void ClarearAnim(Node node){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), node);
        fadeTransition.setFromValue(node.getOpacity());
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }
    private void verificarElementos() throws PlayerInexistenteException {
        for(int i = 0; i<4; i++){
            for(int j=1; j<10;j++){
                GridElementos.getChildren().get(j+(i*10)).setOpacity(0.2);
            }
        }
        ArrayList<TiposElementais[]> lista = new ArrayList<>();
        lista.add(Player.getPlayer().getFraquezas());
        lista.add(Player.getPlayer().getResistencias());
        lista.add(Player.getPlayer().getImundades());
        lista.add(Player.getPlayer().getAbsorcoes());
        for(int i = 0; i<lista.size();i++){
            for(int j = 0; j<lista.get(i).length;j++){
                switch (lista.get(i)[j]) {
                    case Gelo:
                        ClarearAnim(GridElementos.getChildren().get(5+(i*10)));
                        break;
                    case Luz:
                        ClarearAnim(GridElementos.getChildren().get(8+(i*10)));
                        break;
                    case Terra:
                        ClarearAnim(GridElementos.getChildren().get(4+(i*10)));
                        break;
                    case Fogo:
                        ClarearAnim(GridElementos.getChildren().get(1+(i*10)));
                        break;
                    case Vento:
                        ClarearAnim(GridElementos.getChildren().get(3+(i*10)));
                        break;
                    case Agua:
                        ClarearAnim(GridElementos.getChildren().get(2+(i*10)));
                        break;
                    case Eletrico:
                        ClarearAnim(GridElementos.getChildren().get(6+(i*10)));
                        break;
                    case Escuridao:
                        ClarearAnim(GridElementos.getChildren().get(7+(i*10)));
                        break;
                    case NaoElemental:
                        ClarearAnim(GridElementos.getChildren().get(9+(i*10)));
                        break;
                }
            }
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            configurarBotoes(btnBestiario);
            configurarBotoes(btnInventario);
            configurarBotoes(btnPontos);
            contornarBotaoVoltar(btnVoltar);
            definirBackground(panePrincipal, "/com.daniel.Images/Fundos/fundoPedra.jpg");

            if (Player.getPlayer().getPontos() > 0){
                SinalPontos.setOpacity(1);
            }
            else{
                SinalPontos.setOpacity(0);
            }
            String lvl = "Lvl: "+String.valueOf(Player.getPlayer().getLvl());
            TxtLvl.setText(lvl);
            TxtNome.setText(Player.getPlayer().getName());
            TxtNomeArma.setText(Player.getPlayer().getArma().getNome());
            TxtNomeCalca.setText(Player.getPlayer().getCalca().getNome());
            TxtNomeCapacete.setText(Player.getPlayer().getCapacete().getNome());
            TxtNomePeitoral.setText(Player.getPlayer().getPeitoral().getNome());
            String xp = "Exp. Atual: " + String.valueOf(Player.getPlayer().getXp());
            TxtXPAtual.setText(xp);
            String xpProx = "Exp. Prox.: " + String.valueOf((Player.getPlayer().getLvl()*1000) - Player.getPlayer().getXp());
            TxtXPProx.setText(xpProx);
            ImgPlayer.setImage(Player.getPlayer().getImagem());

            AnimarBarras(GrafAF, Player.getPlayer().getAtaqueF());
            AnimarBarras(GrafAM, Player.getPlayer().getAtaqueM());
            AnimarBarras(GrafDF, Player.getPlayer().getDefesaF());
            AnimarBarras(GrafDM, Player.getPlayer().getDefesaM());
            verificarElementos();
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
}
