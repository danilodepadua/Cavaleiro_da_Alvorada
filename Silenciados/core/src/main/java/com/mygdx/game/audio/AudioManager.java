package com.mygdx.game.audio;

import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Manager.PreferenceManager;
import com.mygdx.game.Manager.ResourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;

// Ótimo uso de pacotes para manter as coisas organizadas!

public class AudioManager implements AudioObserver {

    private static final Logger LOGGER = LoggerFactory.getLogger(AudioManager.class);

    private static AudioManager instance = null;

    private Music currentMusic;

    private Hashtable<String, Music> queuedMusic;

    // Construtor privado para garantir apenas uma instância da classe
    private AudioManager() {
        queuedMusic = new Hashtable<>();
    }

    // Método para obter a única instância da classe (Padrão de Design Singleton)
    public static AudioManager getInstance() {
        if (instance == null) {
            instance = new AudioManager();
        }

        return instance;
    }

    // Método para obter a música atualmente em reprodução
    public Music getCurrentMusic() {
        return currentMusic;
    }

    // Método para definir a música atual
    public void setCurrentMusic(Music currentMusic) {
        this.currentMusic = currentMusic;
    }

    // Método para verificar se a música está habilitada nas configurações e tomar ação adequada
    private void checkMusicEnabled(Music music) {
        if (!PreferenceManager.getInstance().isMusicEnabled()) {
            music.stop();
        } else {
            music.play();
        }
    }

    // Método para lidar com os comandos de áudio notificados
    @Override
    public void onNotify(AudioCommand command, AudioTypeEvent event) {
        switch (command) {
            case MUSIC_LOAD -> ResourceManager.loadMusicAsset(event.getValue());
            case MUSIC_PLAY_ONCE -> playMusic(false, event.getValue());
            case MUSIC_PLAY_LOOP -> playMusic(true, event.getValue());
            case MUSIC_STOP -> {
                Music music = queuedMusic.get(event.getValue());
                if (music != null) {
                    music.stop();
                }
            }
            case MUSIC_STOP_ALL -> {
                for (Music musicStop : queuedMusic.values()) {
                    musicStop.stop();
                }
            }
            default -> {
                // Comando não reconhecido
            }
        }
    }

    // Método para reproduzir música com opções de loop e arquivo de música
    private void playMusic(boolean isLooping, String fullFilePath) {
        Music music = queuedMusic.get(fullFilePath);
        if (music != null) {
            music.setLooping(isLooping);
            music.setVolume(PreferenceManager.getMusicVolume());
            checkMusicEnabled(music);
            setCurrentMusic(music);
        } else if (ResourceManager.isAssetLoaded(fullFilePath)) {
            music = ResourceManager.getMusicAsset(fullFilePath);
            music.setLooping(isLooping);
            music.setVolume(PreferenceManager.getMusicVolume());
            checkMusicEnabled(music);
            queuedMusic.put(fullFilePath, music);
            setCurrentMusic(music);
        } else {
            LOGGER.debug("Music not loaded");
        }
    }

    // Método para liberar recursos ao encerrar o aplicativo
    public void dispose() {
        for (Music music : queuedMusic.values()) {
            music.dispose();
        }
    }
}
