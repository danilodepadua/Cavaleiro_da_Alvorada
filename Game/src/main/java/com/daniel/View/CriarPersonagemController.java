package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextosInterface;
import com.daniel.Model.Dados.Textos.TextosIntroducao;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
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
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import static com.daniel.View.Utilidades.configurarBotoes;
import static com.daniel.View.Utilidades.definirBackground;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CriarPersonagemController implements Initializable {
    Integer pontosDisp = 10;
    private List<String> images;
    private int indiceAtual;


    @FXML
    private Text Txt_Dica;

    @FXML
    private Text Txt_Foca1;

    @FXML
    private Text Txt_Forca;

    @FXML
    private Text Txt_Int;

    @FXML
    private Text Txt_Int1;

    @FXML
    private Text Txt_Nome;

    @FXML
    private Text Txt_Pontos;

    @FXML
    private Text Txt_Res;

    @FXML
    private Text Txt_Res1;

    @FXML
    private Text Txt_Sorte;

    @FXML
    private Text Txt_Sorte1;

    @FXML
    private Text Txt_Titulo;

    @FXML
    private Text Txt_Vel;

    @FXML
    private Text Txt_Vel1;
    @FXML
    private ProgressBar BarraForca;

    @FXML
    private ProgressBar BarraInt;

    @FXML
    private ProgressBar BarraRes;

    @FXML
    private ProgressBar BarraSorte;

    @FXML
    private ProgressBar BarraVel;

    @FXML
    private TextField Nome;

    @FXML
    private Button btnCriar;

    @FXML
    private Button btnMaisForca;

    @FXML
    private Button btnMaisInt;

    @FXML
    private Button btnMaisRes;

    @FXML
    private Button btnMaisSorte;

    @FXML
    private Button btnMaisVel;

    @FXML
    private Button btnMenosForca;

    @FXML
    private Button btnMenosInt;

    @FXML
    private Button btnMenosRes;

    @FXML
    private Button btnMenosSorte;

    @FXML
    private Button btnMenosVel;

    @FXML
    private Button btnProxSkin;

    @FXML
    private Button btnSkinAnterior;

    @FXML
    private ImageView imgBonecos;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private Text txtForce;

    @FXML
    private Text txtInt;

    @FXML
    private Text txtPontos;

    @FXML
    private Text txtRes;

    @FXML
    private Text txtSorte;

    @FXML
    private Text txtVelocidade;

    private static final String PROGRESS_BAR_COLOR = "-fx-accent:   #ad8a37; ";

    @FXML
    void Criar(ActionEvent event) throws IOException, PlayerInexistenteException {
        String nomeDoJogador = Nome.getText();

        // Configurando as características do jogador
        int forca = calcularValorDaBarra(BarraForca);
        int velocidade = calcularValorDaBarra(BarraVel);
        int res = calcularValorDaBarra(BarraRes);
        int Int = calcularValorDaBarra(BarraInt);
        int sorte = calcularValorDaBarra(BarraSorte);
        Player.CreatePlayer(images.get(indiceAtual), forca, Int, nomeDoJogador, velocidade, res, sorte);
        Main.cidadeAtual = Player.getPlayer().getCidadesConehcidas().getFirst();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void MaisForca(ActionEvent event) {
        if(pontosDisp>0) {
            pontosDisp--;
            txtPontos.setText(pontosDisp.toString());
            BarraForca.setProgress(BarraForca.getProgress() + 0.01);
            atualizarBotao();

        }
    }
    @FXML
    void MaisSorte(ActionEvent event) {
        if(pontosDisp>0) {
            pontosDisp--;
            txtPontos.setText(pontosDisp.toString());
            BarraSorte.setProgress(BarraSorte.getProgress() + 0.01);
            atualizarBotao();
        }
    }
    @FXML
    void MaisVel(ActionEvent event) {
        if(pontosDisp>0) {
            pontosDisp--;
            txtPontos.setText(pontosDisp.toString());
            BarraVel.setProgress(BarraVel.getProgress() + 0.01);
            atualizarBotao();
        }
    }
    @FXML
    void MaisRes(ActionEvent event) {
        if(pontosDisp>0){
        pontosDisp--;
        txtPontos.setText(pontosDisp.toString());
        BarraRes.setProgress(BarraRes.getProgress() + 0.01);
        atualizarBotao();
        }
    }
    @FXML
    void MenosForca(ActionEvent event) {
        if(BarraForca.getProgress() > 0.25) {
            pontosDisp++;
            txtPontos.setText(pontosDisp.toString());
            BarraForca.setProgress(BarraForca.getProgress() - 0.01);
            atualizarBotao();
        }
    }
    @FXML
    void MenosSorte(ActionEvent event) {
        if(BarraSorte.getProgress() > 0.25) {
            pontosDisp++;
            txtPontos.setText(pontosDisp.toString());
            BarraVel.setProgress(BarraSorte.getProgress() - 0.01);
            atualizarBotao();
        }
    }
    @FXML
    void MenosVel(ActionEvent event) {
        if(BarraVel.getProgress() > 0.25) {
            pontosDisp++;
            txtPontos.setText(pontosDisp.toString());
            BarraVel.setProgress(BarraVel.getProgress() - 0.01);
            atualizarBotao();
        }
    }
    @FXML
    void MenosRes(ActionEvent event) {
        if(BarraRes.getProgress() > 0.25) {
            pontosDisp++;
            txtPontos.setText(pontosDisp.toString());
            BarraRes.setProgress(BarraRes.getProgress() - 0.01);
            atualizarBotao();

        }
    }
    @FXML
    void MenosInt(ActionEvent event) {
        if(BarraInt.getProgress() > 0.25) {
            pontosDisp++;
            txtPontos.setText(pontosDisp.toString());
            BarraInt.setProgress(BarraInt.getProgress() - 0.01);
            atualizarBotao();

        }
    }
    @FXML
    void MaisInt(ActionEvent event) {
        if(pontosDisp>0){
            pontosDisp--;
            txtPontos.setText(pontosDisp.toString());
            BarraInt.setProgress(BarraInt.getProgress() + 0.01);
            atualizarBotao();
        }
    }
    private int calcularValorDaBarra(ProgressBar barra) {
        double progresso = barra.getProgress() * 100;
        return (int) Math.round(progresso);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JogoFachada.getInstance().getAudioPlayer().PlayLoop("/com.daniel.audios/msc_criacaodepersonagem.wav");
        btnCriar.setDisable(true);

        Txt_Dica.setText(TextosIntroducao.getDica());
        Txt_Nome.setText(TextosInterface.getNome()+":");
        Txt_Forca.setText(TextosInterface.getForca());
        Txt_Int.setText(TextosInterface.getInteli());
        Txt_Vel.setText(TextosInterface.getVel());
        Txt_Sorte.setText(TextosInterface.getSorte());
        Txt_Res.setText(TextosInterface.getResis());
        Txt_Foca1.setText(TextosInterface.getForca()+":");
        Txt_Int1.setText(TextosInterface.getInteli()+":");
        Txt_Vel1.setText(TextosInterface.getVel()+":");
        Txt_Sorte1.setText(TextosInterface.getSorte()+":");
        Txt_Res1.setText(TextosInterface.getResis()+":");
        Txt_Pontos.setText(TextosInterface.getPontos()+":");
        Txt_Titulo.setText(TextosInterface.getCriarPerso());
        btnCriar.setText(TextosInterface.getCriar());

        BarraForca.setStyle(PROGRESS_BAR_COLOR);
        BarraRes.setStyle(PROGRESS_BAR_COLOR);
        BarraInt.setStyle(PROGRESS_BAR_COLOR);
        BarraVel.setStyle(PROGRESS_BAR_COLOR);
        BarraSorte.setStyle(PROGRESS_BAR_COLOR);

        configurarBotoes(btnCriar);
        configurarBotoes(btnProxSkin);
        configurarBotoes(btnSkinAnterior);
        configurarBotoes(btnMaisForca);
        configurarBotoes(btnMaisInt);
        configurarBotoes(btnMaisRes);
        configurarBotoes(btnMaisVel);
        configurarBotoes(btnMaisSorte);

        configurarBotoes(btnMenosForca);
        configurarBotoes(btnMenosRes);
        configurarBotoes(btnMenosInt);
        configurarBotoes(btnMenosVel);
        configurarBotoes(btnMenosSorte);
        txtPontos.setText(""+pontosDisp);
        definirBackground(panePrincipal, "/com.daniel.Images/Fundos/Castelo.jpg");
        configurarOuvinte(BarraInt, txtInt);
        configurarOuvinte(BarraVel, txtVelocidade);
        configurarOuvinte(BarraRes, txtRes);
        configurarOuvinte(BarraForca, txtForce);
        configurarOuvinte(BarraSorte, txtSorte);

        // Definir os textos iniciais com os valores iniciais das barras
        txtVelocidade.setText(String.valueOf(calcularValorDaBarra(BarraVel)));
        txtForce.setText(String.valueOf(calcularValorDaBarra(BarraForca)));
        txtRes.setText(String.valueOf(calcularValorDaBarra(BarraRes)));
        txtInt.setText(String.valueOf(calcularValorDaBarra(BarraInt)));
        txtSorte.setText(String.valueOf(calcularValorDaBarra(BarraSorte)));

        images = new ArrayList<>();
        images.add("/com.daniel.Images/Personagens/Homi.png");
        images.add("/com.daniel.Images/Personagens/Muie.png");
        atualizarSkin();
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
        imgBonecos.setImage(new Image(Main.class.getResource(images.get(indiceAtual)).toString()));
    }
    private void atualizarBotao(){
        if (pontosDisp == 0 && Nome.getText() != null){
            btnCriar.setDisable(false);
        }
    }

}