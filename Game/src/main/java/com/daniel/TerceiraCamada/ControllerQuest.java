package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Quest;
import com.daniel.game.Main;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.contornarBotaoVoltar;
import static com.daniel.TerceiraCamada.Utilidades.definirBackground;

public class ControllerQuest implements Initializable {
    int questAtual = 0;
    int questDisponivel = 0;
    @FXML
    private Button bntSetaSubir;

    @FXML
    private Button btnSetaDescer;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private VBox vboxQuests;

    @FXML
    private Button btnVoltar;

    private static final String FONT_FAMILY = "Barlow Condensed SemiBold";
    private static final int FONT_SIZE = 24;
    private static final String TEXT_FILL = "-fx-fill: #eccb7e;";
    private static final String PROGRESS_BAR_COLOR = "-fx-accent:   #ad8a37; ";


    private void criarQuest(Quest quest) throws PlayerInexistenteException {
        SimpleIntegerProperty progressoProperty = new SimpleIntegerProperty(quest.getProgresso());

        Text texto = new Text(quest.getDescricao());
        texto.setFont(Font.font(FONT_FAMILY, FONT_SIZE));
        texto.setStyle(TEXT_FILL);

        ProgressBar progressBar = new ProgressBar();
        progressBar.setMaxWidth(Double.MAX_VALUE);

        progressoProperty.addListener((observable, oldValue, newValue) ->
                progressBar.setProgress((double) newValue / quest.getObjetivo()));

        progressBar.setProgress((double) quest.getProgresso() / quest.getObjetivo());
        progressBar.setStyle(PROGRESS_BAR_COLOR);
        Button btnRecolher = new Button("Recolher");
        btnRecolher.setStyle("-fx-background-color: #241811; -fx-border-color:  #eccb7e; -fx-text-fill:  #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'");
        btnRecolher.setPrefWidth(100);
        btnRecolher.setPrefHeight(30);

        // Configurar propriedade disable com base na completude da quest
        btnRecolher.setDisable(!quest.isCompleta());

        btnRecolher.setOnAction(e -> {
            try {
                recolherRecompensas(quest);
                atualizarInterfaceGrafica();
            } catch (PlayerInexistenteException ex) {
                throw new RuntimeException(ex);
            }
        });
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setPrefWidth(500.0);
        hBox.getChildren().addAll(progressBar, btnRecolher);
        vboxQuests.getChildren().addAll(texto,hBox);
        vboxQuests.setAlignment(Pos.TOP_LEFT);
        vboxQuests.setSpacing(25);
    }
    private void recolherRecompensas(Quest quest) throws PlayerInexistenteException {
        System.out.println("Recolher recompensas para a quest: " + quest.getNome());
        Player.getPlayer().completarQuest(quest);
    }
    private void atualizarInterfaceGrafica() {
        try {
            vboxQuests.getChildren().clear();

            int inicio = questAtual;
            int fim = Math.min(questAtual + 5, Player.getPlayer().getQuestsAtuais().size());

            for (int i = inicio; i < fim; i++) {
                Quest quest = Player.getPlayer().getQuestsAtuais().get(i);
                if (quest.isHabilitada()) {
                    criarQuest(quest);
                }
            }
        } catch (PlayerInexistenteException e) {
            e.printStackTrace();
        }
    }

    private void configurarSetas() {
        ImageView seta = new ImageView(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        seta.setFitWidth(40);
        seta.setFitHeight(40);
        seta.setPreserveRatio(true);

        ImageView setaInv = new ImageView(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        setaInv.setFitWidth(40);
        setaInv.setFitHeight(40);
        setaInv.setPreserveRatio(true);
        setaInv.setRotate(180);

        btnSetaDescer.setGraphic(seta);
        bntSetaSubir.setGraphic(setaInv);


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        definirBackground(panePrincipal,"/com.daniel.Images/Cartas/MesaTaverna.jpeg");
        configurarSetas();
        ImageView seta = new ImageView();
        seta.setImage(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        seta.setFitWidth(40);
        seta.setFitHeight(60);
        seta.setPreserveRatio(true);
        ImageView setaInv = new ImageView();
        setaInv.setImage(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        setaInv.setFitWidth(40);
        setaInv.setFitHeight(60);
        setaInv.setPreserveRatio(true);
        setaInv.rotateProperty().set(180);
        contornarBotaoVoltar(btnVoltar);
        try {
            Player.getPlayer().desabilitarQuestsNaoComuns();
            atualizarInterfaceGrafica();

        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
    private void verificarSetasQuests(int size) {
        if (questDisponivel == 0) {
            bntSetaSubir.setDisable(true);
        } else {
            bntSetaSubir.setDisable(false);
        }

        if (questDisponivel + 5 >= size) {
            btnSetaDescer.setDisable(true);
        } else {
            btnSetaDescer.setDisable(false);
        }
    }

    @FXML
    void DescerItens(ActionEvent event) throws PlayerInexistenteException {
        if (questAtual < Player.getPlayer().getQuestsAtuais().size() - 1) {
            questAtual++;
            atualizarInterfaceGrafica();
        }
    }

    @FXML
    void SubirItens(ActionEvent event) {
        if (questAtual > 0) {
            questAtual--;
            atualizarInterfaceGrafica();
        }
    }
    @FXML
    void Voltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
    }

}
