package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.game.Main;
import javafx.animation.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerBestiario implements Initializable {

    @FXML
    private GridPane GridAbsorcoes;

    @FXML
    private GridPane GridFraquezas;

    @FXML
    private GridPane GridImunidades;
    @FXML
    private AnchorPane PnlInfos;
    @FXML
    private GridPane GridResistencias;
    @FXML
    private ImageView ImgBesta;

    @FXML
    private Text TxtFr;

    @FXML
    private Text TxtHP;

    @FXML
    private Text TxtInt;

    @FXML
    private Text TxtMP;

    @FXML
    private Text TxtNome;

    @FXML
    private Text TxtRes;

    @FXML
    private Text TxtVel;

    @FXML
    private VBox VBoxBestas;
    @FXML
    private ScrollPane scrollPane;

    @FXML
    void OnActionVoltar(ActionEvent event) {
        Main.ChangeScene("TelaInfosPlayer.fxml");
    }
    private void AjustarElementos(Inimigo ini){
        for(int i = 0; i<9;i++){
            GridAbsorcoes.getChildren().get(i).setOpacity(0.2);
            GridFraquezas.getChildren().get(i).setOpacity(0.2);
            GridResistencias.getChildren().get(i).setOpacity(0.2);
            GridImunidades.getChildren().get(i).setOpacity(0.2);
        }
        if(ini != null){
            verificarTipos(ini.getAbsorcao(), GridAbsorcoes);
            verificarTipos(ini.getResistencias(), GridResistencias);
            verificarTipos(ini.getFraquezas(), GridFraquezas);
            verificarTipos(ini.getImunidades(), GridImunidades);
        }
    }

    public Transition AnimarQueda(Node node){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), node);
        scaleTransition.setToY(1);
        scaleTransition.setToX(1);
        scaleTransition.setFromX(0.1);
        scaleTransition.setFromY(0.1);
        return scaleTransition;
    }
    private void verificarTipos(TiposElementais [] Te, GridPane pane) {
        for (TiposElementais te : Te) {
            switch (te) {
                case Gelo:
                    pane.getChildren().get(4).setOpacity(1);
                    break;
                case Luz:
                    pane.getChildren().get(7).setOpacity(1);
                    break;
                case Terra:
                    pane.getChildren().get(3).setOpacity(1);
                    break;
                case Fogo:
                    pane.getChildren().get(0).setOpacity(1);
                    break;
                case Vento:
                    pane.getChildren().get(2).setOpacity(1);
                    break;
                case Agua:
                    pane.getChildren().get(1).setOpacity(1);
                    break;
                case Eletrico:
                    pane.getChildren().get(5).setOpacity(1);
                    break;
                case Escuridao:
                    pane.getChildren().get(6).setOpacity(1);
                    break;
                case NaoElemental:
                    pane.getChildren().get(8).setOpacity(1);
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Antes: " + VBoxBestas.getPrefWidth());
        System.out.println("Antes: " + scrollPane.getWidth());
        VBoxBestas.setPrefWidth(Main.getLargura() - 510);
        System.out.println("Depois: " + VBoxBestas.getPrefWidth());
        System.out.println("Depois: " + scrollPane.getWidth());
        try {
            Inimigo[] bestas = Player.getPlayer().getBestiario().getInimigos();
            ParallelTransition sequenciaTransicoes = new ParallelTransition();
            int j = 0;
            for(Inimigo i : bestas){
                Button btnBesta = new Button();
                if(i == null){
                    btnBesta.setText("?????");
                    btnBesta.setOnAction(event -> {
                        TxtFr.setText("Força: ???");
                        TxtHP.setText("HP: ???");
                        TxtMP.setText("MP: ???");
                        TxtNome.setText("?????");
                        TxtRes.setText("Resistência: ???");
                        TxtInt.setText("Inteligência: ???");
                        TxtVel.setText("Velocidade: ???");
                        PnlInfos.setOpacity(1);
                        ImgBesta.setImage(new Image(Main.class.getResource("/com.daniel.Images/Interrogacao.png").toString()));
                        AjustarElementos(i);
                    });
                }
                else{
                    btnBesta.setText(i.getName());
                    btnBesta.setOnAction(event -> {
                        TxtFr.setText("Força: " + i.getForce());
                        TxtHP.setText("HP: " + i.getHP());
                        TxtMP.setText("MP: " + i.getMP());
                        TxtNome.setText(i.getName());
                        TxtRes.setText("Resistência: " + i.getResistencia());
                        TxtInt.setText("Inteligência: " + i.getInteligence());
                        TxtVel.setText("Velocidade: " + i.getVelocity());
                        ImgBesta.setImage(i.getImagem());
                        PnlInfos.setOpacity(1);
                        AjustarElementos(i);
                    });
                }
                btnBesta.setPrefWidth(Double.MAX_VALUE);
                VBoxBestas.getChildren().add(btnBesta);
                SequentialTransition transition = new SequentialTransition();
                transition.getChildren().addAll(new PauseTransition(Duration.millis(j*50)),AnimarQueda(btnBesta));
                sequenciaTransicoes.getChildren().add(transition);
                j++;
            }
            sequenciaTransicoes.play();
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
}
