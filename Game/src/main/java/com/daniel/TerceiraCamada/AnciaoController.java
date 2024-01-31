package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.AudioPlayer;
import com.daniel.PrimeiraCamada.Entidades.NPC;
import com.daniel.PrimeiraCamada.SistemaDeDialogo;
import com.daniel.game.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.*;

public class AnciaoController implements Initializable {
    @FXML
    AnchorPane Screen;
    @FXML
    HBox Hbox;
    @FXML
    ImageView veioImg;
    private final List<Node> botoesOriginais = new ArrayList<>();
    private int indiceDicaAtual = 0;
    private int indiceLoreAtual = 0;
    private int indiceFuncaoAtual = 0;

    private VBox VBoxAtual = null;

    private static final String DICAS = "Dicas";
    private static final String COMO_FUNCIONA = "Como funciona";
    private static final String LORE = "Lore";
    private static final String VOLTAR = "Voltar";
    private static final String PROXIMA_DICA = "Próxima Dica";
    private static final String PROXIMA_FUNCAO = "Próxima Função";
    private static final String PROXIMA_LORE = "Próxima Lore";
    private AudioPlayer audioPlayer = new AudioPlayer();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        audioPlayer.play("/com.daniel.audios/msc_anciao.wav", true);
        definirBackground(Screen, "/com.daniel.Images/Fundos/CasaDoAnciao.jpg");
        carregarImagemVeio();
        configurarBotaoVoltar();
        configurarBotoesIniciais();

        StackPane pane = new StackPane();
        NPC veioNPC = new NPC("Veio");
        veioNPC.setMaisOpcao("abluble teste");
        SistemaDeDialogo dialogo = new SistemaDeDialogo(veioNPC);
        pane.getChildren().add(dialogo);


        BorderPane.setAlignment(pane, Pos.CENTER);
        BorderPane.setMargin(pane, new Insets(50));

        BorderPane root = new BorderPane();
        root.setBottom(pane);
        root.setAlignment(dialogo, Pos.CENTER);
        Screen.getChildren().add(root);
    }

    private Button criarBotaoVoltar() {
        Button botaoVoltar = new Button(VOLTAR);
        botaoVoltar.setOnAction(event -> {
            try {
                audioPlayer.stop();
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Clicou no botao de voltar");
        });
        estiloBotao(botaoVoltar);
        configurarBotoes(botaoVoltar);
        configurarBotoesTelaCidade(botaoVoltar);
        AnchorPane.setBottomAnchor(botaoVoltar, 10.0);
        AnchorPane.setLeftAnchor(botaoVoltar, 10.0);
        return botaoVoltar;
    }

    private void configurarBotaoVoltar() {
        Button botaoVoltar = criarBotaoVoltar();
        Screen.getChildren().add(botaoVoltar);
    }

    private void configurarBotoesIniciais() {
        adicionarBotao(Hbox, DICAS, Pos.CENTER);
        adicionarBotao(Hbox, COMO_FUNCIONA, Pos.CENTER);
        adicionarBotao(Hbox, LORE, Pos.CENTER);
        botoesOriginais.addAll(Hbox.getChildren());
    }

    private void carregarImagemVeio() {
        Image imagemVeio = new Image(getClass().getResourceAsStream("/com.daniel.Images/Personagens/veiohaha.png"));
        configurarImagemVeio(imagemVeio);
    }

    private void configurarImagemVeio(Image image) {
        veioImg.setImage(image);
        veioImg.setFitWidth(500);
        veioImg.setFitHeight(500);
    }

    private void handleButtonClick(String buttonText) { // confere qual botão inicial foi clicado e chama o metodo enviando seus valores correspondentes
        System.out.println("handleButtonClick: " + buttonText);

        Hbox.getChildren().clear();

        if (DICAS.equals(buttonText)) {
            handleArrayButtonClick(DICAS, VOLTAR, PROXIMA_DICA,
                    "A dica é que o mal nunca vence afdfsdfsdsdgsdgsdgdsgsdgsg", "Outra dica...", "More dicas...");
        }

        if (COMO_FUNCIONA.equals(buttonText)) {
            handleArrayButtonClick(COMO_FUNCIONA, VOLTAR, PROXIMA_FUNCAO,
                    "funciona daquele jeito rapaz", "entre uma função e outra", "ksksk função");
        }

        if (LORE.equals(buttonText)) {
            handleArrayButtonClick(LORE, VOLTAR, PROXIMA_LORE,
                    "A lore é grande rapaz", "a lore n acaba", "nunca nunca");
        }
        if (PROXIMA_DICA.equals(buttonText)) {
            handleArrayButtonClick(DICAS, VOLTAR, PROXIMA_DICA,
                    "A dica é que o mal nunca vence", "Outra dica...", "More dicas...");
        }

        if (PROXIMA_FUNCAO.equals(buttonText)) {
            handleArrayButtonClick(COMO_FUNCIONA, VOLTAR, PROXIMA_FUNCAO,
                    "funciona daquele jeito rapaz", "entre uma função e outra", "ksksk função");
        }

        if (PROXIMA_LORE.equals(buttonText)) {
            handleArrayButtonClick(LORE, VOLTAR, PROXIMA_LORE,
                    "A lore é grande rapaz", "a lore n acaba", "nunca nunca");
        }

        Hbox.getChildren().add(VBoxAtual);
    }

    private void handleArrayButtonClick(String arrayType, String botaoVoltarLabel, String botaoProxLabel, String... itensArray) {
        System.out.println("handleArrayButtonClick - arrayType: " + arrayType + ", botaoProxLabel: " + botaoProxLabel);

        if (itensArray.length == 0) {
            System.out.println("Empty array for " + arrayType);
            return;
        }

        switch (arrayType) {
            case DICAS:
                if (PROXIMA_DICA.equals(botaoProxLabel)) {
                    indiceDicaAtual = (indiceDicaAtual + 1) % itensArray.length;
                    System.out.println("Current Dicas Index: " + indiceDicaAtual);
                }
                VBoxAtual = criarVboxTextBotoes(itensArray[indiceDicaAtual], botaoVoltarLabel, botaoProxLabel);
                break;

            case COMO_FUNCIONA:
                if (PROXIMA_FUNCAO.equals(botaoProxLabel)) {
                    indiceFuncaoAtual = (indiceFuncaoAtual + 1) % itensArray.length;
                    System.out.println("Current Como funciona Index: " + indiceFuncaoAtual);
                }
                VBoxAtual = criarVboxTextBotoes(itensArray[indiceFuncaoAtual], botaoVoltarLabel, botaoProxLabel);
                break;

            case LORE:
                if (PROXIMA_LORE.equals(botaoProxLabel)) {
                    indiceLoreAtual = (indiceLoreAtual + 1) % itensArray.length;
                    System.out.println("Current Lore Index: " + indiceLoreAtual);
                }
                VBoxAtual = criarVboxTextBotoes(itensArray[indiceLoreAtual], botaoVoltarLabel, botaoProxLabel);
                break;

            default:
                System.out.println("Invalid arrayType: " + arrayType);
                break;
        }
    }

    private void adicionarBotao(HBox innerHBox, String buttonText, Pos alignment) { //cria, posiciona e estiliza o botão
        Button button = new Button(buttonText);
        innerHBox.getChildren().add(button);
        HBox.setMargin(button, new Insets(5));
        HBox.setHgrow(button, Priority.ALWAYS);
        innerHBox.setAlignment(alignment);

        estiloBotao(button);
        configurarBotoes(button);
        configurarBotoesTelaCidade(button);
        configurarBotaoAcao(button, buttonText);
    }

    private void configurarBotaoAcao(Button button, String buttonText) { // se o botão voltar for clicado, ele volta ao estado inicial da tela
        button.setOnAction(event -> {
            System.out.println("Button Clicked: " + buttonText);
            if (VOLTAR.equals(buttonText)) {
                formaInicial();
            } else {
                handleButtonClick(buttonText);
            }
        });
    }

    private Text criarTexto(String labelTexto) { // cria o texto e dá estilo
        Text text = new Text(labelTexto);
        text.setStyle("-fx-font-size: 20px; -fx-fill: #ffffff; -fx-font-weight: bold; -fx-background-color: rgba(255, 255, 255, 1);");
        return text;
    }

    private HBox criarHBoxBotoes(String... botaoLabels) { // cria os botões
        HBox botoesHBox = new HBox();
        for (String buttonLabel : botaoLabels) {
            adicionarBotao(botoesHBox, buttonLabel, Pos.CENTER);
        }
        botoesHBox.setAlignment(Pos.CENTER);
        return botoesHBox;
    }

    private VBox criarVboxTextBotoes(String labelTexto, String... botaoLabels) { // chama os métodos de criação dos botões e textos associados com o botão recebido
        VBox vBox = new VBox();
        vBox.getChildren().add(criarTexto(labelTexto));
        vBox.getChildren().add(criarHBoxBotoes(botaoLabels));
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }


    private void formaInicial() { // limpa os botões atuais e pega os botões iniciais
        Hbox.getChildren().clear();
        Hbox.getChildren().addAll(botoesOriginais);
    }
}