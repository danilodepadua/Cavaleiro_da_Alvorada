package com.mygdx.game.Entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Components.*;
import com.mygdx.game.Utilities.AnimationMaker;

public class PlayerEntity extends Entity {
    public PlayerEntity(Vector2 vec){
        Array<Animation<TextureRegion>> Animations = new Array<>();
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_down idle.png"), 2,4, 5));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_down walk.png"), 2,4, 6));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_up idle.png"), 2,4, 5));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_up walk.png"), 2,4, 6));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_side idle.png"), 2,4, 5));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_side walk.png"), 2,4, 6));
        add(new EntityType(EntityType.Types.Player));
        add(new TransformComponent(vec, 2.5f));
        add(new MovementComponent(100));
        add(new GraphicsComponent());
        add(new AnimationComponent(Animations));
        System.out.println("Fui Criado");
        System.out.println("Posição: x = " + this.getComponent(TransformComponent.class).position.x + ", Y = " + this.getComponent(TransformComponent.class).position.y);
    }
}
