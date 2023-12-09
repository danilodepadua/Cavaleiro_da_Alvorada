package com.mygdx.game.Components;

import com.badlogic.ashley.core.ComponentMapper;

public class ComponentMappers {
    public static final ComponentMapper<EntityType> Types = ComponentMapper.getFor(EntityType.class);
    public static final ComponentMapper<TransformComponent> Transforms = ComponentMapper.getFor(TransformComponent.class);
    public static final ComponentMapper<GraphicsComponent> Graphcs = ComponentMapper.getFor(GraphicsComponent.class);
    public static final ComponentMapper<MovementComponent> Movements = ComponentMapper.getFor(MovementComponent.class);
    public static final ComponentMapper<AnimationComponent> Animation = ComponentMapper.getFor(AnimationComponent.class);
    public static final ComponentMapper<ColliderComponent> Colliders = ComponentMapper.getFor(ColliderComponent.class);
}
