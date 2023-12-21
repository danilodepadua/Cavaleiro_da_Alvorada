package com.daniel.ControleInterface;

import com.daniel.Basicos.Player;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.Basicos.Player.player;

public class CityController implements Initializable {
    @FXML
    private Label lblDefesaMagica;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Método chamado automaticamente quando o controlador é inicializado
        labelNome.setText(player.getName());
        LabelForca.setText("" + player.getForce());
        LabelMP.setText(""+ player.getMP());
        labelVida.setText(""+ player.getHP());
        lblDefesaMagica.setText(""+ player.getMagicDef());
        lblInteligencia.setText(""+ player.getIntelligence());
        LblDefesa.setText(""+ player.getDef());
        btnLoja.setOnAction(event->Main.ChangeScene(new FXMLLoader(Main.class.getResource("ControllerInventario.fxml"))));
    }
}