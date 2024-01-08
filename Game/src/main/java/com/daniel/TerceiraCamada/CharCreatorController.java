package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CharCreatorController implements Initializable {
    Integer pontosDisp = 10;
    private List<Image> images;
    private int indiceAtual;

    @FXML
    private ProgressBar BarraForca;

    @FXML
    private ProgressBar BarraInt;

    @FXML
    private ProgressBar BarraRes;

    @FXML
    private ProgressBar BarraVel;

    @FXML
    private GridPane Grid;

    @FXML
    private TextField Nome;

    @FXML
    private Text Pontos;

    @FXML
    private Text TxtForce;

    @FXML
    private Text TxtInt;

    @FXML
    private Text TxtRes;

    @FXML
    private Text TxtVel;

    @FXML
    private Button btnProxSkin;

    @FXML
    private Button btnSkinAnterior;

    @FXML
    private ImageView imgBonecos;

    @FXML
    void Criar(ActionEvent event) {
        String nomeDoJogador = Nome.getText();
        System.out.println(nomeDoJogador);

        // Configurando as características do jogador
        int forca = calcularValorDaBarra(BarraForca);
        int velocidade = calcularValorDaBarra(BarraVel);
        int res = calcularValorDaBarra(BarraRes);
        int Int = calcularValorDaBarra(BarraInt);
        Player.CreatePlayer("/com.daniel.Images/Player.png", forca, Int, nomeDoJogador, velocidade, res, 10000, 10);
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));

    }
    @FXML
    void MaisForca(ActionEvent event) {
        if(pontosDisp>0) {
            pontosDisp--;
            Pontos.setText(pontosDisp.toString());
            BarraForca.setProgress(BarraForca.getProgress() + 0.01);
        }
    }
    @FXML
    void MaisVel(ActionEvent event) {
        if(pontosDisp>0) {
            pontosDisp--;
            Pontos.setText(pontosDisp.toString());
            BarraVel.setProgress(BarraVel.getProgress() + 0.01);
        }
    }
    @FXML
    void MaisRes(ActionEvent event) {
        if(pontosDisp>0){
        pontosDisp--;
        Pontos.setText(pontosDisp.toString());
        BarraRes.setProgress(BarraRes.getProgress() + 0.01);
        }
    }
    @FXML
    void MenosForca(ActionEvent event) {
        if(BarraForca.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraForca.setProgress(BarraForca.getProgress() - 0.01);
        }
    }
    @FXML
    void MenosVel(ActionEvent event) {
        if(BarraVel.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraVel.setProgress(BarraVel.getProgress() - 0.01);
        }
    }
    @FXML
    void MenosRes(ActionEvent event) {
        if(BarraRes.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraRes.setProgress(BarraRes.getProgress() - 0.01);
        }
    }
    @FXML
    void MenosInt(ActionEvent event) {
        if(BarraInt.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraInt.setProgress(BarraInt.getProgress() - 0.01);
        }
    }
    @FXML
    void MaisInt(ActionEvent event) {
        if(pontosDisp>0){
            pontosDisp--;
            Pontos.setText(pontosDisp.toString());
            BarraInt.setProgress(BarraInt.getProgress() + 0.01);
        }
    }
    private int calcularValorDaBarra(ProgressBar barra) {
        double progresso = barra.getProgress() * 100;
        return (int) Math.round(progresso);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarOuvinte(BarraInt, TxtInt);
        configurarOuvinte(BarraVel, TxtVel);
        configurarOuvinte(BarraRes, TxtRes);
        configurarOuvinte(BarraForca, TxtForce);

        // Definir os textos iniciais com os valores iniciais das barras
        TxtVel.setText(String.valueOf(calcularValorDaBarra(BarraVel)));
        TxtForce.setText(String.valueOf(calcularValorDaBarra(BarraForca)));
        TxtRes.setText(String.valueOf(calcularValorDaBarra(BarraRes)));
        TxtInt.setText(String.valueOf(calcularValorDaBarra(BarraInt)));

        images = new ArrayList<>();
        images.add(new Image(Main.class.getResource("/com.daniel.Images/Player2.png").toString()));
        images.add(new Image(Main.class.getResource("/com.daniel.Images/Player.png").toString()));
    }
    private void configurarOuvinte(ProgressBar barra, Text texto) {
        barra.progressProperty().addListener((observable, oldValue, newValue) -> {
            int valorInteiro = (int) (newValue.doubleValue() * 100);
            texto.setText(String.valueOf(valorInteiro));
        });
    }
    @FXML
    void onClickAvancar(ActionEvent event) {
        // Lógica para avançar
        indiceAtual = (indiceAtual + 1) % images.size(); // Avança para a próxima skin
        atualizarSkin();
    }
    @FXML
    void onClickVoltar(ActionEvent event) {
        // Lógica para voltar
        indiceAtual = (indiceAtual - 1 + images.size()) % images.size(); // Volta para a skin anterior
        atualizarSkin();
    }
    private void atualizarSkin() {
        imgBonecos.setImage(images.get(indiceAtual));
    }
}