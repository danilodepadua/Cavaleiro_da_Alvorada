package com.mygdx.game.Mapas;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Manejar.ManejarRecursos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Mapa {
    private static final Logger LOGGER = LoggerFactory.getLogger(Mapa.class); //Para Debug
    protected static final String COLLISION_LAYER = "MAPA_LAYOUTS_COLISAO";
    protected static final String SPAWNS_LAYER = "MAPA_LAYOUTS_SPAWNS";
    protected static final String PORTAL_LAYER = "MAPA_LAYOUTS_PORTAL";
    protected static final String QUEST_ITEM_SPAWN_LAYER = "MAPA_QUEST_ITEM_SPAWN_LAYER";
    public static final float UNIDADE_ESCALA = 1/32f;
    protected static final String INICIAR_PLAYER = "INICIAR_PLAYER";
    protected Vector2 convertedUnits;
    protected Vector2 playerStartPositionRect;
    protected Vector2 closestPlayerStartPosition;
    protected FabricaDeMapa.MapType currentMapType;
    protected MapLayer layerColisao = null;
    protected MapLayer layerPortal = null;
    protected MapLayer layerSpawn = null;
    protected MapLayer questItemSpawnLayer = null;
    protected TiledMap mapaAtual = null;
    protected FabricaDeMapa.MapType mapTypeAtual;

    protected Vector2 iniciarPlayer;

    public Vector2 getIniciarPlayer() {
        return iniciarPlayer;
    }

    public void setIniciarPlayer(Vector2 iniciarPlayer) {
        this.iniciarPlayer = iniciarPlayer;
    }

    public TiledMap getMapaAtual() {
        return mapaAtual;
    }

    public Mapa(FabricaDeMapa.MapType mapType, String fullMapPath){
        mapTypeAtual = mapType;
        iniciarPlayer = new Vector2(0, 0);

        // Verificação da validade do caminho do mapa
        if (fullMapPath == null || fullMapPath.isEmpty()) {
            LOGGER.debug("Mapa não é valido");
            return;
        }
        // Carregamento do mapa a partir do manejar recursos
        ManejarRecursos.carregarMapaAsset(fullMapPath);
        if (ManejarRecursos.isAssetLoaded(fullMapPath)) {
            mapaAtual = ManejarRecursos.getMapaAsset(fullMapPath);
        } else {
            LOGGER.debug("Mapa não carregou");
            return;
        }
        // Inicialização das camadas do mapa
        layerColisao = mapaAtual.getLayers().get(COLLISION_LAYER);
        if (layerColisao == null) {
            LOGGER.debug("Sem collision layer!");
        }

        layerPortal = mapaAtual.getLayers().get(PORTAL_LAYER);
        if (layerPortal == null) {
            LOGGER.debug("Sem portal layer!");
        }

        layerSpawn = mapaAtual.getLayers().get(SPAWNS_LAYER);
        if (layerSpawn == null) {
            LOGGER.debug("Sem spawn layer!");
        }

        questItemSpawnLayer = mapaAtual.getLayers().get(QUEST_ITEM_SPAWN_LAYER);
        if (questItemSpawnLayer == null) {
            LOGGER.debug("Sem quest item spawn layer!");
        }
    }

    public Vector2 getPlayerStartUnitScaled() {
        Vector2 playerStart = this.iniciarPlayer.cpy();
        playerStart.set(this.iniciarPlayer.x * UNIDADE_ESCALA, this.iniciarPlayer.y * UNIDADE_ESCALA);
        return playerStart;
    }
    protected void dispose() {
    }
    private void setClosestStartPosition(final Vector2 position) {
        LOGGER.debug("setClosestStartPosition INPUT: ({},{}) {}", position.x, position.y, currentMapType.toString());

        // Obtém a última posição conhecida neste mapa
        playerStartPositionRect.set(0, 0);
        closestPlayerStartPosition.set(0, 0);
        float shortestDistance = 0f;

        // Percorre todas as posições iniciais de jogador e escolhe a mais próxima da última posição conhecida
        for (MapObject object : layerSpawn.getObjects()) {
            String objectName = object.getName();

            if (objectName == null || objectName.isEmpty()) {
                continue;
            }

            if (objectName.equalsIgnoreCase(INICIAR_PLAYER)) {
                ((RectangleMapObject) object).getRectangle().getPosition(playerStartPositionRect);
                float distance = position.dst2(playerStartPositionRect);

                LOGGER.debug("DISTANCE: {} for {}", distance, currentMapType.toString());

                if (distance < shortestDistance || shortestDistance == 0) {
                    closestPlayerStartPosition.set(playerStartPositionRect);
                    shortestDistance = distance;
                    LOGGER.debug("closest START is: ({},{}) {}", closestPlayerStartPosition.x, closestPlayerStartPosition.y, currentMapType.toString());
                }
            }
        }
        iniciarPlayer = closestPlayerStartPosition.cpy();
    }
    public void setClosestStartPositionFromScaledUnits(Vector2 position) {
        convertedUnits.set(position.x / UNIDADE_ESCALA, position.y / UNIDADE_ESCALA);
        setClosestStartPosition(convertedUnits);
    }

    public MapLayer getCollisionLayer() {
        return layerColisao;
    }
    public MapLayer getPortalLayer() {
        return layerPortal;
    }

}
