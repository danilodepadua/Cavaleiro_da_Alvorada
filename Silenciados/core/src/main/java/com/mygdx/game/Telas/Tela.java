package com.mygdx.game.Telas;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Components.Systems.MovementSystem;
import com.mygdx.game.Manejar.ManejarRecursos;
import com.mygdx.game.Silenciados;

import java.util.ArrayList;
import java.util.List;

public class Tela implements Screen {
    protected final Silenciados gdxGame;
    protected ManejarRecursos resourceManager;
    protected OrthographicCamera gameCam;
    protected OrthographicCamera battleCam;
    // viewport that keeps aspect ratios of the game when resizing
    protected Viewport viewport;
    // main stage of each screen
    protected Stage stage;

    public Tela(Silenciados gdxGame, ManejarRecursos resourceManager) {
        this.gdxGame = gdxGame;
        this.resourceManager = resourceManager;


/*
        CameraManager cameraManager = new CameraManager();
        gameCam = cameraManager.createCamera(Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/3, .4f);
        battleCam = cameraManager.createCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        // the game will retain it's scaled dimensions regardless of resizing
        viewport = new StretchViewport(gameCam.viewportWidth, gameCam.viewportHeight, gameCam);
        stage = new Stage(viewport, gdxGame.getBatch());*/
    }


    public Table createTable() {
        Table table = new Table();
        table.setBounds(0,0, (float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
        return table;
    }


    @Override
    public void show() {
        // Nothing
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // Nothing
    }

    @Override
    public void pause() {
        // Nothing
    }

    @Override
    public void resume() {
        // Nothing
    }

    @Override
    public void hide() {
        // Nothing
    }

    @Override
    public void dispose() {
        //stage.dispose();
    }

    public OrthographicCamera getGameCam() {
        return gameCam;
    }

    public OrthographicCamera getBattleCam() {
        return battleCam;
    }

    public Stage getStage() {
        return stage;
    }
}
