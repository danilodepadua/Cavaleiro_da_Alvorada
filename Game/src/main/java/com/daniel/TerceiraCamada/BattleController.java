package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.GerenciadorDeBatalha;
import com.daniel.PrimeiraCamada.Personagem;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;

public class BattleController implements Initializable {

    GerenciadorDeBatalha gdb;

    private Personagem[] Inimigos = new Personagem[1];
    private Personagem Inimigo;

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
    private ImageView PlayerImg;

    @FXML
    private AnchorPane PnlPrimeirasEscolhas;

    @FXML
    private AnchorPane Screen;

    @FXML
    void Atacar(ActionEvent event) throws PlayerInexistenteException {

    }

    @FXML
    void Fugir(ActionEvent event) throws PlayerInexistenteException {
        Random rand = new Random();
        int i = rand.nextInt(0, 100);
        if(i >= 50-(Player.getPlayer().getVelocity()-Inimigo.getVelocity())){
            Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Random rand = new Random();
        Inimigo = Inimigos[rand.nextInt(0, Inimigos.length)];
        EnimyImg.setImage(Inimigo.getImagem());
        try {
            InfoVida.setText("HP: " + Player.getPlayer().getcHP() + "/" + Player.getPlayer().getHP());
            InfoMp.setText("MP: " + Player.getPlayer() + "/" + Player.getPlayer().getMP());
            InfoNome.setText(Player.getPlayer().getName());
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
}
