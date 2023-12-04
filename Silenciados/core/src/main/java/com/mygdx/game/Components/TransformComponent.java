package com.mygdx.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;

public class TransformComponent implements Component {
    public Vector2 position = new Vector2();
    public Quaternion Rotation = new Quaternion();

    public TransformComponent(Vector2 vec){
        position = vec;
    }
}
