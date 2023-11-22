package com.mygdx.game.Components;

// Interface para observadores de eventos de componentes
public interface ComponentObserver {

    // Enumeração de eventos de componentes que podem ser observados
    enum ComponentEvent {
        LOAD_CONVERSATION,
        SHOW_CONVERSATION,
        HIDE_CONVERSATION,
        LOAD_RESUME,
        SHOW_RESUME,
        QUEST_LOCATION_DISCOVERED,
        ENEMY_SPAWN_LOCATION_CHANGED,
        START_BATTLE,
        OPTION_INPUT
    }

    // Método chamado quando há notificação de um evento de componente
    void onNotify(final String value, ComponentEvent event);
}
