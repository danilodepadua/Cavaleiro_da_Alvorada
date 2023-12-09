package com.mygdx.game.Components.Systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.ComponentMappers;
import com.mygdx.game.Components.GraphicsComponent;

public class RenderingSystem extends EntitySystem {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private ComponentMapper<GraphicsComponent> graphicsMapper = ComponentMapper.getFor(GraphicsComponent.class);

    public RenderingSystem(SpriteBatch batch, OrthographicCamera camera) {
        this.batch = batch;
        this.camera = camera;
    }

    @Override
    public void update(float deltaTime) {
        ImmutableArray<com.badlogic.ashley.core.Entity> entities = getEngine().getEntitiesFor(Family.all(GraphicsComponent.class).get());
        camera.update();
        batch.begin();

        for (com.badlogic.ashley.core.Entity entity : entities) {
            GraphicsComponent graphics = graphicsMapper.get(entity);
            graphics.sprite.setPosition(ComponentMappers.Colliders.get(entity).body.getPosition().x, ComponentMappers.Colliders.get(entity).body.getPosition().y);
            graphics.sprite.setScale(ComponentMappers.Transforms.get(entity).Scale);
            if(graphics.flipY){
                graphics.sprite.setFlip(true, false);
            }
            else{
                graphics.sprite.setFlip(false, false);
            }
            // Renderize o sprite da entidade
            graphics.sprite.draw(batch);
        }

        batch.end();
    }
}