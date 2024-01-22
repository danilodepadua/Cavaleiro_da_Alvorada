package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.daniel.game.Main.CurrentStage;
import static com.daniel.game.Main.cidadeAtual;

public class MapaController extends Utilidades implements Initializable {

    @FXML
    private Circle Circulo;
    @FXML
    private AnchorPane Fundo;
    @FXML
    private ImageView ImgMapa;
    private Cidade cidadeTroca;
    @FXML
    private Button btnViajar;

    @FXML
    private Button btnVoltar;

    @FXML
    void OnActionVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void OnActionViajar(ActionEvent event) throws IOException {
        // Configura a cidade atual
        Main.cidadeAtual = cidadeTroca;

        // Exibe a cutscene
        exibirCutscene();

    }

    private void exibirCutscene() throws IOException {
        if (cidadeTroca.isDialogoAtivo()){
            AnchorPane cutsceneContainer = criarAnchorPane(); //cria um AnchorPane pro dialogo junto de um scene
            String mensagemCutscene = Main.cidadeAtual.getDialogoCutscene();

            // Verifica se a mensagem não é nula ou vazia antes de proceder pra evitar erro de nullPoint
            if (mensagemCutscene != null && !mensagemCutscene.isEmpty()) {
                // Adiciona um VBox como filho do AnchorPane
                VBox vbox = new VBox();
                vbox.setLayoutX(100);
                vbox.setLayoutY(50);
                cutsceneContainer.getChildren().add(vbox);

                // Adiciona um Text para exibir a mensagem
                Text mensagemText = new Text();
                mensagemText.setStyle("-fx-font-family: 'Barlow Condensed SemiBold'; -fx-fill: #eccb7e; -fx-font-size: 40; -fx-stroke: black; -fx-stroke-width: 1");
                mensagemText.setWrappingWidth(1100);

                vbox.getChildren().add(mensagemText);
                cidadeTroca.mudarDialogo(false);
                adicionarCaracteresComAtraso(mensagemCutscene, mensagemText, () -> {
                    // Muda para a cena da cidade após a animação da cutscene
                    try {
                        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            });
            }
        } else {
            Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaLoad.fxml")).load());
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event -> {
                try {
                    Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            pause.play();
        }
    }

    private AnchorPane criarAnchorPane() {
        AnchorPane cutsceneContainer = new AnchorPane();
        definirBackground(cutsceneContainer, cidadeAtual.getCaminhoImagem());

        cutsceneContainer.setStyle("-fx-padding: 20;");
        Scene cutsceneScene = new Scene(cutsceneContainer, CurrentStage.getWidth(), CurrentStage.getHeight());
        cutsceneScene.setFill(Color.WHITE);
        CurrentStage.setScene(cutsceneScene);

        return cutsceneContainer;
    }

    private Timeline CriarAnimacaoQueda(Node n, double d) {
        KeyValue keyValue = new KeyValue(n.layoutYProperty(), d, Interpolator.EASE_BOTH);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);

        return new Timeline(keyFrame);
    }
    private void MostraMarca(double x, double y){
        Circulo.setOpacity(1);
        Circulo.setRadius(0);
        Circulo.setLayoutX(Main.getLargura() - 100 - x*ImgMapa.getBoundsInLocal().getWidth());
        Circulo.setLayoutY(50+y*ImgMapa.getBoundsInLocal().getHeight());
        KeyValue kv = new KeyValue(Circulo.radiusProperty(), 30, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.millis(200), kv);
        Timeline tm = new Timeline(kf);
        tm.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contornarBotaoVoltar(btnVoltar);
        configurarBotoes(btnViajar);
        ImgMapa.setFitHeight(Main.getAltura() - 100);
        ImgMapa.setFitWidth(ImgMapa.getBoundsInLocal().getWidth());
        definirBackground(Fundo, "/com.daniel.Images/Fundos/Mar.jpg");
        Circulo.setOpacity(0);
        //Cidade do norte(0.445, 0.15)
        //Forte nas montanhas(0.638, 0.71)
        //Cidade do bosque(0.82,0.65)
        //Cidade inicial(0.924, 0.55)
        //Cidade morta(0.73, 0.195)
        //Cidade porto(0.305,0.52)
        try {
            ParallelTransition parallelTransition = new ParallelTransition();
            int i = 0;
            for (Cidade cidade : Player.getPlayer().getCidadesConehcidas()) {
                if (!Objects.equals(cidade.getNome(), Main.cidadeAtual.getNome())) {
                    Button butao = new Button();
                    butao.setText(cidade.getNome());
                    butao.setOnAction(event -> {
                        switch (cidade.getNome()){
                            case "Montanha Do Norte":
                                MostraMarca(0.445, 0.15);
                                break;
                            case "Cidade Inicial":
                                MostraMarca(0.924, 0.55);
                                break;
                            case "Cidade morta":
                                MostraMarca(0.73, 0.195);
                        }
                        cidadeTroca = cidade;
                    });
                    butao.setLayoutX(10);
                    butao.setLayoutY(-50);
                    estiloBotao(butao);
                    Fundo.getChildren().add(butao);

                    SequentialTransition sequentialTransition = new SequentialTransition();
                    sequentialTransition.getChildren().addAll(
                            new PauseTransition(Duration.millis(i * 250)),
                            CriarAnimacaoQueda(butao, (70 + (i * 70)))
                    );
                    parallelTransition.getChildren().add(sequentialTransition);
                    i++;
                }
            }
            parallelTransition.play();
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
}