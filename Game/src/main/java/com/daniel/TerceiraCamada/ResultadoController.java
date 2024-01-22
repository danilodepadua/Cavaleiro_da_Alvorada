package com.daniel.TerceiraCamada;


import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.*;

public class ResultadoController implements Initializable {
    @FXML
    private Label labelXP;
    @FXML
    private Label labelMoedas;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnCacar;
    @FXML
    private AnchorPane Screen;

    static int moedasInimigo; // uso temporário
    static int xpInimigo;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelXP.setText("" + getXpinimigo());
        labelMoedas.setText("" + getMoedasInimigo());

        definirBackground(Screen, "/com.daniel.Images/Fundos/FundoSalaDeTesouro.jpg");
        estiloBotao(btnCacar);
        estiloBotao(btnVoltar);
        configurarBotoesTelaResultado(btnCacar);
        configurarBotoesTelaResultado(btnVoltar);
    }
    @FXML
    void onClickVoltar (ActionEvent event) throws PlayerInexistenteException, IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void onClickCacar (ActionEvent event) throws PlayerInexistenteException, IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBatalha.fxml")).load());
    }


    public int getMoedasInimigo() {
        return moedasInimigo;
    }


    public static void setMoedasInimigo(int moedasInimigo) {
        ResultadoController.moedasInimigo = moedasInimigo;
    }

    public int getXpinimigo() {return xpInimigo;}
    public static void setXpInimigo(int xpInimigo) {ResultadoController.xpInimigo = xpInimigo;}


}
