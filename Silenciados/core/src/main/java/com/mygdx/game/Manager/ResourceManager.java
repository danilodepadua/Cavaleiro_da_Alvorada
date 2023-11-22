package com.mygdx.game.Manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceManager.class);

    protected boolean isOptionScreen;
    protected boolean isMenuNewGameScreen;
    protected boolean isMenuLoadGameScreen;
    private static InternalFileHandleResolver filePathResolver =  new InternalFileHandleResolver();
    private final static String ITEMS_TEXTURE_ATLAS_PATH = "skins/items.atlas";

    // MAP
    public final static int SQUARE_TILE_SIZE = 32;

    // ATLAS
    public TextureAtlas atlas;

    // ITEMS
    public static TextureAtlas ITEMS_TEXTURE_ATLAS = new TextureAtlas(ITEMS_TEXTURE_ATLAS_PATH);

    // STATUS
    private final static String STATUSUI_TEXTURE_ATLAS_PATH = "skins/statusui.atlas";
    private final static String STATUS_UI_SKIN_PATH = "skins/statusui.json";
    public static TextureAtlas STATUS_UI_TEXTURE_ATLAS = new TextureAtlas(STATUSUI_TEXTURE_ATLAS_PATH);
    public static Skin STATUS_UI_SKIN = new Skin(Gdx.files.internal(STATUS_UI_SKIN_PATH), STATUS_UI_TEXTURE_ATLAS);

    // IMAGES
    public Texture backgroundSheet;
    public Texture battleBackgroundMeadow;
    public Pixmap cursor;

    // BUTTON
    public TextureRegion[][] button;

    // FONT
    public BitmapFont pixel10;

    // SETTINGS
    public static Skin skin;

    // ENTITIES
    public Texture rabite;
    public Texture heroWalkUp;
    public Texture rabiteWalkDown;

    private static AssetManager assetManager = new AssetManager();

    public ResourceManager() {
        // ATLAS
        assetManager.load("asset/textures.atlas", TextureAtlas.class);

        // IMAGES
        assetManager.load("asset/background/natureBackground_frames_sheet.png", Texture.class);
        assetManager.load("asset/background/battleBackground_meadow.png", Texture.class);

        // ENTITIES
        assetManager.load("entities/hero/hero_1_walking_up.png", Texture.class);

        assetManager.finishLoading();

        atlas = assetManager.get("asset/textures.atlas", TextureAtlas.class);

        // IMAGES
        backgroundSheet = assetManager.get("asset/background/natureBackground_frames_sheet.png");
        battleBackgroundMeadow = assetManager.get("asset/background/battleBackground_meadow.png");
        cursor = new Pixmap(Gdx.files.internal("asset/tool/cursor.png"));

        // BUTTON
        button = atlas.findRegion("play_button").split(80, 40);

        // FONT
        pixel10 = new BitmapFont(Gdx.files.internal("fonts/pixel.fnt"), atlas.findRegion("pixel"), false);

        // SETTINGS
        skin = new Skin(Gdx.files.internal("asset/data/uiskin.json"));

        // ENTITIES
        heroWalkUp = assetManager.get("entities/hero/hero_1_walking_up.png");
    }

    public boolean isOptionScreen() {
        return isOptionScreen;
    }

    public void setOptionScreen(boolean optionScreen) {
        isOptionScreen = optionScreen;
    }

    public boolean isMenuNewGameScreen() {
        return isMenuNewGameScreen;
    }

    public void setMenuNewGameScreen(boolean menuNewGameScreen) {
        isMenuNewGameScreen = menuNewGameScreen;
    }

    public boolean isMenuLoadGameScreen() {
        return isMenuLoadGameScreen;
    }

    public void setMenuLoadGameScreen(boolean menuLoadGameScreen) {
        isMenuLoadGameScreen = menuLoadGameScreen;
    }

    /**
     * Carrega um mapa (TiledMap) no ResourceManager.
     * @param mapFilenamePath Caminho do arquivo do mapa.
     */
    public static void loadMapAsset(String mapFilenamePath) {
        // Verifica se o caminho do arquivo do mapa é válido
        if (mapFilenamePath == null || mapFilenamePath.isEmpty()) {
            return;
        }

        // Verifica se o mapa já está carregado
        if (assetManager.isLoaded(mapFilenamePath)) {
            return;
        }

        // Carrega o asset do mapa se o arquivo existir
        if (filePathResolver.resolve(mapFilenamePath).exists()) {
            // Configura o carregador de mapa e inicia o carregamento
            assetManager.setLoader(TiledMap.class, new TmxMapLoader(filePathResolver));
            assetManager.load(mapFilenamePath, TiledMap.class);

            // Aguarda até que o mapa seja carregado (bloqueio temporário)
            assetManager.finishLoadingAsset(mapFilenamePath);

            LOGGER.debug("Map loaded!: {}", mapFilenamePath);
        } else {
            LOGGER.debug("Map doesn't exist!: {}", mapFilenamePath);
        }
    }


    public static boolean isAssetLoaded(String fileName) {
        return assetManager.isLoaded(fileName);
    }

    /**
     * Obtém uma referência para um mapa (TiledMap) carregado.
     * @param mapFilenamePath Caminho do arquivo do mapa.
     * @return O objeto TiledMap carregado, ou null se o mapa não foi carregado.
     */
    public static TiledMap getMapAsset(String mapFilenamePath) {
        TiledMap map = null;

        // Verifica se o asset manager concluiu o carregamento do mapa
        if (assetManager.isLoaded(mapFilenamePath)) {
            // Obtém a referência para o objeto TiledMap carregado
            map = assetManager.get(mapFilenamePath, TiledMap.class);
        } else {
            LOGGER.debug("Mapa não carregou: {}", mapFilenamePath);
        }

        return map;
    }
    //Função para carregar arquivos
    public static void loadTextureAsset(String textureFilenamePath) {
        // Verifica se o caminho do arquivo da textura é válido
        if (textureFilenamePath == null || textureFilenamePath.isEmpty()) {
            return;
        }

        // Verifica se a textura já foi carregada
        if (assetManager.isLoaded(textureFilenamePath)) {
            return;
        }

        // Carrega a textura
        // Verifica se o arquivo da textura existe
        if (filePathResolver.resolve(textureFilenamePath).exists()) {
            // Configura o carregador para texturas
            assetManager.setLoader(Texture.class, new TextureLoader(filePathResolver));
            // Inicia o carregamento da textura
            assetManager.load(textureFilenamePath, Texture.class);
            // Bloqueia a execução até que a textura seja carregada
            assetManager.finishLoadingAsset(textureFilenamePath);
        } else {
            // Loga se o arquivo da textura não existir
            LOGGER.debug("Texture doesn't exist!: {}", textureFilenamePath);
        }
    }

    public static Texture getTextureAsset(String textureFilenamePath) {
        // Inicializa uma variável texture como null
        Texture texture = null;

        // Verifica se a textura está carregada
        if (assetManager.isLoaded(textureFilenamePath)) {
            // Obtém a textura
            texture = assetManager.get(textureFilenamePath, Texture.class);
        } else {
            // Loga se a textura não estiver carregada
            LOGGER.debug("Textura não carregou : {}", textureFilenamePath);
        }

        // Retorna a textura (pode ser null se não estiver carregada)
        return texture;
    }

    public static void loadMusicAsset(String musicFilenamePath) {
        if (musicFilenamePath == null || musicFilenamePath.isEmpty()) {
            return;
        }

        if (assetManager.isLoaded(musicFilenamePath)) {
            return;
        }

        //load asset
        if (filePathResolver.resolve(musicFilenamePath).exists()) {
            assetManager.setLoader(Music.class, new MusicLoader(filePathResolver));
            assetManager.load(musicFilenamePath, Music.class);
            //Until we add loading screen, just block until we load the map
            assetManager.finishLoadingAsset(musicFilenamePath);
            LOGGER.debug("Music loaded!: {}", musicFilenamePath);
        } else {
            LOGGER.debug("Music doesn't exist!: {}", musicFilenamePath);
        }
    }

    public static Music getMusicAsset(String musicFilenamePath) {
        Music music = null;

        // once the asset manager is done loading
        if (assetManager.isLoaded(musicFilenamePath)) {
            music = assetManager.get(musicFilenamePath, Music.class);
        } else {
            LOGGER.debug("Music is not loaded: {}", musicFilenamePath);
        }

        return music;
    }

    public void dispose() {
        assetManager.dispose();

        atlas.dispose();

        backgroundSheet.dispose();
        battleBackgroundMeadow.dispose();

        pixel10.dispose();
    }
}