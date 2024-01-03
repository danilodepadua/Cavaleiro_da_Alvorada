package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCassino implements Initializable {
    @FXML
    private Button btnBlackJack;

    @FXML
    private Text txtMoedas;
    @FXML
    private Button btnVoltar;
    @FXML
    void Jogar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("BlackJack.fxml")));

    }

    @FXML
    void Voltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            txtMoedas.setText(""+ Player.getPlayer().getCoins());
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }

    }

}
