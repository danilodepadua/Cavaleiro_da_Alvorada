package com.mygdx.game.Mapas;

import com.mygdx.game.Mapas.MapasMundo.Castelo;
import com.mygdx.game.Mapas.MapasMundo.InteriorCastelo;
import com.mygdx.game.Mapas.MapasMundo.Mansao;

import java.util.Hashtable;

public class FabricaDeMapa {
    private static Hashtable<MapType, Mapa> mapTable = new Hashtable<>();

    public enum MapType {
        CASTELO,
        MANSAO,
        CASTELO_INTERIOR
    }

    public static Hashtable<MapType, Mapa> getMapTable() {
        return mapTable;
    }

    public static Mapa getMap(MapType mapType) {
        Mapa map = null;
        switch(mapType) {
            case CASTELO:
                map = mapTable.get(MapType.CASTELO);
                if (map == null) {
                    map = new Castelo();
                    mapTable.put(MapType.CASTELO, map);
                }
                break;
            case MANSAO:
                map = mapTable.get(MapType.MANSAO);
                if (map == null) {
                    map = new Mansao();
                    mapTable.put(MapType.MANSAO, map);
                }
                break;
            case CASTELO_INTERIOR:
                map = mapTable.get(MapType.CASTELO_INTERIOR);
                if (map == null) {
                    map = new InteriorCastelo();
                    mapTable.put(MapType.CASTELO_INTERIOR, map);
                }

            default:
                break;
        }
        return map;
    }

    public static void clearCache() {
        for(Mapa map: mapTable.values()) {
            map.dispose();
        }
        mapTable.clear();
    }
}
