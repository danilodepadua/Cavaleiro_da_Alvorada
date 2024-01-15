package com.daniel.TerceiraCamada;

import com.daniel.SegundaCamada.ConfiguracoesUsuario;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerConfig implements Initializable {

    @FXML
    private ChoiceBox<String> EscolhaResolucao;
    @FXML
    private Slider SliderVolume;
    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnVoltar;

    @FXML
    void Confirmar(ActionEvent event) {
        String[] tamanho = EscolhaResolucao.getValue().split("x");
        System.out.println("Largura = " + tamanho[0]);
        System.out.println("Altura = " + tamanho[1]);
        int largura = Integer.parseInt(tamanho[0]);
        int altura = Integer.parseInt(tamanho[1]);
        Main.MudarTamanhoTela(largura, altura);
        ConfiguracoesUsuario.salvarAlturaTela(altura);
        ConfiguracoesUsuario.salvarLarguraTela(largura);
        ConfiguracoesUsuario.salvarVolume(SliderVolume.getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EscolhaResolucao.getItems().addAll("1200x675","1280x720");
        SliderVolume.setValue(ConfiguracoesUsuario.obterVolumePadrao());
        EscolhaResolucao.setValue(ConfiguracoesUsuario.obterLarguraTelaPadrao() + "x" + ConfiguracoesUsuario.obterAlturaTelaPadrao());
        configurarBotoes(btnConfirmar);
        contornarBotaoVoltar();
    }
    @FXML
    void Voltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
    }
    private void contornarBotaoVoltar() {
        btnVoltar.setOnMouseEntered(event -> {
            btnVoltar.setStyle("-fx-background-color: transparent; -fx-background-radius: 100; -fx-border-color:  #eccb7e;");
        });

        btnVoltar.setOnMouseExited(event -> {
            btnVoltar.setStyle("-fx-background-color: transparent; -fx-background-radius: 100; -fx-border-color: transparent;");
        });

        btnVoltar.setOnMousePressed(event -> {
            btnVoltar.setStyle("-fx-background-color: transparent; -fx-background-radius: 100; -fx-border-color:  #eccb7e; -fx-opacity: 0.7;");
        });

        btnVoltar.setOnMouseReleased(event -> {
            btnVoltar.setStyle("-fx-background-color: transparent; -fx-background-radius: 100; -fx-border-color: transparent;");
        });
    }
    private void configurarBotoes(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color:   #241811; -fx-border-color: #ADD8E6;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e;");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e; -fx-opacity: 0.7;");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e;");
        });

    }
}

