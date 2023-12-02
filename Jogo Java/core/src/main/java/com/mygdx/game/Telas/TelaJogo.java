package com.mygdx.game.Telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.Camera.CameraStyles;
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
    private static GameState gameState;
    private Silenciados game;
    // Posições de início e fim do nível, largura e altura do nível
    private float inicioX;
    private float inicioY;
    private float larguraLevel;
    private float alturaLevel;
    private float fimX;
    private float fimY;
    protected OrthographicCamera camera;
    public static class VIEWPORT {
        private static float viewportWidth;
        private static float viewportHeight;
        private static float virtualWidth;
        private static float virtualHeight;
        private static float physicalWidth;
        private static float physicalHeight;
        private static float aspectRatio;
    }
    private InputMultiplexer multiplexer;

    public enum GameState {
        SAVING,
        LOADING,
        RUNNING,
        PAUSED,
        GAME_OVER
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
        // Inicializa o renderizador de mapa se ainda não estiver inicializado
        if (rendezirarMapa == null) {
            rendezirarMapa = new OrthogonalTiledMapRenderer(manejarMapa.getAtualMapaTiled(), Mapa.UNIDADE_ESCALA);
        }
    }

    @Override
    public void render(float delta) {
        // Configuração do OpenGL para limpar o buffer de cores
        Gdx.gl.glClearColor(0, 0, 0, 1); // Cor preta para melhor contraste com o mapa
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Simplifica a atualização da câmera para centralizar no mapa
        camera.position.set(larguraLevel * ManejarRecursos.TAMANHO_BLOCO * Mapa.UNIDADE_ESCALA / 2,
                alturaLevel * ManejarRecursos.TAMANHO_BLOCO * Mapa.UNIDADE_ESCALA / 2,
                0f);
        camera.update();

        rendezirarMapa.setView(camera);

        // Configura o modo de mistura para lidar com transparência
        rendezirarMapa.getBatch().enableBlending();
        rendezirarMapa.getBatch().setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        // Verifica se o mapa foi alterado
        if (manejarMapa.mapaAlterado()) {
            // Atualiza o renderizador de mapa e a posição da câmera
            rendezirarMapa.setMap(manejarMapa.getAtualMapaTiled());

            camera.position.set(manejarMapa.getPlayerStartUnitScaled().x, manejarMapa.getPlayerStartUnitScaled().y, 0f);

            camera.update();
            manejarMapa.setTrocaMapa(false);
        }
        // Renderiza o mapa
        rendezirarMapa.render();

        // Configura as bordas da câmera para evitar que ultrapasse os limites do mapa
        inicioX = camera.viewportWidth / 2;
        inicioY = camera.viewportHeight / 2;
        larguraLevel = manejarMapa.getAtualMapaTiled().getProperties().get("width", Integer.class);
        alturaLevel = manejarMapa.getAtualMapaTiled().getProperties().get("height", Integer.class);
        fimX = larguraLevel * ManejarRecursos.TAMANHO_BLOCO * Mapa.UNIDADE_ESCALA - inicioX * 2;
        fimY = alturaLevel * ManejarRecursos.TAMANHO_BLOCO * Mapa.UNIDADE_ESCALA - inicioY * 2;
        CameraStyles.boundaries(camera, inicioX, inicioY, fimX, fimY);
    }

    private static void setupViewport(int width, int height) {
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
