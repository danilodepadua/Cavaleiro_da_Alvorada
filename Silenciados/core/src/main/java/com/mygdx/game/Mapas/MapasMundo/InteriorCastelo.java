package com.mygdx.game.Mapas.MapasMundo;


import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Mapas.FabricaDeMapa;
import com.mygdx.game.Mapas.Mapa;

public class InteriorCastelo extends Mapa {

    private static String mapPath = "asset/map/InternoCastelo.tmx";

    public InteriorCastelo(World world) {
        super(FabricaDeMapa.MapType.CASTELO_INTERIOR, mapPath, world);

    }

}
