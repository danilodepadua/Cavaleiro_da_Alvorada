package com.mygdx.game.Entities;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.Components.Component;
import com.mygdx.game.Entities.NPC.NPCGraphicsComponent;
import com.mygdx.game.Entities.NPC.NPCInputComponent;
import com.mygdx.game.Entities.NPC.NPCPhysicsComponent;
import com.mygdx.game.Entities.Player.PlayerGraphicsComponent;
import com.mygdx.game.Entities.Player.PlayerInputComponent;
import com.mygdx.game.Entities.Player.PlayerPhysicsComponent;

import java.util.Hashtable;

import static com.badlogic.gdx.net.HttpRequestBuilder.json;

public class EntityFactory {

    private static Json json = new Json();
    private static EntityFactory instance = null;
    private Hashtable<String, EntityConfig> entities;

    public enum EntityType {
        WARRIOR,
        MAGE,
        THIEF,
        GRAPPLER,
        CLERIC,
        PLAYER_DEMO,
        ENEMY,
        NPC
    }

    public enum EntityName {
        TOWN_GUARD_WALKING,
        TOWN_BLACKSMITH,
        TOWN_MAGE,
        TOWN_INNKEEPER,
        TOWN_FOLK1, TOWN_FOLK2, TOWN_FOLK3, TOWN_FOLK4, TOWN_FOLK5,
        TOWN_FOLK6, TOWN_FOLK7, TOWN_FOLK8, TOWN_FOLK9, TOWN_FOLK10,
        TOWN_FOLK11, TOWN_FOLK12, TOWN_FOLK13, TOWN_FOLK14, TOWN_FOLK15,
        RABITE, RABITE2,
        QUEST003_TASK002,
        FIRE
    }

    public static final String PLAYER_WARRIOR_CONFIG = "scripts/player_warrior.json";

    private EntityFactory() {
        entities = new Hashtable<>();
    }

    public static EntityFactory getInstance() {
        if (instance == null) {
            instance = new EntityFactory();
        }

        return instance;
    }

    public Entity getEntity(EntityType entityType) {
        Entity entity;
        switch (entityType) {
            case WARRIOR -> {
                entity = new Entity(new PlayerInputComponent(), new PlayerPhysicsComponent(), new PlayerGraphicsComponent());
                entity.setEntityConfig(Entity.getEntityConfig(EntityFactory.PLAYER_WARRIOR_CONFIG));
                entity.sendMessage(Component.MESSAGE.LOAD_ANIMATIONS, json.toJson(entity.getEntityConfig()));
                return entity;
            }
            case PLAYER_DEMO -> {
                entity = new Entity(new NPCInputComponent(), new PlayerPhysicsComponent(), new PlayerGraphicsComponent());
                return entity;
            }
            case NPC, ENEMY -> {
                entity = new Entity(new NPCInputComponent(), new NPCPhysicsComponent(), new NPCGraphicsComponent());
                return entity;
            }
            default -> {
                return null;
            }
        }
    }

    public Entity getEntityByName(EntityName entityName) {
        EntityConfig config = new EntityConfig(entities.get(entityName.toString()));
        return Entity.initEntity(config);
    }

}


