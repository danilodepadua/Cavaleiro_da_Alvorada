package com.daniel.PrimeiraCamada;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioPlayer {

    private Clip clip;


    public void play(String audioPath, boolean loop){
        stop();

        try{
            URL audioUrl = getClass().getResource(audioPath);

            // debug
            if(audioUrl == null){
                System.err.println("arquivo de audio nao encontrado");
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioUrl);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            if(loop == true){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){

            e.printStackTrace();
        }


    }

    public void stop() {

        if(clip != null && clip.isRunning()){
            clip.stop();
            clip.close();

        }


    }

    public void somMouseClick(Button button, String audioPath) {
        button.setOnMouseClicked(event -> {
            play(audioPath, false);
        });
    }

}
