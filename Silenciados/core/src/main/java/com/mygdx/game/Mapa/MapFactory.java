package com.mygdx.game.Mapa;
import com.mygdx.game.Mapa.MapasMundo.Castelo;
import com.mygdx.game.Mapa.MapasMundo.InteriorCastelo;
import com.mygdx.game.Mapa.MapasMundo.Mansao;


import java.util.Hashtable;


public class MapFactory {
    //All maps for the game
    private static Hashtable<MapType, Map> mapTable = new Hashtable<>();

    public enum MapType {
        CASTELO,
        MANSAO,
        CASTELO_INTERIOR
    }

    public static Hashtable<MapType, Map> getMapTable() {
        return mapTable;
    }

    public static Map getMap(MapType mapType) {
        Map map = null;
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
        for(Map map: mapTable.values()) {
            map.dispose();
        }
        mapTable.clear();
    }
}