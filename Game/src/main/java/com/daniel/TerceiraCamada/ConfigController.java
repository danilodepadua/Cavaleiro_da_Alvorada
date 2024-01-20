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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.configurarBotoes;
import static com.daniel.TerceiraCamada.Utilidades.contornarBotaoVoltar;

public class ConfigController implements Initializable {

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
        contornarBotaoVoltar(btnVoltar);
    }
    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }

}

