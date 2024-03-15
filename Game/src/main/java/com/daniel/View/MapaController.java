package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.CidadeInexistenteException;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.RemoverCoinsException;
import com.daniel.Model.Exceptions.SemMoedasException;
import com.daniel.game.Main;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.daniel.game.Main.CurrentStage;
import static com.daniel.game.Main.cidadeAtual;

public class MapaController extends Utilidades implements Initializable {
    private final JogoFachada jogoFachada = JogoFachada.getInstance();
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
    private Button btnNao;

    @FXML
    private Button btnSim;
    @FXML
    private AnchorPane paneAceitar;
    @FXML
    void OnActionVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void OnActionViajar(ActionEvent event) throws IOException, CidadeInexistenteException {
        // Configura a cidade atual
        if ( cidadeTroca != null) {
            if (cidadeTroca.getNome().equals("ILHA")) { //condiçao para ilha, verifica se é a ilham se for, aparece o pane
                paneAceitar.setDisable(false);
                paneAceitar.setOpacity(1.0);
            } else {
                Main.cidadeAtual = cidadeTroca;
                exibirCutscene();
            }
        }else {
            throw new CidadeInexistenteException();
        }
    }

    private void exibirCutscene() throws IOException {
        if (cidadeTroca.isDialogoAtivo()){ //chamo a variável booleana pra ver se ta ativa pra não ficar repetindo os diálogos sempre.
            AnchorPane cutsceneContainer = criarAnchorPane(); //cria um AnchorPane pro dialogo junto de um scene
            String mensagemCutscene = Main.cidadeAtual.getDialogoCutscene();

            // Verifica se a mensagem não é nula ou vazia antes de proceder pra evitar erro de nullPoint
            if (mensagemCutscene != null && !mensagemCutscene.isEmpty()) {
                // Adiciona um VBox como filho do AnchorPane
                VBox vbox = new VBox();
                vbox.setLayoutX(25);
                vbox.setLayoutY(25);
                AnchorPane anchorPane = new AnchorPane();
                anchorPane.setStyle("-fx-background-color:  white; -fx-border-color: black; -fx-opacity: 0.7");
                //Configs básicas do pane
                anchorPane.getChildren().add(vbox);
                anchorPane.setPrefWidth(1150);
                anchorPane.setLayoutX(50);
                anchorPane.setLayoutY(200);

                cutsceneContainer.getChildren().add(anchorPane);

                // Adiciona um Text para exibir a mensagem
                Text mensagemText = new Text();
                mensagemText.setStyle("-fx-font-family: 'Barlow Condensed SemiBold'; -fx-fill: black; -fx-font-size: 40;-fx-opacity: 1");
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
            //Se não ta ativo, chama a tela de load
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
    //Metodo pra criar um pane pra tela de diálogo
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
        contornarBotaoVoltar(btnNao);
        configurarBotoes(btnSim);
        contornarBotaoVoltar(btnVoltar);
        configurarBotoes(btnViajar);
        ImgMapa.setFitHeight(Main.getAltura() - 100);
        ImgMapa.setFitWidth(ImgMapa.getBoundsInLocal().getWidth());
        definirBackground(Fundo, "/com.daniel.Images/Fundos/Mar.jpg");
        identificarTextos(Fundo);
        Circulo.setOpacity(0);
        try {
            ParallelTransition parallelTransition = new ParallelTransition();
            int i = 0;
            for (Cidade cidade : Player.getPlayer().getCidadesConehcidas()) {
                if (!Objects.equals(cidade.getNome(), Main.cidadeAtual.getNome())) {
                    Button butao = new Button();
                    butao.setText(cidade.getNome());
                    butao.setOnAction(event -> {
                        switch (cidade.getNome()){
                            case "MONTANHA DO NORTE":
                                MostraMarca(0.445, 0.15);
                                break;
                            case "AURORAVILLE":
                                MostraMarca(0.924, 0.55);
                                break;
                            case "DASÓPOLES":
                                MostraMarca(0.82,0.65);
                                break;
                            case "MONTE CLARO":
                                MostraMarca(0.638, 0.71);
                                break;
                            case "CIDADE MORTA":
                                MostraMarca(0.73, 0.195);
                                break;
                            case "ILHA":
                                MostraMarca(0.35, 0.83);
                                break;
                            case "CIDADE PORTUÁRIA":
                                MostraMarca(0.305,0.52);
                                break;
                            case "PEDRAVEIRA":
                                MostraMarca(0.18, 0.13);
                                break;
                        }
                        cidadeTroca = cidade;
                    });
                    butao.setLayoutX(10);
                    butao.setLayoutY(-50);
                    estiloBotao(butao);
                    configurarBotoesMapa(butao);
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
    @FXML
    void onActionNao(ActionEvent event) {
        paneAceitar.setDisable(true);
        paneAceitar.setOpacity(0);
    }
    @FXML
    void onActionSim(ActionEvent event) throws PlayerInexistenteException, RemoverCoinsException, IOException, SemMoedasException {
        Main.cidadeAtual = cidadeTroca;
        int passagem = 50;
        int dinheiro =  Player.getPlayer().getCoins();
        if (dinheiro >= passagem){
            Player.getPlayer().removerCoins(passagem);
            exibirCutscene();
            System.out.println("Viajando com passagem");
        }else {
            throw new SemMoedasException();
        }
    }
}