package Interface.Components;

import Interface.EntityType;
import Interface.SilenciadosApp;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public class InvisibleObjectComponent extends Component {

    @Override
    public void onAdded() {
        entity.getViewComponent().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            // Verifica se o jogador está colidindo com o objeto invisível
            Entity player = FXGL.getGameWorld().getSingleton(EntityType.PLAYER); // ou substitua pelo nome da entidade do jogador
            if (player.isColliding(entity)) {
                // Carrega o novo mapa da classe principal
                ((SilenciadosApp) FXGL.getApp()).changeMap("level1.tmx");
                System.out.println("Colliding with invisivel!");
            }
        });
    }
}
