package com.mygdx.game.Components;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.EntityFactory;
import com.mygdx.game.Mapa.Map;
import com.mygdx.game.Mapa.MapManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Classe abstrata para componentes físicos
public abstract class PhysicsComponent extends ComponentSubject implements Component {

    // Logger para mensagens de log
    private static final Logger LOGGER = LoggerFactory.getLogger(PhysicsComponent.class);

    // Tipo de entidade encontrada durante a colisão
    public EntityFactory.EntityName entityEncounteredType;

    // Posições atual e próxima da entidade
    protected Vector2 nextEntityPosition;
    protected Vector2 currentEntityPosition;

    // Direção atual da entidade
    protected Entity.Direction currentDirection;

    // Objeto para serialização/desserialização de dados
    protected Json json;

    // Velocidade da entidade
    protected Vector2 velocity;

    // Array temporário para armazenar entidades durante colisões
    protected Array<Entity> tempEntities;

    // Caixa delimitadora para colisões
    public Rectangle boundingBox;

    // Localização da caixa delimitadora em relação à entidade
    protected BoundingBoxLocation boundingBoxLocation;

    // Raio de seleção para interações
    protected Ray selectionRay;
    protected static final float SELECT_RAY_MAXIMUM_DISTANCE = 32.0f;

    // Enumeração para a localização da caixa delimitadora
    public enum BoundingBoxLocation {
        BOTTOM_LEFT,
        BOTTOM_CENTER,
        CENTER,
    }

    // Construtor padrão inicializando variáveis
    public PhysicsComponent() {
        this.nextEntityPosition = new Vector2(0, 0);
        this.currentEntityPosition = new Vector2(0, 0);
        this.velocity = new Vector2(2f, 2f);
        this.boundingBox = new Rectangle();

        this.json = new Json();
        this.tempEntities = new Array<>();
        boundingBoxLocation = BoundingBoxLocation.BOTTOM_LEFT;
        selectionRay = new Ray(new Vector3(), new Vector3());
    }

    // Método abstrato para atualizar o componente físico
    public abstract void update(Entity entity, MapManager mapMgr, float delta);

    // Método para verificar colisões com outras entidades do mapa
    protected boolean isCollisionWithMapEntities(Entity entity, MapManager mapMgr) {
        tempEntities.clear();
        tempEntities.addAll(mapMgr.getCurrentMapEntities());
        tempEntities.addAll(mapMgr.getCurrentMapQuestEntities());
        boolean isCollisionWithMapEntities = false;

        for (Entity mapEntity : tempEntities) {
            // Check for testing against self
            if (mapEntity.equals(entity)) {
                continue;
            }

            Rectangle targetRect = mapEntity.getCurrentBoundingBox();
            if (boundingBox.overlaps(targetRect)) {
                // Collision
                if ("FOE".equals(mapEntity.getEntityConfig().getEntityStatus())) {
                    entity.sendMessage(MESSAGE.COLLISION_WITH_FOE, mapEntity.getEntityConfig().getEntityID());
                } else {
                    entity.sendMessage(MESSAGE.COLLISION_WITH_ENTITY, mapEntity.getEntityConfig().getEntityID());
                }
                isCollisionWithMapEntities = true;
                break;
            }
        }
        tempEntities.clear();
        return isCollisionWithMapEntities;
    }

    // Método para verificar colisões entre duas entidades
    protected boolean isCollision(Entity entitySource, Entity entityTarget) {
        boolean isCollisionWithMapEntities = false;

        if (entitySource.equals(entityTarget)) {
            return false;
        }

        if (entitySource.getCurrentBoundingBox().overlaps(entityTarget.getCurrentBoundingBox())) {
            // Collision
            entitySource.sendMessage(MESSAGE.COLLISION_WITH_ENTITY);
            isCollisionWithMapEntities = true;
        }

        return isCollisionWithMapEntities;
    }

    // Método para verificar colisões com objetos do mapa
    protected boolean isCollisionWithMapLayer(Entity entity, MapManager mapMgr) {
        MapLayer mapCollisionLayer = mapMgr.getCollisionLayer();

        if (mapCollisionLayer == null) {
            return false;
        }

        for (MapObject object : mapCollisionLayer.getObjects()) {
            if (object instanceof RectangleMapObject) {
                Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
                if (boundingBox.overlaps(rectangle)) {
                    // Collision
                    entity.sendMessage(MESSAGE.COLLISION_WITH_MAP);
                    return true;
                }
            }
        }

        return false;
    }

    // Método para definir a próxima posição como a posição atual da entidade
    protected void setNextPositionToCurrent(Entity entity) {
        this.currentEntityPosition.x = nextEntityPosition.x;
        this.currentEntityPosition.y = nextEntityPosition.y;

        entity.sendMessage(MESSAGE.CURRENT_POSITION, json.toJson(currentEntityPosition));
    }

    // Método para calcular a próxima posição da entidade com base na direção e velocidade
    protected void calculateNextPosition(float deltaTime) {
        if (currentDirection == null) {
            return;
        }

        if (deltaTime > .7) {
            return;
        }

        float testX = currentEntityPosition.x;
        float testY = currentEntityPosition.y;

        velocity.scl(deltaTime);

        switch (currentDirection) {
            case LEFT:
                testX -= velocity.x;
                break;
            case RIGHT:
                testX += velocity.x;
                break;
            case UP:
                testY += velocity.y;
                break;
            case DOWN:
                testY -= velocity.y;
                break;
            default:
                break;
        }

        nextEntityPosition.x = testX;
        nextEntityPosition.y = testY;

        // velocity
        velocity.scl(1 / deltaTime);
    }

    // Método para inicializar a caixa delimitadora da entidade com reduções proporcionais
    protected void initBoundingBox(float percentageWidthReduced, float percentageHeightReduced) {
        // Update the current bounding box
        float width;
        float height;

        float origWidth = Entity.FRAME_WIDTH;
        float origHeight = Entity.FRAME_HEIGHT;

        float widthReductionAmount = 1.0f - percentageWidthReduced; // .8f for 20% (1 - .20)
        float heightReductionAmount = 1.0f - percentageHeightReduced; // .8f for 20% (1 - .20)

        if (widthReductionAmount > 0 && widthReductionAmount < 1) {
            width = Entity.FRAME_WIDTH * widthReductionAmount;
        } else {
            width = Entity.FRAME_WIDTH;
        }

        if (heightReductionAmount > 0 && heightReductionAmount < 1) {
            height = Entity.FRAME_HEIGHT * heightReductionAmount;
        } else {
            height = Entity.FRAME_HEIGHT;
        }

        if (width == 0 || height == 0) {
            LOGGER.debug("Width and Height are 0!! {}:{}", width, height);
        }

        // Need to account for the unitscale, since the map coordinates will be in pixels
        float minX;
        float minY;

        minX = nextEntityPosition.x / Map.UNIT_SCALE;
        minY = nextEntityPosition.y / Map.UNIT_SCALE;

        boundingBox.setWidth(width);
        boundingBox.setHeight(height);

        switch (boundingBoxLocation) {
            case BOTTOM_LEFT:
                boundingBox.set(minX, minY, width, height);
                break;
            case BOTTOM_CENTER:
                boundingBox.setCenter(minX + origWidth / 2, minY + origHeight / 4);
                break;
            case CENTER:
                boundingBox.setCenter(minX + origWidth / 2, minY + origHeight / 2);
                break;
        }
    }

    // Método para atualizar a posição da caixa delimitadora com base na posição da entidade
    protected void updateBoundingBoxPosition(Vector2 position) {
        // Need to account for the unitscale, since the map coordinates will be in pixels
        float minX;
        float minY;

        minX = position.x / Map.UNIT_SCALE;
        minY = position.y / Map.UNIT_SCALE;

        switch (boundingBoxLocation) {
            case BOTTOM_LEFT:
                boundingBox.set(minX, minY, boundingBox.getWidth(), boundingBox.getHeight());
                break;
            case BOTTOM_CENTER:
                boundingBox.setCenter(minX + (float) Entity.FRAME_WIDTH / 2, minY + (float) Entity.FRAME_HEIGHT / 4);
                break;
            case CENTER:
                boundingBox.setCenter(minX + (float) Entity.FRAME_WIDTH / 2, minY + (float) Entity.FRAME_HEIGHT / 2);
                break;
        }
    }
}
