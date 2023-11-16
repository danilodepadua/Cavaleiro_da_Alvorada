package Interface.Components;

import Interface.GameMap;
import PrimeiraCamada.Personagens.Player;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.input.MouseButton;

import static Interface.Gameplay.enterPortal;
import static Interface.Gameplay.showAlert;

public class PortaComponent extends Component {
    private String nomeMapa;
    private String alerta;
    private double positionX;
    private double positionY;

    public PortaComponent(String nomeMapa, String alerta, double positionX, double positionY) {
        this.nomeMapa = nomeMapa;
        this.alerta = alerta;
        this.positionX = positionX;
        this.positionY = positionY;

    }

    @Override
    public void onAdded() {
        entity.getViewComponent().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            // Verificar se o botão do mouse foi clicado
            if (e.getButton() == MouseButton.PRIMARY) {

                // Obter as coordenadas do jogador
                GameMap.getPlayer().getComponent(PlayerComponent.class).interact();
                showAlert(nomeMapa, alerta , positionX, positionY);
                // Em seguida, chame o método para entrar no portal
            }
        });
    }


}
