package com.daniel.TerceiraCamada;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.PrimeiraCamada.Entidades.Player.player;

public class CityController implements Initializable {
    @FXML
    private AnchorPane Screen;
    @FXML
    private Label lblDefesaMagica;
    @FXML
    private Label lblDinheiro;

    @FXML
    private Label lblInteligencia;
    @FXML
    private Label LblDefesa;
    @FXML
    private Pane pane1;
    @FXML
    private Button AnimTest;

    @FXML
    private Button btnLoja;

    @FXML
    private Button btnViajar;

    @FXML
    private Button btncacar;
    @FXML
    private Button btnInventario;

    @FXML
    private Label labelNome;

    @FXML
    private Label LabelForca;

    @FXML
    private Label labelVida;

    @FXML
    private Label LabelMP;

    @FXML
    void Mudar(ActionEvent event) {
        System.out.println("O nome do player é "+ player.getName());
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("AnimationsTest.fxml")));
    }
    @FXML
    void Salvar(ActionEvent event){
        Main.saveManager.Salvar();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Método chamado automaticamente quando o controlador é inicializado
        labelNome.setText(player.getName());
        LabelForca.setText("" + player.getForce());
        LabelMP.setText(""+ player.getMP());
        labelVida.setText(""+ player.getHP());
        lblDefesaMagica.setText(""+ player.getMagicDef());
        lblInteligencia.setText(""+ player.getInteligence());
        LblDefesa.setText(""+ player.getDef());
        lblDinheiro.setText(""+ player.getCoins());
        btnInventario.setOnAction(event->Main.ChangeScene(new FXMLLoader(Main.class.getResource("ControllerInventario.fxml"))));
        btnLoja.setOnAction(event->Main.ChangeScene(new FXMLLoader(Main.class.getResource("LojaController.fxml"))));

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
}