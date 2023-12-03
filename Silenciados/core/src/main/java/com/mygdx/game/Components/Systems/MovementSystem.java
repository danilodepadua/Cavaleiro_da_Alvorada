package com.mygdx.game.Components.Systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.mygdx.game.Components.MovementComponent;
import com.mygdx.game.Components.TransformComponent;

public class MovementSystem extends EntitySystem {
    private final Family family = Family.all(TransformComponent.class, MovementComponent.class).get();

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
            TransformComponent position = entity.getComponent(TransformComponent.class);
            MovementComponent control = entity.getComponent(MovementComponent.class);

            // Atualiza a posição com base nos controles (apenas um exemplo)
            if (control.left) {
                position.position.x -= deltaTime * control.Speed;
            }
            if (control.right) {
                position.position.x += deltaTime * control.Speed;
            }
            if (control.up) {
                position.position.y += deltaTime * control.Speed;
            }
            if (control.down) {
                position.position.y -= deltaTime * control.Speed;
            }
        }
    }
}