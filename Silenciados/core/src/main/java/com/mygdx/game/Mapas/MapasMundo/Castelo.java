package com.mygdx.game.Mapas.MapasMundo;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Mapas.FabricaDeMapa;
import com.mygdx.game.Mapas.Mapa;

public class Castelo extends Mapa {

    private static String mapPath = "asset/map/Castelo2.tmx";

    public Castelo(World world) {
        super(FabricaDeMapa.MapType.CASTELO, mapPath, world);
    }
}
