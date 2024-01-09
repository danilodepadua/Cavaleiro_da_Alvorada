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
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CityController implements Initializable {
    @FXML
    private Button AnimTest;

    @FXML
    private Label LabelForca;

    @FXML
    private Label LabelMP;

    @FXML
    private Label LblDefesa;

    @FXML
    private AnchorPane Screen;

    @FXML
    private Button btnCassino;

    @FXML
    private Button btnInventario;

    @FXML
    private Button btnLoja;

    @FXML
    private Button btnViajar;

    @FXML
    private Button btncacar;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelVida;

    @FXML
    private Label lblDefesaMagica;

    @FXML
    private Label lblDinheiro;

    @FXML
    private Label lblInteligencia;

    @FXML
    private Pane pane1;

    @FXML
    private Text txtPontos;

    @FXML
    private Text txtResistencia;
    @FXML
    private Text txtVelocidade;
    @FXML
    private Text txtNivel;

    @FXML
    void Mudar(ActionEvent event) throws PlayerInexistenteException {
        System.out.println("O nome do player é "+ Player.getPlayer().getName());
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("AnimationsTest.fxml")));
    }
    @FXML
    void Salvar(ActionEvent event) throws PlayerInexistenteException {
        Main.saveManager.Salvar();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("1");
        try {
            System.out.println("2");
            System.out.println(Player.getPlayer() != null);
            // Método chamado automaticamente quando o controlador é inicializado
            txtPontos.setText("" + Player.getPlayer().getPontos());
            txtResistencia.setText(""+ Player.getPlayer().getResistencia());
            labelNome.setText(Player.getPlayer().getName());
            LabelForca.setText("" + Player.getPlayer().getForce());
            LabelMP.setText("" + Player.getPlayer().getMP());
            labelVida.setText("" + Player.getPlayer().getHP());
            lblDefesaMagica.setText("" + Player.getPlayer().getDefesaM());
            lblInteligencia.setText("" + Player.getPlayer().getInteligence());
            LblDefesa.setText("" + Player.getPlayer().getDefesaF());
            lblDinheiro.setText("" + Player.getPlayer().getCoins());
            txtNivel.setText(""+ Player.getPlayer().getLvl());
            txtVelocidade.setText(""+ Player.getPlayer().getVelocity());
        }
        catch (PlayerInexistenteException e){
            throw new RuntimeException(e);
        }
        btnInventario.setOnAction(event->Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInventario.fxml"))));
        btnLoja.setOnAction(event->Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaLoja.fxml"))));
        btncacar.setOnAction(event -> Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBatalha.fxml"))));


        Screen.setBackground(new Background(new BackgroundImage(Main.cidadeAtual.getFundo(),
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
    }
    @FXML
    void onClickCassino(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("ControllerCassino.fxml")));

    }

    @FXML
    void onClickStatus(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaStatus.fxml")));

    }

    @FXML
    void Config(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaConfiguracoes.fxml")));

    }
}