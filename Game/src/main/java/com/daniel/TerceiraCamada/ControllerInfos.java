package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerInfos implements Initializable {

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
    void OnActionBestiario(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBestiario.fxml")));
    }

    @FXML
    void OnActionInventario(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInventario.fxml")));
    }

    @FXML
    void OnActionPontos(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaStatus.fxml")));
    }

    @FXML
    void OnActionVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
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
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
}
