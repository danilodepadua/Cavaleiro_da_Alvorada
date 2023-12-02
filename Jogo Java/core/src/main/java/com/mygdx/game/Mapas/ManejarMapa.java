package com.mygdx.game.Mapas;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManejarMapa {
    private static final Logger LOGGER = LoggerFactory.getLogger(ManejarMapa.class);
    private Camera camera;
    private boolean trocaMapa = false;
    private Mapa mapaAtual;

    public ManejarMapa() {
        // Nada
    }

    public void carregarMapa(FabricaDeMapa.MapType mapType) {
        // Obtém o mapa do tipo especificado
        Mapa mapa = FabricaDeMapa.getMap(mapType);

        // Verifica se o mapa existe
        if (mapa == null) {
            LOGGER.debug("Mapa não existe");
            return;
        }

        // Define o novo mapa como o mapa atual
        mapaAtual = mapa;
        // Indica que o mapa foi alterado
        trocaMapa = true;
        // Limpa a entidade de mapa atualmente selecionada
        LOGGER.debug("Iniciar Player: ({},{})", mapaAtual.getIniciarPlayer().x, mapaAtual.getIniciarPlayer().y);
    }
    public MapLayer getCollisionLayer() {
        return mapaAtual.getCollisionLayer();
    }

    public MapLayer getPortalLayer() {
        return mapaAtual.getPortalLayer();
    }
    public TiledMap getAtualMapaTiled() {
        if (mapaAtual == null) {
            carregarMapa(FabricaDeMapa.MapType.MANSAO);
        }
        return mapaAtual.getMapaAtual();
    }

    public boolean mapaAlterado() {
        return trocaMapa;
    }
    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    public Camera getCamera() {
        return camera;
    }
    public void setClosestStartPositionFromScaledUnits(Vector2 position) {
        mapaAtual.setClosestStartPositionFromScaledUnits(position);
    }
    public Vector2 getPlayerStartUnitScaled() {
        return mapaAtual.getPlayerStartUnitScaled();
    }
    public void setTrocaMapa(boolean trocaMapa) {
        this.trocaMapa = trocaMapa;
    }
}
