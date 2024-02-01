package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.AudioPlayer;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javax.sound.sampled.AudioInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.*;

public class CompraOuVendaController implements Initializable {

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnVender;

    @FXML
    private Button btnVoltar;

    @FXML
    private AnchorPane panePrincipal;
    private AudioPlayer audioPlayer = new AudioPlayer();

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        audioPlayer.stop();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }

    @FXML
    void onActionComprar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("TelaLoja.fxml"));
        AnchorPane telaLoja = loader.load();  // Carrega o FXML
        LojaController lojaController = loader.getController();  // Obtém o controlador após carregar o FXML
        lojaController.setAtivado(true);
        Main.ChangeScene(telaLoja);
    }


    @FXML
    void onActionVender(ActionEvent event) throws IOException, PlayerInexistenteException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("TelaLoja.fxml"));
        AnchorPane telaLoja = loader.load();  // Carrega o FXML
        LojaController lojaController = loader.getController();  // Obtém o controlador após carregar o FXML
        lojaController.setAtivarVenda(true);
        Main.ChangeScene(telaLoja);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        audioPlayer.play("/com.daniel.audios/msc_loja.wav", true);
        definirBackground(panePrincipal, "/com.daniel.Images/Fundos/FundoLoja.jpg");
        contornarBotaoVoltar(btnVoltar);
        configurarBotoes(btnComprar);
        configurarBotoes(btnVender);
    }
}
