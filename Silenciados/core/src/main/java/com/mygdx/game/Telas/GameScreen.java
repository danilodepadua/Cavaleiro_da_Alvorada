package com.mygdx.game.Telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Camera.CameraStyles;
import com.mygdx.game.Components.Component;
import com.mygdx.game.Components.ComponentObserver;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.EntityFactory;
import com.mygdx.game.Entities.Player.PlayerInputComponent;
import com.mygdx.game.Manager.ResourceManager;
import com.mygdx.game.Mapa.Map;
import com.mygdx.game.Mapa.MapManager;
import com.mygdx.game.Profile.ProfileManager;
import com.mygdx.game.SilenciadosApp;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.audio.AudioObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mygdx.game.Mapa.MapFactory;

import java.util.ArrayList;

public class GameScreen extends BaseScreen implements ComponentObserver {

    /**
     * Classe GameScreen que representa a tela principal do jogo.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameScreen.class);

    /**
     * Classe interna VIEWPORT que contém informações sobre o viewport do jogo.
     */
    public static class VIEWPORT {
        private static float viewportWidth;
        private static float viewportHeight;
        private static float virtualWidth;
        private static float virtualHeight;
        private static float physicalWidth;
        private static float physicalHeight;
        private static float aspectRatio;
    }

    /**
     * Enumeração GameState que define os estados possíveis do jogo.
     */
    public enum GameState {
        SAVING,
        LOADING,
        RUNNING,
        PAUSED,
        GAME_OVER
    }
    // Estado atual do jogo
    private static GameState gameState;

    // Renderizador de mapas ortogonais
    protected OrthogonalTiledMapRenderer mapRenderer = null;
    // Gerenciador de mapas
    protected MapManager mapManager;
    // Câmera ortográfica para o jogo
    protected OrthographicCamera camera;
    // Câmera ortográfica para a interface do usuário (HUD)
    protected OrthographicCamera hudCamera;
    // Cena do jogo
    private Stage gameStage = new Stage();

    // Objeto JSON para manipulação de dados em formato JSON
    private Json json;
    // Referência ao aplicativo principal do jogo
    private SilenciadosApp game;
    // Multiplexador de entrada para lidar com entrada de vários dispositivos
    private InputMultiplexer multiplexer;

    // Entidade do jogador
    private Entity player;

    // Posições de início e fim do nível, largura e altura do nível
    private float startX;
    private float startY;
    private float levelWidth;
    private float levelHeight;
    private float endX;
    private float endY;

    // Tipo de evento de áudio para o tema musical
    private AudioObserver.AudioTypeEvent musicTheme;

    /**
     * Construtor da classe GameScreen, responsável por inicializar a tela principal do jogo.
     *
     * @param gdxGame         Instância do aplicativo principal do jogo.
     * @param resourceManager Gerenciador de recursos do jogo.
     */
    public GameScreen(SilenciadosApp gdxGame, ResourceManager resourceManager) {
        // Chama o construtor da classe pai (BaseScreen)
        super(gdxGame, resourceManager);

        // Inicializa as variáveis necessárias
        game = gdxGame;
        mapManager = new MapManager();
        json = new Json();

        // Define o estado inicial do jogo como RUNNING
        setGameState(GameState.RUNNING);

        // Configuração da câmera
        setupViewport(15, 15);

        // Obtém o tamanho atual e configura a câmera principal
        camera = new OrthographicCamera();
        camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);

        // Inicializa a entidade do jogador e registra o observador (this)
        player = EntityFactory.getInstance().getEntity(EntityFactory.EntityType.WARRIOR);
        player.registerObserver(this);

        // Configura o gerenciador de mapa com o jogador e a câmera
        mapManager.setPlayer(player);
        mapManager.setCamera(camera);

        // Configuração da câmera para a interface do usuário (HUD)
        hudCamera = new OrthographicCamera();
        hudCamera.setToOrtho(false, VIEWPORT.physicalWidth, VIEWPORT.physicalHeight);

        // Configuração do multiplexador de entrada para lidar com a entrada do jogador
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(player.getInputProcessor());
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public AudioObserver.AudioTypeEvent getMusicTheme() {
        return musicTheme;
    }

    /**
     * Método chamado quando a tela é exibida, configura observadores, estado do jogo e processador de entrada.
     */
    @Override
    public void show() {
        // Adiciona o gerenciador de perfis como observador do gerenciador de mapa
        ProfileManager.getInstance().addObserver(mapManager);

        // Define o estado do jogo como LOADING e configura o processador de entrada
        setGameState(GameState.LOADING);
        Gdx.input.setInputProcessor(multiplexer);

        // Inicializa o renderizador de mapa se ainda não estiver inicializado
        if (mapRenderer == null) {
            mapRenderer = new OrthogonalTiledMapRenderer(mapManager.getCurrentTiledMap(), Map.UNIT_SCALE);
        }
    }

    /**
     * Método chamado quando a tela é ocultada, define o estado do jogo e desativa o processador de entrada.
     */
    @Override
    public void hide() {
        // Se o jogo não estiver no estado GAME_OVER, define o estado como SAVING
        if (gameState != GameState.GAME_OVER) {
            setGameState(GameState.SAVING);
        }

        // Desativa o processador de entrada
        Gdx.input.setInputProcessor(null);
    }

    /**
     * Método chamado continuamente para renderizar a tela do jogo.
     *
     * @param delta O tempo decorrido desde a última chamada do método render em segundos.
     */
    @Override
    public void render(float delta) {
        // Se o jogo estiver pausado, apenas atualiza a entrada do jogador e retorna
        if (gameState == GameState.PAUSED) {
            player.updateInput(delta);
            return;
        }

        // Configuração do OpenGL para limpar o buffer de cores
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Configura a visão do renderizador de mapa com a câmera
        mapRenderer.setView(camera);

        // Configura o modo de mistura para lidar com transparência
        mapRenderer.getBatch().enableBlending();
        mapRenderer.getBatch().setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        // Verifica se o mapa foi alterado
        if (mapManager.hasMapChanged()) {
            // Atualiza o renderizador de mapa e a posição da câmera
            mapRenderer.setMap(mapManager.getCurrentTiledMap());
            player.sendMessage(Component.MESSAGE.INIT_START_POSITION, json.toJson(mapManager.getPlayerStartUnitScaled()));
            camera.position.set(mapManager.getPlayerStartUnitScaled().x, mapManager.getPlayerStartUnitScaled().y, 0f);
            camera.update();
            mapManager.setMapChanged(false);
        }

        // Renderiza o mapa
        mapRenderer.render();

        // Atualiza as entidades do mapa e o jogador
        mapManager.updateCurrentMapEntities(mapManager, mapRenderer.getBatch(), delta);
        player.update(mapManager, mapRenderer.getBatch(), delta);

        // Configura as bordas da câmera para evitar que ultrapasse os limites do mapa
        startX = camera.viewportWidth / 2;
        startY = camera.viewportHeight / 2;
        levelWidth = mapManager.getCurrentTiledMap().getProperties().get("width", Integer.class);
        levelHeight = mapManager.getCurrentTiledMap().getProperties().get("height", Integer.class);
        endX = levelWidth * ResourceManager.SQUARE_TILE_SIZE * Map.UNIT_SCALE - startX * 2;
        endY = levelHeight * ResourceManager.SQUARE_TILE_SIZE * Map.UNIT_SCALE - startY * 2;
        CameraStyles.boundaries(camera, startX, startY, endX, endY);

        // Obtém o tema musical do mapa atual e o define como música atual
        musicTheme = MapFactory.getMapTable().get(mapManager.getCurrentMapType()).getMusicTheme();
        AudioManager.getInstance().setCurrentMusic(ResourceManager.getMusicAsset(musicTheme.getValue()));
    }

    @Override
    public void onNotify(String value, ComponentEvent event) {
//        switch (event) {
//            case START_BATTLE -> {
//                setGameState(GameState.SAVING);
//                setScreenWithTransition((BaseScreen) gdxGame.getScreen(), new BattleScreen(game, playerHUD, mapManager, resourceManager), new ArrayList<>());
//                PlayerInputComponent.clear();
//            }
//            case OPTION_INPUT -> {
//                Image screenShot = new Image(ScreenUtils.getFrameBufferTexture());
//                game.setScreen(new OptionScreen(game, (BaseScreen) game.getScreen(), screenShot, resourceManager));
//            }
//            default -> {
//            }
//        }
    }

    @Override
    public void resize(int width, int height) {
        setupViewport(15, 15);
        camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);
    }

    @Override
    public void pause() {
        setGameState(GameState.SAVING);
    }

    @Override
    public void resume() {
        setGameState(GameState.LOADING);
    }

    @Override
    public void dispose() {
        super.dispose();
        if (player != null) {
            player.unregisterObservers();
            player.dispose();
        }

        if (mapRenderer != null) {
            mapRenderer.dispose();
        }

        AudioManager.getInstance().dispose();
        MapFactory.clearCache();
    }

    public static GameState getGameState() {
        return gameState;
    }

    /**
     * Define o estado atual do jogo.
     *
     * @param state O novo estado do jogo.
     */
    public static void setGameState(GameState state) {
        switch (state) {
            case RUNNING:
                gameState = GameState.RUNNING;
                break;
//            case LOADING:
//                // Carrega o perfil do jogador ao iniciar o jogo
//                ProfileManager.getInstance().loadProfile();
//                gameState = GameState.RUNNING;
//                break;
            case SAVING:
                // Salva o perfil do jogador ao pausar o jogo
                ProfileManager.getInstance().saveProfile();
                gameState = GameState.PAUSED;
                break;
            case PAUSED:
                // Alterna entre os estados de pausa e execução
                if (gameState == GameState.PAUSED) {
                    gameState = GameState.RUNNING;
                } else if (gameState == GameState.RUNNING) {
                    gameState = GameState.PAUSED;
                }
                break;
            case GAME_OVER:
                gameState = GameState.GAME_OVER;
                break;
            default:
                gameState = GameState.RUNNING;
        }
    }

    /**
     * Configura as dimensões do viewport do jogo.
     *
     * @param width  Largura virtual do viewport.
     * @param height Altura virtual do viewport.
     */
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

}