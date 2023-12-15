package com.mygdx.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Components.Systems.RenderingSystem;

public class ColliderComponent implements Component {
    public Body body;
    public ColliderComponent(float Densidade, float Atrito, PolygonShape shape, BodyDef.BodyType type, Vector2 pos, World world){
        BodyDef bodydef = new BodyDef();
        bodydef.type = type;
        bodydef.position.set(pos);
        body = world.createBody(bodydef);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = Densidade;
        fixtureDef.friction = Atrito;
        body.createFixture(fixtureDef);
        shape.dispose();
    }
}
