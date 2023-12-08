package com.mygdx.game.Components.Systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Components.AnimationComponent;
import com.mygdx.game.Components.EntityType;
import com.mygdx.game.Components.GraphicsComponent;
import com.mygdx.game.Components.MovementComponent;

public class PlayerControllerSystem extends EntitySystem {
    @Override
    public void update(float deltatime){
        super.update(deltatime);
        ImmutableArray<Entity> entities = getEngine().getEntitiesFor(Family.all(EntityType.class).get());
        for(Entity Player: entities) {
            if(Player.getComponent(EntityType.class).type == EntityType.Types.Player){
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    Player.getComponent(MovementComponent.class).up = true;
                    Player.getComponent(AnimationComponent.class).ChangeAnimation(3);
                } else {
                    Player.getComponent(MovementComponent.class).up = false;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                    Player.getComponent(MovementComponent.class).down = true;
                    Player.getComponent(AnimationComponent.class).ChangeAnimation(1);
                } else {
                    Player.getComponent(MovementComponent.class).down = false;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    Player.getComponent(MovementComponent.class).left = true;
                    Player.getComponent(AnimationComponent.class).ChangeAnimation(5);
                    Player.getComponent(GraphicsComponent.class).flipY = false;
                } else {
                    Player.getComponent(MovementComponent.class).left = false;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    Player.getComponent(MovementComponent.class).right = true;
                    Player.getComponent(AnimationComponent.class).ChangeAnimation(5);
                    Player.getComponent(GraphicsComponent.class).flipY = true;
                } else {
                    Player.getComponent(MovementComponent.class).right = false;
                }
                if(!Player.getComponent(MovementComponent.class).up && !Player.getComponent(MovementComponent.class).down && !Player.getComponent(MovementComponent.class).right && !Player.getComponent(MovementComponent.class).left){
                    int i = Player.getComponent(AnimationComponent.class).currentAnimationIndex;
                    if(i == 1){
                        Player.getComponent(AnimationComponent.class).ChangeAnimation(0);
                    }
                    else if(i == 3){
                        Player.getComponent(AnimationComponent.class).ChangeAnimation(2);
                    }
                    else if(i == 5){
                        Player.getComponent(AnimationComponent.class).ChangeAnimation(4);
                    }
                }
            }
        }
    }
}
