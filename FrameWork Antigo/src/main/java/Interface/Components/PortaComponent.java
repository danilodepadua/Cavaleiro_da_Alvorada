package Interface.Components;

import Interface.EntityType;
import Interface.GameMap;
import PrimeiraCamada.Personagens.Player;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.input.MouseButton;

import static Interface.Gameplay.enterPortal;

public class PortaComponent extends Component {
    private String nomeMapa;
    private double positionX;
    private double positionY;

    public PortaComponent(String nomeMapa, double positionX, double positionY) {
        this.nomeMapa = nomeMapa;
        this.positionX = positionX;
        this.positionY = positionY;

    }

    @Override
    public void onAdded() {
        // Adicione um manipulador de colisões para lidar com colisões entre o jogador e a porta
        FXGL.onCollisionBegin(EntityType.PLAYER, EntityType.PORTA, this::handleCollision);
    }

    private void handleCollision(Entity player, Entity porta) {
        // Chame o método para trocar de mapa diretamente
        enterPortal(nomeMapa, positionX, positionY);
    }


}
