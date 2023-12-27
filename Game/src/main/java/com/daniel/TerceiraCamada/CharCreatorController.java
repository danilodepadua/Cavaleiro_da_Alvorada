package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerExistenteException;
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
    private ProgressBar BarraDefesa;

    @FXML
    private ProgressBar BarraDefesaMagica;

    @FXML
    private ProgressBar BarraForca;

    @FXML
    private ProgressBar BarraVel;

    @FXML
    private ProgressBar BarraVida;

    @FXML
    private TextField Nome;

    @FXML
    private Text Pontos;

    @FXML
    private Text TxtForce;

    @FXML
    private Text TxtDefesa;

    @FXML
    private Text TxtDefesaMagica;

    @FXML
    private Text TxtVelocidade;

    @FXML
    private Button btnProxSkin;

    @FXML
    private Button btnSkinAnterior;

    @FXML
    private GridPane txtForca;
    @FXML
    private ImageView imgBonecos;

    @FXML
    private Text txtVida;

    @FXML
    void Criar(ActionEvent event) {
        String nomeDoJogador = Nome.getText();
        System.out.println(nomeDoJogador);

        // Configurando as características do jogador
        int forca = calcularValorDaBarra(BarraForca);
        int velocidade = calcularValorDaBarra(BarraVel);
        int vida = calcularValorDaBarra(BarraVida);
        int defesa = calcularValorDaBarra(BarraDefesa);
        int defesaMagica = calcularValorDaBarra(BarraDefesaMagica);

        try {
            Player.player = new Player(vida, 50, forca, 50, nomeDoJogador, defesa, defesaMagica, velocidade);
        } catch (PlayerExistenteException e) {
            e.printStackTrace();
        }
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));

    }
    @FXML
    void MaisForca(ActionEvent event) {
        if(pontosDisp>0) {
            pontosDisp--;
            Pontos.setText(pontosDisp.toString());
            BarraForca.setProgress(BarraForca.getProgress() + 0.05);
        }
    }
    @FXML
    void MaisVel(ActionEvent event) {
        if(pontosDisp>0) {
            pontosDisp--;
            Pontos.setText(pontosDisp.toString());
            BarraVel.setProgress(BarraVel.getProgress() + 0.05);
        }
    }
    @FXML
    void MaisVida(ActionEvent event) {
        if(pontosDisp>0){
        pontosDisp--;
        Pontos.setText(pontosDisp.toString());
        BarraVida.setProgress(BarraVida.getProgress() + 0.05);
        }
    }
    @FXML
    void MenosForca(ActionEvent event) {
        if(BarraForca.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraForca.setProgress(BarraForca.getProgress() - 0.05);
        }
    }
    @FXML
    void MenosVel(ActionEvent event) {
        if(BarraVel.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraVel.setProgress(BarraVel.getProgress() - 0.05);
        }
    }
    @FXML
    void MenosVida(ActionEvent event) {
        if(BarraVida.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraVida.setProgress(BarraVida.getProgress() - 0.05);
        }
    }
    @FXML
    void MenosDEF(ActionEvent event) {
        if(BarraDefesa.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraDefesa.setProgress(BarraDefesa.getProgress() - 0.05);
        }
    }
    @FXML
    void MaisDEF(ActionEvent event) {
        if(pontosDisp>0){
            pontosDisp--;
            Pontos.setText(pontosDisp.toString());
            BarraDefesa.setProgress(BarraDefesa.getProgress() + 0.05);
        }
    }
    @FXML
    void MenosDefMagica(ActionEvent event) {
        if(BarraDefesaMagica.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraDefesaMagica.setProgress(BarraDefesaMagica.getProgress() - 0.05);
        }
    }
    @FXML
    void MaisDefMagica(ActionEvent event) {
        if(pontosDisp>0){
            pontosDisp--;
            Pontos.setText(pontosDisp.toString());
            BarraDefesaMagica.setProgress(BarraDefesaMagica.getProgress() + 0.05);
        }
    }
    private int calcularValorDaBarra(ProgressBar barra) {
        return (int) (barra.getProgress() * 100);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarOuvinte(BarraDefesa, TxtDefesa);
        configurarOuvinte(BarraVel, TxtVelocidade);
        configurarOuvinte(BarraDefesaMagica, TxtDefesaMagica);
        configurarOuvinte(BarraForca, TxtForce);
        configurarOuvinte(BarraVida, txtVida);

        // Definir os textos iniciais com os valores iniciais das barras
        TxtDefesa.setText(String.valueOf(calcularValorDaBarra(BarraDefesa)));
        TxtVelocidade.setText(String.valueOf(calcularValorDaBarra(BarraVel)));
        TxtDefesaMagica.setText(String.valueOf(calcularValorDaBarra(BarraDefesaMagica)));
        TxtForce.setText(String.valueOf(calcularValorDaBarra(BarraForca)));
        txtVida.setText(String.valueOf(calcularValorDaBarra(BarraVida)));

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