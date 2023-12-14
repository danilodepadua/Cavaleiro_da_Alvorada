package com.mygdx.game.Telas;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Camera.CameraStyles;
import com.mygdx.game.Components.MovementComponent;
import com.mygdx.game.Components.Systems.AnimationSystem;
import com.mygdx.game.Components.Systems.PlayerControllerSystem;
import com.mygdx.game.Entities.PlayerEntity;
import com.mygdx.game.Manejar.ManejarRecursos;
import com.mygdx.game.Mapas.FabricaDeMapa;
import com.mygdx.game.Mapas.ManejarMapa;
import com.mygdx.game.Mapas.Mapa;
import com.mygdx.game.Silenciados;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TelaJogo extends Tela{
    private static final Logger LOGGER = LoggerFactory.getLogger(TelaJogo.class);
    protected OrthogonalTiledMapRenderer rendezirarMapa = null;
    protected ManejarMapa manejarMapa;
    private Silenciados game;
    // Posições de início e fim do nível, largura e altura do nível
    public float inicioX;
    public float inicioY;
    public float larguraLevel;
    public float alturaLevel;
    public float fimX;
    public float fimY;
    private Entity Player;
    public OrthographicCamera camera;
    public static class VIEWPORT {
        static float viewportWidth;
        static float viewportHeight;
        private static float virtualWidth;
        private static float virtualHeight;
        private static float physicalWidth;
        private static float physicalHeight;
        private static float aspectRatio;
    }

    public TelaJogo(Silenciados app, ManejarRecursos manejarRecursos){
        // Chama o construtor da classe pai (BaseScreen)
        super(app, manejarRecursos);

        // Inicializa as variáveis necessárias
        game = app;
        manejarMapa = new ManejarMapa();

        // Configuração da câmera
        setupViewport(15, 15);
        // Obtém o tamanho atual e configura a câmera principal
        camera = new OrthographicCamera();
        camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);

        manejarMapa.setCamera(camera);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    static void setupViewport(int width, int height) {
        // Define a largura e altura virtual do viewport
        VIEWPORT.virtualWidth = width;
        VIEWPORT.virtualHeight = height;

        // Dimensões atuais do viewport
        VIEWPORT.viewportWidth = VIEWPORT.virtualWidth;
        VIEWPORT.viewportHeight = VIEWPORT.virtualHeight;

        // Dimensões físicas em pixels da tela
        VIEWPORT.physicalWidth = Gdx.graphics.getWidth();
        VIEWPORT.physicalHeight = Gdx.graphics.getHeight();

        // Razão de aspecto do viewport atual
        VIEWPORT.aspectRatio = (VIEWPORT.virtualWidth / VIEWPORT.virtualHeight);

        // Atualiza o viewport se houver possibilidade de distorção
        if (VIEWPORT.physicalWidth / VIEWPORT.physicalHeight >= VIEWPORT.aspectRatio) {
            // Adiciona barras pretas nas laterais
            VIEWPORT.viewportWidth = VIEWPORT.viewportHeight * (VIEWPORT.physicalWidth / VIEWPORT.physicalHeight);
            VIEWPORT.viewportHeight = VIEWPORT.virtualHeight;
        } else {
            // Adiciona barras pretas acima e abaixo
            VIEWPORT.viewportWidth = VIEWPORT.virtualWidth;
            VIEWPORT.viewportHeight = VIEWPORT.viewportWidth * (VIEWPORT.physicalHeight / VIEWPORT.physicalWidth);
        }
        LOGGER.debug("WorldRenderer: virtual: ({},{})", VIEWPORT.virtualWidth, VIEWPORT.virtualHeight);
        LOGGER.debug("WorldRenderer: viewport: ({},{})", VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);
        LOGGER.debug("WorldRenderer: physical: ({},{})", VIEWPORT.physicalWidth, VIEWPORT.physicalHeight);
    }
    @Override
    public void resize(int width, int height) {
        setupViewport(15, 15);
        camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);
    }

    @Override
    public void hide() {
        // Desativa o processador de entrada
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        super.dispose();
        if (rendezirarMapa != null) {
            rendezirarMapa.dispose();
        }
        FabricaDeMapa.clearCache();
    }
}