package com.daniel.PrimeiraCamada;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;

import java.net.URL;

public class AudioPlayer {

    private MediaPlayer mediaPlayer;


    public void play(String audioPath, boolean loop){
        stop();


        URL audioUrl = getClass().getResource(audioPath);

        // debug
        if(audioUrl == null){
            System.err.println("arquivo de audio nao encontrado");
            return;
        }

        Media media = new Media(audioUrl.toString());
        mediaPlayer = new MediaPlayer(media);

        if(loop == true){
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        }

        mediaPlayer.setVolume(1.0);
        mediaPlayer.play();

    }

    public void stop() {

        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.dispose();

        }
    }

    public void configVolume(double volume){

        if(mediaPlayer != null){
            mediaPlayer.setVolume(volume);
        }

    }

    public void somMouseClick(Button button, String audioPath) {
        button.setOnMouseClicked(event -> {
            play(audioPath, false);
        });
    }

}
