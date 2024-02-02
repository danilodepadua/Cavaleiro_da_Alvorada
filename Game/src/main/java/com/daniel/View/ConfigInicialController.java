package com.daniel.View;

import com.daniel.Model.Dados.ConfiguracoesUsuario;
import com.daniel.game.Main;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.MainController.audioPlayerInicial;
import static com.daniel.View.Utilidades.configurarBotoes;
import static com.daniel.View.Utilidades.contornarBotaoVoltar;

public class ConfigInicialController implements Initializable {

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
        int largura = Integer.parseInt(tamanho[0]);
        int altura = Integer.parseInt(tamanho[1]);
        Main.MudarTamanhoTela(largura, altura);
        ConfiguracoesUsuario.salvarAlturaTela(altura);
        ConfiguracoesUsuario.salvarLarguraTela(largura);
        ConfiguracoesUsuario.salvarVolume(SliderVolume.getValue());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EscolhaResolucao.getItems().addAll("1200x675","1280x720");
        configurarBotoes(btnConfirmar);
        contornarBotaoVoltar(btnVoltar);

        SliderVolume.setValue(ConfiguracoesUsuario.obterVolumePadrao()*100);
        SliderVolume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                audioPlayerInicial.getMediaPlayer().setVolume(SliderVolume.getValue()/100);
            }
        });
        EscolhaResolucao.setValue(ConfiguracoesUsuario.obterLarguraTelaPadrao() + "x" + ConfiguracoesUsuario.obterAlturaTelaPadrao());
        configurarBotoes(btnConfirmar);
    }

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("MainScene.fxml")).load());

    }
}
