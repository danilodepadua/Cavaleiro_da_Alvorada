package com.mygdx.game.Mapa;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.audio.AudioObserver;
import com.mygdx.game.audio.AudioSubject;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Manager.ResourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;

public abstract class Map implements AudioSubject {

    /**
     * Para debug e afins
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Map.class);

    // Lista de observadores de áudio associados ao mapa
    private Array<AudioObserver> observers;

    // Fatores de escala e constantes para camadas do mapa
    public static final float UNIT_SCALE = 1/32f;
    protected static final String COLLISION_LAYER = "MAP_COLLISION_LAYER";
    protected static final String SPAWNS_LAYER = "MAP_SPAWNS_LAYER";
    protected static final String PORTAL_LAYER = "MAP_PORTAL_LAYER";
    protected static final String QUEST_ITEM_SPAWN_LAYER = "MAP_QUEST_ITEM_SPAWN_LAYER";
    protected static final String QUEST_DISCOVER_LAYER = "MAP_QUEST_DISCOVER_LAYER";
    protected static final String ENEMY_SPAWN_LAYER = "MAP_ENEMY_SPAWN_LAYER";
    protected static final String PARTICLE_EFFECT_SPAWN_LAYER = "PARTICLE_EFFECT_SPAWN_LAYER";
    public static final String BACKGROUND_LAYER = "Background_Layer";
    public static final String GROUND_LAYER = "Ground_Layer";
    public static final String DECORATION_LAYER = "Decoration_Layer";
    protected static final String PLAYER_START = "PLAYER_START";
    protected static final String NPC_START = "NPC_START";
    protected static final String ENEMY_SPAWN = "ENEMY_SPAWN";

    // Objeto de serialização JSON para carregar configurações do mapa
    protected Json json;

    // Posições e unidades associadas ao jogador e NPCs no mapa
    protected Vector2 playerStartPositionRect;
    protected Vector2 closestPlayerStartPosition;
    protected Vector2 convertedUnits;

    // Informações sobre o mapa atual
    protected TiledMap currentMap = null;
    protected Vector2 playerStart;
    protected Array<Vector2> npcStartPositions;
    protected Hashtable<String, Vector2> enemyStartPositions;
    protected Hashtable<String, Vector2> specialNPCStartPositions;

    // Camadas do mapa
    protected MapLayer collisionLayer = null;
    protected MapLayer portalLayer = null;
    protected MapLayer spawnsLayer = null;
    protected MapLayer questItemSpawnLayer = null;
    protected MapLayer questDiscoverLayer = null;
    protected MapLayer enemySpawnLayer = null;

    // Tipo de mapa atual
    protected MapFactory.MapType currentMapType;

    // Entidades associadas ao mapa
    protected Array<Entity> mapEntities;
    protected Array<Entity> mapQuestEntities;

    // Evento de áudio para o tema musical do mapa
    private AudioObserver.AudioTypeEvent musicTheme;

    /**
     * Construtor da classe Map, responsável por inicializar e carregar informações do mapa.
     * @param mapType Tipo do mapa a ser carregado.
     * @param fullMapPath Caminho completo para o arquivo do mapa.
     */
    public Map(MapFactory.MapType mapType, String fullMapPath) {
        // Inicialização de variáveis e estruturas de dados
        json = new Json();
        mapEntities = new Array<>(10);
        observers = new Array<>();
        mapQuestEntities = new Array<>();
        currentMapType = mapType;
        playerStart = new Vector2(0, 0);
        playerStartPositionRect = new Vector2(0, 0);
        closestPlayerStartPosition = new Vector2(0, 0);
        convertedUnits = new Vector2(0, 0);

        // Verificação da validade do caminho do mapa
        if (fullMapPath == null || fullMapPath.isEmpty()) {
            LOGGER.debug("Mapa não é valido");
            return;
        }

        // Carregamento do mapa a partir do ResourceManager
        ResourceManager.loadMapAsset(fullMapPath);
        if (ResourceManager.isAssetLoaded(fullMapPath)) {
            currentMap = ResourceManager.getMapAsset(fullMapPath);
        } else {
            LOGGER.debug("Mapa não carregou");
            return;
        }

        // Inicialização das camadas do mapa
        collisionLayer = currentMap.getLayers().get(COLLISION_LAYER);
        if (collisionLayer == null) {
            LOGGER.debug("Sem collision layer!");
        }

        portalLayer = currentMap.getLayers().get(PORTAL_LAYER);
        if (portalLayer == null) {
            LOGGER.debug("Sem portal layer!");
        }

        spawnsLayer = currentMap.getLayers().get(SPAWNS_LAYER);
        if (spawnsLayer == null) {
            LOGGER.debug("Sem spawn layer!");
        } else {
            setClosestStartPosition(playerStart);
        }

        questItemSpawnLayer = currentMap.getLayers().get(QUEST_ITEM_SPAWN_LAYER);
        if (questItemSpawnLayer == null) {
            LOGGER.debug("Sem quest item spawn layer!");
        }

        questDiscoverLayer = currentMap.getLayers().get(QUEST_DISCOVER_LAYER);
        if (questDiscoverLayer == null) {
            LOGGER.debug("Sem quest discover layer!");
        }

        enemySpawnLayer = currentMap.getLayers().get(ENEMY_SPAWN_LAYER);
        if (enemySpawnLayer == null) {
            LOGGER.debug("Sem enemy layer found!");
        } else {
            enemyStartPositions = getEnemyStartPositions();
        }

        npcStartPositions = getNPCStartPositions();
        specialNPCStartPositions = getSpecialNPCStartPositions();

        // Adição de observadores, neste caso, o AudioManager
        this.addObserver(AudioManager.getInstance());
    }


    public AudioObserver.AudioTypeEvent getMusicTheme() {
        return musicTheme;
    }

    /**
     * Obtém as posições de spawn de itens de missão no mapa.
     * @param objectName Nome do objeto de missão.
     * @param objectTaskID ID da tarefa associada ao objeto de missão.
     * @return Um array de posições (Vector2) onde os itens de missão podem spawnar.
     */
    public Array<Vector2> getQuestItemSpawnPositions(String objectName, String objectTaskID) {
        Array<Vector2> positions = new Array<>();

        // Itera sobre os objetos na camada de spawn de itens de missão
        for (MapObject object : questItemSpawnLayer.getObjects()) {
            // Obtém o nome e a ID da tarefa do objeto
            String name = object.getName();
            String taskID = (String) object.getProperties().get("taskID");

            // Verifica se as informações do objeto são válidas e correspondem aos parâmetros
            if (name == null || taskID == null || name.isEmpty() || taskID.isEmpty() ||
                    !name.equalsIgnoreCase(objectName) || !taskID.equalsIgnoreCase(objectTaskID)) {
                continue;
            }

            // Obtém o centro do retângulo associado ao objeto
            float x = ((RectangleMapObject) object).getRectangle().getX();
            float y = ((RectangleMapObject) object).getRectangle().getY();

            // Escala as coordenadas do mapa pela unidade para conversão
            x *= UNIT_SCALE;
            y *= UNIT_SCALE;

            // Adiciona a posição ao array
            positions.add(new Vector2(x, y));
        }

        return positions;
    }


    public Array<Entity> getMapEntities() {
        return mapEntities;
    }

    public Array<Entity> getMapQuestEntities() {
        return mapQuestEntities;
    }

    public void addMapQuestEntities(Array<Entity> entities) {
        mapQuestEntities.addAll(entities);
    }

    public MapFactory.MapType getCurrentMapType() {
        return currentMapType;
    }

    public Vector2 getPlayerStart() {
        return playerStart;
    }

    public void setPlayerStart(Vector2 playerStart) {
        this.playerStart = playerStart;
    }

    /**
     * Atualiza todas as entidades no mapa, incluindo entidades normais e de missão.
     * @param mapMgr Gerenciador de mapa.
     * @param batch Batch utilizado para renderização.
     * @param delta Tempo passado desde a última atualização.
     */
    protected void updateMapEntities(MapManager mapMgr, Batch batch, float delta) {
        // Atualiza todas as entidades normais
        for (int i = 0; i < mapEntities.size; i++) {
            mapEntities.get(i).update(mapMgr, batch, delta);
        }

        // Atualiza todas as entidades de missão
        for (int i = 0; i < mapQuestEntities.size; i++) {
            mapQuestEntities.get(i).update(mapMgr, batch, delta);
        }
    }

    protected void dispose() {
        // Libera os recursos de todas as entidades normais
        for (int i = 0; i < mapEntities.size; i++) {
            mapEntities.get(i).dispose();
        }

        // Libera os recursos de todas as entidades de missão
        for (int i = 0; i < mapQuestEntities.size; i++) {
            mapQuestEntities.get(i).dispose();
        }
    }


    public MapLayer getCollisionLayer() {
        return collisionLayer;
    }

    public MapLayer getPortalLayer() {
        return portalLayer;
    }

    public MapLayer getQuestItemSpawnLayer() {
        return questItemSpawnLayer;
    }

    public MapLayer getQuestDiscoverLayer() {
        return questDiscoverLayer;
    }

    public MapLayer getEnemySpawnLayer() {
        return enemySpawnLayer;
    }

    public TiledMap getCurrentTiledMap() {
        return currentMap;
    }

    /**
     * Obtém a posição inicial do jogador escalada pela unidade de escala do mapa.
     * @return Vetor representando a posição inicial do jogador escalada.
     */
    public Vector2 getPlayerStartUnitScaled() {
        Vector2 playerStart = this.playerStart.cpy();
        playerStart.set(this.playerStart.x * UNIT_SCALE, this.playerStart.y * UNIT_SCALE);
        return playerStart;
    }

    /**
     * Obtém as posições iniciais dos NPCs no mapa, escaladas pela unidade de escala do mapa.
     * @return Array de vetores representando as posições iniciais dos NPCs.
     */
    private Array<Vector2> getNPCStartPositions() {
        Array<Vector2> npcStartPositions = new Array<>();

        for (MapObject object : spawnsLayer.getObjects()) {
            String objectName = object.getName();

            if (objectName == null || objectName.isEmpty()) {
                continue;
            }

            if (objectName.equalsIgnoreCase(NPC_START)) {
                // Obtém o centro do retângulo
                float x = ((RectangleMapObject) object).getRectangle().getX();
                float y = ((RectangleMapObject) object).getRectangle().getY();

                // Escala as coordenadas pela unidade para converter de coordenadas de mapa
                x *= UNIT_SCALE;
                y *= UNIT_SCALE;

                npcStartPositions.add(new Vector2(x, y));
            }
        }
        return npcStartPositions;
    }

    /**
     * Obtém as posições iniciais dos inimigos no mapa, escaladas pela unidade de escala do mapa.
     * @return Hashtable associando o nome do inimigo à sua posição inicial.
     */
    private Hashtable<String, Vector2> getEnemyStartPositions() {
        Hashtable<String, Vector2> enemyStartPositions = new Hashtable<>();

        for (MapObject object : enemySpawnLayer.getObjects()) {
            String objectName = object.getName();

            if (objectName == null || objectName.isEmpty()) {
                continue;
            }

            // Isso é destinado a todas as posições especiais de spawn, um "catch all", então ignore as conhecidas
            // Obtém o centro do retângulo
            float x = ((RectangleMapObject) object).getRectangle().getX();
            float y = ((RectangleMapObject) object).getRectangle().getY();

            // Escala as coordenadas pela unidade para converter de coordenadas de mapa
            x *= UNIT_SCALE;
            y *= UNIT_SCALE;

            enemyStartPositions.put(objectName, new Vector2(x, y));
        }
        return enemyStartPositions;
    }

    /**
     * Obtém as posições iniciais de NPCs especiais no mapa, escaladas pela unidade de escala do mapa.
     * @return Hashtable associando o nome do NPC especial à sua posição inicial.
     */
    private Hashtable<String, Vector2> getSpecialNPCStartPositions() {
        Hashtable<String, Vector2> specialNPCStartPositions = new Hashtable<>();

        for (MapObject object : spawnsLayer.getObjects()) {
            String objectName = object.getName();

            if (objectName == null || objectName.isEmpty()) {
                continue;
            }

            // Isso é destinado a todas as posições especiais de spawn, um "catch all", então ignore as conhecidas
            if (objectName.equalsIgnoreCase(NPC_START) || objectName.equalsIgnoreCase(PLAYER_START)) {
                continue;
            }

            // Obtém o centro do retângulo
            float x = ((RectangleMapObject) object).getRectangle().getX();
            float y = ((RectangleMapObject) object).getRectangle().getY();

            // Escala as coordenadas pela unidade para converter de coordenadas de mapa
            x *= UNIT_SCALE;
            y *= UNIT_SCALE;

            specialNPCStartPositions.put(objectName, new Vector2(x, y));
        }
        return specialNPCStartPositions;
    }

    /**
     * Define a posição inicial mais próxima com base na última posição conhecida do jogador neste mapa.
     * @param position A posição do jogador.
     */
    private void setClosestStartPosition(final Vector2 position) {
        LOGGER.debug("setClosestStartPosition INPUT: ({},{}) {}", position.x, position.y, currentMapType.toString());

        // Obtém a última posição conhecida neste mapa
        playerStartPositionRect.set(0, 0);
        closestPlayerStartPosition.set(0, 0);
        float shortestDistance = 0f;

        // Percorre todas as posições iniciais de jogador e escolhe a mais próxima da última posição conhecida
        for (MapObject object : spawnsLayer.getObjects()) {
            String objectName = object.getName();

            if (objectName == null || objectName.isEmpty()) {
                continue;
            }

            if (objectName.equalsIgnoreCase(PLAYER_START)) {
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
        playerStart = closestPlayerStartPosition.cpy();
    }

    /**
     * Define a posição inicial mais próxima com base em unidades escaladas.
     * @param position A posição do jogador em unidades escaladas.
     */
    public void setClosestStartPositionFromScaledUnits(Vector2 position) {
        convertedUnits.set(position.x / UNIT_SCALE, position.y / UNIT_SCALE);
        setClosestStartPosition(convertedUnits);
    }


    public abstract void unloadMusic();
    public abstract void loadMusic();

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
        for(AudioObserver observer: observers) {
            observer.onNotify(command, event);
        }
    }
}