package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoSlime;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Quests.Quests;
import com.daniel.game.Main;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerQuest implements Initializable {

    @FXML
    private Button btnQuest;

    @FXML
    private Pane paneAceitarQuests;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private Text txtAceitarQuests;

    @FXML
    private VBox vboxQuests;

    private static final String FONT_FAMILY = "Barlow Condensed SemiBold";
    private static final int FONT_SIZE = 23;
    private static final String TEXT_FILL = "-fx-fill: white;";

    Quests inimigos = new Quests("Derrote inimigos", "Derrote um total de 10 inimigos", 100, 1000, 5, 10);

    private void atualizarInterfaceGrafica() {
        try {
            List<Node> elementosGraficos = new ArrayList<>();

            for (Quests quest : Player.getPlayer().getQuestsAtuais()) {
                SimpleIntegerProperty progressoProperty = new SimpleIntegerProperty(quest.getProgresso());

                Text texto = new Text();
                texto.setText(quest.getDescricao());
                texto.setFont(Font.font(FONT_FAMILY, FONT_SIZE));
                texto.setStyle(TEXT_FILL);

                ProgressBar progressBar = new ProgressBar();
                progressBar.setMaxWidth(Double.MAX_VALUE);

                progressoProperty.addListener((observable, oldValue, newValue) ->
                        progressBar.setProgress((double) newValue / quest.getObjetivo()));

                progressBar.setProgress((double) quest.getProgresso() / quest.getObjetivo());

                elementosGraficos.add(texto);
                elementosGraficos.add(progressBar);
            }

            vboxQuests.getChildren().addAll(elementosGraficos);
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtAceitarQuests.setText(inimigos.getNome());
        atualizarInterfaceGrafica();
    }

    @FXML
    void abrirPane(ActionEvent event) {
        paneAceitarQuests.setVisible(true);
        paneAceitarQuests.setOpacity(100);
    }

    @FXML
    void aceitarQuest(ActionEvent event) throws PlayerInexistenteException {
        Player.getPlayer().aceitarQuest(inimigos);
        atualizarInterfaceGrafica();
        System.out.println("Primeira quest do player aceita: " + Player.getPlayer().getQuestsAtuais().get(0).getNome());
    }

    @FXML
    void Voltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
    }
}
