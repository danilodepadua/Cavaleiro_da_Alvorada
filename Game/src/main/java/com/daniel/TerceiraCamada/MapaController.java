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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MapaController extends Utilidades implements Initializable {

    @FXML
    private Circle Circulo;
    @FXML
    private AnchorPane Fundo;
    @FXML
    private ImageView ImgMapa;
    private Cidade cidadeTroca;

    @FXML
    void OnActionVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void OnActionViajar(ActionEvent event) throws IOException {
        Main.cidadeAtual = cidadeTroca;
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
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