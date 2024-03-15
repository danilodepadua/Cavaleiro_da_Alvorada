package com.daniel.Model;

import com.daniel.game.Main;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioClip;
import javafx.scene.control.Button;

import java.io.Serializable;

public class AudioPlayer implements Serializable {

    private MediaPlayer mediaPlayer;
    private AudioClip audioClip;

    private void stop() {
        if (mediaPlayer != null) {
            System.out.println("Parando musica");
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
    }

    public void PlayLoop(String pathItroducao, String pathLoop){
        stop();
        Media midia = new Media(Main.class.getResource(pathItroducao).toString());
        mediaPlayer = new MediaPlayer(midia);
        mediaPlayer.setOnEndOfMedia(() -> {
            Media midiaLoop = new Media(Main.class.getResource(pathLoop).toString());
            mediaPlayer = new MediaPlayer(midiaLoop);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        });
        mediaPlayer.play();
    }
    public void PlayLoop(String loop){
        stop();
        Media midia = new Media(Main.class.getResource(loop).toString());
        mediaPlayer = new MediaPlayer(midia);
        mediaPlayer.play();
    }
    public void PlayEfeito(String pathEfeito){
        audioClip = new AudioClip(Main.class.getResource(pathEfeito).toString());
        audioClip.play();
    }

    public void configVolume(double normalizedVolume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(normalizedVolume);
        }
    }


    public void somMouseClick(Button button, String audioPath) {
        button.setOnMouseClicked(event -> {
            PlayEfeito(audioPath);
        });
    }

}
