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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultadoController implements Initializable {
    @FXML
    private Label labelXP;
    @FXML
    private Label labelPontos;
    @FXML
    private Label labelMoedas;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnCacar;
    int pontosInimigo; // uso temporário
    int moedasInimigo; // uso temporário
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelXP.setText("" + Main.getXpGanho());
        labelPontos.setText("" + pontosInimigo);
        labelMoedas.setText("" + moedasInimigo);
    }
    @FXML
    void onClickVoltar (ActionEvent event) throws PlayerInexistenteException, IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void onClickCacar (ActionEvent event) throws PlayerInexistenteException, IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBatalha.fxml")).load());
    }

    public int getPontosInimigo() {
        return pontosInimigo;
    }

    public int getMoedasInimigo() {
        return moedasInimigo;
    }

    public void setPontosInimigo(int pontosInimigo) {
        this.pontosInimigo = pontosInimigo;
    }

    public void setMoedasInimigo(int moedasInimigo) {
        this.moedasInimigo = moedasInimigo;
    }
}
