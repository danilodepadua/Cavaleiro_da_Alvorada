package Interface;

import Interface.Components.NPCComponent;
import Interface.Components.PlayerComponent;
import Interface.Components.PortaComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import static com.almasb.fxgl.dsl.FXGL.entityBuilder;


public class SilenciadosFactory implements EntityFactory {

    //Colocando uma imagem de fundo
//    @Spawns("background")
//    public Entity newBackground(SpawnData data) {
//        return FXGL.entityBuilder()
//                .view(new ScrollingBackgroundView(texture("background/fundinho.png").getImage(), getAppWidth(), getAppHeight()))
//                .zIndex(-1)
//                .with(new IrremovableComponent())
//                .build();
//    }


    @Spawns("platform")
    public Entity newPlatform(SpawnData data) {

        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);


        Entity platform = entityBuilder(data)
                .type(EntityType.PLATFORM)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height")))) //pega os dados de objeto do tmx
                .with(physics)
                .build();

        return platform;
    }
    @Spawns("porta1")
    public Entity newPortal(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);

        int width = data.get("width");
        int height = data.get("height");

        return entityBuilder(data)
                .type(EntityType.PORTA)
                .viewWithBBox(new Rectangle(width, height, Color.TRANSPARENT))
                .with(new CollidableComponent(true))
                .with(new PortaComponent("Mansao", 610, 450))
                .with(physics)
                .build();
    }
    @Spawns("arvore")
    public Entity newArvore(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);

        int width = data.get("width");
        int height = data.get("height");

        return entityBuilder(data)
                .type(EntityType.ARVORE)
                .viewWithBBox(new Rectangle(width, height, Color.TRANSPARENT))
                .with(new CollidableComponent(true))
                .with(physics)
                .build();
    }

    @Spawns("objetoInvisivel")
    public Entity novoObjetoInvisivel(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);

        return entityBuilder(data)
                .type(EntityType.OBJETO_INVISIVEL)
                .viewWithBBox(new Rectangle(50, 50, Color.BLUE))
                .collidable()
                .with(physics)
                .build();
    }
    @Spawns("cadeira")
        public Entity novaCadeira(SpawnData data){
            return entityBuilder(data)
                    .type(EntityType.OBJETO_INVISIVEL)
                    .viewWithBBox(new Rectangle(50, 50, Color.RED))
                    .build();
    }

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        physics.setOnPhysicsInitialized(() -> physics.getBody().setGravityScale(0));

        Entity player = entityBuilder(data)
                .type(EntityType.PLAYER)
                .collidable()
                .bbox(new HitBox(new Point2D(24,48),BoundingShape.box(16, 16)))
                .with(physics)
                .with(new PlayerComponent())
                .buildAndAttach();
        return player;
    }

    @Spawns("porta")
    public Entity newPorta(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);

        int width = data.get("width");
        int height = data.get("height");

        return entityBuilder(data)
                .type(EntityType.PORTA)
                .viewWithBBox(new Rectangle(width, height, Color.BLUE))
                .with(new CollidableComponent(true))
                .with(physics)
                .with(new PortaComponent("Castelo2", 620, 650))
                .build();
    }

    @Spawns("NPC")
    public Entity newNpc(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);

        return entityBuilder(data)
                .type(EntityType.NPC)
                .bbox(new HitBox(new Point2D(24,48),BoundingShape.box(16, 16)))
                .collidable()
                .with(physics)
                .with(new NPCComponent())
                .buildAndAttach();

    }

}
