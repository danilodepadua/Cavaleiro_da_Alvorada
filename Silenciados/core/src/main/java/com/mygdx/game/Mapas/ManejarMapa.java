package com.mygdx.game.Mapas;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Components.ColliderComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mygdx.game.Mapas.Mapa.UNIDADE_ESCALA;

public class ManejarMapa {
    private static final Logger LOGGER = LoggerFactory.getLogger(ManejarMapa.class);
    private Camera camera;
    private boolean trocaMapa = false;
    private Mapa mapaAtual;
    private static float ppt = 0;
    private World world;

    public ManejarMapa() {
        // Nada
    }

    public void carregarMapa(FabricaDeMapa.MapType mapType) {
        // Obtém o mapa do tipo especificado
        Mapa mapa = FabricaDeMapa.getMap(mapType, getWorld());

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
    public TiledMap getMapaAtual() {
        return mapaAtual.getMapaAtual();
    }

    public Vector2 IniciarPlayer(){
        return mapaAtual.getIniciarPlayer();
    }
    public boolean mapaAlterado() {
        return trocaMapa;
    }
    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    public Vector2 getPlayerStartUnitScaled() {
        return mapaAtual.getPlayerStartUnitScaled();
    }
    public void setTrocaMapa(boolean trocaMapa) {
        this.trocaMapa = trocaMapa;
    }
    public World createWorld() {
        world = new World(new Vector2(0, 0), true);
        LOGGER.debug("Novo mundo Box2D criado: {}", world);
        return world;
    }

    public static Array<Body> buildShapes(float pixels, World world, ManejarMapa mpr) {
        ppt = pixels;
        MapLayer mapCollisionLayer = mpr.getCollisionLayer();

        Array<Body> bodies = new Array<Body>();

        for (MapObject object : mapCollisionLayer.getObjects()) {
            if (object instanceof TextureMapObject) {
                continue;
            }

            BodyDef bd = new BodyDef();
            bd.type = BodyDef.BodyType.StaticBody;

            Shape shape = null;

            if (object instanceof RectangleMapObject) {
                shape = getRectangle((RectangleMapObject) object);
            } else if (object instanceof PolygonMapObject) {
                shape = getPolygon((PolygonMapObject) object);
            } else if (object instanceof PolylineMapObject) {
                shape = getPolyline((PolylineMapObject) object);
            }

            bd.position.set(shape.getRadius(), shape.getRadius()); // Defina a posição conforme necessário

            Body body = world.createBody(bd);
            body.createFixture(shape, 0.0f);

            // Adiciona um listener de contato
            body.setUserData("collision");
            body.getFixtureList().first().setUserData("collision");

            bodies.add(body);

            shape.dispose();
        }

        return bodies;
    }

    private static PolygonShape getRectangle(RectangleMapObject rectangleObject) {
        Rectangle rectangle = rectangleObject.getRectangle();
        PolygonShape polygon = new PolygonShape();
        Vector2 size = new Vector2((rectangle.x + rectangle.width * 0.5f) / ppt,
                (rectangle.y + rectangle.height * 0.5f) / ppt);
        polygon.setAsBox(rectangle.width * 0.5f / ppt,
                rectangle.height * 0.5f / ppt,
                size,
                0.0f);
        return polygon;
    }

    private static PolygonShape getPolygon(PolygonMapObject polygonObject) {
        PolygonShape polygon = new PolygonShape();
        float[] vertices = polygonObject.getPolygon().getTransformedVertices();
        float[] worldVertices = new float[vertices.length];

        for (int i = 0; i < vertices.length; ++i) {
            System.out.println(vertices[i]);
            worldVertices[i] = vertices[i] / ppt;
        }

        polygon.set(worldVertices);
        return polygon;
    }

    private static ChainShape getPolyline(PolylineMapObject polylineObject) {
        float[] vertices = polylineObject.getPolyline().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i = 0; i < vertices.length / 2; ++i) {
            worldVertices[i] = new Vector2();
            worldVertices[i].x = vertices[i * 2] / ppt;
            worldVertices[i].y = vertices[i * 2 + 1] / ppt;
        }

        ChainShape chain = new ChainShape();
        chain.createChain(worldVertices);
        return chain;
    }


    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}

