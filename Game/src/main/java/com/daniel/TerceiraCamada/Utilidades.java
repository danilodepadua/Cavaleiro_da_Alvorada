package com.daniel.TerceiraCamada;

import com.daniel.game.Main;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Utilidades {
    public static void contornarBotaoVoltar(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: transparent; -fx-background-radius: 100; -fx-border-color:  #eccb7e;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: transparent; -fx-background-radius: 100; -fx-border-color: transparent;");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color: transparent; -fx-background-radius: 100; -fx-border-color:  #eccb7e; -fx-opacity: 0.7;");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color: transparent; -fx-background-radius: 100; -fx-border-color: transparent;");
        });
    }

    public static void configurarBotoes(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color:   #241811; -fx-border-color: #ADD8E6;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e;");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e; -fx-opacity: 0.7;");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e;");
        });

    }
    public static void definirBackground(AnchorPane pane, String caminhoDaImagem){
        pane.setBackground(new Background(new BackgroundImage(new Image(Main.class.getResource(caminhoDaImagem).toString()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        true
                ))));
    }
    public static void configurarEstiloLabel(Label... labels) {
        for (Label label : labels) {
            label.setBackground(new Background(new BackgroundFill(Color.web("#241811"), new CornerRadii(5), Insets.EMPTY)));
            label.setPadding(new Insets(5));
        }
    }

    // Método para configurar o evento de MouseEntered para uma ImageView
    public static void configurarEventoMouseEntered(ImageView imageView, Label label, String informacao) {
        imageView.setOnMouseEntered(event -> mostrarInformacao(event, label, informacao));
    }

    // Método para configurar o evento de MouseExited para uma ImageView
    public static void configurarEventoMouseExited(ImageView imageView, Label label) {
        imageView.setOnMouseExited(event -> label.setVisible(false));
        label.setOpacity(1);
    }

    // Método genérico para mostrar a informação
    public static void mostrarInformacao(MouseEvent event, Label label, String informacao) {
        label.setText(informacao);
        label.setVisible(true);
    }
    public static void estiloBotao(Button button) {
        button.setStyle("-fx-background-color:  #241811; -fx-min-width: 200; -fx-min-height: 50; -fx-background-insets: 0; -fx-background-radius: 0; -fx-border-width: 1; -fx-focus-traversable: false; -fx-border-color: #eccb7e; -fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
    }

    public static void configurarBotoesTelaCidade(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color:   #241811; -fx-border-color: #ADD8E6;-fx-min-width: 200; -fx-min-height: 50;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e;-fx-min-width: 200; -fx-min-height: 50;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e; -fx-opacity: 0.7;-fx-min-width: 200; -fx-min-height: 50;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e;-fx-min-width: 200; -fx-min-height: 50;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
        });

    }
    public static void configurarBotoesTelaBestiario(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color:    #140e0a; -fx-border-color: #ADD8E6;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 15;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color:   #140e0a; -fx-border-color: #eccb7e;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 15;");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color:   #140e0a; -fx-border-color: #eccb7e; -fx-opacity: 0.7;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 15;");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color:   #140e0a; -fx-border-color: #eccb7e;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 15;");
        });

    }

    public static void contornarBotaoVoltarLoja(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle(" -fx-border-color:  #eccb7e; -fx-background-color: #140e0a ");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-border-color: transparent;-fx-background-color: #140e0a");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-border-color:  #eccb7e; -fx-opacity: 0.7;-fx-background-color: #140e0a");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-border-color: transparent;-fx-background-color: #140e0a");
        });
    }



}
