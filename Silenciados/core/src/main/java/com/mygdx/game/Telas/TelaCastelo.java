package com.mygdx.game.Telas;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Camera.CameraStyles;
import com.mygdx.game.Components.Systems.AnimationSystem;
import com.mygdx.game.Components.Systems.PlayerControllerSystem;
import com.mygdx.game.Entities.PlayerEntity;
import com.mygdx.game.Manejar.ManejarRecursos;
import com.mygdx.game.Mapas.FabricaDeMapa;
import com.mygdx.game.Mapas.ManejarMapa;
import com.mygdx.game.Mapas.Mapa;
import com.mygdx.game.Silenciados;

public class TelaCastelo extends TelaJogo{
    private Entity Player;
    private final World world;
    private final TiledMap map;
    private final Box2DDebugRenderer worldRenderer;

    public TelaCastelo(Silenciados app, ManejarRecursos manejarRecursos) {
        super(app, manejarRecursos);
        setupViewport(15, 15);
        world = manejarMapa.createWorld();
        worldRenderer = new Box2DDebugRenderer();
        manejarMapa.carregarMapa(FabricaDeMapa.MapType.CASTELO);

        map = manejarMapa.getMapaAtual();

        // Obtém o tamanho atual e configura a câmera principal
        camera = new OrthographicCamera();
        camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);

        manejarMapa.setCamera(camera);
        parseMap();

    }
    private void parseMap()
    {
        MapObjects collisions = map.getLayers().get("MAP_COLLISION_LAYER").getObjects();
        for (int i = 0; i < collisions.getCount(); i++)
        {
            MapObject mapObject = collisions.get(i);

            if (mapObject instanceof RectangleMapObject)
            {
                RectangleMapObject rectangleObject = (RectangleMapObject) mapObject;
                Rectangle rectangle = rectangleObject.getRectangle();

                BodyDef bodyDef = getBodyDef(rectangle.getX() + rectangle.getWidth() / 2f, rectangle.getY() + rectangle.getHeight() / 2f);
                bodyDef.position.set(new Vector2(1, 1));
                Body body = world.createBody(bodyDef);
                PolygonShape polygonShape = new PolygonShape();
                polygonShape.setAsBox(rectangle.getWidth() / 2f, rectangle.getHeight() / 2f);
                body.createFixture(polygonShape, 0.0f);
                polygonShape.dispose();
            }
            else if (mapObject instanceof EllipseMapObject)
            {
                EllipseMapObject circleMapObject = (EllipseMapObject) mapObject;
                Ellipse ellipse = circleMapObject.getEllipse();

                BodyDef bodyDef = getBodyDef(ellipse.x, ellipse.y);

                if (ellipse.width != ellipse.height)
                    throw new IllegalArgumentException("Only circles are allowed.");

                Body body = world.createBody(bodyDef);
                CircleShape circleShape = new CircleShape();
                circleShape.setRadius(ellipse.width / 2f);
                body.createFixture(circleShape, 0.0f);
                circleShape.dispose();
            }
            else if (mapObject instanceof PolygonMapObject)
            {
                PolygonMapObject polygonMapObject = (PolygonMapObject) mapObject;
                Polygon polygon = polygonMapObject.getPolygon();

                BodyDef bodyDef = getBodyDef(polygon.getX()*Mapa.UNIDADE_ESCALA, polygon.getY()*Mapa.UNIDADE_ESCALA);

                Body body = world.createBody(bodyDef);
                PolygonShape polygonShape = new PolygonShape();
                polygonShape.set(polygon.getVertices());
                body.createFixture(polygonShape, 0.0f);
                polygonShape.dispose();
            }
        }
    }

    private BodyDef getBodyDef(float x, float y)
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);

        return bodyDef;
    }
    @Override
    public void show() {
        // Inicializa o renderizador de mapa se ainda não estiver inicializado
        if (rendezirarMapa == null) {
            // Carrega o mapa do tipo CASTELO
            manejarMapa.carregarMapa(FabricaDeMapa.MapType.CASTELO);
            rendezirarMapa = new OrthogonalTiledMapRenderer(manejarMapa.getMapaAtual(), Mapa.UNIDADE_ESCALA);
        }

        Player = new PlayerEntity(manejarMapa.IniciarPlayer(), manejarMapa.getWorld());
        //gdxGame.engine.addEntity(Player);
        //gdxGame.engine.addSystem(new PlayerControllerSystem());
        //gdxGame.engine.addSystem(new AnimationSystem());
    }

    @Override
    public void render(float delta) {
        // Configuração do OpenGL para limpar o buffer de cores
        Gdx.gl.glClearColor(0, 0, 0, 1); // Cor preta para melhor contraste com o mapa
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Simplifica a atualização da câmera para centralizar no mapa
        camera.position.set(larguraLevel * ManejarRecursos.TAMANHO_BLOCO * Mapa.UNIDADE_ESCALA / 2,
                alturaLevel * ManejarRecursos.TAMANHO_BLOCO * Mapa.UNIDADE_ESCALA / 2,
                0f);
        worldRenderer.render(world, camera.combined);
        System.out.println(camera.position);
        camera.update();
        manejarMapa.getWorld().step(delta, 6,2);
        rendezirarMapa.setView(camera);
        // Configura o modo de mistura para lidar com transparência
        rendezirarMapa.getBatch().enableBlending();
        rendezirarMapa.getBatch().setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        // Verifica se o mapa foi alterado
        if (manejarMapa.mapaAlterado()) {
            // Atualiza o renderizador de mapa e a posição da câmera
            rendezirarMapa.setMap(manejarMapa.getMapaAtual());

            camera.position.set(manejarMapa.getPlayerStartUnitScaled().x, manejarMapa.getPlayerStartUnitScaled().y, 0f);

            camera.update();
            manejarMapa.setTrocaMapa(false);
        }
        // Renderiza o mapa
        rendezirarMapa.render();
        //gdxGame.engine.update(delta);

        // Configura as bordas da câmera para evitar que ultrapasse os limites do mapa
        inicioX = camera.viewportWidth / 2;
        inicioY = camera.viewportHeight / 2;
        larguraLevel = manejarMapa.getMapaAtual().getProperties().get("width", Integer.class);
        alturaLevel = manejarMapa.getMapaAtual().getProperties().get("height", Integer.class);
        fimX = larguraLevel * ManejarRecursos.TAMANHO_BLOCO * Mapa.UNIDADE_ESCALA - inicioX * 2;
        fimY = alturaLevel * ManejarRecursos.TAMANHO_BLOCO * Mapa.UNIDADE_ESCALA - inicioY * 2;
        CameraStyles.boundaries(camera, inicioX, inicioY, fimX, fimY);
    }
}
