package com.mygdx.game.Entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.*;

public class PlayerEntity extends Entity {
    public PlayerEntity(Texture texture, Vector2 vec){
        add(new EntityType());
        add(new TransformComponent(vec));
        add(new MovementComponent(5));
        add(new GraphicsComponent(texture));
        System.out.println("Fui Criado");
        System.out.println("Posição: x = " + this.getComponent(TransformComponent.class).position.x + ", Y = " + this.getComponent(TransformComponent.class).position.y);
    }
}
