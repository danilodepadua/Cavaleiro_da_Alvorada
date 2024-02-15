package com.daniel.Model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;

import java.io.Serializable;
import java.net.URL;

public class AudioPlayer implements Serializable {

    private MediaPlayer mediaPlayer;

    public void play(String audioPath, boolean loop) {
        if (mediaPlayer != null) {
            stop(); //acaba com a musica atual
        }

        URL audioUrl = getClass().getResource(audioPath);

        // debug
        if (audioUrl == null) {
            System.err.println("arquivo de audio nao encontrado: " + audioPath);
            return;
        }

        Media media = new Media(audioUrl.toString());
        mediaPlayer = new MediaPlayer(media);

        if (loop) {
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        }

        mediaPlayer.setVolume(1.0);
        mediaPlayer.setOnEndOfMedia(() -> {
        });
        mediaPlayer.play();
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
    }


    public void configVolume(double normalizedVolume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(normalizedVolume);
        }
    }


    public void somMouseClick(Button button, String audioPath) {
        button.setOnMouseClicked(event -> {
            play(audioPath, false);
        });
    }

}
