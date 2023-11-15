package Interface.Components;


import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.image;


public class NPCComponent extends Component {
    private AnimatedTexture texture;
    private AnimationChannel channelIdleDown;
    private PhysicsComponent physics;
    public NPCComponent() {
        Image image = image("male_hurt.png");

        channelIdleDown = new AnimationChannel(image, 1, 64, 64, Duration.seconds(0.5), 0, 0);

        texture = new AnimatedTexture(channelIdleDown);

    }
    @Override
    public void onAdded() {
        // Adiciona a textura à visualização da entidade
        entity.getViewComponent().addChild(texture);

        // Obtém o componente de física da entidade
        physics = entity.getComponent(PhysicsComponent.class);
    }
}
