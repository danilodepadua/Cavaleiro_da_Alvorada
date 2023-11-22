package com.mygdx.game.Telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Manager.ResourceManager;
import com.mygdx.game.SilenciadosApp;
import com.mygdx.game.Telas.transition.effects.TransitionEffect;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.audio.AudioObserver;
import com.mygdx.game.audio.AudioSubject;

import java.util.ArrayList;
import java.util.List;

public class BaseScreen implements Screen, AudioSubject {
    protected final SilenciadosApp gdxGame;
    protected ResourceManager resourceManager;
    protected OrthographicCamera gameCam;
    protected OrthographicCamera battleCam;
    // viewport that keeps aspect ratios of the game when resizing
    protected Viewport viewport;
    // main stage of each screen
    protected Stage stage;
    protected AudioObserver.AudioTypeEvent musicTheme;

    private Array<AudioObserver> observers;

    public BaseScreen(SilenciadosApp gdxGame, ResourceManager resourceManager) {
        this.gdxGame = gdxGame;
        this.resourceManager = resourceManager;

        observers = new Array<>();
        this.addObserver(AudioManager.getInstance());
/*
        CameraManager cameraManager = new CameraManager();
        gameCam = cameraManager.createCamera(Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/3, .4f);
        battleCam = cameraManager.createCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        // the game will retain it's scaled dimensions regardless of resizing
        viewport = new StretchViewport(gameCam.viewportWidth, gameCam.viewportHeight, gameCam);
        stage = new Stage(viewport, gdxGame.getBatch());*/
    }

    public AudioObserver.AudioTypeEvent getMusicTheme() {
        return musicTheme;
    }

    public void setScreenWithTransition(BaseScreen current, BaseScreen next, List<TransitionEffect> transitionEffect) {
        ArrayList<TransitionEffect> effects = new ArrayList<>(transitionEffect);

        Screen transitionScreen = new TransitionScreen(gdxGame, current, next, effects);
        gdxGame.setScreen(transitionScreen);
    }

    public void createButton(String buttonName, float posX, float posY, Table table) {
        TextureRegion[][] playButtons = resourceManager.button;

        BitmapFont pixel10 = resourceManager.pixel10;

        TextureRegionDrawable imageUp = new TextureRegionDrawable(playButtons[0][0]);
        TextureRegionDrawable imageDown = new TextureRegionDrawable(playButtons[1][0]);

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle(imageUp, imageDown, null, pixel10);
        TextButton button = new TextButton(buttonName, buttonStyle);
        button.getLabel().setColor(new Color(79 / 255.f, 79 / 255.f, 117 / 255.f, 1));

        table.add(button).padLeft(posX).padTop(posY);
        table.row();
    }

    public void criaBotao(String buttonName, float posX, float posY, float width, float height, Color buttonColor, Table table) {
        BitmapFont pixel10 = resourceManager.pixel10;

        // Crie o estilo do botão sem textura
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.up = new TextureRegionDrawable();  // Textura quando o botão não está pressionado
        buttonStyle.down = new TextureRegionDrawable();  // Textura quando o botão está pressionado
        buttonStyle.font = pixel10;  // Fonte do texto (mesmo que não haja texto)

        TextButton button = new TextButton("", buttonStyle);  // Criar botão sem texto
        button.getLabel().setColor(buttonColor);  // Definir a cor do texto

        // Definir o tamanho do botão
        button.setSize(width, height);

        table.add(button).padLeft(posX).padTop(posY);
        table.row();
    }


    public Table createTable() {
        Table table = new Table();
        table.setBounds(0,0, (float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
        return table;
    }

    @Override
    public void addObserver(AudioObserver audioObserver) {
        observers.add(audioObserver);
    }

    @Override
    public void removeObserver(AudioObserver audioObserver) {
        observers.removeValue(audioObserver, true);
    }

    @Override
    public void removeAllObservers() {
        observers.removeAll(observers, true);
    }

    @Override
    public void notify(AudioObserver.AudioCommand command, AudioObserver.AudioTypeEvent event) {
        for(AudioObserver observer: observers){
            observer.onNotify(command, event);
        }
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
