package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.BattleController.controladorMusica;
import static com.daniel.View.Utilidades.*;

public class CidadeController implements Initializable {
    @FXML
    private Label LabelForca;

    @FXML
    private Label LabelMP;

    @FXML
    private Label LblDefesa;

    @FXML
    private AnchorPane Screen;

    @FXML
    private Button btnCraft;

    @FXML
    private Button btnInventario;


    @FXML
    private Button btnStatus;

    @FXML
    private Button btnConfig;

    @FXML
    private ImageView imgDefesaFisica;

    @FXML
    private ImageView imgDefesaMagica;

    @FXML
    private ImageView imgForca;

    @FXML
    private ImageView imgInteligencia;

    @FXML
    private ImageView imgMana;

    @FXML
    private ImageView imgMoeda;

    @FXML
    private ImageView imgResistencia;

    @FXML
    private ImageView imgVelocidade;

    @FXML
    private ImageView imgVida;

    @FXML
    private Label infoCoin;

    @FXML
    private Label infoDefesa;

    @FXML
    private Label infoDefesaMagica;

    @FXML
    private Label infoForca;

    @FXML
    private Label infoInteligencia;

    @FXML
    private Label infoMana;

    @FXML
    private Label infoResistencia;

    @FXML
    private Label infoVelo;

    @FXML
    private Label infoVida;

    @FXML
    private Label labelNome;

    @FXML
    private VBox VBox;
    @FXML
    private Label labelVida;

    @FXML
    private Label lblDefesaMagica;

    @FXML
    private Label lblDinheiro;

    @FXML
    private Label lblInteligencia;

    @FXML
    private Pane pane1;

    @FXML
    private Text txtNivel;

    @FXML
    private Text txtPontos;

    @FXML
    private Text txtResistencia;

    @FXML
    private Text txtVelocidade;

    @FXML
    private HBox vboxBotoes;
    @FXML
    private Text txtCidade;

    @FXML
    void onActionInventario(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaEstalagem.fxml")).load());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        identificarTextos(Screen);
        controladorMusica = new AudioPlayer();
        if(Main.cidadeAtual.getMusicPath() != null){
            JogoFachada.getInstance().getAudioPlayer().PlayLoop(Main.cidadeAtual.getMusicPath());
        }

        for(int i = 0; i<Main.cidadeAtual.getBotoes().size();i++){
            Button b = new Button();

            int finalI = i;
            b.setText(Main.cidadeAtual.getBotaoNome(finalI));
            b.setOnAction(event -> Main.cidadeAtual.getBotaoFunc(finalI).run());
            b.setFont(loadFont());

            configurarBotoesTelaCidade(b);
            estiloBotao(b);

//            if (!b.getText().equals("Salvar") && !b.getText().equals("Quest")){
//                b.setOnMousePressed(event -> {
//                    audioPlayer.stop();
//                });
//            }

            VBox.getChildren().add(b);
        }
        txtCidade.setText(Main.cidadeAtual.getNome());
        txtCidade.setStroke(Color.BLACK);
        txtCidade.setStrokeWidth(2);

        try {
            txtPontos.setText("" + Player.getPlayer().getPontos());
            txtResistencia.setText(""+ Player.getPlayer().getResistencia());
            labelNome.setText(Player.getPlayer().getNome());
            LabelForca.setText("" + Player.getPlayer().getForca());
            LabelMP.setText("" + Player.getPlayer().getMP());
            labelVida.setText("" + Player.getPlayer().getHP());
            lblDefesaMagica.setText("" + Player.getPlayer().getDefesaM());
            lblInteligencia.setText("" + Player.getPlayer().getInteligencia());
            LblDefesa.setText("" + Player.getPlayer().getDefesaF());
            lblDinheiro.setText("" + Player.getPlayer().getCoins());
            txtNivel.setText(""+ Player.getPlayer().getLvl());
            txtVelocidade.setText(""+ Player.getPlayer().getVelocidade());
        }
        catch (PlayerInexistenteException e){
            throw new RuntimeException(e);
        }


        definirBackground(Screen, Main.cidadeAtual.getCaminhoImagem());
        configurarBotoes(btnStatus);
        configurarBotoes(btnInventario);
        configurarBotoes(btnConfig);
        configurarBotoes(btnCraft);
        // Configurar os estilos para os Labels de informações
        configurarEstiloLabel(infoCoin, infoResistencia, infoForca, infoDefesa, infoMana, infoVelo, infoVida, infoInteligencia, infoDefesaMagica);

        // Configurar os eventos para as ImageViews
        configurarEventoMouseEntered(imgVida, infoVida, "Informação sobre o HP");
        configurarEventoMouseEntered(imgDefesaFisica, infoDefesa, "Informação sobre a defesa física");
        configurarEventoMouseEntered(imgForca, infoForca, "Informação sobre a força");
        configurarEventoMouseEntered(imgInteligencia, infoInteligencia, "Informações sobre a Inteligência");
        configurarEventoMouseEntered(imgMana, infoMana, "Informações sobre a Mana");
        configurarEventoMouseEntered(imgMoeda, infoCoin, "Informações sobre as Moedas");
        configurarEventoMouseEntered(imgResistencia, infoResistencia, "Informações sobre a Resistência");
        configurarEventoMouseEntered(imgVelocidade, infoVelo, "Informações sobre a Velocidade");
        configurarEventoMouseEntered(imgDefesaMagica, infoDefesaMagica, "Informações sobre a defesa mágica");

        // Configurar os eventos para esconder os Labels de informações ao sair das ImageViews
        configurarEventoMouseExited(imgVida, infoVida);
        configurarEventoMouseExited(imgDefesaFisica, infoDefesa);
        configurarEventoMouseExited(imgForca, infoForca);
        configurarEventoMouseExited(imgInteligencia, infoInteligencia);
        configurarEventoMouseExited(imgMana, infoMana);
        configurarEventoMouseExited(imgMoeda, infoCoin);
        configurarEventoMouseExited(imgResistencia, infoResistencia);
        configurarEventoMouseExited(imgVelocidade, infoVelo);
        configurarEventoMouseExited(imgDefesaMagica, infoDefesaMagica);
    }

    @FXML
    void onClickStatus(ActionEvent event) throws IOException {
        //audioPlayer.stop();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaLoad.fxml")).load());
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInfosPlayer.fxml")).load());
    }
    @FXML
    void Config(ActionEvent event) throws IOException {
        //audioPlayer.stop();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaConfiguracoes.fxml")).load());
    }
    @FXML
    void Craft(ActionEvent event) throws IOException {
        //audioPlayer.stop();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCraft.fxml")).load());

    }
}