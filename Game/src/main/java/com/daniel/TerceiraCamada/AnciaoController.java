package com.daniel.TerceiraCamada;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import static com.daniel.TerceiraCamada.Utilidades.definirBackground;
import static com.daniel.TerceiraCamada.Utilidades.estiloBotao;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        definirBackground(Screen, "/com.daniel.Images/Fundos/CasaDoAnciao.jpg");
        carregarImagemVeio();

        Button botaoVoltar = new Button("Voltar");
        botaoVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Clicou no botao de voltar");
            }
        });
        estiloBotao(botaoVoltar);
        AnchorPane.setBottomAnchor(botaoVoltar, 10.0);
        AnchorPane.setLeftAnchor(botaoVoltar, 10.0);
        Screen.getChildren().add(botaoVoltar);
        indiceDicaAtual = 0;
        indiceFuncaoAtual = 0;
        indiceLoreAtual = 0;

        adicionarBotao(Hbox, "Dicas", Pos.CENTER);
        adicionarBotao(Hbox, "Como funciona", Pos.CENTER);
        adicionarBotao(Hbox, "Lore", Pos.CENTER);
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

        if ("Dicas".equals(buttonText)) {
            handleArrayButtonClick("Dicas", "Voltar", "Próxima Dica",
                    "A dica é que o mal nunca vence afdfsdfsdsdgsdgsdgdsgsdgsg", "Outra dica...", "More dicas...");
        }

        if ("Como funciona".equals(buttonText)) {
            handleArrayButtonClick("Como funciona", "Voltar", "Próxima Função",
                    "funciona daquele jeito rapaz", "entre uma função e outra", "ksksk função");
        }

        if ("Lore".equals(buttonText)) {
            handleArrayButtonClick("Lore", "Voltar", "Próxima Lore",
                    "A lore é grande rapaz", "a lore n acaba", "nunca nunca");
        }
        if ("Próxima Dica".equals(buttonText)) {
            handleArrayButtonClick("Dicas", "Voltar", "Próxima Dica",
                    "A dica é que o mal nunca vence", "Outra dica...", "More dicas...");
        }

        if ("Próxima Função".equals(buttonText)) {
            handleArrayButtonClick("Como funciona", "Voltar", "Próxima Função",
                    "funciona daquele jeito rapaz", "entre uma função e outra", "ksksk função");
        }

        if ("Próxima Lore".equals(buttonText)) {
            handleArrayButtonClick("Lore", "Voltar", "Próxima Lore",
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
            case "Dicas":
                if ("Próxima Dica".equals(botaoProxLabel)) {
                    indiceDicaAtual = (indiceDicaAtual + 1) % itensArray.length;
                    System.out.println("Current Dicas Index: " + indiceDicaAtual);
                }
                VBoxAtual = criarVboxTextBotoes(itensArray[indiceDicaAtual], botaoVoltarLabel, botaoProxLabel);
                break;

            case "Como funciona":
                if ("Próxima Função".equals(botaoProxLabel)) {
                    indiceFuncaoAtual = (indiceFuncaoAtual + 1) % itensArray.length;
                    System.out.println("Current Como funciona Index: " + indiceFuncaoAtual);
                }
                VBoxAtual = criarVboxTextBotoes(itensArray[indiceFuncaoAtual], botaoVoltarLabel, botaoProxLabel);
                break;

            case "Lore":
                if ("Próxima Lore".equals(botaoProxLabel)) {
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

        configurarBotaoAcao(button, buttonText);
    }

    private void configurarBotaoAcao(Button button, String buttonText) { // se o botão voltar for clicado, ele volta ao estado inicial da tela
        button.setOnAction(event -> {
            System.out.println("Button Clicked: " + buttonText);
            if ("Voltar".equals(buttonText)) {
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