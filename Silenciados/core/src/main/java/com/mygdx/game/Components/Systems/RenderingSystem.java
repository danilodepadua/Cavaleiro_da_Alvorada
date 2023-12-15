package com.mygdx.game.Components.Systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.ComponentMappers;
import com.mygdx.game.Components.GraphicsComponent;

public class RenderingSystem extends EntitySystem {
    public static final float ppm = 32f;
    public static final float FRUSTUM_WIDTH = Gdx.graphics.getWidth()/ppm;
    public static final float FRUSTUM_HEIGHT = Gdx.graphics.getHeight()/ppm;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private ComponentMapper<GraphicsComponent> graphicsMapper = ComponentMapper.getFor(GraphicsComponent.class);

    public RenderingSystem(SpriteBatch batch, OrthographicCamera Camera) {
        this.batch = batch;
        this.camera = Camera;
        this.camera.position.set(FRUSTUM_WIDTH / 2f, FRUSTUM_HEIGHT / 2f, 0);
    }

    @Override
    public void update(float deltaTime) {
        ImmutableArray<com.badlogic.ashley.core.Entity> entities = getEngine().getEntitiesFor(Family.all(GraphicsComponent.class).get());
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.enableBlending();
        batch.begin();

        for (com.badlogic.ashley.core.Entity entity : entities) {
            GraphicsComponent graphics = graphicsMapper.get(entity);
            graphics.sprite.setPosition(ComponentMappers.Colliders.get(entity).body.getPosition().x*ppm, ComponentMappers.Colliders.get(entity).body.getPosition().y*ppm);
            graphics.sprite.setScale(ComponentMappers.Transforms.get(entity).Scale/ppm);
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