package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CityController implements Initializable {
    private Button lastClicked;


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
    void Salvar(ActionEvent event) throws PlayerInexistenteException {
        Main.saveManager.Salvar();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("1");
        try {
            System.out.println("2");
            System.out.println(Player.getPlayer() != null);
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
            String nomeFonte = txtVelocidade.getFont().getFamily();
            System.out.println("Nome da Fonte: " + nomeFonte);

        }
        catch (PlayerInexistenteException e){
            throw new RuntimeException(e);
        }
        btnInventario.setOnAction(event->Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInventario.fxml"))));
        btnLoja.setOnAction(event->Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaLoja.fxml"))));
        btncacar.setOnAction(event -> Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBatalha.fxml"))));


        Screen.setBackground(new Background(new BackgroundImage(Main.cidadeAtual.getFundo(),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        true
                ))));

        btncacar.setOnMouseClicked(event -> {
            desmarcarUltimoClicado();
            destacarBotao(btncacar);
        });
        btncacar.setOnMousePressed(event -> {
            escurecerCor(btncacar);
        });

        btncacar.setOnMouseReleased(event -> {
            restaurarCor(btncacar);
            desmarcarUltimoClicado();
            destacarBotao(btncacar);
        });

        btnCassino.setOnMouseClicked(event -> {
            desmarcarUltimoClicado();
            destacarBotao(btnCassino);
        });
        btnCassino.setOnMousePressed(event -> {
            escurecerCor(btnCassino);
        });

        btnCassino.setOnMouseReleased(event -> {
            restaurarCor(btnCassino);
            desmarcarUltimoClicado();
            destacarBotao(btnCassino);
        });

        btnLoja.setOnMouseClicked(event -> {
            desmarcarUltimoClicado();
            destacarBotao(btnLoja);
        });
        btnLoja.setOnMousePressed(event -> {
            escurecerCor(btnLoja);
        });

        btnLoja.setOnMouseReleased(event -> {
            restaurarCor(btnLoja);
            desmarcarUltimoClicado();
            destacarBotao(btnLoja);
        });

        btnViajar.setOnMouseClicked(event -> {
            desmarcarUltimoClicado();
            destacarBotao(btnViajar);
        });
        btnViajar.setOnMousePressed(event -> {
            escurecerCor(btnViajar);
        });

        btnViajar.setOnMouseReleased(event -> {
            restaurarCor(btnViajar);
            desmarcarUltimoClicado();
            destacarBotao(btnViajar);
        });

        // Inicializar o Label de informações
        infoCoin.setVisible(false);
        infoDefesa.setVisible(false);
        infoForca.setVisible(false);
        infoDefesaMagica.setVisible(false);
        infoMana.setVisible(false);
        infoVelo.setVisible(false);
        infoVida.setVisible(false);
        infoInteligencia.setVisible(false);
        infoResistencia.setVisible(false);

        infoCoin.setBackground(new Background(new BackgroundFill(Color.web("#081936"), new CornerRadii(5), Insets.EMPTY)));
        infoCoin.setPadding(new Insets(5));

        infoResistencia.setBackground(new Background(new BackgroundFill(Color.web("#081936"), new CornerRadii(5), Insets.EMPTY)));
        infoResistencia.setPadding(new Insets(5));

        infoInteligencia.setBackground(new Background(new BackgroundFill(Color.web("#081936"), new CornerRadii(5), Insets.EMPTY)));
        infoInteligencia.setPadding(new Insets(5));

        infoVelo.setBackground(new Background(new BackgroundFill(Color.web("#081936"), new CornerRadii(5), Insets.EMPTY)));
        infoVelo.setPadding(new Insets(5));

        infoForca.setBackground(new Background(new BackgroundFill(Color.web("#081936"), new CornerRadii(5), Insets.EMPTY)));
        infoForca.setPadding(new Insets(5));

        infoDefesaMagica.setBackground(new Background(new BackgroundFill(Color.web("#081936"), new CornerRadii(5), Insets.EMPTY)));
        infoDefesaMagica.setPadding(new Insets(5));

        infoMana.setBackground(new Background(new BackgroundFill(Color.web("#081936"), new CornerRadii(5), Insets.EMPTY)));
        infoMana.setPadding(new Insets(5));

        infoDefesa.setBackground(new Background(new BackgroundFill(Color.web("#081936"), new CornerRadii(5), Insets.EMPTY)));
        infoDefesa.setPadding(new Insets(5));

        infoVida.setBackground(new Background(new BackgroundFill(Color.web("#081936"), new CornerRadii(5), Insets.EMPTY)));
        infoVida.setPadding(new Insets(5));


        // Configurar os eventos para as ImageView
        imgVida.setOnMouseEntered(event -> mostrarInfoVida(event, imgVida));
        imgDefesaFisica.setOnMouseEntered(event -> mostrarInfoDefesaFisica(event, imgDefesaFisica));
        imgForca.setOnMouseEntered(event -> mostrarInfoForca(event, imgForca));
        imgInteligencia.setOnMouseEntered(event -> mostrarInfoInteligencia(event, imgInteligencia));
        imgMana.setOnMouseEntered(event -> mostrarInfoMana(event, imgMana));
        imgMoeda.setOnMouseEntered(event -> mostrarInfoMoeda(event, imgMoeda));
        imgResistencia.setOnMouseEntered(event -> mostrarInfoResistencia(event, imgResistencia));
        imgVelocidade.setOnMouseEntered(event -> mostrarInfoVelocidade(event, imgVelocidade));
        imgDefesaMagica.setOnMouseEntered(event -> mostrarInfoDefesaMagica(event, imgDefesaMagica));
        // Configurar os eventos para esconder o Label de informações ao sair da ImageView
        imgVida.setOnMouseExited(event -> infoVida.setVisible(false));
        imgDefesaFisica.setOnMouseExited(event -> infoDefesa.setVisible(false));
        imgForca.setOnMouseExited(event -> infoForca.setVisible(false));
        imgInteligencia.setOnMouseExited(event -> infoInteligencia.setVisible(false));
        imgMana.setOnMouseExited(event -> infoMana.setVisible(false));
        imgMoeda.setOnMouseExited(event -> infoCoin.setVisible(false));
        imgResistencia.setOnMouseExited(event -> infoResistencia.setVisible(false));
        imgVelocidade.setOnMouseExited(event -> infoVelo.setVisible(false));
        imgDefesaMagica.setOnMouseExited(event -> infoDefesaMagica.setVisible(false));
    }

    // Métodos específicos para cada atributo
    private void mostrarInfoVida(MouseEvent event, ImageView imageView) {
        infoVida.setText("Informação sobre o HP");
        infoVida.setVisible(true);
    }
    private void mostrarInfoDefesaFisica(MouseEvent event, ImageView imageView) {
        infoDefesa.setText("Informação sobre a defesa física");
        infoDefesa.setVisible(true);
    }
    private void mostrarInfoForca(MouseEvent event, ImageView imageView) {
        infoForca.setText("Informação sobre a força");
        infoForca.setVisible(true);
    }
    private void mostrarInfoInteligencia(MouseEvent event, ImageView imageView) {
        infoInteligencia.setText("Informações sobre a Inteligência");
        infoInteligencia.setVisible(true);
    }
    private void mostrarInfoMana(MouseEvent event, ImageView imageView) {
        infoMana.setText("Informações sobre a Mana");
        infoMana.setVisible(true);
    }
    private void mostrarInfoMoeda(MouseEvent event, ImageView imageView) {
        infoCoin.setText("Informações sobre as Moedas");
        infoCoin.setVisible(true);
    }
    private void mostrarInfoResistencia(MouseEvent event, ImageView imageView) {
        infoResistencia.setText("Informações sobre a Resistência");
        infoResistencia.setVisible(true);
    }
    private void mostrarInfoVelocidade(MouseEvent event, ImageView imageView) {
        infoVelo.setText("Informações sobre a Velocidade");
        infoVelo.setVisible(true);
    }
    private void mostrarInfoDefesaMagica(MouseEvent event, ImageView imageView) {
        infoDefesaMagica.setText("Informações sobre a defesa mágica");
        infoDefesaMagica.setVisible(true);
    }
    private void escurecerCor(Button botao) {
        botao.setStyle("-fx-background-color:  #081936; -fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 2; -fx-focus-traversable: false;-fx-border-color: #ADD8E6;-fx-min-width: 200; -fx-min-height: 50; -fx-opacity: 0.8");
    }
    private void restaurarCor(Button botao) {
        botao.setStyle("-fx-background-color:  #081936; -fx-min-width: 60; -fx-min-height: 60;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 2; -fx-focus-traversable: false;");
    }
    private void desmarcarUltimoClicado() {
        if (lastClicked != null) {
            lastClicked.setStyle("-fx-background-color:  #081936; -fx-min-width: 60; -fx-min-height: 60;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 2; -fx-focus-traversable: false;");
        }
    }
    private void destacarBotao(Button button) {
        button.setStyle("-fx-background-color:  #081936; -fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 2; -fx-focus-traversable: false;-fx-border-color: #ADD8E6;-fx-min-width: 200; -fx-min-height: 50");
        lastClicked = button;
    }
    @FXML
    void onClickViajar(ActionEvent event) {
    Main.ChangeScene(new FXMLLoader((Main.class.getResource("TelaResultado.fxml")))); // pra testar mais rapidamente
    }
    @FXML
    void onClickCassino(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("ControllerCassino.fxml")));

    }

    @FXML
    void onClickStatus(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaStatus.fxml")));

    }

    @FXML
    void Config(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaConfiguracoes.fxml")));

    }
    @FXML
    void onClickQuests(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("QuestsController.fxml")));


    }
}