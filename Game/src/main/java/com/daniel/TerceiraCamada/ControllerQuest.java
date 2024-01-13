package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoAbelha;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoBabySlime;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Quests.*;
import com.daniel.game.Main;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerQuest implements Initializable {
    private List<Quests> questsDisponiveis = new ArrayList<>();
    int questAtual = 0;
    int questDisponivel = 0;
    @FXML
    private Button bntSetaSubir;

    @FXML
    private Button bntSetaSubir1;

    @FXML
    private Button btnSetaDescer;

    @FXML
    private Button btnSetaDescer1;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private AnchorPane paneTextos;

    @FXML
    private VBox vboxAceitarQuests;

    @FXML
    private VBox vboxQuests;
    private static final String FONT_FAMILY = "Barlow Condensed SemiBold";
    private static final int FONT_SIZE = 18;
    private static final String TEXT_FILL = "-fx-fill: white;";

    private void criarQuest(Quests quest) {
        SimpleIntegerProperty progressoProperty = new SimpleIntegerProperty(quest.getProgresso());

        Text texto = new Text(quest.getDescricao());
        texto.setFont(Font.font(FONT_FAMILY, FONT_SIZE));
        texto.setStyle(TEXT_FILL);

        ProgressBar progressBar = new ProgressBar();
        progressBar.setMaxWidth(Double.MAX_VALUE);

        progressoProperty.addListener((observable, oldValue, newValue) ->
                progressBar.setProgress((double) newValue / quest.getObjetivo()));

        progressBar.setProgress((double) quest.getProgresso() / quest.getObjetivo());

        Button btnRecolher = new Button("Recolher");
        btnRecolher.setStyle("-fx-background-color: #081936; -fx-border-color: #daa520; -fx-text-fill: #daa520;");

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
        hBox.getChildren().addAll(progressBar, btnRecolher);
        vboxQuests.getChildren().addAll(texto,hBox);
        vboxQuests.setAlignment(Pos.TOP_LEFT);
        vboxQuests.setSpacing(20);
    }
    private void recolherRecompensas(Quests quest) throws PlayerInexistenteException {
        System.out.println("Recolher recompensas para a quest: " + quest.getNome());
        Player.getPlayer().completarQuest(quest);
    }
    private void atualizarInterfaceGrafica() {
        try {
            vboxQuests.getChildren().clear();

            int inicio = questAtual;
            int fim = Math.min(questAtual + 4, Player.getPlayer().getQuestsAtuais().size());

            for (int i = inicio; i < fim; i++) {
                Quests quest = Player.getPlayer().getQuestsAtuais().get(i);
                criarQuest(quest);
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
        paneTextos.setVisible(false);
        atualizarInterfaceGrafica();

        ManejarQuests questManager = ManejarQuests.getInstance();
        questsDisponiveis.addAll(questManager.getQuestsDisponiveis());

        paneTextos.setPickOnBounds(true);
        configurarSetas();
        ImageView seta = new ImageView();
        seta.setImage(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        seta.setFitWidth(40);
        seta.setFitHeight(40);
        seta.setPreserveRatio(true);
        ImageView setaInv = new ImageView();
        setaInv.setImage(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        setaInv.setFitWidth(40);
        setaInv.setFitHeight(40);
        setaInv.setPreserveRatio(true);
        setaInv.rotateProperty().set(180);
        btnSetaDescer1.setGraphic(seta);
        bntSetaSubir1.setGraphic(setaInv);
        try {
            questsDisponiveis();
            verificarSetasQuests(questsDisponiveis.size());

        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }


    }
    private void verificarSetasQuests(int size) {
        if (questDisponivel == 0) {
            bntSetaSubir1.setDisable(true);
            bntSetaSubir.setDisable(true);
        } else {
            bntSetaSubir1.setDisable(false);
            bntSetaSubir.setDisable(false);
        }

        if (questDisponivel + 4 >= size) {
            btnSetaDescer1.setDisable(true);
            btnSetaDescer.setDisable(true);
        } else {
            btnSetaDescer1.setDisable(false);
            btnSetaDescer.setDisable(false);
        }
    }
    public void questsDisponiveis() throws PlayerInexistenteException {
        paneTextos.setVisible(true);
        paneTextos.setDisable(false);
        paneTextos.setOpacity(100);
        try {
            vboxAceitarQuests.getChildren().clear();
            int inicio = questDisponivel;
            int fim = Math.min(questDisponivel + 4, questsDisponiveis.size());

            for (int i = inicio; i < fim; i++) {
                Quests quests = questsDisponiveis.get(i);
                System.out.println("quests disponiveis: "+ quests);
                Text texto = new Text(quests.getDescricao());
                texto.setFont(Font.font(FONT_FAMILY, FONT_SIZE));
                texto.setStyle(TEXT_FILL);

                // Criar Botão
                Button btnAceitar = new Button("Aceitar");
                btnAceitar.setStyle("-fx-background-color: #081936; -fx-border-color: #daa520; -fx-text-fill: #daa520;");
                btnAceitar.setDisable(Player.getPlayer().getQuestsAtuais().contains(quests));
                // Adicionar ação ao botão
                btnAceitar.setOnAction(e -> {
                        aceitarQuest(quests, btnAceitar);
                        btnAceitar.setDisable(true);
                    });

                HBox hBox = new HBox();
                hBox.setSpacing(10);
                hBox.getChildren().addAll(texto, btnAceitar);
                vboxAceitarQuests.getChildren().addAll(hBox);
                vboxAceitarQuests.setSpacing(30);
                vboxAceitarQuests.setAlignment(Pos.TOP_CENTER);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        verificarSetasQuests(questsDisponiveis.size());
    }
    }

    public void aceitarQuest(Quests quest, Button button) {
        try {
            Player.getPlayer().getQuestsAtuais().add(quest);
            System.out.println("Quest aceita: " + quest.getNome());
            atualizarInterfaceGrafica();
        } catch (PlayerInexistenteException ex) {
            System.err.println("Erro ao aceitar quest: " + ex.getMessage());
        }
    }



    @FXML
    void DescerItens(ActionEvent event) {
        if (questAtual < questsDisponiveis.size() - 1) {
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
    @FXML
    void SubirQuests(ActionEvent event) throws PlayerInexistenteException {
        if (questDisponivel > 0) {
            questDisponivel--;
            questsDisponiveis();

        }
    }

    @FXML
    void DescerQuests(ActionEvent event) throws PlayerInexistenteException {
        if (questDisponivel < questsDisponiveis.size() - 1) {
            questDisponivel++;
            questsDisponiveis();

        }
    }

    public List<Quests> getQuestsDisponiveis() {
        return questsDisponiveis;
    }
}
