package com.mygdx.game.Entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Components.*;

public class PlayerEntity extends Entity {
    public PlayerEntity(Texture texture){
        add(new EntityType());
        add(new TransformComponent());
        add(new MovementComponent(5));
        add(new GraphicsComponent(texture));
        System.out.println("Fui Criado");
        System.out.println("Posição: x = " + this.getComponent(TransformComponent.class).position.x + ", Y = " + this.getComponent(TransformComponent.class).position.y);
    }
}
