package com.mygdx.game.Components.Systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Components.AnimationComponent;
import com.mygdx.game.Components.ComponentMappers;
import com.mygdx.game.Components.GraphicsComponent;

public class AnimationSystem extends EntitySystem {

    public AnimationSystem(){

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        ImmutableArray<Entity> entities = getEngine().getEntitiesFor(Family.all(GraphicsComponent.class, AnimationComponent.class).get());
        for(Entity e: entities){
            AnimationComponent an = ComponentMappers.Animation.get(e);
            GraphicsComponent gf = ComponentMappers.Graphcs.get(e);
            an.Time+=deltaTime;
            gf.sprite = new Sprite(an.getCurrentAnimation().getKeyFrame(an.Time));
        }
    }
}
