package com.mygdx.game.Mapa.MapasMundo;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.Components.Component;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.EntityConfig;
import com.mygdx.game.Entities.EntityFactory;
import com.mygdx.game.Mapa.Map;
import com.mygdx.game.Mapa.MapFactory;
import com.mygdx.game.Profile.ProfileManager;
import com.mygdx.game.audio.AudioObserver;

import static com.mygdx.game.audio.AudioObserver.AudioTypeEvent.TOPPLE_THEME;

public class Castelo extends Map {

    private static String mapPath = "asset/map/Castelo2.tmx";
    private Json json;

    public Castelo() {
        super(MapFactory.MapType.CASTELO, mapPath);

        json = new Json();

    }

    @Override
    public AudioObserver.AudioTypeEvent getMusicTheme() {
        return TOPPLE_THEME;
    }

    @Override
    public void unloadMusic() {
        notify(AudioObserver.AudioCommand.MUSIC_STOP, getMusicTheme());
    }

    @Override
    public void loadMusic() {
        notify(AudioObserver.AudioCommand.MUSIC_LOAD, getMusicTheme());
        notify(AudioObserver.AudioCommand.MUSIC_PLAY_LOOP, getMusicTheme());
    }

    private void initSpecialEntityPosition(Entity entity) {
        Vector2 position = new Vector2(0,0);

        if (specialNPCStartPositions.containsKey(entity.getEntityConfig().getEntityID())) {
            position = specialNPCStartPositions.get(entity.getEntityConfig().getEntityID());
        }
        entity.sendMessage(Component.MESSAGE.INIT_START_POSITION, json.toJson(position));

        //Overwrite default if special config is found
        EntityConfig entityConfig = ProfileManager.getInstance().getProperty(entity.getEntityConfig().getEntityID(), EntityConfig.class);
        if (entityConfig != null ) {
            entity.setEntityConfig(entityConfig);
        }
    }
}
