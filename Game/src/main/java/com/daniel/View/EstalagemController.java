package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.RemoverCoinsException;
import com.daniel.game.Main;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.*;

public class EstalagemController implements Initializable {
    private final JogoFachada jogoFachada = JogoFachada.getInstance();
    @FXML
    private Button btnDescanso;

    @FXML
    private Button btnRestaurar;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnTaverna;

    @FXML
    private Button btnVoltar;

    @FXML
    private AnchorPane paneInfos;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private Text txtMana;

    @FXML
    private Text txtRestaurar;

    @FXML
    private Text txtVida;

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());

    }

    @FXML
    void onActionRestaurar(ActionEvent event) throws PlayerInexistenteException, RemoverCoinsException {
        Player.getPlayer().RecuperarMana(Player.getPlayer().getMP());
        Player.getPlayer().RecuperarVida(Player.getPlayer().getHP());
        Player.getPlayer().removerCoins(50);
        txtVida.setText(""+Player.getPlayer().getcHP() + " /"+ Player.getPlayer().getHP());
        txtMana.setText(""+Player.getPlayer().getcMp() + " /"+ Player.getPlayer().getMP());
    }
    @FXML
    void onActionDescanso(ActionEvent event) throws PlayerInexistenteException {
        // Cria um retângulo para cobrir toda a tela
        Rectangle overlay = new Rectangle(panePrincipal.getWidth(), panePrincipal.getHeight(), Color.rgb(0, 0, 0, 0.5));
        panePrincipal.getChildren().add(overlay);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), overlay);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);

        // Configura a ação a ser executada quando a transição terminar
        fadeTransition.setOnFinished(e -> {
            paneInfos.setVisible(true);
            paneInfos.setDisable(false);
            btnRestaurar.setDisable(false);
            btnRestaurar.setVisible(true);
            try {
                txtVida.setText(""+Player.getPlayer().getcHP() + " /"+ Player.getPlayer().getHP());
                txtMana.setText(""+Player.getPlayer().getcMp() + " /"+ Player.getPlayer().getMP());

            } catch (PlayerInexistenteException ex) {
                throw new RuntimeException(ex);
            }
            txtRestaurar.setText(Integer.toString(50));

            FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(0.5), overlay);
            fadeOutTransition.setFromValue(1.0); // Opacidade inicial
            fadeOutTransition.setToValue(0.0);   // Opacidade final

            // Configura a ação a ser executada quando a transição de clareamento terminar
            fadeOutTransition.setOnFinished(e2 -> {
                // Remova o retângulo da cena
                panePrincipal.getChildren().remove(overlay);
            });

            // Inicia a transição de clareamento
            fadeOutTransition.play();
        });

        // Inicia a transição de escurecimento
        fadeTransition.play();
    }

    @FXML
    void onActionTaverna(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCassino.fxml")).load());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        definirBackground(panePrincipal, "/com.daniel.Images/Fundos/FundoEstalagem.jpg");
        configurarBotoes(btnDescanso);
        configurarBotoes(btnTaverna);
        configurarBotoes(btnRestaurar);
        contornarBotaoVoltar(btnVoltar);
        contornarBotaoVoltar(btnSair);

    }
    @FXML
    void onClickFechar(ActionEvent event) {
        paneInfos.setVisible(false);
        paneInfos.setDisable(true);
        btnRestaurar.setDisable(true);
        btnRestaurar.setVisible(false);
    }

}
