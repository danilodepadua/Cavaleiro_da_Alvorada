package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Cidades.Dasópoles;
import com.daniel.PrimeiraCamada.Cidades.Ilha;
import com.daniel.PrimeiraCamada.Cidades.MonteClaro;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Exceptions.SenhaIncorretaException;
import com.daniel.SegundaCamada.ConfiguracoesUsuario;
import com.daniel.game.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    private Button btnAdmin;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnVoltar;

    @FXML
    private AnchorPane paneAdmin;

    @FXML
    private TextField txtTextfield;

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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EscolhaResolucao.getItems().addAll("1200x675","1280x720");
        configurarBotoes(btnAdmin);
        configurarBotoes(btnConfirmar);
        contornarBotaoVoltar(btnSair);

        // Configurar o Slider de Volume
        SliderVolume.setValue(ConfiguracoesUsuario.obterVolumePadrao());
        SliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // Alterar o volume conforme o valor do Slider
                Main.audioPlayer.configVolume(newValue.doubleValue());
            }
        });
        EscolhaResolucao.setValue(ConfiguracoesUsuario.obterLarguraTelaPadrao() + "x" + ConfiguracoesUsuario.obterAlturaTelaPadrao());
        configurarBotoes(btnConfirmar);
        contornarBotaoVoltar(btnVoltar);
    }
    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void Admin(ActionEvent event) throws PlayerInexistenteException {
        paneAdmin.setOpacity(1);
        paneAdmin.setDisable(false);
    }


    @FXML
    void onClickConfirmar(ActionEvent event) throws PlayerInexistenteException, SenhaIncorretaException {
        String senha = "santiago";
        if (txtTextfield.getText().equals(senha)){
                Player.getPlayer().ganhaCoins(10000);
                Player.getPlayer().adicionarCidade(new Ilha());
                Player.getPlayer().adicionarCidade(new Dasópoles());
                Player.getPlayer().adicionarCidade(new MonteClaro());
                Player.getPlayer().ganharXp(100000);
                Player.getPlayer().aumentaForcaProgress(999);
                Player.getPlayer().aumentaVelocidadeProgress(999);
                Player.getPlayer().aumentaResistenciaProgress(999);
                Player.getPlayer().aumentaInteligenciaProgess(999);
                paneAdmin.setOpacity(0);
                paneAdmin.setDisable(true);
        }else {
            throw new SenhaIncorretaException();
        }
    }

    @FXML
    void onClickSair(ActionEvent event) {
        paneAdmin.setOpacity(0);
        paneAdmin.setDisable(true);
    }
}

