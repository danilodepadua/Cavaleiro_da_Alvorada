package com.mygdx.game.Components;

// Interface base para todos os componentes do jogo
public interface Component {

    // Token para separar mensagens
    String MESSAGE_TOKEN = ":::::";

    // Enumeração de tipos de mensagens que os componentes podem receber
    enum MESSAGE {
        CURRENT_POSITION,
        INIT_START_POSITION,
        RESET_POSITION,
        CURRENT_DIRECTION,
        CURRENT_STATE,
        COLLISION_WITH_MAP,
        COLLISION_WITH_ENTITY,
        COLLISION_WITH_FOE,
        LOAD_ANIMATIONS,
        INIT_DIRECTION,
        INIT_STATE,
        INIT_SELECT_ENTITY,
        ENTITY_SELECTED,
        ENTITY_DESELECTED,
        OPTION_INPUT
    }

    // Método para liberar recursos associados ao componente
    void dispose();

    // Método para receber mensagens específicas
    void receiveMessage(String message);
}
