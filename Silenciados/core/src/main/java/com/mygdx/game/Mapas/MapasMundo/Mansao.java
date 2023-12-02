package com.mygdx.game.Mapas.MapasMundo;


import com.mygdx.game.Mapas.FabricaDeMapa;
import com.mygdx.game.Mapas.Mapa;

public class Mansao extends Mapa {

    private static String mapPath = "asset/map/Mansao.tmx";

    public Mansao() {
        super(FabricaDeMapa.MapType.MANSAO, mapPath);
    }

}
