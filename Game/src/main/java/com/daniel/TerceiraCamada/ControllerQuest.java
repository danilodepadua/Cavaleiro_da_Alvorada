package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoAbelha;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoBabySlime;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Quests.QuestAbelha;
import com.daniel.PrimeiraCamada.Quests.QuestBabySlime;
import com.daniel.PrimeiraCamada.Quests.QuestInimigoSlimeDeEscuridaoNv1;
import com.daniel.PrimeiraCamada.Quests.Quests;
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
    private Button btnQuest;

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
    private static final int FONT_SIZE = 20;
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
        btnRecolher.setVisible(quest.isCompleta());
        btnRecolher.setOnAction(e -> {
            try {
                recolherRecompensas(quest);
                atualizarInterfaceGrafica();
            } catch (PlayerInexistenteException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Adicione os elementos diretamente ao vboxQuests
        vboxQuests.getChildren().addAll(texto, progressBar, btnRecolher);
    }


    private void recolherRecompensas(Quests quest) throws PlayerInexistenteException {
        System.out.println("Recolher recompensas para a quest: " + quest.getNome());
        Player.getPlayer().completarQuest(quest);
    }

    private void atualizarInterfaceGrafica() {
        try {
            vboxQuests.getChildren().clear();

            int inicio = questAtual;
            int fim = Math.min(questAtual + 3, Player.getPlayer().getQuestsAtuais().size());

            for (int i = inicio; i < fim; i++) {
                Quests quest = Player.getPlayer().getQuestsAtuais().get(i);
                criarQuest(quest);
            }
        } catch (PlayerInexistenteException e) {
            // Lide com a exceção de maneira apropriada para seu aplicativo
            e.printStackTrace();
        }
    }


    private void configurarSetas() {
        ImageView seta = new ImageView(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        seta.setFitWidth(30);
        seta.setPreserveRatio(true);

        ImageView setaInv = new ImageView(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        setaInv.setFitWidth(30);
        setaInv.setPreserveRatio(true);
        setaInv.setRotate(180);

        btnSetaDescer.setGraphic(seta);
        bntSetaSubir.setGraphic(setaInv);


    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneTextos.setVisible(false);
        atualizarInterfaceGrafica();
        QuestBabySlime questBabySlime = new QuestBabySlime();
        QuestAbelha questAbelha = new QuestAbelha();
        QuestInimigoSlimeDeEscuridaoNv1 questInimigoSlimeDeEscuridaoNv1 = new QuestInimigoSlimeDeEscuridaoNv1();
        questsDisponiveis.add(questBabySlime);
        questsDisponiveis.add(questAbelha);
        paneTextos.setPickOnBounds(true);
        configurarSetas();
        ImageView seta = new ImageView();
        seta.setImage(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        seta.setFitWidth(30);
        seta.setPreserveRatio(true);
        ImageView setaInv = new ImageView();
        setaInv.setImage(new Image(Main.class.getResource("/com.daniel.Images/SetaBaixoAmarela.png").toString()));
        setaInv.setFitWidth(30);
        setaInv.setPreserveRatio(true);
        setaInv.rotateProperty().set(180);
        btnSetaDescer1.setGraphic(seta);
        bntSetaSubir1.setGraphic(setaInv);

    }

    @FXML
    void abrirPane() throws PlayerInexistenteException {
        paneTextos.setVisible(true);
        paneTextos.setDisable(false);
        paneTextos.setOpacity(100);
        try {
            vboxAceitarQuests.getChildren().clear();
            int inicio = questDisponivel;
            int fim = Math.min(questDisponivel + 3, questsDisponiveis.size());

            for (int i = inicio; i < fim; i++) {
                Quests quests = questsDisponiveis.get(i);

                Text texto = new Text(quests.getDescricao());
                texto.setFont(Font.font(FONT_FAMILY, FONT_SIZE));
                texto.setStyle(TEXT_FILL);

                // Criar Botão
                Button btnAceitar = new Button("Aceitar");

                // Adicionar ação ao botão
                btnAceitar.setOnAction(e -> {
                    aceitarQuest(quests);

                });
                btnAceitar.setDisable(Player.getPlayer().getQuestsAtuais().contains(quests));

                vboxAceitarQuests.getChildren().addAll(texto, btnAceitar);
                vboxAceitarQuests.setSpacing(10);
                vboxAceitarQuests.setAlignment(Pos.TOP_CENTER);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void aceitarQuest(Quests quest) {
        try {
            Player.getPlayer().aceitarQuest(quest);
            atualizarInterfaceGrafica();
            System.out.println("Quest aceita: " + quest.getNome());
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
            abrirPane();

        }
    }

    @FXML
    void DescerQuests(ActionEvent event) throws PlayerInexistenteException {
        if (questDisponivel < questsDisponiveis.size() - 1) {
            questDisponivel++;
            abrirPane();

        }
    }
}
