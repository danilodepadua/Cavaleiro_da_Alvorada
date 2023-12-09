package com.mygdx.game.Components.Systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.mygdx.game.Components.ColliderComponent;
import com.mygdx.game.Components.MovementComponent;
import com.mygdx.game.Components.TransformComponent;

public class MovementSystem extends EntitySystem {
    private final Family family = Family.all(ColliderComponent.class, MovementComponent.class).get();

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        // Obtém todas as entidades com os componentes necessários
        ImmutableArray<Entity> entities = getEngine().getEntitiesFor(family);

        for (Entity entity : entities) {
            ColliderComponent position = entity.getComponent(ColliderComponent.class);
            MovementComponent control = entity.getComponent(MovementComponent.class);

            // Atualiza a posição com base nos controles (apenas um exemplo)
            if (control.left) {
                position.body.setLinearVelocity(-control.Speed*10,position.body.getLinearVelocity().y);
            }
            else if (control.right) {
                position.body.setLinearVelocity(control.Speed*10,position.body.getLinearVelocity().y);
            }
            else {
                position.body.setLinearVelocity(0,position.body.getLinearVelocity().y);
            }
            if (control.up) {
                position.body.setLinearVelocity(position.body.getLinearVelocity().x,control.Speed*10);
            }
            else if (control.down) {
                position.body.setLinearVelocity(position.body.getLinearVelocity().x,-control.Speed*10);
            }
            else{
                position.body.setLinearVelocity(position.body.getLinearVelocity().x,0);
            }
        }
    }
}