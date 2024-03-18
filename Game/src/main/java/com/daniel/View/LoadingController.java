package com.daniel.View;

import com.daniel.game.Main;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.definirBackground;

public class LoadingController implements Initializable {
    @FXML
    private Rectangle barraCarregar;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private VBox vboxLoading;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vboxLoading.setAlignment(Pos.CENTER);
        animacaoLoading(barraCarregar);
        definirBackground(panePrincipal, Main.cidadeAtual.getCaminhoImagem());
    }

    public static void animacaoLoading(Rectangle rectangle) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), rectangle);
        scaleTransition.setFromX(0);
        scaleTransition.setToX(5); // Ajuste conforme necessário
        scaleTransition.setCycleCount(Timeline.INDEFINITE);
        scaleTransition.play();
    }

}
