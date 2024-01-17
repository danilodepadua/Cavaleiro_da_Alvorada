package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
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

import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.*;

public class CityController implements Initializable {
    @FXML
    private Label LabelForca;

    @FXML
    private Label LabelMP;

    @FXML
    private Label LblDefesa;

    @FXML
    private AnchorPane Screen;

    @FXML
    private Button btnCassino;

    @FXML
    private Button btnInventario;

    @FXML
    private Button btnLoja;

    @FXML
    private Button btnQuests;

    @FXML
    private Button btnViajar;

    @FXML
    private Button btnSalvar;
    @FXML
    private Button btncacar;

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
    void Salvar(ActionEvent event) throws PlayerInexistenteException {
        Main.saveManager.Salvar();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        txtCidade.setText(Main.cidadeAtual.getNome());
        txtCidade.setStroke(Color.BLACK);
        txtCidade.setStrokeWidth(2);

        try {
            System.out.println(Player.getPlayer() != null);
            System.out.println("XP DO PLAYER: "+ Player.getPlayer().getXp());

            // Método chamado automaticamente quando o controlador é inicializado
            txtPontos.setText("" + Player.getPlayer().getPontos());
            txtResistencia.setText(""+ Player.getPlayer().getResistencia());
            labelNome.setText(Player.getPlayer().getName());
            LabelForca.setText("" + Player.getPlayer().getForce());
            LabelMP.setText("" + Player.getPlayer().getMP());
            labelVida.setText("" + Player.getPlayer().getHP());
            lblDefesaMagica.setText("" + Player.getPlayer().getDefesaM());
            lblInteligencia.setText("" + Player.getPlayer().getInteligence());
            LblDefesa.setText("" + Player.getPlayer().getDefesaF());
            lblDinheiro.setText("" + Player.getPlayer().getCoins());
            txtNivel.setText(""+ Player.getPlayer().getLvl());
            txtVelocidade.setText(""+ Player.getPlayer().getVelocity());
        }
        catch (PlayerInexistenteException e){
            throw new RuntimeException(e);
        }
        btnInventario.setOnAction(event->Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInventario.fxml"))));
        btnLoja.setOnAction(event->Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaLoja.fxml"))));
        btncacar.setOnAction(event -> Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBatalha.fxml"))));


        definirBackground(Screen, Main.cidadeAtual.getCaminhoImagem());

        configurarBotoes(btncacar);
        configurarBotoes(btnCassino);
        configurarBotoes(btnLoja);
        configurarBotoes(btnViajar);
        configurarBotoes(btnSalvar);
        configurarBotoes(btnQuests);
        configurarBotoes(btnStatus);
        configurarBotoes(btnInventario);
        configurarBotoes(btnConfig);

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
    void onClickViajar(ActionEvent event) {
    Main.ChangeScene(new FXMLLoader((Main.class.getResource("TelaResultado.fxml")))); // pra testar mais rapidamente
    }
    @FXML
    void onClickCassino(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCassino.fxml")));
    }
    @FXML
    void onClickStatus(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInfosPlayer.fxml")));
    }
    @FXML
    void Config(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaConfiguracoes.fxml")));
    }
    @FXML
    void onClickQuests(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaQuests.fxml")));
    }
}