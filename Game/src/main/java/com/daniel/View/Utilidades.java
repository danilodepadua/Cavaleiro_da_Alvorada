package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.AudioPlayer;
import com.daniel.game.Main;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Utilidades {
    private static AudioPlayer audioPlayer = new AudioPlayer();
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
        audioPlayer.somMouseClick(button, "/com.daniel.audios/som_click.wav");

        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #ADD8E6;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #eccb7e;");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #eccb7e; -fx-opacity: 0.7;");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #eccb7e;");
        });

    }
    public static void configurarBotoesResultado(Button button) {
        audioPlayer.somMouseClick(button, "/com.daniel.audios/som_click.wav");

        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #ADD8E6;-fx-font-family: 'Barlow Condensed SemiBold'; -fx-text-fill: #eccb7e");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #eccb7e;-fx-font-family: 'Barlow Condensed SemiBold'; -fx-text-fill: #eccb7e");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #eccb7e; -fx-opacity: 0.7;-fx-font-family: 'Barlow Condensed SemiBold'; -fx-text-fill: #eccb7e");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #eccb7e;-fx-font-family: 'Barlow Condensed SemiBold'; -fx-text-fill: #eccb7e");
        });

    }
    public static void configurarBotoesMapa(Button button) {
        audioPlayer.somMouseClick(button, "/com.daniel.audios/som_click.wav");

        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #ADD8E6; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17; -fx-text-fill: #eccb7e;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17; -fx-text-fill: #eccb7e;");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #eccb7e; -fx-opacity: 0.7; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17; -fx-text-fill: #eccb7e;");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color: #241811; -fx-border-color: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17; -fx-text-fill: #eccb7e;");
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
        button.setStyle("-fx-background-color:  #241811; -fx-background-insets: 0; -fx-background-radius: 0; -fx-border-width: 1; -fx-focus-traversable: false; -fx-border-color: #eccb7e; -fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
    }

    public static void configurarBotoesTelaCidade(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color:   #241811; -fx-border-color: #ADD8E6;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e; -fx-opacity: 0.7;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e;-fx-text-fill: #eccb7e; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 17;");
        });
        button.setOnMouseClicked(event -> {
            JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_click.wav");
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
        button.setOnMouseClicked(event -> {
            JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_click.wav");
        });
    }

    public static void configurarBotoesTelaResultado(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color:   #241811; -fx-border-color: #ADD8E6; -fx-min-width: 200; -fx-font-size: 17; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-min-height: 50;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e; -fx-min-width: 200; -fx-font-size: 17; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-min-height: 50;");
        });

        button.setOnMousePressed(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e; -fx-opacity: 0.7; -fx-min-width: 200; -fx-font-size: 17; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-min-height: 50;");
        });

        button.setOnMouseReleased(event -> {
            button.setStyle("-fx-background-color:  #241811; -fx-border-color: #eccb7e; -fx-min-width: 200; -fx-font-size: 17; -fx-font-family: 'Barlow Condensed SemiBold'; -fx-min-height: 50;" );
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
    public static void adicionarCaracteresComAtraso(String mensagem, Text texto, Runnable onCompletion) {
        Timeline timeline = new Timeline();
        double time = 50;
        texto.setText("");
        // Adiciona KeyFrames para cada caractere com atraso
        for (int i = 0; i < mensagem.length(); i++) {
            final int finalI = i;

            // Adiciona um KeyFrame para adicionar o caractere
            timeline.getKeyFrames().add(new KeyFrame(
                    Duration.millis(time),
                    event -> {
                        texto.setText(texto.getText() + mensagem.charAt(finalI));
                        JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_beep2.wav");
                    }));

            // Adiciona um KeyFrame para limpar o texto se for o último caractere da mensagem
            if (finalI == mensagem.length() - 1) {
                time += 1000;
                timeline.getKeyFrames().add(new KeyFrame(Duration.millis(time), event -> {
                    texto.setText("");  // Limpa o Text ao final da animação
                    // Chama o evento de conclusão quando a animação estiver concluída
                    onCompletion.run();
                }));
            }

            // Incrementa o tempo para o próximo caractere
            time += 100;
        }

        // Inicia a animação
        timeline.play();
    }
    public static void adicionarCaracteresComAtrasoCredito(String mensagem, Text texto, Runnable onCompletion) {
        Timeline timeline = new Timeline();
        double time = 50;
        texto.setText("");
        // Adiciona KeyFrames para cada caractere com atraso
        for (int i = 0; i < mensagem.length(); i++) {
            final int finalI = i;

            // Adiciona um KeyFrame para adicionar o caractere
            timeline.getKeyFrames().add(new KeyFrame(
                    Duration.millis(time),
                    event -> {
                        texto.setText(texto.getText() + mensagem.charAt(finalI));
                    }));

            // Adiciona um KeyFrame para limpar o texto se for o último caractere da mensagem
            if (finalI == mensagem.length() - 1) {
                time += 1000;
                timeline.getKeyFrames().add(new KeyFrame(Duration.millis(time), event -> {
                    texto.setText("");  // Limpa o Text ao final da animação
                    // Chama o evento de conclusão quando a animação estiver concluída
                    onCompletion.run();
                }));
            }

            // Incrementa o tempo para o próximo caractere
            time += 100;
        }

        // Inicia a animação
        timeline.play();
    }
    public static void mostrarResultado(String mensagem, Text text, AnchorPane anchorPane) {
        text.setText(mensagem);

        // Animação de fade-in
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), anchorPane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        // Animação de fade-out
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), anchorPane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setDelay(Duration.seconds(2));

        // Combinação das animações
        SequentialTransition sequence = new SequentialTransition(fadeIn, fadeOut);

        // Inicia a sequência de animação
        sequence.play();
    }
    public static Font loadFont() {
        return Font.loadFont(Main.class.getResourceAsStream("/com/daniel/game/BarlowCondensed-SemiBold.ttf"), 14);
    }

    public static void identificarTextos(AnchorPane anchorPane) {
        for (javafx.scene.Node node : anchorPane.getChildren()) {
            if (node instanceof Text) {
                Text texto = (Text) node;
                texto.setFont(loadFont());
            } else if (node instanceof  Button) {
                Button button = (Button) node;
                button.setFont(loadFont());
            }
        }
    }
    public static void AlinharHorizontal(Node node, Double margemDir ){
        node.setLayoutX((Main.getLargura()*margemDir) - (node.getBoundsInLocal().getWidth()/2));
    }
    public static void AlinharVertical(Node node, Double margemTopo ){
        node.setLayoutY((Main.getAltura()*margemTopo) - (node.getBoundsInLocal().getHeight()/2));
    }
}
