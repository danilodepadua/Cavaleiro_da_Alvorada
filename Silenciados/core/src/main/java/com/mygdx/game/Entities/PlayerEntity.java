package com.mygdx.game.Entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Components.*;
import com.mygdx.game.Mapas.FabricaDeMapa;
import com.mygdx.game.Mapas.ManejarMapa;
import com.mygdx.game.Mapas.Mapa;
import com.mygdx.game.Utilities.AnimationMaker;

public class PlayerEntity extends Entity {
    public PlayerEntity(Vector2 vec, World world){
        Array<Animation<TextureRegion>> Animations = new Array<>();
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_down idle.png"), 2,4, 5));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_down walk.png"), 2,4, 6));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_up idle.png"), 2,4, 5));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_up walk.png"), 2,4, 6));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_side idle.png"), 2,4, 5));
        Animations.add(AnimationMaker.MakeAnim(0.125f, new Texture("asset/map/Player/_side walk.png"), 2,4, 6));
        add(new EntityType(EntityType.Types.Player));
        add(new TransformComponent(vec, 2.5f));
        add(new MovementComponent(100));
        add(new GraphicsComponent());
        add(new AnimationComponent(Animations));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(16* Mapa.UNIDADE_ESCALA,32*Mapa.UNIDADE_ESCALA);
        add(new ColliderComponent(10,0,shape, BodyDef.BodyType.DynamicBody,vec, world));
        System.out.println("Fui Criado");
        System.out.println("Posicão: x = " + this.getComponent(TransformComponent.class).position.x + ", Y = " + this.getComponent(TransformComponent.class).position.y);
    }



}
