package com.mygdx.game.Mapa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Components.Component;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Profile.ProfileManager;
import com.mygdx.game.Profile.ProfileObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mygdx.game.Components.ComponentObserver;

public class MapManager implements ProfileObserver {

    /**
     * Gerenciador de mapas responsável por controlar o estado do mapa atual, a câmera e a interação com o perfil do jogador.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MapManager.class);

    private Camera camera;
    private boolean mapChanged = false;
    private Map currentMap;
    private Entity player;
    private Entity currentSelectedEntity = null;

    /**
     * Construtor padrão do MapManager.
     */
    public MapManager() {
        // Nada
    }

    /**
     * Método chamado quando o perfil do jogador é alterado. Atualiza o mapa atual e a posição do jogador com base no perfil carregado.
     * @param profileManager O gerenciador de perfil.
     * @param event O evento que disparou a notificação.
     */
    @Override
    public void onNotify(ProfileManager profileManager, ProfileEvent event) {

    }

    /**
     * Carrega um mapa específico e realiza as operações associadas, como carregar e descarregar músicas.
     * @param mapType O tipo de mapa a ser carregado.
     */
    public void loadMap(MapFactory.MapType mapType) {
        // Obtém o mapa do tipo especificado
        Map map = MapFactory.getMap(mapType);

        // Verifica se o mapa existe
        if (map == null) {
            LOGGER.debug("Map does not exist!");
            return;
        }

        // Verifica se há um mapa atual e se a música é diferente, descarrega a música do mapa atual
        if (currentMap != null && currentMap.getMusicTheme() != map.getMusicTheme()) {
            currentMap.unloadMusic();
        }

        // Carrega a música do novo mapa
        map.loadMusic();

        // Define o novo mapa como o mapa atual
        currentMap = map;
        // Indica que o mapa foi alterado
        mapChanged = true;
        // Limpa a entidade de mapa atualmente selecionada
        clearCurrentSelectedMapEntity();
        LOGGER.debug("Player Start: ({},{})", currentMap.getPlayerStart().x, currentMap.getPlayerStart().y);
    }


    /**
     * Desregistra os observadores das entidades do mapa atual.
     */
    public void unregisterCurrentMapEntityObservers() {
        if (currentMap != null) {
            // Obtém todas as entidades do mapa
            Array<Entity> entities = currentMap.getMapEntities();

            // Desregistra os observadores de cada entidade
            for (Entity entity : entities) {
                entity.unregisterObservers();
            }

            // Obtém todas as entidades de missão do mapa
            Array<Entity> questEntities = currentMap.getMapQuestEntities();

            // Desregistra os observadores de cada entidade de missão
            for (Entity questEntity : questEntities) {
                questEntity.unregisterObservers();
            }
        }
    }

    public void registerCurrentMapEntityObservers(ComponentObserver observer) {
        if (currentMap != null) {
            Array<Entity> entities = currentMap.getMapEntities();
            for(Entity entity: entities) {
                entity.registerObserver(observer);
            }

            Array<Entity> questEntities = currentMap.getMapQuestEntities();
            for(Entity questEntity: questEntities) {
                questEntity.registerObserver(observer);
            }
        }
    }

    public void setClosestStartPositionFromScaledUnits(Vector2 position) {
        currentMap.setClosestStartPositionFromScaledUnits(position);
    }

    public MapLayer getCollisionLayer() {
        return currentMap.getCollisionLayer();
    }

    public MapLayer getPortalLayer() {
        return currentMap.getPortalLayer();
    }

    public Array<Vector2> getQuestItemSpawnPositions(String objectName, String objectTaskID) {
        return currentMap.getQuestItemSpawnPositions(objectName, objectTaskID);
    }

    public MapLayer getQuestDiscoverLayer() {
        return currentMap.getQuestDiscoverLayer();
    }

    public MapLayer getEnemySpawnLayer() {
        return currentMap.getEnemySpawnLayer();
    }

    public MapFactory.MapType getCurrentMapType() {
        return currentMap.getCurrentMapType();
    }

    public Vector2 getPlayerStartUnitScaled() {
        return currentMap.getPlayerStartUnitScaled();
    }

    public TiledMap getCurrentTiledMap() {
        if (currentMap == null) {
            loadMap(MapFactory.MapType.MANSAO);
        }
        return currentMap.getCurrentTiledMap();
    }

    public void updateCurrentMapEntities(MapManager mapMgr, Batch batch, float delta) {
        currentMap.updateMapEntities(mapMgr, batch, delta);
    }

    public final Array<Entity> getCurrentMapEntities() {
        return currentMap.getMapEntities();
    }

    public final Array<Entity> getCurrentMapQuestEntities() {
        return currentMap.getMapQuestEntities();
    }

    public void addMapQuestEntities(Array<Entity> entities) {
        currentMap.getMapQuestEntities().addAll(entities);
    }

    public void removeMapQuestEntity(Entity entity) {
        entity.unregisterObservers();

        Array<Vector2> positions = ProfileManager.getInstance().getProperty(entity.getEntityConfig().getEntityID(), Array.class);
        if (positions == null) {
            return;
        }

        for(Vector2 position : positions) {
            if (position.x == entity.getCurrentPosition().x && position.y == entity.getCurrentPosition().y) {
                positions.removeValue(position, true);
                break;
            }
        }
        currentMap.getMapQuestEntities().removeValue(entity, true);
        ProfileManager.getInstance().setProperty(entity.getEntityConfig().getEntityID(), positions);
    }

    public void addMapEntity(Entity entity) {
        currentMap.getMapEntities().add(entity);
    }

    public void removeMapEntity(Entity entity) {
        entity.unregisterObservers();

        Vector2 position = entity.getCurrentPosition();
        if (position == null) {
            return;
        }

        currentMap.getMapEntities().removeValue(entity, true);
    }

    public void clearAllMapQuestEntities() {
        currentMap.getMapQuestEntities().clear();
    }

    public Entity getCurrentSelectedMapEntity() {
        return currentSelectedEntity;
    }

    public void setCurrentSelectedMapEntity(Entity currentSelectedEntity) {
        this.currentSelectedEntity = currentSelectedEntity;
    }

    public void clearCurrentSelectedMapEntity() {
        if (currentSelectedEntity == null) {
            return;
        }
        currentSelectedEntity.sendMessage(Component.MESSAGE.ENTITY_DESELECTED);
        currentSelectedEntity = null;
    }

    public void setPlayer(Entity entity) {
        this.player = entity;
    }

    public Entity getPlayer() {
        return this.player;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return camera;
    }

    public boolean hasMapChanged() {
        return mapChanged;
    }

    public void setMapChanged(boolean hasMapChanged) {
        this.mapChanged = hasMapChanged;
    }
}