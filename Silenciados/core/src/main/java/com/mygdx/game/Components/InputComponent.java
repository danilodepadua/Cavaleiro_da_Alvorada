package com.mygdx.game.Components;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.Entities.Entity;

import java.util.HashMap;
import java.util.Map;

public abstract class InputComponent extends ComponentSubject implements Component, InputProcessor {

    protected Entity.Direction currentDirection = null;
    protected Entity.State currentState = null;
    protected Json json;

    protected enum Keys {
        LEFT, RIGHT, UP, DOWN, QUIT, INTERACT, OPTION
    }

    protected enum Mouse {
        SELECT, DOACTION
    }

    // Mapas para rastrear o estado das teclas e botões do mouse
    protected static Map<Keys, Boolean> keys = new HashMap<>();
    protected static Map<Mouse, Boolean> mouseButtons = new HashMap<>();

    // Inicialização dos mapas
    static {
        keys.put(Keys.LEFT, false);
        keys.put(Keys.RIGHT, false);
        keys.put(Keys.UP, false);
        keys.put(Keys.DOWN, false);
        keys.put(Keys.QUIT, false);
        keys.put(Keys.INTERACT, false);
        keys.put(Keys.OPTION, false);
    }

    static {
        mouseButtons.put(Mouse.SELECT, false);
        mouseButtons.put(Mouse.DOACTION, false);
    }

    // Construtor padrão inicializando o objeto Json
    public InputComponent() {
        json = new Json();
    }

    public abstract void update(Entity entity, float delta);

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

}
