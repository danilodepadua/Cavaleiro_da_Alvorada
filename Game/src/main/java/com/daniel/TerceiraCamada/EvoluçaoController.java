package com.daniel.TerceiraCamada;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.*;

public class EvoluçaoController implements Initializable {
    private Integer  pontosDisp;
    @FXML
    private AnchorPane panePrincipal;
    @FXML
    private Button btnMaisForca;

    @FXML
    private Button btnMaisInt;

    @FXML
    private Button btnMaisRes;

    @FXML
    private Button btnMaisVel;

    @FXML
    private Button btnMenosForce;

    @FXML
    private Button btnMenosInt;

    @FXML
    private Button btnMenosRes;

    @FXML
    private Button btnMenosVel;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    @FXML
    private ProgressBar progBarForca;

    @FXML
    private ProgressBar progBarInt;

    @FXML
    private ProgressBar progBarRes;

    @FXML
    private ProgressBar progBarVel;

    @FXML
    private Text txtForce;

    @FXML
    private Text txtInt;

    @FXML
    private Text txtLevel;

    @FXML
    private Text txtPontos;

    @FXML
    private Text txtRes;

    @FXML
    private Text txtVelocidade;

    private static final String PROGRESS_BAR_COLOR = "-fx-accent:   #ad8a37; ";

    @FXML
    void onClickMaisForca(ActionEvent event) throws PlayerInexistenteException {
        if(pontosDisp>0) {
            pontosDisp--;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText(""+ pontosDisp);
            progBarForca.setProgress(progBarForca.getProgress() + 0.01);
        }
    }

    @FXML
    void onClickMaisInt(ActionEvent event) throws PlayerInexistenteException {
        if(pontosDisp>0) {
            pontosDisp--;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText(""+ pontosDisp);
            progBarInt.setProgress(progBarInt.getProgress() + 0.01);
        }
    }

    @FXML
    void onClickMaisRes(ActionEvent event) throws PlayerInexistenteException {
        if(pontosDisp>0) {
            pontosDisp--;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText(""+ pontosDisp);
            progBarRes.setProgress(progBarRes.getProgress() + 0.01);
        }
    }

    @FXML
    void onClickMaisVel(ActionEvent event) throws PlayerInexistenteException {
        if(pontosDisp>0) {
            pontosDisp--;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText(""+ pontosDisp);
            progBarVel.setProgress(progBarVel.getProgress() + 0.01);
        }
    }

    @FXML
    void onClickMenosForca(ActionEvent event) throws PlayerInexistenteException {
        if (progBarForca.getProgress() > 0.25 && progBarForca.getProgress() > (Player.getPlayer().getForce() / 100.0)) {
            pontosDisp++;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("" + pontosDisp);
            progBarForca.setProgress(progBarForca.getProgress() - 0.01);
        }
    }

    @FXML
    void onClickMenosInt(ActionEvent event) throws PlayerInexistenteException {
        if (progBarInt.getProgress() > 0.25 && progBarInt.getProgress() > (Player.getPlayer().getInteligence() / 100.0)) {
            pontosDisp++;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("" + pontosDisp);
            progBarInt.setProgress(progBarInt.getProgress() - 0.01);
        }
    }

    @FXML
    void onClickMenosRes(ActionEvent event) throws PlayerInexistenteException {
        if (progBarRes.getProgress() > 0.25 && progBarRes.getProgress() > (Player.getPlayer().getResistencia() / 100.0)) {
            pontosDisp++;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("" + pontosDisp);
            progBarRes.setProgress(progBarRes.getProgress() - 0.01);

        }
    }

    @FXML
    void onClickMenosVel(ActionEvent event) throws PlayerInexistenteException {
        if (progBarVel.getProgress() > 0.25 && progBarVel.getProgress() > (Player.getPlayer().getVelocity() / 100.0)) {
            pontosDisp++;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("" + pontosDisp);
            progBarVel.setProgress(progBarVel.getProgress() - 0.01);

        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            definirBackground(panePrincipal, "/com.daniel.Images/Fundos/Castelo.jpg");
            contornarBotaoVoltar(btnVoltar);
            configurarBotoes(btnSalvar);
            configurarBotoes(btnMaisForca);
            configurarBotoes(btnMaisInt);
            configurarBotoes(btnMaisRes);
            configurarBotoes(btnMaisVel);

            configurarBotoes(btnMenosForce);
            configurarBotoes(btnMenosRes);
            configurarBotoes(btnMenosInt);
            configurarBotoes(btnMenosVel);

            progBarInt.setStyle(PROGRESS_BAR_COLOR);
            progBarRes.setStyle(PROGRESS_BAR_COLOR);
            progBarVel.setStyle(PROGRESS_BAR_COLOR);
            progBarForca.setStyle(PROGRESS_BAR_COLOR);

            btnSalvar.setAlignment(Pos.CENTER);
            configurarOuvinte(progBarForca, txtForce);
            configurarOuvinte(progBarInt, txtInt);
            configurarOuvinte(progBarRes, txtRes);
            configurarOuvinte(progBarVel, txtVelocidade);

            txtVelocidade.setText(""+calcularValorDaBarra(progBarVel));
            txtForce.setText(""+calcularValorDaBarra(progBarForca));
            txtRes.setText(""+ calcularValorDaBarra(progBarRes));
            txtInt.setText(""+calcularValorDaBarra(progBarInt));

            pontosDisp = Player.getPlayer().getPontos();
            txtPontos.setText(""+ pontosDisp);
            txtLevel.setText(""+ Player.getPlayer().getLvl());

            progBarForca.setProgress(Player.getPlayer().getForce()/100.0);
            progBarInt.setProgress(Player.getPlayer().getInteligence()/100.0);
            progBarRes.setProgress(Player.getPlayer().getResistencia()/100.0);
            progBarVel.setProgress(Player.getPlayer().getVelocity()/100.0);

        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onClickSalvar(ActionEvent event) throws PlayerInexistenteException {
        int forca = calcularValorDaBarra(progBarForca);
        int velocidade = calcularValorDaBarra(progBarVel);
        int res = calcularValorDaBarra(progBarRes);
        int inteligencia = calcularValorDaBarra(progBarInt);

        Player.getPlayer().aumentaForcaProgress(forca);
        Player.getPlayer().aumentaInteligenciaProgess(inteligencia);
        Player.getPlayer().aumentaResistenciaProgress(res);
        Player.getPlayer().aumentaVelocidadeProgress(velocidade);

        Player.getPlayer().setPontos(pontosDisp);
    }
    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInfosPlayer.fxml")).load());
    }
    private void configurarOuvinte(ProgressBar barra, Text texto) {
        barra.progressProperty().addListener((observable, oldValue, newValue) -> {
            int valorInteiro = (int) (newValue.doubleValue() * 100);
            texto.setText(String.valueOf(valorInteiro));
        });
    }
    private int calcularValorDaBarra(ProgressBar barra) {
        double progresso = barra.getProgress() * 100;
        return (int) Math.round(progresso);
    }

}
