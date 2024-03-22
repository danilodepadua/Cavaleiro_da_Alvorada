package com.daniel.View;


import com.daniel.Controller.JogoFachada;
import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextosInterface;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Itens.Item;
import com.daniel.game.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.*;

public class ResultadoController implements Initializable {
    private final JogoFachada jogoFachada = JogoFachada.getInstance();

    @FXML
    private ProgressBar LevelBar;

    @FXML
    private Text LevelNum;

    @FXML
    private Text Txt_Drop;

    @FXML
    private Text Txt_Exp;

    @FXML
    private Text Txt_Makkos;

    @FXML
    private Text Txt_Recompensas;

    @FXML
    private Text Txt_Titulo;

    @FXML
    private Button btnRecolher;

    @FXML
    private GridPane gridItens;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private Text txtMoedas;

    @FXML
    private Text txtXpObitdo;
    private int moedasInimigo;
    private int xpInimigo;
    private ArrayList<Item> itensDoInimigo = new ArrayList<>();
    private SequentialTransition t = new SequentialTransition();

    private void atualizarInterface() throws PlayerInexistenteException {
        txtXpObitdo.setText(String.valueOf(xpInimigo));
        txtMoedas.setText(String.valueOf(moedasInimigo));
        LevelNum.setText(Integer.toString(Player.getPlayer().getLvl()));
        Txt_Titulo.setText(TextosInterface.getVitoria());
        Txt_Drop.setText(TextosInterface.getDrop());
        Txt_Exp.setText(TextosInterface.getXpObtido());
        Txt_Makkos.setText(TextosInterface.getMakkoObtido());
        Txt_Recompensas.setText(TextosInterface.getRecompensa());
        btnRecolher.setText(TextosInterface.getRecolher());
        AtualizarProgressbar();
        jogoFachada.ganharXp(xpInimigo);
        Player.getPlayer().ganharCoins(moedasInimigo);
        criarItens();
        btnRecolher.setOnAction(event -> {
            for (Item item: itensDoInimigo){
                try {
                    Player.getPlayer().getInventario().adicionarItem(item);
                } catch (PlayerInexistenteException  e) {
                    throw new RuntimeException(e);
                }
            }
            t.stop();
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JogoFachada.getInstance().getAudioPlayer().PlayLoop("/com.daniel.audios/som_vitoria.wav");
        try {
            atualizarInterface();
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
        definirBackground(panePrincipal, "/com.daniel.Images/Fundos/FundoVitoria.jpg");
        configurarBotoes(btnRecolher);
        Platform.runLater(()->{
            Utilidades.AlinharHorizontal(Txt_Titulo, 0.5);
            Utilidades.AlinharHorizontal(LevelNum, 0.5);
            Utilidades.AlinharHorizontal(btnRecolher, 0.5);
        });
    }

    public void atualizarValores(int novoXp, int novasMoedas, ArrayList<Item> itens) throws PlayerInexistenteException {
        xpInimigo = novoXp;
        moedasInimigo = novasMoedas;
        itensDoInimigo = itens;
        atualizarInterface();
    }
    private void criarItens() {
        int columnIndex = 0;
        int rowIndex = 0;

        for (Item item : itensDoInimigo) {
            ImageView view = new ImageView();
            view.setFitHeight(35);
            view.setFitWidth(35);
            view.setImage(item.getImage());

            Button button = new Button();
            button.setText("X" + item.getQuant());
            button.setGraphic(view);
            button.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button.setStyle("-fx-background-color:  #241811;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 1; -fx-focus-traversable: false; -fx-border-color: #eccb7e; -fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'");
            configurarBotoesResultado(button);

            // Adicione os elementos ao GridPane
            gridItens.add(button, columnIndex, rowIndex);

            columnIndex++;
            if (columnIndex >= 2) {
                columnIndex = 0;
                rowIndex++;
            }
        }
    }
    private void AtualizarProgressbar() throws PlayerInexistenteException {
        double xpProgress = (Player.getPlayer().getCurrentXp() - (Player.getPlayer().getXpProx() - (Player.getPlayer().getLvl()) * 1000)) / (Player.getPlayer().getLvl() * 1000.0);

        double xpProgressFinal = (Player.getPlayer().getCurrentXp() - (Player.getPlayer().getXpProx() - (Player.getPlayer().getLvl()) * 1000)) + xpInimigo / (Player.getPlayer().getLvl() * 1000.0);
        if(xpProgressFinal >1){
            xpProgressFinal =1;
        }
        int ciclos = 0, xpTemporario = xpInimigo;
        xpTemporario -= Player.getPlayer().getXpProx()-Player.getPlayer().getCurrentXp();
        if(xpTemporario >= 0) {
            ciclos++;
            while (xpTemporario > 0) {
                xpTemporario -= (Player.getPlayer().getLvl() + ciclos) * 1000;
                if (xpTemporario >= 0) {
                    ciclos++;
                }
            }
        }

        xpTemporario = xpInimigo - Player.getPlayer().getLvl() * 1000 - Player.getPlayer().getCurrentXp();

        LevelBar.setProgress(xpProgress);
        int nivel = Player.getPlayer().getLvl();

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(1000), new KeyValue(LevelBar.progressProperty(), xpProgressFinal))
        );
        if(ciclos>0){
            nivel++;
            int finalNivel = nivel;
            timeline.setOnFinished(event -> {
                LevelNum.setText(String.valueOf(finalNivel));
                JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_click.wav");
            });
        }

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().add(timeline);
        for (int i = 1; i <= ciclos; i++) {
            nivel++;
            System.out.println("Ciclo: " + i + "/" + ciclos);

            sequentialTransition.getChildren().add(CriarProgress((double) xpTemporario / ((Player.getPlayer().getLvl() + i) * 1000),nivel));
            xpTemporario-=((Player.getPlayer().getLvl() + i) * 1000);
        }
        t = sequentialTransition;
        sequentialTransition.play();
    }
    public Timeline CriarProgress(double ValorFinal, int cont){
        Timeline timeline = new Timeline();
        if(ValorFinal > 1){
            ValorFinal = 1;
            timeline.setOnFinished(event -> {
                LevelNum.setText(String.valueOf(cont));
                JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_click.wav");
            });
        }
        timeline.getKeyFrames().add(new KeyFrame(Duration.ZERO, new KeyValue(LevelBar.progressProperty(), 0)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1000), new KeyValue(LevelBar.progressProperty(), ValorFinal)));
        return timeline;
    }
}