package com.mygdx.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GraphicsComponent implements Component {
    public Sprite sprite;

    public GraphicsComponent(Texture texture) {
        this.sprite = new Sprite(texture);
    }
}
