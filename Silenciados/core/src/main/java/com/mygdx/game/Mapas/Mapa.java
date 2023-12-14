package com.mygdx.game.Mapas;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Components.ColliderComponent;
import com.mygdx.game.Manejar.ManejarRecursos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Mapa {
    private static final Logger LOGGER = LoggerFactory.getLogger(Mapa.class); // Para Debug
    protected static final String COLLISION_LAYER = "MAP_COLLISION_LAYER";
    protected static final String SPAWNS_LAYER = "MAP_SPAWNS_LAYER";
    protected static final String PORTAL_LAYER = "MAP_PORTAL_LAYER";
    protected static final String QUEST_ITEM_SPAWN_LAYER = "MAP_QUEST_ITEM_SPAWN_LAYER";
    public static final float UNIDADE_ESCALA = 1/32f;
    protected static final String INICIAR_PLAYER = "PLAYER_START";
    protected Vector2 playerStartPositionRect;
    protected Vector2 closestPlayerStartPosition;
    protected MapLayer layerColisao = null;
    protected MapLayer layerPortal = null;
    protected MapLayer layerSpawn = null;
    protected MapLayer questItemSpawnLayer = null;
    protected TiledMap mapaAtual = null;
    protected FabricaDeMapa.MapType mapTypeAtual;
    protected Vector2 iniciarPlayer;
    private World world;

    public Vector2 getIniciarPlayer() {
        return iniciarPlayer;
    }

    public TiledMap getMapaAtual() {
        return mapaAtual;
    }

    public Mapa(FabricaDeMapa.MapType mapType, String fullMapPath, World world) {
        mapTypeAtual = mapType;
        iniciarPlayer = new Vector2(0, 0);
        this.world = world;

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
        } else {
            setClosestStartPosition(iniciarPlayer);
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
        LOGGER.debug("setClosestStartPosition INPUT: ({},{}) {}", position.x, position.y, mapTypeAtual.toString());

        // Inicializa a última posição conhecida neste mapa
        playerStartPositionRect = new Vector2(0, 0);
        closestPlayerStartPosition = new Vector2(0, 0); // Adicione esta linha
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

                LOGGER.debug("DISTANCE: {} for {}", distance, mapTypeAtual.toString());

                if (distance < shortestDistance || shortestDistance == 0) {
                    closestPlayerStartPosition.set(playerStartPositionRect);
                    shortestDistance = distance;
                    LOGGER.debug("closest START is: ({},{}) {}", closestPlayerStartPosition.x, closestPlayerStartPosition.y, mapTypeAtual.toString());
                }
            }
        }
        iniciarPlayer = closestPlayerStartPosition.cpy();
    }

    public MapLayer getCollisionLayer() {
        return layerColisao;
    }

    public MapLayer getPortalLayer() {
        return layerPortal;
    }

}
