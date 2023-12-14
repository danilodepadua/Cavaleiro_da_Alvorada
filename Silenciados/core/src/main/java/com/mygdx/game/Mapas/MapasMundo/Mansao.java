package com.mygdx.game.Mapas.MapasMundo;


import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Mapas.FabricaDeMapa;
import com.mygdx.game.Mapas.Mapa;

public class Mansao extends Mapa {

    private static String mapPath = "asset/map/Mansao.tmx";

    public Mansao(World world) {
        super(FabricaDeMapa.MapType.MANSAO, mapPath, world);
    }

}
