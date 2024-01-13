package com.daniel.TerceiraCamada;


import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTelaResultado implements Initializable {
    @FXML
    private Label labelXP;
    @FXML
    private Label labelPontos;
    @FXML
    private Label labelMoedas;
    @FXML
    private Button btnVoltar;
    int xpInimigo = 5; // uso temporário
    int pontosInimigo = 5; // uso temporário
    int moedasInimigo = 5; // uso temporário
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelXP.setText("" + xpInimigo);
        labelPontos.setText("" + pontosInimigo);
        labelMoedas.setText("" + moedasInimigo);

    }
    @FXML
    void onClickVoltar (ActionEvent event) throws PlayerInexistenteException {
        System.out.println("seu xp e :" + Player.getPlayer().getXp());
        Player.getPlayer().ganharXp(xpInimigo);
        System.out.println("seu xp e :" + Player.getPlayer().getXp());
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
    }

}
