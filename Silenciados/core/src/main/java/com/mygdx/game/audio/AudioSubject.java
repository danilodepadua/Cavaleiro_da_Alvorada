package com.mygdx.game.audio;

// Interface para objetos que podem ser observados por eventos de áudio
public interface AudioSubject {

    // Adiciona um observador à lista de observadores
    void addObserver(AudioObserver audioObserver);

    // Remove um observador da lista de observadores
    void removeObserver(AudioObserver audioObserver);

    // Remove todos os observadores da lista
    void removeAllObservers();

    // Notifica todos os observadores sobre um comando de áudio e evento associado
    void notify(final AudioObserver.AudioCommand command, AudioObserver.AudioTypeEvent event);
}
