package com.daniel.TerceiraCamada;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStatus implements Initializable {
    private Integer  pontosDisp;


    @FXML
    private GridPane Grid;

    @FXML
    private Text TxtForce;

    @FXML
    private Text TxtInt;

    @FXML
    private Text TxtRes;

    @FXML
    private Text TxtVel;

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
    private Text txtLevel;

    @FXML
    private Text txtPontos;


    @FXML
    void onClickMaisForca(ActionEvent event) throws PlayerInexistenteException {
        if(pontosDisp>0) {
            pontosDisp--;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("Pontos: "+ pontosDisp);
            progBarForca.setProgress(progBarForca.getProgress() + 0.01);
        }
    }

    @FXML
    void onClickMaisInt(ActionEvent event) throws PlayerInexistenteException {
        if(pontosDisp>0) {
            pontosDisp--;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("Pontos: "+ pontosDisp);
            progBarInt.setProgress(progBarInt.getProgress() + 0.01);
        }
    }

    @FXML
    void onClickMaisRes(ActionEvent event) throws PlayerInexistenteException {
        if(pontosDisp>0) {
            pontosDisp--;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("Pontos: "+ pontosDisp);
            progBarRes.setProgress(progBarRes.getProgress() + 0.01);
        }
    }

    @FXML
    void onClickMaisVel(ActionEvent event) throws PlayerInexistenteException {
        if(pontosDisp>0) {
            pontosDisp--;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("Pontos: "+ pontosDisp);
            progBarVel.setProgress(progBarVel.getProgress() + 0.01);
        }
    }

    @FXML
    void onClickMenosForca(ActionEvent event) throws PlayerInexistenteException {
        if (progBarForca.getProgress() > 0.25 && progBarForca.getProgress() > (Player.getPlayer().getForce() / 100.0)) {
            pontosDisp++;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("Pontos: " + pontosDisp);
            progBarForca.setProgress(progBarForca.getProgress() - 0.01);
        }
    }

    @FXML
    void onClickMenosInt(ActionEvent event) throws PlayerInexistenteException {
        if (progBarInt.getProgress() > 0.25 && progBarInt.getProgress() > (Player.getPlayer().getInteligence() / 100.0)) {
            pontosDisp++;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("Pontos: " + pontosDisp);
            progBarInt.setProgress(progBarInt.getProgress() - 0.01);
        }
    }

    @FXML
    void onClickMenosRes(ActionEvent event) throws PlayerInexistenteException {
        if (progBarRes.getProgress() > 0.25 && progBarRes.getProgress() > (Player.getPlayer().getResistencia() / 100.0)) {
            pontosDisp++;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("Pontos: " + pontosDisp);
            progBarRes.setProgress(progBarRes.getProgress() - 0.01);
        }
    }

    @FXML
    void onClickMenosVel(ActionEvent event) throws PlayerInexistenteException {
        if (progBarVel.getProgress() > 0.25 && progBarVel.getProgress() > (Player.getPlayer().getVelocity() / 100.0)) {
            pontosDisp++;
            Player.getPlayer().setPontos(pontosDisp);
            txtPontos.setText("Pontos: " + pontosDisp);
            progBarVel.setProgress(progBarVel.getProgress() - 0.01);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            configurarOuvinte(progBarForca, TxtForce);
            configurarOuvinte(progBarInt, TxtInt);
            configurarOuvinte(progBarRes, TxtRes);
            configurarOuvinte(progBarVel, TxtVel);

            TxtVel.setText(String.valueOf(calcularValorDaBarra(progBarVel)));
            TxtForce.setText(String.valueOf(calcularValorDaBarra(progBarForca)));
            TxtRes.setText(String.valueOf(calcularValorDaBarra(progBarRes)));
            TxtInt.setText(String.valueOf(calcularValorDaBarra(progBarInt)));

            pontosDisp = Player.getPlayer().getPontos();
            txtPontos.setText("Pontos: "+ pontosDisp);
            txtLevel.setText("Level: "+ Player.getPlayer().getLvl());

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
        System.out.println("Salvo com sucesso");
    }
    @FXML
    void onClickVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInfosPlayer.fxml")));
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
