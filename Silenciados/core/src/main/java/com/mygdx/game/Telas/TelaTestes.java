package com.mygdx.game.Telas;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Components.Systems.*;
import com.mygdx.game.Entities.PlayerEntity;

public class TelaTestes implements Screen {

    public static class VIEWPORT {
        static float viewportWidth;
        static float viewportHeight;
        private static float virtualWidth;
        static float virtualHeight;
        static float physicalWidth;
        static float physicalHeight;
        static float aspectRatio;
    }
    private World world;
    private Box2DDebugRenderer DebugRenderer;
    private OrthographicCamera Camera;
    private Engine engine;
    private SpriteBatch batch;

    public TelaTestes(SpriteBatch bat){
        this.world = new World(new Vector2(0,0), true);
        this.DebugRenderer = new Box2DDebugRenderer();
        setupViewport(32, 24);
        this.Camera = new OrthographicCamera();
        this.engine = new Engine();
        this.batch = bat;
        this.Camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);
        engine.addSystem(new AnimationSystem());
        engine.addSystem(new MovementSystem());
        engine.addSystem(new RenderingSystem(batch, Camera));
        engine.addEntity(new PlayerEntity(new Vector2(Camera.position.x,Camera.position.y), this.world));
        engine.addSystem(new PlayerControllerSystem());
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1); // Cor preta para limpar a tela
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        engine.update(delta);
        world.step(delta,6,3);
        DebugRenderer.render(world,Camera.combined);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    private static void setupViewport(float width, float height) {
        VIEWPORT.virtualWidth = width;
        VIEWPORT.virtualHeight = height;

        VIEWPORT.viewportWidth = VIEWPORT.virtualWidth;
        VIEWPORT.viewportHeight = VIEWPORT.virtualHeight;

        VIEWPORT.physicalWidth = Gdx.graphics.getWidth();
        VIEWPORT.physicalHeight = Gdx.graphics.getHeight();

        VIEWPORT.aspectRatio = VIEWPORT.virtualWidth / VIEWPORT.virtualHeight;

        if (VIEWPORT.physicalWidth / VIEWPORT.physicalHeight >= VIEWPORT.aspectRatio) {
            VIEWPORT.viewportWidth = VIEWPORT.viewportHeight * (VIEWPORT.physicalWidth / VIEWPORT.physicalHeight);
            VIEWPORT.viewportHeight = VIEWPORT.virtualHeight;
        } else {
            VIEWPORT.viewportWidth = VIEWPORT.virtualWidth;
            VIEWPORT.viewportHeight = VIEWPORT.viewportWidth * (VIEWPORT.physicalHeight / VIEWPORT.physicalWidth);
        }

        // Agora, VIEWPORT.viewportWidth e VIEWPORT.viewportHeight estão em metros
        // Restante do código...
    }
}
