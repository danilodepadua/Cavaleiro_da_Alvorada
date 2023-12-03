package com.mygdx.game.Manejar;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManejarRecursos {
    private static final Logger LOGGER = LoggerFactory.getLogger(ManejarRecursos.class);

    private static AssetManager manejarAssets = new AssetManager();
    public final static int TAMANHO_BLOCO = 32;
    private static InternalFileHandleResolver resolverPathArquivo =  new InternalFileHandleResolver();
    public ManejarRecursos() {

    }
    public static void carregarMapaAsset(String mapFilenamePath) {
        // Verifica se o caminho do arquivo do mapa é válido
        if (mapFilenamePath == null || mapFilenamePath.isEmpty()) {
            return;
        }

        // Verifica se o mapa já está carregado
        if (manejarAssets.isLoaded(mapFilenamePath)) {
            return;
        }

        // Carrega o asset do mapa se o arquivo existir
        if (resolverPathArquivo.resolve(mapFilenamePath).exists()) {
            // Configura o carregador de mapa e inicia o carregamento
            manejarAssets.setLoader(TiledMap.class, new TmxMapLoader(resolverPathArquivo));
            manejarAssets.load(mapFilenamePath, TiledMap.class);

            // Aguarda até que o mapa seja carregado (bloqueio temporário)
            manejarAssets.finishLoadingAsset(mapFilenamePath);

            LOGGER.debug("Map loaded!: {}", mapFilenamePath);
        } else {
            LOGGER.debug("Map doesn't exist!: {}", mapFilenamePath);
        }
    }


    public static boolean isAssetLoaded(String nomeArquivo) {
        return manejarAssets.isLoaded(nomeArquivo);
    }

    /**
     * Obtém uma referência para um mapa (TiledMap) carregado.
     * @param mapFilenamePath Caminho do arquivo do mapa.
     * @return O objeto TiledMap carregado, ou null se o mapa não foi carregado.
     */
    public static TiledMap getMapaAsset(String mapFilenamePath) {
        TiledMap map = null;

        // Verifica se o asset manager concluiu o carregamento do mapa
        if (manejarAssets.isLoaded(mapFilenamePath)) {
            // Obtém a referência para o objeto TiledMap carregado
            map = manejarAssets.get(mapFilenamePath, TiledMap.class);
        } else {
            LOGGER.debug("Mapa não carregou: {}", mapFilenamePath);
        }

        return map;
    }
    public static void loadTextureAsset(String textureFilenamePath) {
        // Verifica se o caminho do arquivo da textura é válido
        if (textureFilenamePath == null || textureFilenamePath.isEmpty()) {
            return;
        }

        // Verifica se a textura já foi carregada
        if (manejarAssets.isLoaded(textureFilenamePath)) {
            return;
        }

        // Carrega a textura
        // Verifica se o arquivo da textura existe
        if (resolverPathArquivo.resolve(textureFilenamePath).exists()) {
            // Configura o carregador para texturas
            manejarAssets.setLoader(Texture.class, new TextureLoader(resolverPathArquivo));
            // Inicia o carregamento da textura
            manejarAssets.load(textureFilenamePath, Texture.class);
            // Bloqueia a execução até que a textura seja carregada
            manejarAssets.finishLoadingAsset(textureFilenamePath);
        } else {
            // Loga se o arquivo da textura não existir
            LOGGER.debug("Texture doesn't exist!: {}", textureFilenamePath);
        }
    }

    public void dispose() {
        manejarAssets.dispose();
    }
}
