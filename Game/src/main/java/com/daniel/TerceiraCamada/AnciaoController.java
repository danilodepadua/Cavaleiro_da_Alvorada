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
    private int currentDicaIndex = 0;
    private int currentLoreIndex = 0;
    private int currentFuncaoIndex = 0;

    private VBox currentVBox = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        definirBackground(Screen, "/com.daniel.Images/Fundos/CasaDoAnciao.jpg");
        Image veioImage = new Image(getClass().getResourceAsStream("/com.daniel.Images/Personagens/veiohaha.png"));
        veioImg.setImage(veioImage);
        veioImg.setFitWidth(500);
        veioImg.setFitHeight(500);

        Button botaoVoltar = new Button("Voltar");
        botaoVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Clicou o botao de voltar");
            }
        });
        estiloBotao(botaoVoltar);
        AnchorPane.setBottomAnchor(botaoVoltar, 10.0);
        AnchorPane.setLeftAnchor(botaoVoltar, 10.0);
        Screen.getChildren().add(botaoVoltar);
        currentDicaIndex = 0;
        currentFuncaoIndex = 0;
        currentLoreIndex = 0;

        addButton(Hbox, "Dicas", Pos.CENTER);
        addButton(Hbox, "Como funciona", Pos.CENTER);
        addButton(Hbox, "Lore", Pos.CENTER);
        botoesOriginais.addAll(Hbox.getChildren());

    }

    private void handleButtonClick(String buttonText) {
        System.out.println("handleButtonClick: " + buttonText);

        Hbox.getChildren().clear();

        if ("Dicas".equals(buttonText)) {
            handleArrayButtonClick("Dicas", "Voltar", "Próxima Dica",
                    "A dica é que o mal nunca vence", "Outra dica...", "More dicas...");
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

        Hbox.getChildren().add(currentVBox);
    }

    private void handleArrayButtonClick(String arrayType, String botaoVoltarLabel, String botaoProxLabel, String... arrayItens) {
        System.out.println("handleArrayButtonClick - arrayType: " + arrayType + ", botaoProxLabel: " + botaoProxLabel);

        if (arrayItens.length == 0) {
            System.out.println("Empty array for " + arrayType);
            return;
        }

        switch (arrayType) {
            case "Dicas":
                if ("Próxima Dica".equals(botaoProxLabel)) {
                    currentDicaIndex = (currentDicaIndex + 1) % arrayItens.length;
                    System.out.println("Current Dicas Index: " + currentDicaIndex);
                }
                currentVBox = criarVboxTextBotoes(arrayItens[currentDicaIndex], botaoVoltarLabel, botaoProxLabel);
                break;

            case "Como funciona":
                if ("Próxima Função".equals(botaoProxLabel)) {
                    currentFuncaoIndex = (currentFuncaoIndex + 1) % arrayItens.length;
                    System.out.println("Current Como funciona Index: " + currentFuncaoIndex);
                }
                currentVBox = criarVboxTextBotoes(arrayItens[currentFuncaoIndex], botaoVoltarLabel, botaoProxLabel);
                break;

            case "Lore":
                if ("Próxima Lore".equals(botaoProxLabel)) {
                    currentLoreIndex = (currentLoreIndex + 1) % arrayItens.length;
                    System.out.println("Current Lore Index: " + currentLoreIndex);
                }
                currentVBox = criarVboxTextBotoes(arrayItens[currentLoreIndex], botaoVoltarLabel, botaoProxLabel);
                break;

            default:
                System.out.println("Invalid arrayType: " + arrayType);
                break;
        }
    }

    private void addButton(HBox innerHBox, String buttonText, Pos alignment) {
        Button button = new Button(buttonText);
        innerHBox.getChildren().add(button);
        HBox.setMargin(button, new Insets(5));
        HBox.setHgrow(button, Priority.ALWAYS);
        innerHBox.setAlignment(alignment);
        estiloBotao(button);

        button.setOnAction(event -> {
            System.out.println("Button Clicked: " + buttonText);
            if ("Voltar".equals(buttonText)) {
                formaInicial();
            }  else {
                handleButtonClick(buttonText);
            }
        });
    }

    private VBox criarVboxTextBotoes(String labelTexto, String... botaoLabels) {
        VBox vBox = new VBox();
        Text text = new Text(labelTexto);
        text.setStyle("-fx-font-size: 16px;");
        vBox.getChildren().add(text);

        HBox buttonsHBox = new HBox();
        for (String buttonLabel : botaoLabels) {
            addButton(buttonsHBox, buttonLabel, Pos.CENTER);
        }
        buttonsHBox.setAlignment(Pos.CENTER);

        vBox.getChildren().add(buttonsHBox);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

    private void formaInicial() {
        Hbox.getChildren().clear();
        Hbox.getChildren().addAll(botoesOriginais);
    }
}