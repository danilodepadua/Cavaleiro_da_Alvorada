package com.mygdx.game.audio;

// Interface para observadores de eventos de áudio
public interface AudioObserver {

    // Enumeração para os tipos de eventos de áudio
    enum AudioTypeEvent {
        MENU_THEME("music/Rising_Sun.mp3"),
        TOPPLE_THEME("music/Village.mp3"),
        TEST_THEME("music/Dwarves'_Theme.mp3"),
        BATTLE_THEME("music/Challenge.mp3"),
        GAME_OVER_THEME("music/Requiem.mp3"),
        NONE("");

        private String audioFullFilePath;

        // Construtor privado para associar caminho do arquivo de áudio a cada enum
        AudioTypeEvent(String audioFullFilePath) {
            this.audioFullFilePath = audioFullFilePath;
        }

        // Método para obter o caminho completo do arquivo de áudio
        public String getValue() {
            return audioFullFilePath;
        }
    }

    // Enumeração para comandos relacionados a áudio
    enum AudioCommand {
        MUSIC_LOAD,
        MUSIC_PLAY_ONCE,
        MUSIC_PLAY_LOOP,
        MUSIC_STOP,
        MUSIC_STOP_ALL
    }

    // Método chamado quando há notificação de um evento de áudio
    void onNotify(AudioCommand command, AudioTypeEvent event);
}
