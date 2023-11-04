package Interface;

import Interface.Components.InvisibleObjectComponent;
import Interface.Components.PlayerComponent;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;

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

        // Obtenha as dimensões do objeto a partir dos dados do SpawnData
        //int width = data.get("width");
        //int height = data.get("height");

        Entity platform = entityBuilder(data)
                .type(EntityType.PLATFORM)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height")))) //pega os dados de objeto do tmx
                //viewWithBBox(new Rectangle(width, height, Color.BLUE)) botar uma area azul para colisão
                .with(physics)
                .build();

        return platform;
    }
    @Spawns("arvore")
    public Entity newArvore(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);

        int width = data.get("width");
        int height = data.get("height");

        return entityBuilder(data)
                .type(EntityType.ARVORE)
                .with(new InvisibleObjectComponent())  // Certifique-se de que esta linha está presente
                .viewWithBBox(new Rectangle(width, height, Color.TRANSPARENT))
                .with(new CollidableComponent(true))
                .with(physics)
                .build();
    }

    @Spawns("objetoInvisivel")
    public Entity novoObjetoInvisivel(SpawnData data) {
        // Crie uma instância de SilenciadosApp
        SilenciadosApp app = (SilenciadosApp) FXGL.getApp();

        return entityBuilder(data)
                .type(EntityType.OBJETO_INVISIVEL)
                .viewWithBBox(new Rectangle(50, 50, Color.BLUE))
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
                .bbox(new HitBox(BoundingShape.box(32, 32)))
                .with(physics)
                .with(new PlayerComponent())
                .buildAndAttach();

        return player;
    }
}
